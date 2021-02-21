package com.indiabana.Fragments.MyShopping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.MainFilterRecyclerAdapter;
import com.indiabana.Adapters.MyShoppingFragmentRvAdapter;
import com.indiabana.Data.ListItem;
import com.indiabana.Data.MyShoppingRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;
import com.reim.android.filterrecyclerview.FilterRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyShoppingFragment extends Fragment implements View.OnClickListener, OpenNextFragmentFromAdapter {

    private View rootView;
    private RecyclerView shoppingRv;
    FilterRecyclerView filterView;

    public MyShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_my_shopping, container, false);
        initViews();
        demoRvSetUp();

        // Hamza Aftab

        ImageView iconView = getActivity().findViewById(R.id.icon);
        iconView.setImageResource(R.drawable.ic_mdi_search);
        filterView = getActivity().findViewById(R.id.filter_search_recycler_view);
        iconView.setOnClickListener(this);

        TextView textView = getActivity().findViewById(R.id.text);
        textView.setText(R.string.my_shopping);

        return rootView;
    }

    private void initViews() {
        shoppingRv = rootView.findViewById(R.id.my_shopping_rv);
    }

    public void demoRvSetUp() {
        ArrayList<MyShoppingRvItem> myShoppingRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myShoppingRvItemArrayList.add(new MyShoppingRvItem(R.drawable.demo_shopping_item_img, "Samsung Galaxy 20A, ultra desbloqueado para todas las operadoras.", "$21,253.33", "01", "En proceso"));
            Log.d("Rv:", "" + i);
        }
        MyShoppingFragmentRvAdapter myShoppingFragmentRvAdapter = new MyShoppingFragmentRvAdapter(getContext(), myShoppingRvItemArrayList,this);
        shoppingRv.setAdapter(myShoppingFragmentRvAdapter);
    }

    @Override
    public void onClick(View view) {

        // Hamza Aftab
        switch (view.getId()) {
            case R.id.icon:

                filterView.open(true);
                filterView.setAdapter(new MainFilterRecyclerAdapter(getActivity()));

                List<ListItem> itemList = new ArrayList<>();
                itemList.add(new ListItem("Iphone XR"));
                itemList.add(new ListItem("Iphone protector de pantalla"));
                itemList.add(new ListItem("Iphone 8 plus"));
                itemList.add(new ListItem("Iphone 5s"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));
                itemList.add(new ListItem("Cargador para iphone"));

                filterView.initializeItemList(itemList);
                break;
        }

    }

    @Override
    public void callback() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new PurchaseDetailsFragment())
                .addToBackStack(null).commit();
    }
}