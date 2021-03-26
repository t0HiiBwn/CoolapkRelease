package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeStringBuffer {
    private static final String TAG = "SafeStringBuffer";
    private static final String i = "";

    public static String substring(StringBuffer stringBuffer, int i2) {
        if (stringBuffer != null && stringBuffer.length() >= i2 && i2 >= 0) {
            try {
                return stringBuffer.substring(i2);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i2, int i3) {
        if (stringBuffer != null && i2 >= 0 && i3 <= stringBuffer.length() && i3 >= i2) {
            try {
                return stringBuffer.substring(i2, i3);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
