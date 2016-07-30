package com.luisalonso.rxandroidexample;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class RxAndroidExample extends Application {

    static class Config {
        static final boolean DEBUG = true;
    }

    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
    }

    public static void log(String message) {
        if (Config.DEBUG) {
            Log.d("RxAndroidExample", message);
        }
    }

    public static void log(String tag, String message) {
        if (Config.DEBUG) {
            Log.d(tag, message);
        }
    }
}
