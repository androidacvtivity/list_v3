package com.bancusoft.listv3.Helpers;

import android.widget.TextView;

public class ViewUtils {
    public static void setTextSafely(TextView textView, String text) {
        if (textView != null && text != null) {
            textView.setText(text.trim());
        }
    }

}