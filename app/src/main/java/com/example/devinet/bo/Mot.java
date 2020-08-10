package com.example.devinet.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Mot {
    @PrimaryKey(autoGenerate = true)
    private int idMot;
    private String img;
    private String mot;
    private String proposition;
    private int categorie;

    public Mot(int idMot, String img, String mot, String proposition, int categorie) {
        this.idMot = idMot;
        this.img = img;
        this.mot = mot;
        this.proposition = proposition;
        this.categorie = categorie;
    }

    public int getIdMot() {
        return idMot;
    }

    public void setIdMot(int idMot) {
        this.idMot = idMot;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Mot{" +
                "id=" + idMot +
                ", img=" + img +
                ", mot='" + mot + '\'' +
                ", proposition='" + proposition + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
