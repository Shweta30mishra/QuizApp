package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class fragmentDialog extends DialogFragment {
public interface DialogClickListner{
    void dialogAddQuestuions(String quetions,boolean answers);
}
    public DialogClickListner listner;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public fragmentDialog() {
        // Required empty public constructor
    }


    public static fragmentDialog newInstance(String param1, String param2) {
        fragmentDialog fragment = new fragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dialog,container,false);
        EditText enterquestions = v.findViewById(R.id.enterquestions);
        Button btn_save = v.findViewById(R.id.Save);
        RadioButton true_btu = v.findViewById(R.id.true_btu);
        RadioButton false_btu = v.findViewById(R.id.false_btu);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterquestions.getText()!=null && enterquestions.getText().toString().length()>0){
                    boolean answer=false;
                    if(true_btu.isChecked()){
                        answer=true;
                    }
                    listner.dialogAddQuestuions(enterquestions.getText().toString(),answer);
                    dismiss();
                }
            }
        });
        return v;
    }
}