package net.mosur.tomasz.lab3;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Tomek on 16/04/2017.
 */

public class MovieActivity extends AppCompatActivity {


    int position;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getIntent().getIntExtra("position", 0);
        setContentView(R.layout.movie_description);
        setTitle(((Movie)getIntent().getParcelableExtra("movie")).getTitle());
        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MovieDescriptionF MovieDescriptionF = new MovieDescriptionF();
            MovieDescriptionF.setArguments(getMovieBundle());
            fragmentTransaction.add(R.id.baner_fragment_place, MovieDescriptionF, "MovieDF");
            fragmentTransaction.addToBackStack("first");  //234234234
            fragmentTransaction.commit();
        }
        }

    public void setRating(float r)
    {
        rating = r;
    }

    public Bundle getMovieBundle()
    {
        Bundle bundle = new Bundle();
        Movie movie = getIntent().getParcelableExtra("movie");
        bundle.putInt("position", getIntent().getIntExtra("position",0));
        bundle.putParcelable("movie", movie);

        int imgId= getResources().getIdentifier("baner"+String.valueOf(movie.getId()), "drawable", getPackageName());
        bundle.putInt("imgId", imgId);


        //put 9 Film images
        Random random = new Random();
        for(int i=0; i<9; i++) {
            int rand = random.nextInt(9);
            int mImg = getResources().getIdentifier("mimg" + rand , "drawable", getPackageName());
            bundle.putInt("mimg" + String.valueOf(i), mImg);
        }
        return bundle;
    }

    @Override
    public void onBackPressed() {

        Intent it = new Intent();
        it.putExtra("rating", rating);
        it.putExtra("position", position);
        setResult(RESULT_OK,it);
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putFloat("rate", rating);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rating = savedInstanceState.getFloat("rate");
    }
}
