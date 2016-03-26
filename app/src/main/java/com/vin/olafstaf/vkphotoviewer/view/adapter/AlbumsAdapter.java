package com.vin.olafstaf.vkphotoviewer.view.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumVH> {

    private List<AlbumEntity> data = new ArrayList<>();
    private Context context;
    private OnAlbumClickListener listener;

    public AlbumsAdapter(OnAlbumClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AlbumVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        AlbumVH albumVH = new AlbumVH(view);
        return albumVH;
    }

    @Override
    public void onBindViewHolder(AlbumVH holder, int position) {
        AlbumEntity albumEntity = data.get(position);
        Log.e("AlbumPhotoUrl",albumEntity.getAlbumIcon());
        holder.bindAlbumIcon(albumEntity.getAlbumIcon());
        holder.bindAlbumTitle(albumEntity.getAlbumTitle());
        holder.bindPhotoCount(String.valueOf(albumEntity.getPhotoCount()));
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else return 0;
    }

    public void setData(List<AlbumEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<AlbumEntity> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public interface OnAlbumClickListener {
        void onAlbumClick(AlbumEntity albumEntity);
    }

    public class AlbumVH extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_album)
        AppCompatImageView ivAlbumIcon;
        @Bind(R.id.tv_album_title)
        AppCompatTextView tvAlbumTitle;
        @Bind(R.id.tv_photo_count)
        AppCompatTextView tvPhotoCount;
        @Bind(R.id.progressBar)
        FrameLayout progressBar;

        public AlbumVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> listener.onAlbumClick(data.get(getAdapterPosition())));
        }

        public void bindAlbumTitle(String albumTitle) {
            tvAlbumTitle.setText(albumTitle);
        }

        public void bindPhotoCount(String photoCount) {
            tvPhotoCount.setText(photoCount);
        }

        public void bindAlbumIcon(String iconUrl) {
            progressBar.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(iconUrl)
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
                    .into(ivAlbumIcon);
        }
    }
}
