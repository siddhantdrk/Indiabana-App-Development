package com.indiabana.Fragments.AddProduct;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;

import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WhatAreYouSellingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WhatAreYouSellingFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WhatAreYouSellingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WhatAreYouSellingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WhatAreYouSellingFragment newInstance(String param1, String param2) {
        WhatAreYouSellingFragment fragment = new WhatAreYouSellingFragment();
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
        View view = inflater.inflate(R.layout.fragment_what_are_you_selling, container, false);
        View backIcon = getActivity().findViewById(R.id.to_post_activity_back_arrow);
        backIcon.setOnClickListener(this);
        View iconView = getActivity().findViewById(R.id.icon);
        iconView.setOnClickListener(this);
        view.findViewById(R.id.continue_btn).setOnClickListener(this);

        return view;
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
            case R.id.to_post_activity_back_arrow:
                getActivity().finish();
            case R.id.continue_btn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.add_product_fragment_container, new AddProductFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}