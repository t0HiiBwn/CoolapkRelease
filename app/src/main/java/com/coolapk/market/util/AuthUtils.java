package com.coolapk.market.util;

import android.content.Context;

public class AuthUtils {
    public static native String getAS(Context context, String str);

    static {
        System.loadLibrary("native-lib");
    }
}
