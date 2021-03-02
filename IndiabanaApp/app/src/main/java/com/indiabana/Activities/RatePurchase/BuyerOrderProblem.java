package com.indiabana.Activities.RatePurchase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.indiabana.R;

public class BuyerOrderProblem extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_order_problem);

        findViewById(R.id.to_post_activity_back_arrow).setOnClickListener(view -> finish());

        findViewById(R.id.icon).setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(BuyerOrderProblem.this, view);
            popupMenu.setOnMenuItemClickListener(BuyerOrderProblem.this);
            popupMenu.inflate(R.menu.item_menu);
            popupMenu.show();
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}