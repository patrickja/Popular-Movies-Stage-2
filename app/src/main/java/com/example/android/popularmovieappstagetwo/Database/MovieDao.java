package com.example.android.popularmovieappstagetwo.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.popularmovieappstagetwo.Models.Favorites;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM FavMovies ORDER BY id")
    LiveData<List<Favorites>> loadAllMovies();

    @Insert
    void insertMovie(Favorites favMovie);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Favorites favMovie);

    @Delete
    void deleteMovie(Favorites favMovie);

    @Query("SELECT * FROM FavMovies WHERE id = :id")
    Favorites loadMovieById(int id);
}