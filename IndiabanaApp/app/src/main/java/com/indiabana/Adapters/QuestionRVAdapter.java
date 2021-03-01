package com.indiabana.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.FeaturedSellersRVItem;
import com.indiabana.Data.QuestionRVItem;
import com.indiabana.Data.ReviewRVItem;
import com.indiabana.R;

import java.util.ArrayList;

public class QuestionRVAdapter  extends RecyclerView.Adapter<QuestionRVAdapter.MyViewHolder> {
    public ArrayList<QuestionRVItem> arrayList;

    public QuestionRVAdapter(ArrayList<QuestionRVItem> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public QuestionRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_item_layout, parent, false);
        return new QuestionRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionRVAdapter.MyViewHolder holder, int position) {

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
