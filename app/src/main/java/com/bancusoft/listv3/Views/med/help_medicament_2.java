package com.bancusoft.listv3.Views.med;
import static com.bancusoft.listv3.Helpers.Utils_2.showInfoDialog_help_ro_med_3;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;
import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.Helpers.Utils_2;
import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Retrofit.Scientist;
import com.bancusoft.listv3.Views.BaseActivity;
import com.bancusoft.listv3.Views.DashboardActivity;

public class help_medicament_2 extends BaseActivity {

    private Scientist receivedScientist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_med);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBarn_med);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrowh_med).setOnClickListener(v -> Utils_2.showInfoDialog_help_ro_med_3(this,
                "Atenție", "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar despre clasificatorul medicamentelor  in limba engleza si rusa."));

        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Show the info dialog
                showInfoDialog_help_ro_med_3(help_medicament_2.this,
                        "Atenție", "Sunteți sigutri că vreți sa esiți? Exista traducere la indrumar despre clasificatorul medicamentelor  in limba engleza si rusa.");
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_med, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.rolang_med) {
            Utils.sendScientistToActivity(this, receivedScientist, help_medicament_2.class);
            finish();
            return true;
        } else if (id == R.id.enlang_med) {
            Utils.sendScientistToActivity(this, receivedScientist, help_medicament_en.class);
            finish();
            return true;
        } else if (id == R.id.rulang_med) {
            Utils.sendScientistToActivity(this, receivedScientist, help_medicament_ru.class);
            finish();
            return true;
        } else if (id == android.R.id.home) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;
        } else if (id == R.id.link1_med) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.listv3.Helpers.Utils.youtube_level_stat));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }

    public void setReceivedScientist() {
        // empty method, consider removing if not used
    }
}
