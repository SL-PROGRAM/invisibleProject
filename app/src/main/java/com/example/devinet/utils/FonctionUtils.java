package com.example.devinet.utils;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.devinet.bo.Mot;
import com.example.devinet.repository.CategorieBddRepository;
import com.example.devinet.repository.ICategorieRepository;
import com.example.devinet.repository.IMotRepository;
import com.example.devinet.repository.MotBddRepository;

import java.util.List;
import java.util.Objects;

public class FonctionUtils {

    public static final int NB_MOT_PAR_LISTE = 10;

    public static int longueurMotPourNiveau(String mot){
        return mot.length();
    }

    public static int definirNumeroList(int niveau, Context context){
        IMotRepository motRepository = new MotBddRepository(context);
        int nombreDeMotList = Objects.requireNonNull(motRepository.getNiveau(niveau).getValue()).size();
        Log.i("utils", "definirNumeroList: "+nombreDeMotList);
        return nombreDeMotList / NB_MOT_PAR_LISTE +1;
    }




}
