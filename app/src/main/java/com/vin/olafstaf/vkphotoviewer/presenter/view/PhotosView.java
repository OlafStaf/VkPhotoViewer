package com.vin.olafstaf.vkphotoviewer.presenter.view;

import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;

import java.util.List;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public interface PhotosView extends BaseView{

    void showPhotos(List<PhotoEntity> photoEntities);
}
