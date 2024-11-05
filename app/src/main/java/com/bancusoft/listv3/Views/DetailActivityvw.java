package com.bancusoft.listv3.Views;

import static com.bancusoft.listv3.Helpers.Utils.app_google;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Retrofit.Scientistvw;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityvw extends AppCompatActivity  {

    //Let's define our instance fields
    private TextView DEN_COM_VW_TV,IDNO_VW_TV,ADRESA_VW_TV,FORMA_ORG_VW_TV,LIST_COND_VW_TV, LISTA_FOND_VW_TV, GEN_ACT_NE_LIC_VW_TV, GEN_ACT_LIC_VW_TV,
            STATUTUL_VW_TV, DATA_REG_VW_TV, act_TV;

    //  private FloatingActionButton editFAB;
    private Scientistvw receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayoutvw;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        DEN_COM_VW_TV= findViewById(R.id.DEN_COM_VW_TV);
        IDNO_VW_TV= findViewById(R.id.IDNO_VW_TV);
        ADRESA_VW_TV= findViewById(R.id.ADRESA_VW_TV);
        FORMA_ORG_VW_TV= findViewById(R.id.FORMA_ORG_VW_TV);
        LIST_COND_VW_TV = findViewById(R.id.LIST_COND_VW_TV);
        LISTA_FOND_VW_TV = findViewById(R.id.LISTA_FOND_VW_TV);
        GEN_ACT_NE_LIC_VW_TV = findViewById(R.id.GEN_ACT_NE_LIC_VW_TV);
        GEN_ACT_LIC_VW_TV = findViewById(R.id.GEN_ACT_LIC_VW_TV);
        STATUTUL_VW_TV = findViewById(R.id.STATUTUL_VW_TV);
        DATA_REG_VW_TV = findViewById(R.id.DATA_REG_VW_TV);
        act_TV = findViewById(R.id.act_TV);





        mCollapsingToolbarLayoutvw=findViewById(R.id.mCollapsingToolbarLayoutvw);
    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientistvw(getIntent(),DetailActivityvw.this);

        if(receivedScientist != null){
            // Check if receivedScientist's fields are null before calling trim()
            DEN_COM_VW_TV.setText(receivedScientist.getDEN_COM_VW() != null ? receivedScientist.getDEN_COM_VW().trim() : "N/A");
            IDNO_VW_TV.setText(receivedScientist.getIDNO_VW() != null ? receivedScientist.getIDNO_VW().trim() : "N/A");
            ADRESA_VW_TV.setText(receivedScientist.getADRESA_VW() != null ? receivedScientist.getADRESA_VW().trim() : "N/A");
            FORMA_ORG_VW_TV.setText(receivedScientist.getFORMA_ORG_VW() != null ? receivedScientist.getFORMA_ORG_VW().trim() : "N/A");
            LIST_COND_VW_TV.setText(receivedScientist.getLIST_COND_VW() != null ? receivedScientist.getLIST_COND_VW().trim() : "N/A");
            LISTA_FOND_VW_TV.setText(receivedScientist.getLISTA_FOND_VW() != null ? receivedScientist.getLISTA_FOND_VW().trim() : "N/A");
            GEN_ACT_NE_LIC_VW_TV.setText(receivedScientist.getGEN_ACT_NE_LIC_VW() != null ? receivedScientist.getGEN_ACT_NE_LIC_VW().trim() : "N/A");
            GEN_ACT_LIC_VW_TV.setText(receivedScientist.getGEN_ACT_LIC_VW() != null ? receivedScientist.getGEN_ACT_LIC_VW().trim() : "N/A");
            STATUTUL_VW_TV.setText(receivedScientist.getSTATUTUL_VW() != null ? receivedScientist.getSTATUTUL_VW().trim() : "N/A");
            DATA_REG_VW_TV.setText(receivedScientist.getDATA_REG_VWW() != null ? receivedScientist.getDATA_REG_VWW().trim() : "N/A");
            act_TV.setText(receivedScientist.getAct() != null ? receivedScientist.getAct().trim().toUpperCase() : "N/A");

// Set title for collapsing toolbar
            mCollapsingToolbarLayoutvw.setTitle(receivedScientist.getIDNO_VW() != null ? receivedScientist.getIDNO_VW() : "N/A");
            mCollapsingToolbarLayoutvw.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));


        }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_vw, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_edit_vw){
            Utils.sendScientistvwToActivity(this,receivedScientist,help_vw.class);
            finish();
            return true;
        }
        else

        if (id==R.id.action_edit_en_vw){
            Utils.sendScientistvwToActivity(this,receivedScientist,help_vw_en.class);
            finish();
            return true;

        }

        else
        if (id==R.id.action_edit_ru_vw){
            Utils.sendScientistvwToActivity(this,receivedScientist,help_vw_ru.class);
            finish();
            return true;
        }


        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, ScientistsActivityvw.class);
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

    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * Our onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvw);

        DEN_COM_VW_TV= findViewById(R.id.DEN_COM_VW_TV);
        IDNO_VW_TV= findViewById(R.id.IDNO_VW_TV);
        ADRESA_VW_TV= findViewById(R.id.ADRESA_VW_TV);
        FORMA_ORG_VW_TV= findViewById(R.id.FORMA_ORG_VW_TV);
        LIST_COND_VW_TV = findViewById(R.id.LIST_COND_VW_TV);
        LISTA_FOND_VW_TV = findViewById(R.id.LISTA_FOND_VW_TV);
        GEN_ACT_NE_LIC_VW_TV = findViewById(R.id.GEN_ACT_NE_LIC_VW_TV);
        GEN_ACT_LIC_VW_TV = findViewById(R.id.GEN_ACT_LIC_VW_TV);
        STATUTUL_VW_TV = findViewById(R.id.STATUTUL_VW_TV);
        DATA_REG_VW_TV = findViewById(R.id.DATA_REG_VW_TV);
        act_TV = findViewById(R.id.act_TV);

        Button mBtnShare = findViewById(R.id.btnShare_vw);

        mBtnShare.setOnClickListener(view -> {

            // Ensure TextViews are not null before retrieving their text
            String s_DEN_COM_VW_TV = DEN_COM_VW_TV != null ? DEN_COM_VW_TV.getText().toString() : "";
            String s_IDNO_VW_TV = IDNO_VW_TV != null ? IDNO_VW_TV.getText().toString() : "";
            String s_ADRESA_VW_TV = ADRESA_VW_TV != null ? ADRESA_VW_TV.getText().toString() : "";
            String s_FORMA_ORG_VW_TV = FORMA_ORG_VW_TV != null ? FORMA_ORG_VW_TV.getText().toString() : "";
            String s_LIST_COND_VW_TV = LIST_COND_VW_TV != null ? LIST_COND_VW_TV.getText().toString() : "";
            String s_LISTA_FOND_VW_TV = LISTA_FOND_VW_TV != null ? LISTA_FOND_VW_TV.getText().toString() : "";
            String s_GEN_ACT_NE_LIC_VW_TV = GEN_ACT_NE_LIC_VW_TV != null ? GEN_ACT_NE_LIC_VW_TV.getText().toString() : "";
            String s_GEN_ACT_LIC_VW_TVV = GEN_ACT_LIC_VW_TV != null ? GEN_ACT_LIC_VW_TV.getText().toString() : "";
            String s_STATUTUL_VW_TV = STATUTUL_VW_TV != null ? STATUTUL_VW_TV.getText().toString() : "";
            String s_DATA_REG_VW_TV = DATA_REG_VW_TV != null ? DATA_REG_VW_TV.getText().toString() : "";
            String s_act_TV = act_TV != null ? act_TV.getText().toString() : "";


            String contentShare = " IDNO / Cod fiscal : " + s_IDNO_VW_TV + " - Data înregistrării :  " + s_DATA_REG_VW_TV + " - Denumirea comercială - " + s_DEN_COM_VW_TV
                    + " - Forma org./jurid. :  " +  s_FORMA_ORG_VW_TV
                    + " -  Adresa :  " +  s_ADRESA_VW_TV + "  - Lista conducătorilor  :  " + s_LIST_COND_VW_TV + " -  Lista fondatorilor (cota parte în capitalul social %) :  " + s_LISTA_FOND_VW_TV
                    + " -  : Genuri de activitate nelicentiate " + s_GEN_ACT_NE_LIC_VW_TV +  " -  Genuri de activitate licentiate :  " +  s_GEN_ACT_LIC_VW_TVV + " -  Statutul :  " + s_STATUTUL_VW_TV
                    + " - Ultima actualizare - " + s_act_TV + " -- The application -Stat Level  - can be downloaded from here "
                     +  app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  despre Unitatea de drept");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });



        //-----------------------------

        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(DetailActivityvw.this, ScientistsActivityvw.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);

        //------------------------------------------------------------------------




//-----------------------------

        initializeWidgets();
        receiveAndShowData();
    }

}
//end
