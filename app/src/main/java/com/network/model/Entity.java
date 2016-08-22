package com.network.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

/**
 * A class from HomeApi response
 * Created by nikita on 9/8/16.
 */
public class Entity {

    //Datum class for synopsis api and also for moreapi
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("streams")
    @Expose
    private Streams streams;
    @SerializedName("poster")
    @Expose
    private Poster poster;
    @SerializedName("awards")
    @Expose
    private String awards;
    @SerializedName("countries")
    @Expose
    private List<Country> countries = new ArrayList<Country>();
    @SerializedName("languages")
    @Expose
    private List<Language> languages = new ArrayList<Language>();
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("actors")
    @Expose
    private String actors;
    @SerializedName("writer")
    @Expose
    private String writer;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("genre")
    @Expose
    private List<Genre> genre = new ArrayList<Genre>();
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("rated")
    @Expose
    private String rated;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     *
     * @return
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

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
     * The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     *
     * @param views
     * The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     *
     * @return
     * The streams
     */
    public Streams getStreams() {
        return streams;
    }

    /**
     *
     * @param streams
     * The streams
     */
    public void setStreams(Streams streams) {
        this.streams = streams;
    }

    /**
     *
     * @return
     * The poster
     */
    public Poster getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     * The poster
     */
    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    /**
     *
     * @return
     * The awards
     */
    public String getAwards() {
        return awards;
    }

    /**
     *
     * @param awards
     * The awards
     */
    public void setAwards(String awards) {
        this.awards = awards;
    }

    /**
     *
     * @return
     * The countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     *
     * @param countries
     * The countries
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     *
     * @return
     * The languages
     */
    public List<Language> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    /**
     *
     * @return
     * The plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     *
     * @param plot
     * The plot
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     *
     * @return
     * The actors
     */
    public String getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     * The actors
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     *
     * @return
     * The writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     *
     * @param writer
     * The writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     *
     * @return
     * The director
     */
    public String getDirector() {
        return director;
    }

    /**
     *
     * @param director
     * The director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     *
     * @return
     * The genre
     */
    public List<Genre> getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     * The genre
     */
    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    /**
     *
     * @return
     * The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     * The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     * The released
     */
    public String getReleased() {
        return released;
    }

    /**
     *
     * @param released
     * The released
     */
    public void setReleased(String released) {
        this.released = released;
    }

    /**
     *
     * @return
     * The rated
     */
    public String getRated() {
        return rated;
    }

    /**
     *
     * @param rated
     * The rated
     */
    public void setRated(String rated) {
        this.rated = rated;
    }

    /**
     *
     * @return
     * The year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    public void setYear(String year) {
        this.year = year;
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
