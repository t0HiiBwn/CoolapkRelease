package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class CloudManager {
    public static final String KEY_CONFIG = "cloud";
    private static Context a;
    private String b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private int t;
    private int u;
    private int v;
    private String w;
    private JSONArray x;
    private String y;

    /* compiled from: ProGuard */
    public static class CloudManagerHolder {
        public static CloudManager instance = new CloudManager();
    }

    private CloudManager() {
        this.b = null;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = null;
        this.x = null;
        this.y = null;
    }

    public static CloudManager getInstance(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
        }
        return CloudManagerHolder.instance;
    }

    public String getCloud() {
        return this.b;
    }

    public long getCloudVersion() {
        if (this.c == -1) {
            this.c = PushPreferences.getLong(a, "cloud_control_version", 0);
        }
        return this.c;
    }

    public boolean disablePullUp() {
        return b() == 10 || e() == 1;
    }

    public boolean isCloudRefuse() {
        if (c() == 20 || d() == 1) {
            return true;
        }
        int max = Math.max(c(), d());
        if (max <= 0 || new Random().nextInt(100) >= max) {
            return false;
        }
        return true;
    }

    public int getInterval() {
        if (this.f == -1) {
            this.f = PushPreferences.getInt(a, "cloud_control_interval", 0);
        }
        return this.f;
    }

    public int getRecons() {
        if (this.i == -1) {
            this.i = b(a, "cloud_control_recons", 0);
        }
        return this.i;
    }

    public boolean disableReptErrCode() {
        int reptErrCode = getReptErrCode();
        if (reptErrCode == 1) {
            return true;
        }
        if (reptErrCode <= 0 || new Random().nextInt(100) >= reptErrCode) {
            return false;
        }
        return true;
    }

    public int getReptErrCode() {
        if (this.j == -1) {
            this.j = b(a, "cloud_control_reptErrCode", 0);
        }
        return this.j;
    }

    public boolean disableCollData() {
        return f() == 1;
    }

    public boolean disableShareBugly() {
        return g() == 1;
    }

    public int getAppClsAlive() {
        if (this.m == -1) {
            this.m = b(a, "cloud_control_appClsAlive", 0);
        }
        return this.m;
    }

    public boolean disableRepLanuEv() {
        if (this.n == -1) {
            this.n = b(a, "cloud_control_repoLanuEv", 0);
        }
        if (this.n == 1) {
            return true;
        }
        return false;
    }

    public String getCustom() {
        if (!Util.isNullOrEmptyString(this.q)) {
            return this.q;
        }
        try {
            if (Util.isNullOrEmptyString(i())) {
                return this.q;
            }
            this.q = new JSONObject(i()).getString("custom");
            return this.q;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCustom");
        }
    }

    public String getStat() {
        if (!Util.isNullOrEmptyString(this.p)) {
            return this.p;
        }
        try {
            if (Util.isNullOrEmptyString(i())) {
                return this.p;
            }
            this.p = new JSONObject(i()).getString("stat");
            return this.p;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getStat");
        }
    }

    public String getLog() {
        if (!Util.isNullOrEmptyString(this.r)) {
            return this.r;
        }
        try {
            if (Util.isNullOrEmptyString(i())) {
                return this.r;
            }
            this.r = new JSONObject(i()).getString("log");
            return this.r;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getLog");
        }
    }

    public String getGuid() {
        if (!Util.isNullOrEmptyString(this.s)) {
            return this.s;
        }
        try {
            if (Util.isNullOrEmptyString(i())) {
                return this.s;
            }
            this.s = new JSONObject(i()).getString("guid");
            return this.s;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getGuid");
        }
    }

    public void clearGuid() {
        this.s = null;
        this.o = null;
        try {
            PushPreferences.remove(a, "cloud_control_addrCfg");
        } catch (Throwable unused) {
            TBaseLogger.w("CloudManager", "unexpected for clearGuid");
        }
    }

    public JSONArray getPullupArrProviderAndActivity() {
        JSONArray jSONArray = this.x;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            if (Util.isNullOrEmptyString(h())) {
                return null;
            }
            this.x = new JSONArray(this.w);
            return this.x;
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupJSONArr");
        }
    }

    public String getPullupBlackList() {
        try {
            if (this.y == null) {
                this.y = PushPreferences.getString(a, "cloud_control_conf_pull_black_list", "");
            }
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getPullupBlackList");
        }
        return "";
    }

    public boolean disablePullMsg() {
        if (this.t == -1) {
            this.t = b(a, "cloud_control_pullMsg", 0);
        }
        if (this.t == 1) {
            return true;
        }
        return false;
    }

    public boolean disableReptLog() {
        if (this.u == -1) {
            this.u = b(a, "cloud_control_reptLog", 0);
        }
        if (this.u == 1) {
            return true;
        }
        return false;
    }

    public int getCompressLevel() {
        if (this.v == -1) {
            this.v = b(a, "cloud_control_compress", 0);
        }
        return this.v;
    }

    public void parseCloudConfig(final String str, final long j2) {
        if (!Util.isNullOrEmptyString(str) && a != null) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.tpns.baseapi.base.util.CloudManager.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TBaseLogger.d("CloudManager", "config: " + str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("reset")) {
                            CloudManager.this.reset();
                            return;
                        }
                        CloudManager.this.b = str;
                        CloudManager.this.c = jSONObject.optLong("cloudVersion", 0);
                        CloudManager.this.d = jSONObject.optInt("keepAlive", 0);
                        CloudManager.this.e = jSONObject.optInt("packetLoss", 0);
                        CloudManager.this.f = jSONObject.optInt("interval", 0);
                        CloudManager.this.a(CloudManager.a, "cloud_control_keepAlive", CloudManager.this.d);
                        CloudManager.this.a(CloudManager.a, "cloud_control_packetLoss", CloudManager.this.e);
                        CloudManager.this.a(CloudManager.a, "cloud_control_interval", CloudManager.this.f);
                        if (CloudManager.this.c > 0) {
                            PushPreferences.putLong(CloudManager.a, "cloud_control_version", CloudManager.this.c);
                        }
                        CloudManager.this.g = jSONObject.optInt("appAlive", 0);
                        CloudManager.this.h = jSONObject.optInt("losePkt", 0);
                        CloudManager.this.i = jSONObject.optInt("recons", 0);
                        CloudManager.this.j = jSONObject.optInt("reptErrCode", 0);
                        CloudManager.this.k = jSONObject.optInt("collData", 0);
                        CloudManager.this.l = jSONObject.optInt("shrBugly", 0);
                        CloudManager.this.m = jSONObject.optInt("appClsAlive", 0);
                        CloudManager.this.n = jSONObject.optInt("repoLanuEv", 0);
                        CloudManager.this.v = jSONObject.optInt("compress", 0);
                        CloudManager.this.o = jSONObject.optString("addrCfg", "");
                        CloudManager.this.t = jSONObject.optInt("pullMsg", -1);
                        CloudManager.this.u = jSONObject.optInt("reptLog", -1);
                        CloudManager.this.w = jSONObject.optString("conf_pull_arr", "");
                        CloudManager.this.y = jSONObject.optString("conf_pull_black_list", "");
                        CloudManager.this.a(CloudManager.a, "cloud_control_appAlive", CloudManager.this.g);
                        CloudManager.this.a(CloudManager.a, "cloud_control_losePkt", CloudManager.this.h);
                        CloudManager.this.a(CloudManager.a, "cloud_control_recons", CloudManager.this.i);
                        CloudManager.this.a(CloudManager.a, "cloud_control_reptErrCode", CloudManager.this.j);
                        CloudManager.this.a(CloudManager.a, "cloud_control_collData", CloudManager.this.k);
                        CloudManager.this.a(CloudManager.a, "cloud_control_shrBugly", CloudManager.this.l);
                        CloudManager.this.a(CloudManager.a, "cloud_control_appClsAlive", CloudManager.this.m);
                        CloudManager.this.a(CloudManager.a, "cloud_control_repoLanuEv", CloudManager.this.n);
                        CloudManager.this.a(CloudManager.a, "cloud_control_compress", CloudManager.this.v);
                        CloudManager.this.a(CloudManager.a, "cloud_control_pullMsg", CloudManager.this.t);
                        CloudManager.this.a(CloudManager.a, "cloud_control_reptLog", CloudManager.this.u);
                        if (!Util.isNullOrEmptyString(CloudManager.this.o)) {
                            PushPreferences.putString(CloudManager.a, "cloud_control_addrCfg", CloudManager.this.o);
                        }
                        if (!Util.isNullOrEmptyString(CloudManager.this.w)) {
                            PushPreferences.putString(CloudManager.a, "cloud_control_conf_pull_arr", CloudManager.this.w);
                        }
                        if (!Util.isNullOrEmptyString(CloudManager.this.y)) {
                            PushPreferences.putString(CloudManager.a, "cloud_control_conf_pull_black_list", CloudManager.this.y);
                        }
                        StatHelper.reportCloudControl(CloudManager.a, CloudManager.this.c, 1, str, j2);
                    } catch (Throwable th) {
                        TBaseLogger.w("CloudManager", "unexpected for config:" + str, th);
                        StatHelper.reportCloudControl(CloudManager.a, CloudManager.this.getCloudVersion(), 2, str, j2);
                    }
                }
            });
        }
    }

    public void reset() {
        this.b = null;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.v = -1;
        this.t = -1;
        this.u = -1;
        this.o = null;
        this.w = null;
        try {
            PushPreferences.remove(a, "cloud_control_keepAlive");
            PushPreferences.remove(a, "cloud_control_packetLoss");
            PushPreferences.remove(a, "cloud_control_version");
            PushPreferences.remove(a, "cloud_control_interval");
            PushPreferences.remove(a, "cloud_control_appAlive");
            PushPreferences.remove(a, "cloud_control_losePkt");
            PushPreferences.remove(a, "cloud_control_recons");
            PushPreferences.remove(a, "cloud_control_reptErrCode");
            PushPreferences.remove(a, "cloud_control_collData");
            PushPreferences.remove(a, "cloud_control_shrBugly");
            PushPreferences.remove(a, "cloud_control_appClsAlive");
            PushPreferences.remove(a, "cloud_control_repoLanuEv");
            PushPreferences.remove(a, "cloud_control_compress");
            PushPreferences.remove(a, "cloud_control_pullMsg");
            PushPreferences.remove(a, "cloud_control_reptLog");
            PushPreferences.remove(a, "cloud_control_addrCfg");
            PushPreferences.remove(a, "cloud_control_conf_pull_arr");
            PushPreferences.remove(a, "cloud_control_conf_pull_black_list");
        } catch (Throwable th) {
            TBaseLogger.w("CloudManager", "unexpected for reset", th);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, int i2) {
        if (i2 > 0) {
            try {
                PushPreferences.putInt(context, str, i2);
            } catch (Throwable unused) {
                TBaseLogger.d("CloudManager", "unexpected for putCloudConfig:" + str);
            }
        }
    }

    private int b(Context context, String str, int i2) {
        if (context == null) {
            return i2;
        }
        try {
            return PushPreferences.getInt(context, str, i2);
        } catch (Throwable unused) {
            TBaseLogger.d("CloudManager", "unexpected for getCloudConfig:" + str);
            return i2;
        }
    }

    private int b() {
        if (this.d == -1) {
            this.d = b(a, "cloud_control_keepAlive", 0);
        }
        return this.d;
    }

    private int c() {
        if (this.e == -1) {
            this.e = b(a, "cloud_control_packetLoss", 0);
        }
        return this.e;
    }

    private int d() {
        if (this.h == -1) {
            this.h = b(a, "cloud_control_losePkt", 0);
        }
        return this.h;
    }

    private int e() {
        if (this.g == -1) {
            this.g = b(a, "cloud_control_appAlive", 0);
        }
        return this.g;
    }

    private int f() {
        if (this.k == -1) {
            this.k = b(a, "cloud_control_collData", 0);
        }
        return this.k;
    }

    private int g() {
        if (this.l == -1) {
            this.l = b(a, "cloud_control_shrBugly", 0);
        }
        return this.l;
    }

    private String h() {
        if (this.w == null) {
            this.w = PushPreferences.getString(a, "cloud_control_conf_pull_arr", "");
        }
        return this.w;
    }

    private String i() {
        if (this.o == null) {
            this.o = PushPreferences.getString(a, "cloud_control_addrCfg", "");
        }
        return this.o;
    }
}
