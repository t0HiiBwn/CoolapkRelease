package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
public final class y {
    public static boolean a = true;
    private static boolean b = true;
    private static SimpleDateFormat c = null;
    private static int d = 30720;
    private static StringBuilder e;
    private static StringBuilder f;
    private static boolean g;
    private static a h;
    private static String i;
    private static String j;
    private static Context k;

    /* renamed from: l  reason: collision with root package name */
    private static String f1445l;
    private static boolean m;
    private static boolean n;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (y.class) {
            if (!m && context != null && a) {
                try {
                    o = Executors.newSingleThreadExecutor();
                    f = new StringBuilder(0);
                    e = new StringBuilder(0);
                    k = context;
                    com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                    i = a2.d;
                    a2.getClass();
                    j = "";
                    f1445l = k.getFilesDir().getPath() + "/buglylog_" + i + "_" + j + ".txt";
                    p = Process.myPid();
                } catch (Throwable unused) {
                }
                m = true;
            }
        }
    }

    public static void a(int i2) {
        synchronized (q) {
            d = i2;
            if (i2 < 0) {
                d = 0;
            } else if (i2 > 30720) {
                d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            a(str, str2, message + '\n' + z.b(th));
        }
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (y.class) {
            if (m && a) {
                try {
                    o.execute(new Runnable() {
                        /* class com.tencent.bugly.proguard.y.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            y.c(str, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (y.class) {
            if (b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, (long) Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                    if (f.length() >= d) {
                        StringBuilder sb = f;
                        f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, (long) Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                    if (f.length() > d) {
                        if (!g) {
                            g = true;
                            a aVar = h;
                            if (aVar == null) {
                                h = new a(f1445l);
                            } else if (aVar.b == null || h.b.length() + ((long) f.length()) > h.e) {
                                h.a();
                            }
                            if (h.a(f.toString())) {
                                f.setLength(0);
                                g = false;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String str4;
        e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            str4 = simpleDateFormat.format(date);
        } else {
            str4 = date.toString();
        }
        StringBuilder sb = e;
        sb.append(str4);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return e.toString();
    }

    public static byte[] a() {
        if (!b) {
            return b();
        }
        if (!a) {
            return null;
        }
        return z.a((File) null, f.toString(), "BuglyLog.txt");
    }

    private static byte[] b() {
        if (!a) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            a aVar = h;
            if (aVar != null && aVar.a && h.b != null && h.b.length() > 0) {
                sb.append(z.a(h.b, 30720, true));
            }
            StringBuilder sb2 = f;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(f.toString());
            }
        }
        return z.a((File) null, sb.toString(), "BuglyLog.txt");
    }

    /* compiled from: BUGLY */
    public static class a {
        private boolean a;
        private File b;
        private String c;
        private long d;
        private long e = 30720;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.c = str;
                this.a = a();
            }
        }

        /* access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.c);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.a = false;
                    return false;
                }
            } catch (Throwable th) {
                x.a(th);
                this.a = false;
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
        public final boolean a(String str) {
            Throwable th;
            if (!this.a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.b, true);
                try {
                    byte[] bytes = str.getBytes("UTF-8");
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.d += (long) bytes.length;
                    this.a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.a(th);
                        this.a = false;
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                x.a(th);
                this.a = false;
                return false;
            }
        }
    }
}
