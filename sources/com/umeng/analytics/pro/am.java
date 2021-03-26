package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: ConvertHelper */
public class am {
    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile("[0-9]+").matcher(str).matches();
        }
        return false;
    }
}
