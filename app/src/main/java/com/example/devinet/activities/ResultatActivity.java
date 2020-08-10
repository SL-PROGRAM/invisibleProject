package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.devinet.R;

public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat_activity);
    }

    public void onClickChoixDetail(View view) {
        Intent intent = new Intent(this, ResultatDetailActivity.class);
        startActivity(intent);
    }
}