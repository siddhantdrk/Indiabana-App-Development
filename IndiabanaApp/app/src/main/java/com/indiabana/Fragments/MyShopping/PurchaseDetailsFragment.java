package com.indiabana.Fragments.MyShopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.indiabana.Activities.MainActivity;
import com.indiabana.Fragments.PromoteDetailsFragment;
import com.indiabana.R;
import com.indiabana.Utility.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PurchaseDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PurchaseDetailsFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PurchaseDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PurchaseDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PurchaseDetailsFragment newInstance(String param1, String param2) {
        PurchaseDetailsFragment fragment = new PurchaseDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_purchase_details, container, false);

        ImageView menuIcon = getActivity().findViewById(R.id.icon);
        menuIcon.setImageResource(R.drawable.menu);
        menuIcon.setVisibility(View.VISIBLE);
        menuIcon.setOnClickListener(this);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.purchase_details);

        view.findViewById(R.id.order_detail_IHavePackage).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.item_menu);
                popupMenu.show();
                break;

            case R.id.order_detail_IHavePackage:
                Util.replaceFragment(new RatePurchaseFragment(), (MainActivity) getActivity(), R.id.fragment_container_main);
//((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new RatePurchaseFragment()).addToBackStack(RatePurchaseFragment.class.getSimpleName()).commit();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}