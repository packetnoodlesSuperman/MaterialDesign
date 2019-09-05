package com.bob.bugly.proguard;

import android.content.Context;

public class z {

    public static Context getApplicationContext(Context context) {
        if (context == null) {
            return context;
        } else {
            return context.getApplicationContext() == null ? context : context.getApplicationContext();
        }
    }

}
