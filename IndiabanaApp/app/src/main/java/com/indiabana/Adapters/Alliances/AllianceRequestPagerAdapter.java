package com.indiabana.Adapters.Alliances;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.Alliances.CommentsFragment;
import com.indiabana.Fragments.Alliances.OperationsFragment;
import com.indiabana.Fragments.Alliances.ProductsFragment;

public class AllianceRequestPagerAdapter extends FragmentStateAdapter {

    public AllianceRequestPagerAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ProductsFragment();
                break;
            case 1:
                fragment = new CommentsFragment();
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
