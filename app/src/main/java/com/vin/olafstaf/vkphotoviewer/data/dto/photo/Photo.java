package com.vin.olafstaf.vkphotoviewer.data.dto.photo;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vin.olafstaf.vkphotoviewer.data.dto.Size;

import java.util.ArrayList;
import java.util.List;


public class Photo {

    @SerializedName("pid")
    @Expose
    private Integer pid;
    @SerializedName("aid")
    @Expose
    private Integer aid;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = new ArrayList<Size>();
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created")
    @Expose
    private Integer created;

    /**
     *
     * @return
     * The pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @param pid
     * The pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

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
     * The ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     *
     * @param ownerId
     * The owner_id
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The created
     */
    public Integer getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

}