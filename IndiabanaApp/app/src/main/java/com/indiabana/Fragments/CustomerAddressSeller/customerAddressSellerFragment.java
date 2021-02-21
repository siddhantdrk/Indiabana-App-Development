package com.indiabana.Fragments.CustomerAddressSeller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.CustomerAddressSellerVpAdapter;
import com.indiabana.R;
import com.indiabana.databinding.FragmentCustomerAddressSellerBinding;

public class customerAddressSellerFragment extends Fragment {
    FragmentCustomerAddressSellerBinding customerAddressSellerBinding;

    public customerAddressSellerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customerAddressSellerBinding = FragmentCustomerAddressSellerBinding.inflate(inflater, container, false);
        setUpViewPager();
        return customerAddressSellerBinding.getRoot();
    }

    private void setUpViewPager() {
        customerAddressSellerBinding.addressDetailsVp2.setAdapter(new CustomerAddressSellerVpAdapter(this));
        new TabLayoutMediator(customerAddressSellerBinding.tabLayout, customerAddressSellerBinding.addressDetailsVp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText(getResources().getString(R.string.icarry));
                } else {
                    tab.setText(getResources().getString(R.string.other));
                }
            }
        }).attach();
    }
}