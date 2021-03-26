package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.a.d;
import com.tencent.open.utils.e;
import java.io.File;

/* compiled from: ProGuard */
public class f {
    public static f a;
    protected static final b c = new b(c(), c.m, c.g, c.h, c.c, (long) c.i, 10, c.e, c.n);
    private static boolean d;
    protected a b = new a(c);

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                    d = true;
                }
            }
        }
        return a;
    }

    private f() {
    }

    protected void a(int i, String str, String str2, Throwable th) {
        a aVar;
        if (d) {
            String b2 = e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:3.3.0.lite";
                if (this.b != null) {
                    e.a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    d = false;
                } else {
                    return;
                }
            }
        }
        e.a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.b, i) && (aVar = this.b) != null) {
            aVar.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    public static final void b(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (a != null) {
                a = null;
            }
        }
    }

    protected static File c() {
        String str = c.d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null && b2.c() > c.f) {
                z = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z) {
            return new File(Environment.getExternalStorageDirectory(), str);
        }
        return new File(e.c(), str);
    }

    protected void d() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b.b();
            this.b = null;
        }
    }
}
