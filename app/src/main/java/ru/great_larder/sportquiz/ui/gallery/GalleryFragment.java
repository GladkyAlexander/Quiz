package ru.great_larder.sportquiz.ui.gallery;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.*;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.database.DatabaseAdapterFon;
import ru.great_larder.sportquiz.databinding.FragmentGalleryBinding;
import ru.great_larder.sportquiz.domain.Fon;
import ru.great_larder.sportquiz.domain.FonItem;
import ru.great_larder.sportquiz.domain.User;

import java.util.*;

public class GalleryFragment extends Fragment {
    
    private FragmentGalleryBinding binding;
    private TextView textViewNameGalleryFragment, textViewPointsGF, textViewFon1, textViewFon2, textViewFon3
        , textViewFon4, textViewFon5, textViewFon6, textViewFon7, textViewFon8, textViewFon9;
    private ImageView imageViewFon1, imageViewFon2, imageViewFon3, imageViewFon4, imageViewFon5, imageViewFon6
        ,imageViewFon7, imageViewFon8, imageViewFon9;
    private LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9;
    DialogFragment dialogFragment;
    Integer i = 0;
    List<FonItem> fonItemList = new ArrayList<>();
    @SuppressLint("DiscouragedApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GalleryViewModel.class);
        
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        textViewNameGalleryFragment = binding.textViewNameGalleryFragment;
        textViewPointsGF = binding.textViewPointsGF;
        
        fonItemList.add(new FonItem(ll1 = binding.ll1, textViewFon1 = binding.textViewFon1, imageViewFon1 = binding.imageViewFon1));
        fonItemList.add(new FonItem(ll2 = binding.ll2, textViewFon2 = binding.textViewFon2, imageViewFon2 = binding.imageViewFon2));
        fonItemList.add(new FonItem(ll3 = binding.ll3, textViewFon3 = binding.textViewFon3, imageViewFon3 = binding.imageViewFon3));
        fonItemList.add(new FonItem(ll4 = binding.ll4, textViewFon4 = binding.textViewFon4, imageViewFon4 = binding.imageViewFon4));
        fonItemList.add(new FonItem(ll5 = binding.ll5, textViewFon5 = binding.textViewFon5, imageViewFon5 = binding.imageViewFon5));
        fonItemList.add(new FonItem(ll6 = binding.ll6, textViewFon6 = binding.textViewFon6, imageViewFon6 = binding.imageViewFon6));
        fonItemList.add(new FonItem(ll7 = binding.ll7, textViewFon7 = binding.textViewFon7, imageViewFon7 = binding.imageViewFon7));
        fonItemList.add(new FonItem(ll8 = binding.ll8, textViewFon8 = binding.textViewFon8, imageViewFon8 = binding.imageViewFon8));
        fonItemList.add(new FonItem(ll9 = binding.ll9, textViewFon9 = binding.textViewFon9, imageViewFon9 = binding.imageViewFon9));
        
        if(GlobalLinkUser.getUser() != null){
            loadFragment(GlobalLinkUser.getUser());
        }
        dialogFragment = new FragmentDialogBuy();
        
        return root;
    }
    private void openDialog(Fon fo){
        /*DatabaseAdapterFon databaseAdapterFon = new DatabaseAdapterFon(requireActivity());
        databaseAdapterFon.open();
        fo.setId(databaseAdapterFon.insert(fo));
        databaseAdapterFon.close();
        
        User u = GlobalLinkUser.getUser();
        u.setGlasses(u.getGlasses() - fo.getPrice());
        List<Fon> lf = u.getFonList();
        lf.add(fo);
        u.setFonList(lf);
        
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(requireActivity());
        databaseAdapter.open();
        databaseAdapter.update(u);
        GlobalLinkUser.setUser(databaseAdapter.getUserById(u.getId()));
        databaseAdapter.close();
        
        DatabaseAdapterFon adapterFon = new DatabaseAdapterFon(requireActivity());
        adapterFon.open();
        List<Fon> fonList = new ArrayList<>(adapterFon.getBackgrounds((int) GlobalLinkUser.getUser().getId()));
        adapterFon.close();
        
        List<Fon> fonUser = new ArrayList<>();
        for(Fon f : fonList){
            if(Objects.equals(GlobalLinkUser.getUser().getId(), f.getAffiliation())){
                fonUser.add(f);
            }
        }
        GlobalLinkUser.getUser().setFonList(fonUser);
        loadFragment(GlobalLinkUser.getUser());*/
        
        Bundle args = new Bundle();
        args.putInt("numberImage", fo.getImageI());
        args.putInt("idFon", fo.getId());
        dialogFragment.setArguments(args);
        
        dialogFragment.show(getChildFragmentManager(), "dlg 1");
    }
    
    public void loadFragment(User user) {
        
        textViewNameGalleryFragment.setText(user.getName());
        textViewPointsGF.setText(String.valueOf(user.getGlasses()));
        
        GetFon getFon = new GetFonImpl();
        List<Fon> fonList = getFon.getListFon();

        for (FonItem fi : fonItemList){
            fi.getTextView().setText(String.valueOf(fonList.get(i).getPrice()));
            fi.getImageView().setImageResource(fonList.get(i).getImageI());
            
            if(fonList.get(i).getPrice() > user.getGlasses()){
                ImageViewCompat.setImageTintMode(fi.getImageView(), PorterDuff.Mode.SRC_ATOP);
                ImageViewCompat.setImageTintList(fi.getImageView(), ColorStateList.valueOf(Color.parseColor("#80000000")));
            }
            
            fi.getImageView().setOnClickListener(r->{
                Fon fon = new Fon();
                fon.setId(fonList.get(i).getId());
                fon.setName(fi.getImageView().getTransitionName());
                fon.setPrice(Integer.parseInt((String) fi.getTextView().getText()));
                fon.setAffiliation((int) GlobalLinkUser.getUser().getId());
                fon.setImageI(fi.getImageView().getId());
                if(Integer.parseInt((String) textViewPointsGF.getText()) >= Integer.parseInt((String) fi.getTextView().getText())){
                    openDialog(fon);
                }
            });
            
            /*if(!user.getFonList().isEmpty()){
                for (Fon g : user.getFonList()) {
                    if (g.getPrice() == fonList.get(i).getPrice()) {
                        ImageViewCompat.setImageTintList(fi.getImageView(), null);
                    } else {
                        ImageViewCompat.setImageTintMode(fi.getImageView(), PorterDuff.Mode.SRC_ATOP);
                        ImageViewCompat.setImageTintList(fi.getImageView(), ColorStateList.valueOf(Color.parseColor("#80000000")));
                    }
                }
            } else if(Integer.parseInt((String) textViewPointsGF.getText()) >= fonList.get(i).getPrice()){
                ImageViewCompat.setImageTintList(fi.getImageView(), null);
            } else {
                ImageViewCompat.setImageTintMode(fi.getImageView(), PorterDuff.Mode.SRC_ATOP);
                ImageViewCompat.setImageTintList(fi.getImageView(), ColorStateList.valueOf(Color.parseColor("#80000000")));
            }*/
            i++;
        }
        i = 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}