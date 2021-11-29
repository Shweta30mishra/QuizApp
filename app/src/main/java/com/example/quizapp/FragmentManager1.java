package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentManager1 extends Fragment {
    public static FragmentManager1 newInstance(int Qid, int colorid){
        FragmentManager1 fragment = new FragmentManager1();
        Bundle args = new Bundle();
        args.putInt("QuestId",Qid);
        args.putInt("ColorId",colorid);
        fragment.setArguments(args);
        return fragment;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment,container,false);
        TextView text=v.findViewById(R.id.questionText);
        text.setText(getArguments().getInt("QuestId"));
        text.setBackgroundResource(getArguments().getInt("ColorId"));
        return  v;
    }
}
