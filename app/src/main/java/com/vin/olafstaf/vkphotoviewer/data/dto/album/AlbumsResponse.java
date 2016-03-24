package com.vin.olafstaf.vkphotoviewer.data.dto.album;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumsResponse {

    @SerializedName("response")
    @Expose
    private List<Album> response = new ArrayList<Album>();

    /**
     *
     * @return
     * The response
     */
    public List<Album> getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(List<Album> response) {
        this.response = response;
    }

}