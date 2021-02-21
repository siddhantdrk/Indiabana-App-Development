package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.BillsRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class BillsFragmentRvAdapter extends RecyclerView.Adapter<BillsFragmentRvAdapter.BillsFragmentRvViewHolder> {
    private final Context context;
    private final ArrayList<BillsRvItem> billsRvItemArrayList;
    OpenNextFragmentFromAdapter clickListener;

    public BillsFragmentRvAdapter(Context context, ArrayList<BillsRvItem> billsRvItemArrayList, OpenNextFragmentFromAdapter clickListener) {
        this.context = context;
        this.billsRvItemArrayList = billsRvItemArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public BillsFragmentRvAdapter.BillsFragmentRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.bills_rv_item, parent, false);
        return new BillsFragmentRvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BillsFragmentRvAdapter.BillsFragmentRvViewHolder holder, int position) {
        holder.dateTxt.setText(billsRvItemArrayList.get(position).getDate());
        holder.saleTypeTxt.setText(billsRvItemArrayList.get(position).getSaleType());
        holder.orderNumberTxt.setText(billsRvItemArrayList.get(position).getOrderNumber());
        holder.moneyTxt.setText(billsRvItemArrayList.get(position).getMoney());
        holder.statusTxt.setText(billsRvItemArrayList.get(position).getStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.callback();
            }
        });
    }

    @Override
    public int getItemCount() {
        return billsRvItemArrayList.size();
    }

    static class BillsFragmentRvViewHolder extends RecyclerView.ViewHolder {
        TextView dateTxt, saleTypeTxt, orderNumberTxt, moneyTxt, statusTxt;

        public BillsFragmentRvViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTxt = itemView.findViewById(R.id.date_txt);
            saleTypeTxt = itemView.findViewById(R.id.sale_type_txt);
            orderNumberTxt = itemView.findViewById(R.id.order_no_txt);
            moneyTxt = itemView.findViewById(R.id.money_txt);
            statusTxt = itemView.findViewById(R.id.status_txt);
        }
    }
}
