package com.example.devinet.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;
import com.example.devinet.dal.CategorieDAO;

import java.util.List;

public class CategorieBddRepository implements ICategorieRepository {

    private CategorieDAO categorieDAO;
    private LiveData<List<Categorie>> get = null;
    private Categorie getId = null;

    public CategorieBddRepository(Context context) {
        com.example.devinet.dal.AppDatabase bdd = com.example.devinet.dal.AppDatabase.getInstanceCategorie(context);
        categorieDAO = bdd.getCategorieDAO();
    }

    public void insert(final Categorie categorie) {
        new AsyncTask<Categorie, Void, Void>() {
            @Override
            protected Void doInBackground(Categorie... categories) {
                categorieDAO.insert(categories[0]);
                return null;
            }
        }.execute(categorie);
    }

    List<Categorie> resultat = null;

    @Override
    public LiveData<List<Categorie>> get() {

        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                get = categorieDAO.get();
            }
        };


        Thread thread1 = new Thread(task1);
        thread1.start();
        return get;

    }

    @Override
    public Categorie get(final int id) {
        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                getId = categorieDAO.get(id);
            }
        };


        Thread thread1 = new Thread(task1);
        thread1.start();
        return getId;
    }

    @Override
    public void update(Categorie categorie) {
        //Je créé un nouveau thread(ouvrier)
        new AsyncTask<Categorie, Void, Void>() {
            //Je lui dis quoi faire
            @Override
            protected Void doInBackground(Categorie... categories) {
                //Inserer un Article dans la bdd
                categorieDAO.update(categories[0]);
                return null;
            }//Je lui dis de le faire
        }.execute(categorie);
    }

    @Override
    public void delete(Categorie categorie) {
        new AsyncTask<Categorie, Void, Void>() {
            @Override
            protected Void doInBackground(Categorie... categories) {
                //Delete dans la base de données.
                categorieDAO.delete(categories[0]);
                return null;
            }
        }.execute(categorie);
    }

    @Override
    public void delete() {
        //Je créé un nouveau thread(ouvrier)
        new AsyncTask<Void, Void, Void>() {
            //Je lui dis quoi faire
            @Override
            protected Void doInBackground(Void... voids) {
                //Inserer un Article dans la bdd
                categorieDAO.delete();
                return null;
            }//Je lui dis de le faire
        }.execute();
    }
}
