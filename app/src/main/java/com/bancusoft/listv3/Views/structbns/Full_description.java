package com.bancusoft.listv3.Views.structbns;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bancusoft.listv3.R;

public class Full_description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disclaimer_layout);

        // Inițializarea spannableString
        SpannableString spannableString = new SpannableString("date.gov.md");
        SpannableString spannableString1 = new SpannableString("date.gov.ro");

        // Inițializarea clickableSpan
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                // Gestionează acțiunea de clic pe link
                String url = "https://dataset.gov.md/dataset/11736-date-din-registrul-de-stat-al-unitatilor-de-drept-privind-intreprinderile-inregistrate-in-repu/resource/bf9b2be1-c341-4898-8d11-17270a0bc647";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }



            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED); // Setează culoarea textului la roșu
                ds.setUnderlineText(false); // Dezactivează sublinierea textului
            }
        };


        // Inițializarea clickableSpan
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                // Gestionează acțiunea de clic pe link
                String url = "https://data.gov.ro/dataset/firme-inregistrate-la-registrul-comertului-pana-la-data-de-07-aprilie-2023/resource/27d6a6fd-f656-477c-bb5b-5f727562205a";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }



            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED); // Setează culoarea textului la roșu
                ds.setUnderlineText(false); // Dezactivează sublinierea textului
            }
        };

        // Setează ClickableSpan pentru textul "Link1"
        spannableString.setSpan(clickableSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(clickableSpan1, 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Găsește TextView-ul din layout și setează textul și gestionarea clicului pe link
        TextView footerTextView = findViewById(R.id.footerTextView);
        footerTextView.setText(spannableString);
        footerTextView.setMovementMethod(LinkMovementMethod.getInstance());


        // Găsește TextView-ul din layout și setează textul și gestionarea clicului pe link
        TextView footerTextView1 = findViewById(R.id.footerTextView1);
        footerTextView1.setText(spannableString1);
        footerTextView1.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
