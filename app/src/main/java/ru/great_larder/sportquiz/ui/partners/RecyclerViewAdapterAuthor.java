package ru.great_larder.sportquiz.ui.partners;

import android.content.Context;
import android.graphics.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.R;

import java.util.List;


public class RecyclerViewAdapterAuthor extends RecyclerView.Adapter<RecyclerViewAdapterAuthor.ViewHolder> {
    private List<String> lastNameAuthorList;
    private List<String> firstNameAuthorList;
    private List<byte[]> mAnimals;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    
    public RecyclerViewAdapterAuthor(Context context, List<String> lastNameAuthor, List<String> firstNameAuthor, List<byte[]> animals) {
        this.mInflater = LayoutInflater.from(context);
        this.lastNameAuthorList = lastNameAuthor;
        this.firstNameAuthorList = firstNameAuthor;
        this.mAnimals = animals;
    }
    
    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapterAuthor.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_author, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapterAuthor.ViewHolder holder, int position) {
        String name = firstNameAuthorList.get(position);
        holder.nameAuthor.setText(name);
        String last = lastNameAuthorList.get(position);
        holder.lastName.setText(last);
        if(mAnimals != null && !mAnimals.isEmpty()) {
            byte[] animal = mAnimals.get(position);
            if(animal != null && animal.length > 0) {
                holder.photoAuthor.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeByteArray(animal, 0, animal.length)));
            }else {
                holder.photoAuthor.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeResource(mInflater.getContext().getResources(), R.drawable.cheat_sheet)));
            }
        } else {
            holder.photoAuthor.setImageBitmap(getRoundedRectBitmap(BitmapFactory.decodeResource(mInflater.getContext().getResources(), R.drawable.cheat_sheet)));
        }
    }
    
    @Override
    public int getItemCount() {
        return mAnimals.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        
        ImageView photoAuthor;
        TextView nameAuthor;
        TextView lastName;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            
            photoAuthor = itemView.findViewById(R.id.imageViewLogoAuthor);
            nameAuthor = itemView.findViewById(R.id.textViewNameAuthor);
            lastName = itemView.findViewById(R.id.textViewLastAuthor);
            itemView.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(photoAuthor, getBindingAdapterPosition());
        }
    }
    
   public String getItem(int id) {
        return lastNameAuthorList.get(id);
    }
    
    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
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
