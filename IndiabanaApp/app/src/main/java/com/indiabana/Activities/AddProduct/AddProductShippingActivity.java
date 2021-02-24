package com.indiabana.Activities.AddProduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;
import com.indiabana.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddProductShippingActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private MaterialButton continue_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_shipping);
        View backIcon = findViewById(R.id.to_post_activity_back_arrow);
        backIcon.setOnClickListener(this);
        View iconView = findViewById(R.id.icon);
        iconView.setOnClickListener(this);
        continue_btn = findViewById(R.id.continue_btn);
        continue_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(AddProductShippingActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AddProductShippingActivity.this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
            case R.id.to_post_activity_back_arrow:
                finish();
                break;
            case R.id.continue_btn:
                startActivity(new Intent(AddProductShippingActivity.this, AddProductPriceActivity.class));
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
