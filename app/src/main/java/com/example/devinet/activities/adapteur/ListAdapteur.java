package com.example.devinet.activities.adapteur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.devinet.R;
import com.example.devinet.activities.ChoixListNiveau;
import com.example.devinet.activities.JouerActivity;
import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;

import java.util.List;

public class ListAdapteur extends ArrayAdapter<Mot> {

    public ListAdapteur(@NonNull Context context, int resource, @NonNull List<Mot> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.style_ligne_liste,parent,false);

        CardView cardView = nouvelleLigne.findViewById(R.id.card_n1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mot mot = getItem(position);
                Intent intent = new Intent (getContext(), JouerActivity.class);
                intent.putExtra("mot", mot);
                getContext().startActivity(intent);
            }
        });

        TextView tv_liste = nouvelleLigne.findViewById(R.id.tv_liste_nombre);
        tv_liste.setText(String.valueOf(getItem(position).getListe()));

        ProgressBar pb = nouvelleLigne.findViewById(R.id.pb_list);
        pb.setProgress(getItem(position).getProgress());

        return nouvelleLigne;
    }
}
