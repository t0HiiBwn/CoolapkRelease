package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.e;
import java.util.Locale;

/* compiled from: ProGuard */
public class c {
    static String a;
    static String b;
    static String c;
    private static String d;
    private static String e;

    public static String a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context a2 = e.a();
            if (a2 == null || (wifiManager = (WifiManager) a2.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "";
            }
            return connectionInfo.getMacAddress();
        } catch (SecurityException e2) {
            f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e2);
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (context == null) {
            return "";
        }
        d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            d = width + "x" + height;
        }
        return d;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context) {
        String str = a;
        if (str != null && str.length() > 0) {
            return a;
        }
        if (context == null) {
            return "";
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            a = deviceId;
            return deviceId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        String str = b;
        if (str != null && str.length() > 0) {
            return b;
        }
        if (context == null) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            b = simSerialNumber;
            return simSerialNumber;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        String str = c;
        if (str != null && str.length() > 0) {
            return c;
        }
        if (context == null) {
            return "";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            c = string;
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (e == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append('&');
                sb.append("model=");
                sb.append(Build.MODEL);
                sb.append('&');
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append('&');
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append('&');
                String b2 = a.b(context);
                if (b2 == null) {
                    b2 = "";
                }
                sb.append("network=");
                sb.append(b2);
                sb.append('&');
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append('&');
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(a.e(context));
                e = sb.toString();
            }
            return e;
        } catch (Exception unused) {
            return null;
        }
    }
}
