package com.bancusoft.listv3.Retrofit;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModelcaem {

    @SerializedName("resultcu")
    List<Scientistscaem> scientistscaem;

    @SerializedName("codecu")
    private String codecu;

    @SerializedName("messagecu")
    private String messagecu;


    public List<Scientistscaem> getResultcaem () {return  scientistscaem;}

    public String getCodecu () {return  codecu;}

    public void setCodecu  ( String codecu) {this.codecu = codecu;}


    public String getMessagecu () {return messagecu;}

    public void setMessagecu (String messagecu) {this.messagecu = messagecu;}

}


