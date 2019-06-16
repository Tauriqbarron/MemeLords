package com.example.memelords;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Winnie_fragment extends Fragment {
    TextView winnieTV1,winnieTV2;
    EditText winnieET1,winnieET2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winnie,container,false);

        //winnieTV1 = (TextView) view.findViewById(R.id.winnieTV1);
        //winnieTV2 = (TextView) view.findViewById(R.id.winnieTV2);
        winnieET1 = (EditText) view.findViewById(R.id.winneET1);
        winnieET2 = (EditText) view.findViewById(R.id.winneET2);

        winnieET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //winnieTV1.setText(winnieET1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        winnieET2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // winnieTV2.setText(winnieET2.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }
}
