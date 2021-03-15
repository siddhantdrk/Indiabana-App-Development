package com.indiabana.Fragments.Billing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.indiabana.Activities.MainActivity;
import com.indiabana.Fragments.MyShopping.RatePurchaseFragment;
import com.indiabana.Fragments.MyShopping.ReviewPostedDialog;
import com.indiabana.R;
import com.indiabana.Utility.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WithdrawOperationSellerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WithdrawOperationSellerFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WithdrawOperationSellerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WithdrawOperationSellerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WithdrawOperationSellerFragment newInstance(String param1, String param2) {
        WithdrawOperationSellerFragment fragment = new WithdrawOperationSellerFragment();
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
        return inflater.inflate(R.layout.fragment_withdraw_operation_seller, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View viewRoot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewRoot, savedInstanceState);

        ImageView menuIcon = getActivity().findViewById(R.id.icon);
        menuIcon.setImageResource(R.drawable.menu);
        menuIcon.setVisibility(View.VISIBLE);
        menuIcon.setOnClickListener(this);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.start_withdrawal);

        viewRoot.findViewById(R.id.cart_view_add_card_btn).setOnClickListener(view -> {
            showModalBankSecurityDialog();
        });
    }

    private void showModalBankSecurityDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        ModalBankSecurityDialog editNameDialogFragment = new ModalBankSecurityDialog();
        editNameDialogFragment.show(fm, "ReviewPostedDialog");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.inflate(R.menu.item_menu);
                popupMenu.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}