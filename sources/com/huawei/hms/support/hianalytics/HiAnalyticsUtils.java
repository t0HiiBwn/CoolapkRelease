package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bu;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.countrycode.CountryCodeBean;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HiAnalyticsUtils {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static HiAnalyticsUtils c;
    private static String e = new String();
    private int d = 0;
    private final int f = -1;
    private int g = -1;
    private int h = -1;
    private boolean i = false;

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (a) {
            if (c == null) {
                c = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = c;
        }
        return hiAnalyticsUtils;
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        if (!hasError(context)) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                onEvent2(context, str, a2);
                bs.a(1, str, b(map));
                a();
            }
        }
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        if (!hasError(context) && context != null) {
            onEvent2(context, str, str2);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        if (!hasError(context) && context != null && bs.b()) {
            bs.a(context, str, str2);
        }
    }

    private String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            HMSLog.e("HiAnalyticsUtils", "AnalyticsHelper create json exception" + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public void onNewEvent(Context context, String str, Map map) {
        if (!hasError(context)) {
            String a2 = a(map);
            if (context != null && bs.b()) {
                bs.a(context, str, a2);
                bs.a(1, str, b(map));
                a();
            }
        }
    }

    private static LinkedHashMap<String, String> b(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (String str : map.keySet()) {
            linkedHashMap.put(str, map.get(str));
        }
        return linkedHashMap;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void onReport(Context context, String str, Map map) {
        if (!hasError(context)) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                HMSLog.i("HiAnalyticsUtils", "Report the data");
                onEvent2(context, str, a2);
                bs.a(1, str, b(map));
                bs.a();
            }
        }
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        bu.a();
    }

    public boolean hasError(Context context) {
        String str;
        if (this.h == -1 ? a(context) : this.i) {
            HMSLog.i("HiAnalyticsUtils", "cp BI report protocol is true");
            return false;
        }
        String str2 = e;
        if (str2 == null || str2.isEmpty()) {
            HMSLog.i("HiAnalyticsUtils", "issueCountry initial");
            String a2 = new CountryCodeBean(context, false).a();
            e = a2;
            if (TextUtils.isEmpty(a2)) {
                str = "CN";
            } else {
                str = e.toUpperCase(Locale.ENGLISH);
            }
            e = str;
        }
        if (!"CN".equalsIgnoreCase(e) && this.g == -1) {
            HMSLog.i("HiAnalyticsUtils", "not ChinaROM");
            if (context == null) {
                return true;
            }
            try {
                this.g = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
                HMSLog.i("HiAnalyticsUtils", "hw_app_analytics_state value is " + this.g);
                if (this.g != 1) {
                    return true;
                }
                return false;
            } catch (Settings.SettingNotFoundException unused) {
                HMSLog.i("HiAnalyticsUtils", "Get OOBE failed");
                return true;
            }
        } else if (this.g == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getInitFlag() {
        HMSLog.i("HiAnalyticsUtils", "Get the init flag");
        return bs.b();
    }

    private void a() {
        synchronized (b) {
            int i2 = this.d;
            if (i2 < 60) {
                this.d = i2 + 1;
            } else {
                this.d = 0;
                bs.a();
            }
        }
    }

    private boolean a(Context context) {
        if (context == null) {
            HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to get 'PackageManager' instance.");
            return false;
        }
        this.h = 0;
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || applicationInfo.metaData == null) {
                HMSLog.i("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
                return false;
            }
            boolean z = applicationInfo.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
            this.i = z;
            return z;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            return false;
        }
    }
}
