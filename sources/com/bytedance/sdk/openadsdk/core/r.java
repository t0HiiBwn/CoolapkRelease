package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.h.f;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.i.g.d;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetApiImpl */
public class r implements q<com.bytedance.sdk.openadsdk.c.a> {
    private static String a = null;
    private static boolean g = true;
    private final Context b;
    private final boolean c = g();
    private final String d = j();
    private long e;
    private int f;

    private int a(int i) {
        return 10000;
    }

    private static String b(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    r(Context context) {
        this.b = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e5 A[Catch:{ Exception -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x016e A[Catch:{ Exception -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0172 A[Catch:{ Exception -> 0x01b9 }] */
    private JSONObject a(AdSlot adSlot, m mVar, int i, boolean z) {
        String str;
        JSONObject jSONObject;
        JSONObject d2;
        JSONObject jSONObject2;
        String g2;
        String h;
        String str2 = "";
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObject4 = new JSONObject();
            if (mVar != null) {
                if (!TextUtils.isEmpty(mVar.a)) {
                    str = mVar.a;
                    if (i != 7) {
                        if (mVar != null && mVar.b > 0) {
                            jSONObject4.put("req_type", mVar.b);
                        }
                    } else if (i == 8 && mVar != null && mVar.c > 0) {
                        jSONObject4.put("req_type", mVar.c);
                    }
                    g2 = p.h().g();
                    h = p.h().h();
                    String u = i.d().u();
                    if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h)) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("version", g2);
                        if (adSlot == null) {
                            jSONObject5.put("external_ab_vid", d.a(adSlot.getExternalABVid()));
                            StringBuilder sb = new StringBuilder();
                            jSONObject = jSONObject3;
                            try {
                                sb.append("external_ab_vid ");
                                sb.append(d.a(adSlot.getExternalABVid()));
                                u.f("NetApiImpl", sb.toString());
                            } catch (Throwable unused) {
                            }
                        } else {
                            jSONObject = jSONObject3;
                        }
                        jSONObject5.put("param", h);
                        jSONObject5.put("tob_ab_sdk_version", u);
                        jSONObject4.put("abtest", jSONObject5);
                        jSONObject4.put("request_id", str);
                        jSONObject4.put("ad_sdk_version", "3.4.1.2");
                        jSONObject4.put("source_type", "app");
                        jSONObject4.put("logsdk_version", AppLog.getHeaderValue("sdk_version_name", str2));
                        jSONObject4.put("app", b());
                        d2 = i.d(this.b);
                        if (d2 != null) {
                            if (!p.h().w() && !g.b()) {
                                d2.remove("free_space");
                            }
                            if (adSlot != null && adSlot.getOrientation() > 0) {
                                d2.put("orientation", adSlot.getOrientation());
                            }
                        }
                        jSONObject4.put("device", d2);
                        jSONObject4.put("user", d());
                        jSONObject4.put("ua", aj.b());
                        jSONObject4.put("ip", e());
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(a(adSlot, i, mVar));
                        jSONObject4.put("adslots", jSONArray);
                        a(jSONObject4, mVar);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        jSONObject4.put("ts", currentTimeMillis);
                        if (!(adSlot.getCodeId() == null || str == null)) {
                            str2 = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(str);
                        }
                        jSONObject4.put("req_sign", j.a(str2));
                        if (z) {
                            jSONObject4.put("ad_sdk_version", "3.4.1.2");
                            return jSONObject4;
                        }
                        String k = k();
                        String a2 = a.a(jSONObject4.toString(), f(k));
                        String str3 = 2 + k + a2;
                        if (c(a2)) {
                            jSONObject2 = jSONObject;
                            try {
                                jSONObject2.put("message", str3);
                                jSONObject2.put("cypher", 2);
                            } catch (Exception unused2) {
                                return jSONObject2;
                            }
                        } else {
                            jSONObject2 = jSONObject;
                            jSONObject2.put("message", jSONObject4.toString());
                            jSONObject2.put("cypher", 0);
                        }
                        jSONObject2.put("ad_sdk_version", "3.4.1.2");
                        return jSONObject2;
                    }
                    jSONObject = jSONObject3;
                    jSONObject4.put("request_id", str);
                    jSONObject4.put("ad_sdk_version", "3.4.1.2");
                    jSONObject4.put("source_type", "app");
                    jSONObject4.put("logsdk_version", AppLog.getHeaderValue("sdk_version_name", str2));
                    jSONObject4.put("app", b());
                    d2 = i.d(this.b);
                    if (d2 != null) {
                    }
                    jSONObject4.put("device", d2);
                    jSONObject4.put("user", d());
                    jSONObject4.put("ua", aj.b());
                    jSONObject4.put("ip", e());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(a(adSlot, i, mVar));
                    jSONObject4.put("adslots", jSONArray);
                    a(jSONObject4, mVar);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    jSONObject4.put("ts", currentTimeMillis);
                    str2 = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(str);
                    jSONObject4.put("req_sign", j.a(str2));
                    if (z) {
                    }
                }
            }
            str = aj.c();
            if (i != 7) {
            }
            try {
                g2 = p.h().g();
                h = p.h().h();
                String u = i.d().u();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("version", g2);
                if (adSlot == null) {
                }
                jSONObject5.put("param", h);
                jSONObject5.put("tob_ab_sdk_version", u);
                jSONObject4.put("abtest", jSONObject5);
            } catch (Throwable unused3) {
            }
            try {
                jSONObject4.put("request_id", str);
                jSONObject4.put("ad_sdk_version", "3.4.1.2");
                jSONObject4.put("source_type", "app");
                jSONObject4.put("logsdk_version", AppLog.getHeaderValue("sdk_version_name", str2));
                jSONObject4.put("app", b());
                d2 = i.d(this.b);
                if (d2 != null) {
                }
                jSONObject4.put("device", d2);
                jSONObject4.put("user", d());
                jSONObject4.put("ua", aj.b());
                jSONObject4.put("ip", e());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a(adSlot, i, mVar));
                jSONObject4.put("adslots", jSONArray);
                a(jSONObject4, mVar);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                jSONObject4.put("ts", currentTimeMillis);
                str2 = String.valueOf(currentTimeMillis).concat(adSlot.getCodeId()).concat(str);
                jSONObject4.put("req_sign", j.a(str2));
                if (z) {
                }
            } catch (Exception unused4) {
                return jSONObject;
            }
        } catch (Exception unused5) {
            return jSONObject3;
        }
    }

    private void a(JSONObject jSONObject, m mVar) {
        if (mVar != null && mVar.d != null) {
            try {
                jSONObject.put("source_temai_product_ids", mVar.d);
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            return false;
        }
        String b2 = com.bytedance.sdk.openadsdk.core.b.b.b();
        if (!TextUtils.isEmpty(b2)) {
            com.bytedance.sdk.openadsdk.c.d.a(this.b, b2, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(final AdSlot adSlot, final m mVar, final int i, final q.b bVar) {
        String str;
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            f.a((com.bytedance.sdk.openadsdk.core.h.c) null).c();
            com.bytedance.sdk.openadsdk.core.h.d.a().b();
            com.bytedance.sdk.openadsdk.core.h.b.a().b();
            e.a().c();
            if (bVar != null) {
                if (a(adSlot.getCodeId())) {
                    bVar.a(-8, h.a(-8));
                } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    u.b("bidding", "getAd bidAdm有效，则直接解析返回广告：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.i.g.b.a(adSlot.getBidAdm()));
                    try {
                        JSONObject e2 = e(new JSONObject(adSlot.getBidAdm()));
                        if (e2 == null) {
                            a(bVar);
                            return;
                        }
                        a a2 = a.a(e2, adSlot, mVar);
                        k.a(this.b, a2.i);
                        if (a2.d != 20000) {
                            bVar.a(a2.d, a2.e);
                        } else if (a2.h == null) {
                            a(bVar);
                        } else {
                            a2.h.c(e2.toString());
                            bVar.a(a2.h);
                        }
                    } catch (Throwable th) {
                        u.c("NetApiImpl", "get ad error: ", th);
                        a(bVar);
                    }
                } else {
                    final JSONObject a3 = a(adSlot, mVar, i, false);
                    if (a3 == null) {
                        bVar.a(-9, h.a(-9));
                        return;
                    }
                    String l = aj.l("/api/ad/union/sdk/get_ads/");
                    try {
                        if (b(adSlot.getExtraSmartLookParam()) && !TextUtils.isEmpty(a)) {
                            if (i != 4) {
                                l = a;
                            } else {
                                return;
                            }
                        }
                        str = l;
                    } catch (Throwable unused) {
                        str = aj.l("/api/ad/union/sdk/get_ads/");
                    }
                    new com.bytedance.sdk.adnet.b.f(1, str, new m.a<JSONObject>() {
                        /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass1 */

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                            boolean z;
                            long j;
                            try {
                                j = ((Long) mVar.a("extra_time_start")).longValue();
                                z = true;
                            } catch (Throwable unused) {
                                j = 0;
                                z = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject e2 = r.this.e((JSONObject) mVar.a);
                            if (e2 == null) {
                                r.this.a(bVar);
                                r.this.a(mVar.e, adSlot.getCodeId(), i, null, -1, "mate parse_fail");
                                return;
                            }
                            try {
                                a a2 = a.a(e2, adSlot, mVar);
                                k.a(r.this.b, a2.i);
                                if (a2.d != 20000) {
                                    bVar.a(a2.d, a2.e);
                                    r.this.a(mVar.e, adSlot.getCodeId(), i, a2, a2.d, String.valueOf(a2.f));
                                } else if (a2.h == null) {
                                    r.this.a(bVar);
                                    r.this.a(mVar.e, adSlot.getCodeId(), i, a2, -1, "parse_fail");
                                } else {
                                    a2.h.c(e2.toString());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    bVar.a(a2.h);
                                    Map<String, l> a3 = com.bytedance.sdk.openadsdk.core.d.a.a(a2.h);
                                    if (a3 != null) {
                                        com.bytedance.sdk.openadsdk.gecko.a.a().a(a3);
                                    }
                                    if (z && a2.h.c() != null && !a2.h.c().isEmpty()) {
                                        l lVar = a2.h.c().get(0);
                                        String b2 = aj.b(i);
                                        HashMap hashMap = new HashMap();
                                        com.bytedance.sdk.openadsdk.core.d.m mVar2 = mVar;
                                        if (mVar2 != null && mVar2.f > 0) {
                                            hashMap.put("client_start_time", Long.valueOf(j - mVar.f));
                                            hashMap.put("load_ts", Long.valueOf(mVar.f));
                                            hashMap.put("total_time", Long.valueOf(currentTimeMillis2 - mVar.f));
                                        }
                                        hashMap.put("request_ts", Long.valueOf(j));
                                        hashMap.put("s_revice_ts", Long.valueOf(a2.b));
                                        hashMap.put("s_send_ts", Long.valueOf(a2.c));
                                        hashMap.put("c_revice_ts", Long.valueOf(currentTimeMillis));
                                        hashMap.put("c_end_ts", Long.valueOf(currentTimeMillis2));
                                        hashMap.put("network_time", Long.valueOf(mVar.f));
                                        hashMap.put("go_time", Long.valueOf(a2.b - j));
                                        hashMap.put("sever_time", Integer.valueOf(a2.a));
                                        hashMap.put("back_time", Long.valueOf(currentTimeMillis - a2.c));
                                        hashMap.put("client_end_time", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                                        com.bytedance.sdk.openadsdk.c.d.a(lVar, b2, hashMap);
                                    }
                                }
                            } catch (Throwable th) {
                                u.c("NetApiImpl", "get ad error: ", th);
                                r.this.a(bVar);
                                r.this.a(mVar.e, adSlot.getCodeId(), i, null, -1, "parse_fail");
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                            int i;
                            VAdError vAdError = mVar.c;
                            if (vAdError instanceof e) {
                                r.this.a(bVar);
                                r.this.a(mVar.e, adSlot.getCodeId(), i, null, -1, h.a(-1));
                                return;
                            }
                            String a2 = h.a(-2);
                            if (vAdError == null || mVar == null) {
                                i = -2;
                            } else {
                                a2 = vAdError.getMessage();
                                i = (int) mVar.h;
                            }
                            bVar.a(i, a2);
                            r.this.a(mVar.e, adSlot.getCodeId(), i, null, i, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : a2);
                        }
                    }, a3) {
                        /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass2 */

                        @Override // com.bytedance.sdk.adnet.core.Request
                        public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ss-sign", s.b(k.a(r.this.b)).d(a3.toString()));
                            return hashMap;
                        }
                    }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(a(i)).b(0)).setUserAgent(aj.b()).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).e());
                }
            }
        } else if (bVar != null) {
            bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
        }
    }

    private boolean b(String str) {
        try {
            String k = aj.k(str);
            JSONObject jSONObject = !TextUtils.isEmpty(k) ? new JSONObject(k) : null;
            if (jSONObject == null || jSONObject.getJSONObject("smart_look") == null || jSONObject.getString("smart_look_url") == null) {
                return false;
            }
            a = com.bytedance.sdk.openadsdk.multipro.c.b(jSONObject.getString("smart_look_url"));
            return true;
        } catch (Exception e2) {
            u.b("TTMediationSDK", "NetApiImpl-->异常：" + e2.toString());
            return false;
        }
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad  */
    public void a(long j, String str, int i, a aVar, int i2, String str2) {
        String str3;
        String str4;
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (i == 4 || i == 3) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = h.a(i2);
                }
                com.bytedance.sdk.openadsdk.g.a.b bVar = (com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) new com.bytedance.sdk.openadsdk.g.a.b().a(i)).b(i2)).g(str2);
                l lVar = null;
                String str5 = "";
                if (aVar != null) {
                    try {
                        if (!(aVar.h == null || aVar.h.c() == null || aVar.h.c().size() <= 0)) {
                            lVar = aVar.h.c().get(0);
                            str4 = lVar.aj();
                            if (!TextUtils.isEmpty(str4)) {
                                try {
                                    str3 = new JSONObject(str4).getString("req_id");
                                } catch (Throwable unused) {
                                }
                                if (!(!TextUtils.isEmpty(str3) || aVar == null || aVar.h == null)) {
                                    str3 = aVar.h.a();
                                }
                                com.bytedance.sdk.openadsdk.g.a.b bVar2 = (com.bytedance.sdk.openadsdk.g.a.b) bVar.f(str3);
                                if (lVar != null) {
                                    str5 = lVar.ag();
                                }
                                ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) bVar2.d(str5)).h(str4)).c(str)).a(j).b(aVar != null ? (long) aVar.a : 0);
                                com.bytedance.sdk.openadsdk.g.a.a().e(bVar);
                            }
                            str3 = str5;
                            str3 = aVar.h.a();
                            com.bytedance.sdk.openadsdk.g.a.b bVar2 = (com.bytedance.sdk.openadsdk.g.a.b) bVar.f(str3);
                            if (lVar != null) {
                            }
                            ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) bVar2.d(str5)).h(str4)).c(str)).a(j).b(aVar != null ? (long) aVar.a : 0);
                            com.bytedance.sdk.openadsdk.g.a.a().e(bVar);
                        }
                    } catch (Throwable th) {
                        u.c("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                    }
                }
                str4 = str5;
                str3 = str4;
                str3 = aVar.h.a();
                com.bytedance.sdk.openadsdk.g.a.b bVar2 = (com.bytedance.sdk.openadsdk.g.a.b) bVar.f(str3);
                if (lVar != null) {
                }
                ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) ((com.bytedance.sdk.openadsdk.g.a.b) bVar2.d(str5)).h(str4)).c(str)).a(j).b(aVar != null ? (long) aVar.a : 0);
                com.bytedance.sdk.openadsdk.g.a.a().e(bVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        try {
            com.bytedance.sdk.adnet.core.m mVar = null;
            if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                a(list.get(0));
                jSONObject.put("header", f());
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.c.a aVar : list) {
                    jSONArray.put(aVar.b);
                }
                jSONObject.put("event", jSONArray);
                jSONObject.put("_gen_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String a2 = a.a(jSONObject.toString(), b.b());
            if (!c(a2)) {
                a2 = jSONObject.toString();
            }
            if (u.c()) {
                u.b("adevent", "adevent is :" + jSONObject.toString());
            }
            final Map<String, String> e2 = e(a2);
            com.bytedance.sdk.adnet.b.i a3 = com.bytedance.sdk.adnet.b.i.a();
            new com.bytedance.sdk.adnet.b.f(1, aj.h(), a2, a3) {
                /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass3 */

                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return e2;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
            try {
                mVar = a3.get();
            } catch (Throwable unused2) {
            }
            boolean z = true;
            boolean z2 = mVar != null && b(mVar.a);
            String str = "error unknown";
            int i = mVar != null ? (int) mVar.h : 0;
            if (z2 || i != 200) {
                if (!(mVar == null || mVar.c == null)) {
                    str = mVar.c.getMessage();
                }
                z = false;
            } else {
                str = "server say not success";
            }
            d(a2);
            return new h(z2, i, str, z);
        } catch (Throwable th) {
            u.c("NetApiImpl", "uploadEvent error", th);
            return new h(false, 509, "service_busy", false);
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && i.d().v()) {
            final Map<String, String> e2 = e(str);
            new com.bytedance.sdk.adnet.b.f(1, aj.i(), str, com.bytedance.sdk.adnet.b.i.a()) {
                /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass4 */

                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return e2;
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(l lVar, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && (b2 = b(lVar, list)) != null) {
            new com.bytedance.sdk.adnet.b.h(1, aj.l("/api/ad/union/dislike_event/"), aj.a(b2), null).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    private JSONObject b(l lVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.4.1.2");
            if (a2 != null) {
                jSONObject2.put("latitude", (double) a2.a);
                jSONObject2.put("longitude", (double) a2.b);
            }
            if (lVar != null) {
                jSONObject2.put("extra", lVar.aj());
                if (lVar.y() == null) {
                    lVar.c("other");
                }
                jSONObject2.put("dislike_source", lVar.y());
            }
            String b2 = b(list);
            if (b2 != null) {
                jSONObject2.put("comment", b2);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", c(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
            PersonalizationPrompt am = lVar.am();
            if (am != null) {
                jSONObject2.put("personalization_prompts", am.toJson());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String b(List<FilterWord> list) {
        if (list.get(0).getId().equals("0:00")) {
            return list.get(0).getName();
        }
        return null;
    }

    private JSONArray c(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord filterWord : list) {
            jSONArray.put(filterWord.getId());
        }
        return jSONArray;
    }

    private Map<String, String> e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (c(str)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(q.b bVar) {
        bVar.a(-1, h.a(-1));
    }

    /* access modifiers changed from: private */
    public void a(q.c cVar) {
        cVar.a(-1, h.a(-1));
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", i.d().f());
            jSONObject.put("name", i.d().g());
            c(jSONObject);
            d(jSONObject);
            jSONObject.put("is_paid_app", i.d().h());
            jSONObject.put("apk_sign", s.b(k.a(this.b)).b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String c() {
        return i.a();
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, "keywords", i.d().i());
            JSONArray a2 = com.bytedance.sdk.openadsdk.utils.q.a(this.b);
            if (a2 != null) {
                jSONObject.put("app_list", a2);
            }
            a(jSONObject, "data", i.d().j());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", aj.e());
            jSONObject.put("version_code", aj.f());
            jSONObject.put("version", aj.g());
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(this.b);
        if (a2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", (double) a2.a);
                jSONObject2.put("longitude", (double) a2.b);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String e() {
        return i.a(true);
    }

    private JSONObject a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", adSlot.getCodeId());
            jSONObject2.put("prime_rit", adSlot.getPrimeRit());
            jSONObject2.put("show_seq", adSlot.getAdloadSeq());
            jSONObject2.put("adtype", i);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId())) {
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject3.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject3.put("creative_id", adSlot.getCreativeId());
                }
                jSONObject2.put("preview_ads", jSONObject3);
            }
            int i2 = 1;
            if (mVar != null) {
                if (i == 3 || i == 4) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("publisher_timeout_control", mVar.g);
                    jSONObject4.put("time_out_control", mVar.h);
                    jSONObject4.put("time_out", mVar.i);
                    jSONObject2.put("tmax", jSONObject4);
                }
                jSONObject2.put("render_method", mVar.e);
                if (mVar.e == 1) {
                    a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (mVar.e == 2) {
                    a(jSONObject2, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject2.put("render_method", 1);
                a(jSONObject2, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject2.put("ptpl_ids", p.h().h(adSlot.getCodeId()));
            jSONObject2.put("pos", AdSlot.getPosition(i));
            jSONObject2.put("is_support_dpl", adSlot.isSupportDeepLink());
            jSONObject2.put("if_support_render_control", adSlot.isSupportRenderConrol() ? 1 : 0);
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject2.put("is_origin_ad", true);
            }
            if (!(mVar == null || mVar.j == null)) {
                jSONObject2.put("session_params", mVar.j);
            }
            int adCount = adSlot.getAdCount();
            if (!(i == 7 || i == 8)) {
                i2 = adCount;
            }
            if (!(mVar == null || mVar.d == null)) {
                i2 = adSlot.getAdCount();
            }
            jSONObject2.put("ad_count", i2);
            String k = aj.k(adSlot.getExtraSmartLookParam());
            JSONObject jSONObject5 = null;
            if (!TextUtils.isEmpty(k)) {
                jSONObject5 = new JSONObject(k);
            }
            if (!(jSONObject5 == null || (jSONObject = jSONObject5.getJSONObject("smart_look")) == null || TextUtils.isEmpty(jSONObject.toString()))) {
                jSONObject2.put("smart_look", jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    private void a(JSONObject jSONObject, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private void a(JSONObject jSONObject, String str, float f2, float f3) {
        if (f2 > 0.0f && f3 >= 0.0f) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", (int) f2);
                jSONObject2.put("height", (int) f3);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        if (aVar != null && aVar.b != null) {
            String optString = aVar.b.optString("log_extra", "");
            long e2 = aj.e(optString);
            int f2 = aj.f(optString);
            if (e2 == 0) {
                e2 = this.e;
            }
            this.e = e2;
            if (f2 == 0) {
                f2 = this.f;
            }
            this.f = f2;
        }
    }

    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", aj.b());
            jSONObject.put("udid", k.d(this.b));
            jSONObject.put("openudid", k.c(this.b));
            jSONObject.put("oaid", y.a());
            jSONObject.put("ad_sdk_version", "3.4.1.2");
            jSONObject.put("sim_op", a(this.b));
            jSONObject.put("root", this.c ? 1 : 0);
            jSONObject.put("timezone", i());
            jSONObject.put("access", x.f(this.b));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.d);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ak.d(this.b) + "x" + ak.c(this.b));
            jSONObject.put("display_density", b(ak.f(this.b)));
            jSONObject.put("density_dpi", ak.f(this.b));
            jSONObject.put("mc", c());
            jSONObject.put("device_id", k.a(this.b));
            jSONObject.put("aid", "1371");
            jSONObject.put("rom", h());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", k.i(this.b));
            jSONObject.put("ut", this.f);
            jSONObject.put("uid", this.e);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static boolean g() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String h() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ad.e()) {
                sb.append("MIUI-");
            } else if (ad.b()) {
                sb.append("FLYME-");
            } else {
                String n = ad.n();
                if (ad.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static int i() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String j() {
        if (i.b(this.b)) {
            return "tv";
        }
        return i.a(this.b) ? "android_pad" : "android";
    }

    private String k() {
        String a2 = a.a();
        return a2 == null ? b.a() : a2;
    }

    private String f(String str) {
        String a2 = a.a(str);
        if (str != null) {
            return a2;
        }
        String a3 = b.a();
        return a3.concat(a3).substring(8, 24);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    public JSONObject e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            if (g) {
                int optInt = jSONObject.optInt("cypher", -1);
                String optString = jSONObject.optString("message");
                String b2 = optInt == 1 ? a.b(optString, b.a()) : optString;
                if (optInt == 2 && !TextUtils.isEmpty(optString) && optString.length() >= 17) {
                    b2 = a.b(optString.substring(17), f(optString.substring(1, 17)));
                }
                if (!TextUtils.isEmpty(b2)) {
                    jSONObject2 = new JSONObject(b2);
                    return !g ? jSONObject2 : jSONObject;
                }
            }
        } catch (Exception unused) {
        }
        jSONObject2 = jSONObject;
        if (!g) {
        }
    }

    /* compiled from: NetApiImpl */
    public static class a {
        final int a;
        final long b;
        final long c;
        final int d;
        final String e;
        final int f;
        final String g;
        public final com.bytedance.sdk.openadsdk.core.d.a h;
        final String i;

        private a(String str, int i2, int i3, String str2, int i4, String str3, com.bytedance.sdk.openadsdk.core.d.a aVar, long j, long j2) {
            this.a = i2;
            this.d = i3;
            this.e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f = i4;
            this.b = j;
            this.c = j2;
        }

        public static a a(JSONObject jSONObject) {
            return a(jSONObject, null, null);
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt("reason");
            com.bytedance.sdk.openadsdk.core.d.a a2 = c.a(jSONObject, adSlot, mVar);
            if (a2 != null) {
                a2.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, a2, optLong, optLong2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(JSONObject jSONObject, final q.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (cVar != null) {
                cVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else if (jSONObject != null && cVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/reward_video/reward/"), aj.a(jSONObject), new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass5 */

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v11, types: [org.json.JSONObject] */
                /* JADX WARNING: Unknown variable types count: 1 */
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    if (mVar == null || mVar.a == null) {
                        r.this.a(cVar);
                        return;
                    }
                    int optInt = mVar.a.optInt("cypher", -1);
                    String optString = mVar.a.optString("message");
                    T t = mVar.a;
                    String str = null;
                    if (optInt == 1) {
                        str = a.b(optString, b.a());
                    } else if (optInt == 2) {
                        str = aj.k(optString);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            t = new JSONObject(str);
                        } catch (Throwable unused) {
                        }
                    }
                    c a2 = c.a(t);
                    if (a2.a != 20000) {
                        cVar.a(a2.a, h.a(a2.a));
                    } else if (a2.c == null) {
                        r.this.a(cVar);
                    } else {
                        cVar.a(a2);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    int i = -2;
                    String a2 = h.a(-2);
                    if (mVar != null) {
                        i = (int) mVar.h;
                    }
                    if (!(mVar == null || mVar.c == null || TextUtils.isEmpty(mVar.c.getMessage()))) {
                        a2 = mVar.c.getMessage();
                    }
                    cVar.a(i, a2);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    /* compiled from: NetApiImpl */
    public static class c {
        public final int a;
        public final boolean b;
        public final s c;

        private c(int i, boolean z, s sVar) {
            this.a = i;
            this.b = z;
            this.c = sVar;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            s sVar = new s();
            if (optJSONObject != null) {
                try {
                    sVar.a(optJSONObject.optInt("reason"));
                    sVar.b(optJSONObject.optInt("corp_type"));
                    sVar.c(optJSONObject.optInt("reward_amount"));
                    sVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new c(optInt, optBoolean, sVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public String a(AdSlot adSlot, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
        if (7 == adSlot.getAdType()) {
            mVar.b = 1;
        } else if (8 == adSlot.getAdType()) {
            mVar.c = 1;
        } else if (3 == adSlot.getAdType()) {
            mVar.f = System.currentTimeMillis();
        }
        if (p.h().i(adSlot.getCodeId())) {
            mVar.e = 2;
        }
        if (z) {
            mVar.e = 2;
            if (i == 1 || i == 2) {
                adSlot.setNativeAdType(i);
            }
        }
        if (5 == adSlot.getNativeAdType() || 1 == adSlot.getNativeAdType() || 2 == adSlot.getNativeAdType()) {
            mVar.e = 2;
        }
        if (adSlot.getAdType() > 0) {
            i = adSlot.getAdType();
        } else if (i <= 0) {
            i = 0;
        }
        JSONObject a2 = a(adSlot, mVar, i, true);
        u.c("token", "requestBody=" + a2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("ss-sign", s.b(k.a(this.b)).d(a2.toString()));
            jSONObject2.putOpt("User-Agent", aj.b());
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        u.c("token", "message=" + jSONObject);
        String k = k();
        String str = 2 + k + a.a(jSONObject.toString(), f(k));
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("message", str);
            jSONObject3.put("cypher", 2);
            u.c("token", "result=" + jSONObject3.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return "0000000002" + str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public String a(AdSlot adSlot) {
        return a(adSlot, false, -1);
    }

    private JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a2 = a.a(str, b.a());
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = j.a("id=" + a2 + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put("id", a2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public void a(String str, String str2, final q.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            if (aVar != null) {
                aVar.a(false, -1, 0);
            }
        } else if (str != null && str2 != null && aVar != null) {
            new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/material/check/"), aj.a(a(str, str2)), new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.r.AnonymousClass6 */

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    long j;
                    long j2;
                    boolean z;
                    if (mVar.a != null) {
                        b a2 = b.a(mVar.a);
                        long j3 = mVar.f;
                        z = a2.b;
                        j2 = (long) a2.a;
                        j = j3;
                    } else {
                        j2 = -1;
                        j = 0;
                        z = false;
                    }
                    aVar.a(z, j2, j);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    aVar.a(false, mVar.h != 0 ? mVar.h : -1, mVar.f);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(800)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public h a(JSONObject jSONObject) {
        boolean z;
        int i;
        int i2;
        if (!com.bytedance.sdk.openadsdk.core.h.g.a() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.adnet.b.i a2 = com.bytedance.sdk.adnet.b.i.a();
        boolean z2 = true;
        new com.bytedance.sdk.adnet.b.f(1, aj.l("/api/ad/union/sdk/stats/batch/"), aj.a(jSONObject), a2).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).setUserAgent(aj.b()).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        String str = "error unknown";
        boolean z3 = false;
        try {
            com.bytedance.sdk.adnet.core.m b2 = a2.get();
            if (b2 == null) {
                return new h(false, 0, str, false);
            }
            if (b2.a != null) {
                int optInt = b2.a.optInt("code", -1);
                str = b2.a.optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            } else {
                z2 = false;
                z = false;
            }
            try {
                i = (int) b2.h;
                try {
                    if (b2.c != null) {
                        str = b2.c.getMessage();
                    }
                } catch (Throwable unused) {
                    i2 = i;
                    z3 = z;
                    z = z3;
                    i = i2;
                    return new h(z, i, str, z2);
                }
            } catch (Throwable unused2) {
                z3 = z;
                i2 = 0;
                z = z3;
                i = i2;
                return new h(z, i, str, z2);
            }
            return new h(z, i, str, z2);
        } catch (Throwable unused3) {
            i2 = 0;
            z2 = false;
            z = z3;
            i = i2;
            return new h(z, i, str, z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public boolean a(JSONObject jSONObject, int i) {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return false;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return true;
        }
        com.bytedance.sdk.adnet.b.i a2 = com.bytedance.sdk.adnet.b.i.a();
        new com.bytedance.sdk.adnet.b.f(1, ai.b("https://i.snssdk.com/inspect/aegis/client/page/"), jSONObject, a2).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000).b(i)).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        try {
            com.bytedance.sdk.adnet.core.m b2 = a2.get();
            if (b2 == null || b2.a == null) {
                return false;
            }
            return "success".equals(b2.a.optString("status", "success"));
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.q
    public com.bytedance.sdk.openadsdk.core.d.q a() {
        com.bytedance.sdk.adnet.core.m mVar;
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return null;
        }
        com.bytedance.sdk.adnet.b.i a2 = com.bytedance.sdk.adnet.b.i.a();
        new com.bytedance.sdk.adnet.b.j(0, ai.b(p.h().z()), a2).setRetryPolicy(com.bytedance.sdk.openadsdk.h.d.b().a(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.h.d.a(this.b).d());
        try {
            mVar = a2.get();
        } catch (Exception unused) {
            mVar = null;
        }
        if (mVar == null || !mVar.a()) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.core.d.q.e(mVar.a);
    }

    /* compiled from: NetApiImpl */
    public static class b {
        public final int a;
        public final boolean b;

        private b(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
