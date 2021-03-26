package com.bytedance.sdk.openadsdk.gecko;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.preload.geckox.a.a.a;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: GeckoHub */
public class a {
    private static String[] a = {"gecko-pangle-lf.snssdk.com", "gecko-pangle-hl.snssdk.com", "gecko-pangle-lq.snssdk.com"};
    private File b;
    private Map.Entry<String, JSONObject> c;

    /* renamed from: com.bytedance.sdk.openadsdk.gecko.a$a  reason: collision with other inner class name */
    /* compiled from: GeckoHub */
    private static class C0052a {
        private static a a = new a();
    }

    public static a a() {
        return C0052a.a;
    }

    private a() {
        this.b = new File(p.a().getCacheDir() + File.separator + "gecko");
        if (i.d().v()) {
            b.a();
        }
    }

    private String c() {
        String[] G = p.h().G();
        StringBuilder sb = new StringBuilder();
        sb.append("GeckoLog:get gecko hosts from settings ");
        sb.append(G == null ? 0 : G.length);
        u.b("GeckoHub", sb.toString());
        if (G == null) {
            G = a;
        }
        String str = G[new Random().nextInt(G.length)];
        if (TextUtils.isEmpty(str)) {
            str = a[new Random().nextInt(a.length)];
        }
        u.b("GeckoHub", "GeckoLog:random host " + str);
        return str;
    }

    public void a(final Map<String, l> map) {
        String a2 = k.a(p.a());
        if (TextUtils.isEmpty(a2)) {
            u.b("GeckoHub", "no did so don't preload");
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.a a3 = com.bytedance.sdk.openadsdk.preload.geckox.a.a(new b.a(p.a()).b("4ab312f7094810afa84659d3dc6cf0fe").a("4ab312f7094810afa84659d3dc6cf0fe").a(Long.parseLong("1371")).b(a2).a("9999999.0.0").a(new a.C0064a().a(20).a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.b.c).a()).a(this.b).a(false).c(c()).b(e.a()).a(e.a()).a(new com.bytedance.sdk.openadsdk.preload.geckox.statistic.a() {
            /* class com.bytedance.sdk.openadsdk.gecko.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.geckox.statistic.a
            public void a(String str, JSONObject jSONObject) {
                if ("geckosdk_update_stats".equals(str)) {
                    l lVar = (l) map.get(jSONObject.optString("channel"));
                    if (lVar != null) {
                        d.a.a(str, jSONObject, lVar);
                    }
                }
            }
        }).a());
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        for (String str : map.keySet()) {
            linkedList.add(new CheckRequestBodyModel.TargetChannel(str));
        }
        hashMap.put("4ab312f7094810afa84659d3dc6cf0fe", linkedList);
        a3.a(hashMap);
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    private JSONObject a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                Map.Entry<String, JSONObject> entry = this.c;
                if (entry == null || !str.equals(entry.getKey())) {
                    u.b("GeckoHub", "refresh cache manifest");
                    com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar = new com.bytedance.sdk.openadsdk.preload.falconx.a.a(p.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.b);
                    String a2 = com.bytedance.sdk.openadsdk.i.g.a.a(aVar.a(str + "/manifest.json"));
                    if (TextUtils.isEmpty(a2)) {
                        u.f("GeckoHub", "getFileInfoInManifest error null");
                        return null;
                    }
                    this.c = new AbstractMap.SimpleEntry(str, new JSONObject(a2));
                }
                JSONObject value = this.c.getValue();
                String a3 = j.a(str2);
                if (value.has(a3)) {
                    return value.getJSONObject(a3);
                }
                String a4 = a(str2);
                if (a4 == null) {
                    return null;
                }
                String a5 = j.a(a4);
                if (value.has(a5)) {
                    return value.getJSONObject(a5);
                }
                return null;
            } catch (Throwable th) {
                u.c("GeckoHub", "getFileInfoInManifest error", th);
            }
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.preload.falconx.a.a b() {
        try {
            return new com.bytedance.sdk.openadsdk.preload.falconx.a.a(p.a(), "4ab312f7094810afa84659d3dc6cf0fe", this.b);
        } catch (Throwable th) {
            u.c("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar) {
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                u.c("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    private InputStream b(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) throws Exception {
        String str3 = str + File.separator + str2;
        if (!aVar.b(str3)) {
            return null;
        }
        return aVar.a(str3);
    }

    public WebResourceResponse a(com.bytedance.sdk.openadsdk.preload.falconx.a.a aVar, String str, String str2) {
        String optString;
        InputStream b2;
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject a2 = a(str, str2);
            if (a2 == null || (optString = a2.optString("fileName", null)) == null) {
                return null;
            }
            JSONObject jSONObject = a2.has("respHeader") ? a2.getJSONObject("respHeader") : null;
            if (jSONObject == null || (b2 = b(aVar, str, optString)) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return com.bytedance.sdk.openadsdk.preload.falconx.b.a.a(b2, hashMap);
        } catch (Throwable th) {
            u.c("GeckoHub", "findRes error", th);
            return null;
        }
    }
}
