package com.example.studyleagueapp.db;

import com.example.studyleagueapp.model.Productmodel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ProductDao {
    @Insert
    void insert(Productmodel productmodel);

    @Query("SELECT * FROM Productmodel")
    List<Productmodel> getAll();
}
