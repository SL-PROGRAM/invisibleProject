package com.example.devinet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.devinet.R;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.repository.CategorieBddRepository;
import com.example.devinet.repository.ICategorieRepository;
import com.example.devinet.repository.IMotRepository;
import com.example.devinet.repository.MotBddRepository;
import com.example.devinet.utils.FonctionUtils;
import com.example.devinet.view_model.CategorieVM;
import com.example.devinet.view_model.MotVM;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_menu);

//        /*
//        ** test insertion de donnée
//         */
//
//        MotVM motVM = ViewModelProviders.of(this).get(MotVM.class);

//        String motSt = "baba";
//        int longeurMot = FonctionUtils.longueurMotPourNiveau(motSt);

//        LiveData<List<Mot>> observateurMot = motVM.get();

//        IMotRepository motRepository = new MotBddRepository(this);
//        Mot mot1 = new Mot(1, "chat", "chat", "hcat", 1,1,0);
//        motRepository.update(mot1);
//        Mot mot2 = new Mot(2, "juge", "juge", "ugje", 1,1,0);
//        motRepository.update(mot2);
//        Mot mot3 = new Mot(3, "hisoka", "bibi", "biib", 1,1,0);
//        motRepository.update(mot3);
//
//        Mot mot4 = new Mot(4, "chat", "baba", "abab", 1,2,0);
//        motRepository.update(mot4);
//        Mot mot5 = new Mot(5, "juge", "toto", "oott", 1,2,0);
//        motRepository.update(mot5);
//        Mot mot6 = new Mot(6, "hisoka", "tata", "atta", 1,2,0);
//        motRepository.update(mot6);

//        ICategorieRepository categorieRepository = new CategorieBddRepository(this);
//        Categorie categorie1 = new Categorie(1, "4 lettres");
//        categorieRepository.insert(categorie1);
//        Categorie categorie2 = new Categorie(2, "5 lettres");
//        categorieRepository.insert(categorie2);
//        Categorie categorie3 = new Categorie(3, "6 lettres");
//        categorieRepository.insert(categorie3);
//        Categorie categorie4 = new Categorie(4, "7 lettres");
//        categorieRepository.insert(categorie4);
//
//        CategorieVM categorieVM = ViewModelProviders.of(this).get(CategorieVM.class);
//
//        observateurMot.observe(this, new Observer<List<Mot>>() {
//            @Override
//            public void onChanged(List<Mot> mots) {
//                for (Mot item : mots)
//                {
//                    Log.i("test mot", "Item : "+item.toString());
//                }
//            }
//        });
//
//      LiveData<List<Categorie>> observateurCategorie = categorieVM.get();
//        observateurCategorie.observe(this, new Observer<List<Categorie>>() {
//            @Override
//            public void onChanged(List<Categorie> categories) {
//
//                for (Categorie item : categories)
//                {
//                    Log.i("test categorie", "Item : "+item.toString());
//                }
//            }
//        });

        /*
         **  fin test insertion de donnée
         */
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
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
        final Dialog myPopup;

        myPopup = new Dialog(this);

        myPopup.setContentView(R.layout.popup);
        TextView quitter =  myPopup.findViewById(R.id.action_quitter);
        TextView annuler =  myPopup.findViewById(R.id.action_annuler);

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPopup.dismiss();
            }
        });
        myPopup.show();
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