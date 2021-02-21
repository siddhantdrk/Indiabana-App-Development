package com.indiabana.Fragments.Alliances;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.Alliances.CommitmentsViewPagerAdapter;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllyProfileFragmentTemp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllyProfileFragmentTemp extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    CommitmentsViewPagerAdapter adapter;


    public AllyProfileFragmentTemp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllyProfileFragmentTemp.
     */
    // TODO: Rename and change types and number of parameters
    public static AllyProfileFragmentTemp newInstance(String param1, String param2) {
        AllyProfileFragmentTemp fragment = new AllyProfileFragmentTemp();
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
        View view = inflater.inflate(R.layout.fragment_ally_profile_temp, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        adapter = new CommitmentsViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        String[] array = {getString(R.string.products), getString(R.string.Comments), getString(R.string.operations)};
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(array[position]);
            }
        }).attach();

        return view;
    }
}