package ru.great_larder.sportquiz.ui.city;

import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.QuestionCity;

import java.util.List;

public class RecyclerViewAdapterCity extends RecyclerView.Adapter<RecyclerViewAdapterCity.ViewHolder> {
    private final LayoutInflater mInflater;
    private final List<QuestionCity> questionCities;
    private RecyclerViewAdapterCity.ItemClickListener mClickListener;
    
    public RecyclerViewAdapterCity(Context context, List<QuestionCity> questionCities) {
        this.mInflater = LayoutInflater.from(context);
        this.questionCities = questionCities;
    }
    
    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapterCity.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapterCity.ViewHolder holder, int position) {
        String name = questionCities.get(position).getCity();
        holder.nameCity.setText(name);
        if(questionCities.get(position).getLabel() != null && questionCities.get(position).getLabel().length > 0){
                holder.logoCity.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeByteArray(
                    questionCities.get(position).getLabel(), 0, questionCities.get(position).getLabel().length)));
            }else {
            holder.logoCity.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeResource(mInflater.getContext().getResources(), R.drawable.city_quiz)));
        }
    }
    
    @Override
    public int getItemCount() {
        return questionCities.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        
        ImageView logoCity;
        TextView nameCity;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            logoCity = itemView.findViewById(R.id.imageViewLogoCity);
            nameCity = itemView.findViewById(R.id.textViewNameCity);
            itemView.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(logoCity, getBindingAdapterPosition());
        }
    }
    
    public String getItem(int id) {
        return questionCities.get(id).getCity();
    }
    
    // allows clicks events to be caught
    public void setClickListener(RecyclerViewAdapterCity.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    
    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    
    private Bitmap getRoundedRectBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
            bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 100;
        
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        
        return output;
    }
  
}
