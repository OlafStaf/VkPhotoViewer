package com.vin.olafstaf.vkphotoviewer.presenter.entity;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class PhotoEntity {
    private int photoId;
    private String photoUrl;
    private String photoBigUrl;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoBigUrl() {
        return photoBigUrl;
    }

    public void setPhotoBigUrl(String photoBigUrl) {
        this.photoBigUrl = photoBigUrl;
    }
}
