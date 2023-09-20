package ru.great_larder.sportquiz.ui.city;

import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.R;

import java.util.List;

public class RecyclerViewAdapterCity extends RecyclerView.Adapter<RecyclerViewAdapterCity.ViewHolder> {
    private List<String> nameCityList;
    private List<byte[]> logoCityList;
    private LayoutInflater mInflater;
    private RecyclerViewAdapterCity.ItemClickListener mClickListener;
    
    public RecyclerViewAdapterCity(Context context, List<String> nameCityList, List<byte[]> logoCityList) {
        this.mInflater = LayoutInflater.from(context);
        this.nameCityList = nameCityList;
        this.logoCityList = logoCityList;
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
        String name = nameCityList.get(position);
        holder.nameCity.setText(name);
        if(logoCityList != null && !logoCityList.isEmpty()) {
            byte[] animal = logoCityList.get(position);
            if(animal != null && animal.length > 0) {
                holder.logoCity.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeByteArray(animal, 0, animal.length)));
            }else {
                holder.logoCity.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeResource(mInflater.getContext().getResources(), R.drawable.city_quiz)));
            }
        } else {
            holder.logoCity.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeResource(mInflater.getContext().getResources(), R.drawable.city_quiz)));
        }
    }
    
    @Override
    public int getItemCount() {
        return nameCityList.size();
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
        return nameCityList.get(id);
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
