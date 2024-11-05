package com.bancusoft.listv3.Views;

import static com.bancusoft.listv3.Helpers.Utils.app_google;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Retrofit.Scientistsvw_ro;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
public class DetailActivityvw_ro extends AppCompatActivity{

    //Let's define our instance fields
    private TextView Nume_firma, cui, cod_inmatriculare, EUID, stare, Sediu, country, Localitate, Judet, act;

    private CollapsingToolbarLayout mCollapsingToolbarLayoutvw_ro;

    private void initializeWidgets(){
        Nume_firma= findViewById(R.id.Nume_firma_det);
        cui = findViewById(R.id.cui_det);
        cod_inmatriculare  = findViewById(R.id.cod_inmatriculare_det);
        EUID = findViewById(R.id.eud_det);
        stare = findViewById(R.id.stare_det);
        Sediu = findViewById(R.id.sediu_det);
        country = findViewById(R.id.country_det);
        Localitate = findViewById(R.id.localitate_det);
        Judet = findViewById(R.id.judet_det);
        act = findViewById(R.id.last_update_det);

        mCollapsingToolbarLayoutvw_ro=findViewById(R.id.mCollapsingToolbarLayoutvw_ro);
    }



    private void receiveAndShowData() {

        Scientistsvw_ro receivedScientist_ro = Utils.receiveScientistvw_ro(getIntent(), DetailActivityvw_ro.this);

        if (receivedScientist_ro != null) {



            // Check if the TextViews and receivedScientist_ro are not null before setting text
            if (Nume_firma != null && receivedScientist_ro.getNume_firma() != null) {
                Nume_firma.setText(receivedScientist_ro.getNume_firma().trim());
            }

            if (cui != null && receivedScientist_ro.getCui() != null) {
                cui.setText(receivedScientist_ro.getCui().trim());
            }

            if (cod_inmatriculare != null && receivedScientist_ro.getcod_inmatriculare() != null) {
                cod_inmatriculare.setText(receivedScientist_ro.getcod_inmatriculare().trim());
            }

            if (EUID != null && receivedScientist_ro.getEUID() != null) {
                EUID.setText(receivedScientist_ro.getEUID().trim());
            }

            if (stare != null && receivedScientist_ro.getStare() != null) {
                stare.setText(receivedScientist_ro.getStare().trim());
            }

            if (Sediu != null && receivedScientist_ro.getSediu() != null) {
                Sediu.setText(receivedScientist_ro.getSediu().trim());
            }

            if (country != null && receivedScientist_ro.getCountry() != null) {
                country.setText(receivedScientist_ro.getCountry().trim());
            }

            if (Localitate != null && receivedScientist_ro.getLocalitate() != null) {
                Localitate.setText(receivedScientist_ro.getLocalitate().trim());
            }

            if (Judet != null && receivedScientist_ro.getJudet() != null) {
                Judet.setText(receivedScientist_ro.getJudet().trim());
            }

            if (act != null && receivedScientist_ro.getAct() != null) {
                act.setText(receivedScientist_ro.getAct().trim());
            }

// Set title for CollapsingToolbarLayout
            if (mCollapsingToolbarLayoutvw_ro != null && receivedScientist_ro.getCui() != null) {
                mCollapsingToolbarLayoutvw_ro.setTitle(receivedScientist_ro.getCui());
                mCollapsingToolbarLayoutvw_ro.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
            }



        }
    }


    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }




    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, ScientistsActivityvw_ro.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_vw){

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.listv3.Helpers.Utils.youtube_level_stat));

            startActivity(browserIntent);


        }


        return super.onOptionsItemSelected(item);
    }







    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvw_ro);

        Nume_firma= findViewById(R.id.Nume_firma_det);
        cui = findViewById(R.id.cui_det);
        cod_inmatriculare  = findViewById(R.id.cod_inmatriculare_det);
        EUID = findViewById(R.id.eud_det);
        stare = findViewById(R.id.stare_det);
        Sediu = findViewById(R.id.sediu_det);
        country = findViewById(R.id.country_det);
        Localitate = findViewById(R.id.localitate_det);
        Judet = findViewById(R.id.judet_det);
        act = findViewById(R.id.last_update_det);


        Button mBtnShare = findViewById(R.id.share_ro_det);

        mBtnShare.setOnClickListener(view -> {



            // Ensure TextViews are not null before retrieving their text
            String s_Nume_firma = Nume_firma != null ? Nume_firma.getText().toString() : "";
            String s_cui = cui != null ? cui.getText().toString() : "";
            String s_cod_inmatriculare = cod_inmatriculare != null ? cod_inmatriculare.getText().toString() : "";
            String s_EUID = EUID != null ? EUID.getText().toString() : "";
            String s_stare = stare != null ? stare.getText().toString() : "";
            String s_Sediu = Sediu != null ? Sediu.getText().toString() : "";
            String s_country = country != null ? country.getText().toString() : "";
            String s_Localitate = Localitate != null ? Localitate.getText().toString() : "";
            String s_Judet = Judet != null ? Judet.getText().toString() : "";
            String s_act = act != null ? act.getText().toString() : "";


            String contentShare = " Nume firmă : " + s_Nume_firma + " - Cui :  " + s_cui + " - Cod Inmatriculare - " + s_cod_inmatriculare
                    + " - EUID. :  " +  s_EUID
                    + " -  Stare :  " +  s_stare + "  - Sediu  :  " + s_Sediu
                    + " -  Țara :  " + s_country
                    + " -  : Localitate " + s_Localitate
                    + " -  : Județ :  " +  s_Judet
                    + " -  actualizare" + s_act + " -- The application -Stat Level  - can be downloaded from here "
                    +  app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  despre firmă");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });

 //-----------------------------

        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(DetailActivityvw_ro.this, ScientistsActivityvw_ro.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);

//-----------------------------

        initializeWidgets();
        receiveAndShowData();
    }


}
