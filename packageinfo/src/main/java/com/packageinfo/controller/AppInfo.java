package com.packageinfo.controller;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.packageinfo.R;
import com.packageinfo.model.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nmn on 8/3/17.
 */

public class AppInfo {

    private Context context;
    private static AppInfo appInfo;
    List<ApplicationInfo> system_apps;
    List<ApplicationInfo> user_installed_apps = new ArrayList<>();
    private static int INSTALLED_APPS = 0;


    private AppInfo(Context context) {
        this.context = context;
    }


    public static  AppInfo getAppInfo (Context context)
    {
    if (appInfo==null)
    {

        appInfo = new AppInfo(context);

    }
        return appInfo ;


    }

    public ArrayList<App> getAllApps ()
    {

        PackageManager pm = context.getPackageManager() ;
        system_apps = context.getPackageManager().getInstalledApplications(0);
         for (ApplicationInfo ai : system_apps)
         {
             if((ai.flags & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP | ApplicationInfo.FLAG_SYSTEM)) > 0) {
                 // It is a system app
             } else {
                 // It is installed by the user
                 user_installed_apps.add(ai);

             }


         }
        Log.v("checkuserApps",user_installed_apps.size()+"") ;
        ArrayList<App> apps = new ArrayList<>();
        for (ApplicationInfo ai : user_installed_apps)
        {

            App app = new App();
            app.setIcon(ai.loadIcon(context.getPackageManager()));
            app.setName(context.getPackageManager().getApplicationLabel(ai)+"");
            app.setPackageName(ai.packageName);
            apps.add(app);
        }
        Log.v("checkuserApps",apps.size()+"") ;
            return apps ;
    }


    public ArrayList<String> getServices(String pkgName)
    {
        ArrayList <String> serviceList = new ArrayList<>();

        try {
            PackageInfo pkginfo = context.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_SERVICES);

            for (ServiceInfo si : pkginfo.services)
            {
                serviceList.add(si.name) ;
            }

        }
        catch (PackageManager.NameNotFoundException ex)
        {
            ex.printStackTrace();
        }
       return  serviceList ;

    }

    public ArrayList<String> getActivities (String pkgName)
    {

       ArrayList <String> activityList = new ArrayList<>() ;

        try {
        PackageInfo pkginfo = context.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_ACTIVITIES);
        for (ActivityInfo activityInfo : pkginfo.activities)
        {
            activityList.add(activityInfo.name) ;
        }

        }
        catch (PackageManager.NameNotFoundException ne)
        {
            ne.printStackTrace();
        }
        return  activityList ;
    }


    public Drawable getIcon (String pkgName)
    {
        Drawable drawable =context.getResources().getDrawable(R.drawable.chek);
        try {
             drawable = context.getPackageManager().getApplicationIcon(pkgName) ;
        }
        catch(PackageManager.NameNotFoundException ne)
        {
            ne.printStackTrace();
        }

        return drawable ;

    }

}
