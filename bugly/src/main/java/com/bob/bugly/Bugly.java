package com.bob.bugly;

import android.content.Context;
import android.util.Log;
import com.bob.bugly.proguard.z;

public class Bugly {

    private static boolean isCreated = false;
    public static Context applicationContext = null;

    public Bugly() {}

    public static void init(Context context, String string, boolean var) {

    }

//    public static synchronized void init(Context context,
//                                         String sting,
//                                         boolean var,
//                                         BuglyStrategy buglyStrategy) {
//        if (!isCreated) {
//            isCreated = true;
//
//            if ((applicationContext = z.getApplicationContext(context)) == null) {
//                Log.e(x.a, "init arg 'context' should not be null!");
//            } else {
//                if (isDev())
//            }
//        }
//
//
//    }
//
//    private static boolean isDev() {
//
//    }

}
