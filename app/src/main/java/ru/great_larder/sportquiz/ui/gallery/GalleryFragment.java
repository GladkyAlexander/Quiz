package ru.great_larder.sportquiz.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.FairiesDatabaseAdapterSQLite;
import ru.great_larder.sportquiz.databinding.FragmentGalleryBinding;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.DoubleClickListener;
import ru.great_larder.sportquiz.services.GetNamesVictik;
import ru.great_larder.sportquiz.services.fairies.GetFairies;
import ru.great_larder.sportquiz.services.fairies.GetFairiesImpl;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

import java.util.Date;
import java.util.List;

public class GalleryFragment extends Fragment implements ObserverUser {
    
    private FragmentGalleryBinding binding;
    private TextView textViewNameGalleryFragment, textViewFairiesGreeting;
    private TextView textViewPointsGF, textViewPriceFairies, textViewHint, textViewPointsGalleryFragment;
    private ImageView img3, imgMax;
    private FrameLayout frameLayoutFairies;
    private Carousel carousel;
    int numImages;
    Fairies fairiesToInstall;
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
        adapterFairies = new FairiesDatabaseAdapterSQLite(this.requireActivity());
        userAdapter = new DatabaseAdapterUserSQLite(this.requireActivity());
        textViewNameGalleryFragment = binding.textViewNameGalleryFragment;
        textViewPointsGF = binding.textViewPointsGF;
        textViewFairiesGreeting = binding.textViewFairiesGreeting;
        textViewHint = binding.textViewHint;
        textViewPointsGalleryFragment = binding.textViewPointsGalleryFragment;
        carousel = binding.carousel;
        imgMax = binding.imgMax;
        textViewPriceFairies = binding.textViewPriceFairies;
        frameLayoutFairies = binding.frameLayoutFairies;
        img3 = binding.img3;
        Button button_patronage = binding.buttonPatronat;
        
        img3.setClickable(true);
        img3.setOnClickListener(new DoubleClickListener(){
            @Override
            public void onDoubleClick(View v) {
                super.onDoubleClick(v);
                openFairies((Fairies) img3.getTag());
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
        if(user != null) {
            textViewFairiesGreeting.setVisibility(View.VISIBLE);
            frameLayoutFairies.setVisibility(View.GONE);
            textViewNameGalleryFragment.setText(user.getName());
            textViewPointsGF.setText(String.valueOf(user.getGlasses()));
            textViewPointsGalleryFragment.setText(new GetNamesVictik().getVictik(user.getGlasses()));
           
        } else {
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
    private void openFairies(Fairies value){
        fairiesToInstall = value;
        frameLayoutFairies.setVisibility(View.VISIBLE);
        imgMax.setImageResource(value.getImageI());
        textViewPriceFairies.setText(String.valueOf(value.getPrice()));
    }
    @Override
    public void updateUser(DataUser dataUser) {
        loadFragment(dataUser.getUser());
    }
    
}