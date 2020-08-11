package com.example.devinet.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.devinet.bo.Mot;

import java.util.List;

@Dao
public interface MotDAO {
    @Insert
    void insert(Mot mt);

    @Insert
    void insert(Mot ... items);

    @Query("SELECT * FROM Mot")
    LiveData<List<Mot>> get();

    @Query("SELECT * FROM Mot WHERE idMot = :id")
    Mot get(int id);

    @Update
    void update(Mot item);

    @Delete
    void delete(Mot item);

    @Query("Delete from Mot")
    void delete();

    @Query("SELECT * FROM Mot WHERE categorie = :niveau")
    LiveData<List<Mot>> getNiveau(int niveau);

    @Query("SELECT * FROM Mot WHERE (categorie = :niveau AND liste = :liste )")
    LiveData<List<Mot>> getListNiveau(int niveau, int liste);

    @Query("SELECT * FROM Mot WHERE categorie = :niveau")
    List<Mot> getNiveauList(int niveau);
}
