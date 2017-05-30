package net.mosur.tomasz.lab3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tomek on 08/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList <Movie> movies= new ArrayList<>();
    Movie lastDeleted;
    private RecyclerView recyclerView;
    private Resources resources;
    static final int LEFT_SIDE = 0;
    static final int RIGHT_SIDE = 1;
    private ItemTouchHelper.Callback touchCallback;
    private ItemTouchHelper itemTouchHelper;


    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView movie_image;
        TextView movie_genre;
        TextView movie_title;
        TextView movie_year;
        ImageView watch_status;


        public MyViewHolder(View itemView) {
            super(itemView);
            movie_image = (ImageView)itemView.findViewById(R.id.movie_image);
            movie_genre = (TextView) itemView.findViewById(R.id.movie_genre);
            movie_title = (TextView) itemView.findViewById(R.id.movie_title);
            movie_year = (TextView) itemView.findViewById(R.id.movie_year);
            watch_status = (ImageView) itemView.findViewById(R.id.watchedButton);


        }
    }

    public MyAdapter(ArrayList<Movie> movies, android.support.v7.widget.RecyclerView recyclerView) {
        this.movies = movies;
        this.recyclerView = recyclerView;
        resources=recyclerView.getResources();
        touchCallback = new MovieListTouch(this);
        itemTouchHelper= new ItemTouchHelper(touchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }


    public void setItemRate(int position, float rate)
    {
        movies.get(position).setRating(rate);
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

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(recyclerView.getContext(), MovieActivity.class);
                it.putExtra("movie", movies.get(recyclerView.getChildAdapterPosition(v)));
                it.putExtra("position", recyclerView.getChildAdapterPosition(v));
                ((Activity) recyclerView.getContext()).startActivityForResult(it,1);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Movie movie = movies.get(recyclerView.getChildAdapterPosition(v));
                movie.switchToWatch();
                updateWatchStateImage(recyclerView.getChildViewHolder(v), movie);
                return true;
            }
        });

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
        updateWatchStateImage(holder, movie);
    }


    private void updateWatchStateImage(RecyclerView.ViewHolder holder, Movie movie) {

        if(movie.getToWatch() == Movie.TO_WATCH)
        {
            if(holder.getItemViewType() == LEFT_SIDE )
                ((MyViewHolder)holder).movie_year.setPadding(0,0,150,0); // to avoid collision

            ((MyViewHolder)holder).watch_status.setImageResource(
                    resources.getIdentifier("towatch", "drawable", recyclerView.getContext().getPackageName()));
            ((MyViewHolder)holder).watch_status.setVisibility(View.VISIBLE);
        }
        else
        {
            ((MyViewHolder)holder).watch_status.setVisibility(View.INVISIBLE);
            if(holder.getItemViewType() == LEFT_SIDE )
                ((MyViewHolder)holder).movie_year.setPadding(0,0,0,0);
        }
    }

    public void onItemDismiss(int position) {

        lastDeleted = (movies.get(position));
        movies.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Movie getLastDeleted() {
        return lastDeleted;
    }

    public void addMovie(Movie m)
    {
        movies.add(0,m);
        lastDeleted= null;
    }
}
