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
import com.bancusoft.listv3.Retrofit.Scientistscaem;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class DetailActivitycaem extends AppCompatActivity {

    //Let's define our instance fields
    private TextView DENUMIRE_TV_caem,VALUE_TV_caem,act_TV_caem;

    private Scientistscaem receivedScientist;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        DENUMIRE_TV_caem= findViewById(R.id.DENUMIRE_TV_caem);
        VALUE_TV_caem= findViewById(R.id.VALUE_TV_caem);
        act_TV_caem= findViewById(R.id.act_TV_caem);


        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayoutcaem);
    }



    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){

        receivedScientist = Utils.receiveScientistscaem(getIntent(),DetailActivitycaem.this);

        if(receivedScientist != null){
            DENUMIRE_TV_caem.setText(receivedScientist.getDENUMIRE());
            VALUE_TV_caem.setText(receivedScientist.getVALUE());
            act_TV_caem.setText(receivedScientist.getAct());



            mCollapsingToolbarLayout.setTitle(receivedScientist.getVALUE());



            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }

    }

    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_caem, menu);
        return true;
    }


    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_edit_caem){
            Utils.sendScientistscaemToActivity(this,receivedScientist,help_vw.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_en_caem){
            Utils.sendScientistscaemToActivity(this,receivedScientist,help_vw_en.class);
            finish();
            return true;

        }
        else

        if (id==R.id.action_edit_ru_caem){
            Utils.sendScientistscaemToActivity(this,receivedScientist,help_vw_ru.class);
            finish();
            return true;

        }
        else



        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this, ScientistsActivitycucaem.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        if (id == R.id.video3_caem){

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_caem);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(DetailActivitycaem.this, ScientistsActivitycucaem.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

        DENUMIRE_TV_caem= findViewById(R.id.DENUMIRE_TV_caem);
        VALUE_TV_caem= findViewById(R.id.VALUE_TV_caem);
        act_TV_caem= findViewById(R.id.act_TV_caem);

        Button mBtnShare = findViewById(R.id.btnShare_caem);

        mBtnShare.setOnClickListener(view -> {
            String s_DENUMIRE_TV_caem = DENUMIRE_TV_caem.getText().toString();
            String s_VALUE_TV_caem = VALUE_TV_caem.getText().toString();
            String s_act_TV_caem = act_TV_caem.getText().toString();


            String contentShare = " Genul de activitate: " + s_DENUMIRE_TV_caem + " - Număr (care au codul IDNO) :  "+ s_VALUE_TV_caem + " Actualizarea " + s_act_TV_caem
                    + " -- The application -Level Stat - can be downloaded from here "
                    +  app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");


            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Informatia deschisa  după genurile de activitate declarate");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });

        initializeWidgets();
        receiveAndShowData();
    }
}
