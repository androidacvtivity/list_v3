package com.bancusoft.listv3.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Scientistsvw_ro implements Serializable {
    @SerializedName("Nume_firma")
    private final String Nume_firma;

    @SerializedName("cui")
    private final String cui;

    @SerializedName("cod_inmatriculare")
    private final String cod_inmatriculare;

    @SerializedName("EUID")
    private final String EUID;

    @SerializedName("stare")
    private final String stare;

    @SerializedName("Sediu")
    private final String Sediu;

    @SerializedName("country")
    private final String country;

    @SerializedName("Localitate")
    private final String Localitate;

    @SerializedName("Judet")
    private final String Judet;

    @SerializedName("act")
    private final String act;

    public Scientistsvw_ro(String Nume_firma, String cui, String cod_inmatriculare, String EUID, String stare, String Sediu, String country, String Localitate, String Judet, String act) {
        this.Nume_firma = Nume_firma;
        this.cui = cui;
        this.cod_inmatriculare = cod_inmatriculare;
        this.EUID = EUID;
        this.stare = stare;
        this.Sediu = Sediu;
        this.country = country;
        this.Localitate = Localitate;
        this.Judet = Judet;
        this.act = act;
    }

    public String getNume_firma() {
        return Nume_firma;
    }

    public String getCui() {
        return cui;
    }

    public String getcod_inmatriculare() {
        return cod_inmatriculare;
    }

    public String getEUID() {
        return EUID;
    }

    public String getStare() {
        return stare;
    }

    public String getSediu() {
        return Sediu;
    }

    public String getCountry() {
        return country;
    }

    public String getLocalitate() {
        return Localitate;
    }

    public String getJudet() {
        return Judet;
    }

    public String getAct() {
        return act;
    }

    @NonNull
    @Override
    public String toString() {
        return getStare();
    }
}
