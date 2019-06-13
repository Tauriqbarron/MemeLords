package com.example.memelords;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Pika_Fragment extends Fragment {
    EditText line1,line2,subject;
    TextView subjectTV,line1Tv,line2Tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pika,container,false);
        line1 = (EditText) view.findViewById(R.id.et1_pika);
        line2 = (EditText) view.findViewById(R.id.et2_pika);
        line1Tv = (TextView) view.findViewById(R.id.tvLine1_pika);
        line2Tv = (TextView) view.findViewById(R.id.tvLine2_pika);
        subject = (EditText) view.findViewById(R.id.subjectnameET_pika);
        subjectTV = (TextView) view.findViewById(R.id.subjectTV_pika);

        subject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                subjectTV.setText(subject.getText().toString()+":");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        line1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                line1Tv.setText(line1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        line2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                line2Tv.setText(line2.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }
}