package com.indiabana.Fragments.Billing;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.indiabana.Activities.MainActivity;
import com.indiabana.Fragments.MyShopping.AddTipFragment;
import com.indiabana.R;
import com.indiabana.Utility.Util;

public class ModalSecurityCodeDialog extends DialogFragment {


    public ModalSecurityCodeDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ModalSecurityCodeDialog newInstance(String title) {
        ModalSecurityCodeDialog frag = new ModalSecurityCodeDialog();
        return frag;
    }

    private Dialog mDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDialog = new Dialog(getActivity());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialog.getWindow().getAttributes());

        final View view = View.inflate(getActivity(), R.layout.modal_security_code_dialog, null);
        mDialog.getWindow().setAttributes(layoutParams);
        mDialog.setContentView(view);

        return mDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modal_security_code_dialog, container);
    }

    @Override
    public void onViewCreated(View viewRoot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewRoot, savedInstanceState);

        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        viewRoot.findViewById(R.id.iv_close).setOnClickListener(view -> mDialog.hide());

        viewRoot.findViewById(R.id.mb_cancel).setOnClickListener(view -> {
            mDialog.hide();
        });

        viewRoot.findViewById(R.id.mb_continue).setOnClickListener(view -> {
            mDialog.hide();
            Util.replaceFragment(new NewPaymentBankOrBankAccountFragment(), (MainActivity) getActivity(), R.id.fragment_container_main);
        });

    }
}


