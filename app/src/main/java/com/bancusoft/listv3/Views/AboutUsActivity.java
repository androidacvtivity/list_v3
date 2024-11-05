package com.bancusoft.listv3.Views;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.widget.TextView;
import android.widget.Toast;

import com.bancusoft.listv3.R;
import com.bancusoft.listv3.Views.structbns.Full_description;

import java.util.TimeZone;

public class AboutUsActivity extends AppCompatActivity {
    public void openMapsLink(View view) {
        String url = "https://www.google.com/maps/place/Chi%C8%99in%C4%83u,+Moldova/@46.9999566,28.7757764,12z/data=!3m1!4b1!4m6!3m5!1s0x40c97c3628b769a1:0x37d1d6305749dd3c!8m2!3d47.0104529!4d28.8638102!16zL20vMGZuNzc?authuser=0";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }


    public void onMImageViewClick(View view) {
        // LinkedIn profile URL
        String linkedinProfileUrl = getString(R.string.http_linkedin);

        // Create an intent to open the URL in the LinkedIn app
        Intent chromeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinProfileUrl));
        chromeIntent.setPackage("com.linkedin.android"); // Package name for LinkedIn app

        try {
            // Open the URL in LinkedIn if it's installed
            startActivity(chromeIntent);
        } catch (ActivityNotFoundException e) {
            // Log error and fallback to WebView
            Log.e("onMImageViewClick", "LinkedIn app not available, opening URL in WebView", e);

            // Fall back to opening the URL in a WebView within your app
            openLinkInWebView(linkedinProfileUrl);
        }
    }

    //---------------------------------------------------------------------

    private void openLinkInWebView(String url) {
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("url", url);
        startActivity(webViewIntent);
    }
    private static final int CALL_PERMISSION_REQUEST_CODE = 123;

    public void onCallImageViewClick(View view) {
        String phoneNumber = getString(R.string.phone_number);
        handleCall(phoneNumber, view);
    }
    public void onCallImageViewClick_ro(View view) {
        String phoneNumber = getString(R.string.phone_number_ro);
        handleCall(phoneNumber, view);
    }

    public void handleCall(String phoneNumber, View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall(phoneNumber);
        } else {
            // Request the CALL_PHONE permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with calling
                handleCall(getString(R.string.phone_number), null); // You can pass null or an actual View instance here
            } else {
                // Permission denied, show a message or take appropriate action
                showSupportEmailOption();
            }
        }
    }

    private void showSupportEmailOption() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permission Denied");
        builder.setMessage("You have denied the permission to make phone calls. If you need assistance, please contact our support team via email.");

        builder.setPositiveButton("Email Support", (dialog, which) -> {
            // Open an email client to compose an email to support
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "bancusoft@google.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request");
            startActivity(Intent.createChooser(emailIntent, "Choose an email client"));
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Handle cancel action
            dialog.dismiss();
        });

        builder.show();
    }



    private void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }




    public void onEmailImageViewClick(View view) {
        // Create an Intent to send an email
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text"); // Set the type to plain text

        // Set the recipient emails
        String[] recipients = new String[]{"bancusoft@gmail.com", "vitalie.bancu@bancusoft.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);

        // Retrieve the Android version, device model, manufacturer, etc.
        String androidVersion = Build.VERSION.RELEASE;
        String deviceModel = Build.MODEL;
        String deviceManufacturer = Build.MANUFACTURER;
        String buildNumber = Build.DISPLAY;
        String cpuArchitecture = Build.SUPPORTED_ABIS[0]; // First ABI is the preferred one
        String timeZone = TimeZone.getDefault().getID(); // Get the current time zone
        String deviceBrand = Build.BRAND;
        String host = Build.HOST;
        String bootloader = Build.BOOTLOADER;

        // Retrieve screen resolution
        DisplayMetrics displayMetrics = new DisplayMetrics();
        view.getContext().getResources().getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // Retrieve available and total internal storage
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long totalStorage = statFs.getTotalBytes();
        long availableStorage = statFs.getAvailableBytes();

        // Retrieve available RAM
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) view.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        long totalRam = memoryInfo.totalMem;
        long availableRam = memoryInfo.availMem;

        // Add subject and body to the email with additional device information
        String emailBody = "Device Information:\n"
                + "Android Version: " + androidVersion + "\n"
                + "Device Model: " + deviceModel + "\n"
                + "Manufacturer: " + deviceManufacturer + "\n"
                + "Build Number: " + buildNumber + "\n"
                + "Brand: " + deviceBrand + "\n"
                + "CPU Architecture: " + cpuArchitecture + "\n"
                + "Time Zone: " + timeZone + "\n"
                + "Host: " + host + "\n"
                + "Bootloader: " + bootloader + "\n"
                + "Screen Resolution: " + screenWidth + "x" + screenHeight + " pixels\n"
                + "Total Internal Storage: " + totalStorage / (1024 * 1024) + " MB\n"
                + "Available Internal Storage: " + availableStorage / (1024 * 1024) + " MB\n"
                + "Total RAM: " + totalRam / (1024 * 1024) + " MB\n"
                + "Available RAM: " + availableRam / (1024 * 1024) + " MB";

        // Set the email subject and body
        String emailSubject = "About Stat Level - Device: " + deviceModel;
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);

        // Specify the Gmail package
        intent.setPackage("com.google.android.gm");

        try {
            // Try to start the Gmail app
            startActivity(intent);
        } catch (Exception e) {
            // If Gmail is not available, fall back to a generic email chooser
            Intent fallbackIntent = new Intent(Intent.ACTION_SENDTO);
            fallbackIntent.setData(Uri.parse("mailto:")); // Using ACTION_SENDTO requires a mailto URI
            fallbackIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
            fallbackIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            fallbackIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

            try {
                startActivity(Intent.createChooser(fallbackIntent, "Choose Email Client"));
            } catch (Exception ex) {
                // If no email app is available, show a toast
                Toast.makeText(view.getContext(), "No email app available", Toast.LENGTH_SHORT).show();
            }
        }
    }




    //--------------------------------------------------------------------------
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_me);
        Toolbar toolbar = findViewById(R.id.aboutUsToolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.mBackArrow).setOnClickListener(v -> finish());
        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(AboutUsActivity.this, DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);


        // Find the TextView that should open the disclaimer content
        TextView disclaimerTextView = findViewById(R.id.disclaimer_layout);
        disclaimerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(AboutUsActivity.this, Full_description.class);
            startActivity(intent);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_dgti, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_dgti) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish(); // Move finish() after startActivity
            return true;
        } else if (id == android.R.id.home) {
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish(); // Move finish() after startActivity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void setReceivedScientist() {
    }


}
