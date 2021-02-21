package com.indiabana.Activities.AddProduct;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.indiabana.Fragments.AddProduct.WhatAreYouSellingFragment;
import com.indiabana.R;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        getSupportFragmentManager().beginTransaction().add(R.id.add_product_fragment_container, new WhatAreYouSellingFragment()).commit();
    }
}