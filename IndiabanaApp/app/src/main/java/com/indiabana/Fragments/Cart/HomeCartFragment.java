package com.indiabana.Fragments.Cart;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.indiabana.Activities.MainActivity;
import com.indiabana.Adapters.CartRvAdapter;
import com.indiabana.Data.CartRvItem;
import com.indiabana.R;
import com.indiabana.Utility.Util;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeCartFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    View parentView;
    RecyclerView cartItemsRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.activity_cart, container, false);

        parentView.findViewById(R.id.to_post_activity_back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                getActivity().setResult(RESULT_OK, intent);
                getActivity().onBackPressed();
                ((MainActivity) getActivity()).hideFullScreenFragmentLayout();
            }
        });

        View iconView = getActivity().findViewById(R.id.icon);
        iconView.setOnClickListener(this);
        setUpRv(parentView);

        //continue Button
        parentView.findViewById(R.id.cart_continue_btn).setOnClickListener(this);
        parentView.findViewById(R.id.cl_shipping_address).setOnClickListener(this);

        return parentView;
    }

    private void setUpRv(View view) {
        cartItemsRv = view.findViewById(R.id.cart_view_rv);
        cartItemsRv.setAdapter(new CartRvAdapter(getContext(), getCarteData()));
        cartItemsRv.hasFixedSize();
        cartItemsRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private List<CartRvItem> getCarteData() {
        ArrayList<CartRvItem> dataList = new ArrayList<>();

        dataList.add(new CartRvItem(R.drawable.demo_cart_item_img, "Samsung Samsung Galaxy A5 última generación liberado para cualquier...",
                "$. 21,253.33", "Qty:", "Yellow", "negro"));
        dataList.add(new CartRvItem(R.drawable.demo_cart_item_img, "Samsung Samsung Galaxy A5 última generación liberado para cualquier...",
                "$. 21,253.33", "Qty:", "Yellow", "negro"));

        return dataList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.show();
                break;
            case R.id.cl_shipping_address:
                ((MainActivity) getActivity()).showFullScreenFragmentLayout();
                Util.replaceFragment(new ShippingAddressFragment(), (MainActivity) getActivity(), R.id.fragment_full_container_main);
                break;
            case R.id.cart_continue_btn:
                if (parentView.findViewById(R.id.cart_view_ll_additional_views).getVisibility() == View.GONE) {
                    parentView.findViewById(R.id.cart_view_payment_method_below_tv).setVisibility(View.GONE);

                    TextView tvEditor = parentView.findViewById(R.id.cart_view_tv_editor);
                    tvEditor.setVisibility(View.VISIBLE);
                    tvEditor.setText(Html.fromHtml("<u>Editor</u>"));

                    MaterialCardView materialCardView = parentView.findViewById(R.id.cart_view_material_card_payment_method);
                    materialCardView.setStrokeWidth(1);
                    materialCardView.setStrokeColor(getResources().getColor(R.color.GrayBorderStroke));

                    parentView.findViewById(R.id.cart_view_material_card_add_new_card).setVisibility(View.GONE);

                    parentView.findViewById(R.id.cart_view_ll_additional_views).setVisibility(View.VISIBLE);

                    TextView tvQuestionOne = parentView.findViewById(R.id.cart_view_question_one);
                    tvQuestionOne.setVisibility(View.VISIBLE);
                    tvQuestionOne.setText(Html.fromHtml("<u>¿Qué es?</u>"));

                    TextView tvQuestionTwo = parentView.findViewById(R.id.cart_view_question_two);
                    tvQuestionTwo.setVisibility(View.VISIBLE);
                    tvQuestionTwo.setText(Html.fromHtml("<u>¿Qué es?</u>"));

                    parentView.findViewById(R.id.cart_view_card_iv).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                } else {
                    Util.replaceFragment(new OrderScuccessBuyerFragment(), (MainActivity) getActivity(), R.id.fragment_container_main);
                    ((MainActivity) getActivity()).hideFullScreenFragmentLayout();
                }
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

}