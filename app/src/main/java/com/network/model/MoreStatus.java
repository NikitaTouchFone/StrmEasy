package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 22/8/16.
 */
public class MoreStatus {

    @SerializedName("sucess")
    @Expose
    private Boolean sucess;
    @SerializedName("data")
    @Expose
    private List<Entity> data = new ArrayList<Entity>();

    /**
     *
     * @return
     * The sucess
     */
    public Boolean getSucess() {
        return sucess;
    }

    /**
     *
     * @param sucess
     * The sucess
     */
    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
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
    public void setData(List<Entity> data) {
        this.data = data;
    }

}
