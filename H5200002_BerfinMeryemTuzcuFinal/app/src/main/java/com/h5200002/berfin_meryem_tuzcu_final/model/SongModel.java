package com.h5200002.berfin_meryem_tuzcu_final.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SongModel {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Album")
    @Expose
    private String album;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("ResimURL")
    @Expose
    private String resimURL;
    @SerializedName("ImgCover")
    @Expose
    private String imgCover;
    @SerializedName("Explanation")
    @Expose
    private String explanation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}