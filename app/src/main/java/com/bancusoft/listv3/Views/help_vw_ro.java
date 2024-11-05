package com.bancusoft.listv3.Views;
import static com.bancusoft.listv3.R.id.TextView_1;
import static com.bancusoft.listv3.R.string.date_ro1;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.R;

public class help_vw_ro  extends BaseActivity{

    public help_vw_ro() {
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpvw_ro);




        // Get the TextView
        TextView textView = findViewById(TextView_1);


        // Define the original string
        String originalText = getString(date_ro1);


        // Find the start and end indices of "data.gov.ro"
        int startIndex = originalText.indexOf("data.gov.ro");
        int endIndex = startIndex + "data.gov.ro".length();

        // Create a SpannableString to make the link clickable
        SpannableString spannableString = new SpannableString(originalText);



        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                openUrl("https://data.gov.ro/");
            }

            private void openUrl(String url) {

                Intent intent = new Intent(help_vw_ro.this, WebViewActivity_1.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }

        };


        // Set the ClickableSpan to the specified range
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        // Set the text in the TextView
        textView.setText(spannableString);

        // Make the link clickable
        textView.setMovementMethod(LinkMovementMethod.getInstance());



        findViewById(R.id.mBackArrowh_vw_ro).setOnClickListener(v ->  Utils.openActivity(help_vw_ro.this,DashboardActivity.class));



        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Show the info dialog
                Utils.openActivity(help_vw_ro.this, DashboardActivity.class);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);


    }


    public void setReceivedScientist() {
    }
}
