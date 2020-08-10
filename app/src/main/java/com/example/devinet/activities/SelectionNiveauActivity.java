package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.devinet.R;

public class SelectionNiveauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_niveau);
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