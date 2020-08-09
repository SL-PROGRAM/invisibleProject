package com.example.devinet.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Mot.class,
        parentColumns = "idMot",
        childColumns = "idCat",
        onDelete = ForeignKey.CASCADE))

public class Categorie {
    @PrimaryKey(autoGenerate = true)
    private int idCat;
    private String nom;

    public Categorie(int idCat, String nom) {
        this.idCat = idCat;
        this.nom = nom;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + idCat +
                ", nom='" + nom + '\'' +
                '}';
    }
}
