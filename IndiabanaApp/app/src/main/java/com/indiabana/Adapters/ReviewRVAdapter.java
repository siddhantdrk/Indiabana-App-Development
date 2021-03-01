package com.indiabana.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.ReviewRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class ReviewRVAdapter  extends RecyclerView.Adapter<ReviewRVAdapter.MyViewHolder> {

    public ArrayList<ReviewRVItem> arrayList;

    public ReviewRVAdapter(ArrayList<ReviewRVItem> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ReviewRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item_layout, parent, false);
        return new ReviewRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewRVAdapter.MyViewHolder holder, int position) {

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
