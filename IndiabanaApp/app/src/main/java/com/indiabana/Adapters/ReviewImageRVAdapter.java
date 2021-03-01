package com.indiabana.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.ReviewImageRVItem;
import com.indiabana.Data.ReviewRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class ReviewImageRVAdapter extends RecyclerView.Adapter<ReviewImageRVAdapter.MyViewHolder>{
    public ArrayList<ReviewImageRVItem> arrayList;

    public ReviewImageRVAdapter(ArrayList<ReviewImageRVItem> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ReviewImageRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_review_images, parent, false);
        return new ReviewImageRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewImageRVAdapter.MyViewHolder holder, int position) {

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
