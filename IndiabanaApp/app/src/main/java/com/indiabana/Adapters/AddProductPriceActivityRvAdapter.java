package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indiabana.Data.ProductPricePostTypeRvItem;
import com.indiabana.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddProductPriceActivityRvAdapter extends RecyclerView.Adapter<AddProductPriceActivityRvAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<ProductPricePostTypeRvItem> productPricePostTypeRvItemsArrayList;

    public AddProductPriceActivityRvAdapter(Context context, ArrayList<ProductPricePostTypeRvItem> productPricePostTypeRvItemsArrayList) {
        this.context = context;
        this.productPricePostTypeRvItemsArrayList = productPricePostTypeRvItemsArrayList;
    }

    @NonNull
    @Override
    public AddProductPriceActivityRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.productprice_posttype_rv_item, parent, false);
        return new AddProductPriceActivityRvAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddProductPriceActivityRvAdapter.ViewHolder holder, int position) {
        holder.badge_img.setImageResource(productPricePostTypeRvItemsArrayList.get(position).getBadge_img());
        holder.badge_name.setText(productPricePostTypeRvItemsArrayList.get(position).getBadge_name());
        holder.badge_name.setTextColor(productPricePostTypeRvItemsArrayList.get(position).getBadge_textcolor());
        if (productPricePostTypeRvItemsArrayList.get(position).getBadge_name().equals(context.getResources().getString(R.string.badge_name4)))
            holder.info_img.setVisibility(View.VISIBLE);
        else
            holder.info_img.setVisibility(View.GONE);
        holder.duration_value.setText(productPricePostTypeRvItemsArrayList.get(position).getDuration_value());
        holder.exposure_value.setText(productPricePostTypeRvItemsArrayList.get(position).getExposure_value());
        holder.accumulate_value.setText(productPricePostTypeRvItemsArrayList.get(position).getAccumulate_value());
        holder.stock_value.setText(productPricePostTypeRvItemsArrayList.get(position).getStock_value());
        holder.percent_value.setText(productPricePostTypeRvItemsArrayList.get(position).getPercent_value());
    }

    @Override
    public int getItemCount() {
        return productPricePostTypeRvItemsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView badge_img, info_img;
        TextView badge_name, duration_value, exposure_value, accumulate_value, stock_value, percent_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            badge_img = itemView.findViewById(R.id.badge_img);
            info_img = itemView.findViewById(R.id.info_img);
            badge_name = itemView.findViewById(R.id.badge_name);
            duration_value = itemView.findViewById(R.id.duration_value);
            exposure_value = itemView.findViewById(R.id.exposure_value);
            accumulate_value = itemView.findViewById(R.id.accumulate_value);
            stock_value = itemView.findViewById(R.id.stock_value);
            percent_value = itemView.findViewById(R.id.percent_value);
        }
    }
}
