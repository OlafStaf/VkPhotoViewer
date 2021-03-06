package com.vin.olafstaf.vkphotoviewer.data.api;


import com.vin.olafstaf.vkphotoviewer.data.dto.album.AlbumsResponse;
import com.vin.olafstaf.vkphotoviewer.data.dto.photo.AlbumPhotosResponse;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Stafiiyevskyi on 14.03.2016.
 */
public interface VKApiInterface {

    @GET("photos.getAlbums")
    Observable<AlbumsResponse> getUserAlbums(@Query("owner_id") String ownerId,
                                             @Query("need_covers") String needCovers,
                                             @Query("access_token") String accessToken,
                                             @Query("photo_sizes") String needPhotoSizes);

    @GET("photos.get")
    Observable<AlbumPhotosResponse> getAlbumsPhoto(@Query("album_id") String albumId,
                                                   @Query("owner_id") String ownerId,
                                                   @Query("access_token") String accessToken,
                                                   @Query("photo_sizes") String needPhotoSizes);
}
