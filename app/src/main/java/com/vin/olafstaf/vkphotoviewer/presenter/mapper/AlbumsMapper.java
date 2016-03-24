package com.vin.olafstaf.vkphotoviewer.presenter.mapper;

import com.vin.olafstaf.vkphotoviewer.data.dto.album.Album;
import com.vin.olafstaf.vkphotoviewer.data.dto.Size;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.AlbumEntity;

import rx.functions.Func1;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class AlbumsMapper implements Func1<Album, AlbumEntity> {
    @Override
    public AlbumEntity call(Album album) {
        String imageUrl = "";
        for (Size size : album.getSizes()) {
            if (size.getType().equalsIgnoreCase("q")) {
                imageUrl = size.getSrc();
                break;
            }
        }
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumIcon(imageUrl);
        albumEntity.setAlbumId(album.getAid());
        albumEntity.setAlbumTitle(album.getTitle());
        albumEntity.setPhotoCount(album.getSize());
        return albumEntity;
    }
}
