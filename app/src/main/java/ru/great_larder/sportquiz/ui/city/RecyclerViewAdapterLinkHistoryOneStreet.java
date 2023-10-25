package ru.great_larder.sportquiz.ui.city;

import android.graphics.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.QuestionCity;

import java.util.List;

public class RecyclerViewAdapterLinkHistoryOneStreet extends RecyclerView.Adapter<RecyclerViewAdapterLinkHistoryOneStreet.ViewHolder> {
    
    private final LayoutInflater mInflater;
    private final List<QuestionCity> questionCities;
    private RecyclerViewAdapterLinkHistoryOneStreet.ItemClickListener mClickListener;
    
    public RecyclerViewAdapterLinkHistoryOneStreet(LayoutInflater mInflater, List<QuestionCity> questionCities) {
        this.mInflater = mInflater;
        this.questionCities = questionCities;
    }
    
    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapterLinkHistoryOneStreet.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_link_history_one_street, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapterLinkHistoryOneStreet.ViewHolder holder, int position) {
        if(questionCities.get(position).getLinkHistoryOneStreet() != null &&
        !questionCities.get(position).getLinkHistoryOneStreet().isEmpty()){
            holder.logoCityLinHistoryOneStreet.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeByteArray(
                questionCities.get(position).getLabel(), 0, questionCities.get(position).getLabel().length)));
        }
    }
    
    @Override
    public int getItemCount() {
        return questionCities.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView logoCityLinHistoryOneStreet;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            logoCityLinHistoryOneStreet = itemView.findViewById(R.id.logoCityLinHistoryOneStreet);
            logoCityLinHistoryOneStreet.setClickable(true);
            logoCityLinHistoryOneStreet.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClickLinkHistoryOneStreet(logoCityLinHistoryOneStreet, getBindingAdapterPosition());
        }
    }
    public QuestionCity getItem(int id) {
        return questionCities.get(id);
    }
    
    public void setClickListener(RecyclerViewAdapterLinkHistoryOneStreet.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    
    public interface ItemClickListener {
        void onItemClickLinkHistoryOneStreet(View view, int position);
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
