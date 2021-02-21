package com.indiabana.Activities.AddProduct;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.indiabana.Adapters.AddProductPriceActivityRvAdapter;
import com.indiabana.Data.ProductPricePostTypeRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class AddProductPriceActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private RecyclerView posttypeRv;
    private MaterialButton cart_to_post_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_price);

        View backIcon = findViewById(R.id.to_post_activity_back_arrow);
        backIcon.setOnClickListener(this);
        View iconView = findViewById(R.id.icon);
        iconView.setOnClickListener(this);
        posttypeRv = findViewById(R.id.posttype_rv);
        demoRvSetUp();
        cart_to_post_btn = findViewById(R.id.cart_to_post_btn);
        cart_to_post_btn.setOnClickListener(this);
    }

    public void demoRvSetUp() {
        ArrayList<ProductPricePostTypeRvItem> productPricePostTypeRvItemsArrayList = new ArrayList<>();
        productPricePostTypeRvItemsArrayList.add(new ProductPricePostTypeRvItem(R.drawable.free_badge, getResources().getString(R.string.badge_name1), getResources().getString(R.string.duration1), getResources().getString(R.string.exposure1), getResources().getString(R.string.accumulate1), getResources().getString(R.string.stock1), getResources().getString(R.string.percent1), R.color.free_badge));
        productPricePostTypeRvItemsArrayList.add(new ProductPricePostTypeRvItem(R.drawable.standard_badge, getResources().getString(R.string.badge_name2), getResources().getString(R.string.duration2), getResources().getString(R.string.exposure2), getResources().getString(R.string.accumulate2), getResources().getString(R.string.stock2), getResources().getString(R.string.percent2), R.color.standard_badge));
        productPricePostTypeRvItemsArrayList.add(new ProductPricePostTypeRvItem(R.drawable.outstanding_badge, getResources().getString(R.string.badge_name3), getResources().getString(R.string.duration3), getResources().getString(R.string.exposure3), getResources().getString(R.string.accumulate3), getResources().getString(R.string.stock3), getResources().getString(R.string.percent3), R.color.outstanding_badge));
        productPricePostTypeRvItemsArrayList.add(new ProductPricePostTypeRvItem(R.drawable.gold_badge, getResources().getString(R.string.badge_name4), getResources().getString(R.string.duration4), getResources().getString(R.string.exposure4), getResources().getString(R.string.accumulate4), getResources().getString(R.string.stock4), getResources().getString(R.string.percent4), R.color.gold_badge));
        AddProductPriceActivityRvAdapter addProductPriceActivityRvAdapter = new AddProductPriceActivityRvAdapter(AddProductPriceActivity.this, productPricePostTypeRvItemsArrayList);
        posttypeRv.setAdapter(addProductPriceActivityRvAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(AddProductPriceActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AddProductPriceActivity.this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
            case R.id.to_post_activity_back_arrow:
                finish();
                break;
            case R.id.cart_to_post_btn:
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}