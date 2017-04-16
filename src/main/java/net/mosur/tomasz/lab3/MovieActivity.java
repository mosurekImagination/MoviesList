package net.mosur.tomasz.lab3;

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

    @BindView(R.id.moviedesc_image)ImageView baner;
    @BindView(R.id.moviedesc_desc)TextView description;
    @BindView(R.id.moviedesc_rating)RatingBar rating;
    @BindView(R.id.moviedesc_title) TextView title;
    Movie movie;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_description);
        ButterKnife.bind(this);
        movie = getIntent().getParcelableExtra("movie");
        position = getIntent().getIntExtra("position",0);
        setData();
//        ActionBar a = getSupportActionBar();
//        a.setDisplayHomeAsUpEnabled(false);
    }

    public void setData()
    {
        int imgId= getResources().getIdentifier("baner"+String.valueOf(movie.getId()), "drawable", getPackageName());
        baner.setImageDrawable(getDrawable(imgId));
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        rating.setRating(movie.getRating());
    }


    @Override
    public void onBackPressed() {
        Intent it = new Intent();
        it.putExtra("rating", rating.getRating());
        it.putExtra("position", position);
        setResult(RESULT_OK,it);
        finish();
    }

}
