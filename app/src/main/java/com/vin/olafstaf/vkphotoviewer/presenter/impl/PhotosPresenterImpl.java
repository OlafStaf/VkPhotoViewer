package com.vin.olafstaf.vkphotoviewer.presenter.impl;

import com.vin.olafstaf.vkphotoviewer.data.api.VKApiModule;
import com.vin.olafstaf.vkphotoviewer.data.dto.photo.AlbumPhotosResponse;
import com.vin.olafstaf.vkphotoviewer.presenter.BasePresenter;
import com.vin.olafstaf.vkphotoviewer.presenter.PhotosPresenter;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;
import com.vin.olafstaf.vkphotoviewer.presenter.mapper.PhotosMapper;
import com.vin.olafstaf.vkphotoviewer.presenter.view.PhotosView;
import com.vin.olafstaf.vkphotoviewer.app.util.PreferencesManager;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosPresenterImpl extends BasePresenter implements PhotosPresenter {

    private PhotosView view;

    public PhotosPresenterImpl(PhotosView view) {
        this.view = view;
    }

    @Override
    public void getAlbumPhotos(String albumId) {
        Subscription subscription = VKApiModule
                .getService()
                .getAlbumsPhoto(albumId, PreferencesManager.getInstance().getUserId(), PreferencesManager.getInstance().getAccessToken(),"1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AlbumPhotosResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AlbumPhotosResponse albumPhotosResponse) {
                        List<PhotoEntity> photos = Observable.from(albumPhotosResponse.getResponse())
                                .map(new PhotosMapper())
                                .toList()
                                .toBlocking()
                                .first();
                        view.showPhotos(photos);
                    }
                });
        addSubscription(subscription);
    }
}
