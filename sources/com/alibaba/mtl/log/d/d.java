package com.alibaba.mtl.log.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.model.LogField;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: DeviceUtil */
public class d {
    private static Map<String, String> v;

    public static synchronized Map<String, String> a(Context context) {
        synchronized (d.class) {
            Map<String, String> map = v;
            if (map != null) {
                map.put(LogField.CHANNEL.toString(), b.o());
                v.put(LogField.APPKEY.toString(), b.getAppkey());
                String imei = m.getImei(context);
                String imsi = m.getImsi(context);
                if (TextUtils.isEmpty(imei) || TextUtils.isEmpty(imsi)) {
                    imei = "";
                    imsi = "";
                }
                v.put(LogField.IMEI.toString(), imei);
                v.put(LogField.IMSI.toString(), imsi);
                a(v, context);
                return v;
            }
            HashMap hashMap = new HashMap();
            v = hashMap;
            if (context == null) {
                return null;
            }
            if (hashMap != null) {
                try {
                    String imei2 = m.getImei(context);
                    String imsi2 = m.getImsi(context);
                    if (TextUtils.isEmpty(imei2) || TextUtils.isEmpty(imsi2)) {
                        imei2 = "";
                        imsi2 = "";
                    }
                    v.put(LogField.IMEI.toString(), imei2);
                    v.put(LogField.IMSI.toString(), imsi2);
                    v.put(LogField.BRAND.toString(), Build.BRAND);
                    v.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
                    v.put(LogField.RESOLUTION.toString(), c(context));
                    v.put(LogField.CHANNEL.toString(), b.o());
                    v.put(LogField.APPKEY.toString(), b.getAppkey());
                    v.put(LogField.APPVERSION.toString(), d(context));
                    v.put(LogField.LANGUAGE.toString(), b(context));
                    v.put(LogField.OS.toString(), s());
                    v.put(LogField.OSVERSION.toString(), r());
                    v.put(LogField.SDKVERSION.toString(), "2.6.4.5_for_bc");
                    v.put(LogField.SDKTYPE.toString(), "mini");
                    try {
                        v.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Throwable th) {
                        Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                        th.printStackTrace();
                    }
                    a(v, context);
                } catch (Exception unused) {
                    return null;
                }
            }
            return v;
        }
    }

    private static String r() {
        String str = Build.VERSION.RELEASE;
        if (i()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            str = v();
            if (!TextUtils.isEmpty(str)) {
            }
        }
        return str;
    }

    private static String s() {
        return (!i() || j()) ? "a" : "y";
    }

    private static void a(Map<String, String> map, Context context) {
        String str = "Unknown";
        try {
            String[] networkState = l.getNetworkState(context);
            map.put(LogField.ACCESS.toString(), networkState[0]);
            if (networkState[0].equals("2G/3G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), networkState[1]);
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), str);
            }
        } catch (Exception unused) {
            map.put(LogField.ACCESS.toString(), str);
            map.put(LogField.ACCESS_SUBTYPE.toString(), str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str2 = "";
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                str2 = telephonyManager.getNetworkOperatorName();
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            map.put(LogField.CARRIER.toString(), str);
        } catch (Exception unused2) {
        }
    }

    private static String b(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    private static String c(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            return i2 + "*" + i;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String d(Context context) {
        String f = b.a().f();
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return "Unknown";
            }
            v.put(LogField.APPVERSION.toString(), packageInfo.versionName);
            return packageInfo.versionName;
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    public static boolean i() {
        try {
            if ((System.getProperty("java.vm.name") != null && System.getProperty("java.vm.name").toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null) {
                return true;
            }
            if (!TextUtils.isEmpty(q.get("ro.yunos.build.version"))) {
                return true;
            }
            return j();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean j() {
        return !TextUtils.isEmpty(q.get("ro.yunos.product.chip")) || !TextUtils.isEmpty(q.get("ro.yunos.hardware"));
    }

    public static String t() {
        String str = q.get("ro.aliyun.clouduuid", "false");
        if ("false".equals(str)) {
            str = q.get("ro.sys.aliyun.clouduuid", "false");
        }
        return TextUtils.isEmpty(str) ? u() : str;
    }

    private static String u() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String v() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (String) declaredField.get(new String());
        } catch (Exception unused) {
            return null;
        }
    }
}
