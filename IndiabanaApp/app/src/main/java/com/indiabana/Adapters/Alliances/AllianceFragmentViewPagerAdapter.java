package com.indiabana.Adapters.Alliances;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.Alliances.AllianceFragmentCommitments;
import com.indiabana.Fragments.Alliances.MyAlliancesFragment;
import com.indiabana.Fragments.Alliances.PotentialAlliancesFragment;
import com.indiabana.Fragments.Alliances.RequestsFragment;

public class AllianceFragmentViewPagerAdapter extends FragmentStateAdapter {

    public AllianceFragmentViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AllianceFragmentCommitments();
                break;
            case 1:
                fragment = new MyAlliancesFragment();
                break;
            case 2:
                fragment = new RequestsFragment();
                break;
            case 3:
                fragment = new PotentialAlliancesFragment();
                break;
        }
        Log.d("Fragment: ", fragment.toString());
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
