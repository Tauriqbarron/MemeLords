package com.example.memelords;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
public class memegenerator_fragment extends Fragment {
    View view;
    Context context;
    private RecyclerView staggeredRv;
    private StaggeredRecyclerAdapter adapter;
    private StaggeredGridLayoutManager manager;
    public memegenerator_fragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.memegenerator_fragment,container,false);
        staggeredRvSetup();
        return view;
    }
    public void staggeredRvSetup(){
        staggeredRv = (RecyclerView)view.findViewById(R.id.staggered_recycleview);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredRv.setLayoutManager(manager);
        List<row> lst = new ArrayList<>();
        lst.add(new row(R.drawable.surprisedpika));
        lst.add(new row(R.drawable.tuxwinne));
        lst.add(new row(R.drawable.drake));
        lst.add(new row(R.drawable.buttons));
        lst.add(new row(R.drawable.changemymind));
        adapter = new StaggeredRecyclerAdapter(view.getContext(),lst);
        staggeredRv.setAdapter(adapter);
    }
}
