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
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.services.GetRoundedRectBitmap;

import java.util.List;


public class RecyclerViewAdapterAuthor extends RecyclerView.Adapter<RecyclerViewAdapterAuthor.ViewHolder> {
    private final List<Author> authors;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    
    public RecyclerViewAdapterAuthor(Context context, List<Author> authors) {
        this.mInflater = LayoutInflater.from(context);
        this.authors = authors;
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
        String name =authors.get(position).getFirstNameAuthor();
        holder.nameAuthor.setText(name);
        String last = authors.get(position).getLastNameAuthor();
        holder.lastName.setText(last);
        if(authors.get(position).getPhoto() != null && authors.get(position).getPhoto().length >0){
            holder.photoAuthor.setImageBitmap(new GetRoundedRectBitmap().getRoundedRectBitmap(BitmapFactory.decodeByteArray(authors.get(position).getPhoto()
                , 0, authors.get(position).getPhoto().length)));
        }
    }
    
    @Override
    public int getItemCount() {
        return authors.size();
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
            if (mClickListener != null) mClickListener.onItemClickAuthor(photoAuthor, getBindingAdapterPosition(), authors.get(getBindingAdapterPosition()));
        }
    }
    
   public Author getItem(int id) {
        return authors.get(id);
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    
    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClickAuthor(View view, int position, Author author);
    }
}
