package net.mosur.tomasz.lab3;

import java.util.ArrayList;

/**
 * Created by Tomek on 08/04/2017.
 */

public class Movie {
    public static final int TO_WATCH = 1;
    public static final int WATCHED = 2;
    public static final int WATCH_CLEAR =0;
    String title;
    int id;
    int year;
    String genre;
    int watchstate;


    public Movie(String title, int year, String genre, int id) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.id = id;
        watchstate = WATCH_CLEAR;
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

    public int getWatchState() {
        return watchstate;
    }

/*    public void setWatchState(int state)
    {
        if(state == TO_WATCH || state == WATCHED || state == WATCH_CLEAR)
        {
            watchstate = state;
        }
        else throw new IllegalArgumentException("Invalid Watch_State param");
    }*/
    
    public void toWatchSwitch()
    {
        watchstate = watchstate != WATCH_CLEAR ? WATCH_CLEAR : TO_WATCH;
    }

    public void watchedSwitch()
    {
        watchstate = watchstate != WATCHED ? WATCHED : WATCH_CLEAR;
    }
}
