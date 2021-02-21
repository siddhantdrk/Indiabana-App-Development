package com.indiabana.Adapters.Alliances;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

public class AllianceFragmentCommitmentRVAdapter extends RecyclerView.Adapter<AllianceFragmentCommitmentRVAdapter.MyViewHolder>{

    private OpenNextFragmentFromAdapter clickListener;

    public AllianceFragmentCommitmentRVAdapter(OpenNextFragmentFromAdapter clickListener){
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alliance_product_rv_item, parent, false);
        return new AllianceFragmentCommitmentRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
