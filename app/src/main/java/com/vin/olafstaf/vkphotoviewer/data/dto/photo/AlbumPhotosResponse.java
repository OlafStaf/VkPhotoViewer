package com.vin.olafstaf.vkphotoviewer.data.dto.photo;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AlbumPhotosResponse {

    @SerializedName("response")
    @Expose
    private List<Photo> response = new ArrayList<Photo>();

    /**
     *
     * @return
     * The response
     */
    public List<Photo> getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(List<Photo> response) {
        this.response = response;
    }

}