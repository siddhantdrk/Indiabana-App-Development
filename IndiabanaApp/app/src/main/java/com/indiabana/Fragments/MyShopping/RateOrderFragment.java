package com.indiabana.Fragments.MyShopping;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RadioButton;

import com.indiabana.Activities.MainActivity;
import com.indiabana.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RateOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RateOrderFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RateOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RateOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RateOrderFragment newInstance(String param1, String param2) {
        RateOrderFragment fragment = new RateOrderFragment();
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
        return inflater.inflate(R.layout.activity_rate_purchase, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View viewroot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewroot, savedInstanceState);

        viewroot.findViewById(R.id.to_post_activity_back_arrow).setOnClickListener(view -> {
            getActivity().onBackPressed();
            ((MainActivity) getActivity()).hideFullScreenFragmentLayout();
        });

        viewroot.findViewById(R.id.icon).setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), view);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.inflate(R.menu.item_menu);
            popupMenu.show();
        });

        ((RadioButton) viewroot.findViewById(R.id.rb_problem_with_package)).setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ((RadioButton) viewroot.findViewById(R.id.rb_problem_with_package)).setChecked(false);
                ((RadioButton) viewroot.findViewById(R.id.rb_package_fine)).setChecked(true);
                ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_full_container_main, new BuyerOrderProblemFragment()).commit();
                ((RadioButton) viewroot.findViewById(R.id.rb_problem_with_package)).setChecked(false);
                ((MainActivity) getActivity()).showFullScreenFragmentLayout();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}