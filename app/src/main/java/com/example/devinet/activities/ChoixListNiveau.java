package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.devinet.R;

public class ChoixListNiveau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_list_niveau);
    }

    public void onClickBtnList(View view) {
        Intent intent = new Intent(this,JouerActivity.class);
        startActivity(intent);
    }
}