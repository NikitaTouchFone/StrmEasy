package com.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A class from HomeApi response and also for synopsisApi also for MoreApi Response
 * Created by nikita on 9/8/16.
 *
 * Note: @Expose
 String myString;  // will be serialized as myString
 @SerializedName("m_s")
 String myString; // will be serialized as m_s
 */
    public class Category {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("_id")
    @Expose
    private String id;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The _id
     */
    public void setId(String id) {
        this.id = id;
    }

}
