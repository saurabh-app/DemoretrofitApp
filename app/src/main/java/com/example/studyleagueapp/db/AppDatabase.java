package com.example.studyleagueapp.db;

import com.example.studyleagueapp.model.Product;
import com.example.studyleagueapp.model.Productmodel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Productmodel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
