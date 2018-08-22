package com.soniyaprojects.onlinestoreapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.soniyaprojects.onlinestoreapp.db.DatabaseBuilder;

public class OnlineStoreApplication extends Application {

    private static final String DATABASE_NAME = "OnlineStoreAppDb";
    private DatabaseBuilder databaseBuilder;

    @Override
    public void onCreate() {
        super.onCreate();
        createDatabase();
    }

    /**
     * Create local database using Room persistence Library, only once when app is installed
     */
    private void createDatabase(){
        if(databaseBuilder == null){
            databaseBuilder = Room.databaseBuilder(getApplicationContext(),
                    DatabaseBuilder.class,
                    DATABASE_NAME)
                    .build();
        }
    }

    public DatabaseBuilder getDatabase(){
        return databaseBuilder;
    }
}
