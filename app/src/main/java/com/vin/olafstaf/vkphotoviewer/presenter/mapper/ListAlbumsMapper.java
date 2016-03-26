package com.vin.olafstaf.vkphotoviewer.presenter.mapper;

import com.vin.olafstaf.vkphotoviewer.data.dto.album.Album;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Shoorik on 26.03.2016.
 */
public class ListAlbumsMapper implements Func1<List<Album>, List<AlbumEntity>> {
    @Override
    public List<AlbumEntity> call(List<Album> albums) {
        return Observable.from(albums)
                .map(new AlbumsMapper())
                .toList()
                .toBlocking()
                .first();
    }
}
