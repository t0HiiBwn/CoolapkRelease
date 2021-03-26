package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.z;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ToolUtils */
public class aj {
    private static String a = "";
    private static String b;
    private static String c;

    public static String a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static String b(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static boolean a(Context context, String str) {
        Intent b2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!c(context)) {
                    Intent b3 = b(context, str);
                    if (b3 == null) {
                        return false;
                    }
                    b3.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b3);
                    return true;
                } else if (!c(context, str) || (b2 = b(context, str)) == null) {
                    return false;
                } else {
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    b.a(context, b2, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static Intent b(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean c(Context context, String str) {
        if (context == null || !c(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null || context == null || !c(context)) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        return i.d() != null && !i.d().a();
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                b.a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 1;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 2;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 3;
                    break;
                }
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 6;
            default:
                return 1;
        }
    }

    public static String a(l lVar) {
        if (lVar == null) {
            return null;
        }
        try {
            return b(c(lVar.aj()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject b(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(l lVar) {
        return lVar != null && c(lVar.aj()) == 9;
    }

    public static boolean c(l lVar) {
        if (lVar == null || lVar.aj() == null) {
            return false;
        }
        if (c(lVar.aj()) == 5 || c(lVar.aj()) == 1 || c(lVar.aj()) == 2) {
            return true;
        }
        return false;
    }

    public static boolean d(l lVar) {
        if (lVar != null) {
            return c(lVar.aj()) == 3 || c(lVar.aj()) == 4;
        }
        return false;
    }

    public static boolean e(l lVar) {
        return lVar != null && c(lVar.aj()) == 7;
    }

    public static boolean f(l lVar) {
        return lVar != null && c(lVar.aj()) == 8;
    }

    public static boolean g(l lVar) {
        return (lVar == null || lVar.ai() == null || TextUtils.isEmpty(lVar.ai().a())) ? false : true;
    }

    public static String h(l lVar) {
        return g(lVar) ? "deeplink_fail" : "installed";
    }

    public static int c(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int d(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("rit", 0);
        }
        return 0;
    }

    public static long e(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optLong("uid", 0);
        }
        return 0;
    }

    public static int f(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ut", 0);
        }
        return 0;
    }

    public static double g(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static String h(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optString("req_id", "");
        }
        return "";
    }

    public static String i(l lVar) {
        if (lVar == null || lVar.ah() == null || TextUtils.isEmpty(lVar.ah().b())) {
            return null;
        }
        return lVar.ah().b();
    }

    public static String b() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a = new SSWebView(p.a()).getSettings().getUserAgentString();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.utils.aj.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String unused = aj.a = new SSWebView(p.a()).getSettings().getUserAgentString();
                        } catch (Exception unused2) {
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String d() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return j.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized String e() {
        String str;
        synchronized (aj.class) {
            str = null;
            if (p.a() != null) {
                try {
                    str = p.a().getPackageName();
                } catch (Throwable th) {
                    u.c("ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
        }
        return str;
    }

    public static synchronized String f() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(b) && p.a() != null) {
                try {
                    PackageInfo packageInfo = p.a().getPackageManager().getPackageInfo(e(), 0);
                    b = String.valueOf(packageInfo.versionCode);
                    c = packageInfo.versionName;
                } catch (Throwable th) {
                    u.c("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = b;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(c) && p.a() != null) {
                try {
                    PackageInfo packageInfo = p.a().getPackageManager().getPackageInfo(e(), 0);
                    b = String.valueOf(packageInfo.versionCode);
                    c = packageInfo.versionName;
                } catch (Throwable th) {
                    u.c("ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = c;
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = d.a(context).b("total_memory", (String) null);
        if (b2 != null) {
            return b2;
        }
        String e = e(context, "MemTotal");
        d.a(context).a("total_memory", e);
        return e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[SYNTHETIC, Splitter:B:38:0x0060] */
    public static String e(Context context, String str) {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String[] split = readLine.split("\\s+");
                u.b("ToolUtils", "getTotalMemory = " + split[1]);
                String str2 = split[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                th.printStackTrace();
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> a(long j, l lVar, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (lVar != null) {
            if (!TextUtils.isEmpty(lVar.ag())) {
                hashMap.put("creative_id", lVar.ag());
            }
            t R = lVar.R();
            if (R != null) {
                hashMap.put("video_resolution", R.f());
                hashMap.put("video_size", Long.valueOf(R.d()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(boolean z, l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("load_time", Long.valueOf(j));
        t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put("video_resolution", R.f());
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> b(boolean z, l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("load_time", Long.valueOf(j));
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> a(l lVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put("video_resolution", R.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(l lVar, long j, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("buffers_time", Long.valueOf(j));
        t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put("video_resolution", R.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        if (!map.containsKey("video_resolution") && dVar != null) {
            try {
                if (dVar.a() != null) {
                    map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] i(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(str.getBytes());
            try {
                gZIPOutputStream.close();
            } catch (Exception e) {
                u.b(e.toString());
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            u.b(e2.toString());
            try {
                gZIPOutputStream.close();
            } catch (Exception e3) {
                u.b(e3.toString());
            }
            return null;
        } catch (Throwable th) {
            try {
                gZIPOutputStream.close();
            } catch (Exception e4) {
                u.b(e4.toString());
            }
            throw th;
        }
    }

    public static boolean j(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            u.f("ToolUtils", e.toString());
            return "";
        }
    }

    public static int a(c cVar, boolean z) {
        if (cVar == null || cVar.u() == null || !cVar.u().g()) {
            return 3;
        }
        return !z ? 1 : 0;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            String a2 = a.a();
            String str = 2 + a2 + a.a(jSONObject.toString(), a.a(a2));
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("message", str);
                jSONObject2.put("cypher", 2);
            } else {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return a.b(str.substring(17), o(str.substring(1, 17)));
    }

    private static String o(String str) {
        String a2 = a.a(str);
        if (str != null) {
            return a2;
        }
        String a3 = b.a();
        return a3.concat(a3).substring(8, 24);
    }

    public static boolean a(l lVar, String str) {
        if (lVar != null) {
            try {
                String W = lVar.W();
                if (TextUtils.isEmpty(W) && lVar.ai() != null && lVar.ai().c() == 1 && !TextUtils.isEmpty(lVar.ai().b())) {
                    W = lVar.ai().b();
                }
                if (!TextUtils.isEmpty(W)) {
                    z.a(p.a(), W, lVar, a(str), str, false, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean j(l lVar) {
        if (lVar == null) {
            return true;
        }
        int c2 = p.h().c(d(lVar.aj()));
        if (c2 == 1) {
            return x.d(p.a());
        }
        if (c2 != 2) {
            if (c2 != 3) {
                return true;
            }
            return false;
        } else if (x.e(p.a()) || x.d(p.a())) {
            return true;
        } else {
            return false;
        }
    }

    public static String l(String str) {
        String format = String.format("https://%s%s", p.h().b(), str);
        if (!ai.a()) {
            return format;
        }
        String b2 = ai.b(format);
        String a2 = ai.a("testIp.txt");
        return a2 != null ? ai.a(b2, a2) : b2;
    }

    public static String h() {
        return ai.b(String.format("https://%s", p.h().c()));
    }

    public static String i() {
        return ai.b(String.format("https://%s", "log.snssdk.com/service/2/app_log_test/"));
    }

    public static int j() {
        try {
            return (int) ((((double) Runtime.getRuntime().maxMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int k() {
        try {
            return (int) ((((double) Runtime.getRuntime().freeMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int l() {
        try {
            return (int) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        if (str.contains("kllk")) {
            return str.replace("kllk", "oppo");
        }
        return "";
    }

    public static boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }

    public static long a(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static String a(l lVar, View view) {
        if (lVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", d(lVar.aj()));
            jSONObject.put("app_id", i.d().f());
            jSONObject.put("creative_id", lVar.ag());
            jSONObject.put("ad_sdk_version", 3412);
            jSONObject.put("ad_slot_type", c(lVar.aj()));
            if (view != null) {
                jSONObject.put("ad_width", view.getWidth());
                jSONObject.put("ad_height", view.getHeight());
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                jSONObject.put("ad_x", iArr[0]);
                jSONObject.put("ad_y", iArr[1]);
            }
            jSONObject.put("screen_width", ak.c(p.a()));
            jSONObject.put("screen_height", ak.d(p.a()));
        } catch (Exception unused) {
        }
        String a2 = a.a(jSONObject.toString(), b.a());
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }

    public static boolean c(Context context) {
        if (context != null) {
            boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
            StringBuilder sb = new StringBuilder();
            sb.append("can query all package = ");
            sb.append(!z);
            u.c("ToolUtils", sb.toString());
            return !z;
        }
        throw new IllegalArgumentException("params context is null");
    }
}
