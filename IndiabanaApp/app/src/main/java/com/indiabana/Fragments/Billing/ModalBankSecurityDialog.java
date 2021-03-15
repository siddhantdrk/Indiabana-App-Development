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

import com.indiabana.R;

public class ModalBankSecurityDialog extends DialogFragment {


    public ModalBankSecurityDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ModalBankSecurityDialog newInstance(String title) {
        ModalBankSecurityDialog frag = new ModalBankSecurityDialog();
        return frag;
    }

    private Dialog mDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDialog = new Dialog(getActivity());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialog.getWindow().getAttributes());

        final View view = View.inflate(getActivity(), R.layout.modal_bank_security_dialog, null);
        mDialog.getWindow().setAttributes(layoutParams);
        mDialog.setContentView(view);

        return mDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modal_bank_security_dialog, container);
    }

    @Override
    public void onViewCreated(View viewRoot, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewRoot, savedInstanceState);

        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        viewRoot.findViewById(R.id.iv_close).setOnClickListener(view -> mDialog.dismiss());

        viewRoot.findViewById(R.id.mb_return).setOnClickListener(view -> {
            mDialog.dismiss();
        });

        viewRoot.findViewById(R.id.mb_continue).setOnClickListener(view -> {
            mDialog.dismiss();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            ModalSecurityCodeDialog editNameDialogFragment = new ModalSecurityCodeDialog();
            editNameDialogFragment.show(fm, "ReviewPostedDialog");
        });

    }
}