package com.indiabana.Fragments.Question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.questions.QuestionSellingRvAdapter;
import com.indiabana.Data.QuestionFragmentRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class SellingFragment extends Fragment {

    private RecyclerView sellingRecyclerView;
    private QuestionSellingRvAdapter questionSellingRvAdapter;
    private ArrayList<QuestionFragmentRvItem> questionFragmentRvItemArrayList;
    private View view;
    public SellingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_selling, container, false);
        setUpPreview();
        return view;
    }

    private void setUpPreview() {
        sellingRecyclerView = view.findViewById(R.id.selling_recyclerView);
        questionFragmentRvItemArrayList = new ArrayList<>();

        QuestionFragmentRvItem questionFragmentRvItem = new QuestionFragmentRvItem("Samsung Glaxy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore?", R.drawable.ic_mdi_keyboard_arrow_right_black);
        for (int i = 0; i < 2; i++)
            questionFragmentRvItemArrayList.add(questionFragmentRvItem);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        sellingRecyclerView.setLayoutManager(layoutManager);
        questionSellingRvAdapter = new QuestionSellingRvAdapter(questionFragmentRvItemArrayList);
        sellingRecyclerView.setAdapter(questionSellingRvAdapter);
    }
}