package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.devinet.R;
import com.example.devinet.activities.adapteur.ListAdapteur;
import com.example.devinet.activities.adapteur.NiveauAdapteur;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.view_model.CategorieVM;
import com.example.devinet.view_model.MotVM;

import java.util.ArrayList;
import java.util.List;

public class ChoixListNiveau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_list_niveau);
        getSupportActionBar().setTitle("Choix des listes");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {

            final Categorie categorie = intent.getParcelableExtra("categorie");
            if (categorie != null){
                MotVM vm = ViewModelProviders.of(this).get(MotVM.class);
                final LiveData<List<Mot>> observateur = vm.getMotNiveauLD(categorie.getIdCat());


                observateur.observe(this, new Observer<List<Mot>>() {
                    @Override
                    public void onChanged(List<Mot> mots) {

                        Log.i("NIVEAU", categorie.toString());
                        int cpt = 0 ;
                        List<Mot> motUniqueList = new ArrayList<>();
                        motUniqueList.add(mots.get(1));
                        for (int i = 2; i < mots.size(); i++) {
                            if (mots.get(i).getListe() != mots.get(i - 1).getListe()) {
                                motUniqueList.add(mots.get(i));
                            }
                        }
                        ListView maListe = findViewById(R.id.listView_choix_list);
                        ListAdapteur adapter = new ListAdapteur(ChoixListNiveau.this, R.layout.activity_choix_list_niveau, motUniqueList);
                        maListe.setAdapter(adapter);
                    }
                });
            } else{

                intent = new Intent(this,MenuActivity.class);
                startActivity(intent);
            }

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
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