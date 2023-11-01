package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.FairiesDatabaseAdapterSQLite;
import ru.great_larder.sportquiz.databinding.ActivityMainBinding;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.GetActiveFairies;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.HandlerUserListener;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

import java.util.List;


public class MainActivity extends AppCompatActivity implements ObserverUser {
    
    private AppBarConfiguration mAppBarConfiguration;
    public TextView textViewBar, tg;
    private ImageView img, imageViewAwatar;
    public ImageView img_fairies;
    private ProgressBar progressBar;
    private FloatingActionButton fabHideFab;
    private Animation animShowFab, animHideFab;
    HandlerUserListener handlerUserListener = new HandlerUserListener();
    FairiesDatabaseAdapterSQLite fairiesDatabaseAdapter;
    public DrawerLayout drawer;
    
    public ImageView getImg_fairies() {
        return img_fairies;
    }
    
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    
    @SuppressLint({"UnsafeIntentLaunch", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        handlerUserListener.registerObserverUser(this);
        GlobalLinkUser.setHandlerUserListener(handlerUserListener);
        fairiesDatabaseAdapter = new FairiesDatabaseAdapterSQLite(this);
        GlobalLinkUser.setMainActivity(this);
        
        List<User> users;
        DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(this);
        adapter.open();
        users = adapter.getUsers();
        adapter.close();
        if (!users.isEmpty()) {
            GlobalLinkUser.setUser(users.get(0));
        } else GlobalLinkUser.setUser(null);
        
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        
        textViewBar = binding.appBarMain.textViewRight;
        
        fabHideFab = binding.appBarMain.fab;
        animShowFab = AnimationUtils.loadAnimation(this, R.animator.fab_show);
        animHideFab = AnimationUtils.loadAnimation(this, R.animator.fab_hide);
        fabHideFab.startAnimation(animHideFab);
        
        img = binding.appBarMain.imageViewVik;
        drawer = binding.drawerLayout;
        
        img_fairies = binding.appBarMain.imgFairies;
        progressBar = binding.appBarMain.progressBar;
        
        NavigationView navigationView = binding.navView;
        View hView = navigationView.getHeaderView(0);
        
        tg = hView.findViewById(R.id.textViewNameNavHeader);
        imageViewAwatar = hView.findViewById(R.id.imageViewAwatar);
        
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        
        navigationView.setItemIconTintList(null);
        /*if (GlobalLinkUser.getUser() != null) {
            loadMainAct(GlobalLinkUser.getUser());
        }*/
        
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_language_quiz, R.id.nav_sports_quiz
            , R.id.nav_school, R.id.nav_traffic_laws, R.id.nav_etiquette, R.id.nav_city, R.id.nav_partners)
            .setOpenableLayout(drawer)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        if (GlobalLinkUser.getUser() != null) {
            loadMainAct(GlobalLinkUser.getUser());
        }
    }
    public void loadMainAct(User userIn) {
        if(userIn != null) {
            GetActiveFairies getActiveFairies = new GetActiveFairies(this, progressBar);
            Fairies fairies = getActiveFairies.getFairies();
            if(fairies != null){
                img_fairies.setImageResource(fairies.getImageI());
            } else img_fairies.setImageResource(R.drawable.logo_victorinka);
            
            setTBarDate(GlobalLinkUser.getUser());
            tg.setText(GlobalLinkUser.getUser().getName());
            if (GlobalLinkUser.getUser().getAwatar() != null && GlobalLinkUser.getUser().getAwatar().length > 0) {
                imageViewAwatar.setImageBitmap(BitmapFactory.decodeByteArray(GlobalLinkUser.getUser().getAwatar()
                    , 0, GlobalLinkUser.getUser().getAwatar().length));
            }
        } else Toast.makeText(this, "Зарегистрируйтесь", Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
            || super.onSupportNavigateUp();
    }
    
    public void setTBarDate(User user) {
        img.setImageDrawable(null);
        img.setBackground(null);
        if (user != null) {
            textViewBar.setText(String.valueOf(user.getGlasses()));
            img.setBackgroundResource(R.drawable.animat_viktik);
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.setOneShot(true);
            frameAnimation.start();
        } else textViewBar.setText(String.valueOf(0));
        img.setBackgroundResource(R.drawable.animat_viktik);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.setOneShot(true);
        frameAnimation.start();
        
    }
    
    @Override
    public void updateUser(DataUser dataUser) {
        loadMainAct(dataUser.getUser());
    }
    public void setHintButton(String s){
        if (s != null && !s.isEmpty()) {
            fabHideFab.startAnimation(animShowFab);
            fabHideFab.setOnClickListener(v -> {
                fabHideFab.startAnimation(animHideFab);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
                startActivity(browserIntent);
            });
        } else fabHideFab.startAnimation(animHideFab);
    }
}