package com.vin.olafstaf.vkphotoviewer.view;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public interface Navigator extends BaseNavigator{

    void navigateToAlbumsScreen();

    void navigateToSingleAlbumScreen(String albumId, String albumTitle);

    void navigateToPhotoViewScreen(String photoUrl);

    void navigateToLoginScreen();
}
