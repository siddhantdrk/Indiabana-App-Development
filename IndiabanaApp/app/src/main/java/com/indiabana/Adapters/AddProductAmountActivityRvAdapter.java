package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.indiabana.Data.ProductAmountRvItem;
import com.indiabana.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddProductAmountActivityRvAdapter extends RecyclerView.Adapter<AddProductAmountActivityRvAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<ProductAmountRvItem> productAmountRvItemsArrayList;

    public AddProductAmountActivityRvAdapter(Context context, ArrayList<ProductAmountRvItem> productAmountRvItemsArrayList) {
        this.context = context;
        this.productAmountRvItemsArrayList = productAmountRvItemsArrayList;
    }

    @NonNull
    @Override
    public AddProductAmountActivityRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.productamount_productimage_rv_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddProductAmountActivityRvAdapter.ViewHolder holder, int position) {
        if (productAmountRvItemsArrayList.get(position).getProduct_img() != 0) {
            holder.product_img.setImageResource(productAmountRvItemsArrayList.get(position).getProduct_img());
            holder.bg_img.setVisibility(View.GONE);
        } else {

        }

    }

    @Override
    public int getItemCount() {
        return productAmountRvItemsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product_img, bg_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            bg_img = itemView.findViewById(R.id.bg_img);
        }
    }
}
