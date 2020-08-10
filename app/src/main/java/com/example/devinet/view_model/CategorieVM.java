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


    private ICategorieRepository articleRepository;

    private LiveData<List<Categorie>> observateur = null;

    public CategorieVM(@NonNull Application application)
    {
        super(application);
        articleRepository = new CategorieBddRepository(application);
        observateur = articleRepository.get();
    }

    public LiveData<List<Categorie>> get()
    {
        return observateur;
    }

    public Categorie get(int id){
        return articleRepository.get(id);
    };

    void insert(Categorie item)
    {
        articleRepository.insert(item);
    }

    void update(Categorie item)
    {
        articleRepository.update(item);
    }

    void delete(Categorie item)
    {
        articleRepository.delete(item);
    }

    void delete()
    {
        articleRepository.delete();
    }
}
