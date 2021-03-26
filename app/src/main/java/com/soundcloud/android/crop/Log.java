package com.soundcloud.android.crop;

class Log {
    private static final String TAG = "android-crop";

    Log() {
    }

    public static void e(String str) {
        android.util.Log.e("android-crop", str);
    }

    public static void e(String str, Throwable th) {
        android.util.Log.e("android-crop", str, th);
    }
}
