/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Zaw L Than
 */
public class DVD {
    private String id;
    private String title;
    private String releaseDate;
    private String MPAArating;
    private String director;
    private String studio;
    private String userRating;

    public DVD(String id) {
        this.id = id;
    }

    public DVD(String id, String title, String releaseDate, String MPAArating, String director, String studio, String userRating) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAArating = MPAArating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAArating() {
        return MPAArating;
    }

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    } 
}
