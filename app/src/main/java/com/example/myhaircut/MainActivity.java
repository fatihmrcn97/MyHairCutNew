package com.example.myhaircut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printKeyhas();
    }

    private void printKeyhas() {
    try{
        PackageInfo packageInfo = getPackageManager().getPackageInfo(
                getPackageName(), PackageManager.GET_SIGNATURES
        );
        for(Signature signature :packageInfo.signatures){
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("keyhash", Base64.encodeToString(md.digest(),Base64.DEFAULT));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
