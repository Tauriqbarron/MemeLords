package com.example.memelords;

import android.Manifest;
import android.app.ProgressDialog;
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
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class Pika_Fragment extends Fragment {
    EditText line1,line2,subject;
    TextView subjectTV,line1Tv,line2Tv;
    Button btnSave_pika;
    Context context;
    ConstraintLayout cont;
    DatabaseHelper mDatabaseHelper;
    String newMeme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_pika,container,false);
        line1 = (EditText) view.findViewById(R.id.et1_pika);
        line2 = (EditText) view.findViewById(R.id.et2_pika);
        line1Tv = (TextView) view.findViewById(R.id.tvLine1_pika);
        line2Tv = (TextView) view.findViewById(R.id.tvLine2_pika);
        subject = (EditText) view.findViewById(R.id.subjectnameET_pika);
        subjectTV = (TextView) view.findViewById(R.id.subjectTV_pika);
        btnSave_pika = (Button) view.findViewById(R.id.btnsave_pika);
        context = view.getContext();
        cont = (ConstraintLayout)view.findViewById(R.id.con_pika);
        mDatabaseHelper = new DatabaseHelper(view.getContext());

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
        addData(newMeme);
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
    public void addData(String newMeme){
        Boolean insert = mDatabaseHelper.addData(newMeme);

        if(insert){
            toast("Insert Successful");
        }else{
            toast("Something went wrong");
        }
    }

    public void toast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}