package com.example.memelords;

import android.content.Context;
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

public class Change_My_Mind_Fragment extends Fragment {
    TextView cmmTV;
    EditText cmmET;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.change_my_mind_fragment, container,false);
        cmmTV = (TextView)view.findViewById(R.id.cmm_TV);
        cmmET = (EditText)view.findViewById(R.id.cmm_ET);
        context = view.getContext();
        setup();
        return view;
    }
    public void setup(){
        cmmET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cmmTV.setText(cmmET.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
