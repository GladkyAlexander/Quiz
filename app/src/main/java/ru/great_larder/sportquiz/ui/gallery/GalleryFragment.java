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
import ru.great_larder.sportquiz.databinding.FragmentGalleryBinding;
import ru.great_larder.sportquiz.domain.Fon;
import ru.great_larder.sportquiz.domain.FonItem;
import ru.great_larder.sportquiz.domain.User;

import java.util.*;

public class GalleryFragment extends Fragment {
    
    private FragmentGalleryBinding binding;
    private TextView textViewNameGalleryFragment;
    private TextView textViewPointsGF;
    private TextView textViewFon1;
    private TextView textViewFon2;
    private TextView textViewFon3;
    private TextView textViewFon4;
    private TextView textViewFon5;
    private TextView textViewFon6;
    private TextView textViewFon7;
    private TextView textViewFon8;
    private TextView textViewFon9;
    private ImageView imageViewFon1, imageViewFon2, imageViewFon3, imageViewFon4, imageViewFon5, imageViewFon6
        ,imageViewFon7, imageViewFon8, imageViewFon9;
    private LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, llStart;
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
        
        llStart = binding.llStart;
        
        fonItemList.add(new FonItem(ll1 = binding.ll1, textViewFon1 = binding.textViewFon1, imageViewFon1 = binding.imageViewFon1));
        fonItemList.add(new FonItem(ll2 = binding.ll2, textViewFon2 = binding.textViewFon2, imageViewFon2 = binding.imageViewFon2));
        fonItemList.add(new FonItem(ll3 = binding.ll3, textViewFon3 = binding.textViewFon3, imageViewFon3 = binding.imageViewFon3));
        fonItemList.add(new FonItem(ll4 = binding.ll4, textViewFon4 = binding.textViewFon4, imageViewFon4 = binding.imageViewFon4));
        fonItemList.add(new FonItem(ll5 = binding.ll5, textViewFon5 = binding.textViewFon5, imageViewFon5 = binding.imageViewFon5));
        fonItemList.add(new FonItem(ll6 = binding.ll6, textViewFon6 = binding.textViewFon6, imageViewFon6 = binding.imageViewFon6));
        fonItemList.add(new FonItem(ll7 = binding.ll7, textViewFon7 = binding.textViewFon7, imageViewFon7 = binding.imageViewFon7));
        fonItemList.add(new FonItem(ll8 = binding.ll8, textViewFon8 = binding.textViewFon8, imageViewFon8 = binding.imageViewFon8));
        fonItemList.add(new FonItem(ll9 = binding.ll9, textViewFon9 = binding.textViewFon9, imageViewFon9 = binding.imageViewFon9));
        
        dialogFragment = new FragmentDialogBuy();
        
        if(GlobalLinkUser.getUser() != null){
            loadFragment(GlobalLinkUser.getUser());
        }
        
        return root;
    }
    private void openDialog(Fon fo){
        
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
            Fon fon = new Fon();
            fon.setId(fonList.get(i).getId());
            fon.setName(fi.getImageView().getTransitionName());
            fon.setPrice(Integer.parseInt((String) fi.getTextView().getText()));
            fon.setAffiliation((int) GlobalLinkUser.getUser().getId());
            fon.setImageI(fonList.get(i).getImageI());
            
            if(fonList.get(i).getPrice() > user.getGlasses()){
                ImageViewCompat.setImageTintMode(fi.getImageView(), PorterDuff.Mode.SRC_ATOP);
                ImageViewCompat.setImageTintList(fi.getImageView(), ColorStateList.valueOf(Color.parseColor("#80000000")));
            }
            
            fi.getImageView().setOnClickListener(r->{
                
                if(GlobalLinkUser.getUser().getGlasses() >= Integer.parseInt((String) fi.getTextView().getText())){
                    openDialog(fon);
                }
            });
            
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