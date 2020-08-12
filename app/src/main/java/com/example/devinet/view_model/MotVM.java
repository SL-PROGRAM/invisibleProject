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


    private IMotRepository motRepository;

    private LiveData<List<Mot>> observateur = null;

    public MotVM(@NonNull Application application)
    {
        super(application);
        motRepository = new MotBddRepository(application);
        observateur = motRepository.get();
    }

    public LiveData<List<Mot>> get()
    {
        return observateur;
    }

    public Mot get(int id){
        return motRepository.get(id);
    };

    public List<Mot> getMotNiveau(int categorie){
        return motRepository.getMotNiveau(categorie);
    }

    public LiveData<List<Mot>> getMotNiveauLD(int categorie){
        return motRepository.getMotNiveauLD(categorie);
    }

    public LiveData<List<Mot>> getListNiveau(int categorie, int liste) {
        return motRepository.getListNiveau(categorie, liste);
    }

    void insert(Mot item)
    {
        motRepository.insert(item);
    }

    void update(Mot item)
    {
        motRepository.update(item);
    }

    void delete(Mot item)
    {
        motRepository.delete(item);
    }

    void delete()
    {
        motRepository.delete();
    }
}
