package com.indiabana.Adapters.Alliances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.Alliances.RequestsPotentialRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class RequestPotentialRvAdapter extends RecyclerView.Adapter<RequestPotentialRvAdapter.RequestPotentialViewHolder> {
    private final Context context;
    private final ArrayList<RequestsPotentialRvItem> requestsPotentialRvItemArrayList;
    OpenNextFragmentFromAdapter clickListener;

    public RequestPotentialRvAdapter(Context context, ArrayList<RequestsPotentialRvItem> requestsPotentialRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.requestsPotentialRvItemArrayList = requestsPotentialRvItemArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RequestPotentialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.requests_potential_rv_item, parent, false);
        return new RequestPotentialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestPotentialViewHolder holder, int position) {
        holder.commonNum.setText(requestsPotentialRvItemArrayList.get(position).getCommonProductNum());
        holder.details.setText(requestsPotentialRvItemArrayList.get(position).getDetails());
        holder.itemImg.setImageResource(requestsPotentialRvItemArrayList.get(position).getItemImgId());
        holder.rating.setText(requestsPotentialRvItemArrayList.get(position).getRating());
        holder.title.setText(requestsPotentialRvItemArrayList.get(position).getTitle());
        holder.ratingBar.setRating(requestsPotentialRvItemArrayList.get(position).getRatingValue());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestsPotentialRvItemArrayList.size();
    }

    public class RequestPotentialViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        TextView title, rating, details, commonNum;
        RatingBar ratingBar;

        public RequestPotentialViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.requests_potential_rv_item_title);
            itemImg = itemView.findViewById(R.id.request_potential_rv_item_img);
            rating = itemView.findViewById(R.id.rating_txt_requests);
            details = itemView.findViewById(R.id.requests_detail);
            ratingBar = itemView.findViewById(R.id.rating_bar_requests);
            commonNum = itemView.findViewById(R.id.common_products_num);
        }
    }
}
