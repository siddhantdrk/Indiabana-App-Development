package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.MyShoppingRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class MyShoppingFragmentRvAdapter extends RecyclerView.Adapter<MyShoppingFragmentRvAdapter.MyShoppingFragmentRvViewHolder> {
    private final Context context;
    private final ArrayList<MyShoppingRvItem> myShoppingRvItemArrayList;
    private OpenNextFragmentFromAdapter openNextFragmentFromAdapter;

    public MyShoppingFragmentRvAdapter(Context context, ArrayList<MyShoppingRvItem> myShoppingRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.myShoppingRvItemArrayList = myShoppingRvItemArrayList;
        this.openNextFragmentFromAdapter = clickListener;
    }

    @NonNull
    @Override
    public MyShoppingFragmentRvAdapter.MyShoppingFragmentRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.my_sales_rv_item, parent, false);
        return new MyShoppingFragmentRvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyShoppingFragmentRvAdapter.MyShoppingFragmentRvViewHolder holder, int position) {
        holder.priceTxt.setText(myShoppingRvItemArrayList.get(position).getPrice());
        holder.shoppingImg.setImageResource(myShoppingRvItemArrayList.get(position).getShoppingImgId());
        holder.statusTxt.setText(myShoppingRvItemArrayList.get(position).getStatus());
        holder.productTitleTxt.setText(myShoppingRvItemArrayList.get(position).getProductTitle());
        holder.amountTxt.setText(myShoppingRvItemArrayList.get(position).getAmount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextFragmentFromAdapter.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myShoppingRvItemArrayList.size();
    }

    class MyShoppingFragmentRvViewHolder extends RecyclerView.ViewHolder {
        ImageView shoppingImg;
        TextView productTitleTxt, priceTxt, amountTxt, statusTxt;

        public MyShoppingFragmentRvViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppingImg = itemView.findViewById(R.id.shopping_img);
            productTitleTxt = itemView.findViewById(R.id.product_title_txt);
            priceTxt = itemView.findViewById(R.id.price_value);
            amountTxt = itemView.findViewById(R.id.amount_value);
            statusTxt = itemView.findViewById(R.id.status_value);
        }
    }
}
