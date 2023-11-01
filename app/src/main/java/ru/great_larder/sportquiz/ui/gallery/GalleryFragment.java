package ru.great_larder.sportquiz.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.ForAPuzzleFragment;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.database.repository.get_live.ListPuzzlesLoad;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.FairiesDatabaseAdapterSQLite;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.PuzzleDatabaseAdapterSQLite;
import ru.great_larder.sportquiz.databinding.FragmentGalleryBinding;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.DoubleClickListener;
import ru.great_larder.sportquiz.services.GetNamesVictik;
import ru.great_larder.sportquiz.services.fairies.GetFairies;
import ru.great_larder.sportquiz.services.fairies.GetFairiesImpl;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;
import ru.great_larder.sportquiz.ui.for_a_corusel_of_puzzles.ForACarouselOfPuzzlesFragment;

import java.util.Date;
import java.util.List;

public class GalleryFragment extends Fragment implements ObserverUser {
    
    private FragmentGalleryBinding binding;
    private TextView textViewNameGalleryFragment, textViewPuzzleGreeting, textViewFairiesGretting;
    private TextView textViewPointsGF, textViewPriceFairies, textViewHint, textViewPointsGalleryFragment, outTest;
    private ImageView img3, imgMax;
    private FrameLayout frameLayoutFairies, frameLayoutPuzzleImage, imgPuzzle3;
    private Carousel carousel, carouselPuzzle;
    private MotionLayout motion, motionPuzzle;
    private Button button_patronage;
    int numImages;
    int getNumImagesPuzzle;
    Fairies fairiesToInstall;
    List<Puzzle> puzzles;
    PuzzleDatabaseAdapterSQLite adapterPuzzle;
    FairiesDatabaseAdapterSQLite adapterFairies;
    DatabaseAdapterUserSQLite userAdapter;
    
