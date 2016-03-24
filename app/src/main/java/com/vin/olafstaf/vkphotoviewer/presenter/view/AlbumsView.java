package com.vin.olafstaf.vkphotoviewer.presenter.view;

import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;

import java.util.List;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public interface AlbumsView extends BaseView{

    void showAlbums(List<AlbumEntity> albumEntities);

}
