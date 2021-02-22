package com.indiabana.Fragments.Inventory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.indiabana.Activities.AddProduct.AddProductActivity;
import com.indiabana.Adapters.InventoryFragmentRvAdapter;
import com.indiabana.Data.InventoryRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class InventoryFragment extends Fragment implements View.OnClickListener, OpenNextFragmentFromAdapter {
    private View rootView;
    private RecyclerView inventoryRv;
    private RelativeLayout header_layout;

    public InventoryFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_inventory, container, false);
        initViews();
        demoRvSetUp();

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.inventory);
        ImageView nav_icon = getActivity().findViewById(R.id.nav_icon);
        nav_icon.setVisibility(View.VISIBLE);
        ImageView back_icon = getActivity().findViewById(R.id.back_icon);
        back_icon.setVisibility(View.GONE);
        ImageView iconView = getActivity().findViewById(R.id.icon);
        iconView.setImageResource(R.drawable.ic_white_plus);
        iconView.setOnClickListener(this);
        return rootView;
    }

    private void initViews() {
        inventoryRv = rootView.findViewById(R.id.inventory_rv);
        header_layout = rootView.findViewById(R.id.header_layout);
//        header_layout.setVisibility(View.VISIBLE);
    }

    public void demoRvSetUp() {
        ArrayList<InventoryRvItem> inventoryRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inventoryRvItemArrayList.add(new InventoryRvItem(R.drawable.demo_promote_rv_item_img, "SmartWatch Motorola, con correa nueva, bluetooth, protector de vidrio templad...", "$. 5,263.35", "Standard publication"));
            Log.d("Rv:", "" + i);
        }
        InventoryFragmentRvAdapter inventoryFragmentRvAdapter = new InventoryFragmentRvAdapter(getContext(), inventoryRvItemArrayList, this);
        inventoryRv.setAdapter(inventoryFragmentRvAdapter);
        inventoryRv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                header_layout.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                startActivity(new Intent(getActivity(), AddProductActivity.class));
                break;
        }
    }

    @Override
    public void callback() {
        //startActivity(new Intent(getActivity(), InventoryDetailsActivity.class));
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new InventoryDetailsFragment())
                .addToBackStack(null).commit();
    }
}
