package com.example.devinet.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Categorie;
import com.example.devinet.dal.CategorieDAO;
import java.util.List;

public class CategorieBddRepository implements  ICategorieRepository {
    private CategorieDAO categorieDAO;

    public CategorieBddRepository(Context context) {
        com.example.achat.dal.AppDatabase bdd = com.example.achat.dal.AppDatabase.getInstanceCategorie(context);
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
        return categorieDAO.get();
    }

    @Override
    public Categorie get(int id) {
        return categorieDAO.get(id);
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
