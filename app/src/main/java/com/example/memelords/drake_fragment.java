package com.example.memelords;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class drake_fragment extends Fragment {
    TextView drake_Tv1,drake_Tv2;
    EditText drake_Ed1,drake_Ed2;
    Context context;
    ConstraintLayout cont;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.drake_fragment,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
