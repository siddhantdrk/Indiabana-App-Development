package com.indiabana.Fragments.Billing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.Billing.BillingFragmentViewPagerAdapter;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewPaymentBankOrBankAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewPaymentBankOrBankAccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView iconView;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    BillingFragmentViewPagerAdapter adapter;

    public NewPaymentBankOrBankAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewPaymentBankOrBankAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewPaymentBankOrBankAccountFragment newInstance(String param1, String param2) {
        NewPaymentBankOrBankAccountFragment fragment = new NewPaymentBankOrBankAccountFragment();
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
        return inflater.inflate(R.layout.fragment_new_payment_bank_or_bank_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.settings);

        ImageView iconView = getActivity().findViewById(R.id.icon);
        iconView.setImageResource(R.drawable.ic_mdi_search);

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        adapter = new BillingFragmentViewPagerAdapter(this);
        viewPager.setAdapter(adapter);


        String[] array = {getString(R.string.card), getString(R.string.bank)};
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(array[position])).attach();

    }
}