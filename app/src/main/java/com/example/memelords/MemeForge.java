package com.example.memelords;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MemeForge extends AppCompatActivity {

    ImageView ImgVw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meme_forge);
        Log.d("Forge","Forge up");

        Bundle imageSent = getIntent().getExtras();
        ImgVw = findViewById(R.id.MF_imageView);
        if(imageSent != null){
            int imageInt = getIntent().getIntExtra("image_clicked",0);
            //int imageCovert = Integer.getInteger(imageInt);
            ImgVw.setImageResource(imageInt);
        }

    }

}
