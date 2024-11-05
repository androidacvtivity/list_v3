package com.bancusoft.listv3.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ResponseModel_Cl_medicament {

    @SerializedName("resultcu")
    List<Cl_medicament> cl_medicament;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Cl_medicament> getResultCl_medicament () {return  cl_medicament;}

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}
}
