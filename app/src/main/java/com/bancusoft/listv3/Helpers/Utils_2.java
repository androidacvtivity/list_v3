package com.bancusoft.listv3.Helpers;

import android.app.AlertDialog;
import android.content.Context;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Views.DashboardActivity;
import com.bancusoft.listv3.Views.help_vw;
import com.bancusoft.listv3.Views.help_vw_en;
import com.bancusoft.listv3.Views.help_vw_ru;
import com.bancusoft.listv3.Views.med.help_medicament_2;
import com.bancusoft.listv3.Views.med.help_medicament_en;
import com.bancusoft.listv3.Views.med.help_medicament_ru;

public class Utils_2 {
    /**
     * This utility method will allow us open any activity.
     */
    public static void openActivity(Context c, Class <?> clazz){
        Intent intent = new Intent(c, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        c.startActivity(intent);
    }


    public static void showInfoDialog_help_ro_med_3(final AppCompatActivity activity, String title, String message) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)
                .setPositiveButton("en", (dialog, which) -> openActivity(activity, help_medicament_en.class))
                .setNeutralButton("La inceput", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", (dialog, which) -> openActivity(activity, help_medicament_ru.class))
                .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                        .setNegativeButton(android.R.string.no, null)
                        .show())
                .show();
    }




    public static void showInfoDialog_help_en_med_3(final AppCompatActivity activity, String title, String message) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)
                .setPositiveButton("ro", (dialog, which) -> openActivity(activity, help_medicament_2.class))
                .setNeutralButton("Dashboard", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", (dialog, which) -> openActivity(activity, help_medicament_ru.class))
                .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                        .setNegativeButton(android.R.string.no, null)
                        .show())
                .show();
    }




    public static void showInfoDialog_help_ru_med_3(final AppCompatActivity activity, String title, String message) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)
                .setPositiveButton("ro", (dialog, which) -> openActivity(activity, help_medicament_2.class))
                .setNeutralButton("В начало", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", (dialog, which) -> openActivity(activity, help_medicament_ru.class))
                .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                        .setNegativeButton(android.R.string.no, null)
                        .show())
                .show();
    }






//------------------------------------------------


    public static void showInfoDialog_help_ro_vw_3(final AppCompatActivity activity, String title, String message) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)
//                .setPositiveButton("ro", (dialog, which) -> openActivity(activity, help_medicament_2.class))
//                .setNeutralButton("В начало", (dialog, which) -> openActivity(activity, DashboardActivity.class))
//                .setNegativeButton("en", (dialog, which) -> openActivity(activity, help_medicament_ru.class))

                .setPositiveButton("en", (dialog, which) -> openActivity(activity, help_vw_en.class))
                .setNeutralButton("La inceput", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", (dialog, which) -> openActivity(activity, help_vw_ru.class))
                .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                        .setNegativeButton(android.R.string.no, null)
                        .show())
                .show();
    }
//--------------------------------------------------------------------------
public static void showInfoDialog_help_en_vw_3(final AppCompatActivity activity, String title, String message) {
    new AlertDialog.Builder(activity)
            .setTitle(title)
            .setIcon(R.drawable.m_info)
            .setMessage(message)

                .setPositiveButton("ro", (dialog, which) -> openActivity(activity, help_vw.class))
                .setNeutralButton("Dashboard", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("ru", (dialog, which) -> openActivity(activity, help_vw_ru.class))

            .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                    .setTitle("Confirm Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                    .setNegativeButton(android.R.string.no, null)
                    .show())
            .show();
}





//---------------------------------------------------------------------------


    //--------------------------------------------------------------------------
    public static void showInfoDialog_help_ru_vw_3(final AppCompatActivity activity, String title, String message) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(R.drawable.m_info)
                .setMessage(message)

                .setPositiveButton("ro", (dialog, which) -> openActivity(activity, help_vw.class))
                .setNeutralButton("В начало", (dialog, which) -> openActivity(activity, DashboardActivity.class))
                .setNegativeButton("en", (dialog, which) -> openActivity(activity, help_vw_en.class))

                .setOnDismissListener(dialog -> new AlertDialog.Builder(activity)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton(android.R.string.yes, (dialog1, which) -> activity.finish())
                        .setNegativeButton(android.R.string.no, null)
                        .show())
                .show();
    }
    //---------------------------------------------------------------------------

    /**
     * This method will allow us show an Info dialog anywhere in our app.
     */


    public static void openActivity(AppCompatActivity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }
}
