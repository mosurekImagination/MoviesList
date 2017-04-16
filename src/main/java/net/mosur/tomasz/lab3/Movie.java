package net.mosur.tomasz.lab3;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Tomek on 08/04/2017.
 */

public class Movie implements Parcelable{
    public static final int TO_WATCH = 1;
    public static final int WATCHED = 2;
    public static final int WATCH_CLEAR =0;
    private String title;
    private String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et mollis mi, in venenatis urna. Mauris eu nunc consequat eros facilisis posuere. Curabitur feugiat nulla malesuada mi tempor vestibulum. Aliquam molestie dolor a tellus elementum, vel luctus turpis laoreet. Nunc et interdum magna, a imperdiet libero. Phasellus libero nisl, maximus vel maximus et, porttitor eu ex. Donec elementum hendrerit orci sit amet pellentesque. Praesent id nibh ac nisi semper gravida. Mauris dignissim est dolor, nec vulputate ex suscipit finibus. Quisque diam mi, suscipit ac lobortis ut, viverra quis lorem. ";
    private float rating;
    private int id;
    private int year;
    private String genre;
    private int watchstate;
    
    public static final Parcelable.Creator<Movie> CREATOR= new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(Parcel in)
    {
        title=in.readString();
        genre=in.readString();
        year=in.readInt();
        id=in.readInt();
        rating= in.readFloat();
        watchstate = in.readInt();
        description = in.readString();
    }

    public Movie(String title, int year, String genre, int id) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.id = id;
        watchstate = WATCH_CLEAR;
    }

    public float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
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

    
    public void switchToWatch()
    {
        watchstate = watchstate != WATCH_CLEAR ? WATCH_CLEAR : TO_WATCH;
    }

    public void switchWatched()
    {
        watchstate = watchstate != WATCHED ? WATCHED : WATCH_CLEAR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeInt(year);
        dest.writeInt(id);
        dest.writeFloat(rating);
        dest.writeInt(watchstate);
        dest.writeString(description);
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
