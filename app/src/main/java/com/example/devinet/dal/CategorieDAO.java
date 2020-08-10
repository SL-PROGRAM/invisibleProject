package com.example.devinet.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.devinet.bo.Categorie;

import java.util.List;

    @Dao
    public interface CategorieDAO {
        @Insert
        void insert(Categorie mt);

        @Insert
        void insert(Categorie ... items);

        @Query("SELECT * FROM Categorie")
        LiveData<List<Categorie>> get();

        @Query("SELECT * FROM Categorie WHERE idCat = :id")
        Categorie get(int id);

        @Update
        void update(Categorie item);

        @Delete
        void delete(Categorie item);

        @Query("Delete from Categorie")
        void delete();
}
