package net.mosur.tomasz.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Movies List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_list);
        recyclerView.setHasFixedSize(true);       // OPTIMISATION
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Movie> movies = generateMovies(1);

        recyclerView.setAdapter(new MyAdapter(movies, recyclerView));
    }

    public static ArrayList<Movie> generateMovies(int loops)
    {

        ArrayList<Movie> movies = new ArrayList<>();

        Movie watched = new Movie("Terminatory", 1998, "Action", 1);
        watched.toWatchSwitch();
        Movie to_watch = new Movie("Terminators", 1998, "Action", 1);
        to_watch.watchedSwitch();
        movies.add(to_watch);
        movies.add(to_watch);
        movies.add(watched);
        movies.add(to_watch);

        for(int i=0; i<loops; i++) { //USE ID FROM 1 TO 4 BECAUSE ONLY 4 IMAGES WERE UPLOADED TO TEST
            movies.add(new Movie("Terminator", 1998, "Action", 1));
            movies.add(new Movie("Minions", 2014, "Comedy", 2));
            movies.add(new Movie("Fast & Furious", 2002, "Sci-fi", 3));
            movies.add(new Movie("Gone with the Wind", 1956, "Dramatic", 4));
        }
        return movies;
    }
}
