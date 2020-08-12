package com.example.devinet.repository;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;

import java.util.List;

public interface IMotRepository {

    void insert(Mot item);
    LiveData<List<Mot>> get();
    List<Mot> getMotNiveau(int niveau);
    LiveData<List<Mot>> getMotNiveauLD(int categorie);
    Mot get(int id);
    void update(Mot item);
    void delete(Mot item);
    void delete();
}
