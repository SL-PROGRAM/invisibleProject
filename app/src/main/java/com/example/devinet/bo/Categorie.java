package com.example.devinet.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Mot.class,
        parentColumns = "idMot",
        childColumns = "idCat",
        onDelete = ForeignKey.CASCADE))

public class Categorie implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int idCat;
    private String nom;

    public Categorie(int idCat, String nom) {
        this.idCat = idCat;
        this.nom = nom;
    }

    protected Categorie(Parcel in) {
        idCat = in.readInt();
        nom = in.readString();
    }

    public static final Creator<Categorie> CREATOR = new Creator<Categorie>() {
        @Override
        public Categorie createFromParcel(Parcel in) {
            return new Categorie(in);
        }

        @Override
        public Categorie[] newArray(int size) {
            return new Categorie[size];
        }
    };

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
                "idCat=" + idCat +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idCat);
        parcel.writeString(nom);
    }
}
