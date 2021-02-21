package com.indiabana.Fragments.Alliances;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.Alliances.AllianceFragmentViewPagerAdapter;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlliancesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlliancesFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    boolean status = true;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView iconView;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    AllianceFragmentViewPagerAdapter adapter;
    public AlliancesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlliancesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlliancesFragment newInstance(String param1, String param2) {
        AlliancesFragment fragment = new AlliancesFragment();
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
        View view = inflater.inflate(R.layout.fragment_alliances, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        adapter = new AllianceFragmentViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        //Hamza Aftab
        iconView = getActivity().findViewById(R.id.icon);
        iconView.setImageResource(R.drawable.ic_sort);
        iconView.setOnClickListener(this);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.alliances);

        String[] array = {getString(R.string.commitments), getString(R.string.my_alliances), getString(R.string.requests), getString(R.string.potential_alliances)};
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(array[position]);
                    }
                }).attach();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                if (status) {
                    iconView.setImageResource(R.drawable.ic_login_delete);
                    getActivity().findViewById(R.id.horizontalScrollView).setVisibility(View.VISIBLE);
                    status = false;
                } else {
                    iconView.setImageResource(R.drawable.ic_sort);
                    getActivity().findViewById(R.id.horizontalScrollView).setVisibility(View.GONE);
                    status = true;
                }
                break;
        }
    }
}