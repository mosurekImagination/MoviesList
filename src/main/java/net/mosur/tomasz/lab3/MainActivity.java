package net.mosur.tomasz.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    
    MyAdapter myAdapter;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent ratedIntent) {
        super.onActivityResult(requestCode, resultCode, ratedIntent);
        myAdapter.setItemRate(ratedIntent.getIntExtra("position", 0), ratedIntent.getFloatExtra("rating", 0));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("movies", myAdapter.getMovies());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Movies List");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_list);
        recyclerView.setHasFixedSize(true);       // OPTIMISATION
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Movie> movies = generateMovies(10);
        myAdapter = new MyAdapter(movies, recyclerView);
        recyclerView.setAdapter(myAdapter);
    }


    public static ArrayList<Movie> generateMovies(int loops)
    {

        ArrayList<Movie> movies = new ArrayList<>();

        for(int i=0; i<loops; i++) { //USE ID FROM 1 TO 4 BECAUSE ONLY 4 IMAGES WERE UPLOADED TO TEST
            movies.add(new Movie("Terminator", 1998, "Action", 1));
            movies.add(new Movie("Minions", 2014, "Comedy", 2));
            movies.add(new Movie("Fast & Furious", 2002, "Sci-fi", 3));
            movies.add(new Movie("Gone with the Wind", 1956, "Dramatic", 4));
        }
        return movies;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.backEraseB:
                if(myAdapter.getLastDeleted()!= null) {
                    myAdapter.addMovie(myAdapter.getLastDeleted());
                    myAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Nie usunięto filmu", Toast.LENGTH_SHORT).show();}
                return true;
            default:

                return true;
        }
    }
}
