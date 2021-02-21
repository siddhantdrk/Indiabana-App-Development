package com.indiabana.Fragments.Alliances;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.Alliances.MyAlliancesRvAdapter;
import com.indiabana.Data.Alliances.MyAlliancesFragmentRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class MyAlliancesFragment extends Fragment implements OpenNextFragmentFromAdapter{

    View rootView;
    RecyclerView alliancesRv;

    public MyAlliancesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_my_alliances, container, false);
        initViews();
        demoRvSetUp();
        return rootView;
    }


    private void initViews() {
        alliancesRv = rootView.findViewById(R.id.my_alliances_rv);
    }

    public void demoRvSetUp() {
        ArrayList<MyAlliancesFragmentRvItem> myAlliancesFragmentRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myAlliancesFragmentRvItemArrayList.add(new MyAlliancesFragmentRvItem(R.drawable.demo_my_alliances_item_img, "Adidas LATAM", "Av. 12 con calle 3 y 6 esquina el Marquéz, Caballito, CABA, Argentina.", "4/5", 4));
            Log.d("Rv:", "" + i);
        }
        MyAlliancesRvAdapter myAlliancesRvAdapter = new MyAlliancesRvAdapter(getContext(), myAlliancesFragmentRvItemArrayList, (OpenNextFragmentFromAdapter) this);
        alliancesRv.setAdapter(myAlliancesRvAdapter);
    }

    @Override
    public void callback() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new AllyProfileFragmentTemp())
                .addToBackStack(null).commit();
    }
}