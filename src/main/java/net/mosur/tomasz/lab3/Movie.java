package net.mosur.tomasz.lab3;

import java.util.ArrayList;

/**
 * Created by Tomek on 08/04/2017.
 */

public class Movie {

    String title;
    int id;
    int year;
    String genre;


    public Movie(String title, int year, String genre, int id) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }
}
