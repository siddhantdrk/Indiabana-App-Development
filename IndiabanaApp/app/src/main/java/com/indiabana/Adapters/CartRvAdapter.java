package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.CartRvItem;
import com.indiabana.R;

import java.util.List;

public class CartRvAdapter extends RecyclerView.Adapter<CartRvAdapter.MyViewHolder> {

    Context context;
    List<CartRvItem> data;
    int count = 0;

    public CartRvAdapter(){

    }

    public CartRvAdapter(Context context, List<CartRvItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ItemImg.setImageResource(data.get(position).getImgId());
        holder.itemName.setText(data.get(position).getItemName());
        holder.itemPrice.setText(data.get(position).getItemPrice());
        holder.itemQty.setText(data.get(position).getItemQty());
        holder.itemColor.setText(data.get(position).getItemColor());
        holder.itemCategory.setText(data.get(position).getItemCategory());

        holder.tvQuantity.setText("0");
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = Integer.valueOf(holder.tvQuantity.getText().toString());
                value++;
                holder.tvQuantity.setText(value + "");
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = Integer.valueOf(holder.tvQuantity.getText().toString());
                if(value > 0) {
                    value--;
                    holder.tvQuantity.setText(value + "");
                }
            }
        });
        holder.itemCancelImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,data.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemPrice, itemQty, itemColor, itemCategory, tvQuantity;
        ImageView ItemImg, itemCancelImg;
        Button btnPlus, btnMinus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View v) {
            ItemImg = v.findViewById(R.id.cart_rv_item_img);
            itemName = v.findViewById(R.id.cart_rv_item_name);
            itemPrice = v.findViewById(R.id.cart_rv_item_price);
            itemQty = v.findViewById(R.id.cart_rv_item_qty);
            itemColor = v.findViewById(R.id.cart_rv_item_color);
            itemCategory = v.findViewById(R.id.cart_rv_item_capacity);
            tvQuantity = v.findViewById(R.id.cart_view_tv_variable_value);
            btnPlus = v.findViewById(R.id.cart_plus_btn);
            btnMinus = v.findViewById(R.id.cart_minus_btn);
            itemCancelImg = v.findViewById(R.id.cart_view_cancel_btn);
        }
    }
}
