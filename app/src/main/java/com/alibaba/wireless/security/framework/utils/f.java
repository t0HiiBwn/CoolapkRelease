package com.alibaba.wireless.security.framework.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class f {
    private static String[] a = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g = false;

    public static String a(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String a2 = a(classLoader, str, true);
        return a2 == null ? a(classLoader, str, false) : a2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        Method method;
        if (classLoader == null) {
            return null;
        }
        if (z) {
            try {
                method = classLoader.getClass().getMethod("findLibrary", String.class);
            } catch (Exception unused) {
                return null;
            }
        } else {
            method = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
        }
        if (method == null) {
            return null;
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        Object invoke = method.invoke(classLoader, str);
        if (invoke == null) {
            return null;
        }
        if (invoke instanceof String) {
            return (String) invoke;
        }
        return null;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if ((r3.applicationInfo.flags & 128) == 0) goto L_0x0025;
     */
    public static boolean a(Context context) {
        boolean z;
        if (b) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                z = true;
                if (packageInfo != null) {
                    if ((packageInfo.applicationInfo.flags & 1) != 0) {
                    }
                }
            } catch (Throwable unused) {
            }
            z = false;
            c = z;
            b = false;
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r1 = r2;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[SYNTHETIC, Splitter:B:29:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064 A[SYNTHETIC, Splitter:B:35:0x0064] */
    public static boolean a(String str, String str2, File file) {
        IOException e2;
        boolean z = false;
        z = false;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                String[] strArr = a;
                boolean z2 = false;
                for (String str3 : strArr) {
                    ZipEntry entry = zipFile2.getEntry("lib" + File.separator + str3 + File.separator + str2);
                    if (entry != null) {
                        if (entry.getSize() != 0) {
                            z2 = a(zipFile2, entry, file);
                        }
                    }
                }
                try {
                    zipFile2.close();
                    return z2;
                } catch (IOException unused) {
                    return z2;
                }
            } catch (IOException e3) {
                e2 = e3;
                zipFile = zipFile2;
                try {
                    a.a("", e2);
                    if (zipFile != null) {
                    }
                    return z;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (zipFile != null) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
            }
        } catch (IOException e4) {
            e2 = e4;
            a.a("", e2);
            if (zipFile != null) {
            }
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009a A[SYNTHETIC, Splitter:B:49:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1 A[SYNTHETIC, Splitter:B:53:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ac A[SYNTHETIC, Splitter:B:62:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b3 A[SYNTHETIC, Splitter:B:66:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00bb  */
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        File file2;
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        boolean z = false;
        if (zipFile == null || zipEntry == null || file == null) {
            return false;
        }
        InputStream inputStream2 = null;
        try {
            file2 = new File(file.getAbsolutePath() + ".tmp." + Process.myPid());
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                inputStream = zipFile.getInputStream(zipEntry);
            } catch (Exception unused) {
                fileOutputStream = null;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                file2.delete();
                if (!z) {
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                file2.delete();
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception unused2) {
                fileOutputStream = null;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                file2.delete();
                if (!z) {
                }
                return z;
            } catch (Throwable th4) {
                th2 = th4;
                fileOutputStream = null;
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                file2.delete();
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (!file.exists() || file.length() != zipEntry.getSize()) {
                        if (file2.exists() && file2.length() == zipEntry.getSize()) {
                            file.delete();
                            z = file2.renameTo(file);
                        }
                        file2.delete();
                        if (!z || !file.exists() || file.length() <= 0 || file.length() != zipEntry.getSize()) {
                            return z;
                        }
                        return true;
                    }
                    z = true;
                    file2.delete();
                    if (!z) {
                    }
                    return z;
                } catch (Exception unused3) {
                    if (inputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    file2.delete();
                    if (!z) {
                    }
                    return z;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    file2.delete();
                    throw th;
                }
            } catch (Exception unused4) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                file2.delete();
                if (!z) {
                }
                return z;
            } catch (Throwable th6) {
                th2 = th6;
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused8) {
                    }
                }
                file2.delete();
                throw th;
            }
        } catch (Exception unused9) {
            file2 = null;
            fileOutputStream = null;
            if (inputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            file2.delete();
            if (!z) {
            }
            return z;
        } catch (Throwable th7) {
            th = th7;
            file2 = null;
            fileOutputStream = null;
            if (inputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            file2.delete();
            throw th;
        }
    }

    public static boolean b(Context context) {
        boolean z;
        if (d) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (!(packageInfo == null || (packageInfo.applicationInfo.flags & 128) == 0)) {
                    z = true;
                    e = z;
                    d = false;
                }
            } catch (Throwable unused) {
            }
            z = false;
            e = z;
            d = false;
        }
        return e;
    }

    public static boolean c(Context context) {
        if (f) {
            try {
                String d2 = d(context);
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    packageName = packageName + ":fore";
                }
                g = d2.equals(packageName);
                f = false;
            } catch (Exception unused) {
            }
        }
        return g;
    }

    public static String d(Context context) {
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName != null ? runningAppProcessInfo.processName : "";
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
