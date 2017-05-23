package net.mosur.tomasz.lab3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

/**
 * Created by Tomek on 16/04/2017.
 */

public class MovieActivity extends AppCompatActivity {

/*    @BindView(R.id.moviedesc_image)ImageView baner;
    @BindView(R.id.moviedesc_desc)TextView description;
    @BindView(R.id.moviedesc_rating)RatingBar rating;
    @BindView(R.id.moviedesc_title) TextView title;
    Movie movie;*/
    int position;

    float rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getIntent().getIntExtra("position",0);
        setContentView(R.layout.movie_description);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MovieDescriptionF MovieDescriptionF = new MovieDescriptionF();
        MovieDescriptionF.setArguments(getMovieBundle());
        fragmentTransaction.add(R.id.baner_fragment_place, MovieDescriptionF);
        fragmentTransaction.commit();
    }

/*    public void setData()
    {
        int imgId= getResources().getIdentifier("baner"+String.valueOf(movie.getId()), "drawable", getPackageName());
        baner.setImageDrawable(getDrawable(imgId));
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        rating.setRating(movie.getRating());

    }*/

    public void setRating(float r)
    {
        rating = r;
    }
    public Bundle getMovieBundle()
    {
        Bundle bundle = new Bundle();
        Movie movie = getIntent().getParcelableExtra("movie");
        int imgId= getResources().getIdentifier("baner"+String.valueOf(movie.getId()), "drawable", getPackageName());
        bundle.putInt("position", getIntent().getIntExtra("position",0));
        bundle.putParcelable("movie", movie);
        bundle.putInt("imgId", imgId);
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

}
