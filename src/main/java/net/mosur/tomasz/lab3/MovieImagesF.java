package net.mosur.tomasz.lab3;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieImagesF.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieImagesF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieImagesF extends Fragment {

    Movie movie;

    @BindView(R.id.mImage1)ImageView mImage1;
    @BindView(R.id.mImage2)ImageView mImage2;
    @BindView(R.id.mImage3)ImageView mImage3;
    @BindView(R.id.mImage4)ImageView mImage4;
    @BindView(R.id.mImage5)ImageView mImage5;
    @BindView(R.id.mImage6)ImageView mImage6;
    @BindView(R.id.mImage7)ImageView mImage7;
    @BindView(R.id.mImage8)ImageView mImage8;
    @BindView(R.id.mImage9)ImageView mImage0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = getArguments().getParcelable("movie");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_images, container, false);

        ButterKnife.bind(this, view);
        setImages();
        backButtonListener(view);


        return view;
    }

    private void backButtonListener(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    MovieDescriptionF mdf = new MovieDescriptionF();
                    mdf.setArguments(getArguments());
                    fragmentTransaction.replace(R.id.baner_fragment_place, mdf);
                    fragmentTransaction.commit();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void setImages()
    {
        mImage1.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg1", 0)));
        mImage2.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg2", 0)));
        mImage3.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg3", 0)));
        mImage4.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg4", 0)));
        mImage5.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg5", 0)));
        mImage6.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg6", 0)));
        mImage7.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg7", 0)));
        mImage8.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg8", 0)));
        mImage0.setImageDrawable(getActivity().getDrawable(getArguments().getInt("mimg0", 0)));

    }
}
