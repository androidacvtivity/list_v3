package com.bancusoft.listv3.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Our json response will be mapped to this class.
 */
public class ResponseModel {

    /**
     * Our ResponseModel attributes
     * index_view.php
     */


    @SerializedName("code")
    private String code;


    @SerializedName("message")
    private String message;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
//end
