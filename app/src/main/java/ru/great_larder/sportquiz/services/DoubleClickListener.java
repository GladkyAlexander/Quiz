package ru.great_larder.sportquiz.services;

import android.view.View;

public class DoubleClickListener implements View.OnClickListener {
    
    private static final long DOUBLE_CLICK_TIME_DELTA = 300;//milliseconds
    
    long lastClickTime = 0;
    
    @Override
    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA){
            onDoubleClick(v);
        } else {
            onSingleClick(v);
        }
        lastClickTime = clickTime;
    }
    
    public void onSingleClick(View v) {
    
    }
    
    public void onDoubleClick(View v) {
    
    }
}
