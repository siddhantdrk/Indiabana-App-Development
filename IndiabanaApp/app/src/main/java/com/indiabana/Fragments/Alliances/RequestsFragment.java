package com.indiabana.Fragments.Alliances;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Activities.AllianceRequestActivityTemp;
import com.indiabana.Adapters.Alliances.RequestPotentialRvAdapter;
import com.indiabana.Data.Alliances.RequestsPotentialRvItem;
import com.indiabana.Data.OpenNextFragmentFromAdapter;
import com.indiabana.R;

import java.util.ArrayList;

public class RequestsFragment extends Fragment implements OpenNextFragmentFromAdapter{

    View rootView;
    RecyclerView requestsRv;

    public RequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_requests, container, false);
        initViews();
        demoRvSetUp();
        return rootView;
    }

    private void initViews() {
        requestsRv = rootView.findViewById(R.id.requests_rv);
    }

    private void demoRvSetUp() {
        ArrayList<RequestsPotentialRvItem> requestsPotentialRvItemArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            requestsPotentialRvItemArrayList.add(new RequestsPotentialRvItem(R.drawable.demo_request_item_img, "Zapatería Don Calos", "Av. 12 con calle 3 y 6 esquina el Marquéz, Caballito, CABA, Argentina.", "4/5", "18", 4));
            Log.d("Rv:", "" + i);
        }
        RequestPotentialRvAdapter requestPotentialRvAdapter = new RequestPotentialRvAdapter(getContext(), requestsPotentialRvItemArrayList, (OpenNextFragmentFromAdapter) this);
        requestsRv.setAdapter(requestPotentialRvAdapter);
    }

    @Override
    public void callback() {
        getActivity().startActivity(new Intent(getContext(), AllianceRequestActivityTemp.class));
    }
}