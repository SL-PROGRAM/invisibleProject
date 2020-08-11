package com.example.devinet.utils;

import android.content.Context;
import android.util.Log;

import com.example.devinet.repository.IMotRepository;
import com.example.devinet.repository.MotBddRepository;

public class FonctionUtils {

    public static final int NB_MOT_PAR_LISTE = 10;


    public static int longueurMotPourNiveau(String mot){
        return mot.length();
    }

    public static int definirNumeroList(int niveau, Context context){


        IMotRepository motRepository = new MotBddRepository(context);
        Log.i("Test utils", "elemNiv: 0");

        int  nbMotNiveau = motRepository.getMotNiveau(niveau).size();

        Log.i("Test utils", "elemNiv: "+ nbMotNiveau);
        Log.i("Test utils", "list: "+  nbMotNiveau / NB_MOT_PAR_LISTE);

        return  (nbMotNiveau - 1) / NB_MOT_PAR_LISTE + 1;

    }




}
