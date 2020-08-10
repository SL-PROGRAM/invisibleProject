package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.devinet.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ICategorieRepository categorieRepository = new CategorieBddRepository(this);
        CategorieVM categorieVM = ViewModelProviders.of(this).get(CategorieVM.class);

        LiveData<List<Categorie>> observateurCategorie = CategorieVM.get();

        Categorie categorie = new Categorie(0, "Categorie pour test");
        categorieRepository.insert(categorie);

        observateurCategorie.observe(this, new Observer<List<Categorie>>() {
            @Override
            public void onChanged(List<Categorie> categories) {
                for (Categorie item : categories)
                {
                    Log.i("test categorie", "Item : "+item.toString());
                }
            }
        });

        IMotRepository motRepository = new MotBddRepository(this);
        MotVM motVM = ViewModelProviders.of(this).get(MotVM.class);

        LiveData<List<Mot>> observateurMot = MotVM.get();
        Mot mot = new Mot(0, "chemin de l'image", "Mot", "proposition", 1);
        motRepository.insert(mot);

        observateurMot.observe(this, new Observer<List<Mot>>() {
            @Override
            public void onChanged(List<Mot> mots) {
                for (Mot item : mots)
                {
                    Log.i("test mot", "Item : "+item.toString());
                }
            }
        });





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                /* DO EDIT */
                return true;
            case R.id.action_parametres:
                /* DO ADD */
                return true;
            case R.id.action_aPropos:
                /* DO DELETE */
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickBtnJouer(View view) {
        Intent intent = new Intent(this,SelectionNiveauActivity.class);
        startActivity(intent);
    }

    public void onClickBtnResultat(View view) {
        Intent intent = new Intent(this,ResultatActivity.class);
        startActivity(intent);
    }

    public void onClickBtnProposer(View view) {
        Intent intent = new Intent(this,ProposerActivity.class);
        startActivity(intent);
    }

    public void onClickBtnQuitter(View view) {
        finish();
        System.exit(0);
    }

    public void onClickActionParametres(MenuItem item) {
        Intent intent = new Intent(this,ParametreActivity.class);
        startActivity(intent);
    }

    public void onClickActionAPropos(MenuItem item) {
        Intent intent = new Intent(this,AProposActivity.class);
        startActivity(intent);
    }
}