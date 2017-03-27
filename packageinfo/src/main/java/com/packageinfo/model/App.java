package com.packageinfo.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by nmn on 8/3/17.
 */
public class App {

    public String name ;
    public String packageName ;
    public Drawable icon ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
