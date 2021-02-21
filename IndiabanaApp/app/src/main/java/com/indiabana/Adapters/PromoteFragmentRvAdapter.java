package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.PromotePublicationRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class PromoteFragmentRvAdapter extends RecyclerView.Adapter<PromoteFragmentRvAdapter.PromotePublicationViewHolder> {
    private final Context context;
    private final ArrayList<PromotePublicationRvItem> promotePublicationRvItemArrayList;

    public PromoteFragmentRvAdapter(Context context, ArrayList<PromotePublicationRvItem> promotePublicationRvItemArrayList) {
        this.context = context;
        this.promotePublicationRvItemArrayList = promotePublicationRvItemArrayList;
    }

    @NonNull
    @Override
    public PromoteFragmentRvAdapter.PromotePublicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.publication_promotes_rv_item, parent, false);
        return new PromotePublicationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoteFragmentRvAdapter.PromotePublicationViewHolder holder, int position) {
        holder.publicationImg.setImageResource(promotePublicationRvItemArrayList.get(position).getPublicationImgId());
        holder.title.setText(promotePublicationRvItemArrayList.get(position).getTitle());
        holder.price.setText(promotePublicationRvItemArrayList.get(position).getPrice());
        holder.publicationType.setText(promotePublicationRvItemArrayList.get(position).getPublicationType());
    }

    @Override
    public int getItemCount() {
        return promotePublicationRvItemArrayList.size();
    }

    public class PromotePublicationViewHolder extends RecyclerView.ViewHolder {
        ImageView publicationImg;
        TextView title, price, publicationType;

        public PromotePublicationViewHolder(@NonNull View itemView) {
            super(itemView);
            publicationImg = itemView.findViewById(R.id.promote_img);
            title = itemView.findViewById(R.id.promote_title);
            price = itemView.findViewById(R.id.promote_price);
            publicationType = itemView.findViewById(R.id.publication_type);
        }
    }
}
