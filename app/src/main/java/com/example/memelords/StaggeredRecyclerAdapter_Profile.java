package com.example.memelords;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class StaggeredRecyclerAdapter_Profile extends RecyclerView.Adapter<StaggeredRecyclerAdapter_Profile.ImageViewHolder>{

   private Context mContext;
   private List<row> mdata;

    public StaggeredRecyclerAdapter_Profile(Context mContext, List<row> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item_1,viewGroup,false);
        return new ImageViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.img.setImageBitmap(mdata.get(i).getImgBit());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        ConstraintLayout ConLayout;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            ConLayout = itemView.findViewById(R.id.staggered_recycleview_conlayout_profile);
        }
    }
}
