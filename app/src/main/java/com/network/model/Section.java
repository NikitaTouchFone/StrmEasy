package com.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A class from HomeApi response
 * Created by nikita on 9/8/16.
 */
public class Section {

    @SerializedName("items")
    @Expose
    private List<Entity> items = new ArrayList<Entity>();
    @SerializedName("title")
    @Expose
    private String title;

    /**
     *
     * @return
     * The items
     */
    public List<Entity> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<Entity> items) {
        this.items = items;
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

}
