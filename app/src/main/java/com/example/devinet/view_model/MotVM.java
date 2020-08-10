package com.example.devinet.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.repository.MotBddRepository;
import com.example.devinet.repository.IMotRepository;

import java.util.List;

public class MotVM extends AndroidViewModel {


    private IMotRepository articleRepository;

    private LiveData<List<Mot>> observateur = null;

    public MotVM(@NonNull Application application)
    {
        super(application);
        articleRepository = new MotBddRepository(application);
        observateur = articleRepository.get();
    }

    public LiveData<List<Mot>> get()
    {
        return observateur;
    }

    public Mot get(int id){
        return articleRepository.get(id);
    };

    void insert(Mot item)
    {
        articleRepository.insert(item);
    }

    void update(Mot item)
    {
        articleRepository.update(item);
    }

    void delete(Mot item)
    {
        articleRepository.delete(item);
    }

    void delete()
    {
        articleRepository.delete();
    }
}
