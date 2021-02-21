package com.indiabana.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.indiabana.Adapters.HomeScreenCategoriesRVAdapter;
import com.indiabana.Adapters.HomeScreenRecommendedRVAdapter;
import com.indiabana.Adapters.HomeScreenVendorsRVAdapter;
import com.indiabana.Adapters.MainFilterRecyclerAdapter;
import com.indiabana.Data.CategoriesRVItem;
import com.indiabana.Data.FeaturedSellersRVItem;
import com.indiabana.Data.ListItem;
import com.indiabana.Data.RecommendedRVItem;
import com.indiabana.R;
import com.reim.android.filterrecyclerview.FilterRecyclerView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FilterRecyclerView filterView;
    CarouselView carouselView;
    RecyclerView recommendedRecyclerView, homeApplianceRecyclerView, consolesRecyclerView, categoriesRecyclerView, vendorRecyclerView;
    ArrayList<RecommendedRVItem> recommendedRVListArrayItem = new ArrayList<>();
    ArrayList<CategoriesRVItem> categoriesRVItems = new ArrayList<>();
    ArrayList<FeaturedSellersRVItem> featuredSellersRVItems = new ArrayList<>();

    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));
        recommendedRVListArrayItem.add(new RecommendedRVItem("1", "a", "a", "a", "a"));

        HomeScreenRecommendedRVAdapter adapter = new HomeScreenRecommendedRVAdapter(recommendedRVListArrayItem);

        recommendedRecyclerView = view.findViewById(R.id.recommended_recycler_view);
        homeApplianceRecyclerView = view.findViewById(R.id.home_appliance_recycler_view);
        consolesRecyclerView = view.findViewById(R.id.consoles_recycler_view);
        categoriesRecyclerView = view.findViewById(R.id.categories_recycler_view);
        vendorRecyclerView = view.findViewById(R.id.featured_sellers_recycler_view);

        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));
        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));
        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));
        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));
        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));
        categoriesRVItems.add(new CategoriesRVItem("1", "", ""));


        HomeScreenCategoriesRVAdapter adapter1 = new HomeScreenCategoriesRVAdapter(categoriesRVItems);
        categoriesRecyclerView.setAdapter(adapter1);

        featuredSellersRVItems.add(new FeaturedSellersRVItem("1", "", "", ""));
        featuredSellersRVItems.add(new FeaturedSellersRVItem("1", "", "", ""));
        //featuredSellersRVItems.add(new FeaturedSellersRVItem("1","","",""));


        HomeScreenVendorsRVAdapter adapter2 = new HomeScreenVendorsRVAdapter(featuredSellersRVItems);
        vendorRecyclerView.setAdapter(adapter2);


        consolesRecyclerView.setAdapter(adapter);
        homeApplianceRecyclerView.setAdapter(adapter);
        recommendedRecyclerView.setAdapter(adapter);


        // Hamza Aftab
        View iconView = getActivity().findViewById(R.id.icon);
        filterView = getActivity().findViewById(R.id.filter_search_recycler_view);
        iconView.setOnClickListener(this);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 3:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new TechnologyFragment()).addToBackStack(null)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

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