package com.indiabana.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.BillsFragmentRvAdapter;
import com.indiabana.Data.BillsRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.Fragments.MySales.SaleDetailsFragment;
import com.indiabana.R;

import java.util.ArrayList;

public class BillingFragment extends Fragment implements View.OnClickListener , OpenNextFragmentFromAdapter {
    private View rootView;
    private RecyclerView billsRv;
    boolean status = true;
    ImageView iconView;

    public BillingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_billing, container, false);
        initViews();
        demoRvSetUp();

        //Hamza Aftab
        iconView = getActivity().findViewById(R.id.icon);
        iconView.setOnClickListener(this);

        return rootView;
    }

    private void initViews() {
        billsRv = rootView.findViewById(R.id.bills_rv);
    }

    public void demoRvSetUp() {
        ArrayList<BillsRvItem> billsRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            billsRvItemArrayList.add(new BillsRvItem("12 Dic 2020", "Venta directa", "N° 0120155533", "$. 1,253.33", "Disponible"));
            Log.d("Rv:", "" + i);
        }
        BillsFragmentRvAdapter billsFragmentRvAdapter = new BillsFragmentRvAdapter(getContext(), billsRvItemArrayList, this);
        billsRv.setAdapter(billsFragmentRvAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon:
                if (status) {
                    iconView.setImageResource(R.drawable.ic_login_delete);
                    getActivity().findViewById(R.id.horizontalScrollView).setVisibility(View.VISIBLE);
                    status = false;
                } else {
                    iconView.setImageResource(R.drawable.ic_sort);
                    getActivity().findViewById(R.id.horizontalScrollView).setVisibility(View.GONE);
                    status = true;
                }
                break;
        }
    }

    @Override
    public void callback() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new SaleDetailsFragment())
                .addToBackStack(null).commit();
    }
}