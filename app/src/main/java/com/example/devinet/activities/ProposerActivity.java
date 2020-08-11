package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.devinet.R;
import com.example.devinet.bo.Categorie;
import com.example.devinet.repository.CategorieBddRepository;
import com.example.devinet.repository.ICategorieRepository;
import com.example.devinet.view_model.CategorieVM;

import java.util.List;

public class ProposerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposer);
        getSupportActionBar().setTitle("Proposer une image");

        Spinner dropdown = findViewById(R.id.spinner);
        CategorieVM categorieVM = ViewModelProviders.of(this).get(CategorieVM.class);

        LiveData<List<Categorie>> listeCategorie = categorieVM.get();

//        ArrayAdapter<Categorie> adapter = new ArrayAdapter<Categorie>(this,R.layout.support_simple_spinner_dropdown_item, listeCategorie);

//        dropdown.setAdapter(adapter);
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

    public void onClickBtnAjouter(View view) {
        int nbrLettre = 0;
        EditText et_proposition = findViewById(R.id.et_proposition);
        nbrLettre = et_proposition.length();

        Toast.makeText(this, "Le mot a été ajouté " + nbrLettre , Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnQuitter(View view) {
        super.onBackPressed();
    }

}