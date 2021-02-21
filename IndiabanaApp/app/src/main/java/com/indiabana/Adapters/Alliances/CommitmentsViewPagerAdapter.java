package com.indiabana.Adapters.Alliances;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.Alliances.CommentsFragment;
import com.indiabana.Fragments.Alliances.OperationsFragment;
import com.indiabana.Fragments.Alliances.ProductsFragment;

public class CommitmentsViewPagerAdapter extends FragmentStateAdapter {



    public CommitmentsViewPagerAdapter(@NonNull Fragment fragment) {
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
            case 2:
                fragment = new OperationsFragment();
                break;
        }
        Log.d("Fragment: ", fragment.toString());
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
