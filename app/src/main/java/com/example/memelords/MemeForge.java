package com.example.memelords;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MemeForge extends AppCompatActivity {
    private Pika_Fragment pika_fragment;
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
    }
    }

}
