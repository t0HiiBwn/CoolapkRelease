package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.open.a.f;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class j {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = null;
    private static String g = "0123456789ABCDEF";

    private static char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e2) {
                        f.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a2 = a(url.getQuery());
            a2.putAll(a(url.getRef()));
            return a2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a2 = a((JSONObject) null, url.getQuery());
            a(a2, url.getRef());
            return a2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    /* compiled from: ProGuard */
    public static class a {
        public String a;
        public long b;
        public long c;

        public a(String str, int i) {
            this.a = str;
            this.b = (long) i;
            if (str != null) {
                this.c = (long) str.length();
            }
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            f.a("openSDK_LOG.Util", "getUserIp SocketException ", e2);
            return "";
        }
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean f(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (h.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(signatureArr[0].toByteArray());
                    String a2 = a(instance.digest());
                    instance.reset();
                    if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    f.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[SYNTHETIC, Splitter:B:14:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002f A[SYNTHETIC, Splitter:B:24:0x002f] */
    public static boolean a(Context context, String str) {
        boolean z;
        try {
            z = f(context);
            if (z) {
                try {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                    return true;
                } catch (Exception unused) {
                    if (!z) {
                    }
                }
            } else {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                return true;
            }
        } catch (Exception unused2) {
            z = false;
            if (!z) {
                try {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception unused3) {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused4) {
                        try {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        } catch (Exception unused5) {
                            return false;
                        }
                    }
                }
            } else {
                try {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception unused6) {
                    try {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    } catch (Exception unused7) {
                        return false;
                    }
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static String f(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(i(str));
            byte[] digest = instance.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(a(b2 >>> 4));
                sb.append(a(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            f.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean b() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String num = Integer.toString(b2 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final boolean g(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static boolean h(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static final String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e2) {
            f.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.b.a.a(e.a()));
        bundle.putString("apn", com.tencent.open.b.a.b(e.a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", "3.3.0.lite");
        bundle.putString("packagename", e.b());
        bundle.putString("app_ver", d(e.a(), e.b()));
        return bundle;
    }

    public static String c(Context context) {
        Location lastKnownLocation;
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = locationManager.getLastKnownLocation(bestProvider)) == null) {
                return "";
            }
            String str = lastKnownLocation.getLatitude() + "*" + lastKnownLocation.getLongitude();
            f = str;
            return str;
        } catch (Exception e2) {
            f.b("openSDK_LOG.Util", "getLocation>>>", e2);
        }
        return "";
    }

    public static void b(Context context, String str) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                String str2 = packageInfo.versionName;
                b = str2;
                a = str2.substring(0, str2.lastIndexOf(46));
                String str3 = b;
                d = str3.substring(str3.lastIndexOf(46) + 1, b.length());
                e = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
            } catch (Exception e3) {
                f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
            }
        }
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d2 = d(context, str);
        c = d2;
        return d2;
    }

    public static byte[] i(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static boolean d(Context context) {
        double d2;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d));
        } catch (Throwable unused) {
            d2 = 0.0d;
        }
        return d2 > 6.5d;
    }

    public static boolean f(Context context, String str) {
        boolean z = true;
        boolean z2 = !d(context) || h.a(context, "com.tencent.minihd.qq") == null;
        if (z2 && h.a(context, "com.tencent.tim") != null) {
            z2 = false;
        }
        if (!z2) {
            return z2;
        }
        if (h.c(context, str) >= 0) {
            z = false;
        }
        return z;
    }

    public static boolean g(Context context, String str) {
        boolean z = true;
        boolean z2 = !d(context) || h.a(context, "com.tencent.minihd.qq") == null;
        if (z2 && h.a(context, "com.tencent.tim") != null) {
            z2 = false;
        }
        if (!z2) {
            return z2;
        }
        if (h.c(context, str) >= 0) {
            z = false;
        }
        return z;
    }

    public static boolean a(Context context, boolean z) {
        if (d(context) && h.a(context, "com.tencent.minihd.qq") != null) {
            return true;
        }
        if (!z) {
            if (h.c(context, "4.1") >= 0 || h.a(context, "com.tencent.tim") != null) {
                return true;
            }
            return false;
        } else if (h.c(context, "4.1") >= 0 || h.a(context, "com.tencent.tim") != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean e(Context context) {
        return h.c(context, "5.9.5") >= 0 || h.a(context, "com.tencent.tim") != null;
    }
}
