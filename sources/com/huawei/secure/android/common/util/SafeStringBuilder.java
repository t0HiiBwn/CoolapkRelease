package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

public class SafeStringBuilder {
    private static final String TAG = "SafeStringBuilder";
    private static final String i = "";

    public static String substring(StringBuilder sb, int i2) {
        if (!TextUtils.isEmpty(sb) && sb.length() >= i2 && i2 >= 0) {
            try {
                return sb.substring(i2);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuilder sb, int i2, int i3) {
        if (!TextUtils.isEmpty(sb) && i2 >= 0 && i3 <= sb.length() && i3 >= i2) {
            try {
                return sb.substring(i2, i3);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
