package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TemplateManager */
class b {
    private static File a;
    private static volatile b b;
    private AtomicBoolean c = new AtomicBoolean(true);
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private AtomicInteger f = new AtomicInteger(0);
    private AtomicLong g = new AtomicLong();

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private b() {
        f();
    }

    private void f() {
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.widget.webview.a.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                f.a();
                b.this.c.set(false);
                b.this.g();
                b.this.d();
            }
        }, 10);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[EDGE_INSN: B:22:0x007c->B:16:0x007c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    public void g() {
        String a2;
        File file;
        u.b("TemplateManager", "check template usable1");
        q b2 = f.b();
        if (b2 == null || !b2.f()) {
            u.b("TemplateManager", "check template usable2");
            return;
        }
        boolean z = true;
        Iterator<q.a> it2 = b2.e().iterator();
        while (true) {
            if (!it2.hasNext()) {
                q.a next = it2.next();
                a2 = next.a();
                file = new File(e(), j.a(a2));
                String a3 = j.a(file);
                if (!file.exists() || !file.isFile() || next.b() == null || !next.b().equals(a3)) {
                    break;
                }
                if (!it2.hasNext()) {
                    break;
                }
            }
        }
        z = false;
        u.b("TemplateManager", "check template usable3: " + a2 + "," + file.getAbsolutePath());
        if (!z) {
            f.d();
        }
        u.b("TemplateManager", "check template usable4: " + z);
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public q c() {
        return f.b();
    }

    public void d() {
        a(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0198 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0123  */
    public void a(boolean z) {
        Iterator<q.a> it2;
        m mVar;
        if (this.c.get()) {
            u.b("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.d.get()) {
                if (z) {
                    this.f.getAndIncrement();
                }
                u.b("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            this.d.set(true);
            q a2 = p.f().a();
            q b2 = f.b();
            if (a2 != null) {
                if (a2.f()) {
                    if (!f.b(a2.b())) {
                        this.d.set(false);
                        this.g.set(System.currentTimeMillis());
                        u.b("TemplateManager", "loadTemplate error4");
                        return;
                    }
                    ArrayList<q.a> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (b2 != null) {
                        if (!b2.e().isEmpty()) {
                            if (a2.e().isEmpty()) {
                                arrayList.addAll(b2.e());
                                u.b("TemplateManager", "loadTemplate update2");
                            } else {
                                for (q.a aVar : a2.e()) {
                                    if (!b2.e().contains(aVar)) {
                                        arrayList2.add(aVar);
                                    } else {
                                        q.a a3 = f.a(aVar.a());
                                        if (!(a3 == null || aVar.b() == null || aVar.b().equals(a3.b()))) {
                                            arrayList2.add(aVar);
                                        }
                                    }
                                }
                                for (q.a aVar2 : b2.e()) {
                                    if (!a2.e().contains(aVar2)) {
                                        arrayList.add(aVar2);
                                    }
                                }
                                u.b("TemplateManager", "loadTemplate update3");
                            }
                            it2 = arrayList2.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    String a4 = it2.next().a();
                                    File file = new File(e(), j.a(a4));
                                    File file2 = new File(file + ".tmp");
                                    if (file.exists()) {
                                        try {
                                            file.delete();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    if (file2.exists()) {
                                        try {
                                            file2.delete();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i a5 = i.a();
                                    new c(file.getAbsolutePath(), a4, a5).build(d.a(p.a()).c());
                                    try {
                                        mVar = a5.get();
                                    } catch (Throwable unused3) {
                                        mVar = null;
                                    }
                                    if (mVar == null) {
                                        break;
                                    }
                                } else {
                                    for (q.a aVar3 : arrayList) {
                                        File file3 = new File(e(), j.a(aVar3.a()));
                                        File file4 = new File(file3 + ".tmp");
                                        if (file3.exists()) {
                                            try {
                                                file3.delete();
                                            } catch (Throwable unused4) {
                                            }
                                        }
                                        if (file4.exists()) {
                                            try {
                                                file4.delete();
                                            } catch (Throwable unused5) {
                                            }
                                        }
                                    }
                                    f.a(a2);
                                    f.c();
                                    u.b("TemplateManager", "loadTemplate update success: " + a2.b());
                                    g();
                                    this.d.set(false);
                                    this.g.set(System.currentTimeMillis());
                                    h();
                                    return;
                                }
                            } while (mVar.a());
                            this.d.set(false);
                            a(arrayList2);
                            u.b("TemplateManager", "loadTemplate error5");
                            return;
                        }
                    }
                    arrayList2.addAll(a2.e());
                    u.b("TemplateManager", "loadTemplate update1");
                    it2 = arrayList2.iterator();
                    do {
                        if (!it2.hasNext()) {
                        }
                    } while (mVar.a());
                    this.d.set(false);
                    a(arrayList2);
                    u.b("TemplateManager", "loadTemplate error5");
                    return;
                }
            }
            this.d.set(false);
            a(109);
            u.b("TemplateManager", "loadTemplate error3");
        } catch (Throwable th) {
            u.a("TemplateManager", "loadTemplate error: ", th);
        }
    }

    private void a(int i) {
        a.a().h(com.bytedance.sdk.openadsdk.g.a.c.b().b(i).g(h.a(i)));
    }

    private void h() {
        if (this.f.getAndSet(0) > 0 && System.currentTimeMillis() - this.g.get() > 600000) {
            d();
        }
    }

    private void a(List<q.a> list) {
        if (!(list == null || list.isEmpty())) {
            for (q.a aVar : list) {
                File file = new File(e(), j.a(aVar.a()));
                File file2 = new File(file + ".tmp");
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static File e() {
        File file;
        if (a == null) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && p.a().getExternalCacheDir() != null) {
                    file = p.a().getExternalCacheDir();
                } else {
                    file = p.a().getCacheDir();
                }
                File file2 = new File(new File(file, "tt_tmpl_pkg"), "template");
                file2.mkdirs();
                a = file2;
            } catch (Throwable th) {
                u.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return a;
    }
}
