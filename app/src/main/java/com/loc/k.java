package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public final class k {
    static String a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    static void a(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
            if (context != null) {
                ab.d().submit(new Runnable() {
                    /* class com.loc.k.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[SYNTHETIC, Splitter:B:21:0x0045] */
                    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    public final void run() {
                        Throwable th;
                        FileOutputStream fileOutputStream = null;
                        try {
                            File file = new File(z.c(context, "k.store"));
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(u.a(str));
                                try {
                                    fileOutputStream2.close();
                                    return;
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    y.a(th, "AI", "stf");
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            return;
                                        } catch (Throwable th4) {
                                            th4.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            y.a(th, "AI", "stf");
                            if (fileOutputStream == null) {
                            }
                        }
                        throw th;
                    }
                });
            }
        }
    }

    public static void a(String str) {
        d = str;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (b(a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(a)) {
                b = false;
                a = null;
                return false;
            } else if (b(d)) {
                b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(d)) {
                    b = false;
                    d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager packageManager = context.getPackageManager();
            c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return c;
        } catch (Throwable th) {
            y.a(th, "AI", "gAN");
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    ab.b(u.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String c(Context context) {
        try {
            String str = d;
            if (str != null && !"".equals(str)) {
                return d;
            }
            String packageName = context.getPackageName();
            d = packageName;
            if (!b(packageName)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            y.a(th, "AI", "gpck");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = e;
            return str == null ? "" : str;
        } catch (Throwable th) {
            y.a(th, "AI", "gAV");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(u.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            y.a(th, "AI", "gsp");
            return a;
        }
    }

    public static String f(Context context) {
        try {
            l.a(context);
        } catch (Throwable unused) {
        }
        try {
            return h(context);
        } catch (Throwable th) {
            y.a(th, "AI", "gKy");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[SYNTHETIC, Splitter:B:29:0x0056] */
    private static String g(Context context) {
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(z.c(context, "k.store"));
        String str = "";
        if (!file.exists()) {
            return str;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String a2 = u.a(bArr);
                if (a2.length() == 32) {
                    str = a2;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                try {
                    y.a(th, "AI", "gKe");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            fileInputStream = null;
            th = th7;
            y.a(th, "AI", "gKe");
            if (file.exists()) {
            }
            if (fileInputStream != null) {
            }
            return str;
        }
        throw th;
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        String str = f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
