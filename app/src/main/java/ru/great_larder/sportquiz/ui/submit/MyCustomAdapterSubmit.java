package ru.great_larder.sportquiz.ui.submit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.Chapter;

import java.util.Collections;
import java.util.List;

public class MyCustomAdapterSubmit extends ArrayAdapter<List<Chapter>> {
    private final int resource;
    private final List<Chapter> chapters;
    private final Context context;
    
    public MyCustomAdapterSubmit(@NonNull Context context, int resource, @NonNull List<Chapter> objects) {
        super(context, resource, Collections.singletonList(objects));
        this.chapters = objects;
        this.resource = resource;
        this.context = context;
    }
    
    @Override
    public int getCount() {
        return chapters.size();
    }
    
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_chapter, parent, false);
            viewHolder.logo = convertView.findViewById(R.id.icon);
            viewHolder.text = convertView.findViewById(R.id.weekofday);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.logo.setImageResource(chapters.get(position).getIdResources());
        viewHolder.text.setText(chapters.get(position).getName());
        
        return convertView;
    }
    
    @Override
    public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
    private static class ViewHolder{
        ImageView logo;
        TextView text;
    }
}
