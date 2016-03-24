package com.vin.olafstaf.vkphotoviewer.view;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
public interface Navigator {

    void navigateToAlbumsScreen();

    void navigateToAlbumsScreenNonBackStack();

    void navigateToSingleAlbumScreen(String albumId);

    void navigateToPhotoViewScreen(String photoUrl);

    void navigateToLoginScreen();
}
