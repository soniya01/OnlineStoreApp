package com.soniyaprojects.onlinestoreapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {}, version = 1)
public abstract class DatabaseBuilder extends RoomDatabase{

    @Override
    public void clearAllTables() {

    }
}
