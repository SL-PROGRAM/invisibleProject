package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.devinet.R;
import com.example.devinet.activities.adapteur.NiveauAdapteur;
import com.example.devinet.bo.Categorie;
import com.example.devinet.view_model.CategorieVM;

import java.util.List;

public class SelectionNiveauActivity extends AppCompatActivity {

    private ListView maListe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_niveau);
        getSupportActionBar().setTitle("Sélection du niveau");
    }

    @Override
    protected void onResume() {
        super.onResume();

        CategorieVM categorieVM = ViewModelProviders.of(this).get(CategorieVM.class);
        LiveData<List<Categorie>> observateur = categorieVM.get();
        observateur.observe(this, new Observer<List<Categorie>>() {
                    @Override
                    public void onChanged(List<Categorie> categories) {
                        Log.i("WOLOLO", "onChanged: "+categories.size());
                        NiveauAdapteur niveauAdapteur = new NiveauAdapteur(SelectionNiveauActivity.this, R.layout.style_ligne_liste, categories);
                        maListe.setAdapter(niveauAdapteur);
                    }
                });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onClickChoixListe(View view) {
        Intent intent = new Intent(this,ChoixListNiveau.class);
        startActivity(intent);
    }

    public void onClickActionBack(MenuItem item) {
        super.onBackPressed();
    }

    public void onClickActionParametres(MenuItem item) {
        Intent intent = new Intent(this,ParametreActivity.class);
        startActivity(intent);
    }

    public void onClickActionAPropos(MenuItem item) {
        Intent intent = new Intent(this,AProposActivity.class);
        startActivity(intent);
    }

    public void onClickActionAccueil(MenuItem item) {
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}