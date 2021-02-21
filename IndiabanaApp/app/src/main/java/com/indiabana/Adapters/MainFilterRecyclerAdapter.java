package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.ListItem;
import com.indiabana.R;
import com.reim.android.filterrecyclerview.FilterRecyclerAdapter;

import org.jetbrains.annotations.NotNull;

public class MainFilterRecyclerAdapter extends FilterRecyclerAdapter<ListItem> {

    private LayoutInflater inflater;

    public MainFilterRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected boolean filterByConstraint(@NotNull ListItem listItem, @NotNull String s) {
        String lowerName = listItem.getName().toLowerCase();
        String lowerConstraint = s.trim().toLowerCase();

        return lowerName.contains(lowerConstraint);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(inflater.inflate(R.layout.filter_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).initialize(findItemByPosition(position));
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;

        ItemViewHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.item_row_name);
        }

        private void initialize(ListItem listItem) {
            textName.setText(listItem.getName());
        }
    }
}
