package com.indiabana.Fragments.Question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.indiabana.Adapters.MainFilterRecyclerAdapter;
import com.indiabana.Adapters.QuestionsFragmentRVAdapter;
import com.indiabana.Adapters.questions.QuestionStateAdapter;
import com.indiabana.Data.ListItem;
import com.indiabana.R;
import com.indiabana.databinding.FragmentQuestionsBinding;
import com.reim.android.filterrecyclerview.FilterRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class QuestionFragment extends Fragment implements View.OnClickListener {



    FilterRecyclerView filterView;
    RecyclerView recyclerView;
    QuestionsFragmentRVAdapter adapter;
    private FragmentQuestionsBinding fragmentQuestionsBinding;
    private ViewPager2 questionViewPager;
    private TabLayout tabLayout;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentQuestionsBinding = FragmentQuestionsBinding.inflate(inflater,container,false);
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        questionViewPager = view.findViewById(R.id.question_viewPager);
        tabLayout = view.findViewById(R.id.tab_layout);

//        recyclerView = view.findViewById(R.id.recycler_view);
//        adapter = new QuestionsFragmentRVAdapter();
//        recyclerView.setAdapter(adapter);

        // Hamza Aftab
        View iconView = getActivity().findViewById(R.id.icon);
        filterView = getActivity().findViewById(R.id.filter_search_recycler_view);
        iconView.setOnClickListener(this);

        setViewPager();
        return view;
    }

    private void setViewPager() {
        questionViewPager.setAdapter(new QuestionStateAdapter(this));
        new TabLayoutMediator(tabLayout,questionViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0) {
                            tab.setText(getResources().getString(R.string.buying));
                        } else {
                            tab.setText(getResources().getString(R.string.selling));
                        }
                    }
                }).attach();
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
}