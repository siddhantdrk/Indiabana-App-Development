package com.indiabana.Fragments.MyShopping;

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

import com.indiabana.Activities.MainActivity;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatePurchaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatePurchaseFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RatePurchaseFragment() {

    }

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
                    ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_full_container_main, new RateOrderFragment()).addToBackStack(RateOrderFragment.class.getSimpleName()).commit();
                    /* getActivity().startActivity(new Intent(getContext(), RateOrderActivity.class));*/
                    ((RadioButton) view.findViewById(R.id.rb_package_fine)).setChecked(false);
                    ((MainActivity) getActivity()).showFullScreenFragmentLayout();
                }
            }
        });

        ((RadioButton) view.findViewById(R.id.rb_problem_with_package)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_full_container_main, new BuyerOrderProblemFragment()).addToBackStack(BuyerOrderProblemFragment.class.getSimpleName()).commit();
                    ((RadioButton) view.findViewById(R.id.rb_problem_with_package)).setChecked(false);
                    ((MainActivity) getActivity()).showFullScreenFragmentLayout();
                }
            }
        });
    }
}