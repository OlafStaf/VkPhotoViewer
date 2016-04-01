package com.vin.olafstaf.vkphotoviewer.presenter.impl;

import com.vin.olafstaf.vkphotoviewer.data.api.VKApiModule;
import com.vin.olafstaf.vkphotoviewer.data.dto.album.Album;
import com.vin.olafstaf.vkphotoviewer.data.dto.album.AlbumsResponse;
import com.vin.olafstaf.vkphotoviewer.presenter.AlbumsPresenter;
import com.vin.olafstaf.vkphotoviewer.presenter.BasePresenter;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;
import com.vin.olafstaf.vkphotoviewer.presenter.mapper.AlbumsMapper;
import com.vin.olafstaf.vkphotoviewer.presenter.mapper.ListAlbumsMapper;
import com.vin.olafstaf.vkphotoviewer.presenter.view.AlbumsView;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class AlbumsPresenterImpl extends BasePresenter implements AlbumsPresenter {

    private AlbumsView view;

    public AlbumsPresenterImpl(AlbumsView view) {
        this.view = view;
    }

    @Override
    public void getAllUserAlbums(String userId) {
        Subscription subscription = VKApiModule.getService()
                .getUserAlbums(userId, "1", PreferencesManager.getInstance().getAccessToken(), "1")
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map(this::unwrapResponse)
                .map(new ListAlbumsMapper())
                .subscribe(new Observer<List<AlbumEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<AlbumEntity> albumEntities) {
                        view.showAlbums(albumEntities);
                    }
                });
        addSubscription(subscription);
    }

    private List<Album> unwrapResponse(AlbumsResponse response) {
        return response.getResponse();
    }
}
