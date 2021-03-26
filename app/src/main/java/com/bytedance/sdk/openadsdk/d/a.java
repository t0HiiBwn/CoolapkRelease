package com.bytedance.sdk.openadsdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsAppAdDownloadManager */
public class a implements c {
    private final l a;
    private final b b;
    private final Map<String, b> c = new HashMap();

    private a(b bVar, l lVar) {
        this.b = bVar;
        this.a = lVar;
    }

    public static a a(b bVar, l lVar) {
        return new a(bVar, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a() {
        for (b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void b() {
        for (b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void c() {
        b();
        for (b bVar : this.c.values()) {
            if (bVar != null) {
                bVar.d();
            }
        }
        this.c.clear();
    }

    private l a(JSONObject jSONObject, String str) {
        String str2 = null;
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.c(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            lVar.m(str);
        }
        if (this.a == null) {
            return lVar;
        }
        if (lVar.ah() != null) {
            str2 = lVar.ah().b();
        }
        if (TextUtils.isEmpty(str2)) {
            return this.a;
        }
        return (this.a.ah() == null || !str2.equals(this.a.ah().b())) ? lVar : this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(context, a(optJSONObject, str), optJSONObject, i, z);
        }
    }

    private void a(Context context, l lVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && lVar != null && lVar.ah() != null && jSONObject != null && this.b != null && this.c.get(lVar.ah().b()) == null) {
            String a2 = aj.a(i);
            if (!TextUtils.isEmpty(a2)) {
                this.c.put(lVar.ah().b(), a(context, lVar, jSONObject, a2, z));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(context, a(optJSONObject, (String) null));
        }
    }

    private void a(Context context, l lVar) {
        if (context != null && lVar != null && lVar.ah() != null) {
            final String ag = lVar.ag();
            b bVar = this.c.get(lVar.ah().b());
            if (bVar != null) {
                bVar.g();
                bVar.a(new TTAppDownloadListener() {
                    /* class com.bytedance.sdk.openadsdk.d.a.AnonymousClass1 */

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                        C0049a.a(ag, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long j, long j2, String str, String str2) {
                        if (j > 0) {
                            C0049a.a(ag, 3, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long j, long j2, String str, String str2) {
                        if (j > 0) {
                            C0049a.a(ag, 2, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long j, long j2, String str, String str2) {
                        if (j > 0) {
                            C0049a.a(ag, 4, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long j, String str, String str2) {
                        C0049a.a(ag, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String str, String str2) {
                        C0049a.a(ag, 6, 100);
                    }
                });
            }
            if (context instanceof com.bytedance.sdk.openadsdk.core.video.c.b) {
                ((com.bytedance.sdk.openadsdk.core.video.c.b) context).W();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            a(a(optJSONObject, (String) null), optJSONObject);
        }
    }

    private void a(l lVar, JSONObject jSONObject) {
        if (this.b != null && lVar != null && lVar.ah() != null) {
            String b2 = lVar.ah().b();
            if (this.c.containsKey(b2)) {
                this.c.remove(b2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("status", "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.b.a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && this.b != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            b bVar = this.c.get(a(optJSONObject, (String) null).ah().b());
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    private b a(final Context context, final l lVar, final JSONObject jSONObject, String str, final boolean z) {
        b b2 = com.bytedance.sdk.openadsdk.downloadnew.a.b(context, lVar, str);
        b2.a(new TTAppDownloadListener() {
            /* class com.bytedance.sdk.openadsdk.d.a.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                a("status", "idle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                a("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                a("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                a("status", "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                a("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                a("status", "installed");
            }

            private void a(String... strArr) {
                if (strArr != null && strArr.length % 2 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", "success");
                        jSONObject.put("appad", jSONObject);
                        for (int i = 0; i < strArr.length; i += 2) {
                            jSONObject.put(strArr[i], strArr[i + 1]);
                        }
                        a.this.b.a("app_ad_event", jSONObject);
                    } catch (JSONException unused) {
                        u.b("JsAppAdDownloadManager", "JSONException");
                    }
                }
            }
        });
        b2.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.d.a.AnonymousClass3 */
        });
        b2.a(3, new a.AbstractC0050a() {
            /* class com.bytedance.sdk.openadsdk.d.a.AnonymousClass4 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
                if (r7.equals("click_pause") == false) goto L_0x0028;
             */
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.AbstractC0050a
            public boolean a(int i, l lVar, String str, String str2, Object obj) {
                char c2 = 3;
                if (i == 3 && lVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (!z) {
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case -1297985154:
                                if (str2.equals("click_continue")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -777040223:
                                if (str2.equals("click_open")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 565370917:
                                if (str2.equals("click_start_detail")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1682049151:
                                break;
                            case 1685366507:
                                if (str2.equals("click_start")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                return false;
                            default:
                                return true;
                        }
                    } else if (str2.equals("click_start")) {
                        d.a(context, lVar, str, "click_start_detail", (JSONObject) null);
                    }
                }
                return true;
            }
        });
        return b2;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.d.a$a  reason: collision with other inner class name */
    /* compiled from: JsAppAdDownloadManager */
    public static class C0049a {
        private static ConcurrentHashMap<String, JSONObject> a = new ConcurrentHashMap<>();

        public static synchronized JSONObject a(String str) {
            synchronized (C0049a.class) {
                if (TextUtils.isEmpty(str)) {
                    return new JSONObject();
                }
                ConcurrentHashMap<String, JSONObject> concurrentHashMap = a;
                if (concurrentHashMap == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject = concurrentHashMap.get(str);
                if (jSONObject != null) {
                    return jSONObject;
                }
                return new JSONObject();
            }
        }

        public static synchronized void a(String str, int i, int i2) {
            synchronized (C0049a.class) {
                if (!TextUtils.isEmpty(str)) {
                    if (a == null) {
                        a = new ConcurrentHashMap<>();
                    }
                    JSONObject jSONObject = a.get(str);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        a.put(str, jSONObject);
                    }
                    try {
                        jSONObject.put("downloadStatus", i);
                        jSONObject.put("downloadProcessRate", i2);
                        jSONObject.put("code", 0);
                        jSONObject.put("codeMsg", "get ad_down_load_id success");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
