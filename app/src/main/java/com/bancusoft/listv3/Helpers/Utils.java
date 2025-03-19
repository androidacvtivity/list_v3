package com.bancusoft.listv3.Helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Retrofit.Cl_caem;
import com.bancusoft.listv3.Retrofit.Cl_caem2;
import com.bancusoft.listv3.Retrofit.Cl_cfoj;
import com.bancusoft.listv3.Retrofit.Cl_cfp;
import com.bancusoft.listv3.Retrofit.Cl_cocm;
import com.bancusoft.listv3.Retrofit.Cl_cuatm_all;
import com.bancusoft.listv3.Retrofit.Cl_medicament;
import com.bancusoft.listv3.Retrofit.Cl_prodmold;
import com.bancusoft.listv3.Retrofit.Cl_servicii;
import com.bancusoft.listv3.Retrofit.Scientist;
import com.bancusoft.listv3.Retrofit.Scientistscaem;
import com.bancusoft.listv3.Retrofit.Scientistscfp;
import com.bancusoft.listv3.Retrofit.Scientistscu;
import com.bancusoft.listv3.Retrofit.Scientistsvw_ro;
import com.bancusoft.listv3.Retrofit.Scientistvw;
import com.bancusoft.listv3.Views.DashboardActivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A Utility class. Contains reusable utility methods we will use throughout our project.This
 * class will save us from typing lots of repetitive code.
 */
//Last commit before change account in github.
public class Utils {
    /**
     * Let's define some Constants
     */
    //supply your ip address. Type ipconfig while connected to internet to get your
    //ip address in cmd. Watch video for more details.
     //
    public   static  final  String  app_google = "https://play.google.com/store/apps/details?id=com.bancusoft.list&gl=MD";
   public   static  final  String  youtube_level_stat = "https://www.youtube.com/";


  private  static  final String base_url = "http://bancusoft.com/PHP/production/";


  // private  static  final String base_url = "http://172.20.1.154/PHP/production/";



    private static Retrofit retrofit = null;

