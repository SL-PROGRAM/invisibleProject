package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.devinet.R;
import com.example.devinet.activities.adapteur.CaseAdateur;
import com.example.devinet.bo.Mot;
import com.example.devinet.view_model.MotVM;

import java.io.File;
import java.util.List;

public class JouerActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        MotVM vm = ViewModelProviders.of(this).get(MotVM.class);
        final LiveData<List<Mot>> observateur = vm.get();

        observateur.observe(this, new Observer<List<Mot>>() {
            @Override
            public void onChanged(List<Mot> mots) {
                ListView maListe = findViewById(R.id.lv_jouer_proposition);
                CaseAdateur adapter = new CaseAdateur(JouerActivity.this,R.layout.activity_jouer,mots);
                maListe.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);
        getSupportActionBar().setTitle("Jouer");

        ImageView img = findViewById(R.id.imgTrouve);
        img.setImageResource(R.drawable.hisoka);
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

    public void onClickBtnValider(View view) {
    }

    public void onClickBtnNext(View view) {
    }
}