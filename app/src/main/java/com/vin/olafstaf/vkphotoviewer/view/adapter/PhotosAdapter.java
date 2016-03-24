package com.vin.olafstaf.vkphotoviewer.view.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoVH> {

    private List<PhotoEntity> data;
    private OnPhotoClickListener listener;
    private Context context;

    public PhotosAdapter(OnPhotoClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<PhotoEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public PhotoVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        PhotoVH photoVH = new PhotoVH(view);
        return photoVH;
    }

    @Override
    public void onBindViewHolder(PhotoVH holder, int position) {
        PhotoEntity photoEntity = data.get(position);
        holder.bindPhoto(photoEntity.getPhotoUrl());
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    public interface OnPhotoClickListener {
        void onPhotoClick(PhotoEntity photoEntity);
    }

    public class PhotoVH extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_photo)
        AppCompatImageView ivPhoto;
        @Bind(R.id.progressBar)
        ProgressBar progressBar;

        public PhotoVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPhotoClick(data.get(getAdapterPosition()));
                }
            });
        }

        public void bindPhoto(String photoUrl) {
            Glide.with(context)
                    .load(photoUrl)
                    .centerCrop()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(ivPhoto);
        }
    }
}
