package com.indiabana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.indiabana.Adapters.FavouritesRvAdapter;
import com.indiabana.Adapters.MainFilterRecyclerAdapter;
import com.indiabana.Data.FavouritesRvItem;
import com.indiabana.Data.ListItem;
import com.indiabana.R;
import com.indiabana.databinding.FragmentFavouritesBinding;
import com.reim.android.filterrecyclerview.FilterRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class    FavouritesFragment extends Fragment implements View.OnClickListener {

    FragmentFavouritesBinding favouritesBinding;
    FilterRecyclerView filterView;

    public FavouritesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        favouritesBinding = FragmentFavouritesBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        setUpRv();

        // Hamza Aftab
        View iconView = getActivity().findViewById(R.id.icon);
        filterView = getActivity().findViewById(R.id.filter_search_recycler_view);
        iconView.setOnClickListener(this);

        return favouritesBinding.getRoot();
    }

    private void setUpRv() {
        favouritesBinding.itemRv.setAdapter(new FavouritesRvAdapter(getContext(), getFavouriteData()));
        favouritesBinding.itemRv.hasFixedSize();
        favouritesBinding.itemRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private List<FavouritesRvItem> getFavouriteData() {
        ArrayList<FavouritesRvItem> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(new FavouritesRvItem(R.drawable.demo_fav_mobile_img, "Nuevo", "Apple AirPods with Charging Case (Lasted...", "3hrs aprox.", "1,522.33"));
        }
        return dataList;
    }

    @Override
    public void onClick(View view) {

        // Hamza Aftab
        switch (view.getId()) {
            case R.id.icon:

                filterView.open(true);
                filterView.setAdapter(new MainFilterRecyclerAdapter(getActivity()));

                List<ListItem> itemList = new ArrayList<>();
                itemList.add(new ListItem("Iphone XR"));
                itemList.add(new ListItem("Iphone protector de pantalla"));
                itemList.add(new ListItem("Iphone 8 plus"));
                itemList.add(new ListItem("Iphone 5s"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));

                filterView.initializeItemList(itemList);
                break;
        }

    }
}