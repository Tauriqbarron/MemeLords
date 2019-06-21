package com.example.memelords;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MemeForge extends AppCompatActivity {
    private Pika_Fragment pika_fragment;
    private Winnie_fragment winnie_fragment;
    private Drake_Fragment drake_fragment;
    ImageView ImgVw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meme_forge);
        Log.d("Forge", "Forge up");

        Bundle imageSent = getIntent().getExtras();

        switch (imageSent.getInt("image_clicked")){
            // pikachu meme
            case 2131165310:
                pika_fragment = new Pika_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.meme_forge_frame,pika_fragment)
                        .commit();
                break;
            case 2131165313:
                winnie_fragment = new Winnie_fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.meme_forge_frame,winnie_fragment)
                        .commit();
                break;
            case 2131165286:
                drake_fragment = new Drake_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.meme_forge_frame,drake_fragment)
                        .commit();
                break;
    }
    }

}
