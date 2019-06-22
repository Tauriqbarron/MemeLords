package com.example.memelords;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class profile_fragment extends Fragment {
    View view;
    private RecyclerView staggeredRv;
    private StaggeredRecyclerAdapter_Profile adapter;
    private StaggeredGridLayoutManager manager;
    private DatabaseHelper mDB;
    private Button btnRefresh;
    private TextView test;
    public profile_fragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment,container,false);
        mDB = new DatabaseHelper(view.getContext());
        staggeredRvSetup();
        return view;
    }
    public void staggeredRvSetup(){
        staggeredRv = (RecyclerView)view.findViewById(R.id.staggered_recycleview_profile);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredRv.setLayoutManager(manager);
        btnRefresh = (Button)view.findViewById(R.id.btnRefresh);
        test = (TextView)view.findViewById(R.id.tvTest);
        btnSetup();
    }
    public void btnSetup(){
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor data = mDB.getData();
                ArrayList<String> filePaths = new ArrayList<>();

                List<row> row = new ArrayList<>();
                while(data.moveToNext()){
                    filePaths.add(data.getString(1));
                    File imgFile = new File(data.getString(1));
                    test.setText(data.getString(1));
                    if(imgFile.exists()){
                        Bitmap bitImg = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                        row.add( new row(bitImg));
                    }
                }
                adapter = new StaggeredRecyclerAdapter_Profile(view.getContext(),row);
                staggeredRv.setAdapter(adapter);
            }
        });
    }
}
