package com.indiabana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.indiabana.Adapters.NotificationFragmentRvAdapter;
import com.indiabana.Data.NotificationFragmentRvItem;
import com.indiabana.R;
import com.indiabana.databinding.FragmentNotificationBinding;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment implements View.OnClickListener {

    private FragmentNotificationBinding notificationBinding;
    ImageView iconView;
    boolean status = true;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        notificationBinding = FragmentNotificationBinding.inflate(inflater, container, false);
        setRecyclerView();

        //Hamza Aftab
        iconView = getActivity().findViewById(R.id.icon);
        iconView.setOnClickListener(this);

        return notificationBinding.getRoot();
    }

    private void setRecyclerView() {
        notificationBinding.notificationRecycler.setAdapter(new NotificationFragmentRvAdapter(getContext(), getNotificationList()));
        notificationBinding.notificationRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationBinding.notificationRecycler.hasFixedSize();
    }

    private List<NotificationFragmentRvItem> getNotificationList() {
        ArrayList<NotificationFragmentRvItem> notificationFragmentRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            notificationFragmentRvItemArrayList.add(new NotificationFragmentRvItem("Mensaje de comprador", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor...", R.drawable.demo_notification_img));
        }
        return notificationFragmentRvItemArrayList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                Toast.makeText(getContext(), "Notification Filer", Toast.LENGTH_SHORT).show();
        }
    }
}