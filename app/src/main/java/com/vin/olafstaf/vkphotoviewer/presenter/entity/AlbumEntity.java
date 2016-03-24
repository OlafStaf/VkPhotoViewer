package com.vin.olafstaf.vkphotoviewer.presenter.entity;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public class AlbumEntity {
    private int albumId;
    private String albumIcon;
    private String albumTitle;
    private int photoCount;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumIcon() {
        return albumIcon;
    }

    public void setAlbumIcon(String albumIcon) {
        this.albumIcon = albumIcon;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }
}
