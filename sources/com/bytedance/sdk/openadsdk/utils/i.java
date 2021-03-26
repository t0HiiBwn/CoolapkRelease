package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.s;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: DeviceUtils */
public class i {
    public static String a() {
        String str;
        TTCustomController e = com.bytedance.sdk.openadsdk.core.i.d().e();
        if (e == null || !e.isCanUseWifiState() || !e.isCanUseLocation()) {
            str = "DU:MM:YA:DD:RE:SS";
        } else {
            str = a("wlan0");
            if (TextUtils.isEmpty(str)) {
                str = a("eth0");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "DU:MM:YA:DD:RE:SS";
        }
        return str;
    }

    private static String a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(boolean z) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            boolean z2 = inetAddress instanceof Inet4Address;
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (z) {
                                if (z2) {
                                    return upperCase;
                                }
                            } else if (!z2) {
                                int indexOf = upperCase.indexOf(37);
                                return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", k.d(context));
            jSONObject.put("android_id", k.c(context));
            jSONObject.put("uuid", k.e(context));
            jSONObject.put("ssid", k.g(context));
            jSONObject.put("wifi_mac", k.h(context));
            jSONObject.put("imsi", k.f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", ad.a());
            jSONObject.put("sys_compiling_time", k.b(context));
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", x.b(context));
            jSONObject.put("mac", a());
            jSONObject.put("screen_width", ak.c(context));
            jSONObject.put("screen_height", ak.d(context));
            jSONObject.put("oaid", y.a());
            jSONObject.put("free_space", m.a);
            jSONObject.put("applog_did", AppLog.getDid());
            jSONObject.put("sec_did", s.b(k.a(context)).a());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
