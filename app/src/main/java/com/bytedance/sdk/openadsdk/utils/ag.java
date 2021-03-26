package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.h.f;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.util.Properties;

/* compiled from: TTCrashHandler */
public class ag implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    public static ag a() {
        return new ag();
    }

    private ag() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void b() {
        File externalFilesDir;
        Context a2 = p.a();
        if (a2 != null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = a2.getExternalFilesDir("TTCache")) != null) {
                    externalFilesDir.mkdirs();
                    this.b = externalFilesDir.getPath();
                }
                if (TextUtils.isEmpty(this.b)) {
                    File file = new File(a2.getFilesDir(), "TTCache");
                    file.mkdirs();
                    this.b = file.getPath();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0113 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010e A[SYNTHETIC, Splitter:B:64:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    private void a(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        Throwable th2;
        FileOutputStream fileOutputStream2;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.b)) {
                b();
            }
            if (!TextUtils.isEmpty(this.b)) {
                File file = new File(this.b, "tt_crash_count.properties");
                boolean z2 = true;
                if (!file.exists() || !file.isFile() || !file.canRead()) {
                    Properties properties = new Properties();
                    properties.setProperty("crash_count", String.valueOf(1));
                    properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream3, "tt_crash_info");
                        u.f("TTCrashHandler", "==first");
                        fileOutputStream = fileOutputStream3;
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileOutputStream = fileOutputStream3;
                        try {
                            u.c("TTCrashHandler", "crash count error", th2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (fileOutputStream == null) {
                                return;
                            }
                            fileOutputStream.close();
                            return;
                        } catch (Throwable unused2) {
                        }
                    }
                } else {
                    Properties properties2 = new Properties();
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        properties2.load(fileInputStream2);
                        String property = properties2.getProperty("crash_count", "0");
                        String property2 = properties2.getProperty("crash_last_time", "0");
                        int intValue = Integer.valueOf(property).intValue();
                        long longValue = Long.valueOf(property2).longValue();
                        int i2 = 0;
                        if (System.currentTimeMillis() - longValue < 300000) {
                            i = intValue + 1;
                            z = false;
                        } else {
                            i = 1;
                            z = true;
                        }
                        if (i < 3) {
                            z2 = false;
                        }
                        if (!z2) {
                            i2 = i;
                        }
                        u.f("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                        if (z2) {
                            try {
                                file.delete();
                            } catch (Throwable unused3) {
                            }
                        } else {
                            properties2.setProperty("crash_count", String.valueOf(i2));
                            if (z) {
                                properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                            }
                            FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                            try {
                                properties2.store(fileOutputStream4, "tt_crash_info");
                                fileInputStream = fileOutputStream4;
                            } catch (Throwable th4) {
                                th2 = th4;
                                fileOutputStream2 = fileOutputStream4;
                                fileInputStream = fileInputStream2;
                                fileOutputStream = fileOutputStream2;
                                u.c("TTCrashHandler", "crash count error", th2);
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream == null) {
                                }
                                fileOutputStream.close();
                                return;
                            }
                        }
                        if (z2) {
                            c();
                        }
                        fileOutputStream = fileInputStream;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        fileOutputStream2 = null;
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        u.c("TTCrashHandler", "crash count error", th2);
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        fileOutputStream.close();
                        return;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
                try {
                    fileOutputStream.close();
                    return;
                } catch (Throwable unused5) {
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable th6) {
            th2 = th6;
            fileOutputStream = null;
            u.c("TTCrashHandler", "crash count error", th2);
            if (fileInputStream != null) {
            }
            if (fileOutputStream == null) {
            }
            fileOutputStream.close();
            return;
        }
        throw th;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        throw th;
    }

    private void c() {
        try {
            Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (a2 != null) {
                a2.invoke(null, p.a());
            }
        } catch (Throwable unused) {
        }
        try {
            Method a3 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (a3 != null) {
                a3.invoke(null, p.a());
            }
        } catch (Throwable unused2) {
        }
        try {
            f.a();
        } catch (Throwable unused3) {
        }
        try {
            a.b();
        } catch (Throwable unused4) {
        }
        try {
            String b2 = com.bytedance.sdk.adnet.a.b(p.a());
            if (!TextUtils.isEmpty(b2)) {
                File file = new File(b2);
                if (file.exists()) {
                    l.c(file);
                }
            }
        } catch (Throwable unused5) {
        }
        try {
            g.e();
        } catch (Throwable unused6) {
        }
    }
}
