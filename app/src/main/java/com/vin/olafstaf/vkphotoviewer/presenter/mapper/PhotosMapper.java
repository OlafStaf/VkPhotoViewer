package com.vin.olafstaf.vkphotoviewer.presenter.mapper;

import com.vin.olafstaf.vkphotoviewer.data.dto.photo.Photo;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;

import rx.functions.Func1;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosMapper implements Func1<Photo, PhotoEntity> {
    @Override
    public PhotoEntity call(Photo photo) {
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setPhotoId(photo.getPid());
        photoEntity.setPhotoUrl(photo.getSrc());
        photoEntity.setPhotoBigUrl(photo.getSrcBig());
        return photoEntity;
    }
}
