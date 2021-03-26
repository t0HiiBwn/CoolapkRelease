package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
public final class e implements Thread.UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();
    private Context a;
    private b b;
    private a c;
    private com.tencent.bugly.crashreport.common.info.a d;
    private Thread.UncaughtExceptionHandler e;
    private Thread.UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(Context context, b bVar, a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f = defaultUncaughtExceptionHandler;
                    this.e = defaultUncaughtExceptionHandler;
                } else {
                    x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.e = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        x.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.g = false;
        x.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x007f: APUT  
      (r9v10 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x007b: INVOKE  (r10v3 java.lang.Integer) = (r10v2 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d8: APUT  
      (r9v12 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x00d4: INVOKE  (r13v5 java.lang.Boolean) = (r13v4 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String str2;
        String str3;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean l = c.a().l();
        String str4 = (!l || !z) ? "" : " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
        if (l && z) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = b.g();
        crashDetailBean.D = b.e();
        crashDetailBean.E = b.i();
        crashDetailBean.F = this.d.k();
        crashDetailBean.G = this.d.j();
        crashDetailBean.H = this.d.l();
        crashDetailBean.w = z.a(this.a, c.e, (String) null);
        crashDetailBean.y = y.a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.y == null ? 0 : crashDetailBean.y.length);
        x.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        crashDetailBean.f = this.d.k;
        crashDetailBean.g = this.d.q();
        crashDetailBean.m = this.d.g();
        String name = th.getClass().getName();
        String b2 = b(th, 1000);
        if (b2 == null) {
            b2 = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e("stack frame :%d, has cause %b", objArr2);
        if (th.getStackTrace().length > 0) {
            str2 = th.getStackTrace()[0].toString();
        } else {
            str2 = "";
        }
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.n = name;
            crashDetailBean.o = b2 + str4;
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = str2;
            str3 = a(th, c.f);
            crashDetailBean.q = str3;
        } else {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = b(th2, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(b2);
            sb.append("\n");
            sb.append(str2);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append("\n");
            str3 = a(th2, c.f);
            sb.append(str3);
            crashDetailBean.q = sb.toString();
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = z.a(c.f, false);
            crashDetailBean.A = this.d.d;
            crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.z.put(crashDetailBean.B, str3);
            crashDetailBean.I = this.d.s();
            crashDetailBean.h = this.d.p();
            crashDetailBean.i = this.d.B();
            crashDetailBean.M = this.d.a;
            crashDetailBean.N = this.d.a();
            if (z) {
                this.b.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    crashDetailBean.O = new HashMap(1);
                    crashDetailBean.O.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.U = bArr;
                }
            }
            crashDetailBean.Q = this.d.z();
            crashDetailBean.R = this.d.A();
            crashDetailBean.S = this.d.t();
            crashDetailBean.T = this.d.y();
        } catch (Throwable th3) {
            x.e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            if (h != null && thread.getName().equals(h)) {
                return true;
            }
            h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            x.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                x.a("this class has handled this exception", new Object[0]);
                if (this.f != null) {
                    x.a("call system handler", new Object[0]);
                    this.f.uncaughtException(thread, th);
                } else {
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            x.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.g) {
                x.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } else {
                if (!this.c.b()) {
                    x.d("no remote but still store!", new Object[0]);
                }
                if (this.c.c().e || !this.c.b()) {
                    CrashDetailBean b2 = b(thread, th, z, str, bArr);
                    if (b2 == null) {
                        x.e("pkg crash datas fail!", new Object[0]);
                        if (z) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.e;
                            if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                                x.e("sys default last handle start!", new Object[0]);
                                this.e.uncaughtException(thread, th);
                                x.e("sys default last handle end!", new Object[0]);
                            } else if (this.f != null) {
                                x.e("system handle start!", new Object[0]);
                                this.f.uncaughtException(thread, th);
                                x.e("system handle end!", new Object[0]);
                            } else {
                                x.e("crashreport last handle start!", new Object[0]);
                                x.e("current process die", new Object[0]);
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                                x.e("crashreport last handle end!", new Object[0]);
                            }
                        }
                    } else {
                        b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, thread.getName(), z.a(th), b2);
                        if (!this.b.a(b2)) {
                            this.b.a(b2, 3000, z);
                        }
                        if (z) {
                            this.b.c(b2);
                        }
                        if (z) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.e;
                            if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                                x.e("sys default last handle start!", new Object[0]);
                                this.e.uncaughtException(thread, th);
                                x.e("sys default last handle end!", new Object[0]);
                            } else if (this.f != null) {
                                x.e("system handle start!", new Object[0]);
                                this.f.uncaughtException(thread, th);
                                x.e("system handle end!", new Object[0]);
                            } else {
                                x.e("crashreport last handle start!", new Object[0]);
                                x.e("current process die", new Object[0]);
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                                x.e("crashreport last handle end!", new Object[0]);
                            }
                        }
                    }
                } else {
                    x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, thread.getName(), z.a(th), null);
                    if (z) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.e;
                        if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                            x.e("sys default last handle start!", new Object[0]);
                            this.e.uncaughtException(thread, th);
                            x.e("sys default last handle end!", new Object[0]);
                        } else if (this.f != null) {
                            x.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread, th);
                            x.e("system handle end!", new Object[0]);
                        } else {
                            x.e("crashreport last handle start!", new Object[0]);
                            x.e("current process die", new Object[0]);
                            Process.killProcess(Process.myPid());
                            System.exit(1);
                            x.e("crashreport last handle end!", new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.e;
                if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                    x.e("sys default last handle start!", new Object[0]);
                    this.e.uncaughtException(thread, th);
                    x.e("sys default last handle end!", new Object[0]);
                } else if (this.f != null) {
                    x.e("system handle start!", new Object[0]);
                    this.f.uncaughtException(thread, th);
                    x.e("system handle end!", new Object[0]);
                } else {
                    x.e("crashreport last handle start!", new Object[0]);
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    x.e("crashreport last handle end!", new Object[0]);
                }
            }
            throw th2;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            a(thread, th, true, null, null);
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.e != this.g) {
                x.a("java changed to %b", Boolean.valueOf(strategyBean.e));
                if (strategyBean.e) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (i2 <= 0 || sb.length() < i2) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    } else {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            x.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
