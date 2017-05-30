package net.mosur.tomasz.lab3;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieImagesF2 extends Fragment {

    @BindView(R.id.mAImage1)ImageView mAImage1;
    @BindView(R.id.mAImage2)ImageView mAImage2;
    @BindView(R.id.mAImage3)ImageView mAImage3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        View view = inflater.inflate(R.layout.fragment_movie_images2, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}