package com.example.devinet.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.dal.MotDAO;

import java.util.List;

public class MotBddRepository implements IMotRepository {

    private MotDAO motDAO;

    public MotBddRepository(Context context) {
        com.example.devinet.dal.AppDatabase bdd = com.example.devinet.dal.AppDatabase.getInstanceMot(context);
        motDAO = bdd.getMotDAO();
    }

    public void insert(final Mot mot) {
        new AsyncTask<Mot, Void, Void>() {
            @Override
            protected Void doInBackground(Mot... mots) {
                motDAO.insert(mots[0]);
                return null;
            }
        }.execute(mot);
    }

    List<Mot> resultat = null;

    @Override
    public LiveData<List<Mot>> get() {
        return motDAO.get();
    }

    @Override
    public Mot get(int id) {
        return motDAO.get(id);
    }

    @Override
    public LiveData<List<Mot>> getNiveau(int niveau){
        return motDAO.getNiveau(niveau);
    }

    @Override
    public List<Mot> getMotNiveau(int niveau){
        return motDAO.getNiveauList(niveau);
    }
    @Override
    public LiveData<List<Mot>> getListNiveau(int niveau, int list){
        return motDAO.getListNiveau(niveau, list);
    }

    @Override
    public void update(Mot mot) {
        //Je créé un nouveau thread(ouvrier)
        new AsyncTask<Mot, Void, Void>() {
            //Je lui dis quoi faire
            @Override
            protected Void doInBackground(Mot... mots) {
                //Inserer un Article dans la bdd
                motDAO.update(mots[0]);
                return null;
            }//Je lui dis de le faire
        }.execute(mot);
    }

    @Override
    public void delete(Mot mot) {
        new AsyncTask<Mot, Void, Void>() {
            @Override
            protected Void doInBackground(Mot... mots) {
                //Delete dans la base de données.
                motDAO.delete(mots[0]);
                return null;
            }
        }.execute(mot);
    }

    @Override
    public void delete() {
        //Je créé un nouveau thread(ouvrier)
        new AsyncTask<Void, Void, Void>() {
            //Je lui dis quoi faire
            @Override
            protected Void doInBackground(Void... voids) {
                //Inserer un Article dans la bdd
                motDAO.delete();
                return null;
            }//Je lui dis de le faire
        }.execute();
    }
}

