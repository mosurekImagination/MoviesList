package net.mosur.tomasz.lab3;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MovieDescriptionF extends Fragment {

    @BindView(R.id.moviedesc_image)ImageView baner;
    @BindView(R.id.moviedesc_desc)TextView description;
    @BindView(R.id.moviedesc_rating)RatingBar rating;
    @BindView(R.id.moviedesc_title) TextView title;
    Movie movie;
    int position;
    int imgId;

    public MovieDescriptionF() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_description, container, false);
        movie = getArguments().getParcelable("movie");
        position = getArguments().getInt("position", 0);
        imgId = getArguments().getInt("imgId");
        ButterKnife.bind(this, view);
        setData();

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    ((MovieActivity)getActivity()).setRating(rating.getRating());
                    (getActivity()).onBackPressed();
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    //    return inflater.inflate(R.layout.fragment_movie_description, container, false);
    }

    public void setData()
    {
        baner.setImageDrawable(getActivity().getDrawable(imgId));
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        rating.setRating(movie.getRating());

    }



}
