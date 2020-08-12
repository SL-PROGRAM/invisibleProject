package com.example.devinet.utils;

import android.content.Context;
import android.util.Log;

import com.example.devinet.repository.IMotRepository;
import com.example.devinet.repository.MotBddRepository;

public class FonctionUtils {

    public static final int NB_MOT_PAR_LISTE = 10;
    public static Context cx = null;
    public static int niv;
    public static int list;



    public static int longueurMotPourNiveau(String mot){
        return mot.length();
    }

    public static int definirNumeroList(int niveau, Context context){
        cx = context;
        niv = niveau;

        Log.i("Test utils", "elemNiv: 0");

        Runnable task1 = new Runnable(){

            @Override
            public void run(){
                IMotRepository motRepository = new MotBddRepository(cx);
                int  nbMotNiveau = motRepository.getMotNiveau(niv).size();
                int list = (nbMotNiveau - 1) / NB_MOT_PAR_LISTE + 1;

                Log.i("Test utils", "elemNiv: "+ nbMotNiveau);
                Log.i("Test utils", "list: "+  nbMotNiveau / NB_MOT_PAR_LISTE);
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();

        return list ;

    }




}
