package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.devinet.R;

public class SelectionNiveauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_niveau);
    }

    public void onClickChoixListe(View view) {
        Intent intent = new Intent(this,ChoixListNiveau.class);
        startActivity(intent);
    }
}