package com.example.memelords;

import android.graphics.Bitmap;

public class row {

    private int img;
    private Bitmap imgBit;

    public row(int img) {
        this.img = img;
    }
    public row(Bitmap img){
        this.imgBit = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
