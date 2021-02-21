package com.indiabana.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.Alliances.AllianceRequestPagerAdapter;
import com.indiabana.R;

public class PotentialAlliancesItemActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager;
    TabLayout tabLayout;
    AllianceRequestPagerAdapter adapter;
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potential_alliances_item);

//        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view);
//
//        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
//            if (scrollY > 100) {
//                findViewById(R.id.imageView).setVisibility(View.GONE);
//            } else if (scrollY <100){
//                findViewById(R.id.imageView).setVisibility(View.VISIBLE);
//            }
//        });

        backIcon = findViewById(R.id.nav_icon);
        backIcon.setOnClickListener(this);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        adapter = new AllianceRequestPagerAdapter(this);
        viewPager.setAdapter(adapter);

        String[] array = {getString(R.string.products), getString(R.string.Comments), getString(R.string.operations)};
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(array[position]);
            }
        }).attach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nav_icon:
                finish();
            break;
        }
    }
}