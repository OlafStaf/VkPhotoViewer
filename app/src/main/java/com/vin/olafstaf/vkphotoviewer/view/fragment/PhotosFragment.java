package com.vin.olafstaf.vkphotoviewer.view.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.vin.olafstaf.vkphotoviewer.R;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;
import com.vin.olafstaf.vkphotoviewer.presenter.impl.PhotosPresenterImpl;
import com.vin.olafstaf.vkphotoviewer.presenter.view.PhotosView;
import com.vin.olafstaf.vkphotoviewer.view.Navigator;
import com.vin.olafstaf.vkphotoviewer.view.activity.BaseActivity;
import com.vin.olafstaf.vkphotoviewer.view.adapter.PhotosAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosFragment extends BaseFragment implements PhotosView, PhotosAdapter.OnPhotoClickListener {
    private final int SPAN_COUNT = 2;
    private static final String ALBUM_ID_BUNDLE = "album_id_bundle";
    @Bind(R.id.rv_photo_content)
    RecyclerView rvPhotos;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    private GridLayoutManager layoutManager;
    private PhotosAdapter adapter;
    private PhotosPresenterImpl presenter;
    private String albumID;

    public static BaseFragment newInstance(String idAlbum) {
        Bundle args = new Bundle();
        args.putString(ALBUM_ID_BUNDLE, idAlbum);
        BaseFragment fragment = new PhotosFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PhotosPresenterImpl(this);
        setupRvAlbums();
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(getString(R.string.photos_subtitle));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
    public void showPhotos(List<PhotoEntity> photoEntities) {
        progressBar.setVisibility(View.GONE);
        adapter.setData(photoEntities);
    }

    @Override
    public void showError(String error) {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPhotoClick(PhotoEntity photoEntity) {
        ((Navigator) getActivity()).navigateToPhotoViewScreen(photoEntity.getPhotoBigUrl());
    }
}
