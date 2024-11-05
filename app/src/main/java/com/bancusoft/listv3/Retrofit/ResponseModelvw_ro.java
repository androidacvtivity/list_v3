package com.bancusoft.listv3.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ResponseModelvw_ro {


    @SerializedName("resultvw_ro")
    List<Scientistsvw_ro> scientistsvw_ro;

    @SerializedName("codevw_ro")
    private final String codevw_ro;

    @SerializedName("messagevw_ro")
    private final String messagevw_ro;

    public ResponseModelvw_ro(String codevw_ro, String messagevw_ro) {
        this.codevw_ro = codevw_ro;
        this.messagevw_ro = messagevw_ro;
    }


    public List<Scientistsvw_ro> getResultvw_ro() {return  scientistsvw_ro;}

    public String getCodevw_ro () {return  codevw_ro;}


    public String getMessagevw_ro() {return messagevw_ro;}

}
