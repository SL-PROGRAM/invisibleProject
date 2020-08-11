package com.example.devinet.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.dal.MotDAO;

import java.util.List;

public class MotBddRepository implements IMotRepository {

    private MotDAO motDAO;
    private LiveData<List<Mot>> get;
    private Mot getId;
    private List<Mot> getNiveau;

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
        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                get = motDAO.get();
            }
        };


        Thread thread1 = new Thread(task1);
        thread1.start();
        return get;
    }


    @Override
    public Mot get(final int id) {
        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                getId = motDAO.get(id);
            }
        };


        Thread thread1 = new Thread(task1);
        thread1.start();
        return getId;
    }

    @Override
    public List<Mot> getMotNiveau(final int niveau){
        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                getNiveau = motDAO.getNiveauList(niveau);
            }
        };
        Thread thread1 = new Thread(task1);
        thread1.start();
        return getNiveau;
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

