package com.indiabana.Fragments.Cart;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShippingAddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShippingAddressFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MaterialCardView addressOne;
    MaterialCardView addressTwo;
    ImageView iconOne;
    ImageView iconTwo;

    public ShippingAddressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShippingAddressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShippingAddressFragment newInstance(String param1, String param2) {
        ShippingAddressFragment fragment = new ShippingAddressFragment();
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
        View view = inflater.inflate(R.layout.fragment_shipping_address, container, false);

        addressOne = view.findViewById(R.id.shipping_address_material_card_address_one);
        iconOne = view.findViewById(R.id.shipping_address_iv_location_one);
        addressTwo = view.findViewById(R.id.shipping_address_material_card_address_two);
        iconTwo = view.findViewById(R.id.shipping_address_iv_location_two);

        view.findViewById(R.id.address_one).setOnClickListener(this);
        view.findViewById(R.id.address_two).setOnClickListener(this);

        return view;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.address_one:

                addressOne.setStrokeColor(getResources().getColor(R.color.indiabana_orange));
                addressTwo.setStrokeColor(getResources().getColor(R.color.GrayBorderStroke));

                iconOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.indiabana_orange)));
                iconTwo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                break;
            case R.id.address_two:

                addressOne.setStrokeColor(getResources().getColor(R.color.GrayBorderStroke));
                addressTwo.setStrokeColor(getResources().getColor(R.color.indiabana_orange));

                iconOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                iconTwo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.indiabana_orange)));
                break;
        }
    }
}