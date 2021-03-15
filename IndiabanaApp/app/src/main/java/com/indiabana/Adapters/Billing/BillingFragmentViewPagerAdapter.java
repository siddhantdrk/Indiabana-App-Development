package com.indiabana.Adapters.Billing;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.Billing.AddNewBankFragment;
import com.indiabana.Fragments.Billing.AddNewCardPaymentFragment;

public class BillingFragmentViewPagerAdapter extends FragmentStateAdapter {

    public BillingFragmentViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AddNewCardPaymentFragment();
                break;
            case 1:
                fragment = new AddNewBankFragment();
                break;
        }
        Log.d("Fragment: ", fragment.toString());
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
