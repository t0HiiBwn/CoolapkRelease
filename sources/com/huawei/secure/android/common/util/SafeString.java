package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeString {
    private static final String TAG = "SafeString";
    private static final String i = "";

    public static String substring(String str, int i2) {
        if (str != null && str.length() >= i2 && i2 >= 0) {
            try {
                return str.substring(i2);
            } catch (Exception e) {
                String str2 = TAG;
                Log.e(str2, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i2, int i3) {
        if (str != null && i2 >= 0 && i3 <= str.length() && i3 >= i2) {
            try {
                return str.substring(i2, i3);
            } catch (Exception e) {
                String str2 = TAG;
                Log.e(str2, "substring: " + e.getMessage());
            }
        }
        return "";
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (!(str == null || charSequence == null || charSequence2 == null)) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e) {
                String str2 = TAG;
                Log.e(str2, "replace: " + e.getMessage());
            }
        }
        return str;
    }
}
