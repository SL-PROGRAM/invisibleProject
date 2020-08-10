package com.example.devinet.activities.adapteur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devinet.R;

import java.util.List;

public class NiveauAdapteur extends ArrayAdapter<NiveauAdapteur>
{
    public NiveauAdapteur(@NonNull Context context, int resource, @NonNull List<NiveauAdapteur> objects) {
        super(context, resource, objects);
    }
    //Faire adapter pour liste des niveaux (nbre de lettres)


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //On décompresse le fichier style_ligne_niveaux.xml
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.style_ligne_niveau,parent,false);

        //On met les données dans la ligne

        TextView titreNiveau = nouvelleLigne.findViewById(R.id.tv_titre_niveau);
        titreNiveau.setText("NIVEAU 99");

        TextView titreNiveauLettre = nouvelleLigne.findViewById(R.id.tv_titre_niveau_lettre);
        titreNiveauLettre.setText("85 LETTRES");

        //On retourne la ligne
        return nouvelleLigne;

    }
}
