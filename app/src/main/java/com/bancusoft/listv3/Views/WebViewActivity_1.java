package com.bancusoft.listv3.Views;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.R;

public class WebViewActivity_1 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_1);

        WebView   webView = findViewById(R.id.webView);

        // Enable JavaScript (if needed)
        webView.getSettings().setJavaScriptEnabled(true);

        // Set a WebViewClient to handle URL loading within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Get the URL from the intent data
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("url")) {
            String url = intent.getStringExtra("url");
            // Load the URL within the WebView

            if (url != null) {
                // Load the URL within the WebView
                webView.loadUrl(url);
            } else {
                Toast.makeText(this, "URL is not provided or is invalid", Toast.LENGTH_SHORT).show();
            }



        }

        // Create an OnBackPressedCallback to handle back button press
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Utils.openActivity(WebViewActivity_1.this, help_vw_ro.class);
            }
        };

        // Add the callback
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
