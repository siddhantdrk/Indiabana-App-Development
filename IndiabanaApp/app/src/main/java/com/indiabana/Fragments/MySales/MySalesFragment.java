package com.indiabana.Fragments.MySales;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.MySalesFragmentRvAdapter;
import com.indiabana.Data.MySalesRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class MySalesFragment extends Fragment implements OpenNextFragmentFromAdapter {
    private View rootView;
    private RecyclerView salesRv;

    public MySalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_my_sales, container, false);
        initViews();
        demoRvSetUp();

        ImageView menuIcon  = getActivity().findViewById(R.id.icon);
        menuIcon.setVisibility(View.GONE);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.my_sales);

        return rootView;
    }

    private void initViews() {
        salesRv = rootView.findViewById(R.id.my_sales_rv);
    }

    public void demoRvSetUp() {
        ArrayList<MySalesRvItem> mySalesRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mySalesRvItemArrayList.add(new MySalesRvItem(R.drawable.demo_shopping_item_img, "Samsung Galaxy 20A, ultra desbloqueado para todas las operadoras.", "$21,253.33", "01", "En proceso", "María Álvarez"));
            Log.d("Rv:", "" + i);
        }
        MySalesFragmentRvAdapter mySalesFragmentRvAdapter = new MySalesFragmentRvAdapter(getContext(), mySalesRvItemArrayList, this);
        salesRv.setAdapter(mySalesFragmentRvAdapter);
    }

    @Override
    public void callback() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new SaleDetailsFragment())
                .addToBackStack(null).commit();
    }
}