package com.mycompany.model;

import com.opencsv.bean.CsvBindByName;

public class Movie {

    @CsvBindByName(column = "movieId")
    private long movieID;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "year")
    private int year;

    @CsvBindByName(column = "genres")
    private String genre;

    public long getMovieID() {
        return movieID;
    }

    public void setMovieID(long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
