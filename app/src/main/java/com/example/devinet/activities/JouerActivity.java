package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devinet.R;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.IMotRepository;
import com.example.devinet.repository.MotBddRepository;
import com.example.devinet.view_model.MotVM;

import java.util.ArrayList;
import java.util.List;

public class JouerActivity extends AppCompatActivity {

    List<Mot> motsList = new ArrayList<>();
    Mot motATrouver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);
        getSupportActionBar().setTitle("Jouer");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent != null){
            final Mot mot = intent.getParcelableExtra("mot");
            if (mot != null){

                MotVM vm = ViewModelProviders.of(this).get(MotVM.class);
                final LiveData<List<Mot>> observateur = vm.getListNiveau(mot.getCategorie(), mot.getListe());

                final IMotRepository motRepository = new MotBddRepository(this);

                observateur.observe(this, new Observer<List<Mot>>() {
                    @Override
                    public void onChanged(List<Mot> mots) {
                        motsList = mots;
                        Log.i("MOT", motsList.toString());

                        definirMotATrouver();

                        ImageView imageView = findViewById(R.id.imgTrouve);
                        Resources res = getResources();
                        int resourceId = res.getIdentifier(motATrouver.getImg(), "drawable", getPackageName() );
                        imageView.setImageResource(resourceId);

                        TextView tv_proposition = findViewById(R.id.tv_motMelange);
                        tv_proposition.setText(motATrouver.getProposition());

                        TextView valider = findViewById(R.id.circle_add);
                        valider.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                EditText et_proposition = findViewById(R.id.et_proposition);
                                String proposition = et_proposition.getText().toString();
                                motATrouver.setProposition(proposition);
                                motRepository.update(motATrouver);

                                if(motATrouver.getMot().equalsIgnoreCase(proposition)){
                                    Toast.makeText(JouerActivity.this, "Bravo, vous avez trouvé! " , Toast.LENGTH_SHORT).show();
                                    motATrouver.setProgress(1);
                                    motRepository.update(motATrouver);
                                }
                                else {
                                    Toast.makeText(JouerActivity.this, "Mauvaise réponse!" , Toast.LENGTH_SHORT).show();
                                }

                                Intent intent = new Intent(JouerActivity.this,JouerActivity.class);
                                intent.putExtra("mot", motATrouver);
                                startActivity(intent);
                            }
                        });

                        TextView suivant = findViewById(R.id.circle_next);
                        suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                motATrouver.setProposition(motATrouver.getMot());
                                motRepository.update(motATrouver);
                                motATrouver.setProgress(0);
                                motRepository.update(motATrouver);

                                Intent intent = new Intent(JouerActivity.this,JouerActivity.class);
                                intent.putExtra("mot", motATrouver);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }

        for (Mot item : motsList){
            Log.i("MOT LIST", "onResume: "+ item.toString());
        }
    }

    private void definirMotATrouver() {
        int indice = 0;
        for (Mot item : motsList){
            if (!item.getMot().equalsIgnoreCase(item.getProposition())){
                motATrouver = item;
                break;
            }
            indice++;
            if(indice == motsList.size()){
                Intent intent = new Intent(this,SelectionNiveauActivity.class);
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