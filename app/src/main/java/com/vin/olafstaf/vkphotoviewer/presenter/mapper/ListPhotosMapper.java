package com.vin.olafstaf.vkphotoviewer.presenter.mapper;

import com.vin.olafstaf.vkphotoviewer.data.dto.photo.Photo;
import com.vin.olafstaf.vkphotoviewer.presenter.entity.PhotoEntity;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Shoorik on 26.03.2016.
 */
public class ListPhotosMapper implements Func1<List<Photo>, List<PhotoEntity>> {
    @Override
    public List<PhotoEntity> call(List<Photo> photos) {
        return Observable.from(photos)
                .map(new PhotosMapper())
                .toList()
                .toBlocking()
                .first();
    }
}
