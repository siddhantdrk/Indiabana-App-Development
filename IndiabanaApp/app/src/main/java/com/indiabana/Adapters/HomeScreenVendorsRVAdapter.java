package com.indiabana.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.FeaturedSellersRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class HomeScreenVendorsRVAdapter extends RecyclerView.Adapter<HomeScreenVendorsRVAdapter.MyViewHolder>{

    public ArrayList<FeaturedSellersRVItem> arrayList;

    public HomeScreenVendorsRVAdapter(ArrayList<FeaturedSellersRVItem> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vendors_list_item, parent, false);
        return new HomeScreenVendorsRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
