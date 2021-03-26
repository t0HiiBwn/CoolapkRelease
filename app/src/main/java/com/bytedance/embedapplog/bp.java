package com.bytedance.embedapplog;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bp {
    private static String a = null;
    private static String b = ":push";

    public static String a(boolean z) {
        return z ? "yes" : "no";
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return a((Object) jSONObject, (Object) jSONObject2);
        }
        return jSONObject.toString().equals(jSONObject2.toString());
    }

    public static String a(Context context) {
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.pid == myPid) {
                    a = next.processName;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        a = a();
        if (bo.b) {
            bo.a("getProcessName, " + a, null);
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            return null;
        }
    }

    public static boolean b(Context context) {
        String a2 = a(context);
        return a2 != null && a2.endsWith(b);
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            bo.a(e);
        }
        return jSONObject;
    }

    public static String a(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String a2 = a(str3, str2);
            String str4 = hashMap.get(str3);
            String a3 = str4 != null ? a(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(a2);
            sb.append("=");
            sb.append(a3);
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }
}
