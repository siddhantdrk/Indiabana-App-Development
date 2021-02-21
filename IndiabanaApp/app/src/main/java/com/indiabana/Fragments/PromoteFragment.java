package com.indiabana.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.PromoteFragmentRvAdapter;
import com.indiabana.Data.PromotePublicationRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class PromoteFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private View rootView;
    private RecyclerView promotePublicationsRv;

    public PromoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_promote, container, false);
        initViews();
        demoRvSetUp();

        View iconView = getActivity().findViewById(R.id.icon);
        iconView.setOnClickListener(this);

        return rootView;
    }

    private void initViews() {
        promotePublicationsRv = rootView.findViewById(R.id.promotes_rv);
    }

    public void demoRvSetUp() {
        ArrayList<PromotePublicationRvItem> promotePublicationRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            promotePublicationRvItemArrayList.add(new PromotePublicationRvItem(R.drawable.demo_promote_rv_item_img, "SmartWatch Motorola, con correa nueva, bluetooth, protector de vidrio templad...", "$. 5,263.35", "Standard publication"));
            Log.d("Rv:", "" + i);
        }
        PromoteFragmentRvAdapter promoteFragmentRvAdapter = new PromoteFragmentRvAdapter(getContext(), promotePublicationRvItemArrayList);
        promotePublicationsRv.setAdapter(promoteFragmentRvAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return menuItem.getItemId() == R.id.menu;
    }
}