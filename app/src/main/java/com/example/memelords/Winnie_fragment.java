package com.example.memelords;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Winnie_fragment extends Fragment {
    TextView winnieTV1,winnieTV2;
    EditText winnieET1,winnieET2;
    Context context;
    Button btnSave;
    ConstraintLayout cont;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winnie,container,false);

        winnieTV1 = (TextView) view.findViewById(R.id.winnieTV1);
        winnieTV2 = (TextView) view.findViewById(R.id.winnieTV2);
        winnieET1 = (EditText) view.findViewById(R.id.winneET1);
        winnieET2 = (EditText) view.findViewById(R.id.winneET2);
        context = view.getContext();
        btnSave = (Button) view.findViewById(R.id.btnSave_winnie);
        cont = (ConstraintLayout) view.findViewById(R.id.winnie_con);

        winnieET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                winnieTV1.setText(winnieET1.getText().toString());
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
                winnieTV2.setText(winnieET2.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = saveMeme(context,cont);
            }
        });
        return view;
    }
    private Bitmap getbitmap(View v){
        Bitmap memeBit = Bitmap.createBitmap(v.getWidth(),v.getHeight(),Bitmap.Config.ARGB_8888);
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
    private File saveMeme(Context context, View v){
        File pictureFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"MemeLords");
        if (!pictureFileDir.exists()) {
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if (!isDirectoryCreated)
                Log.i("TAG", "Can't create directory to save the image");
            return null;
        }
        String filename = pictureFileDir.getPath() +File.separator+ System.currentTimeMillis()+".jpg";
        File pictureFile = new File(filename);
        Bitmap saveMap =getbitmap(v);

        try{
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            saveMap.compress(Bitmap.CompressFormat.PNG,100,oStream);
            oStream.flush();
            oStream.close();
        }catch(IOException e){
            e.printStackTrace();
            Log.i("TAG", "There was an issue saving the image.");
        }
        scanGallery( context,pictureFile.getAbsolutePath());

        return pictureFile;
    }

    private void scanGallery(Context context, String path){
        try {
            MediaScannerConnection.scanFile(context, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue scanning gallery.");
        }
    }
}
