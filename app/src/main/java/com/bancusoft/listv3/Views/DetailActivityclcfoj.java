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
import com.bancusoft.listv3.Retrofit.Cl_cfoj;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityclcfoj extends AppCompatActivity {
    //Let's define our instance fields
    private TextView CODUL_TV_CFOJ ,DENUMIRE_TV_CFOJ;

    private Cl_cfoj receivedCl_cfoj;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CFOJ = findViewById(R.id.CODUL_TV_CFOJ);
        DENUMIRE_TV_CFOJ = findViewById(R.id.DENUMIRE_TV_CFOJ);



        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcfoj);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedCl_cfoj  = Utils.receiveCl_cfoj(getIntent(),DetailActivityclcfoj.this);

        if(receivedCl_cfoj != null){
            CODUL_TV_CFOJ.setText(receivedCl_cfoj.getCODUL());
            DENUMIRE_TV_CFOJ.setText(receivedCl_cfoj.getDENUMIRE());




            mCollapsingToolbarLayout.setTitle(receivedCl_cfoj.getCODUL());

            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_cfoj_cl, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        int id = item.getItemId();

        if (id==R.id.action_edit_cl_cfoj){
            Utils.sendCl_cfojToActivity(this,receivedCl_cfoj,help_vw.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_en_cl_cfoj){
            Utils.sendCl_cfojToActivity(this,receivedCl_cfoj,help_vw_en.class);
            finish();
            return true;

        }
        else


        if (id==R.id.action_edit_ru_cl_cfoj){
            Utils.sendCl_cfojToActivity(this,receivedCl_cfoj,help_vw_ru.class);
            finish();
            return true;

        }
        else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,ScientistsActivityclcfoj.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video3_cl_cfoj) {

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

    /**
     * Let's finish the current activity when back button is pressed
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cfoj);

        CODUL_TV_CFOJ = findViewById(R.id.CODUL_TV_CFOJ);
        DENUMIRE_TV_CFOJ = findViewById(R.id.DENUMIRE_TV_CFOJ);


        Button mBtnShare = findViewById(R.id.btnShare_cfoj);

        mBtnShare.setOnClickListener(view -> {
            String s_CODUL_TV_CFOJ = CODUL_TV_CFOJ.getText().toString();
            String s_DENUMIRE_TV_CFOJ = DENUMIRE_TV_CFOJ.getText().toString();


            String contentShare = " Codul CFOJ : " + s_CODUL_TV_CFOJ + " - Denumirea CFOJ, \n" +
                    "  :  " + s_DENUMIRE_TV_CFOJ

                    + " -- The application -Level Stat - can be downloaded from here "
                    +  app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "CLASIFICATORUL  \n" +
                    "FORMELOR  \n" +
                    "ORGANIZATORICO-JURIDICE  \n" +
                    "ALE  AGENŢILOR  ECONOMICI  \n" +
                    "DIN  REPUBLICA  MOLDOVA\n" +
                    "(C.F.O.J.)\n");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });

//-------------

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(DetailActivityclcfoj.this, ScientistsActivityclcfoj.class);
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
