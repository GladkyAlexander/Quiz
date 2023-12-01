package ru.great_larder.sportquiz.ui.home;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.MainActivity;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.databinding.FragmentHomeBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.GetNamesVictik;
import ru.great_larder.sportquiz.services.MyBounceInterpolator;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

public class HomeFragment extends Fragment {
    
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private TextView textViewNameUser, textViewGlasses, textFieldVictorinok, textViewSlogan;
    private LinearLayout linearLayoutHello, fra;
    private LinearLayout linearLayoutGlasses;
    private ImageView imageViewAnimCoins, imgStartDetki;
    private Button buttonOpenDrav;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        homeViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        buttonOpenDrav = binding.buttonOpenDrav;
        
        imageViewAnimCoins = binding.imageViewAnimCoins;
        imgStartDetki = binding.imgStartDetki;
        
        linearLayoutHello = binding.linearLayoutHello;
        linearLayoutGlasses = binding.linearLayoutGlasses;
        fra = binding.fra;
        
        textViewNameUser = binding.textViewNameUser;
        textViewGlasses = binding.textViewGlasse;
        
        textFieldVictorinok = binding.textFieldVictorinok;
        textViewSlogan = binding.textViewSlogan;
        
        homeViewModel.loadUser();
        new Handler(Looper.getMainLooper()).postDelayed(this::buttonOpenStartAnimat, 500);
        homeViewModel.getmUser().observe(getViewLifecycleOwner(), this::loadFragment);
        
        buttonOpenDrav.setOnClickListener(f -> {
            if(!((MainActivity)requireActivity()).drawer.isDrawerOpen(GravityCompat.START)) ((MainActivity)requireActivity()).drawer.openDrawer(GravityCompat.START);
            else ((MainActivity)requireActivity()).drawer.closeDrawer(GravityCompat.END);
        });
        
        return root;
    }
    
    private void buttonOpenStartAnimat(){
        final MediaPlayer[] mediaPlayers = {android.media.MediaPlayer.create(requireContext(), R.raw.knopka_start)};
        try {
            if (mediaPlayers[0].isPlaying()) {
                mediaPlayers[0].stop();
                mediaPlayers[0].release();
                mediaPlayers[0] = MediaPlayer.create(requireContext(), R.raw.knopka_start);
            } mediaPlayers[0].start();
        } catch(Exception e) { System.err.println(e.getMessage()); }
        final Animation myAnim = AnimationUtils.loadAnimation(requireActivity(), R.anim.bouce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.4, 5);
        myAnim.setInterpolator(interpolator);
        buttonOpenDrav.startAnimation(myAnim);
    }
    
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    
    private void loadFragment(User user) {
        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
        if (user == null) {
            setVisibleLayout(false);
        } else {
            setVisibleLayout(true);
            textViewNameUser.setText(user.getName());
            textViewGlasses.setText(String.valueOf(user.getGlasses()));
            textFieldVictorinok.setText(new GetNamesVictik().getVictik(user.getGlasses()));
            
            imageViewAnimCoins.setBackgroundResource(R.drawable.animat_home);
            AnimationDrawable frameAnimation = (AnimationDrawable) imageViewAnimCoins.getBackground();
            frameAnimation.setOneShot(true);
            frameAnimation.start();
            homeViewModel.loadDate();
        }
        
    }
    private void setVisibleLayout(boolean b){
        if(b) {
            linearLayoutHello.setVisibility(View.VISIBLE);
            linearLayoutGlasses.setVisibility(View.VISIBLE);
        } else {
            linearLayoutHello.setVisibility(View.GONE);
            linearLayoutGlasses.setVisibility(View.GONE);
        }
    }
}