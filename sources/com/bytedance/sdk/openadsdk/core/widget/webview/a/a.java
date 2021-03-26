package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

/* compiled from: TTDynamic */
public class a {
    static Object a = new Object();

    public static void a() {
        b.a();
        d.a();
    }

    public static void b() {
        try {
            f.d();
            File e = b.e();
            if (e != null && e.exists()) {
                if (e.getParentFile() != null) {
                    l.c(e.getParentFile());
                } else {
                    l.c(e);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        d.a().a(lVar);
    }

    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        d.a().b(lVar);
    }

    public static String c() {
        return c.c();
    }

    public static r a(String str) {
        return d.a().a(str);
    }

    public static Set<String> b(String str) {
        return d.a().b(str);
    }

    public static r c(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.M() == null) {
            return null;
        }
        r a2 = d.a().a(lVar.M().b());
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
        }
        return a2;
    }

    public static r d(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.N() == null) {
            return null;
        }
        r a2 = d.a().a(lVar.N().b());
        if (a2 != null) {
            a2.a(Long.valueOf(System.currentTimeMillis()));
            a(a2);
        }
        return a2;
    }

    private static void a(final r rVar) {
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.widget.webview.a.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.a) {
                    c.a().a(rVar);
                }
            }
        }, 10);
    }

    public static q d() {
        return b.a().c();
    }

    public static boolean e() {
        return b.a().b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        if (r2.b().equals(r4) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057 A[SYNTHETIC, Splitter:B:15:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static WebResourceResponse a(String str, e.a aVar) {
        File file;
        if (e()) {
            Iterator<q.a> it2 = d().e().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                q.a next = it2.next();
                if (next.a() != null && next.a().equals(str)) {
                    file = new File(b.e(), j.a(next.a()));
                    String a2 = j.a(file);
                    if (next.b() != null) {
                    }
                }
            }
            if (file != null) {
                return null;
            }
            try {
                return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(file));
            } catch (Throwable th) {
                u.c("TTDynamic", "get html WebResourceResponse error", th);
                return null;
            }
        }
        file = null;
        if (file != null) {
        }
    }
}
