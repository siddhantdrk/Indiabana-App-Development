package com.indiabana.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.indiabana.Activities.AddProduct.AddProductActivity;
import com.indiabana.Fragments.Alliances.AlliancesFragment;
import com.indiabana.Fragments.Billing.BillingFragment;
import com.indiabana.Fragments.Cart.HomeCartFragment;
import com.indiabana.Fragments.FavouritesFragment;
import com.indiabana.Fragments.HelpFragment;
import com.indiabana.Fragments.HomeFragment;
import com.indiabana.Fragments.MyAccountFragment;
import com.indiabana.Fragments.MySales.MySalesFragment;
import com.indiabana.Fragments.MyShopping.MyShoppingFragment;
import com.indiabana.Fragments.NotificationFragment;
import com.indiabana.Fragments.PromoteFragment;
import com.indiabana.Fragments.Question.QuestionFragment;
import com.indiabana.Fragments.SettingsFragment;
import com.indiabana.R;
import com.indiabana.Utility.Util;
import com.reim.android.filterrecyclerview.FilterRecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RESULT_CODE = 101;
    boolean home = true;
    private TextView toolbarText;
    private ImageView navIcon;
    private ImageView secondaryIcon;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private MaterialButton home_btn, question_btn, my_shopping_btn, my_sales_btn, alliance_btn, to_post_btn, billing_btn, settings_btn, account_btn, help_btn, advertise_btn, info_btn, about_btn, rate_btn;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private FilterRecyclerView filterRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        findViewById(R.id.tv_cancel).setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.bottom_nav_home:
                    home = true;
                    toolbarText.setText("INDIABANA");
                    findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, fragment).commit();
                    break;
                case R.id.bottom_nav_notification:
                    toolbarText.setText(getResources().getString(R.string.notification));
                    home = false;
                    fragment = new NotificationFragment();
                    secondaryIcon.setImageResource(R.drawable.ic_sort);
                    findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, fragment).commit();
                    break;
                case R.id.bottom_nav_like:
                    home = false;
                    toolbarText.setText("INDIABANA");
                    fragment = new FavouritesFragment();
                    findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, fragment).commit();
                    break;
                case R.id.bottom_nav_cart:
                    home = false;
                    findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                    Util.replaceFragment(new HomeCartFragment(), MainActivity.this, R.id.fragment_full_container_main);
                    showFullScreenFragmentLayout();
 /*Intent intent = new Intent(MainActivity.this, HomeCartFragment.class);
                    startActivityForResult(intent, RESULT_CODE);*/
                    break;
            }
            return true;
        });

        navIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START, true);
            }
        });

    }

    private void initViews() {
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout_main);
        toolbarText = findViewById(R.id.text);
        navIcon = findViewById(R.id.nav_icon);
        secondaryIcon = findViewById(R.id.icon);
        filterRecyclerView = findViewById(R.id.filter_search_recycler_view);
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(this);
        question_btn = findViewById(R.id.ques_btn);
        question_btn.setOnClickListener(this);
        my_shopping_btn = findViewById(R.id.my_shopping_btn);
        my_shopping_btn.setOnClickListener(this);
        my_sales_btn = findViewById(R.id.my_sales_btn);
        my_sales_btn.setOnClickListener(this);
        alliance_btn = findViewById(R.id.alliances_btn);
        alliance_btn.setOnClickListener(this);
        to_post_btn = findViewById(R.id.to_post_btn);
        to_post_btn.setOnClickListener(this);
        billing_btn = findViewById(R.id.billing_btn);
        billing_btn.setOnClickListener(this);
        settings_btn = findViewById(R.id.setings_btn);
        settings_btn.setOnClickListener(this);
        account_btn = findViewById(R.id.account_btn);
        account_btn.setOnClickListener(this);
        help_btn = findViewById(R.id.help_btn);
        help_btn.setOnClickListener(this);
        advertise_btn = findViewById(R.id.advertise_btn);
        advertise_btn.setOnClickListener(this);
        info_btn = findViewById(R.id.how_work_btn);
        info_btn.setOnClickListener(this);
        about_btn = findViewById(R.id.about_btn);
        about_btn.setOnClickListener(this);
        rate_btn = findViewById(R.id.rate_btn);
        rate_btn.setOnClickListener(this);
        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        toolbar = findViewById(R.id.toolbar);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_btn:
                home = true;
                toolbarText.setText("INDIABANA");
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new HomeFragment()).commit();
                break;
            case R.id.ques_btn:
                home = false;
                toolbarText.setText(getString(R.string.questions));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new QuestionFragment()).commit();
                break;
            case R.id.my_shopping_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new MyShoppingFragment()).commit();
                break;
            case R.id.my_sales_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new MySalesFragment()).commit();
                break;
            case R.id.alliances_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new AlliancesFragment()).commit();
                break;
            case R.id.to_post_btn:
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, AddProductActivity.class));
                break;
            case R.id.billing_btn:
                home = false;
                toolbarText.setText(getString(R.string.billing));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_sort);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new BillingFragment()).commit();
                break;
            case R.id.setings_btn:
                home = false;
                toolbarText.setText(getString(R.string.settings));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new SettingsFragment()).commit();
                break;
            case R.id.account_btn:
                home = false;
                toolbarText.setText(getString(R.string.my_account));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new MyAccountFragment()).commit();
                break;
            case R.id.help_btn:
                home = false;
                toolbarText.setText(getString(R.string.help));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new HelpFragment()).commit();
                break;
            case R.id.advertise_btn:
                home = false;
                toolbarText.setText(getString(R.string.promote));
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.menu);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new PromoteFragment()).commit();
                break;
            case R.id.how_work_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new HomeFragment()).commit();
                break;
            case R.id.about_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new HomeFragment()).commit();
                break;
            case R.id.rate_btn:
                home = false;
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new HomeFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START, true);
    }

    public void transaction(Fragment fragment) {
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        findViewById(R.id.tv_cancel).setVisibility(View.GONE);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (filterRecyclerView.isOpened()) {
            filterRecyclerView.close();
        } else if (findViewById(R.id.search_text_card).getVisibility() == View.VISIBLE) {
            findViewById(R.id.search_text_card).setVisibility(View.GONE);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            hideFullScreenFragmentLayout();
            getSupportFragmentManager().popBackStack();
        } else if (home) {
            super.onBackPressed();
        } else {
            hideFullScreenFragmentLayout();
            transaction(new HomeFragment());
            bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
            toolbarText.setText("INDIABANA");
            secondaryIcon.setVisibility(View.VISIBLE);
            findViewById(R.id.tv_cancel).setVisibility(View.GONE);
            secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
                toolbarText.setText("INDIABANA");
                secondaryIcon.setVisibility(View.VISIBLE);
                findViewById(R.id.tv_cancel).setVisibility(View.GONE);
                secondaryIcon.setImageResource(R.drawable.ic_mdi_search);
            }
        }
    }

    public void showFullScreenFragmentLayout() {
        findViewById(R.id.tv_cancel).setVisibility(View.GONE);
        findViewById(R.id.fragment_full_container_main).setVisibility(View.VISIBLE);

        findViewById(R.id.fragment_container_main).setVisibility(View.GONE);
        findViewById(R.id.bottom_nav_main).setVisibility(View.GONE);
        findViewById(R.id.toolbar).setVisibility(View.GONE);
    }


    public void hideFullScreenFragmentLayout() {
        findViewById(R.id.tv_cancel).setVisibility(View.GONE);
        findViewById(R.id.fragment_full_container_main).setVisibility(View.GONE);

        findViewById(R.id.fragment_container_main).setVisibility(View.VISIBLE);
        findViewById(R.id.bottom_nav_main).setVisibility(View.VISIBLE);
        findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
    }
}