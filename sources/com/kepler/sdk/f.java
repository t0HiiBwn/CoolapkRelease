package com.kepler.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    private List<String> A;
    private String[] B;
    private String[] C;
    private String[] D;
    private ArrayList<k> E;
    public int a;
    public boolean b;
    public boolean c;
    boolean d;
    HashSet<String> e;
    String[] f;
    HashSet<String> g;
    public String h;
    public String i;
    public String j;
    private LinkedHashMap<String, ArrayList<String>> k;
    private LinkedHashMap<String, ArrayList<String>> l;
    private LinkedHashMap<String, String> m;
    private String n;
    private String[] o;
    private String[] p;
    private String[] q;
    private Map<String, String[]> r;
    private long s;
    private ArrayList<String> t;
    private LinkedHashMap<String[], String> u;
    private LinkedHashMap<String, b> v;
    private LinkedHashMap<String, HashMap<String, String>> w;
    private LinkedHashMap<String, String[]> x;
    private HashMap<String, String> y;
    private HashMap<String, String> z;

    static class a {
        private static final f a = new f();
    }

    private String b(String str) {
        if (af.b(str)) {
            return "";
        }
        if (!af.a(str, "http://") && !af.a(str, "https://")) {
            str = "http://" + str;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean a(String str) {
        try {
            if (af.b(str)) {
                return false;
            }
            b(str);
            for (String str2 : this.p) {
                if (a(str, str2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            j.a(e2);
            return false;
        }
    }

    private f() {
        this.k = new LinkedHashMap<>();
        this.l = new LinkedHashMap<>();
        this.m = new LinkedHashMap<>();
        this.n = "";
        this.o = new String[0];
        this.p = new String[]{".*\\.jd\\.com.*$", ".*\\.jd\\.hk.*$", ".*\\.yiyaojd\\.com.*$", ".*\\.admaster\\.com\\.cn.*$"};
        this.q = new String[0];
        this.r = new HashMap();
        this.s = 10;
        this.t = new ArrayList<>();
        this.u = new LinkedHashMap<>();
        this.v = new LinkedHashMap<>();
        this.w = new LinkedHashMap<>();
        this.x = new LinkedHashMap<>();
        this.y = new HashMap<>();
        this.z = new HashMap<>();
        this.A = new ArrayList();
        this.B = new String[0];
        this.C = new String[0];
        this.D = new String[0];
        this.E = new ArrayList<>();
        this.e = new HashSet<>();
        this.g = new HashSet<>();
    }

    public static final f a() {
        return a.a;
    }

    public void a(final FaceCommonCallBack<Boolean> faceCommonCallBack) {
        final Context applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
        if (applicatonContext != null) {
            Hashtable hashtable = new Hashtable();
            x xVar = new x();
            hashtable.put("kepler_token", g.a().a(aa.a(), "kepler_token"));
            hashtable.put("kepler_devicemodel", ag.a(x.j(aa.a()) + "_" + x.k(aa.a())));
            hashtable.put("kepler_os", ag.a("android"));
            hashtable.put("kepler_osversion", ag.a(x.i(aa.a())));
            hashtable.put("kepler_appversion", ag.a(x.g(aa.a()) + "_" + x.h(aa.a())));
            hashtable.put("kepler_version", ag.a("3.0.1_254"));
            hashtable.put("kepler_imei", ag.a(xVar.b(aa.a())));
            hashtable.put("kepler_mac", ag.a(xVar.a(aa.a())));
            hashtable.put("kepler_appkey", e.a().b());
            hashtable.put("configid", "android_new");
            new q(new r("https://kepler.jd.com/console/admin/getConfigNew", hashtable, "get"), "getconfig", 19, new t() {
                /* class com.kepler.sdk.f.AnonymousClass1 */

                @Override // com.kepler.sdk.t
                public void a(s sVar) {
                    try {
                        f.this.a(new JSONObject(sVar.b()));
                        g.a().a(applicatonContext, "time", System.currentTimeMillis());
                        g.a().a(applicatonContext, "configm", sVar.b());
                        FaceCommonCallBack faceCommonCallBack = faceCommonCallBack;
                        if (faceCommonCallBack != null) {
                            faceCommonCallBack.callBack(true);
                        }
                    } catch (Throwable unused) {
                        f.this.a(applicatonContext);
                        FaceCommonCallBack faceCommonCallBack2 = faceCommonCallBack;
                        if (faceCommonCallBack2 != null) {
                            faceCommonCallBack2.callBack(false);
                        }
                    }
                }

                @Override // com.kepler.sdk.t
                public void a(int i, String str) {
                    FaceCommonCallBack faceCommonCallBack = faceCommonCallBack;
                    if (faceCommonCallBack != null) {
                        faceCommonCallBack.callBack(false);
                    }
                }
            }).c();
        } else if (faceCommonCallBack != null) {
            faceCommonCallBack.callBack(false);
        }
    }

    public boolean a(Context context) {
        try {
            String a2 = g.a().a(context, "configm");
            if (!TextUtils.isEmpty(a2)) {
                return a(new JSONObject(a2));
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(JSONObject jSONObject) {
        HashMap<String, String> hashMap;
        String[] split;
        JSONArray jSONArray;
        String[] split2;
        JSONArray jSONArray2;
        String[] split3;
        if (jSONObject == null) {
            return true;
        }
        try {
            LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
            LinkedHashMap<String, ArrayList<String>> linkedHashMap2 = new LinkedHashMap<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("from");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("url", "");
                        String optString2 = jSONObject2.optString("key", "");
                        if (optString2 != null && optString != null && !"".equals(optString) && !"".equals(optString2) && (split3 = optString2.split(",")) != null && split3.length > 0) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            jSONArray2 = optJSONArray;
                            for (String str : split3) {
                                arrayList.add(str);
                            }
                            linkedHashMap.put(optString, arrayList);
                            i2++;
                            optJSONArray = jSONArray2;
                        }
                    }
                    jSONArray2 = optJSONArray;
                    i2++;
                    optJSONArray = jSONArray2;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int i3 = 0;
                while (i3 < optJSONArray2.length()) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                    if (jSONObject3 != null) {
                        String optString3 = jSONObject3.optString("url", "");
                        String optString4 = jSONObject3.optString("key", "");
                        if (optString4 != null && optString3 != null && !"".equals(optString3) && !"".equals(optString4) && (split2 = optString4.split(",")) != null && split2.length > 0) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            jSONArray = optJSONArray2;
                            for (String str2 : split2) {
                                arrayList2.add(str2);
                            }
                            linkedHashMap2.put(optString3, arrayList2);
                            i3++;
                            optJSONArray2 = jSONArray;
                        }
                    }
                    jSONArray = optJSONArray2;
                    i3++;
                    optJSONArray2 = jSONArray;
                }
            }
            this.n = jSONObject.optString("payurl", "");
            this.s = jSONObject.optLong("timeout", this.s);
            ab.j = jSONObject.optString("tokenurl", ab.j);
            ab.g = jSONObject.optString("hoauth", ab.g);
            ab.u = jSONObject.optString("starturl", "");
            ab.m = jSONObject.optString("logout_200", ab.m);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("loginAuthArray_200");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                ab.l = new String[optJSONArray3.length()];
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    ab.l[i4] = optJSONArray3.getString(i4);
                }
            }
            ab.b = jSONObject.optString("isUseStatic_114", "1").equals("1");
            ab.c = "1".equals(jSONObject.optString("isUseCatchAbleSendBack_200", "1"));
            if (!i.a.booleanValue()) {
                i.a = Boolean.valueOf("1".equals(jSONObject.optString("isLog_136", "1")));
            }
            ab.i = jSONObject.optString("oauthCodeDoURL", "");
            ab.f = jSONObject.optString("url_add2Cart_130", ab.f);
            ab.o = jSONObject.optString("url_add2CartOpen_130", ab.o);
            ab.q = jSONObject.optString("url_feeLogin_134", ab.q);
            ab.h = jSONObject.optString("accessConfirmURL", "");
            ab.r = jSONObject.optString("UNPLjsURL_134", ab.r);
            ab.t = jSONObject.optString("SessionjsURL_134", ab.t);
            ab.s = jSONObject.optString("UNPLjdkeplerjsbridgejs", ab.t);
            this.b = true;
            String optString5 = jSONObject.optString("isUNPLjs_134", "1");
            if (!af.a(optString5)) {
                this.b = "1".equals(optString5);
            }
            this.c = true;
            if (!af.a(jSONObject.optString("isAppOpen_201", "1"))) {
                this.c = "1".equals(optString5);
            }
            this.a = jSONObject.optInt("UNPLjsLastTime_134", 10);
            this.h = jSONObject.optString("menu_search_url", "");
            this.i = jSONObject.optString("menu_recent_url", "");
            this.j = jSONObject.optString("menu_message_url", "");
            String optString6 = jSONObject.optString("blackUrl_130", "");
            if (optString6 != null && !"".equals(optString6)) {
                this.o = optString6.split(",");
            }
            String optString7 = jSONObject.optString("openJDAppWhiteList_200", "");
            if (optString7 == null || "".equals(optString7)) {
                this.p = ab.n;
            } else {
                this.p = optString7.split(",");
                int length = ab.n.length;
                for (int i5 = 0; i5 < length; i5++) {
                    ab.n[i5] = null;
                }
                ab.n = this.p;
            }
            String optString8 = jSONObject.optString("openJDAppBlackList_200", "");
            if (optString8 != null && !"".equals(optString8)) {
                this.q = optString8.split(",");
            }
            String optString9 = jSONObject.optString("select_more_keys_134", "");
            if (!af.c(optString9)) {
                this.f = optString9.split(",");
            }
            String optString10 = jSONObject.optString("black_key_exs", "");
            if (!af.c(optString10) && (split = optString10.split(",")) != null && split.length > 0) {
                this.e.clear();
                for (String str3 : split) {
                    this.e.add(str3);
                }
            }
            String optString11 = jSONObject.optString("loginout_clear_url_cookie", "");
            if (!af.c(optString11)) {
                this.C = optString11.split(",");
            }
            String optString12 = jSONObject.optString("cookies_domain", "jd.com,yiyaojd.com,360buy.com,jd.hk");
            if (!af.c(optString11)) {
                this.D = optString12.split(",");
            }
            this.r.clear();
            JSONArray jSONArray3 = jSONObject.getJSONArray("addparmer_132");
            if (jSONArray3 != null) {
                for (int i6 = 0; i6 < jSONArray3.length(); i6++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i6);
                    String optString13 = jSONObject4.optString("key", "");
                    String optString14 = jSONObject4.optString("urls", "");
                    if (!af.c(optString13) && !af.c(optString14)) {
                        this.r.put(optString13, optString14.split(","));
                    }
                }
            }
            String optString15 = jSONObject.optString("androidNoCheckUrls", "");
            if (!af.c(optString15)) {
                this.B = optString15.split(",");
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray("getskuurl");
            if (jSONArray4 != null) {
                for (int i7 = 0; i7 < jSONArray4.length(); i7++) {
                    JSONObject jSONObject5 = jSONArray4.getJSONObject(i7);
                    this.y.put(jSONObject5.optString("url", ""), jSONObject5.optString("param", ""));
                    this.z.put(jSONObject5.optString("url", ""), jSONObject5.optString("type", ""));
                }
            }
            JSONArray jSONArray5 = jSONObject.getJSONArray("get_url_name");
            if (jSONArray5 != null) {
                this.E.clear();
                int i8 = 0;
                while (i8 < jSONArray5.length()) {
                    JSONObject jSONObject6 = jSONArray5.getJSONObject(i8);
                    this.E.add(new k(jSONObject6.optString("show_name", ""), jSONObject6.optInt("type", 0), jSONObject6.optString("url", "")));
                    i8++;
                    jSONArray5 = jSONArray5;
                    linkedHashMap2 = linkedHashMap2;
                }
            }
            JSONArray jSONArray6 = jSONObject.getJSONArray("jump_114");
            if (jSONArray6 != null) {
                this.v.clear();
                this.w.clear();
                int i9 = 0;
                while (i9 < jSONArray6.length()) {
                    JSONObject jSONObject7 = jSONArray6.getJSONObject(i9);
                    String optString16 = jSONObject7.optString("fromRule_132", "");
                    this.v.put(optString16, new b(jSONObject7.optString("to", ""), "1".equals(jSONObject7.optString("isNeedParam", "")), jSONObject7.optString("encode", null)));
                    JSONArray optJSONArray4 = jSONObject7.optJSONArray("replaceList");
                    if (optJSONArray4 != null) {
                        hashMap = new HashMap<>();
                        for (int i10 = 0; i10 < optJSONArray4.length(); i10++) {
                            hashMap.put(optJSONArray4.getJSONObject(i10).optString("replace"), optJSONArray4.getJSONObject(i10).optString("to"));
                        }
                    } else {
                        hashMap = null;
                    }
                    if (!TextUtils.isEmpty(optString16)) {
                        this.w.put(optString16, hashMap);
                    }
                    i9++;
                    jSONArray6 = jSONArray6;
                }
            }
            JSONArray jSONArray7 = jSONObject.getJSONArray("jumpurl");
            if (jSONArray7 != null) {
                this.x.clear();
                for (int i11 = 0; i11 < jSONArray7.length(); i11++) {
                    JSONObject jSONObject8 = jSONArray7.getJSONObject(i11);
                    String optString17 = jSONObject8.optString("current_nobacks_132");
                    this.x.put(jSONObject8.optString("url"), !af.c(optString17) ? optString17.split(",") : null);
                }
            }
            JSONArray jSONArray8 = jSONObject.getJSONArray("insertjs");
            if (jSONArray8 != null) {
                this.u.clear();
                for (int i12 = 0; i12 < jSONArray8.length(); i12++) {
                    JSONObject jSONObject9 = jSONArray8.getJSONObject(i12);
                    String optString18 = jSONObject9.optString("url", "");
                    String optString19 = jSONObject9.optString("js", "");
                    String[] strArr = new String[0];
                    if (optString18 != null && !"".equals(optString18)) {
                        strArr = optString18.split(",");
                    }
                    this.u.put(strArr, optString19);
                }
            }
            JSONArray jSONArray9 = jSONObject.getJSONArray("hideCloseBtn_114");
            this.A.clear();
            if (!(jSONArray9 == null || this.A == null)) {
                for (int i13 = 0; i13 < jSONArray9.length(); i13++) {
                    this.A.add(jSONArray9.getJSONObject(i13).optString("url"));
                }
            }
            this.A.add(this.n);
            this.k = linkedHashMap;
            this.l = linkedHashMap2;
            this.d = true;
            return true;
        } catch (Throwable th) {
            j.a(th, "kepler config load ");
            return false;
        }
    }

    public boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static class b {
        public String a;
        public String b;
        public boolean c;

        public b(String str, boolean z, String str2) {
            this.a = str;
            this.c = z;
            this.b = str2;
        }
    }

    public long b() {
        return this.s;
    }
}
