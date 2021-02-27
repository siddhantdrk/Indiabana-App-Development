package com.indiabana.Adapters.questions;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.indiabana.Fragments.Question.BuyingFragment;
import com.indiabana.Fragments.Question.SellingFragment;

public class QuestionStateAdapter extends FragmentStateAdapter {
    public QuestionStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0)
            return new BuyingFragment();
        else
            return new SellingFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
