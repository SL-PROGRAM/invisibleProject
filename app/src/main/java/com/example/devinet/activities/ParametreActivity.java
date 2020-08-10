package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.devinet.R;

public class ParametreActivity extends AppCompatActivity{

    SwitchCompat mySwitchSon = null;
    SwitchCompat mySwitchVibrate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);

        mySwitchSon = findViewById(R.id.switch_son);
        mySwitchSon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE,0);
                    Toast.makeText(ParametreActivity.this, "SON ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                    Toast.makeText(ParametreActivity.this, "SON OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mySwitchVibrate = findViewById(R.id.switch_vibration);
        mySwitchVibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setRingerMode(2);
                    Toast.makeText(ParametreActivity.this, "VIBRATE ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setRingerMode(1);
                    Toast.makeText(ParametreActivity.this, "VIBRATE OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_parametres).setVisible(false);
        menu.findItem(R.id.action_accueil).setVisible(false);
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