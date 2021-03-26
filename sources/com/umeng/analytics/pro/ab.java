package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: UMPreferenceWrapper */
public class ab {
    public static final String a = "cconfig_sp_last_request_time";
    public static final String b = "abtest_sp_last_request_data";
    private static final String c = "umeng_general_config";
    private static final String d = "cconfig_sharedpreference";

    private ab() {
    }

    public static SharedPreferences a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("cconfig_sharedpreference", 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
