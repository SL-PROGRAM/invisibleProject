package com.example.devinet.activities.adapteur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devinet.R;
import com.example.devinet.bo.Mot;

import java.util.List;

public class ListAdapteur extends ArrayAdapter<Mot> {

    public ListAdapteur(@NonNull Context context, int resource, @NonNull List<Mot> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View nouvelleLigne = li.inflate(R.layout.style_ligne_liste,parent,false);

        return nouvelleLigne;
    }
}
