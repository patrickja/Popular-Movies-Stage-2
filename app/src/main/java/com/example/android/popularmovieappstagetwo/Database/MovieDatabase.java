package com.example.android.popularmovieappstagetwo.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.android.popularmovieappstagetwo.Models.Constants;
import com.example.android.popularmovieappstagetwo.Models.Favorites;

@Database(entities = {Favorites.class}, version = 3, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase{

    private static final Object LOCK = new Object();
    private static MovieDatabase sInstance;

    public static MovieDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDatabase.class, Constants.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract MovieDao movieDao();
}