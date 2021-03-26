package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTSdkSettings */
public class h implements c {
    private Set<String> A = Collections.synchronizedSet(new HashSet());
    private Set<String> B = Collections.synchronizedSet(new HashSet());
    private int C = 0;
    private int D = 1;
    private long E = 10000;
    private int F = 50;
    private int G = 30;
    private int H = 5;
    private int I = 3600;
    private String J = "pangolin.snssdk.com";
    private String K = "extlog.snssdk.com/service/2/app_log/";
    private int L = 100;
    private int M = 3000;
    private Set<String> N = Collections.synchronizedSet(new HashSet());
    private String O = "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json";
    private int P = 0;
    private int a = 0;
    private int b = -1;
    private Map<String, a> c = new HashMap();
    private Map<String, i> d = new HashMap();
    private String e;
    private Set<String> f = new HashSet();
    private String g;
    private Set<String> h = Collections.synchronizedSet(new HashSet());
    private List<e> i = new CopyOnWriteArrayList();
    private String j;
    private int k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f1312l = 30;
    private int m = 1;
    private int n = 0;
    private JSONObject o = null;
    private String p = "";
    private String q;
    private String r;
    private int s = 1;
    private int t = 5;
    private String u;
    private String v;
    private int w;
    private int x;
    private int y = 0;
    private long z = 0;

    private int a(boolean z2) {
        return z2 ? 20 : 5;
    }

