package net.mosur.tomasz.lab3;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tomek on 08/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter{

    private ArrayList <Movie> movies= new ArrayList<>();
    private RecyclerView recyclerView;
    private Resources resources;
    static final int LEFT_SIDE = 0;
    static final int RIGHT_SIDE = 1;

    private class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView movie_image;
        TextView movie_genre;
        TextView movie_title;
        TextView movie_year;

        public MyViewHolder(View itemView) {
            super(itemView);
            movie_image = (ImageView)itemView.findViewById(R.id.movie_image);
            movie_genre = (TextView) itemView.findViewById(R.id.movie_genre);
            movie_title = (TextView) itemView.findViewById(R.id.movie_title);
            movie_year = (TextView) itemView.findViewById(R.id.movie_year);
        }
    }

    public MyAdapter(ArrayList<Movie> movies, android.support.v7.widget.RecyclerView recyclerView) {
        this.movies = movies;
        this.recyclerView = recyclerView;
        resources=recyclerView.getResources();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType==LEFT_SIDE) {
             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        }
        else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout_right, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? LEFT_SIDE : RIGHT_SIDE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         Movie movie = movies.get(position);
        int imgId= resources.getIdentifier("mid"+String.valueOf(movie.getId()), "drawable", recyclerView.getContext().getPackageName());
        ((MyViewHolder)holder).movie_image.setImageDrawable(recyclerView.getContext().getDrawable(imgId));
        ((MyViewHolder)holder).movie_title.setText(movie.getTitle());
        ((MyViewHolder)holder).movie_year.setText(String.valueOf(movie.getYear()));
        ((MyViewHolder)holder).movie_genre.setText(movie.getGenre());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
