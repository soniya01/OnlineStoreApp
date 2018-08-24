package com.soniyaprojects.onlinestoreapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.soniyaprojects.onlinestoreapp.db.model.Category;
import com.soniyaprojects.onlinestoreapp.db.model.Product;
import com.soniyaprojects.onlinestoreapp.db.model.Rankings;
import com.soniyaprojects.onlinestoreapp.db.model.Tax;
import com.soniyaprojects.onlinestoreapp.db.model.Variants;

@Database(entities = {Category.class, Product.class, Rankings.class, Tax.class, Variants.class}, version = 1, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase{

    @Override
    public void clearAllTables() {

    }
}
