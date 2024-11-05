package com.bancusoft.listv3.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

 /**
 * Let's Create our Scientist class to represent a single Scientist.
 * It will implement java.io.Serializable interface, a marker interface that will allow
 *  our
 * class to support serialization and deserialization.
 */
public class Scientist implements Serializable {
    /**
     * Let' now come define instance fields for this class. We decorate them with
     * SerializedName
     * attribute. Through this we are specifying the keys in our json data.
     */
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("galaxy")
    private String galaxy;
     @SerializedName("serviciu")
     private String serviciu;
     @SerializedName("phone")
     private String phone;
     @SerializedName("email")
     private String email;


     public Scientist() {
     }


     /**
     * Let's now come define our getter and setter methods.
     */
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }


     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }


     public String getEmail() {
         return email;
     }

     public void setEmail (String email) {
         this.email = email;
     }


     public String getServiciu() {
         return serviciu;
     }

     public void setServiciu(String serviciu) {
         this.serviciu = serviciu;
     }


     public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

     @NonNull
    @Override
    public String toString() {
        return getName();
    }

 }
//end

