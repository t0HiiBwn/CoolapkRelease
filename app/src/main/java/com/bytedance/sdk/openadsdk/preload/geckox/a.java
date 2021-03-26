package com.bytedance.sdk.openadsdk.preload.geckox;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.e.b;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: GeckoClient */
public final class a {
    private final List<String> a = new ArrayList();
    private b b = new b();
    private Queue<String> c = new LinkedBlockingQueue();
    private b d;
    private File e;

    private a(b bVar) {
        this.d = bVar;
        File m = bVar.m();
        this.e = m;
        m.mkdirs();
        c.a(this, this.d);
    }

    public static a a(b bVar) {
        if (bVar != null) {
            List<String> e2 = bVar.e();
            if (e2 == null || e2.isEmpty()) {
                throw new IllegalArgumentException("access key empty");
            }
            g.a(bVar.a());
            return new a(bVar);
        }
        throw new IllegalArgumentException("config == null");
    }

    public void a(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        a("default", null, map, null);
    }

    public void a(final String str, final Map<String, Map<String, Object>> map, final Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("groupType == null");
        } else if (!a()) {
            throw new IllegalArgumentException("deployments keys not in local keys");
        } else if (b(map2)) {
            this.d.g().execute(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.preload.geckox.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.preload.geckox.a.a.b bVar;
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check update...", str);
                    if (a.this.d.b() != null) {
                        bVar = a.this.d.b().a();
                        bVar.a(a.this.d.b(), a.this.d.m(), a.this.d.e());
                    } else {
                        bVar = null;
                    }
                    try {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "update finished", com.bytedance.sdk.openadsdk.preload.geckox.j.a.a(aVar, a.this.e, a.this.d, a.this.b, map, map2, str).a((com.bytedance.sdk.openadsdk.preload.b.b<Object>) str));
                        com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar = aVar;
                        if (aVar != null) {
                            aVar.a();
                        }
                        if (bVar != null) {
                            bVar.a();
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    } catch (Exception e2) {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "Gecko update failed:", e2);
                        com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        if (bVar != null) {
                            bVar.a();
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                        if (bVar != null) {
                            bVar.a();
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                        throw th;
                    }
                    a.this.b();
                }
            });
        } else {
            throw new IllegalArgumentException("target keys not in deployments keys");
        }
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> e2 = this.d.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                boolean z = false;
                for (String str : e2) {
                    if (TextUtils.equals(str, entry.getKey())) {
                        z = true;
                    }
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a() {
        List<String> d2 = this.d.d();
        List<String> e2 = this.d.e();
        if (d2 == null || d2.isEmpty() || e2 == null || e2.isEmpty()) {
            return false;
        }
        for (String str : e2) {
            boolean z = false;
            for (String str2 : d2) {
                if (TextUtils.equals(str, str2)) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        this.b.a(cls, aVar);
    }

    /* access modifiers changed from: private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d.e());
        a(com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(new com.bytedance.sdk.openadsdk.preload.geckox.k.a.a(arrayList)), 100);
    }

    private void a(String str, int i) {
        if (this.d.o() != null && this.d.o().a()) {
            this.d.o().a(str, i);
        } else if (this.c.size() < 10) {
            this.c.add(str);
        }
    }
}
