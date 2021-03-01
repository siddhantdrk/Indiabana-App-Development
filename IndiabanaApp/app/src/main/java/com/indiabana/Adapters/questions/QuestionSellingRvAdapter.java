package com.indiabana.Adapters.questions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.QuestionFragmentRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class QuestionSellingRvAdapter extends RecyclerView.Adapter<QuestionSellingRvAdapter.ViewHolder> {
    public ArrayList<QuestionFragmentRvItem> questionFragmentRvItemArrayList;

    public QuestionSellingRvAdapter(ArrayList<QuestionFragmentRvItem> questionFragmentRvItemArrayList) {
        this.questionFragmentRvItemArrayList = questionFragmentRvItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_fragment_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = questionFragmentRvItemArrayList.get(position).getRightArrowBtn();
        String productName = questionFragmentRvItemArrayList.get(position).getProductName();
        String productDetail = questionFragmentRvItemArrayList.get(position).getProductDetail();

        holder.setProductImage(image);
        holder.setProductName(productName);
        holder.setProductDetail(productDetail);
    }

    @Override
    public int getItemCount() {
        return questionFragmentRvItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final TextView productDetail;
        private final ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            productDetail = itemView.findViewById(R.id.product_details);
            productImage = itemView.findViewById(R.id.btn);
        }

        public void setProductImage(int image) {
            productImage.setImageResource(image);
        }
        public void setProductName(String name){
            productName.setText(name);
        }
        public void setProductDetail(String detail){
            productDetail.setText(detail);
        }
    }
}
