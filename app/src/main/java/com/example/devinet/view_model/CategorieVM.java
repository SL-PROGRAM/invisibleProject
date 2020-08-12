package com.example.devinet.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;
import com.example.devinet.repository.CategorieBddRepository;
import com.example.devinet.repository.ICategorieRepository;

import java.util.List;

public class CategorieVM extends AndroidViewModel {


    private ICategorieRepository categorieRepository;

    private LiveData<List<Categorie>> observateur = null;

    public CategorieVM(@NonNull Application application)
    {
        super(application);
        categorieRepository = new CategorieBddRepository(application);
        observateur = categorieRepository.get();
    }

    public LiveData<List<Categorie>> get()
    {
        return observateur;
    }

    public Categorie get(int id){
        return categorieRepository.get(id);
    };

    void insert(Categorie item)
    {
        categorieRepository.insert(item);
    }

    void update(Categorie item)
    {
        categorieRepository.update(item);
    }

    void delete(Categorie item)
    {
        categorieRepository.delete(item);
    }

    void delete()
    {
        categorieRepository.delete();
    }
}
