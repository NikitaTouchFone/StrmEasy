package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A class from HomeApi response
 * Created by nikita on 9/8/16.
 */
public class Home {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sections")
    @Expose
    private List<Section> sections = new ArrayList<Section>();

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
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
     * The sections
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     *
     * @param sections
     * The sections
     */
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }


}
