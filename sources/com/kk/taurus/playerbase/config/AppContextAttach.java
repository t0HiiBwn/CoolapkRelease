package com.kk.taurus.playerbase.config;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class AppContextAttach {
    private static Context mAppContext;

    public static void attach(Application application) {
        mAppContext = application.getApplicationContext();
    }

    public static Context getApplicationContext() {
        Context context = mAppContext;
        if (context != null) {
            return context;
        }
        Log.e("AppContextAttach", "app context not init !!!");
        throw new RuntimeException("if you need context for using decoder, you must call PlayerLibrary.init(context).");
    }
}
