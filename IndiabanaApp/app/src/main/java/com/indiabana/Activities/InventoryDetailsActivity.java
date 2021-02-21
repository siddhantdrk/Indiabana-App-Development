package com.indiabana.Activities;

import android.os.Bundle;

import com.indiabana.Fragments.Inventory.InventoryDetailsFragment;
import com.indiabana.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InventoryDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
        getSupportFragmentManager().beginTransaction().add(R.id.add_product_fragment_container, new InventoryDetailsFragment()).commit();
    }
}
