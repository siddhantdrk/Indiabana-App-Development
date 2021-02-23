package com.indiabana.Fragments.Question;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indiabana.Adapters.questions.QuestionBuyingRvAdapter;
import com.indiabana.Data.QuestionRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class BuyingFragment extends Fragment {
    private RecyclerView buyingRecyclerView;
    private QuestionBuyingRvAdapter questionBuyingRvAdapter;
    private ArrayList<QuestionRvItem> questionRvItemArrayList;

    public BuyingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_buying, container, false);

        questionRvItemArrayList = new ArrayList<>();
        QuestionRvItem questionRvItem = new QuestionRvItem("Samsung Glaxy","Samsung WiFi SmartTV with USB C port, 3D and surround sound.",R.drawable.ic_mdi_keyboard_arrow_right_black);
        QuestionRvItem questionRvItem1 = new QuestionRvItem("Samsung Glaxy","Samsung WiFi SmartTV with USB C port, 3D and surround sound.",R.drawable.ic_mdi_keyboard_arrow_right_black);
        questionRvItemArrayList.add(questionRvItem);
        buyingRecyclerView = (RecyclerView) view.findViewById(R.id.buying_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        buyingRecyclerView.setLayoutManager(layoutManager);
        questionBuyingRvAdapter = new QuestionBuyingRvAdapter(questionRvItemArrayList);
        buyingRecyclerView.setAdapter(questionBuyingRvAdapter);

        return view;
    }
}