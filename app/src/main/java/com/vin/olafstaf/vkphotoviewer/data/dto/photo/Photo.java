package com.vin.olafstaf.vkphotoviewer.data.dto.photo;

/**
 * Created by Stafiiyevskyi on 23.03.2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("src_big")
    @Expose
    private String srcBig;
    @SerializedName("src_small")
    @Expose
    private String srcSmall;
    @SerializedName("src_xbig")
    @Expose
    private String srcXbig;
    @SerializedName("src_xxbig")
    @Expose
    private String srcXxbig;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("long")
    @Expose
    private Double _long;

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
     * The src
     */
    public String getSrc() {
        return src;
    }

    /**
     *
     * @param src
     * The src
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     *
     * @return
     * The srcBig
     */
    public String getSrcBig() {
        return srcBig;
    }

    /**
     *
     * @param srcBig
     * The src_big
     */
    public void setSrcBig(String srcBig) {
        this.srcBig = srcBig;
    }

    /**
     *
     * @return
     * The srcSmall
     */
    public String getSrcSmall() {
        return srcSmall;
    }

    /**
     *
     * @param srcSmall
     * The src_small
     */
    public void setSrcSmall(String srcSmall) {
        this.srcSmall = srcSmall;
    }

    /**
     *
     * @return
     * The srcXbig
     */
    public String getSrcXbig() {
        return srcXbig;
    }

    /**
     *
     * @param srcXbig
     * The src_xbig
     */
    public void setSrcXbig(String srcXbig) {
        this.srcXbig = srcXbig;
    }

    /**
     *
     * @return
     * The srcXxbig
     */
    public String getSrcXxbig() {
        return srcXxbig;
    }

    /**
     *
     * @param srcXxbig
     * The src_xxbig
     */
    public void setSrcXxbig(String srcXxbig) {
        this.srcXxbig = srcXxbig;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
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

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The _long
     */
    public Double getLong() {
        return _long;
    }

    /**
     *
     * @param _long
     * The long
     */
    public void setLong(Double _long) {
        this._long = _long;
    }

}
