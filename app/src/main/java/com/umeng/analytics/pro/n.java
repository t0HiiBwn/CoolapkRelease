package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CoreProtocolImpl */
public class n {
    private static Context a = null;

    /* renamed from: l  reason: collision with root package name */
    private static final String f1473l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private static Class<?> y;
    private static Method z;
    private c b;
    private SharedPreferences c;
    private String d;
    private String e;
    private int f;
    private JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* compiled from: CoreProtocolImpl */
    public static class a {
        public static final int A = 8211;
        public static final int B = 8212;
        public static final int C = 8213;
        public static final int a = 4097;
        public static final int b = 4098;
        public static final int c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;

        /* renamed from: l  reason: collision with root package name */
        public static final int f1474l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 8193;
        public static final int q = 8194;
        public static final int r = 8195;
        public static final int s = 8196;
        public static final int t = 8197;
        public static final int u = 8199;
        public static final int v = 8200;
        public static final int w = 8201;
        public static final int x = 8208;
        public static final int y = 8209;
        public static final int z = 8210;
    }

    public void b() {
    }

    static {
        h();
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrashUtils");
            if (cls != null) {
                y = cls;
                Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    z = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private n() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 10;
        this.g = new JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.s = 28800000;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            this.k = sharedPreferences.getLong("thtstart", 0);
            this.i = sharedPreferences.getInt("gkvc", 0);
            this.j = sharedPreferences.getInt("ekvc", 0);
            this.b = new c();
        } catch (Throwable unused) {
        }
    }

    /* compiled from: CoreProtocolImpl */
    private static class b {
        private static final n a = new n();

        private b() {
        }
    }

