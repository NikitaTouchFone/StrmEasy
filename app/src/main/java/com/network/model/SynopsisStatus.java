package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 17/8/16.
 */
public class SynopsisStatus {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Entity> data = new ArrayList<Entity>();

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Entity> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Entity > data) {
        this.data = data;
    }
}
