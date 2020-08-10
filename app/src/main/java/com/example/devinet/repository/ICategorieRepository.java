package com.example.devinet.repository;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;

import java.util.List;

public interface ICategorieRepository {
    void insert(Categorie item);
    LiveData<List<Categorie>> get();
    Categorie get(int id);
    void update(Categorie item);
    void delete(Categorie item);
    void delete();
}
