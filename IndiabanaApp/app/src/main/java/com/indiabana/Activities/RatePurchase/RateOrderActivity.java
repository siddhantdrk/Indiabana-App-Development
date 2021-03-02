package com.indiabana.Activities.RatePurchase;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.indiabana.Activities.MainActivity;
import com.indiabana.R;

public class RateOrderActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_purchase);

        findViewById(R.id.to_post_activity_back_arrow).setOnClickListener(view -> finish());

        findViewById(R.id.icon).setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(RateOrderActivity.this, view);
            popupMenu.setOnMenuItemClickListener(RateOrderActivity.this);
            popupMenu.inflate(R.menu.item_menu);
            popupMenu.show();
        });

        ((RadioButton) findViewById(R.id.rb_problem_with_package)).setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ((RadioButton) findViewById(R.id.rb_problem_with_package)).setChecked(false);
                ((RadioButton) findViewById(R.id.rb_package_fine)).setChecked(true);
                startActivity(new Intent(RateOrderActivity.this, BuyerOrderProblem.class));
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}