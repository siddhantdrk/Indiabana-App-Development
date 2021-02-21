package com.indiabana.Fragments.Cart;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.indiabana.Adapters.CartRvAdapter;
import com.indiabana.Data.CartRvItem;
import com.indiabana.R;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView cartItemsRv;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View parentView;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentView =  inflater.inflate(R.layout.fragment_cart, container, false);

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

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.add_cart_fragment_container, new ShippingAddressFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id. cart_continue_btn:

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
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}