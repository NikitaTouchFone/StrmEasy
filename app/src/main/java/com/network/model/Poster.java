
package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A class from HomeApi response and also for synopsisApi
 * Created by nikita on 9/8/16.
 */
public class Poster {

    @SerializedName("xsmall")
    @Expose
    private String xsmall;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("xlarge")
    @Expose
    private String xlarge;

    /**
     *
     * @return
     * The xsmall
     */
    public String getXsmall() {
        return xsmall;
    }

    /**
     *
     * @param xsmall
     * The xsmall
     */
    public void setXsmall(String xsmall) {
        this.xsmall = xsmall;
    }

    /**
     *
     * @return
     * The small
     */
    public String getSmall() {
        return small;
    }

    /**
     *
     * @param small
     * The small
     */
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     *
     * @return
     * The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     *
     * @param medium
     * The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     *
     * @return
     * The large
     */
    public String getLarge() {
        return large;
    }

    /**
     *
     * @param large
     * The large
     */
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     *
     * @return
     * The xlarge
     */
    public String getXlarge() {
        return xlarge;
    }

    /**
     *
     * @param xlarge
     * The xlarge
     */
    public void setXlarge(String xlarge) {
        this.xlarge = xlarge;
    }

}
