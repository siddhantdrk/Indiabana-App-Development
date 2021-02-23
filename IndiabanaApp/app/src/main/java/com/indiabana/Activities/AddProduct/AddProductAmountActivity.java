package com.indiabana.Activities.AddProduct;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.indiabana.Adapters.AddProductAmountActivityRvAdapter;
import com.indiabana.Data.ProductAmountRvItem;
import com.indiabana.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AddProductAmountActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private RecyclerView productiamgeRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_amount);
        View backIcon = findViewById(R.id.to_post_activity_back_arrow);
        backIcon.setOnClickListener(this);
        View iconView = findViewById(R.id.icon);
        iconView.setOnClickListener(this);
        productiamgeRv = findViewById(R.id.productiamge_rv);
        demoRvSetUp();
    }

    public void demoRvSetUp() {
        ArrayList<ProductAmountRvItem> productAmountRvItemArrayList = new ArrayList<>();
        productAmountRvItemArrayList.add(new ProductAmountRvItem(R.drawable.rectangle_104));
        productAmountRvItemArrayList.add(new ProductAmountRvItem(R.drawable.rectangle_101));
        productAmountRvItemArrayList.add(new ProductAmountRvItem(0));
        productAmountRvItemArrayList.add(new ProductAmountRvItem(0));
        productAmountRvItemArrayList.add(new ProductAmountRvItem(0));
        AddProductAmountActivityRvAdapter addProductAmountActivityRvAdapter = new AddProductAmountActivityRvAdapter(AddProductAmountActivity.this, productAmountRvItemArrayList);
        productiamgeRv.setAdapter(addProductAmountActivityRvAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(AddProductAmountActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AddProductAmountActivity.this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
            case R.id.to_post_activity_back_arrow:
                finish();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
