package com.indiabana.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Data.NotificationFragmentRvItem;
import com.indiabana.R;

import java.util.List;

public class NotificationFragmentRvAdapter extends RecyclerView.Adapter<NotificationFragmentRvAdapter.ViewHolder> {
    Context context;
    List<NotificationFragmentRvItem> notificationFragmentRvItemList;

    public NotificationFragmentRvAdapter(Context context, List<NotificationFragmentRvItem> notificationFragmentRvItemList) {
        this.context = context;
        this.notificationFragmentRvItemList = notificationFragmentRvItemList;
    }

    @NonNull
    @Override
    public com.indiabana.Adapters.NotificationFragmentRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.indiabana.Adapters.NotificationFragmentRvAdapter.ViewHolder holder, int position) {
        holder.title.setText(notificationFragmentRvItemList.get(position).getTitle());
        holder.desc.setText(notificationFragmentRvItemList.get(position).getDescription());
        holder.notificationImg.setImageResource(notificationFragmentRvItemList.get(position).getNotificationImgId());
    }

    @Override
    public int getItemCount() {
        return notificationFragmentRvItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView desc;
        private final ImageView notificationImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationImg = itemView.findViewById(R.id.notification_main_imgView);
            title = itemView.findViewById(R.id.notification_title_text);
            desc = itemView.findViewById(R.id.notification_desc_text);
        }
    }
}
