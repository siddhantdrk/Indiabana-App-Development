package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.TechnologyRvItem;
import com.indiabana.R;

import java.util.List;

public class TechnologyTopRvAdapter extends RecyclerView.Adapter<TechnologyTopRvAdapter.ViewHolder> {

    Context context;
    List<TechnologyRvItem> technologyRvItemList;

    public TechnologyTopRvAdapter() {
    }

    public TechnologyTopRvAdapter(Context context, List<TechnologyRvItem> technologyRvItemList) {
        this.context = context;
        this.technologyRvItemList = technologyRvItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.technology_tio_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(technologyRvItemList.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return technologyRvItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.technology_rv_iv);
        }
    }
}
