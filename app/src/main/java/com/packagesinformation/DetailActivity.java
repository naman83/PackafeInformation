package com.packagesinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.packageinfo.controller.AppInfo;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        AppInfo appInfo = AppInfo.getAppInfo(this) ;
         ;

        Log.v ("activities",appInfo.getActivities(appInfo.getAllApps().get(getIntent().getExtras().getInt("positionSelected")).getPackageName()).toString());
        Log.v("services",appInfo.getServices(appInfo.getAllApps().get(getIntent().getExtras().getInt("positionSelected")).getPackageName()).toString());
    }
}
