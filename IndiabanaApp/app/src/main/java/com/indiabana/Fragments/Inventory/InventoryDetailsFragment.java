package com.indiabana.Fragments.Inventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.indiabana.Activities.AddProduct.AddProductActivity;
import com.indiabana.Activities.AddProduct.AddProductAmountActivity;
import com.indiabana.Activities.AddProduct.AddProductPriceActivity;
import com.indiabana.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.fragment.app.Fragment;

public class InventoryDetailsFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.rectangle_23, R.drawable.rectangle_23, R.drawable.rectangle_23};

    public InventoryDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InventoryDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InventoryDetailsFragment newInstance(String param1, String param2) {
        InventoryDetailsFragment fragment = new InventoryDetailsFragment();
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

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
            case R.id.back_icon:
                getFragmentManager().popBackStackImmediate();
                break;
            case R.id.layout_name:
                startActivity(new Intent(getActivity(), AddProductActivity.class));
                break;
            case R.id.layout_price:
                startActivity(new Intent(getActivity(), AddProductPriceActivity.class));
                break;
            case R.id.layout_amount:
                startActivity(new Intent(getActivity(), AddProductAmountActivity.class));
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory_details, container, false);
        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.publication);
        ImageView nav_icon = getActivity().findViewById(R.id.nav_icon);
        nav_icon.setVisibility(View.GONE);
        ImageView back_icon = getActivity().findViewById(R.id.back_icon);
        back_icon.setVisibility(View.VISIBLE);
        back_icon.setOnClickListener(this);
        ImageView menuIcon = getActivity().findViewById(R.id.icon);
        menuIcon.setImageResource(R.drawable.menu);
        menuIcon.setOnClickListener(this);
        LinearLayout layout_name = view.findViewById(R.id.layout_name);
        layout_name.setOnClickListener(this);
        LinearLayout layout_price = view.findViewById(R.id.layout_price);
        layout_price.setOnClickListener(this);
        LinearLayout layout_amount = view.findViewById(R.id.layout_amount);
        layout_amount.setOnClickListener(this);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        return view;
    }
}
