package com.kepler.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class ak {
    static String a() {
        return "Android";
    }

    static String b() {
        return Build.VERSION.RELEASE;
    }

    static String c() {
        return Build.MODEL;
    }

    static String a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Throwable th) {
            j.a(th);
            return "";
        }
    }

    static String b(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i == 120) {
            return "LDPI";
        }
        if (i == 160) {
            return "MDPI";
        }
        if (i == 213) {
            return "TVDPI";
        }
        if (i == 240) {
            return "HDPI";
        }
        if (i == 320) {
            return "XHDPI";
        }
        if (i == 400) {
            return "XMHDPI";
        }
        if (i != 480) {
            return i != 640 ? "" : "XXXHDPI";
        }
        return "XXHDPI";
    }

    static String d() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            j.a(e);
            return "1.0";
        }
    }

    static String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "_dev", c(), "_o", a(), "_oV", b(), "_r", a(context), "_d", b(context), "_l", d());
        String jSONObject2 = jSONObject.toString();
        try {
            return URLEncoder.encode(jSONObject2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            j.a(e);
            return jSONObject2;
        }
    }

    static String e(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "_nt", f(context));
        String jSONObject2 = jSONObject.toString();
        try {
            return URLEncoder.encode(jSONObject2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            j.a(e);
            return jSONObject2;
        }
    }

    public static String f(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String lowerCase = connectivityManager.getActiveNetworkInfo().getTypeName().toLowerCase(Locale.US);
            return !lowerCase.equals("wifi") ? connectivityManager.getNetworkInfo(0).getExtraInfo() : lowerCase;
        } catch (Exception e) {
            j.a(e);
            return "";
        }
    }

    static void a(JSONObject jSONObject, String... strArr) {
        try {
            if (strArr.length > 0 && strArr.length % 2 == 0) {
                for (int i = 0; i < strArr.length; i += 2) {
                    String str = strArr[i];
                    String str2 = strArr[i + 1];
                    if (str2 != null && str2.length() > 0) {
                        jSONObject.put(str, str2);
                    }
                }
            }
        } catch (JSONException e) {
            j.a(e);
        }
    }
}
