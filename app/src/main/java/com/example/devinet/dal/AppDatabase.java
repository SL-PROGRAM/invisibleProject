package com.example.devinet.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.devinet.bo.Categorie;
import com.example.devinet.bo.Mot;
import com.example.devinet.dal.CategorieDAO;
import com.example.devinet.dal.MotDAO;


@Database(entities = {Mot.class, Categorie.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase
{

    private static AppDatabase INSTANCE_MOT;
    private static AppDatabase INSTANCE_CATEGORIE;

    /**
     * Permet de fournir une instance de la dao Mot aux couches supérieures.
     * @return
     */
    public abstract MotDAO getMotDAO();

    public static AppDatabase getInstanceMot(Context context)
    {
        if(INSTANCE_MOT == null)
        {
            INSTANCE_MOT = Room.databaseBuilder(context,AppDatabase.class,"devinette.db").build();
        }
        return INSTANCE_MOT;
    }

    /**
     * Permet de fournir une instance de la dao Categorie aux couches supérieures.
     * @return
     */
    public abstract CategorieDAO getCategorieDAO();

    public static AppDatabase getInstanceCategorie(Context context)
    {
        if(INSTANCE_CATEGORIE == null)
        {
            INSTANCE_CATEGORIE = Room.databaseBuilder(context,AppDatabase.class,"devinette.db").build();
        }
        return INSTANCE_CATEGORIE;
    }
}
