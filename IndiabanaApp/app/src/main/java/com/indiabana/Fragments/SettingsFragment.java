package com.indiabana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.indiabana.Adapters.MainFilterRecyclerAdapter;
import com.indiabana.Data.ListItem;
import com.indiabana.R;
import com.reim.android.filterrecyclerview.FilterRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FilterRecyclerView filterView;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Hamza Aftab
        View iconView = getActivity().findViewById(R.id.icon);
        filterView = getActivity().findViewById(R.id.filter_search_recycler_view);
        iconView.setOnClickListener(this);

        return view;
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