    /**
     * This method will return us our Retrofit instance which we can use to initiate HTTP calls.
     */
    public static Retrofit getClient(){


        if(retrofit == null){

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(okHttpClient)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return  retrofit;
    }
    /**
     * THis method will allow us show Toast messages throughout all activities
     */
    public static void show(Context c,String message){
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }



    /**
     * This utility method will allow us open any activity.
     */
    public static void openActivity(Context c,Class <?> clazz){
        Intent intent = new Intent(c, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(intent);
    }



    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */


    public static void showInfoDialog(final AppCompatActivity activity, String title,
                                      String message) {

        new AlertDialog.Builder(activity)

                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)
                .setPositiveButton("Relax", null)
                .setNeutralButton("Dashboard", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("The List", (dialog, which) -> activity.finish())

                .show();
    }


    //This method will allow us show a single select dialog where we can select and return a
    // star to an edittext.




    /**
     * This method will allow us show a progressbar
     */
    public static void showProgressBar(ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
    }
    /**
     * This method will allow us hide a progressbar
     */
    public static void hideProgressBar(ProgressBar pb){
        pb.setVisibility(View.GONE);
    }



    /**
     * This method will allow us send a serialized Cl_medicament objec  to a specified
     *  activity
     */

    public static void sendCl_mediToActivity(Context c, Cl_medicament cl_medicament,
                                             Class <?> clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY",  cl_medicament);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized Cl_tari objec  to a specified
     *  activity
     */

//    public static void sendCl_tariToActivity(Context c, Cl_tari cl_tari,
//                                             Class <?> clazz){
//        Intent i=new Intent(c,clazz);
//
//        i.putExtra("SCIENTIST_KEY",  cl_tari);
//        c.startActivity(i);
//    }

    /**
     * This method will allow us send a serialized Cl_tari objec  to a specified
     *  activity
     */

    public static void sendCl_prodmoldToActivity(Context c, Cl_prodmold cl_prodmold,
                                             Class  <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_prodmold);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized Cl_cfoj objec  to a specified
     *  activity
     */

    public static void sendCl_cfojToActivity(Context c, Cl_cfoj cl_cfoj,
                                              Class <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_cfoj);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_cocm objec  to a specified
     *  activity
     */

    public static void sendCl_cocmToActivity(Context c, Cl_cocm cl_cocm,
                                             Class <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_cocm);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_cocm objec  to a specified
     *  activity
     */

    public static void sendCl_cfpToActivity(Context c, Cl_cfp cl_cfp,
                                             Class  <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_cfp);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized Cl_servicii objec  to a specified
     *  activity
     */

    public static void sendCl_serviciiToActivity(Context c, Cl_servicii cl_servicii,
                                            Class <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_servicii);
        c.startActivity(i);
    }


       /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendCl_caem2ToActivity(Context c, Cl_caem2 cl_caem2,
                                              Class  <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_caem2);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendCl_caemToActivity(Context c, Cl_caem cl_caem,
                                              Class  <?> clazz){
        Intent i=new Intent(c,clazz);

        i.putExtra("SCIENTIST_KEY", cl_caem);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized scientist objec  to a specified
     *  activity
     */

    public static void sendScientistToActivity(Context c, Scientist scientist,
     Class <?> clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY", scientist);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistvw_roToActivity(Context c, Scientistsvw_ro scientistvw_ro,
                                                 Class <?> clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY", scientistvw_ro);
        c.startActivity(i);
    }


    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistvwToActivity(Context c, Scientistvw scientistvw,
                                               Class <?> clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY", scientistvw);
        c.startActivity(i);
    }
    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistscuToActivity(Context c, Scientistscu scientistscu,
                                                 Class <?> clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY", scientistscu);
        c.startActivity(i);
    }



    /**
     * This method will allow us send a serialized scientist objec  to a specifie activity
     */
    public static void sendScientistscaemToActivity(Context c, Scientistscaem scientistscaem,
                                                  Class <?> clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY", scientistscaem);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized cl_cuatm_all objec  to a specifie activity
     */
    public static void sendCl_cuatm_allToActivity(Context c, Cl_cuatm_all cl_cuatm_all,
                                                    Class <?> clazz){
        Intent i=new Intent(c,clazz);
        i.putExtra("SCIENTIST_KEY", cl_cuatm_all);
        c.startActivity(i);
    }

    /**
     * This method will allow us send a serialized Scientistscfp objec  to a specifie activity
     */
    public static void sendScientistscfpToActivity(Context c, Scientistscfp scientistscfp,
                                                    Class <?> clazz){
        Intent i=new Intent(c,clazz);
//        i.putExtra("" +
//////                "",scientistvw);
        i.putExtra("SCIENTIST_KEY", scientistscfp);
        c.startActivity(i);
    }




    /**
     * This method will allow us receive a serialized Cl_caem2, deserialize it and return it,.
     */
    public  static Cl_caem2 receiveCl_caem2(Intent intent,Context c){
        try {
            return (Cl_caem2) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }
    /**
     * This method will allow us receive a serialized Cl_caem, deserialize it and return it,.
     */
    public  static Cl_caem receiveCl_caem(Intent intent,Context c){
        try {
            return (Cl_caem) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized cl_cuatm_all, deserialize it and return it,.
     */
    public  static Cl_cuatm_all receiveCl_cuatm_all(Intent intent,Context c){
        try {
            return (Cl_cuatm_all) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c,"RECEIVING-SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistsvw_ro receiveScientistvw_ro(Intent intent, Context c){
        try {
            return (Scientistsvw_ro) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }




    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistvw receiveScientistvw(Intent intent,Context c){
        try {
            return (Scientistvw) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistscu receiveScientistscu(Intent intent,Context c) {
        try {
            return (Scientistscu) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized scientist, deserialize it and return it,.
     */
    public  static Scientistscaem receiveScientistscaem(Intent intent,Context c) {
        try {
            return (Scientistscaem) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Scientistscfp, deserialize it and return it,.
     */
    public  static Scientistscfp receiveScientistscfp(Intent intent,Context c) {
        try {
            return (Scientistscfp) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cfoj, deserialize it and return it,.
     */
    public  static Cl_cfoj receiveCl_cfoj(Intent intent,Context c) {
        try {
            return (Cl_cfoj) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cocm, deserialize it and return it,.
     */
    public  static Cl_cocm receiveCl_cocm(Intent intent,Context c) {
        try {
            return (Cl_cocm) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }


    /**
     * This method will allow us receive a serialized Cl_cfp, deserialize it and return it,.
     */
    public  static Cl_cfp receiveCl_cfp(Intent intent,Context c) {
        try {
            return (Cl_cfp) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * This method will allow us receive a serialized Cl_servicii, deserialize it and return it,.
     */
    public  static Cl_servicii receiveCl_servicii(Intent intent,Context c) {
        try {
            return (Cl_servicii) intent.getSerializableExtra("SCIENTIST_KEY")
                    ;
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }



    /**
     * This method will allow us receive a serialized Cl_tari, deserialize it and return it,.
     */
//    public  static Cl_tari receiveCl_tari(Intent intent,Context c) {
//        try {
//            return (Cl_tari) intent.getSerializableExtra("SCIENTIST_KEY");
//        }catch (Exception e){
//            e.printStackTrace();
//            show(c," -SCIENTIST ERROR: "+e.getMessage());
//        }
//        return null;
//    }

    /**
     * This method will allow us receive a serialized Cl_prodmold, deserialize it and return it,.
     */
    public  static Cl_prodmold receiveCl_prodmold(Intent intent,Context c) {
        try {
            return (Cl_prodmold) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c," -SCIENTIST ERROR: "+e.getMessage());
        }
        return null;
    }

    /**
     * This method will allow us receive a serialized cl_medicament, deserialize it and return it,.
     */

    public  static Cl_medicament receiveCl_medicament(Intent intent,Context c) {
        try {
            return (Cl_medicament) intent.getSerializableExtra("SCIENTIST_KEY");
        }catch (Exception e){
            e.printStackTrace();
            show(c," -Medicament ERROR: "+e.getMessage());
        }
        return null;
    }

}
//end
