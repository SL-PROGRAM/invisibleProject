package com.example.devinet.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Mot implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int idMot;
    private String img;
    private String mot;
    private String proposition;
    private int categorie;
    private int liste;
    private int progress;

    public Mot(int idMot, String img, String mot, String proposition, int categorie, int liste, int progress) {
        this.idMot = idMot;
        this.img = img;
        this.mot = mot;
        this.proposition = proposition;
        this.categorie = categorie;
        this.liste = liste;
        this.progress = progress;
    }

    protected Mot(Parcel in) {
        idMot = in.readInt();
        img = in.readString();
        mot = in.readString();
        proposition = in.readString();
        categorie = in.readInt();
        liste = in.readInt();
        progress = in.readInt();
    }

    public static final Creator<Mot> CREATOR = new Creator<Mot>() {
        @Override
        public Mot createFromParcel(Parcel in) {
            return new Mot(in);
        }

        @Override
        public Mot[] newArray(int size) {
            return new Mot[size];
        }
    };

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

    public int getListe() {
        return liste;
    }

    public void setListe(int liste) {
        this.liste = liste;
    }

    public int getProgress() { return progress; }

    public void setProgress(int progress) { this.progress = progress; }

    @Override
    public String toString() {
        return "Mot{" +
                "idMot=" + idMot +
                ", img='" + img + '\'' +
                ", mot='" + mot + '\'' +
                ", proposition='" + proposition + '\'' +
                ", categorie=" + categorie +
                ", liste=" + liste +
                ", progress=" + progress +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idMot);
        parcel.writeString(img);
        parcel.writeString(mot);
        parcel.writeString(proposition);
        parcel.writeInt(categorie);
        parcel.writeInt(liste);
        parcel.writeInt(progress);
    }
}
