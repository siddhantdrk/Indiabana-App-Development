package com.indiabana.Fragments.MyShopping;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RateDeliveryBuyerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RateDeliveryBuyerFragment extends Fragment implements PopupMenu.OnMenuItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RateDeliveryBuyerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RateDeliveryBuyerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RateDeliveryBuyerFragment newInstance(String param1, String param2) {
        RateDeliveryBuyerFragment fragment = new RateDeliveryBuyerFragment();
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
        return inflater.inflate(R.layout.rate_delivery_buyer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View viewRoot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewRoot, savedInstanceState);

        viewRoot.findViewById(R.id.btn_rate_delivery).setOnClickListener(view -> {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            ReviewPostedDialog editNameDialogFragment = new ReviewPostedDialog();
            editNameDialogFragment.show(fm, "ReviewPostedDialog");
        });

        ImageView menuIcon = getActivity().findViewById(R.id.icon);
        menuIcon.setVisibility(View.GONE);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}