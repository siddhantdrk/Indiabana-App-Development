package com.indiabana.Adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Activities.ProductActivity;
import com.indiabana.Data.RecommendedRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class HomeScreenRecommendedRVAdapter extends RecyclerView.Adapter<HomeScreenRecommendedRVAdapter.MyViewHolder> {

    public ArrayList<RecommendedRVItem> arrayList;

    public HomeScreenRecommendedRVAdapter(ArrayList<RecommendedRVItem> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_screen_selling_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendedRVItem listItem = arrayList.get(position);
//        holder.item_name.setText(listItem.getItem_name());
//        holder.item_price.setText(listItem.getItem_rate());
//        holder.item_delivery_time.setText(listItem.getDelivery_time());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_name,item_price,item_delivery_time;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.name);
            item_delivery_time = itemView.findViewById(R.id.delivery_time);
            item_price= itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pp","pressed");
                    v.getContext().startActivity(new Intent(v.getContext(), ProductActivity.class));
//                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                    Fragment myFragment = new ProductFragment();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, myFragment).addToBackStack(null).commit();
                }
            });
        }
    }

}
