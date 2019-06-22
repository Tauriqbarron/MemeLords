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

public class Change_My_Mind_Fragment extends Fragment {
    TextView cmmTV;
    EditText cmmET;
    Button btnSave;
    Context context;
    ConstraintLayout cont;
    String newMeme;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.change_my_mind_fragment, container,false);
        cmmTV = (TextView)view.findViewById(R.id.cmm_TV);
        cmmET = (EditText)view.findViewById(R.id.cmm_ET);
        context = view.getContext();
        cont = (ConstraintLayout) view.findViewById(R.id.cont_layout_cmm);
        btnSave = (Button)view.findViewById(R.id.cmm_btnSave);
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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = saveMeme(context,cont);
            }
        });
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
        newMeme = filename;
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
        //addData(newMeme);
        return pictureFile;
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
