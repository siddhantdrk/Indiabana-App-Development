package com.indiabana.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.indiabana.Activities.MainActivity;
import com.indiabana.R;

import static android.app.Activity.RESULT_OK;

public class HelpCenterContentFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HelpCenterContentFragment() {
        // Required empty public constructor
    }

    public static HelpCenterContentFragment newInstance(String param1, String param2) {
        HelpCenterContentFragment fragment = new HelpCenterContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_center_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View parentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(parentView, savedInstanceState);

        parentView.findViewById(R.id.img_help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                VisorDialogFragment editNameDialogFragment = new VisorDialogFragment();
                editNameDialogFragment.show(fm, "ReviewPostedDialog");
            }
        });


        parentView.findViewById(R.id.to_post_activity_back_arrow).setOnClickListener(view -> {
            Intent intent = new Intent();
            getActivity().setResult(RESULT_OK, intent);
            getActivity().onBackPressed();
            ((MainActivity) getActivity()).showToolbar();
        });
    }
}