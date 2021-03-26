package com.huawei.hms.stats;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

public class ap {
    public static String a(Context context, String str) {
        String packageName = context.getPackageName();
        String m = c.m("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(m)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + m;
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences d = d(context, str);
        if (d != null) {
            SharedPreferences.Editor edit = d.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences d = d(context, str);
        if (d != null) {
            SharedPreferences.Editor edit = d.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static void a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else if (strArr == null) {
            str2 = "clearData(): No data need to be deleted,keys is null";
        } else {
            SharedPreferences d = d(context, str);
            if (d != null) {
                SharedPreferences.Editor edit = d.edit();
                if (strArr.length == 0) {
                    edit.clear();
                    edit.commit();
                    return;
                }
                for (String str3 : strArr) {
                    if (d.contains(str3)) {
                        edit.remove(str3);
                        edit.commit();
                    }
                }
                return;
            }
            return;
        }
        af.c("SharedPreUtils", str2);
    }

    public static long b(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return j;
        }
        SharedPreferences d = d(context, str);
        return d != null ? d.getLong(str2, j) : j;
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences d = d(context, str);
        return d != null ? d.getString(str2, str3) : str3;
    }

    public static Map<String, ?> b(Context context, String str) {
        return d(context, str).getAll();
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            af.c("SharedPreUtils", "clearTypeDataByTag() eventTag is null or empty!");
        } else if ("_default_config_tag".equals(str)) {
            a(context, "stat_v2_1", str);
            a(context, "cached_v2_1", str);
        } else {
            String str2 = str + "-oper";
            String str3 = str + "-maint";
            String str4 = str + "-diffprivacy";
            a(context, "stat_v2_1", str2);
            a(context, "cached_v2_1", str2);
            a(context, "stat_v2_1", str3);
            a(context, "cached_v2_1", str3);
            a(context, "stat_v2_1", str4);
            a(context, "cached_v2_1", str4);
        }
    }

    private static SharedPreferences d(Context context, String str) {
        return context.getSharedPreferences(a(context, str), 0);
    }
}
