package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    
    /*Handler mHandler;
    Runnable mRunnable;*/
    ImageView imageViewSplash;
    Animation rotate_anim;
    
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        imageViewSplash = findViewById(R.id.imageViewSplach);
        
       /* rotate_anim = AnimationUtils.loadAnimation(getApplicationContext(),
            R.animator.rotat);
        imageViewSplash.startAnimation(rotate_anim);
        */
        
        imageViewSplash.setBackgroundResource(R.drawable.animat_viktik);
        AnimationDrawable frameAnimation = (AnimationDrawable) imageViewSplash.getBackground();
        frameAnimation.setOneShot(true);
        frameAnimation.start();
        
        /*mHandler = new Handler();
        mRunnable = () -> {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        };
        mHandler.postDelayed(mRunnable,10);*/
        
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}