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
import ru.great_larder.sportquiz.domain.CompanyPartners;
import ru.great_larder.sportquiz.services.GetRoundedRectBitmap;

import java.util.List;

public class RecyclerViewAdapterCompanyPartners extends RecyclerView.Adapter<RecyclerViewAdapterCompanyPartners.ViewHolder> {
    private final LayoutInflater mInflater;
    private RecyclerViewAdapterCompanyPartners.ItemClickListener mClickListener;
    private final List<CompanyPartners> companyPartnersList;
    
    public RecyclerViewAdapterCompanyPartners(Context context, List<CompanyPartners> companyPartnersList) {
        this.companyPartnersList = companyPartnersList;
        this.mInflater = LayoutInflater.from(context);
    }
    
    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapterCompanyPartners.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_company_partners, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapterCompanyPartners.ViewHolder holder, int position) {
        String name = companyPartnersList.get(position).getNameCompany();
        holder.company.setText(name);
        if(companyPartnersList.get(position).getLogo() != null && companyPartnersList.get(position).getLogo().length > 0){
            holder.logo.setImageBitmap(new GetRoundedRectBitmap().getRoundedRectBitmap(BitmapFactory.decodeByteArray(
                companyPartnersList.get(position).getLogo(), 0, companyPartnersList.get(position).getLogo().length
            )));
        }
    }
    
    @Override
    public int getItemCount() {
        return companyPartnersList.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView logo;
        TextView company;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            company = itemView.findViewById(R.id.mameCompany);
            logo = itemView.findViewById(R.id.imageViewLogoItem);
            itemView.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClickCompanyPartners(logo, getBindingAdapterPosition()
            , companyPartnersList.get(getBindingAdapterPosition()));
        }
    }
    public CompanyPartners getItem(int id) {
        return companyPartnersList.get(id);
    }
    public void setClickListener(RecyclerViewAdapterCompanyPartners.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    
    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClickCompanyPartners(View view, int position, CompanyPartners companyPartners);
    }
}
