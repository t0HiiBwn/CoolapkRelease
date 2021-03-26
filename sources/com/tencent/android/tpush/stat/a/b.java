package com.tencent.android.tpush.stat.a;

import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public final class b {
    private String a = "default";
    private boolean b = true;
    private int c = 2;

    public b() {
    }

    public b(String str) {
        this.a = str;
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public void a(Object obj) {
        String str;
        if (this.c <= 4) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            TLogger.i(this.a, str);
        }
    }

    public void b(Object obj) {
        if (a()) {
            a(obj);
        }
    }

    public void c(Object obj) {
        String str;
        if (this.c <= 5) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            TLogger.w(this.a, str);
        }
    }

    public void d(Object obj) {
        if (a()) {
            c(obj);
        }
    }

    public void e(Object obj) {
        String str;
        if (this.c <= 6) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            TLogger.e(this.a, str);
        }
    }

    public void a(Throwable th) {
        if (this.c <= 6) {
            TLogger.e(this.a, "", th);
        }
    }

    public void f(Object obj) {
        if (a()) {
            e(obj);
        }
    }

    public void b(Throwable th) {
        if (a()) {
            a(th);
        }
    }

    public void g(Object obj) {
        String str;
        if (this.c <= 3) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            TLogger.d(this.a, str);
        }
    }

    public void h(Object obj) {
        if (a()) {
            g(obj);
        }
    }
}
