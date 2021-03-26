package com.tencent.open.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.open.a.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public class h {
    public static String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        return split2.length > i ? -1 : 0;
    }

    public static boolean a(Context context, String str, String str2) {
        f.a("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (j.f(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static String b(Context context, String str) {
        String str2 = "";
        f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(signatureArr[0].toByteArray());
            String a = j.a(instance.digest());
            instance.reset();
            f.a("openSDK_LOG.SystemUtils", "-->sign: " + a);
            instance.update(j.i(packageName + "_" + a + "_" + str + str2));
            str2 = j.a(instance.digest());
            instance.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            f.a("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, "com.tencent.tim"), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0 A[SYNTHETIC, Splitter:B:43:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7 A[SYNTHETIC, Splitter:B:47:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be A[SYNTHETIC, Splitter:B:53:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5 A[SYNTHETIC, Splitter:B:57:0x00c5] */
    public static boolean a(String str, String str2, int i) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
        Context a = e.a();
        if (a == null) {
            f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = a.getSharedPreferences("secure_lib", 0);
        File file = new File(a.getFilesDir(), str2);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            int i2 = sharedPreferences.getInt("version", 0);
            f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
        }
        InputStream inputStream = null;
        r4 = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            InputStream open = a.getAssets().open(str);
            try {
                fileOutputStream2 = a.openFileOutput(str2, 0);
                a(open, fileOutputStream2);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", i);
                edit.commit();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                try {
                    f.b("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            f.b("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                f.c("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static int a(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return 10105;
        }
        if ("sendToMyComputer".equals(str)) {
            return 10106;
        }
        if ("shareToTroopBar".equals(str)) {
            return 10107;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        return "action_request".equals(str) ? 10100 : -1;
    }
}
