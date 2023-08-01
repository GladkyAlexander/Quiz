package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.database.FairiesDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.HandlerUserListener;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;
import ru.great_larder.sportquiz.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements ObserverUser {
    
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private TextView textViewBar;
    private ImageView img, img_fairies;
    private ProgressBar progressBar;
    HandlerUserListener handlerUserListener = new HandlerUserListener();
    FairiesDatabaseAdapter fairiesDatabaseAdapter;
    @SuppressLint("UnsafeIntentLaunch")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        handlerUserListener.registerObserverUser(this);
        GlobalLinkUser.setHandlerUserListener(handlerUserListener);
        fairiesDatabaseAdapter = new FairiesDatabaseAdapter(this);
        
        List<User> users;
        DatabaseAdapter adapter = new DatabaseAdapter(this);
        adapter.open();
        users = adapter.getUsers();
        adapter.close();
        if(!users.isEmpty()) {
            GlobalLinkUser.setUser(users.get(0));
        } else GlobalLinkUser.setUser(null);
        
        LoadDataApp loadDataApp = new LoadDataApp(this);
        loadDataApp.setFairies();
        loadDataApp.setPuzzle();
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        textViewBar = binding.appBarMain.textViewRight;
        img = binding.appBarMain.imageViewVik;
        drawer = binding.drawerLayout;
        img_fairies = binding.appBarMain.imgFairies;
        progressBar = binding.appBarMain.progressBar;
        
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        
        NavigationView navigationView = binding.navView;
        View hView = navigationView.getHeaderView(0);
        
        TextView tg = hView.findViewById(R.id.textViewNameNavHeader);
        navigationView.setItemIconTintList(null);
        if(GlobalLinkUser.getUser() != null) {
            tg.setText(GlobalLinkUser.getUser().getName());
            setTBarDate(GlobalLinkUser.getUser());
            loadMainAct();
        }
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_language_quiz, R.id.nav_sports_quiz
            , R.id.nav_school, R.id.nav_traffic_laws, R.id.nav_etiquette, R.id.nav_partners)
            .setOpenableLayout(drawer)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        
    }
    public void loadMainAct(){
        Fairies fairies;
        fairiesDatabaseAdapter.open();
        fairies = fairiesDatabaseAdapter.getFairiesByActive();
        fairiesDatabaseAdapter.close();
        
        if(fairies != null){
            if (getDifferenceInDays(fairies) <= fairies.getPrice()) {
                if(getDifferenceInDays(fairies) == 0){
                    progressBar.setMax(100);
                } else {
                    progressBar.setProgress(100 / getDifferenceInDays(fairies));
                }
                img_fairies.setImageResource(fairies.getImageI());
            } else progressBar.setProgress(0);
        }else progressBar.setProgress(0);
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
            || super.onSupportNavigateUp();
    }
    public void setTBarDate(User user){
        img.setImageDrawable(null);
        if(user != null) {
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
        setTBarDate(dataUser.getUser());
        loadMainAct();
    }
    private int getDifferenceInDays(Fairies g){
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        try {
            Date dateCurrent = dateFormat.parse(currentDate);
            Date fd = g.getDateStart();
            assert dateCurrent != null;
            assert fd != null;
            long milliseconds = dateCurrent.getTime() - fd.getTime();
            return (int) (milliseconds / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.getStackTrace();
        }
        return 0;
    }
}