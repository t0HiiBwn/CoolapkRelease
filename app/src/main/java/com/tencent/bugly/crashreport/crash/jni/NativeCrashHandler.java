package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler implements a {
    public static int JNI_CALL_TYPE = 1;
    private static NativeCrashHandler a = null;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1438l = false;
    private static boolean m = false;
    private static boolean o = true;
    private final Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final w d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private b n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i2);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i2, String str);

    protected native void testCrash();

    protected native String unregist();

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, w wVar, boolean z, String str) {
        this.b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 boolean)] */
    public static void setShouldHandleInJava(boolean z) {
        o = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x012c: APUT  
      (r5v1 java.lang.Object[])
      (2 ??[int, float, short, byte, char])
      (wrap: java.lang.Integer : 0x0128: INVOKE  (r9v1 java.lang.Integer) = (r9v0 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    private synchronized void a(boolean z) {
        StringBuilder sb;
        String str;
        if (this.j) {
            x.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.i) {
            try {
                String regist = regist(this.f, z, JNI_CALL_TYPE);
                if (regist != null) {
                    x.a("[Native] Native Crash Report enable.", new Object[0]);
                    x.c("[Native] Check extra jni for Bugly NDK v%s", regist);
                    String replace = "2.1.1".replace(".", "");
                    String replace2 = "2.3.0".replace(".", "");
                    String replace3 = regist.replace(".", "");
                    if (replace3.length() == 2) {
                        sb = new StringBuilder();
                        sb.append(replace3);
                        str = "0";
                    } else {
                        if (replace3.length() == 1) {
                            sb = new StringBuilder();
                            sb.append(replace3);
                            str = "00";
                        }
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                            f1438l = true;
                        }
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                            m = true;
                        }
                        if (!m) {
                            x.a("[Native] Info setting jni can be accessed.", new Object[0]);
                        } else {
                            x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
                        }
                        if (!f1438l) {
                            x.a("[Native] Extra jni can be accessed.", new Object[0]);
                        } else {
                            x.d("[Native] Extra jni can not be accessed.", new Object[0]);
                        }
                        this.c.o = regist;
                        if (!this.c.f.contains("-".concat(this.c.o))) {
                            com.tencent.bugly.crashreport.common.info.a aVar = this.c;
                            aVar.f = aVar.f.concat("-").concat(this.c.o);
                        }
                        x.a("comInfo.sdkVersion %s", this.c.f);
                        this.j = true;
                        return;
                    }
                    sb.append(str);
                    replace3 = sb.toString();
                    try {
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                        }
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                        }
                    } catch (Throwable unused) {
                    }
                    if (!m) {
                    }
                    if (!f1438l) {
                    }
                    this.c.o = regist;
                    if (!this.c.f.contains("-".concat(this.c.o))) {
                    }
                    x.a("comInfo.sdkVersion %s", this.c.f);
                    this.j = true;
                    return;
                }
            } catch (Throwable unused2) {
                x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.h) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.b, false);
                int i2 = 5;
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str2 == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    com.tencent.bugly.crashreport.common.info.a.b();
                    str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, clsArr2, new Object[]{this.f, com.tencent.bugly.crashreport.common.info.b.a(this.b, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.C())});
                }
                if (str2 != null) {
                    this.j = true;
                    this.c.o = str2;
                    Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str2});
                    if (bool != null) {
                        f1438l = bool.booleanValue();
                    }
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    if (z) {
                        i2 = 1;
                    }
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)});
                    return;
                }
            } catch (Throwable unused3) {
            }
        }
        this.i = false;
        this.h = false;
    }

    public synchronized void startNativeMonitor() {
        if (!this.i) {
            if (!this.h) {
                String str = "Bugly";
                boolean z = !z.a(this.c.n);
                String str2 = this.c.n;
                if (!z) {
                    this.c.getClass();
                } else {
                    str = str2;
                }
                boolean a2 = a(str, z);
                this.i = a2;
                if (a2 || this.h) {
                    a(this.g);
                    if (f1438l) {
                        setNativeAppVersion(this.c.k);
                        setNativeAppChannel(this.c.m);
                        setNativeAppPackage(this.c.c);
                        setNativeUserId(this.c.g());
                        setNativeIsAppForeground(this.c.a());
                        setNativeLaunchTime(this.c.a);
                    }
                    return;
                }
                return;
            }
        }
        a(this.g);
    }

    public void checkUploadRecordCrash() {
        this.d.a(new Runnable() {
            /* class com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                if (!z.a(NativeCrashHandler.this.b, "native_record_lock", 10000)) {
                    x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.o) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a2 = b.a(NativeCrashHandler.this.b, NativeCrashHandler.this.f, NativeCrashHandler.this.e);
                if (a2 != null) {
                    x.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.n.a(a2)) {
                        NativeCrashHandler.this.n.a(a2, 3000L, false);
                    }
                    b.a(false, NativeCrashHandler.this.f);
                }
                NativeCrashHandler.this.a();
                z.b(NativeCrashHandler.this.b, "native_record_lock");
            }
        });
    }

    private static boolean a(String str, boolean z) {
        Throwable th;
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            x.d(th.getMessage(), new Object[0]);
            x.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    private synchronized void c() {
        if (!this.j) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.j = false;
                return;
            }
        } catch (Throwable unused) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.j = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
            this.i = false;
            this.h = false;
        }
    }

    public void testNativeCrash() {
        if (!this.i) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 boolean)] */
    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected final void a() {
        long b2 = z.b() - c.g;
        long b3 = z.b() + 86400000;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                if (listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f);
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().e;
        }
        if (isUserOpened != this.j) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.e != this.j) {
                x.d("server native changed to %b", Boolean.valueOf(strategyBean.e));
            }
        }
        boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().e && this.k;
        if (z != this.j) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if (!((!this.h && !this.i) || !f1438l || str == null || str2 == null || str3 == null)) {
            try {
                if (this.i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f1438l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if ((!this.h && !this.i) || !f1438l) {
            return null;
        }
        try {
            if (this.i) {
                return getNativeLog();
            }
            return (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f1438l = false;
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.h || this.i) && f1438l && str != null && str2 != null) {
            try {
                if (this.i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f1438l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (this.i && m) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (x.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT <= 29 && Build.VERSION.SDK_INT >= 26 && com.tencent.bugly.crashreport.common.info.b.c(this.b).contains("Oppo")) {
            JNI_CALL_TYPE |= 2;
        }
    }

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }
}