    @SuppressLint("DiscouragedApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GalleryViewModel.class);
        
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        GlobalLinkUser.getHandlerUserListener().registerObserverUser(this);
        adapterPuzzle = new PuzzleDatabaseAdapterSQLite(this.requireActivity());
        adapterFairies = new FairiesDatabaseAdapterSQLite(this.requireActivity());
        userAdapter = new DatabaseAdapterUserSQLite(this.requireActivity());
        textViewNameGalleryFragment = binding.textViewNameGalleryFragment;
        textViewPointsGF = binding.textViewPointsGF;
        textViewPuzzleGreeting = binding.textViewPuzzleGreeting;
        textViewFairiesGretting = binding.textViewFairiesGreeting;
        textViewHint = binding.textViewHint;
        textViewPointsGalleryFragment = binding.textViewPointsGalleryFragment;
        
        outTest = binding.outTest;
        
        carousel = binding.carousel;
        motion = binding.motion;
        imgMax = binding.imgMax;
        textViewPriceFairies = binding.textViewPriceFairies;
        frameLayoutFairies = binding.frameLayoutFairies;
        img3 = binding.img3;
        button_patronage = binding.buttonPatronat;
        
        carouselPuzzle = binding.carouselPazl;
        motionPuzzle = binding.motionPazl;
        frameLayoutPuzzleImage = binding.frameLayoutPazl;
        imgPuzzle3 = binding.imgPazl3;
        
        img3.setClickable(true);
        img3.setOnClickListener(new DoubleClickListener(){
            @Override
            public void onDoubleClick(View v) {
                super.onDoubleClick(v);
                openFairies((Fairies) img3.getTag());
            }
        });

        imgPuzzle3.setClickable(true);
        imgPuzzle3.setOnClickListener(new DoubleClickListener(){
            @Override
            public void onDoubleClick(View v) {
                super.onDoubleClick(v);
                openPuzzle((Puzzle) imgPuzzle3.getTag());
            }
        });
        
        loadFragment(GlobalLinkUser.getUser());
        
        button_patronage.setOnClickListener(m -> {
            if(GlobalLinkUser.getUser() != null) {
                if (GlobalLinkUser.getUser().getGlasses() >= fairiesToInstall.getPrice()) {
                    fairiesToInstall.setActivity_fairies(1);
                    fairiesToInstall.setDateStart(new Date());
                    Fairies g;
                    adapterFairies.open();
                    g = adapterFairies.getFairiesByActive();
                    adapterFairies.close();
                    if (g != null) {
                        g.setActivity_fairies(0);
                        adapterFairies.open();
                        adapterFairies.update(g);
                        adapterFairies.close();
                    }
                    adapterFairies.open();
                    adapterFairies.update(fairiesToInstall);
                    adapterFairies.close();
                    User user = GlobalLinkUser.getUser();
                    user.setGlasses(user.getGlasses() - fairiesToInstall.getPrice());
                    userAdapter.open();
                    userAdapter.update(user);
                    userAdapter.close();
                    GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
                } else Toast.makeText(requireActivity(), "Не достаточно Виктиков!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
            }
        });
        
        return root;
    }
    public void loadFragment(User user) {
        textViewHint.setVisibility(View.VISIBLE);
        setupCarousel();
        if(GlobalLinkUser.getUser() != null) {
            motionPuzzle.setVisibility(View.VISIBLE);
            textViewPuzzleGreeting.setVisibility(View.VISIBLE);
            motion.setVisibility(View.VISIBLE);
            textViewFairiesGretting.setVisibility(View.VISIBLE);
            frameLayoutFairies.setVisibility(View.GONE);
            frameLayoutPuzzleImage.setVisibility(View.GONE);
            
            textViewNameGalleryFragment.setText(user.getName());
            textViewPointsGF.setText(String.valueOf(user.getGlasses()));
            textViewPointsGalleryFragment.setText(new GetNamesVictik().getVictik(user.getGlasses()));
            /*adapterPuzzle.open();
            puzzles = adapterPuzzle.getPuzzles();
            adapterPuzzle.close();*/
            puzzles = ListPuzzlesLoad.getPuzzles();
            setupCarouselPuzzle();
        } else {
            motionPuzzle.setVisibility(View.GONE);
            textViewPuzzleGreeting.setVisibility(View.GONE);
            textViewNameGalleryFragment.setText("");
            textViewPointsGF.setText(String.valueOf(0));
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setupCarousel() {
        GetFairies getFairies = new GetFairiesImpl();
        List<Fairies> listSource = getFairies.getListFairies();
        
        if (carousel == null) {
            return;
        }
        numImages = listSource.size();
        carousel.setAdapter(new Carousel.Adapter() {
            @Override
            public int count() {
                return numImages;
            }
            
            @Override
            public void populate(View view, int index) {
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    imageView.setImageResource(listSource.get(index).getImageI());
                    imageView.setTag(listSource.get(index));
                }
            }
            
            @Override
            public void onNewItem(int index) {
            }
        });
    }
    private void setupCarouselPuzzle() {
        textViewPuzzleGreeting.setVisibility(View.GONE);
            if (puzzles != null && !puzzles.isEmpty()) {
                textViewPuzzleGreeting.setVisibility(View.VISIBLE);
                getNumImagesPuzzle = puzzles.size();
                carouselPuzzle.setAdapter(new Carousel.Adapter() {
                    @Override
                    public int count() {
                        return getNumImagesPuzzle;
                    }
                    
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void populate(View view, int index) {
                        if (view instanceof FrameLayout) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            Bundle bundle = new Bundle();
                            bundle.putInt("idPuzzle", puzzles.get(index).getId());
                            ForACarouselOfPuzzlesFragment forACarouselOfPuzzlesFragment = new ForACarouselOfPuzzlesFragment();
                            forACarouselOfPuzzlesFragment.setArguments(bundle);
                            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                            transaction.replace(frameLayout.getId(), forACarouselOfPuzzlesFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                            frameLayout.setTag(puzzles.get(index));
                        }
                    }
                    @Override
                    public void onNewItem(int index) {
                    }
                    
                });
            }
            
    }
    private void openFairies(Fairies value){
        fairiesToInstall = value;
        motionPuzzle.setVisibility(View.GONE);
        textViewPuzzleGreeting.setVisibility(View.GONE);
        frameLayoutFairies.setVisibility(View.VISIBLE);
        imgMax.setImageResource(value.getImageI());
        textViewPriceFairies.setText(String.valueOf(value.getPrice()));
    }
    private void openPuzzle(Puzzle val){
        textViewHint.setVisibility(View.GONE);
        motion.setVisibility(View.GONE);
        motionPuzzle.setVisibility(View.GONE);
        textViewPuzzleGreeting.setVisibility(View.GONE);
        textViewFairiesGretting.setVisibility(View.GONE);
        frameLayoutPuzzleImage.setVisibility(View.VISIBLE);
        
        ForAPuzzleFragment forAPuzzleFragment = new ForAPuzzleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("getPuzzleId", val.getId());
        forAPuzzleFragment.setArguments(bundle);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(frameLayoutPuzzleImage.getId(), forAPuzzleFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void updateUser(DataUser dataUser) {
        loadFragment(dataUser.getUser());
    }
    
}