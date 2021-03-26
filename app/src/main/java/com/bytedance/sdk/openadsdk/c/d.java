package com.bytedance.sdk.openadsdk.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventManager */
public class d {
    public static void a(l lVar) {
    }

    public static void a(Context context, l lVar, String str, Map<String, Object> map) {
        if (!a(str, lVar)) {
            Context a2 = context == null ? p.a() : context;
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", i.d(a2).toString());
                jSONObject2.put("is_cache", lVar.aq() ? 1 : 0);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                ak.a(jSONObject2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.putOpt("log_extra", lVar.aj());
                float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - aj.g(lVar.aj())).floatValue();
                if (floatValue <= 0.0f) {
                    floatValue = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(floatValue));
            } catch (JSONException unused) {
            }
            p.c().a(a.a(a2, str, "show", lVar.ag(), jSONObject));
            String a3 = k.a(p.a());
            if (!TextUtils.isEmpty(a3)) {
                p.g().a(a3, lVar.ab(), true);
            }
            if (!TextUtils.isEmpty(k.a(context))) {
                s.b(k.a(context)).c("AdShow");
            }
        }
    }

    public static void a(l lVar, String str, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", i.d(p.a()).toString());
            if (str2.equals("download_creative_duration")) {
                jSONObject2.put("download_creative_duration", j);
            } else if (str2.equals("load_ad_duration")) {
                jSONObject2.put("load_ad_duration", j);
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", lVar.aj());
        } catch (JSONException unused) {
        }
        p.c().a(a.a(p.a(), str, str2, lVar.ag(), jSONObject));
    }

    public static void a(l lVar, String str, Map<String, Object> map) {
        Context a2 = p.a();
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() <= 0) {
            c(a2, lVar, str, "load_ad_duration");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", i.d(a2).toString());
            Object remove = map.remove("total_time");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            if (remove instanceof Long) {
                jSONObject.put("duration", remove);
            } else {
                jSONObject.put("duration", 0);
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(a2, lVar, str, "load_ad_duration", jSONObject);
    }

    public static void a(l lVar, Activity activity) {
        if (lVar != null && activity != null) {
            try {
                String a2 = aj.a(lVar);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_name", activity.getClass().getName());
                    ak.a(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject);
                    e(p.a(), lVar, a2, "page_on_create", jSONObject2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, l lVar, f fVar, String str2, boolean z, Map<String, Object> map) {
        if (!a(str2, lVar)) {
            if (context == null) {
                context = p.a();
            }
            JSONObject jSONObject = new JSONObject();
            if (fVar != null) {
                try {
                    JSONObject a2 = fVar.a();
                    a2.put("device", i.d(context).toString());
                    a2.put("is_valid", z);
                    ak.a(a2);
                    if (map != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            a2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    a(lVar, a2, str2);
                    jSONObject.put("ad_extra_data", a2.toString());
                } catch (JSONException unused) {
                }
            }
            jSONObject.putOpt("log_extra", lVar.aj());
            float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - aj.g(lVar.aj())).floatValue();
            if (floatValue <= 0.0f) {
                floatValue = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(floatValue));
            p.c().a(a.a(context, str2, str, lVar.ag(), jSONObject));
            String a3 = k.a(p.a());
            if (!TextUtils.isEmpty(a3) && "click".equals(str)) {
                p.g().a(a3, lVar.ac(), true);
            }
            if (u.c()) {
                u.c("AdEvent", str + " " + lVar.ag());
            }
        }
    }

    private static boolean a(String str, l lVar) {
        if (TextUtils.isEmpty(str) || lVar == null || !str.equals("feed_video_middle_page") || lVar.aA() != 1) {
            return false;
        }
        return true;
    }

    private static void a(l lVar, JSONObject jSONObject, String str) {
        if (lVar != null && jSONObject != null && !TextUtils.isEmpty(str) && str.equals("embeded_ad")) {
            int i = 1;
            if (lVar.aA() != 1 || lVar.N() == null) {
                i = 0;
            }
            try {
                jSONObject.put("video_middle_page", i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e(context, lVar, str, str2, jSONObject2);
            return;
        }
        c(context, lVar, str, str2);
    }

    public static void a(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.size() <= 0) {
            c(context, lVar, str, str2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void b(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            c(context, lVar, str, str2);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(l lVar, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(lVar, list);
        if (u.c()) {
            u.c("AdEvent", "tt_dislike_icon " + lVar.ag());
        }
    }

    public static void a(Context context, long j, l lVar) {
        if (context != null && lVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e(context, lVar, "splash_ad", "skip", jSONObject);
        }
    }

    public static void a(Context context, l lVar, String str) {
        c(context, lVar, str, "click_close");
    }

    public static void c(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void d(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void e(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        f(context, lVar, str, str2, map);
    }

    public static void f(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                u.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void a(Context context, l lVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("percent", i);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void g(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        e(context, lVar, str, str2, jSONObject);
    }

    public static void h(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void b(Context context, l lVar, String str, String str2) {
        c(context, lVar, str, str2);
    }

    public static void b(Context context, l lVar, String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        e(context, lVar, str, str2, jSONObject2);
    }

    public static void i(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, l lVar, String str, String str2, Long l2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", l2);
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void j(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("refer", str2);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable unused) {
        }
        e(context, lVar, str, "click_open", jSONObject);
    }

    private static void c(Context context, l lVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", lVar.aj());
        } catch (JSONException unused) {
        }
        p.c().a(a.a(context, str, str2, lVar.ag(), jSONObject));
        if (u.c()) {
            u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.ag());
        }
    }

    /* access modifiers changed from: private */
    public static void e(Context context, l lVar, String str, String str2, JSONObject jSONObject) {
        if (lVar != null) {
            if (jSONObject != null) {
                try {
                    jSONObject.putOpt("log_extra", lVar.aj());
                } catch (JSONException unused) {
                }
            }
            p.c().a(a.a(context, str, str2, lVar.ag(), jSONObject));
            if (u.c()) {
                u.c("AdEvent", "tag: " + str + "label: " + str2 + " " + lVar.ag());
            }
        }
    }

    public static void a(Context context, String str, long j) {
        c.a(context, str, j);
    }

    public static void a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                jSONObject2.put("device", i.d(p.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put("tag", str2);
                if ("click".equals(str3)) {
                    float floatValue = Double.valueOf(((double) (System.currentTimeMillis() / 1000)) - aj.g(jSONObject.optString("log_extra"))).floatValue();
                    if (floatValue <= 0.0f) {
                        floatValue = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(floatValue));
                }
            } catch (JSONException unused) {
            }
        }
        p.c().a(a.a(str, str2, str3, j, j2, jSONObject));
        if (u.c()) {
            u.c("AdEvent", "sendJsAdEvent");
        }
    }

    public static void c(Context context, l lVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void k(Context context, l lVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        e(context, lVar, str, str2, jSONObject);
    }

    public static void a(Context context, l lVar, String str, String str2, int i, int i2) {
        if (lVar != null && context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("color_percent", Integer.valueOf(i));
            if (lVar.R() != null) {
                hashMap.put("playable_url", lVar.R().j());
            }
            hashMap.put("memory_total", Integer.valueOf(aj.j()));
            hashMap.put("memory_use", Integer.valueOf(aj.l() - aj.k()));
            hashMap.put("request_id", aj.h(lVar.aj()));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("color_percent_type", Integer.valueOf(i2));
            k(context, lVar, str, str2, hashMap);
        }
    }

    public static void a(Context context, l lVar, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && lVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            e(context, lVar, str, str2, jSONObject);
        }
    }

    public static void a(long j, String str, String str2) {
        l lVar;
        try {
            lVar = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(str2));
        } catch (Throwable unused) {
            lVar = null;
        }
        if (lVar != null) {
            a(p.a(), lVar, str, "open_appback", Long.valueOf(j));
            com.bytedance.sdk.openadsdk.utils.k.a(0L);
            com.bytedance.sdk.openadsdk.utils.k.c("");
        }
    }

    public static void a(Context context, l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject.putOpt("ad_extra_data", jSONObject2);
        } catch (Exception unused) {
        }
        c(context, lVar, "landingpage", "open_url_h5", jSONObject);
    }

    public static void a(Context context, l lVar, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject.putOpt("ad_extra_data", jSONObject2);
            jSONObject.put("duration", j);
        } catch (Exception unused) {
        }
        c(context, lVar, str, "load", jSONObject);
    }

    /* compiled from: AdEventManager */
    public static class a {
        public static void a(String str, JSONObject jSONObject, l lVar) {
            try {
                String a = aj.a(lVar);
                if (a != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.e(p.a(), lVar, a + "_landingpage", str, jSONObject2);
                }
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.loadEvent error", th);
            }
        }

        public static void a(int i, int i2, l lVar) {
            try {
                String a = aj.a(lVar);
                if (a != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("all_times", i2);
                    jSONObject.put("hit_times", i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.e(p.a(), lVar, a + "_landingpage", "local_res_hit_rate", jSONObject2);
                }
            } catch (Throwable th) {
                Log.d("AdEvent", "Gecko.localResHitRate error", th);
            }
        }
    }
}
