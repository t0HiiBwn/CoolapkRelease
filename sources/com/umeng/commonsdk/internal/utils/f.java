package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: InfoPreference */
public class f {
    private static final String a = "info";
    private static final String b = "a_dc";
    private static final String c = "bssid";
    private static final String d = "ssid";
    private static final String e = "a_fcy";
    private static final String f = "a_hssid";
    private static final String g = "a_ip";
    private static final String h = "a_ls";
    private static final String i = "a_mac";
    private static final String j = "a_nid";
    private static final String k = "rssi";
    private static final String l = "sta";
    private static final String m = "ts";
    private static final String n = "wifiinfo";
    private static final String o = "ua";

    public static JSONArray a(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
            if (sharedPreferences == null || (string = sharedPreferences.getString("wifiinfo", null)) == null) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
            return null;
        }
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("wifiinfo").commit();
        }
    }

    public static void a(Context context, a.b bVar) {
        JSONArray jSONArray;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
            String str = null;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("wifiinfo", null);
                if (string == null) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(string);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a_dc", bVar.a);
                jSONObject.put("bssid", bVar.b);
                jSONObject.put("ssid", bVar.c);
                jSONObject.put("a_fcy", bVar.d);
                jSONObject.put("a_hssid", bVar.e);
                jSONObject.put("a_ip", bVar.f);
                jSONObject.put("a_ls", bVar.g);
                jSONObject.put("a_mac", bVar.h);
                jSONObject.put("a_nid", bVar.i);
                jSONObject.put("rssi", bVar.j);
                jSONObject.put("sta", bVar.k);
                jSONObject.put("ts", bVar.l);
                jSONArray.put(jSONObject);
                str = jSONArray.toString();
            }
            if (str != null) {
                sharedPreferences.edit().putString("wifiinfo", str).commit();
            }
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ua", str).commit();
        }
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("ua", null);
        }
        return null;
    }
}
