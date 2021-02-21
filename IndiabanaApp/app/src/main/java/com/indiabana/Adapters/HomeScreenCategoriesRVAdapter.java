package com.indiabana.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.CategoriesRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class HomeScreenCategoriesRVAdapter extends RecyclerView.Adapter<HomeScreenCategoriesRVAdapter.MyViewHolder>{

    public ArrayList<CategoriesRVItem> arrayList;

    public HomeScreenCategoriesRVAdapter(ArrayList<CategoriesRVItem> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HomeScreenCategoriesRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new HomeScreenCategoriesRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeScreenCategoriesRVAdapter.MyViewHolder holder, int position) {

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
