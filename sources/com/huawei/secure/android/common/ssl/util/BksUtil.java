package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

public class BksUtil {
    private static final String AUTHORITY = "com.huawei.hwid";
    private static final Uri AUTHORITY_URI = Uri.parse("content://com.huawei.hwid");
    private static final String TAG = "BksUtil";
    private static final String ac = "com.huawei.hwid";
    private static final String ad = "com.huawei.hms";
    private static final String ae = "files/hmsrootcas.bks";
    private static final String af = "4.0.2.300";
    private static final String ag = "aegis";
    private static final String ah = "hmsrootcas.bks";
    private static final long ai = 604800000;
    private static final String aj = "last_update_time";

    private BksUtil() {
    }

    public static synchronized InputStream getBksFromTss(Context context) {
        synchronized (BksUtil.class) {
            String str = TAG;
            g.c(str, "get bks from tss begin");
            if (context != null) {
                c.setContext(context);
            }
            Context k = c.k();
            if (k == null) {
                g.e(str, "context is null");
                return null;
            } else if (!h.g("com.huawei.hwid") && !h.g("com.huawei.hms")) {
                g.e(str, "hms not exist");
                return null;
            } else if (c(h.h("com.huawei.hwid")) || c(h.h("com.huawei.hms"))) {
                try {
                    InputStream openInputStream = k.getContentResolver().openInputStream(Uri.withAppendedPath(AUTHORITY_URI, "files/hmsrootcas.bks"));
                    long b = i.b("last_update_time", 0L, k);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (c(k) && currentTimeMillis - b <= 604800000) {
                        if (b != 0) {
                            g.c(str, "load bks from hms core");
                            return openInputStream;
                        }
                    }
                    i.a("last_update_time", currentTimeMillis, k);
                    a(openInputStream, k);
                    g.c(str, "save last bks and update bks timestamp");
                    if (openInputStream != null) {
                        f.c(openInputStream);
                    }
                    return getFilesBksIS(k);
                } catch (Exception unused) {
                    g.e(TAG, "Get bks from HMS_VERSION_CODE exception : No content provider");
                    return null;
                }
            } else {
                g.e(str, "hms version code is too low : " + h.h("com.huawei.hwid"));
                return null;
            }
        }
    }

    private static void a(InputStream inputStream, Context context) {
        Throwable th;
        if (inputStream != null && context != null) {
            String b = b(context);
            if (!new File(b).exists()) {
                b(b);
            }
            File file = new File(b, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                g.c(TAG, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            f.a((OutputStream) fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        g.e(TAG, " IOException");
                        f.a((OutputStream) fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        f.a((OutputStream) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    f.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                g.e(TAG, " IOException");
                f.a((OutputStream) fileOutputStream);
            }
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            g.d(TAG, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            g.b(TAG, "create directory  success");
            return 0;
        } else {
            g.e(TAG, "create directory  failed");
            return -1;
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e(context);
        try {
            return new FileInputStream(d(context));
        } catch (FileNotFoundException unused) {
            g.e(TAG, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
        }
        return context.getApplicationContext().getFilesDir() + File.separator + "aegis";
    }

    private static boolean c(Context context) {
        return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    private static String d(Context context) {
        return b(context) + File.separator + "hmsrootcas.bks";
    }

    private static void e(Context context) {
        String str = TAG;
        g.c(str, "load bks from aegis folder , time is : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(i.b("last_update_time", 0L, context))));
    }

    private static boolean c(String str) {
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = TAG;
        g.c(str2, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = "4.0.2.300".split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i3 = 0; i3 < max; i3++) {
            if (i3 < length) {
                try {
                    i = Integer.parseInt(split[i3]);
                } catch (Exception e) {
                    String str3 = TAG;
                    g.e(str3, " exception : " + e.getMessage());
                    if (i3 >= length2) {
                        return true;
                    }
                    return false;
                }
            } else {
                i = 0;
            }
            if (i3 < length2) {
                i2 = Integer.parseInt(split2[i3]);
            } else {
                i2 = 0;
            }
            if (i < i2) {
                return false;
            }
            if (i > i2) {
                return true;
            }
        }
        return true;
    }
}
