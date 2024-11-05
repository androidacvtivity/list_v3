package com.bancusoft.listv3;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Verdana.ttf")
                             //   .setDefaultFontPath("fonts/Roboto-Bold.ttf")
                                .setFontAttrId(io.github.inflationx.calligraphy3.R.attr.fontPath)

                                //.setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }
}
//end
