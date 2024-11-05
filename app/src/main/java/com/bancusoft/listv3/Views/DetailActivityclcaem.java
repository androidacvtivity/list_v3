package com.bancusoft.listv3.Views;

import static com.bancusoft.listv3.Helpers.Utils.app_google;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.Helpers.ViewUtils;
import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Retrofit.Cl_caem;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivityclcaem extends AppCompatActivity {

    // Instance fields
    private TextView CODUL_TV_CAEM, DENUMIRE_TV_caem;
    private Cl_caem receivedCl_caem;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    // Removed parameterized constructor
    // public DetailActivityclcaem(Cl_caem receivedClCaem) {}

    /**
     * Initialize the widgets
     */
    private void initializeWidgets(){
        CODUL_TV_CAEM = findViewById(R.id.CODUL_TV_CAEM);
        DENUMIRE_TV_caem = findViewById(R.id.DENUMIRE_TV_caem);
        mCollapsingToolbarLayout = findViewById(R.id.mCollapsingToolbarLayoutclcaem);
    }

    /**
     * Receive and show data passed through Intent
     */
    private void receiveAndShowData() {
        // Retrieve the Cl_caem object from the Intent
        receivedCl_caem = Utils.receiveCl_caem(getIntent(), DetailActivityclcaem.this);

        if (receivedCl_caem != null) {
            // Update the UI components with data from Cl_caem object
            ViewUtils.setTextSafely(CODUL_TV_CAEM, receivedCl_caem.getCODUL());
            ViewUtils.setTextSafely(DENUMIRE_TV_caem, receivedCl_caem.getDENUMIRE());
            mCollapsingToolbarLayout.setTitle(receivedCl_caem.getCODUL() != null ? receivedCl_caem.getCODUL() : "");
            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        } else {
            Log.e("DetailActivity", "Received Cl_caem is null");
            CODUL_TV_CAEM.setText("");
            DENUMIRE_TV_caem.setText("");
            mCollapsingToolbarLayout.setTitle("");
            mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        }
    }

    /**
     * Inflate menu for detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_caem_cl, menu);
        return true;
    }

    /**
     * Handle menu item selections
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_edit_caem) {
            Utils.sendCl_caemToActivity(this, receivedCl_caem, help_vw.class);
            finish();
            return true;
        } else if (id == R.id.action_edit_en_caem) {
            Utils.sendCl_caemToActivity(this, receivedCl_caem, help_vw_en.class);
            finish();
            return true;
        } else if (id == R.id.action_edit_ru_caem) {
            Utils.sendCl_caemToActivity(this, receivedCl_caem, help_vw_ru.class);
            finish();
            return true;
        } else if (id == android.R.id.home) {
            Intent intent = new Intent(this, ScientistsActivityclcaem.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;
        } else if (id == R.id.video3_caem) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.listv3.Helpers.Utils.youtube_level_stat));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cl_caem);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(DetailActivityclcaem.this, ScientistsActivityclcaem.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

        initializeWidgets();

        // Share button logic
        Button mBtnShare = findViewById(R.id.btnShare_caem);
        mBtnShare.setOnClickListener(view -> {
            String s_CODUL_TV_CAEM = CODUL_TV_CAEM.getText().toString();
            String s_DENUMIRE_TV_caem = DENUMIRE_TV_caem.getText().toString();

            String contentShare = " Codul CAEM : " + s_CODUL_TV_CAEM + " - Denumirea activitatii, \n" +
                    "  :  " + s_DENUMIRE_TV_caem +
                    " -- The application -Level Stat - can be downloaded from here " +
                    app_google;

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "CLASIFICATORUL ACTIVITĂŢILOR \nDIN ECONOMIA MOLDOVEI \n(CAEM)\n");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, contentShare);

            startActivity(Intent.createChooser(sharingIntent, "Share text via"));
        });

        // Receive and display the passed data
        receiveAndShowData();
    }
}
