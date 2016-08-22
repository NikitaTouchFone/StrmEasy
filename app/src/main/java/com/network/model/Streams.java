package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A class from HomeApi response
 * Created by nikita on 9/8/16.
 */
public class Streams {

    @SerializedName("dash")
    @Expose
    private String dash;
    @SerializedName("hls")
    @Expose
    private String hls;
    @SerializedName("mp4hq")
    @Expose
    private String mp4hq;
    @SerializedName("mp4mq")
    @Expose
    private String mp4mq;

    /**
     *
     * @return
     * The dash
     */
    public String getDash() {
        return dash;
    }

    /**
     *
     * @param dash
     * The dash
     */
    public void setDash(String dash) {
        this.dash = dash;
    }

    /**
     *
     * @return
     * The hls
     */
    public String getHls() {
        return hls;
    }

    /**
     *
     * @param hls
     * The hls
     */
    public void setHls(String hls) {
        this.hls = hls;
    }

    /**
     *
     * @return
     * The mp4hq
     */
    public String getMp4hq() {
        return mp4hq;
    }

    /**
     *
     * @param mp4hq
     * The mp4hq
     */
    public void setMp4hq(String mp4hq) {
        this.mp4hq = mp4hq;
    }

    /**
     *
     * @return
     * The mp4mq
     */
    public String getMp4mq() {
        return mp4mq;
    }

    /**
     *
     * @param mp4mq
     * The mp4mq
     */
    public void setMp4mq(String mp4mq) {
        this.mp4mq = mp4mq;
    }

}
