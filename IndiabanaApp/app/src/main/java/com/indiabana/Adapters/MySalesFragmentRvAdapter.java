package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.MySalesRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class MySalesFragmentRvAdapter extends RecyclerView.Adapter<MySalesFragmentRvAdapter.MySalesFragmentRvViewHolder> {
    private final Context context;
    private final ArrayList<MySalesRvItem> mySalesRvItemArrayList;
    private OpenNextFragmentFromAdapter openNextFragmentFromAdapter;

    public MySalesFragmentRvAdapter(Context context, ArrayList<MySalesRvItem> mySalesRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.mySalesRvItemArrayList = mySalesRvItemArrayList;
        this.openNextFragmentFromAdapter = clickListener;
    }

    @NonNull
    @Override
    public MySalesFragmentRvAdapter.MySalesFragmentRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.my_sales_rv_item, parent, false);
        return new MySalesFragmentRvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MySalesFragmentRvAdapter.MySalesFragmentRvViewHolder holder, int position) {
        holder.priceTxt.setText(mySalesRvItemArrayList.get(position).getPrice());
        holder.shoppingImg.setImageResource(mySalesRvItemArrayList.get(position).getShoppingImgId());
        holder.clientTxt.setText(mySalesRvItemArrayList.get(position).getClient());
        holder.statusTxt.setText(mySalesRvItemArrayList.get(position).getStatus());
        holder.productTitleTxt.setText(mySalesRvItemArrayList.get(position).getProductTitle());
        holder.amountTxt.setText(mySalesRvItemArrayList.get(position).getAmount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextFragmentFromAdapter.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mySalesRvItemArrayList.size();
    }

    class MySalesFragmentRvViewHolder extends RecyclerView.ViewHolder {
        ImageView shoppingImg;
        TextView productTitleTxt, priceTxt, amountTxt, statusTxt, clientTxt;

        public MySalesFragmentRvViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppingImg = itemView.findViewById(R.id.shopping_img);
            productTitleTxt = itemView.findViewById(R.id.product_title_txt);
            priceTxt = itemView.findViewById(R.id.price_value);
            amountTxt = itemView.findViewById(R.id.amount_value);
            statusTxt = itemView.findViewById(R.id.status_value);
            clientTxt = itemView.findViewById(R.id.client_value);
        }
    }
}
