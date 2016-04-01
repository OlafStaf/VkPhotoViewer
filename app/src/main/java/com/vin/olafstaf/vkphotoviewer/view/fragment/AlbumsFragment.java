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
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;
import com.vin.olafstaf.vkphotoviewer.presenter.impl.AlbumsPresenterImpl;
import com.vin.olafstaf.vkphotoviewer.presenter.view.AlbumsView;
import com.vin.olafstaf.vkphotoviewer.view.Navigator;
import com.vin.olafstaf.vkphotoviewer.view.activity.BaseActivity;
import com.vin.olafstaf.vkphotoviewer.view.adapter.AlbumsAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class AlbumsFragment extends BaseFragment implements AlbumsAdapter.OnAlbumClickListener, AlbumsView {

    private final int SPAN_COUNT = 2;

    @Bind(R.id.rv_photo_content)
    RecyclerView rvAlbums;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.iv_reload)
    AppCompatImageView ivReload;

    private GridLayoutManager layoutManager;
    private AlbumsAdapter adapter;
    private AlbumsPresenterImpl presenter;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new AlbumsFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRvAlbums();
        presenter = new AlbumsPresenterImpl(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photos_contet;
    }

    @Override
    public void updateToolbar() {
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(getString(R.string.albums_subtitle));
//            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    private void setupRvAlbums() {
        adapter = new AlbumsAdapter(this);
        layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        rvAlbums.setLayoutManager(layoutManager);
        rvAlbums.setAdapter(adapter);
    }

    @OnClick(R.id.iv_reload)
    void onReloadClick() {
        ivReload.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        presenter.getAllUserAlbums(PreferencesManager.getInstance().getUserId());
    }

    @Override
    public void onResume() {
        super.onResume();
        updateToolbar();
        presenter.getAllUserAlbums(PreferencesManager.getInstance().getUserId());
    }


    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onAlbumClick(AlbumEntity albumEntity) {
        ((Navigator) getActivity())
                .navigateToSingleAlbumScreen(String.valueOf(albumEntity.getAlbumId())
                        , albumEntity.getAlbumTitle());
    }

    @Override
    public void showAlbums(List<AlbumEntity> albumEntities) {
        adapter.setData(albumEntities);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
        ivReload.setVisibility(View.VISIBLE);
    }
}
