package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.core.widget.webview.d;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MaterialMeta */
public class l {
    private boolean A;
    private boolean B;
    private h C;
    private Map<String, Object> D;
    private a E;
    private a F;
    private boolean G;
    private int H;
    private String I;
    private String J = "";
    private String K = "";
    private int L = 0;
    private int M = 2;
    private PersonalizationPrompt N;
    private int O = -200;
    private int P = 0;
    private e Q = new e();
    private AdSlot R;
    private int S;
    private int T = 1;
    private String U;
    private int V = 0;
    private int W = 0;
    private int X = 0;
    private JSONObject Y;
    private int Z = 1;
    public String a;
    private int aa;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private int ae = 1;
    private n af;
    private c ag;
    private String ah;
    private int b;
    private k c;
    private k d;
    private String e;
    private int f = -1;
    private String g;
    private List<k> h = new ArrayList();
    private String i;
    private List<String> j = new ArrayList();
    private List<String> k = new ArrayList();
    private String l;
    private String m;
    private String n;
    private String o = "0";
    private b p;
    private g q;
    private int r;
    private String s;
    private String t;
    private List<FilterWord> u = new ArrayList();
    private int v = 0;
    private long w;
    private int x;
    private t y;
    private boolean z;

    public static boolean a(l lVar) {
        return lVar != null && lVar.a() == 1;
    }

    public int a() {
        return this.ad;
    }

    public void a(int i2) {
        this.ad = i2;
    }

    public void a(String str) {
        this.K = str;
    }

    public String b() {
        return this.K;
    }

    public void b(int i2) {
        this.L = i2;
    }

    public int c() {
        return this.L;
    }

    public void c(int i2) {
        this.M = i2;
    }

    public int d() {
        return this.M;
    }

    public int e() {
        return this.V;
    }

    public void d(int i2) {
        this.V = i2;
    }

    public boolean f() {
        return this.V == 1;
    }

    public JSONObject g() {
        n nVar = this.af;
        if (nVar == null) {
            return null;
        }
        return nVar.b();
    }