    private static boolean f(int i2) {
        return i2 == 1 || i2 == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.h.c
    public synchronized void a() {
        if (b.b()) {
            this.J = a.b("tt_sdk_settings", "url_ads", "pangolin.snssdk.com");
            this.K = a.b("tt_sdk_settings", "url_alog", "extlog.snssdk.com/service/2/app_log/");
            this.j = a.b("tt_sdk_settings", "xpath", "");
            this.E = a.a("tt_sdk_settings", "duration", 10000L);
            this.F = a.a("tt_sdk_settings", "max", 50);
            this.k = a.a("tt_sdk_settings", "download_config_dl_network", 1);
            this.f1312l = a.a("tt_sdk_settings", "download_config_dl_size", 30);
            this.m = a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            this.G = a.a("tt_sdk_settings", "pos_cache_time", 30);
            this.H = a.a("tt_sdk_settings", "vbtt", 5);
            this.I = a.a("tt_sdk_settings", "fetch_template", 3600);
            this.g = a.b("tt_sdk_settings", "template_ids", (String) null);
            this.q = a.b("tt_sdk_settings", "ab_test_version", (String) null);
            this.r = a.b("tt_sdk_settings", "ab_test_param", (String) null);
            this.s = a.a("tt_sdk_settings", "web_info_wifi_enable", 1);
            this.t = a.a("tt_sdk_settings", "web_info_page_count", 5);
            this.u = a.b("tt_sdk_settings", "pyload_h5", (String) null);
            this.v = a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            this.w = a.a("tt_sdk_settings", "splash_load_type", 1);
            this.x = a.a("tt_sdk_settings", "splash_check_type", 1);
            this.C = a.a("tt_sdk_settings", "if_both_open", 0);
            this.D = a.a("tt_sdk_settings", "support_tnc", 1);
            this.e = a.b("tt_sdk_settings", "tpl_infos", (String) null);
            this.y = a.a("tt_sdk_settings", "app_list_control", 0);
            this.L = a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            this.M = a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", 3000);
            Set<String> set = this.N;
            if (set != null) {
                set.clear();
            }
            Set<String> b2 = a.b("tt_sdk_settings", "gecko_hosts", (Set<String>) null);
            this.N = b2;
            this.N = a(b2);
            this.z = a.a("tt_sdk_settings", "hit_app_list_time", 0L);
            this.A.clear();
            this.a = a.a("tt_sdk_settings", "circle_splash_switch", 0);
            this.b = a.a("tt_sdk_settings", "circle_load_splash_time", -1);
            this.P = a.a("tt_sdk_settings", "sp_key_if_sp_cache", 0);
            this.O = a.b("tt_sdk_settings", "dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
            Set<String> b3 = a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
            if (b3 != null && !b3.isEmpty()) {
                for (String str : b3) {
                    this.A.add(str);
                }
            }
            this.B.clear();
            Set<String> b4 = a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
            if (b4 != null && !b4.isEmpty()) {
                for (String str2 : b4) {
                    this.B.add(str2);
                }
            }
            t(a.b("tt_sdk_settings", "push_config", (String) null));
            String b5 = a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (!TextUtils.isEmpty(b5)) {
                try {
                    JSONArray jSONArray = new JSONArray(b5);
                    int length = jSONArray.length();
                    if (length > 0) {
                        this.c.clear();
                        for (int i2 = 0; i2 < length; i2++) {
                            a b6 = b(jSONArray.optJSONObject(i2));
                            if (b6 != null) {
                                this.c.put(b6.a, b6);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            String b7 = a.b("tt_sdk_settings", "download_sdk_config", "");
            this.p = b7;
            if (!TextUtils.isEmpty(b7)) {
                try {
                    this.o = new JSONObject(this.p);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.n = a.a("tt_sdk_settings", "enable_download_opt", 0);
            g.c();
            return;
        }
        ae J2 = J();
        this.J = J2.b("url_ads", "pangolin.snssdk.com");
        this.K = J2.b("url_alog", "extlog.snssdk.com/service/2/app_log/");
        this.j = J2.b("xpath", "");
        this.E = J2.b("duration", 10000L);
        this.F = J2.b("max", 50);
        this.k = J2.b("download_config_dl_network", 1);
        this.f1312l = J2.b("download_config_dl_size", 30);
        this.m = J2.b("download_config_storage_internal", 1);
        this.G = J2.b("pos_cache_time", 30);
        this.I = J2.b("fetch_template", 3600);
        this.q = J2.a("ab_test_version");
        this.r = J2.a("ab_test_param");
        this.H = J2.b("vbtt", 5);
        this.g = J2.b("template_ids", (String) null);
        this.s = J2.b("web_info_wifi_enable", 1);
        this.t = J2.b("web_info_page_count", 5);
        this.u = J2.b("pyload_h5", (String) null);
        this.v = J2.b("playableLoadH5Url", (String) null);
        this.w = J2.b("splash_load_type", 1);
        this.x = J2.b("splash_check_type", 1);
        this.C = J2.b("if_both_open", 0);
        this.D = J2.b("support_tnc", 1);
        this.e = J2.b("tpl_infos", (String) null);
        this.y = J2.b("app_list_control", 0);
        this.L = J2.b("max_tpl_cnts", 100);
        this.M = J2.b("fetch_tpl_timeout_ctrl", 3000);
        Set<String> set2 = this.N;
        if (set2 != null) {
            set2.clear();
        }
        Set<String> b8 = J2.b("gecko_hosts", (Set<String>) null);
        this.N = b8;
        this.N = a(b8);
        this.z = J2.b("hit_app_list_time", 0L);
        this.A.clear();
        this.a = J2.b("circle_splash_switch", 0);
        this.b = J2.b("circle_load_splash_time", -1);
        this.O = J2.b("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.P = J2.b("sp_key_if_sp_cache", 0);
        Set<String> b9 = J2.b("hit_app_list_data", (Set<String>) null);
        if (b9 != null && !b9.isEmpty()) {
            for (String str3 : b9) {
                this.A.add(str3);
            }
        }
        this.B.clear();
        Set<String> b10 = J2.b("scheme_list_data", (Set<String>) null);
        if (b10 != null && !b10.isEmpty()) {
            for (String str4 : b10) {
                this.B.add(str4);
            }
        }
        t(J2.b("push_config", (String) null));
        String b11 = J2.b("ad_slot_conf", (String) null);
        if (!TextUtils.isEmpty(b11)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b11);
                int length2 = jSONArray2.length();
                if (length2 > 0) {
                    this.c.clear();
                    for (int i3 = 0; i3 < length2; i3++) {
                        a b12 = b(jSONArray2.optJSONObject(i3));
                        if (b12 != null) {
                            this.c.put(b12.a, b12);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        String b13 = J2.b("download_sdk_config", "");
        this.p = b13;
        if (!TextUtils.isEmpty(b13)) {
            try {
                this.o = new JSONObject(this.p);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        this.n = J2.b("enable_download_opt", 0);
        g.c();
    }

    private void t(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    e eVar = new e();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    eVar.a = optJSONObject.optString("action");
                    eVar.b = optJSONObject.optString("service");
                    eVar.c = optJSONObject.optString("package");
                    eVar.d = optJSONObject.optInt("wakeup_interval");
                    this.i.add(eVar);
                }
                d.a().b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("read_video_from_cache", 1);
        int optInt6 = jSONObject.optInt("proportion_watching", 100);
        int optInt7 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt8 = jSONObject.optInt("video_skip_result", 2);
        int optInt9 = jSONObject.optInt("reg_creative_control", 1);
        int optInt10 = jSONObject.optInt("play_bar_show_time", 3);
        int optInt11 = jSONObject.optInt("rv_skip_time", -1);
        int optInt12 = jSONObject.optInt("endcard_close_time", -1);
        int optInt13 = jSONObject.optInt("playable_endcard_close_time", -1);
        int optInt14 = jSONObject.optInt("voice_control", 2);
        int optInt15 = jSONObject.optInt("if_show_win", 1);
        int optInt16 = jSONObject.optInt("sp_preload", 0);
        int optInt17 = jSONObject.optInt("stop_time", 1500);
        int optInt18 = jSONObject.optInt("native_playable_delay", 2);
        int optInt19 = jSONObject.optInt("time_out_control", -1);
        int optInt20 = jSONObject.optInt("playable_duration_time", 20);
        int optInt21 = jSONObject.optInt("playable_close_time", -1);
        int optInt22 = jSONObject.optInt("playable_reward_type", 0);
        int optInt23 = jSONObject.optInt("reward_is_callback", 0);
        int optInt24 = jSONObject.optInt("iv_skip_time", 5);
        JSONArray optJSONArray = jSONObject.optJSONArray("parent_tpl_ids");
        if (!f(optInt2)) {
            optInt2 = 1;
        }
        if (!f(optInt14)) {
            optInt14 = 1;
        }
        return a.a().a(optString).n(optInt).o(optInt2).p(optInt3).q(optInt4).r(optInt5).s(optInt6).t(optInt7).u(optInt8).v(optInt9).m(optInt10).l(optInt11).j(optInt12).i(optInt14).k(optInt13).w(optInt15).f(optInt16).g(optInt17).h(optInt18).e(optInt19).a(optInt21).d(optInt20).b(optInt22).c(optInt23).x(optInt24).a(optJSONArray);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x027e  */
    @Override // com.bytedance.sdk.openadsdk.core.h.c
    public void a(JSONObject jSONObject) {
        String str;
        JSONArray optJSONArray;
        Throwable th;
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            this.a = optJSONObject.optInt("circle_splash", 0);
            this.b = optJSONObject.optInt("circle_time", -1);
            this.P = optJSONObject.optInt("if_sp_cache", 0);
        }
        this.O = jSONObject.optString("dyn_draw_engine_url", "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json");
        this.J = jSONObject.optString("ads_url", "pangolin.snssdk.com");
        this.K = jSONObject.optString("app_log_url", "extlog.snssdk.com/service/2/app_log/");
        this.j = jSONObject.optString("xpath");
        this.G = jSONObject.optInt("pos_cache_time", 30);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject2 != null) {
            this.E = optJSONObject2.optLong("duration") * 1000;
            this.F = optJSONObject2.optInt("max");
        }
        this.H = jSONObject.optInt("vbtt", 5);
        this.I = jSONObject.optInt("fetch_tpl_interval", 3600);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("abtest");
        if (optJSONObject3 != null) {
            this.q = optJSONObject3.optString("version");
            this.r = optJSONObject3.optString("param");
        } else if (b.b()) {
            a.c("tt_sdk_settings", "ab_test_version");
            a.c("tt_sdk_settings", "ab_test_param");
        } else {
            ae J2 = J();
            J2.b("ab_test_version");
            J2.b("ab_test_param");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("web_info");
        if (optJSONObject4 != null) {
            this.s = optJSONObject4.optInt("web_info_wifi_enable", 1);
            this.t = optJSONObject4.optInt("web_info_page_count", 5);
        }
        this.u = jSONObject.optString("pyload_h5");
        this.v = jSONObject.optString("pure_pyload_h5");
        this.w = c(jSONObject);
        u.f("splashLoad", "setting-》mSplashLoadType=" + this.w);
        this.x = d(jSONObject);
        u.f("splashLoad", "setting-》mSplashCheckType=" + this.x);
        this.C = jSONObject.optInt("if_both_open", 0);
        this.D = jSONObject.optInt("support_tnc", 1);
        this.y = jSONObject.optInt("al", 0);
        this.L = jSONObject.optInt("max_tpl_cnts", 100);
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject5 != null) {
            this.M = optJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000);
            try {
                this.N.clear();
                JSONArray optJSONArray2 = optJSONObject5.optJSONArray("gecko_hosts");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.N.add(optJSONArray2.getString(i2));
                    }
                }
                this.N = a(this.N);
            } catch (Throwable th2) {
                u.b("GeckoLog: settings json error " + th2);
            }
        }
        this.z = System.currentTimeMillis();
        this.A.clear();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray3 != null) {
            int length = optJSONArray3.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray3.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    this.A.add(optString);
                }
            }
        }
        this.B.clear();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("scheme_check_list");
        if (optJSONArray4 != null) {
            int length2 = optJSONArray4.length();
            for (int i4 = 0; i4 < length2; i4++) {
                String optString2 = optJSONArray4.optString(i4);
                if (!TextUtils.isEmpty(optString2)) {
                    this.B.add(optString2);
                }
            }
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("download_config");
        if (optJSONObject6 != null) {
            this.k = optJSONObject6.optInt("dl_network", 1);
            this.f1312l = optJSONObject6.optInt("dl_size", 30);
            this.m = optJSONObject6.optInt("if_storage_internal", 1);
            this.n = optJSONObject6.optInt("enable_download_opt", 0);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("download_sdk_config");
        this.o = optJSONObject7;
        if (optJSONObject7 != null) {
            this.p = optJSONObject7.toString();
        } else {
            this.p = "";
        }
        String str2 = null;
        try {
            JSONArray optJSONArray5 = jSONObject.optJSONArray("push_config");
            if (optJSONArray5 != null) {
                str = optJSONArray5.toString();
                try {
                    int length3 = optJSONArray5.length();
                    for (int i5 = 0; i5 < length3; i5++) {
                        e eVar = new e();
                        JSONObject optJSONObject8 = optJSONArray5.optJSONObject(i5);
                        if (optJSONObject8 != null) {
                            eVar.a = optJSONObject8.optString("action");
                            eVar.b = optJSONObject8.optString("service");
                            eVar.c = optJSONObject8.optString("package");
                            eVar.d = optJSONObject8.optInt("wakeup_interval");
                            this.i.add(eVar);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
                    if (optJSONArray != null) {
                    }
                    g.c();
                    a(str2, str);
                }
            } else {
                str = null;
            }
            d.a().b();
        } catch (Throwable th4) {
            th = th4;
            str = null;
            th.printStackTrace();
            optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
            if (optJSONArray != null) {
            }
            g.c();
            a(str2, str);
        }
        optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray != null) {
            str2 = optJSONArray.toString();
            int length4 = optJSONArray.length();
            if (length4 > 0) {
                this.c.clear();
                for (int i6 = 0; i6 < length4; i6++) {
                    a b2 = b(optJSONArray.optJSONObject(i6));
                    if (b2 != null) {
                        this.c.put(b2.a, b2);
                    }
                }
            }
        }
        g.c();
        a(str2, str);
    }

    private int c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_load_type", 1);
        this.w = optInt;
        if (optInt == 0 || optInt == 1 || optInt == 2 || optInt == 3) {
            return optInt;
        }
        return 1;
    }

    private int d(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.x = optInt;
        if (optInt == 0 || optInt == 1) {
            return optInt;
        }
        return 1;
    }

    private void a(String str, String str2) {
        if (b.b()) {
            a.a("tt_sdk_settings", "url_ads", this.J);
            a.a("tt_sdk_settings", "url_alog", this.K);
            a.a("tt_sdk_settings", "xpath", this.j);
            a.a("tt_sdk_settings", "duration", Long.valueOf(this.E));
            a.a("tt_sdk_settings", "max", Integer.valueOf(this.F));
            a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.k));
            a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.f1312l));
            a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.m));
            a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.G));
            a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.H));
            a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.I));
            a.a("tt_sdk_settings", "web_info_wifi_enable", Integer.valueOf(this.s));
            a.a("tt_sdk_settings", "web_info_page_count", Integer.valueOf(this.t));
            a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.w));
            a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.x));
            a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.C));
            a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.D));
            a.a("tt_sdk_settings", "pyload_h5", this.u);
            a.a("tt_sdk_settings", "playableLoadH5Url", this.v);
            a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.y));
            a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.L));
            a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.M));
            a.a("tt_sdk_settings", "gecko_hosts", this.N);
            a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.z));
            a.a("tt_sdk_settings", "hit_app_list_data", this.A);
            a.a("tt_sdk_settings", "scheme_list_data", this.B);
            a.a("tt_sdk_settings", "circle_splash_switch", Integer.valueOf(this.a));
            a.a("tt_sdk_settings", "circle_load_splash_time", Integer.valueOf(this.b));
            a.a("tt_sdk_settings", "sp_key_if_sp_cache", Integer.valueOf(this.P));
            a.a("tt_sdk_settings", "dyn_draw_engine_url", this.O);
            a.a("tt_sdk_settings", "download_sdk_config", this.p);
            a.a("tt_sdk_settings", "enable_download_opt", Integer.valueOf(this.n));
            if (!TextUtils.isEmpty(this.q)) {
                a.a("tt_sdk_settings", "ab_test_version", this.q);
            }
            if (!TextUtils.isEmpty(this.r)) {
                a.a("tt_sdk_settings", "ab_test_param", this.r);
            }
            if (!TextUtils.isEmpty(str2)) {
                a.a("tt_sdk_settings", "push_config", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                a.a("tt_sdk_settings", "ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.g)) {
                a.a("tt_sdk_settings", "template_ids", this.g);
            }
            if (!TextUtils.isEmpty(this.e)) {
                a.a("tt_sdk_settings", "tpl_infos", this.e);
                return;
            }
            return;
        }
        ae J2 = J();
        J2.a("url_ads", this.J);
        J2.a("url_alog", this.K);
        J2.a("xpath", this.j);
        J2.a("duration", this.E);
        J2.a("max", this.F);
        J2.a("download_config_dl_network", this.k);
        J2.a("download_config_dl_size", this.f1312l);
        J2.a("download_config_storage_internal", this.m);
        J2.a("pos_cache_time", this.G);
        J2.a("fetch_template", this.I);
        J2.a("web_info_wifi_enable", this.s);
        J2.a("web_info_page_count", this.t);
        J2.a("pyload_h5", this.u);
        J2.a("playableLoadH5Url", this.v);
        J2.a("splash_load_type", this.w);
        J2.a("splash_check_type", this.x);
        J2.a("if_both_open", this.C);
        J2.a("support_tnc", this.D);
        J2.a("app_list_control", this.y);
        J2.a("max_tpl_cnts", this.L);
        J2.a("fetch_tpl_timeout_ctrl", this.M);
        J2.a("gecko_hosts", this.N);
        J2.a("hit_app_list_time", this.z);
        J2.a("hit_app_list_data", this.A);
        J2.a("scheme_list_data", this.B);
        J2.a("circle_splash_switch", this.a);
        J2.a("circle_load_splash_time", this.b);
        J2.a("dyn_draw_engine_url", this.O);
        J2.a("sp_key_if_sp_cache", this.P);
        J2.a("download_sdk_config", this.p);
        J2.a("enable_download_opt", this.n);
        if (!TextUtils.isEmpty(this.q)) {
            J2.a("ab_test_version", this.q);
        }
        if (!TextUtils.isEmpty(this.r)) {
            J2.a("ab_test_param", this.r);
        }
        J2.a("vbtt", this.H);
        if (!TextUtils.isEmpty(str2)) {
            J2.a("push_config", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            J2.a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.g)) {
            J2.a("template_ids", this.g);
        }
        if (!TextUtils.isEmpty(this.e)) {
            J2.a("tpl_infos", this.e);
        }
    }

    private ae J() {
        return ae.a("tt_sdk_settings", p.a());
    }

    public String b() {
        return TextUtils.isEmpty(this.J) ? "pangolin.snssdk.com" : this.J;
    }

    public String c() {
        return TextUtils.isEmpty(this.K) ? "extlog.snssdk.com/service/2/app_log/" : this.K;
    }

    public boolean d() {
        return this.D == 1;
    }

    public int e() {
        return this.k;
    }

    public int f() {
        return this.f1312l * 1024 * 1024;
    }

    public String g() {
        return this.q;
    }

    public String h() {
        return this.r;
    }

    public String i() {
        return this.j;
    }

    public long j() {
        return this.E;
    }

    public int k() {
        return this.F;
    }

    public int l() {
        return this.G;
    }

    public int m() {
        return this.t;
    }

    public String n() {
        return this.u;
    }

    public String o() {
        return this.v;
    }

    public JSONObject p() {
        return this.o;
    }

    public boolean q() {
        return this.n == 1;
    }

    public int r() {
        return this.w;
    }

    public int s() {
        return this.x;
    }

    public boolean t() {
        return r() != 0;
    }

    public boolean u() {
        return s() == 1;
    }

    public boolean v() {
        return this.s == 1;
    }

    public boolean w() {
        return this.m == 1;
    }

    public int x() {
        return this.a;
    }

    public int y() {
        return this.b;
    }

    public String z() {
        return this.O;
    }

    public boolean a(int i2) {
        return r(String.valueOf(i2)).c == 1;
    }

    public boolean a(String str) {
        int i2 = p.h().r(String.valueOf(str)).e;
        if (i2 == 1) {
            return x.d(p.a());
        }
        if (i2 == 2 && x.c(p.a()) != 0) {
            return true;
        }
        return false;
    }

    public boolean b(String str) {
        return r(String.valueOf(str)).h == 1;
    }

    public int c(String str) {
        return r(String.valueOf(str)).t;
    }

    public boolean d(String str) {
        if (str == null || p.h().r(String.valueOf(str)).p == 1) {
            return true;
        }
        return false;
    }

    public boolean e(String str) {
        if (str == null || p.h().r(String.valueOf(str)).q == 0) {
            return true;
        }
        return false;
    }

    public int f(String str) {
        if (str == null) {
            return 1500;
        }
        return p.h().r(String.valueOf(str)).r;
    }

    public int g(String str) {
        return p.h().r(String.valueOf(str)).f1311l;
    }

    public JSONArray h(String str) {
        try {
            Set<String> b2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(str);
            if (b2 != null) {
                if (b2.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : b2) {
                        r a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str2);
                        if (a2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", a2.b());
                            jSONObject.put("md5", a2.c());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean i(String str) {
        try {
            a r2 = p.h().r(String.valueOf(str));
            return (r2 == null || r2.z == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int j(String str) {
        return r(String.valueOf(str)).i;
    }

    public int k(String str) {
        return r(str).k;
    }

    public int l(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().r(String.valueOf(str)).m;
    }

    public int a(String str, boolean z2) {
        if (str == null) {
            return a(z2);
        }
        a r2 = p.h().r(String.valueOf(str));
        return r2.v != -1 ? r2.v : a(z2);
    }

    public int m(String str) {
        if (str == null) {
            return 0;
        }
        return p.h().r(String.valueOf(str)).w;
    }

    public boolean n(String str) {
        return r(String.valueOf(str)).x == 0;
    }

    public int o(String str) {
        if (str == null) {
            return 20;
        }
        return p.h().r(String.valueOf(str)).u;
    }

    public int p(String str) {
        if (str == null) {
            return -1;
        }
        return p.h().r(String.valueOf(str)).n;
    }

    public boolean b(int i2) {
        if (i2 != 0 && p.h().r(String.valueOf(i2)).o == 1) {
            return true;
        }
        return false;
    }

    public boolean q(String str) {
        if (str == null || p.h().r(String.valueOf(str)).f == 1) {
            return true;
        }
        return false;
    }

    public List<String> A() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.A) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public int B() {
        return this.P;
    }

    public List<String> C() {
        if (this.z + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.B) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public boolean D() {
        return this.y == 1;
    }

    public int E() {
        return this.L;
    }

    public int F() {
        if (this.M <= 0) {
            this.M = 3000;
        }
        return this.M;
    }

    public String[] G() {
        try {
            Set<String> set = this.N;
            if (set != null) {
                if (set.size() != 0) {
                    return (String[]) this.N.toArray(new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int c(int i2) {
        return r(String.valueOf(i2)).b;
    }

    public int d(int i2) {
        return r(String.valueOf(i2)).j;
    }

    public int e(int i2) {
        return r(String.valueOf(i2)).y;
    }

    public int H() {
        return this.H;
    }

    public a r(String str) {
        a aVar = this.c.get(str);
        return aVar == null ? u(str) : aVar;
    }

    private a u(String str) {
        return a.a().a(str).n(1).o(!this.f.contains(str) ? 1 : 0).p(2).q(1).r(1).s(100).t(0).v(1).m(3).l(-1).j(-1).i(2).k(-1).w(1).e(-1).a(-1).d(20).x(5).a((JSONArray) null);
    }

    public List<e> I() {
        return this.i;
    }

    public void s(String str) {
        this.f.add(str);
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            try {
                return new HashSet();
            } catch (Throwable unused) {
                return new HashSet();
            }
        } else {
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        }
    }
}
