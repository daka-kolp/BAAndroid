package com.dakakolp.apptask13.fragments.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.dakakolp.apptask13.interfaces.OnButtonDialogClickListener;

public class DeleteDialogFragment extends DialogFragment {
    private OnButtonDialogClickListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do want to delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onYesClick();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onNoClick();
                    }
                });


        return builder.create();
    }

    public void setListener(OnButtonDialogClickListener listener) {
        this.listener = listener;
    }

}
