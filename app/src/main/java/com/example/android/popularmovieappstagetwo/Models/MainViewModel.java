package com.example.android.popularmovieappstagetwo.Models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.android.popularmovieappstagetwo.Database.MovieDatabase;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<Favorites>> movies;

    public MainViewModel(Application application) {
        super(application);
        MovieDatabase database = MovieDatabase.getInstance(this.getApplication());
        movies = database.movieDao().loadAllMovies();
    }

    public LiveData<List<Favorites>> getMovies() {
        return movies;
    }
}