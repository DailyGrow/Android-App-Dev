package edu.neu.madcourse.numad22sp_chenjiebei;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextlinkname;
    private EditText editTextlinkurl;
    private ExampleDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("add")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String linkname=editTextlinkname.getText().toString();
                        String linkurl=editTextlinkurl.getText().toString();
                        listener.applyTexts(linkname,linkurl);
                        

                    }
                });

        editTextlinkname=view.findViewById(R.id.edit_linkname);
        editTextlinkurl=view.findViewById(R.id.edit_linkurl);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener=(ExampleDialogListener) context;
    }
    public interface ExampleDialogListener{
        void applyTexts(String linkname, String linkurl);
    }
}
