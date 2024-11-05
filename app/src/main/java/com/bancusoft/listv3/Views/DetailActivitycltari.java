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
import com.bancusoft.listv3.Retrofit.Cl_tari;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class DetailActivitycltari extends AppCompatActivity {

    private TextView CODUL_TV_CL_TARII ,DENUMIRE_TV_CL_TARII;

    private Cl_tari receivedCl_tari;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CL_TARII = findViewById(R.id.CODUL_TV_CL_TARII);
        DENUMIRE_TV_CL_TARII = findViewById(R.id.DENUMIRE_TV_CL_TARII);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayouttari);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_tari  = Utils.receiveCl_tari(getIntent(),DetailActivitycltari.this);

        if(receivedCl_tari != null){
            CODUL_TV_CL_TARII.setText(receivedCl_tari.getCODUL());
            DENUMIRE_TV_CL_TARII.setText(receivedCl_tari.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_tari.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_tari_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_edit_cl_tari){
            Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_en_cl_tari){
            Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw_en.class);
            finish();
            return true;

        }
        else


        if (id==R.id.action_edit_ru_cl_tari){
            Utils.sendCl_tariToActivity(this,receivedCl_tari,help_vw_ru.class);
            finish();
            return true;

        }
        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,ScientistsActivitycltari.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_cl_tari) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.listv3.Helpers.Utils.youtube_level_stat));
            startActivity(browserIntent);
            return true;
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_tari);

        CODUL_TV_CL_TARII = findViewById(R.id.CODUL_TV_CL_TARII);
        DENUMIRE_TV_CL_TARII = findViewById(R.id.DENUMIRE_TV_CL_TARII);


        Button mBtnShare = findViewById(R.id.btnShare_cl_tarii);

        mBtnShare.setOnClickListener(view -> {
            String s_CODUL_TV_CL_TARII = CODUL_TV_CL_TARII.getText().toString();
            String s_DENUMIRE_TV_CL_TARII = DENUMIRE_TV_CL_TARII.getText().toString();


            String contentShare = " Codul Țării : " + s_CODUL_TV_CL_TARII + " - Denumirea , \n" +
                    "  :  " + s_DENUMIRE_TV_CL_TARII
                    + " -- The application -Level Stat - can be downloaded from here "
                    +  app_google;


            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Clasificatorul internaţional al ţărilor lumii şi teritoriilor, care se utilizează la\n" +
                    "completarea rapoartelor statistice privind exportul şi importul de servicii.");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });

//-------------

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(DetailActivitycltari.this, ScientistsActivitycltari.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

//----------------

        initializeWidgets();
        receiveAndShowData();
    }
}
