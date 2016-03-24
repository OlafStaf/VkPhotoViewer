package com.vin.olafstaf.vkphotoviewer.data.dto.album;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vin.olafstaf.vkphotoviewer.data.dto.Size;

import java.util.ArrayList;
import java.util.List;

public class Album {

    @SerializedName("aid")
    @Expose
    private Integer aid;
    @SerializedName("thumb_id")
    @Expose
    private String thumbId;
    @SerializedName("owner_id")
    @Expose
    private String ownerId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = new ArrayList<Size>();

    /**
     *
     * @return
     * The aid
     */
    public Integer getAid() {
        return aid;
    }

    /**
     *
     * @param aid
     * The aid
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     *
     * @return
     * The thumbId
     */
    public String getThumbId() {
        return thumbId;
    }

    /**
     *
     * @param thumbId
     * The thumb_id
     */
    public void setThumbId(String thumbId) {
        this.thumbId = thumbId;
    }

    /**
     *
     * @return
     * The ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     *
     * @param ownerId
     * The owner_id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     *
     * @param updated
     * The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     *
     * @return
     * The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return
     * The sizes
     */
    public List<Size> getSizes() {
        return sizes;
    }

    /**
     *
     * @param sizes
     * The sizes
     */
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

}