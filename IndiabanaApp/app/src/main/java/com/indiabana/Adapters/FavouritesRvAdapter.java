package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.FavouritesRvItem;
import com.indiabana.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavouritesRvAdapter extends RecyclerView.Adapter<FavouritesRvAdapter.MyViewHolder> {
    Context context;
    List<FavouritesRvItem> data;

    public FavouritesRvAdapter(Context context, List<FavouritesRvItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.favItemImg.setImageResource(data.get(position).getImgId());
        holder.itemNew.setText(data.get(position).getItemType());
        holder.desc.setText(data.get(position).getTitle());
        holder.duration.setText(data.get(position).getDeliveryTime());
        holder.money.setText(data.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemNew, desc, delivery_in_txt, duration, symbol, money;
        ImageView favItemImg;
        CircleImageView like, truck;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View v) {
            itemNew = v.findViewById(R.id.nuevo);
            desc = v.findViewById(R.id.desc);
            delivery_in_txt = v.findViewById(R.id.delivery_in_txt);
            duration = v.findViewById(R.id.duration);
            symbol = v.findViewById(R.id.symbol);
            money = v.findViewById(R.id.money);
            favItemImg = v.findViewById(R.id.mobile);
            truck = v.findViewById(R.id.gratis);
            like = v.findViewById(R.id.like);
        }
    }
}
