package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indiabana.Data.InventoryRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class InventoryFragmentRvAdapter extends RecyclerView.Adapter<InventoryFragmentRvAdapter.InventoryFragmentRvViewHolder> {
    private final Context context;
    private final ArrayList<InventoryRvItem> inventoryRvItemArrayList;
    private final OpenNextFragmentFromAdapter openNextFragmentFromAdapter;

    public InventoryFragmentRvAdapter(Context context, ArrayList<InventoryRvItem> inventoryRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.inventoryRvItemArrayList = inventoryRvItemArrayList;
        this.openNextFragmentFromAdapter = clickListener;
    }

    @NonNull
    @Override
    public InventoryFragmentRvAdapter.InventoryFragmentRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.publication_promotes_rv_item, parent, false);
        return new InventoryFragmentRvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryFragmentRvAdapter.InventoryFragmentRvViewHolder holder, int position) {
        holder.publicationImg.setImageResource(inventoryRvItemArrayList.get(position).getPublicationImgId());
        holder.title.setText(inventoryRvItemArrayList.get(position).getTitle());
        holder.price.setText(inventoryRvItemArrayList.get(position).getPrice());
        holder.publicationType.setText(inventoryRvItemArrayList.get(position).getPublicationType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextFragmentFromAdapter.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return inventoryRvItemArrayList.size();
    }

    class InventoryFragmentRvViewHolder extends RecyclerView.ViewHolder {
        ImageView publicationImg;
        TextView title, price, publicationType;

        public InventoryFragmentRvViewHolder(@NonNull View itemView) {
            super(itemView);
            publicationImg = itemView.findViewById(R.id.promote_img);
            title = itemView.findViewById(R.id.promote_title);
            price = itemView.findViewById(R.id.promote_price);
            publicationType = itemView.findViewById(R.id.publication_type);
        }
    }
}
