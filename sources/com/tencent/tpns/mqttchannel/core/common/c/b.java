package com.tencent.tpns.mqttchannel.core.common.c;

import android.content.Context;
import android.net.ConnectivityManager;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* compiled from: ProGuard */
public class b {
    public static int a;

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String a(Context context, String str) {
        return "/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String b(Context context, String str) {
        return "/_xg/push/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String c(Context context, String str) {
        return "/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String d(Context context, String str) {
        return "/_xg/push/aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String e(Context context, String str) {
        return "/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String f(Context context, String str) {
        return "/_xg/push/gzip/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String g(Context context, String str) {
        return "/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static String h(Context context, String str) {
        return "/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + "/" + str;
    }

    public static boolean i(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean j(Context context, String str) {
        return str.startsWith("/_xg/push/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean k(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean l(Context context, String str) {
        return str.startsWith("/_xg/push/aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean m(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean n(Context context, String str) {
        return str.startsWith("/_xg/push/gzip/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean o(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean p(Context context, String str) {
        return str.startsWith("/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + "/");
    }

    public static boolean a(Context context) {
        try {
            if (!Util.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return true;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            if (a()) {
                return true;
            }
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "APNUtil -> checkNetWork", th);
            int i = a + 1;
            a = i;
            if (i >= 5) {
                a = 0;
                return true;
            }
        }
    }

    public static boolean a() {
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 -w 10 www.qq.com");
            int waitFor = exec.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (bufferedReader.readLine() != null) {
            }
            bufferedReader.close();
            exec.destroy();
            if (waitFor == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
