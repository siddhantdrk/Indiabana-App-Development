package com.indiabana.Fragments;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indiabana.Adapters.FavouritesRvAdapter;
import com.indiabana.Adapters.TechnologyTopRvAdapter;
import com.indiabana.Data.FavouritesRvItem;
import com.indiabana.Data.TechnologyRvItem;
import com.indiabana.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TechnologyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TechnologyFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView bottomRecyclerview;
    RecyclerView topRecyclerview;
    boolean status = false;
    TextView filterTv;
    View parentView;

    public TechnologyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TechnologyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TechnologyFragment newInstance(String param1, String param2) {
        TechnologyFragment fragment = new TechnologyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentView = inflater.inflate(R.layout.fragment_technology, container, false);

        setUpRv(parentView);

        filterTv = parentView.findViewById(R.id.filter_icon);
        filterTv.setOnClickListener(this);

        getActivity().findViewById(R.id.icon).setOnClickListener(this);

        return  parentView;
    }

    private void setUpRv(View view) {
        bottomRecyclerview = view.findViewById(R.id.technology_vertical_rv);
        bottomRecyclerview.setAdapter(new FavouritesRvAdapter(getContext(), getFavouriteData()));
        bottomRecyclerview.setHasFixedSize(true);
        bottomRecyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));

        topRecyclerview = view.findViewById(R.id.technology_horizontal_rv);
        topRecyclerview.setAdapter(new TechnologyTopRvAdapter(getContext(), getTechnologyTopRvData()));
        topRecyclerview.setHasFixedSize(true);
        topRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    private List<FavouritesRvItem> getFavouriteData() {
        ArrayList<FavouritesRvItem> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(new FavouritesRvItem(R.drawable.demo_fav_mobile_img, "Nuevo", "Apple AirPods with Charging Case (Lasted...", "3hrs aprox.", "1,522.33"));
        }
        return dataList;
    }

    private List<TechnologyRvItem> getTechnologyTopRvData() {
        ArrayList<TechnologyRvItem> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add(new TechnologyRvItem(R.drawable.phones));
        }
        return dataList;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.icon:
                getActivity().findViewById(R.id.search_text_card).setVisibility(View.VISIBLE);
                break;
            case R.id.filter_icon:
                if (status == false) {
                    filterTv.setText("Close");
                    filterTv.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.mdi_close),null);
                    filterTv.setCompoundDrawableTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                    parentView.findViewById(R.id.horizontalScrollView).setVisibility(View.VISIBLE);
                    status = true;
                }else {
                    filterTv.setText("Filter");
                    filterTv.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.ic_sort),null);
                    parentView.findViewById(R.id.horizontalScrollView).setVisibility(View.GONE);
                    status = false;
                }
                break;
        }
    }
}