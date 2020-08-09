package com.example.devinet.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Mot {
    @PrimaryKey(autoGenerate = true)
    private int idMot;
    private byte img;
    private String mot;
    private String proposition;
    private Categorie categorie;

    public Mot(int idMot, byte img, String mot, String proposition, Categorie categorie) {
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

    public byte getImg() {
        return img;
    }

    public void setImg(byte img) {
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
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
