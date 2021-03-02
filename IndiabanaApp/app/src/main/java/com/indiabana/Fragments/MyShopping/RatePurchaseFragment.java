package com.indiabana.Fragments.MyShopping;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.indiabana.Activities.RatePurchase.BuyerOrderProblem;
import com.indiabana.Activities.RatePurchase.RateOrderActivity;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatePurchaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatePurchaseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RatePurchaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RatePurchaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RatePurchaseFragment newInstance(String param1, String param2) {
        RatePurchaseFragment fragment = new RatePurchaseFragment();
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
        return inflater.inflate(R.layout.fragment_rate_purchase, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.rate_purchase);

        ((RadioButton) view.findViewById(R.id.rb_package_fine)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    getActivity().startActivity(new Intent(getContext(), RateOrderActivity.class));
                    ((RadioButton) view.findViewById(R.id.rb_package_fine)).setChecked(false);
                }
            }
        });

        ((RadioButton) view.findViewById(R.id.rb_problem_with_package)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    getActivity().startActivity(new Intent(getContext(), BuyerOrderProblem.class));
                    ((RadioButton) view.findViewById(R.id.rb_problem_with_package)).setChecked(false);
                }
            }
        });
    }
}