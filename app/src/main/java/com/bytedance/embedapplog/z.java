package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class z {
    private final Context a;
    private final InitConfig b;
    private final SharedPreferences c;
    private final SharedPreferences d;
    private final SharedPreferences e;
    private volatile JSONObject f;
    private volatile JSONObject g;

    public long C() {
        return 10000;
    }

    public void a(long j) {
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public boolean a(ArrayList<aq> arrayList) {
        return true;
    }

    String z() {
        return null;
    }

    public z(Context context, InitConfig initConfig) {
        this.a = context;
        this.b = initConfig;
        this.e = context.getSharedPreferences("embed_applog_stats", 0);
        this.c = context.getSharedPreferences("embed_header_custom", 0);
        this.d = context.getSharedPreferences("embed_last_sp_session", 0);
    }

    String a() {
        return this.b.getAliyunUdid();
    }

    public boolean b() {
        return this.b.getPicker() != null;
    }

    public String c() {
        return this.d.getString("session_last_day", "");
    }

    public void a(String str, int i) {
        this.d.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int d() {
        return this.d.getInt("session_order", 0);
    }

    public SharedPreferences e() {
        return this.e;
    }

    public boolean f() {
        return this.b.isPlayEnable();
    }

    public JSONObject g() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (bo.b) {
            bo.a("setConfig, " + jSONObject.toString(), null);
        }
        this.g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.e.edit();
        long optInt = (long) jSONObject.optInt("session_interval", 0);
        if (optInt <= 0 || optInt > 604800) {
            edit.remove("session_interval");
        } else {
            edit.putLong("session_interval", optInt * 1000);
        }
        long optInt2 = (long) jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 <= 0 || optInt2 > 604800) {
            edit.remove("batch_event_interval");
        } else {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 <= 0 || ((long) optInt3) > 604800) {
            edit.remove("send_launch_timely");
        } else {
            edit.putInt("send_launch_timely", optInt3);
        }
        long optInt4 = (long) jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 <= 20 || optInt4 > 604800) {
            edit.remove("abtest_fetch_interval");
        } else {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        bo.a = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 <= 0 || optInt5 > 100) {
            edit.remove("bav_monitor_rate");
            bn.a(false);
        } else {
            edit.putInt("bav_monitor_rate", optInt5);
            bn.a(true);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }

    public long h() {
        return this.e.getLong("app_log_last_config_time", 0);
    }

    public int i() {
        return this.e.getInt("bav_monitor_rate", 0);
    }

    public String j() {
        return this.b.getAid();
    }

    String k() {
        return this.b.getChannel();
    }

    String l() {
        return this.b.getGoogleAid();
    }

    String m() {
        return this.b.getLanguage();
    }

    String n() {
        return this.b.getRegion();
    }

    void b(JSONObject jSONObject) {
        this.c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    String o() {
        return this.c.getString("header_custom_info", null);
    }

    void a(String str) {
        this.c.edit().putString("ab_sdk_version", str).apply();
    }

    String p() {
        return this.c.getString("ab_sdk_version", "");
    }

    void b(String str) {
        this.c.edit().putString("user_unique_id", str).apply();
    }

    String q() {
        return this.c.getString("user_unique_id", null);
    }

    public boolean r() {
        if (this.b.getProcess() == 0) {
            this.b.setProcess(!bp.a(this.a).contains(":"));
        }
        if (this.b.getProcess() == 1) {
            return true;
        }
        return false;
    }

    public long s() {
        return this.e.getLong("abtest_fetch_interval", 0);
    }

    void c(JSONObject jSONObject) {
        bo.a("setAbConfig, " + jSONObject.toString(), null);
        this.c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f = null;
    }

    public String t() {
        if (!TextUtils.isEmpty(this.b.getAbVersion())) {
            return this.b.getAbVersion();
        }
        return this.c.getString("ab_version", null);
    }

    public JSONObject u() {
        JSONObject jSONObject = this.f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (v()) {
                        jSONObject = new JSONObject(this.c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f = jSONObject;
            }
        }
        return jSONObject;
    }

    public JSONObject c(String str) {
        return u().optJSONObject(str);
    }

    public boolean v() {
        return this.e.getBoolean("bav_ab_config", false);
    }

    public boolean w() {
        return this.e.getBoolean("bav_log_collect", false);
    }

    public long x() {
        return this.e.getLong("session_interval", 30000);
    }

    public long y() {
        return this.e.getLong("batch_event_interval", 30000);
    }

    String A() {
        return this.b.getReleaseBuild();
    }

    String B() {
        return this.e.getString("user_agent", null);
    }

    void d(String str) {
        this.e.edit().putString("user_agent", str).apply();
    }

    public String D() {
        return this.b.getAppName();
    }

    public int E() {
        return this.b.getVersionCode();
    }

    public int F() {
        return this.b.getUpdateVersionCode();
    }

    public int G() {
        return this.b.getManifestVersionCode();
    }

    public String H() {
        return this.b.getVersion();
    }

    public String I() {
        return this.b.getTweakedChannel();
    }

    public String J() {
        return this.b.getAbClient();
    }

    public String K() {
        return this.b.getAbGroup();
    }

    public String L() {
        return this.b.getAbFeature();
    }

    public String M() {
        return this.b.getVersionMinor();
    }

    public String N() {
        return this.b.getAppImei() == null ? "" : this.b.getAppImei();
    }

    public boolean O() {
        return this.b.isImeiEnable();
    }

    public InitConfig P() {
        return this.b;
    }

    public void e(String str) {
        this.c.edit().putString("ab_version", str).apply();
    }

    public CharSequence Q() {
        return this.b.getZiJieCloudPkg();
    }
}
