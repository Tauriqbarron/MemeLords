package com.example.memelords;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class Pika_Fragment extends Fragment {
    EditText line1,line2,subject;
    TextView subjectTV,line1Tv,line2Tv;
    Button btnSave_pika;
    Context context;
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
        btnSave_pika = (Button) view.findViewById(R.id.btnsave_pika);
        context = view.getContext();
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
        btnSave_pika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // saveMeme(context,v );
            }
        });
        return view;
    }

    private Bitmap getbitmap(View v){
        Bitmap memeBit = Bitmap.createBitmap(300,300,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(memeBit);

        Drawable back = v.getBackground();
        if (back != null){
            back.draw(canvas);
        }
        else{
            canvas.drawColor(Color.WHITE);
        }
        v.draw(canvas);
        return memeBit;
    }
   // private File saveMeme(Context context, View v){
       // File pictureFileDr = new File(Environment.g)
        //return pic;
   // }
}