package ru.great_larder.sportquiz;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.databinding.ActivityMainBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.HandlerUserListener;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements ObserverUser {
    
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private TextView textViewBar;
    private ImageView img;
    HandlerUserListener handlerUserListener = new HandlerUserListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlerUserListener.registerObserverUser(this);
        GlobalLinkUser.setHandlerUserListener(handlerUserListener);
        
        List<User> users;
        DatabaseAdapter adapter = new DatabaseAdapter(this);
        adapter.open();
        users = adapter.getUsers();
        adapter.close();
        if(users.size() > 0) {
            GlobalLinkUser.setUser(users.get(0));
        } else GlobalLinkUser.setUser(null);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        textViewBar = binding.appBarMain.textViewRight;
        img = binding.appBarMain.imageViewVik;
        drawer = binding.drawerLayout;
        
        handlerUserListener.onNewDataUser(new DataUser(GlobalLinkUser.getUser()));
        
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        
        NavigationView navigationView = binding.navView;
        
        View hView = navigationView.getHeaderView(0);
        TextView tg = hView.findViewById(R.id.textViewNameNavHeader);
        if(GlobalLinkUser.getUser() != null) {
            tg.setText(GlobalLinkUser.getUser().getName());
        }
        
        navigationView.setItemIconTintList(null);
        
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_language_quiz, R.id.nav_sports_quiz
        , R.id.nav_school, R.id.nav_traffic_laws)
            .setOpenableLayout(drawer)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        
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
    public void setBackgroundActivity(int img){
        drawer.setBackgroundResource(img);
    }
    public void setTBarDate(User user){
        img.setImageDrawable(null);
        if(user != null) {
            textViewBar.setText(String.valueOf(user.getGlasses()));
            img.setBackgroundResource(R.drawable.animat_viktik);
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
            frameAnimation.setOneShot(true);
            frameAnimation.start();
            if(user.getThemeInstalledNow() != 0){
                GetFon getFon = new GetFonImpl();
                setBackgroundActivity(getFon.getFonById(user.getThemeInstalledNow()).getImageI());
            }
        } else textViewBar.setText(String.valueOf(0));
        img.setBackgroundResource(R.drawable.animat_viktik);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.setOneShot(true);
        frameAnimation.start();
        
    }
    
    @Override
    public void updateUser(DataUser dataUser) {
        setTBarDate(dataUser.getUser());
    }
}