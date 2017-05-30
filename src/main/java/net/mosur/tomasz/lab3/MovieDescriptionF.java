package net.mosur.tomasz.lab3;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MovieDescriptionF extends Fragment implements View.OnClickListener {


    @BindView(R.id.moviedesc_image)ImageView baner;
    @BindView(R.id.moviedesc_desc)TextView description;
    @BindView(R.id.moviedesc_rating)RatingBar rating;
    @BindView(R.id.moviedesc_title) TextView title;
    Guideline guideline;
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
                             final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_movie_description, container, false);
        movie = getArguments().getParcelable("movie");
        position = getArguments().getInt("position", 0);
        imgId = getArguments().getInt("imgId");
        ButterKnife.bind(this, view);
        setData();

        backButtonListener(view);

        baner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                MovieImagesF mif = new MovieImagesF();
                MovieImagesF2 mif2 = new MovieImagesF2();
                mif.setArguments(getArguments());
                mif2.setArguments(getArguments());
                fragmentTransaction.replace(R.id.baner_fragment_place, mif);
                fragmentTransaction.add(R.id.fragment_container2, mif2);
                fragmentTransaction.addToBackStack("cesond");  //234234234
                fragmentTransaction.commit();
            }
        });

        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        return view;
    }

    private void backButtonListener(final View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK && view==v) {
                    ((MovieActivity)getActivity()).setRating(rating.getRating());
                    (getActivity()).onBackPressed();
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void setData()
    {
        if(guideline!=null);
        baner.setImageDrawable(getActivity().getDrawable(imgId));
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        rating.setRating(movie.getRating());

    }

    @Override
    public void onClick(View v) {

    }
}