    public static n a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return b.a;
    }

    public void a() {
        if (a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i("MobclickRT", "--->>> network is now available, rebuild instant session data packet.");
                    Context context = a;
                    UMWorkDispatch.sendEvent(context, 4353, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    Context context2 = a;
                    UMWorkDispatch.sendEvent(context2, 4354, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    public void c() {
        b(a);
        d();
        a(true);
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = y;
        if (cls != null && (method = z) != null) {
            try {
                method.invoke(cls, str, str2);
            } catch (Throwable unused) {
                UMRTLog.e("MobclickRT", "--->>> reflect call setPuidAndProvider method of crash lib failed.");
            }
        }
    }

    public void a(Object obj, int i2) {
        if (AnalyticsConfig.enable) {
            if (i2 != 8213) {
                switch (i2) {
                    case 4097:
                        if (UMUtils.isMainProgress(a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if (!"-1".equals(((JSONObject) obj).optString("__i"))) {
                                a(false);
                                return;
                            }
                            return;
                        }
                        UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if (!"-1".equals(((JSONObject) obj).optString("__i"))) {
                            a(false);
                            return;
                        }
                        return;
                    case 4099:
                        u.a(a);
                        return;
                    case 4100:
                        k.c(a);
                        return;
                    case 4101:
                        UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case 4102:
                        UMRTLog.i("MobclickRT", "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case 4103:
                        UMRTLog.i("MobclickRT", "--->>> START_SESSION");
                        t.a().a(a, obj);
                        synchronized (this.w) {
                            this.v = true;
                        }
                        return;
                    case 4104:
                        t.a().c(a, obj);
                        return;
                    case 4105:
                        d();
                        return;
                    case 4106:
                        h(obj);
                        return;
                    default:
                        switch (i2) {
                            case 4352:
                                UMRTLog.i("MobclickRT", "--->>> INSTANT_SESSION_START");
                                t.a().b(a, obj);
                                synchronized (this.w) {
                                    this.u = true;
                                }
                                return;
                            case 4353:
                                a(obj, true);
                                return;
                            case 4354:
                                c();
                                return;
                            case 4355:
                                if (!UMUtils.isMainProgress(a)) {
                                    UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                                    return;
                                } else if (obj != null) {
                                    e(obj);
                                    d();
                                    return;
                                } else {
                                    return;
                                }
                            case 4356:
                                if (obj != null && y != null && z != null) {
                                    UMRTLog.i("MobclickRT", "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has("provider")) {
                                            str = jSONObject.getString("provider");
                                            str2 = jSONObject.getString("uid");
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case 8195:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case 8196:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case 8197:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i2) {
                                            case 8199:
                                            case 8200:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case 8201:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case 8208:
                                                        UMRTLog.i("MobclickRT", "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = a;
                                                        UMWorkDispatch.sendEvent(context, 8209, CoreProtocol.getInstance(context), null);
                                                        Context context2 = a;
                                                        UMWorkDispatch.sendEvent(context2, 4354, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case 8209:
                                                        a(obj, false);
                                                        return;
                                                    case 8210:
                                                        UMRTLog.i("MobclickRT", "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        try {
                                                            if (UMUtils.isMainProgress(a) && !(this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                a(true);
                                                                return;
                                                            }
                                                            return;
                                                        } catch (Throwable unused) {
                                                            return;
                                                        }
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                }
            } else if (FieldManager.allow("header_foreground_count")) {
                if (DeviceConfig.getGlobleActivity(a) != null) {
                    t.b(a);
                }
                Context context3 = a;
                UMWorkDispatch.sendEventEx(context3, 8213, CoreProtocol.getInstance(context3), null, 5000);
            }
        }
    }

    public void a(boolean z2) {
        if (!c(z2)) {
            return;
        }
        if (this.b.c() instanceof ReportPolicy.ReportQuasiRealtime) {
            if (z2) {
                if (UMEnvelopeBuild.isOnline(a)) {
                    UMRTLog.i("MobclickRT", "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                }
            } else if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i("MobclickRT", "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        } else if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
            UMRTLog.i("MobclickRT", "--->>> constructMessage()");
            j();
        }
    }

    private void i() {
        JSONObject b2 = b(UMEnvelopeBuild.maxDataSpace(a));
        if (b2 != null && b2.length() >= 1) {
            JSONObject jSONObject = (JSONObject) b2.opt("header");
            JSONObject jSONObject2 = (JSONObject) b2.opt("content");
            if (a != null && jSONObject != null && jSONObject2 != null) {
                UMRTLog.i("MobclickRT", "--->>> constructInstantMessage: request build envelope.");
                JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2);
                if (buildEnvelopeWithExtHeader != null) {
                    try {
                        if (buildEnvelopeWithExtHeader.has("exception")) {
                            UMRTLog.i("MobclickRT", "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                        }
                    } catch (Throwable unused) {
                    }
                    if (UMConfigure.isDebugLog()) {
                        e(buildEnvelopeWithExtHeader);
                    }
                    b((Object) buildEnvelopeWithExtHeader);
                }
            }
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a2 = a(UMEnvelopeBuild.maxDataSpace(a));
        if (a2 != null && a2.length() >= 1) {
            JSONObject jSONObject = (JSONObject) a2.opt("header");
            JSONObject jSONObject2 = (JSONObject) a2.opt("content");
            Context context = a;
            if (context != null && jSONObject != null && jSONObject2 != null && (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) != null) {
                try {
                    if (buildEnvelopeWithExtHeader.has("exception")) {
                        UMRTLog.i("MobclickRT", "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                    }
                } catch (Throwable unused) {
                }
                if (UMConfigure.isDebugLog()) {
                    d(buildEnvelopeWithExtHeader);
                }
                a((Object) buildEnvelopeWithExtHeader);
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i2++;
                }
            } catch (Throwable unused) {
            }
        }
        if (i2 >= length) {
            return true;
        }
        return false;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        if (optJSONArray != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                        if (optJSONArray2 != null && a(optJSONArray2)) {
                            i2++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (i2 >= length) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a(long j2) {
        if (TextUtils.isEmpty(x.a().d(a))) {
            return null;
        }
        JSONObject b2 = b(false);
        int a2 = q.a().a(a);
        if (b2.length() > 0) {
            if (b2.length() == 1) {
                if (b2.optJSONObject("active_user") != null && a2 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                    return null;
                }
            } else if (b2.length() == 2 && b2.optJSONObject("active_user") != null && !TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
            String optString = b2.optString("sessions");
            String optString2 = b2.optString("gkv");
            String optString3 = b2.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b2)) {
                return null;
            }
        } else if (a2 != 3) {
            return null;
        }
        JSONObject l2 = l();
        if (l2 != null) {
            c(l2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (l2 != null && l2.length() > 0) {
                jSONObject.put("header", l2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f2;
        if (!h.a(UMGlobalContext.getAppContext(a)).c() && (f2 = h.a(UMGlobalContext.getAppContext(a)).f()) != null) {
            String optString = f2.optString("__av");
            String optString2 = f2.optString("__vc");
            try {
                if (TextUtils.isEmpty(optString)) {
                    jSONObject.put("app_version", UMUtils.getAppVersionName(a));
                } else {
                    jSONObject.put("app_version", optString);
                }
                if (TextUtils.isEmpty(optString2)) {
                    jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
                } else {
                    jSONObject.put("version_code", optString2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject b(long j2) {
        if (TextUtils.isEmpty(x.a().d(UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        JSONObject b2 = h.a(UMGlobalContext.getAppContext(a)).b(false);
        String[] a2 = com.umeng.analytics.c.a(a);
        if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", a2[0]);
                jSONObject.put("puid", a2[1]);
                if (jSONObject.length() > 0) {
                    b2.put("active_user", jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a3 = q.a().a(a);
        if (b2.length() == 1 && b2.optJSONObject("active_user") != null && a3 != 3) {
            return null;
        }
        q.a().b(b2, a);
        if (b2.length() <= 0 && a3 != 3) {
            return null;
        }
        JSONObject k2 = k();
        if (k2 != null) {
            b(k2);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (a3 == 3) {
            try {
                jSONObject3.put("analytics", new JSONObject());
            } catch (Throwable unused2) {
                return jSONObject2;
            }
        } else if (b2 != null && b2.length() > 0) {
            jSONObject3.put("analytics", b2);
        }
        if (k2 != null && k2.length() > 0) {
            jSONObject2.put("header", k2);
        }
        if (jSONObject3.length() > 0) {
            jSONObject2.put("content", jSONObject3);
        }
        return b(jSONObject2, j2);
    }

    private JSONObject a(JSONObject jSONObject, long j2) {
        try {
            if (p.a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put("eof", p.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return p.a(a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject b(JSONObject jSONObject, long j2) {
        try {
            if (p.a(jSONObject) <= j2) {
                return jSONObject;
            }
            h.a(a).a(true, false);
            h.a(a).b();
            UMRTLog.i("MobclickRT", "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject k() {
        JSONObject l2 = l();
        if (l2 != null) {
            try {
                l2.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l2;
    }

    private void c(JSONObject jSONObject) {
        if (!h.a(a).e()) {
            JSONObject g2 = h.a(a).g();
            if (g2 != null) {
                String optString = g2.optString("__av");
                String optString2 = g2.optString("__vc");
                try {
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put("app_version", UMUtils.getAppVersionName(a));
                    } else {
                        jSONObject.put("app_version", optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
                    } else {
                        jSONObject.put("version_code", optString2);
                    }
                } catch (Throwable unused) {
                }
            }
        } else {
            jSONObject.put("app_version", UMUtils.getAppVersionName(a));
            jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
        }
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(AnalyticsConfig.mWrapperType == null || AnalyticsConfig.mWrapperVersion == null)) {
                jSONObject.put("wrapper_version", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(a);
            jSONObject.put("vertical_type", verticalType);
            String str = "9.3.3";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put("sdk_version", str);
            } else {
                jSONObject.put("sdk_version", str);
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(a, "ekv_bl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put("$ekv_bl_ver", "");
                } else {
                    jSONObject.put("$ekv_bl_ver", imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(a, "ekv_wl_ver", "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put("$ekv_wl_ver", "");
                } else {
                    jSONObject.put("$ekv_wl_ver", imprintProperty3);
                }
            }
            jSONObject.put("pro_ver", "1.0.0");
            if (s()) {
                jSONObject.put("atm", "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("ana_is_f", 0).commit();
                }
            }
            jSONObject.put("$pr_ve", m());
            jSONObject.put("$ud_da", n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put("$pr_ve", sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put("$ud_da", sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject b(boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = h.a(a).a(z2);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    if (jSONObject.has("sessions")) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("sessions");
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i2);
                            JSONArray optJSONArray = jSONObject2.optJSONArray("pages");
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("autopages");
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put("pages", optJSONArray2);
                                jSONObject2.remove("autopages");
                            }
                            if (!(optJSONArray == null || optJSONArray2 == null)) {
                                ArrayList<JSONObject> arrayList = new ArrayList();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i3));
                                }
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i4));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey("page_start");
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                for (JSONObject jSONObject3 : arrayList) {
                                    jSONArray5.put(jSONObject3);
                                }
                                jSONObject2.put("pages", jSONArray5);
                                jSONObject2.remove("autopages");
                            }
                            if (jSONObject2.has("pages")) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray("pages");
                                int i5 = 0;
                                while (i5 < optJSONArray3.length()) {
                                    JSONObject jSONObject4 = optJSONArray3.getJSONObject(i5);
                                    if (jSONObject4.has("page_start")) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject4.put("ts", jSONObject4.getLong("page_start"));
                                        jSONObject4.remove("page_start");
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put("pages", optJSONArray3);
                                jSONObject2.put("$page_num", optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put("$page_num", 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put("sessions", jSONArray4);
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a2 = com.umeng.analytics.c.a(a);
            if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("provider", a2[0]);
                jSONObject5.put("puid", a2[1]);
                if (jSONObject5.length() > 0) {
                    jSONObject.put("active_user", jSONObject5);
                }
            }
            if (ABTest.getService(a).isInTest()) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(ABTest.getService(a).getTestName(), ABTest.getService(a).getGroupInfo());
                jSONObject.put("group_info", jSONObject6);
            }
            q.a().a(jSONObject, a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private String m() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.d)) {
                    return this.d;
                }
                if (this.c == null) {
                    this.c = PreferenceWrapper.getDefault(a);
                }
                String string = this.c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(a);
                if (TextUtils.isEmpty(string)) {
                    this.c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    str = "0";
                } else {
                    String string2 = this.c.getString("cur_version", "");
                    if (!appVersionName.equals(string2)) {
                        this.c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        str = string2;
                    } else {
                        str = string;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.e)) {
                    return this.e;
                }
                if (this.c == null) {
                    this.c = PreferenceWrapper.getDefault(a);
                }
                String string = this.c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.e = str;
        return str;
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                UMRTLog.i("MobclickRT", "--->>>*** flushMemoryData: 事件落库。");
                h.a(a).a(this.g);
                this.g = new JSONArray();
            }
            PreferenceWrapper.getDefault(a).edit().putLong("thtstart", this.k).putInt("gkvc", this.i).putInt("ekvc", this.j).commit();
        } catch (Throwable unused) {
        }
    }

    /* compiled from: CoreProtocolImpl */
    public static class d {
        private Map<String, Object> a = null;
        private String b = null;
        private String c = null;
        private long d = 0;

        private d() {
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.a = map;
            this.b = str;
            this.d = j;
            this.c = str2;
        }

        public Map<String, Object> a() {
            return this.a;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (a(this.k, this.i)) {
                    this.i++;
                } else {
                    return;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (a(this.k, this.j)) {
                    this.j++;
                } else {
                    return;
                }
            }
            if (this.g.length() >= this.f) {
                UMRTLog.i("MobclickRT", "--->>>*** 超过10个事件，事件落库。");
                h.a(a).a(this.g);
                this.g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private boolean a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 > 28800000) {
            o();
            return true;
        } else if (i2 < 5000) {
            return true;
        } else {
            return false;
        }
    }

    private void o() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(a).edit().putLong("dstk_last_time", System.currentTimeMillis()).putInt("dstk_cnt", 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean c(boolean z2) {
        if (s()) {
            return true;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a();
        ReportPolicy.ReportStrategy c2 = this.b.c();
        boolean shouldSendMessage = c2.shouldSendMessage(z2);
        if (shouldSendMessage) {
            if (((c2 instanceof ReportPolicy.ReportByInterval) || (c2 instanceof ReportPolicy.DebugPolicy) || (c2 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c2 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c2.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(t.a().b())) {
                b(a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.g.length(); i2++) {
                JSONObject optJSONObject = this.g.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* compiled from: CoreProtocolImpl */
    public static class c {
        private ReportPolicy.ReportStrategy a;
        private int b;
        private int c;
        private int d;
        private int e;
        private ABTest f;

        public c() {
            this.a = null;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = null;
            this.f = ABTest.getService(n.a);
        }

        public void a() {
            try {
                int[] a2 = a(-1, -1);
                this.b = a2[0];
                this.c = a2[1];
            } catch (Throwable unused) {
            }
        }

        public int[] a(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "report_policy", "-1")).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "report_interval", "-1")).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            } else if (11 != intValue) {
                return new int[]{i, i2};
            } else {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
        }

        public int a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        protected void b() {
            int i;
            Defcon service = Defcon.getService(n.a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                this.a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(n.a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(i.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(n.a));
                } else if (!this.f.isInTest() || !"RPT".equals(this.f.getTestName())) {
                    int i2 = this.d;
                    int i3 = this.e;
                    int i4 = this.b;
                    if (i4 != -1) {
                        i3 = this.c;
                        i2 = i4;
                    }
                    this.a = b(i2, i3);
                } else {
                    if (this.f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "test_report_interval", "-1")).intValue() != -1) {
                            i = a(90000);
                        } else {
                            i = this.c;
                            if (i <= 0) {
                                i = this.e;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    this.a = b(this.f.getTestPolicy(), i);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(i.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(i.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(i.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(i.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            } else if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            } else if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.a;
                if (reportStrategy3 instanceof ReportPolicy.ReportDaily) {
                    return reportStrategy3;
                }
                return new ReportPolicy.ReportDaily(StatTracer.getInstance(n.a));
            } else if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.a;
                if (reportStrategy4 instanceof ReportPolicy.ReportWifiOnly) {
                    return reportStrategy4;
                }
                return new ReportPolicy.ReportWifiOnly(n.a);
            } else if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.a;
                if (!(reportStrategy5 instanceof ReportPolicy.ReportByInterval)) {
                    return new ReportPolicy.ReportByInterval(StatTracer.getInstance(n.a), (long) i2);
                }
                ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval((long) i2);
                return reportStrategy5;
            } else if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.a;
                if (reportStrategy6 instanceof ReportPolicy.SmartPolicy) {
                    return reportStrategy6;
                }
                return new ReportPolicy.SmartPolicy(StatTracer.getInstance(n.a));
            } else if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.a;
                if (reportStrategy7 instanceof ReportPolicy.ReportAtLaunch) {
                    return reportStrategy7;
                }
                return new ReportPolicy.ReportAtLaunch();
            } else {
                ReportPolicy.ReportStrategy reportStrategy8 = this.a;
                if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                    ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval((long) i2);
                    return reportStrategy8;
                }
                ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
                reportQuasiRealtime.setReportInterval((long) i2);
                return reportQuasiRealtime;
            }
        }
    }

    private void d(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.has("analytics")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                        if (jSONObject4.has("ekv")) {
                            str = "version_code";
                            jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                            if (jSONObject3.length() > 0) {
                                MLog.d("事件:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        } else {
                            str = "version_code";
                        }
                        if (jSONObject4.has("gkv")) {
                            jSONObject3.put("gkv", jSONObject4.getJSONArray("gkv"));
                            if (jSONObject3.length() > 0) {
                                MLog.d("游戏事件:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                        if (jSONObject4.has("error")) {
                            jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                            if (jSONObject3.length() > 0) {
                                MLog.d("错误:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                        if (jSONObject4.has("sessions")) {
                            JSONArray jSONArray = jSONObject4.getJSONArray("sessions");
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                                if (jSONObject5 != null && jSONObject5.length() > 0) {
                                    if (jSONObject5.has("autopages")) {
                                        jSONObject5.remove("autopages");
                                    }
                                    jSONArray2.put(jSONObject5);
                                }
                            }
                            jSONObject3.put("sessions", jSONArray2);
                            if (jSONObject3.length() > 0) {
                                MLog.d("会话:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                        if (jSONObject4.has("activate_msg")) {
                            jSONObject3.put("activate_msg", jSONObject4.getJSONObject("activate_msg"));
                        }
                        if (jSONObject4.has("active_user")) {
                            jSONObject3.put("active_user", jSONObject4.getJSONObject("active_user"));
                            if (jSONObject3.length() > 0) {
                                MLog.d("账号:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                    } else {
                        str = "version_code";
                    }
                    if (jSONObject.has("dplus")) {
                        jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
                    }
                    if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                        if (jSONObject2.has("sdk_version")) {
                            jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                        }
                        if (jSONObject2.has("device_id")) {
                            jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                        }
                        if (jSONObject2.has("device_model")) {
                            jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                        }
                        if (jSONObject2.has(str)) {
                            jSONObject3.put("version", jSONObject2.getInt(str));
                        }
                        if (jSONObject2.has("appkey")) {
                            jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                        }
                        if (jSONObject2.has("channel")) {
                            jSONObject3.put("channel", jSONObject2.getString("channel"));
                        }
                        if (jSONObject3.length() > 0) {
                            MLog.d("基础信息:" + jSONObject3.toString());
                            jSONObject3 = new JSONObject();
                        }
                    }
                    jSONObject3.length();
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.has("analytics")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                        if (jSONObject4.has("sessions")) {
                            JSONArray jSONArray = jSONObject4.getJSONArray("sessions");
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                                if (jSONObject5 != null && jSONObject5.length() > 0) {
                                    jSONArray2.put(jSONObject5);
                                }
                            }
                            jSONObject3.put("sessions", jSONArray2);
                            if (jSONObject3.length() > 0) {
                                MLog.d("本次启动会话:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                        if (jSONObject4.has("active_user")) {
                            jSONObject3.put("active_user", jSONObject4.getJSONObject("active_user"));
                            if (jSONObject3.length() > 0) {
                                MLog.d("本次启动账号:" + jSONObject3.toString());
                                jSONObject3 = new JSONObject();
                            }
                        }
                    }
                    if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                        if (jSONObject2.has("sdk_version")) {
                            jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                        }
                        if (jSONObject2.has("device_id")) {
                            jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                        }
                        if (jSONObject2.has("device_model")) {
                            jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                        }
                        if (jSONObject2.has("version_code")) {
                            jSONObject3.put("version", jSONObject2.getInt("version_code"));
                        }
                        if (jSONObject2.has("appkey")) {
                            jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                        }
                        if (jSONObject2.has("channel")) {
                            jSONObject3.put("channel", jSONObject2.getString("channel"));
                        }
                        if (jSONObject3.length() > 0) {
                            MLog.d("本次启动基础信息:" + jSONObject3.toString());
                            jSONObject3 = new JSONObject();
                        }
                    }
                    jSONObject3.length();
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has("exception")) {
                    g(jSONObject);
                } else if (101 != jSONObject.getInt("exception")) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has("exception")) {
                    f(jSONObject);
                } else if (101 != jSONObject.getInt("exception")) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (jSONObject.getJSONObject("header").has("eof")) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                    if (jSONObject2.has("sessions") && (optJSONObject2 = jSONObject2.getJSONArray("sessions").optJSONObject(0)) != null) {
                        String optString = optJSONObject2.optString("id");
                        if (!TextUtils.isEmpty(optString)) {
                            UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: really delete instant session data");
                            h.a(a).b(optString);
                        }
                    }
                }
                h.a(a).b();
                UMRTLog.i("MobclickRT", "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
                Context context = a;
                UMWorkDispatch.sendEvent(context, 4353, CoreProtocol.getInstance(context), null);
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0 && optJSONObject.has("sessions")) {
                h.a(a).a(true, false);
            }
            h.a(a).b();
        } catch (Exception unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has("eof")) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (!jSONObject.has("analytics")) {
                    return;
                }
                if (jSONObject.getJSONObject("analytics").has("sessions")) {
                    h.a(a).i();
                    h.a(a).h();
                    h.a(a).b(true, false);
                    h.a(a).a();
                    return;
                }
                UMRTLog.i("MobclickRT", "--->>> Error, Should not go to this branch.");
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has("sessions")) {
                    h.a(a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has("gkv")) {
                    h.a(a).h();
                }
                if (optJSONObject.has("error")) {
                    h.a(a).i();
                }
            }
            h.a(a).a();
        } catch (Exception unused) {
        }
    }

    public void c(Object obj) {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    public void b(Context context) {
        try {
            h.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new c();
        }
        ReportPolicy.ReportStrategy c2 = this.b.c();
        if (!(c2 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z2) {
            return ((ReportPolicy.DefconPolicy) c2).shouldSendMessageByInstant();
        }
        return c2.shouldSendMessage(false);
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }

    private void q() {
        if (this.g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.g.length(); i2++) {
                try {
                    JSONObject jSONObject = this.g.getJSONObject(i2);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        String str = "-1";
                        if (TextUtils.isEmpty(optString) || str.equals(optString)) {
                            String b2 = t.a().b();
                            if (!TextUtils.isEmpty(b2)) {
                                str = b2;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (s() && (context = a) != null && (sharedPreferences = PreferenceWrapper.getDefault(context)) != null && sharedPreferences.getLong("first_activate_time", 0) == 0) {
                sharedPreferences.edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        try {
            Context context = a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0;
            }
            long j2 = sharedPreferences.getLong("first_activate_time", 0);
            if (j2 == 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong("first_activate_time", currentTimeMillis).commit();
                    return currentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j2;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = a;
            return (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong("ana_is_f", -1) == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.length() > 0) {
                long j2 = jSONObject.getLong("ts");
                b(a);
                d();
                String[] a2 = com.umeng.analytics.c.a(a);
                if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                    t.a().a(a, j2);
                    String c2 = x.a().c(a);
                    UMRTLog.i("MobclickRT", "--->>> onProfileSignIn: force generate new session: session id = " + c2);
                    boolean b2 = t.a().b(a, j2, false);
                    com.umeng.analytics.c.b(a);
                    t.a().a(a, j2, true);
                    if (b2) {
                        t.a().b(a, j2);
                    }
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private void g(Object obj) {
        try {
            b(a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.length() > 0) {
                String string = jSONObject.getString("provider");
                String string2 = jSONObject.getString("uid");
                long j2 = jSONObject.getLong("ts");
                String[] a2 = com.umeng.analytics.c.a(a);
                if (a2 == null || !string.equals(a2[0]) || !string2.equals(a2[1])) {
                    t.a().a(a, j2);
                    String c2 = x.a().c(a);
                    boolean b2 = t.a().b(a, j2, false);
                    com.umeng.analytics.c.a(a, string, string2);
                    UMRTLog.i("MobclickRT", "--->>> onProfileSignIn: force generate new session: session id = " + c2);
                    t.a().a(a, j2, true);
                    if (b2) {
                        t.a().b(a, j2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has("__ii")) {
                String optString = jSONObject.optString("__ii");
                jSONObject.remove("__ii");
                if (!TextUtils.isEmpty(optString)) {
                    h.a(a).a(optString, obj.toString(), 2);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
