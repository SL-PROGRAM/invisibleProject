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
import com.example.devinet.bo.Categorie;

import java.util.List;
import java.util.Objects;

public class NiveauAdapteur extends ArrayAdapter<Categorie>
{
    public NiveauAdapteur(@NonNull Context context, int resource, @NonNull List<Categorie> objects) {
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

        TextView titreNiveau = nouvelleLigne.findViewById(R.id.tv_niveau_nombre);
        titreNiveau.setText(String.valueOf(getItem(position).getIdCat()));

        TextView titreNiveauLettre = nouvelleLigne.findViewById(R.id.tv_titre_niveau_lettre);
        titreNiveauLettre.setText(" - " + getItem(position).getNom());


        //On retourne la ligne
        return nouvelleLigne;

    }
}
