package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.devinet.R;
import com.example.devinet.activities.adapteur.NiveauAdapteur;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.view_model.CategorieVM;
import com.example.devinet.view_model.MotVM;

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

        MotVM vm = ViewModelProviders.of(this).get(MotVM.class);
        final LiveData<List<Mot>> observateur = vm.get();

        observateur.observe(this, new Observer<List<Mot>>() {
            @Override
            public void onChanged(List<Mot> mots) {
                ListView maListe = findViewById(R.id.listView);
                ArrayAdapter adapter = new ArrayAdapter(ChoixListNiveau.this,R.layout.activity_choix_list_niveau,mots);
                maListe.setAdapter(adapter);
            }
        });
    }

    public void onClickBtnList(View view) {
        Intent intent = new Intent(this,JouerActivity.class);
        startActivity(intent);
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