package com.huawei.hms.stats;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;

public class bi extends k {
    public static String c() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                af.b("hmsSdk", "getUDID success");
                return str3;
            } catch (ClassNotFoundException unused) {
                str2 = str3;
            } catch (AndroidRuntimeException unused2) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                af.c("hmsSdk", str);
                return str2;
            } catch (NoSuchMethodException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                af.c("hmsSdk", str);
                return str2;
            } catch (IllegalAccessException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                af.c("hmsSdk", str);
                return str2;
            } catch (IllegalArgumentException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                af.c("hmsSdk", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                af.c("hmsSdk", str);
                return str2;
            }
        } catch (ClassNotFoundException unused7) {
            str = "getUDID method invoke failed";
            af.c("hmsSdk", str);
            return str2;
        } catch (AndroidRuntimeException unused8) {
            str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            af.c("hmsSdk", str);
            return str2;
        } catch (NoSuchMethodException unused9) {
            str = "getUDID method invoke failed : NoSuchMethodException";
            af.c("hmsSdk", str);
            return str2;
        } catch (IllegalAccessException unused10) {
            str = "getUDID method invoke failed : Illegal AccessException";
            af.c("hmsSdk", str);
            return str2;
        } catch (IllegalArgumentException unused11) {
            str = "getUDID method invoke failed : Illegal ArgumentException";
            af.c("hmsSdk", str);
            return str2;
        } catch (InvocationTargetException unused12) {
            str = "getUDID method invoke failed : InvocationTargetException";
            af.c("hmsSdk", str);
            return str2;
        }
    }

    public static String e(Context context) {
        if (ay.a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getDeviceId() : "";
        } catch (SecurityException unused) {
            af.d("hmsSdk", "getDeviceID Incorrect permissions!");
            return "";
        }
    }

    public static String f(Context context) {
        String str = Build.SERIAL;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown")) ? h(context) : str;
    }

    public static Pair<String, String> g(Context context) {
        if (ay.a(context, "android.permission.READ_PHONE_STATE")) {
            af.c("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new Pair<>("", "");
        }
        if (telephonyManager.getSimState() != 5) {
            return new Pair<>("", "");
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null")) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
    }

    private static String h(Context context) {
        af.a("hmsSdk", "getSerial : is executed.");
        if (context == null || ay.a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
        } catch (SecurityException unused) {
            af.c("hmsSdk", "getSerial() Incorrect permissions!");
            return "";
        }
    }
}
