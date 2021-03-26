package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: TmplDiffManager */
class d {
    private static volatile d a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
    }

    public r a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().a(str);
    }

    public Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().b(str);
    }

    private void b() {
        if (p.h() != null) {
            int E = p.h().E();
            if (E <= 0) {
                E = 100;
            }
            List<r> b2 = c.a().b();
            if (b2.isEmpty() || E >= b2.size()) {
                u.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + E + ", 目前存储的模版的个数 " + b2.size());
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (r rVar : b2) {
                treeMap.put(rVar.g(), rVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (((float) b2.size()) - (((float) E) * 0.75f));
            int i = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && i < size) {
                    i++;
                    ((Long) entry.getKey()).longValue();
                    r rVar2 = (r) entry.getValue();
                    if (rVar2 != null) {
                        hashSet.add(rVar2.b());
                    }
                }
            }
            a(hashSet);
            this.b.set(false);
        }
    }

    private JSONObject c(String str) {
        i a2 = i.a();
        new j(0, str, a2).setShouldCache(false).build(com.bytedance.sdk.openadsdk.h.d.a(p.a()).d());
        try {
            m b2 = a2.get();
            if (b2 == null || !b2.a() || b2.a == null) {
                return null;
            }
            return new JSONObject((String) b2.a);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(l lVar) {
        if (lVar != null && lVar.M() != null) {
            String b2 = lVar.M().b();
            String d = lVar.M().d();
            String c = lVar.M().c();
            String e = lVar.M().e();
            String a2 = lVar.M().a();
            int d2 = aj.d(lVar.aj());
            com.bytedance.sdk.openadsdk.core.h.i e2 = com.bytedance.sdk.openadsdk.core.h.i.a().a(b2).b(c).c(d).d(e).e(a2);
            u.b("TmplDiffManager", "从物料中获取模版信息进行保存 rit " + d2);
            a(e2, d2 + "");
        }
    }

    public void b(l lVar) {
        if (lVar != null && lVar.N() != null) {
            String b2 = lVar.N().b();
            String d = lVar.N().d();
            String c = lVar.N().c();
            String e = lVar.N().e();
            String a2 = lVar.N().a();
            int d2 = aj.d(lVar.aj());
            com.bytedance.sdk.openadsdk.core.h.i e2 = com.bytedance.sdk.openadsdk.core.h.i.a().a(b2).b(c).c(d).d(e).e(a2);
            a(e2, d2 + "");
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.h.i iVar, final String str) {
        if (iVar == null) {
            u.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = iVar.a;
        final String str3 = iVar.c;
        final String str4 = iVar.b;
        final String str5 = iVar.d;
        final String str6 = iVar.e;
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.i.d().f();
        }
        if (TextUtils.isEmpty(str2)) {
            u.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            e.a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.widget.webview.a.d.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(str2, str3, str4, str5, str6, str);
                }
            }, 10);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str) != null) {
            if (!TextUtils.isEmpty(str4)) {
                if (!TextUtils.isEmpty(str3)) {
                    b(str6, str, str3, str2, str4, str5);
                }
            }
            return;
        } else if (TextUtils.isEmpty(str4)) {
            a(str2, str6, str);
        } else if (TextUtils.isEmpty(str3)) {
            a(str2, str6, str);
        } else {
            b(str6, str, str3, str2, str4, str5);
        }
        boolean b2 = f.b(str5);
        if (!a.e() || b2) {
            b.a().a(true);
        }
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        c.a().a(new r().a(str).b(str2).c(str3).d(str4).e(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
        b();
    }

    private void a(String str, String str2, String str3) {
        JSONObject c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            String optString = c.optString("md5");
            String optString2 = c.optString("version");
            String optString3 = c.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                r a2 = new r().a(str2).b(str3).c(optString).d(str).e(optString3).f(optString2).a(Long.valueOf(System.currentTimeMillis()));
                c.a().a(a2);
                b();
                if (f.b(optString2)) {
                    a2.f(optString2);
                    b.a().a(true);
                }
            }
        }
    }

    public void a(Set<String> set) {
        try {
            c.a().a(set);
        } catch (Throwable th) {
            u.b("TmplDiffManager", th.getMessage());
        }
    }
}
