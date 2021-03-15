package com.indiabana.Fragments.MyShopping;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.indiabana.Activities.MainActivity;
import com.indiabana.R;
import com.indiabana.Utility.Util;

public class ReviewPostedDialog extends DialogFragment {


    public ReviewPostedDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ReviewPostedDialog newInstance(String title) {
        ReviewPostedDialog frag = new ReviewPostedDialog();
        return frag;
    }

    private Dialog mDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDialog = new Dialog(getActivity());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialog.getWindow().getAttributes());

        final View view = View.inflate(getActivity(), R.layout.review_posted_layout, null);
        mDialog.getWindow().setAttributes(layoutParams);
        mDialog.setContentView(view);

        return mDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.review_posted_layout, container);
    }

    @Override
    public void onViewCreated(View viewRoot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewRoot, savedInstanceState);

        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        viewRoot.findViewById(R.id.no_thanks).setOnClickListener(view -> {
            mDialog.dismiss();
        });

        viewRoot.findViewById(R.id.yes_tip).setOnClickListener(view -> {
            mDialog.dismiss();
            Util.replaceFragment(new AddTipFragment(), (MainActivity) getActivity(), R.id.fragment_container_main);

        });

    }
}
