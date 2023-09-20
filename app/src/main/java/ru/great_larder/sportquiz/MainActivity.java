package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.material.navigation.NavigationView;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.database.FairiesDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataAppService;
import ru.great_larder.sportquiz.services.load.LoadDataAppShop;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.HandlerUserListener;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;
import ru.great_larder.sportquiz.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity implements ObserverUser {
    
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    public TextView textViewBar, tg;
    private ImageView img, imageViewAwatar;
    public ImageView img_fairies;
    private ProgressBar progressBar;
    HandlerUserListener handlerUserListener = new HandlerUserListener();
    FairiesDatabaseAdapter fairiesDatabaseAdapter;
    
    public ImageView getImg_fairies() {
        return img_fairies;
    }
    
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
        if (!users.isEmpty()) {
            GlobalLinkUser.setUser(users.get(0));
                WorkManager workManagerShop = WorkManager.getInstance(this);
                workManagerShop.enqueue(OneTimeWorkRequest.from(LoadDataAppShop.class));
        } else GlobalLinkUser.setUser(null);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        textViewBar = binding.appBarMain.textViewRight;
        img = binding.appBarMain.imageViewVik;
        drawer = binding.drawerLayout;
        
        img_fairies = binding.appBarMain.imgFairies;
        progressBar = binding.appBarMain.progressBar;
        
        img_fairies.setVisibility(View.VISIBLE);
        
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        
        NavigationView navigationView = binding.navView;
        View hView = navigationView.getHeaderView(0);
        
        tg = hView.findViewById(R.id.textViewNameNavHeader);
        imageViewAwatar = hView.findViewById(R.id.imageViewAwatar);
        
        navigationView.setItemIconTintList(null);
        if (GlobalLinkUser.getUser() != null) {
            loadMainAct(GlobalLinkUser.getUser());
            if (new CheckNetClass().getConnectionType(this) > 0) {
                WorkManager workManager = WorkManager.getInstance(this);
                workManager.enqueue(OneTimeWorkRequest.from(LoadDataAppService.class));
            } else {
                Toast.makeText(this, "Нет интернета!", Toast.LENGTH_LONG).show();
            }
        }
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_language_quiz, R.id.nav_sports_quiz
            , R.id.nav_school, R.id.nav_traffic_laws, R.id.nav_etiquette, R.id.nav_city, R.id.nav_partners)
            .setOpenableLayout(drawer)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        
    }
    
    public void loadMainAct(User userIn) {
        if(userIn != null) {
            Fairies fairies;
            fairiesDatabaseAdapter.open();
            fairies = fairiesDatabaseAdapter.getFairiesByActive();
            fairiesDatabaseAdapter.close();
            
            if (fairies != null) {
                if (getDifferenceInDays(fairies) <= fairies.getPrice()) {
                    if (getDifferenceInDays(fairies) == 0) {
                        progressBar.setMax(100);
                    } else {
                        progressBar.setProgress(100 / getDifferenceInDays(fairies));
                    }
                    img_fairies.setImageResource(fairies.getImageI());
                } else {
                    progressBar.setProgress(0);
                    img_fairies.setImageResource(R.drawable.logo_victorinka);
                }
            } else {
                progressBar.setProgress(0);
                img_fairies.setImageResource(R.drawable.logo_victorinka);
            }
            setTBarDate(GlobalLinkUser.getUser());
            tg.setText(GlobalLinkUser.getUser().getName());
            if (GlobalLinkUser.getUser().getAwatar() != null && GlobalLinkUser.getUser().getAwatar().length > 0) {
                imageViewAwatar.setImageBitmap(BitmapFactory.decodeByteArray(GlobalLinkUser.getUser().getAwatar()
                    , 0, GlobalLinkUser.getUser().getAwatar().length));
            }
        }
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
    
    private int getDifferenceInDays(Fairies g) {
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