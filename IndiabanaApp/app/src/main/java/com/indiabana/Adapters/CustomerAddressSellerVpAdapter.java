package com.indiabana.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.CustomerAddressSeller.OtroFragment;
import com.indiabana.Fragments.CustomerAddressSeller.iCarryFragment;

public class CustomerAddressSellerVpAdapter extends FragmentStateAdapter {

    public CustomerAddressSellerVpAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new iCarryFragment();
        } else {
            return new OtroFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
