package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class c {
    private static Context u;

    public static Context k() {
        return u;
    }

    public static void setContext(Context context) {
        if (context != null && u == null) {
            u = context.getApplicationContext();
        }
    }
}
