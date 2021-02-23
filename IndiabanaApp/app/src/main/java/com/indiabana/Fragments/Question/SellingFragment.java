package com.indiabana.Fragments.Question;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indiabana.Adapters.questions.QuestionSellingRvAdapter;
import com.indiabana.Data.QuestionRvItem;
import com.indiabana.R;

import java.util.ArrayList;

public class SellingFragment extends Fragment {

    private RecyclerView sellingRecyclerView;
    private QuestionSellingRvAdapter questionSellingRvAdapter;
    private ArrayList<QuestionRvItem> questionRvItemArrayList;
    public SellingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_selling, container, false);

        sellingRecyclerView = (RecyclerView) view.findViewById(R.id.selling_recyclerView);
        questionRvItemArrayList = new ArrayList<>();

        QuestionRvItem questionRvItem = new QuestionRvItem("Samsung Glaxy","Samsung WiFi SmartTV with USB C port, 3D and surround sound.",R.drawable.ic_mdi_keyboard_arrow_right_black);
        QuestionRvItem questionRvItem1 = new QuestionRvItem("Samsung Glaxy","Samsung WiFi SmartTV with USB C port, 3D and surround sound.",R.drawable.ic_mdi_keyboard_arrow_right_black);
        questionRvItemArrayList.add(questionRvItem);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        sellingRecyclerView.setLayoutManager(layoutManager);
        questionSellingRvAdapter = new QuestionSellingRvAdapter(questionRvItemArrayList);
        sellingRecyclerView.setAdapter(questionSellingRvAdapter);
        return view;
    }
}