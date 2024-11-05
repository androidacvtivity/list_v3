package com.bancusoft.listv3.Views;
import androidx.appcompat.app.AppCompatActivity;

import com.bancusoft.listv3.Helpers.Utils;



public class BaseActivity  extends AppCompatActivity {
    protected void show(String message){
        Utils.show(this,message);
    }
}

