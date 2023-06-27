package ru.great_larder.sportquiz.domain;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FonItem {
    LinearLayout linearLayout;
    TextView textView;
    ImageView imageView;
    
    public FonItem(LinearLayout linearLayout, TextView textView, ImageView imageView) {
        this.linearLayout = linearLayout;
        this.textView = textView;
        this.imageView = imageView;
    }
    
    public LinearLayout getLinearLayout() {
        return linearLayout;
    }
    
    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }
    
    public TextView getTextView() {
        return textView;
    }
    
    public void setTextView(TextView textView) {
        this.textView = textView;
    }
    
    public ImageView getImageView() {
        return imageView;
    }
    
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
