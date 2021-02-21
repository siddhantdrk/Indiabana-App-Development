package com.indiabana.Adapters.Alliances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.Alliances.MyAlliancesFragmentRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAlliancesRvAdapter extends RecyclerView.Adapter<MyAlliancesRvAdapter.MyAlliancesViewHolder> {
    private final Context context;
    private final ArrayList<MyAlliancesFragmentRvItem> myAlliancesFragmentRvItemArrayList;
    OpenNextFragmentFromAdapter clickListener;

    public MyAlliancesRvAdapter(Context context, ArrayList<MyAlliancesFragmentRvItem> myAlliancesFragmentRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.myAlliancesFragmentRvItemArrayList = myAlliancesFragmentRvItemArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyAlliancesRvAdapter.MyAlliancesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.my_alliances_rv_item, parent, false);
        return new MyAlliancesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAlliancesRvAdapter.MyAlliancesViewHolder holder, int position) {
        holder.itemImg.setImageResource(myAlliancesFragmentRvItemArrayList.get(position).getItemImgId());
        holder.title.setText(myAlliancesFragmentRvItemArrayList.get(position).getTitle());
        holder.rating.setText(myAlliancesFragmentRvItemArrayList.get(position).getRating());
        holder.details.setText(myAlliancesFragmentRvItemArrayList.get(position).getDetails());
        holder.ratingBar.setRating(myAlliancesFragmentRvItemArrayList.get(position).getRatingValue());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myAlliancesFragmentRvItemArrayList.size();
    }

    public class MyAlliancesViewHolder extends RecyclerView.ViewHolder {
        CircleImageView itemImg;
        TextView title, rating, details;
        RatingBar ratingBar;

        public MyAlliancesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.my_alliance_rv_item_title);
            itemImg = itemView.findViewById(R.id.item_image_view);
            rating = itemView.findViewById(R.id.myAlliance_rating_txt_view);
            details = itemView.findViewById(R.id.myAlliance_detail);
            ratingBar = itemView.findViewById(R.id.myAlliance_rating_bar);
        }
    }
}
