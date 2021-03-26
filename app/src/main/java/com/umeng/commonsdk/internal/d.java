package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.umeng.analytics.pro.ao;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.i;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMInternalManager */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i_sdk_v", "1.2.0");
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", "1.2.0");
            if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has("exception")) {
                ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                a.f(context);
                i.d(context);
                ao.c(context);
            }
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            l(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null && UMEnvelopeBuild.getTransmissionSendFlag()) {
            l(context);
        }
    }

    private static void l(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, b.a(context).a(), null);
            }
            UMRTLog.e("MobclickRT", "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, 32787, b.a(context).a(), null, 5000);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static JSONObject d(Context context) {
        JSONArray m;
        JSONArray j;
        JSONArray n;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow("inner_rs") && (n = n(applicationContext)) != null && n.length() > 0) {
                    jSONObject2.put("rs", n);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(applicationContext, e);
            }
            try {
                JSONArray o = o(applicationContext);
                if (o != null && o.length() > 0) {
                    jSONObject2.put("bstn", o);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                JSONArray p = p(applicationContext);
                if (p != null && p.length() > 0) {
                    jSONObject2.put("by", p);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                JSONObject a = a();
                if (a != null && a.length() > 0) {
                    jSONObject2.put("sd", a);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject b = b();
                if (b != null && b.length() > 0) {
                    jSONObject2.put("build", b);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                JSONArray e8 = e(applicationContext);
                if (e8 != null && e8.length() > 0) {
                    try {
                        jSONObject3.put("a_sr", e8);
                    } catch (JSONException unused) {
                    }
                }
                JSONArray c = i.c(applicationContext);
                if (c != null && c.length() > 0) {
                    try {
                        jSONObject3.put("stat", c);
                    } catch (JSONException unused2) {
                    }
                }
                jSONObject2.put("sr", jSONObject3);
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                JSONObject f = f(applicationContext);
                if (f != null && f.length() > 0) {
                    jSONObject2.put("scr", f);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                JSONObject g = g(applicationContext);
                if (g != null && g.length() > 0) {
                    jSONObject2.put("sinfo", g);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                JSONArray e12 = a.e(applicationContext);
                if (e12 != null && e12.length() > 0) {
                    try {
                        jSONObject4.put("wl", e12);
                    } catch (JSONException unused3) {
                    }
                }
                JSONArray h = h(applicationContext);
                if (h != null && h.length() > 0) {
                    try {
                        jSONObject4.put("a_wls", h);
                    } catch (JSONException unused4) {
                    }
                }
                jSONObject2.put("winfo", jSONObject4);
            } catch (Exception e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
            try {
                JSONArray i = i(applicationContext);
                if (i != null && i.length() > 0) {
                    jSONObject2.put("input", i);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(applicationContext, e14);
            }
            try {
                if (FieldManager.allow("inner_appls") && (j = j(applicationContext)) != null && j.length() > 0) {
                    jSONObject2.put("appls", j);
                }
            } catch (Exception e15) {
                UMCrashManager.reportCrash(applicationContext, e15);
            }
            try {
                JSONObject k = k(applicationContext);
                if (k != null && k.length() > 0) {
                    jSONObject2.put("mem", k);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(applicationContext, e16);
            }
            try {
                if (FieldManager.allow("inner_lbs") && (m = m(applicationContext)) != null && m.length() > 0) {
                    jSONObject2.put("lbs", m);
                }
            } catch (Exception e17) {
                UMCrashManager.reportCrash(applicationContext, e17);
            }
            try {
                JSONObject d = d();
                if (d != null && d.length() > 0) {
                    jSONObject2.put("cpu", d);
                }
            } catch (Exception unused5) {
            }
            try {
                JSONObject c2 = c();
                if (c2 != null && c2.length() > 0) {
                    jSONObject2.put("rom", c2);
                }
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("inner", jSONObject2);
            } catch (JSONException e18) {
                UMCrashManager.reportCrash(applicationContext, e18);
            }
        }
        return jSONObject;
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tot_s", a.h());
            jSONObject.put("ava_s", a.i());
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject d() {
        try {
            d.a a = com.umeng.commonsdk.internal.utils.d.a();
            if (a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a.a);
                jSONObject.put("pla", a.b);
                jSONObject.put("cpus", a.c);
                jSONObject.put("fea", a.d);
                jSONObject.put("imp", a.e);
                jSONObject.put("arc", a.f);
                jSONObject.put("var", a.g);
                jSONObject.put("par", a.h);
                jSONObject.put("rev", a.i);
                jSONObject.put("har", a.j);
                jSONObject.put("rev", a.k);
                jSONObject.put("ser", a.f1486l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static JSONArray m(Context context) {
        if (context != null) {
            return ao.b(context.getApplicationContext());
        }
        return null;
    }

    private static JSONArray n(Context context) {
        Throwable th;
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i = 0; i < runningServices.size(); i++) {
                if (!(runningServices.get(i) == null || runningServices.get(i).service == null || runningServices.get(i).service.getClassName() == null || runningServices.get(i).service.getPackageName() == null)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th2) {
                th = th2;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th3) {
            th = th3;
            UMCrashManager.reportCrash(context, th);
            return jSONArray;
        }
    }

    private static JSONArray o(Context context) {
        JSONArray jSONArray = new JSONArray();
        JSONObject a = j.a(context);
        if (a != null) {
            try {
                String b = j.b(context);
                if (!TextUtils.isEmpty(b)) {
                    a.put("sig", b);
                }
                jSONArray.put(a);
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray p(Context context) {
        JSONArray jSONArray = new JSONArray();
        String c = j.c(context);
        if (!TextUtils.isEmpty(c)) {
            try {
                jSONArray.put(new JSONObject(c));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getApplicationContext().getPackageManager()) != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
            a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
            a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
            a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
            a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
        }
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    jSONObject.put(str, 1);
                } catch (Exception unused) {
                }
            } else {
                jSONObject.put(str, 0);
            }
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a = k.a(context);
            if (!TextUtils.isEmpty(a)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(a);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2.has("_gdf_r")) {
                        jSONObject.put("_gdf_r", jSONObject2.opt("_gdf_r"));
                    }
                    if (jSONObject2.has("_thm_z")) {
                        jSONObject.put("_thm_z", jSONObject2.opt("_thm_z"));
                    }
                    if (jSONObject2.has("_dsk_s")) {
                        jSONObject.put("_dsk_s", jSONObject2.opt("_dsk_s"));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("f", a.c());
            jSONObject.put("t", a.d());
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Build.SUPPORTED_32_BIT_ABIS.length; i++) {
                    jSONArray.put(Build.SUPPORTED_32_BIT_ABIS[i]);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < Build.SUPPORTED_64_BIT_ABIS.length; i2++) {
                    jSONArray2.put(Build.SUPPORTED_64_BIT_ABIS[i2]);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i3 = 0; i3 < Build.SUPPORTED_ABIS.length; i3++) {
                    jSONArray3.put(Build.SUPPORTED_ABIS[i3]);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONArray e(Context context) {
        if (context != null) {
            return j.d(context.getApplicationContext());
        }
        return null;
    }

    public static JSONObject f(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", a.h(context));
                jSONObject.put("a_nav_h", a.i(context));
                if (!(context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null)) {
                    jSONObject.put("a_den", (double) displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
            }
        }
        return jSONObject;
    }

    public static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", a.a(applicationContext, packageName));
                jSONObject.put("a_alut", a.b(applicationContext, packageName));
                jSONObject.put("a_c", a.c(applicationContext, packageName));
                jSONObject.put("a_uid", a.d(applicationContext, packageName));
                if (a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", a.b());
                jSONObject.put("s_fs", (double) a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", a.f());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", a.g());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(applicationContext, e);
            }
        }
        return jSONObject;
    }

    public static JSONArray h(Context context) {
        Context applicationContext;
        List<ScanResult> b;
        JSONArray jSONArray = new JSONArray();
        if (!(context == null || (b = a.b((applicationContext = context.getApplicationContext()))) == null || b.size() <= 0)) {
            for (ScanResult scanResult : b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_bssid", scanResult.BSSID);
                    jSONObject.put("a_ssid", scanResult.SSID);
                    jSONObject.put("a_cap", scanResult.capabilities);
                    jSONObject.put("a_fcy", scanResult.frequency);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject.put("a_c0", scanResult.centerFreq0);
                        jSONObject.put("a_c1", scanResult.centerFreq1);
                        jSONObject.put("a_cw", scanResult.channelWidth);
                        if (scanResult.is80211mcResponder()) {
                            jSONObject.put("a_is80211", 1);
                        } else {
                            jSONObject.put("a_is80211", 0);
                        }
                        if (scanResult.isPasspointNetwork()) {
                            jSONObject.put("a_isppn", 1);
                        } else {
                            jSONObject.put("a_isppn", 0);
                        }
                        jSONObject.put("a_ofn", scanResult.operatorFriendlyName);
                        jSONObject.put("a_vn", scanResult.venueName);
                    }
                    jSONObject.put("a_dc", scanResult.describeContents());
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    UMCrashManager.reportCrash(applicationContext, e);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray i(Context context) {
        Context applicationContext;
        List<InputMethodInfo> k;
        JSONArray jSONArray = new JSONArray();
        if (!(context == null || (k = a.k((applicationContext = context.getApplicationContext()))) == null)) {
            for (InputMethodInfo inputMethodInfo : k) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray j(Context context) {
        Context applicationContext;
        List<a.C0148a> l2;
        JSONArray jSONArray = new JSONArray();
        if (!(context == null || (l2 = a.l((applicationContext = context.getApplicationContext()))) == null || l2.isEmpty())) {
            for (a.C0148a aVar : l2) {
                if (aVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", aVar.a);
                        jSONObject.put("a_la", aVar.b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(applicationContext, e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject k(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo m;
        JSONObject jSONObject = new JSONObject();
        if (!(context == null || (m = a.m((applicationContext = context.getApplicationContext()))) == null)) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("t", m.totalMem);
                }
                jSONObject.put("f", m.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e) {
                UMCrashManager.reportCrash(applicationContext, e);
            }
        }
        return jSONObject;
    }
}
