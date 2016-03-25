package com.vin.olafstaf.vkphotoviewer.view.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.app.util.NetworkUtil;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;
import com.vin.olafstaf.vkphotoviewer.presenter.impl.PhotosPresenterImpl;
import com.vin.olafstaf.vkphotoviewer.presenter.view.PhotosView;
import com.vin.olafstaf.vkphotoviewer.view.Navigator;
import com.vin.olafstaf.vkphotoviewer.view.activity.BaseActivity;
import com.vin.olafstaf.vkphotoviewer.view.adapter.PhotosAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosFragment extends BaseFragment implements PhotosView, PhotosAdapter.OnPhotoClickListener {
    private final int SPAN_COUNT = 2;
    private static final String ALBUM_ID_BUNDLE = "album_id_bundle";
    private static final String ALBUM_TITLE_BUNDLE = "album_title_bundle";
    @Bind(R.id.rv_photo_content)
    RecyclerView rvPhotos;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.iv_reload)
    AppCompatImageView ivReload;

    private GridLayoutManager layoutManager;
    private PhotosAdapter adapter;
    private PhotosPresenterImpl presenter;
    private String albumID;
    private String albumTitle;

    public static BaseFragment newInstance(String idAlbum, String albumTitle) {
        Bundle args = new Bundle();
        args.putString(ALBUM_ID_BUNDLE, idAlbum);
        args.putString(ALBUM_TITLE_BUNDLE, albumTitle);
        BaseFragment fragment = new PhotosFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new PhotosPresenterImpl(this);
        setupRvAlbums();
    }

    private void setupRvAlbums() {
        adapter = new PhotosAdapter(this);
        layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        rvPhotos.setLayoutManager(layoutManager);
        rvPhotos.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        albumID = getArguments().getString(ALBUM_ID_BUNDLE);
        albumTitle = getArguments().getString(ALBUM_TITLE_BUNDLE);
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(albumTitle);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        presenter.getAlbumPhotos(albumID);
    }

    @OnClick(R.id.iv_reload)
    void onReloadClick() {
        progressBar.setVisibility(View.VISIBLE);
        ivReload.setVisibility(View.GONE);
        presenter.getAlbumPhotos(albumID);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photos_contet;
    }

    @Override
    public void updateToolbar() {

    }


    @Override
    public void showPhotos(List<PhotoEntity> photoEntities) {
        progressBar.setVisibility(View.GONE);
        adapter.setData(photoEntities);
    }

    @Override
    public void showError(String error) {
        if (!NetworkUtil.isNetworkConnected(getActivity())){
            Toast.makeText(getActivity(), R.string.no_connection_message, Toast.LENGTH_LONG).show();
        }
        progressBar.setVisibility(View.GONE);
        ivReload.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPhotoClick(PhotoEntity photoEntity) {
        ((Navigator) getActivity()).navigateToPhotoViewScreen(photoEntity.getPhotoBigUrl());
    }
}
