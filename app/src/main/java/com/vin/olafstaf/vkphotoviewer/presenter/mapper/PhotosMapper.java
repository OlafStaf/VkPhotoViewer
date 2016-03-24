package com.vin.olafstaf.vkphotoviewer.presenter.mapper;

import com.vin.olafstaf.vkphotoviewer.data.dto.Size;
import com.vin.olafstaf.vkphotoviewer.data.dto.photo.Photo;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;

import rx.functions.Func1;

/**
 * Created by Stafiiyevskyi on 24.03.2016.
 */
public class PhotosMapper implements Func1<Photo, PhotoEntity> {
    @Override
    public PhotoEntity call(Photo photo) {
        String imageUrl = "";
        String bigImageUrl = "";
        for (Size size : photo.getSizes()) {
            if (size.getType().equalsIgnoreCase("q")) {
                imageUrl = size.getSrc();
            } else if (!size.getSrc().isEmpty()) {
                bigImageUrl = size.getSrc();
            }
        }
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setPhotoId(photo.getPid());
        photoEntity.setPhotoUrl(imageUrl);
        photoEntity.setPhotoBigUrl(bigImageUrl);
        return photoEntity;
    }
}