    public n h() {
        return this.af;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.af = n.a(jSONObject);
        }
    }

    public int i() {
        return this.H;
    }

    public void e(int i2) {
        this.H = i2;
    }

    public String j() {
        return this.I;
    }

    public void b(String str) {
        this.I = str;
    }

    public int k() {
        return this.X;
    }

    public void f(int i2) {
        this.X = i2;
    }

    public int l() {
        return this.W;
    }

    public void g(int i2) {
        this.W = i2;
    }

    public int m() {
        return this.T;
    }

    public void h(int i2) {
        this.T = i2;
    }

    public int n() {
        return this.P;
    }

    public void i(int i2) {
        this.P = i2;
    }

    public e o() {
        return this.Q;
    }

    public void a(e eVar) {
        this.Q = eVar;
    }

    public AdSlot p() {
        return this.R;
    }

    public void a(AdSlot adSlot) {
        this.R = adSlot;
    }

    public boolean q() {
        return r() == 1;
    }

    public int r() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.e();
    }

    public boolean s() {
        return t() == 1;
    }

    public int t() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.i();
    }

    public int u() {
        h hVar = this.C;
        if (hVar == null) {
            return 300;
        }
        return hVar.j();
    }

    public int v() {
        return this.S;
    }

    public void j(int i2) {
        this.S = i2;
    }

    public int w() {
        return this.O;
    }

    public void k(int i2) {
        this.O = i2;
    }

    public int x() {
        return this.Z;
    }

    public void l(int i2) {
        this.Z = i2;
    }

    public void c(String str) {
        this.J = str;
    }

    public String y() {
        return this.J;
    }

    public int z() {
        return this.aa;
    }

    public void m(int i2) {
        this.aa = i2;
    }

    public boolean A() {
        t tVar = this.y;
        return tVar == null || tVar.n() != 1;
    }

    public boolean B() {
        t tVar = this.y;
        return tVar != null && tVar.o() == 1;
    }

    public boolean C() {
        return this.G;
    }

    public static boolean b(l lVar) {
        return lVar != null && lVar.C();
    }

    public boolean D() {
        return C() && i() == 1;
    }

    public void a(boolean z2) {
        this.G = z2;
    }

    public boolean E() {
        return F() == 1;
    }

    public int F() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.a();
    }

    public int G() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.c();
    }

    public int H() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.d();
    }

    public int I() {
        h hVar = this.C;
        if (hVar == null) {
            return 0;
        }
        return hVar.k();
    }

    public int J() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.f();
    }

    public int K() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.g();
    }

    public int L() {
        h hVar = this.C;
        if (hVar == null) {
            return 1;
        }
        return hVar.h();
    }

    public a M() {
        return this.E;
    }

    public void a(a aVar) {
        this.E = aVar;
        d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public a N() {
        return this.F;
    }

    public void b(a aVar) {
        this.F = aVar;
        d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this);
    }

    public h O() {
        return this.C;
    }

    public void a(h hVar) {
        this.C = hVar;
    }

    public c P() {
        return this.ag;
    }

    public void a(c cVar) {
        this.ag = cVar;
    }

    public String Q() {
        return this.ah;
    }

    public void d(String str) {
        this.ah = str;
    }

    public t R() {
        return this.y;
    }

    public void a(t tVar) {
        this.y = tVar;
    }

    public void e(String str) {
        this.s = str;
    }

    public String S() {
        return this.s;
    }

    public int T() {
        return this.b;
    }

    public void n(int i2) {
        this.b = i2;
    }

    public k U() {
        return this.c;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public k V() {
        return this.d;
    }

    public void b(k kVar) {
        this.d = kVar;
    }

    public String W() {
        return this.e;
    }

    public void f(String str) {
        this.e = str;
    }

    public int X() {
        return this.f;
    }

    public void o(int i2) {
        this.f = i2;
    }

    public String Y() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public List<k> Z() {
        return this.h;
    }

    public void c(k kVar) {
        this.h.add(kVar);
    }

    public String aa() {
        return this.i;
    }

    public void h(String str) {
        this.i = str;
    }

    public List<String> ab() {
        return this.j;
    }

    public List<String> ac() {
        return this.k;
    }

    public String ad() {
        return this.l;
    }

    public void i(String str) {
        this.l = str;
    }

    public String ae() {
        return this.m;
    }

    public void j(String str) {
        this.m = str;
    }

    public String af() {
        return this.n;
    }

    public void k(String str) {
        this.n = str;
    }

    public String ag() {
        return this.o;
    }

    public void l(String str) {
        this.o = str;
    }

    public b ah() {
        return this.p;
    }

    public void a(b bVar) {
        this.p = bVar;
    }

    public g ai() {
        return this.q;
    }

    public void a(g gVar) {
        this.q = gVar;
    }

    public String aj() {
        return this.t;
    }

    public void m(String str) {
        this.t = str;
    }

    public int ak() {
        return this.r;
    }

    public void p(int i2) {
        this.r = i2;
    }

    public List<FilterWord> al() {
        return this.u;
    }

    public void a(FilterWord filterWord) {
        this.u.add(filterWord);
    }

    public void a(PersonalizationPrompt personalizationPrompt) {
        this.N = personalizationPrompt;
    }

    public PersonalizationPrompt am() {
        return this.N;
    }

    public long an() {
        return this.w;
    }

    public void a(long j2) {
        this.w = j2;
    }

    public int ao() {
        return this.x;
    }

    public void q(int i2) {
        this.x = i2;
    }

    public boolean ap() {
        return this.z;
    }

    public void b(boolean z2) {
        this.z = z2;
    }

    public boolean aq() {
        return this.A;
    }

    public void c(boolean z2) {
        this.A = z2;
    }

    public boolean ar() {
        return this.B;
    }

    public void d(boolean z2) {
        this.B = z2;
    }

    public Map<String, Object> as() {
        return this.D;
    }

    public void a(Map<String, Object> map) {
        this.D = map;
    }

    public JSONObject at() {
        return this.Y;
    }

    public void b(JSONObject jSONObject) {
        this.Y = jSONObject;
    }

    public String au() {
        return this.U;
    }

    public void n(String str) {
        this.U = str;
    }

    public void r(int i2) {
        this.ab = i2;
    }

    public int av() {
        return this.ab;
    }

    public boolean aw() {
        return av() == 1;
    }

    public boolean ax() {
        return ay() == 1;
    }

    public void s(int i2) {
        this.ac = i2;
    }

    public int ay() {
        return this.ac;
    }

    public String az() {
        return this.a;
    }

    public void o(String str) {
        this.a = str;
    }

    public int aA() {
        return this.ae;
    }

    public void t(int i2) {
        this.ae = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!this.o.equals(lVar.o) || !this.t.equals(lVar.t)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.o.hashCode() * 31) + this.t.hashCode();
    }

    public boolean aB() {
        if (this.h.isEmpty()) {
            return false;
        }
        if (this.r == 4 && this.h.size() < 3) {
            return false;
        }
        for (k kVar : this.h) {
            if (!kVar.e()) {
                return false;
            }
        }
        return true;
    }

    public int aC() {
        h hVar = this.C;
        if (hVar == null) {
            return -1;
        }
        return hVar.b();
    }

    public boolean aD() {
        return aE() == 1;
    }

    public int aE() {
        return this.v;
    }

    public void u(int i2) {
        this.v = i2;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = 4;
            this.o = jSONObject.optString("id");
            this.s = jSONObject.optString("source");
            b bVar = new b();
            this.p = bVar;
            bVar.d(jSONObject.optString("pkg_name"));
            this.p.c(jSONObject.optString("name"));
            this.p.b(jSONObject.optString("download_url"));
        }
    }

    public JSONObject aF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", T());
            jSONObject.put("target_url", W());
            jSONObject.put("use_media_video_player", a());
            jSONObject.put("landing_scroll_percentage", X());
            jSONObject.put("gecko_id", Y());
            jSONObject.put("ad_id", ag());
            jSONObject.put("source", S());
            jSONObject.put("package_name", az());
            jSONObject.put("screenshot", ap());
            jSONObject.put("dislike_control", aE());
            jSONObject.put("play_bar_show_time", w());
            jSONObject.put("is_playable", C());
            jSONObject.put("playable", g());
            jSONObject.put("playable_type", i());
            jSONObject.put("playable_style", j());
            jSONObject.put("play_bar_style", n());
            jSONObject.put("if_block_lp", e());
            jSONObject.put("cache_sort", x());
            jSONObject.put("if_sp_cache", z());
            jSONObject.put("render_control", d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("reward_name", b());
            jSONObject2.put("reward_amount", c());
            jSONObject.put("reward_data", jSONObject2);
            k U2 = U();
            if (U2 != null && !TextUtils.isEmpty(U2.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", U2.a());
                jSONObject3.put("height", U2.c());
                jSONObject3.put("width", U2.b());
                jSONObject.put("icon", jSONObject3);
            }
            k V2 = V();
            if (V2 != null && !TextUtils.isEmpty(V2.a())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", V2.a());
                jSONObject4.put("height", V2.c());
                jSONObject4.put("width", V2.b());
                jSONObject.put("cover_image", jSONObject4);
            }
            Object at = at();
            if (at != null) {
                jSONObject.put("session_params", at);
            }
            e o2 = o();
            if (o2 != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("click_upper_content_area", o2.a);
                jSONObject5.put("click_upper_non_content_area", o2.b);
                jSONObject5.put("click_lower_content_area", o2.c);
                jSONObject5.put("click_lower_non_content_area", o2.d);
                jSONObject5.put("click_button_area", o2.e);
                jSONObject5.put("click_video_area", o2.f);
                jSONObject.put("click_area", jSONObject5);
            }
            AdSlot p2 = p();
            if (p2 != null) {
                jSONObject.put("adslot", p2.toJsonObj());
            }
            List<k> Z2 = Z();
            if (Z2 != null) {
                JSONArray jSONArray = new JSONArray();
                for (k kVar : Z2) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("url", kVar.a());
                    jSONObject6.put("height", kVar.c());
                    jSONObject6.put("width", kVar.b());
                    jSONArray.put(jSONObject6);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> ab2 = ab();
            if (ab2 != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : ab2) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> ac2 = ac();
            if (ac2 != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : ac2) {
                    jSONArray3.put(str2);
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", aa());
            jSONObject.put("title", ad());
            jSONObject.put("description", ae());
            jSONObject.put("ext", aj());
            jSONObject.put("image_mode", ak());
            jSONObject.put("is_playable", C());
            jSONObject.put("intercept_flag", v());
            jSONObject.put("button_text", af());
            jSONObject.put("ad_logo", m());
            jSONObject.put("video_adaptation", l());
            jSONObject.put("feed_video_opentype", k());
            b ah2 = ah();
            if (ah2 != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("app_name", ah2.c());
                jSONObject7.put("package_name", ah2.d());
                jSONObject7.put("download_url", ah2.b());
                jSONObject7.put("score", ah2.e());
                jSONObject7.put("comment_num", ah2.f());
                jSONObject7.put("quick_app_url", ah2.a());
                jSONObject7.put("app_size", ah2.g());
                jSONObject.put("app", jSONObject7);
            }
            g ai = ai();
            if (ai != null) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("deeplink_url", ai.a());
                jSONObject8.put("fallback_url", ai.b());
                jSONObject8.put("fallback_type", ai.c());
                jSONObject.put("deep_link", jSONObject8);
            }
            List<FilterWord> al = al();
            if (al != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FilterWord filterWord : al) {
                    JSONObject b2 = b(filterWord);
                    if (b2 != null) {
                        jSONArray4.put(b2);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            PersonalizationPrompt am = am();
            if (am != null) {
                jSONObject.put("personalization_prompts", am.toJson());
            }
            jSONObject.put("count_down", ao());
            jSONObject.put("expiration_time", an());
            t R2 = R();
            if (R2 != null) {
                jSONObject.put("video", R2.m());
            }
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("auto_open", G());
            jSONObject9.put("download_mode", H());
            jSONObject9.put("download_type", aC());
            jSONObject9.put("auto_control", r());
            jSONObject9.put("auto_control_choose", t());
            jSONObject9.put("auto_control_time", u());
            jSONObject9.put("if_suspend_download", F());
            jSONObject9.put("if_send_click", I());
            jSONObject9.put("dl_popup", J());
            jSONObject9.put("market_popup", K());
            jSONObject9.put("if_pop_lp", L());
            jSONObject.put("download_conf", jSONObject9);
            jSONObject.put("if_both_open", av());
            jSONObject.put("if_double_deeplink", ay());
            if (as() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = as().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            jSONObject.put("landing_page_type", aA());
            a M2 = M();
            if (M2 != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("id", M2.b());
                jSONObject11.put("md5", M2.c());
                jSONObject11.put("url", M2.d());
                jSONObject11.put("data", M2.e());
                jSONObject11.put("diff_data", M2.f());
                jSONObject11.put("version", M2.a());
                jSONObject11.put("dynamic_creative", M2.g());
                jSONObject.put("tpl_info", jSONObject11);
            }
            a N2 = N();
            if (N2 != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("middle_id", N2.b());
                jSONObject12.put("middle_md5", N2.c());
                jSONObject12.put("middle_url", N2.d());
                jSONObject12.put("middle_data", N2.e());
                jSONObject12.put("middle_diff_data", N2.f());
                jSONObject12.put("middle_version", N2.a());
                jSONObject12.put("middle_dynamic_creative", N2.g());
                jSONObject.put("middle_tpl_info", jSONObject12);
            }
            jSONObject.put("market_url", au());
            c P2 = P();
            if (P2 != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("developer_name", P2.c());
                jSONObject13.put("app_version", P2.b());
                jSONObject13.put("permissions", P2.e());
                jSONObject13.put("privacy_policy_url", P2.d());
                jSONObject13.put("package_name", P2.f());
                jSONObject13.put("app_name", P2.g());
                jSONObject.put("app_manage", jSONObject13);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord filterWord2 : filterWord.getOptions()) {
                        jSONArray.put(b(filterWord2));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean c(l lVar) {
        if (lVar == null) {
            return false;
        }
        if (lVar.ak() == 5 || lVar.ak() == 15) {
            return true;
        }
        return false;
    }

    public static boolean d(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 1;
    }

    public static boolean e(l lVar) {
        return lVar != null && lVar.C() && lVar.i() == 0;
    }

    public static boolean f(l lVar) {
        try {
            return lVar.at().optInt("parent_type") == 1;
        } catch (Exception e2) {
            Log.e("MaterialMeta", "isLuBanLandingPage error " + e2);
            return false;
        }
    }

    public static boolean a(l lVar, boolean z2, boolean z3) {
        t tVar;
        if (lVar == null || (tVar = lVar.y) == null || tVar.a() != 1) {
            u.b("MaterialMeta", "can show end card follow js WebViewClient");
            return z2;
        }
        u.b("MaterialMeta", "can show end card follow js");
        return z3;
    }

    public static boolean g(l lVar) {
        t tVar;
        if (lVar == null || (tVar = lVar.y) == null || tVar.a() != 1) {
            return false;
        }
        return true;
    }

    /* compiled from: MaterialMeta */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public String a() {
            return this.f;
        }

        public void a(String str) {
            this.f = str;
        }

        public String b() {
            return this.a;
        }

        public void b(String str) {
            this.a = str;
        }

        public String c() {
            return this.b;
        }

        public void c(String str) {
            this.b = str;
        }

        public String d() {
            return this.c;
        }

        public void d(String str) {
            this.c = str;
        }

        public String e() {
            return this.d;
        }

        public void e(String str) {
            this.d = str;
        }

        public String f() {
            return this.e;
        }

        public void f(String str) {
            this.e = str;
        }

        public String g() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }
    }
}
