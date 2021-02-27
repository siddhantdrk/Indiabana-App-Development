package com.indiabana.Fragments.Question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.questions.QuestionBuyingRvAdapter;
import com.indiabana.Data.QuestionRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class BuyingFragment extends Fragment {
    private RecyclerView buyingRecyclerView;
    private QuestionBuyingRvAdapter questionBuyingRvAdapter;
    private ArrayList<QuestionRvItem> questionRvItemArrayList;
    private View view;

    public BuyingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_buying, container, false);
        setUpRv();
        return view;
    }

    private void setUpRv() {
        questionRvItemArrayList = new ArrayList<>();
        QuestionRvItem questionRvItem = new QuestionRvItem("Samsung Glaxy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...", R.drawable.ic_mdi_keyboard_arrow_right_black);
        for (int i = 0; i < 2; i++)
            questionRvItemArrayList.add(questionRvItem);
        buyingRecyclerView = view.findViewById(R.id.buying_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        buyingRecyclerView.setLayoutManager(layoutManager);
        questionBuyingRvAdapter = new QuestionBuyingRvAdapter(questionRvItemArrayList);
        buyingRecyclerView.setAdapter(questionBuyingRvAdapter);
    }
}