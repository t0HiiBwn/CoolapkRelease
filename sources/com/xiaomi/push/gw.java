package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class gw {
    private static String a = null;
    private static String b = "";
    private static String c;
    private static String d;
    private static final String e = String.valueOf((char) 2);
    private static final String[] f = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String g = null;
    private static volatile boolean h = false;

    private static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = (double) i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    private static long a(File file) {
        long j;
        long j2;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockCountLong();
            j = statFs.getBlockSizeLong();
        } else {
            j2 = (long) statFs.getBlockCount();
            j = (long) statFs.getBlockSize();
        }
        return j * j2;
    }

    public static String a() {
        if (Build.VERSION.SDK_INT > 8 && Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return (String) ac.a("android.os.Build", "getSerial", (Object[]) null);
        }
        return null;
    }

    private static String a(int i) {
        if (i > 0) {
            String[] strArr = f;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f[0];
    }

    public static String a(Context context) {
        String e2 = e(context);
        return "a-" + ah.b(((String) null) + e2 + ((String) null));
    }

    public static String a(Context context, boolean z) {
        if (c == null) {
            String e2 = e(context);
            String f2 = !it.g() ? z ? f(context) : s(context) : "";
            String a2 = a();
            int i = 1;
            if ((Build.VERSION.SDK_INT < 26) || !TextUtils.isEmpty(f2) || !TextUtils.isEmpty(a2)) {
                e2 = f2 + e2 + a2;
            } else {
                String b2 = v.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                    e2 = b2 + e2;
                    i = 2;
                } else {
                    String r = r(context);
                    if (!TextUtils.isEmpty(r)) {
                        e2 = r;
                        i = 3;
                    } else {
                        String c2 = v.a(context).c();
                        if (!TextUtils.isEmpty(c2)) {
                            i = 4;
                            e2 = c2;
                        } else {
                            i = 5;
                        }
                    }
                }
            }
            c.b("devid rule select:" + i);
            if (i == 3) {
                c = e2;
            } else {
                c = a(i) + ah.b(e2);
            }
            b(context, c);
        }
        return c;
    }

    public static void a(Context context, String str) {
        c.c("update vdevid = " + str);
        if (!TextUtils.isEmpty(str)) {
            g = str;
            jc jcVar = null;
            try {
                if (q(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    jcVar = jc.a(context, file2);
                    jg.a(file2);
                    jg.a(file2, g);
                }
                jg.a(new File(context.getFilesDir(), ".vdevid"), g);
                if (jcVar == null) {
                    return;
                }
            } catch (IOException e2) {
                c.a("update vdevid failure :" + e2.getMessage());
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    jcVar.a();
                }
                throw th;
            }
            jcVar.a();
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    private static float b(int i) {
        float f2 = (((float) (((((i + 102400) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d2 = (double) f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    public static int b() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = ac.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 31) + str.charAt(i2);
        }
        return i;
    }

    public static String b(Context context) {
        try {
            return hx.a(context).a();
        } catch (Exception e2) {
            c.a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    private static void b(Context context, String str) {
        c.c("write lvdd = " + str);
        if (!TextUtils.isEmpty(str)) {
            jc jcVar = null;
            try {
                if (q(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (!file2.exists() || !file2.isFile()) {
                        jcVar = jc.a(context, file2);
                        jg.a(file2);
                        jg.a(file2, c + e + b(c));
                        c.b("lvdd write succ.");
                    } else {
                        c.b("vdr exists, not rewrite.");
                        return;
                    }
                } else {
                    c.a("not support write lvdd.");
                }
                if (jcVar == null) {
                    return;
                }
            } catch (IOException e2) {
                c.a("write lvdd failure :" + e2.getMessage());
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    jcVar.a();
                }
                throw th;
            }
            jcVar.a();
        }
    }

    public static String c() {
        return b(d()) + "GB";
    }

    public static String c(Context context) {
        jc jcVar = null;
        if (!q(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        String b2 = jg.b(new File(context.getFilesDir(), ".vdevid"));
        g = b2;
        if (!TextUtils.isEmpty(b2)) {
            return g;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            jc a2 = jc.a(context, file);
            g = "";
            String b3 = jg.b(file);
            if (b3 != null) {
                g = b3;
            }
            String str = g;
            if (a2 != null) {
                a2.a();
            }
            return str;
        } catch (IOException e2) {
            c.a("getVDevID failure :" + e2.getMessage());
            if (0 != 0) {
                jcVar.a();
            }
            return g;
        } catch (Throwable th) {
            if (0 != 0) {
                jcVar.a();
            }
            throw th;
        }
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && ah.e(str) && !ah.f(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056  */
    public static int d() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        int i = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        i = Integer.parseInt(split[1]);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return i;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9  */
    public static String d(Context context) {
        Throwable th;
        String str;
        IOException e2;
        jc jcVar;
        jc jcVar2 = null;
        if (!q(context) || h) {
            return null;
        }
        h = true;
        String b2 = jg.b(new File(context.getFilesDir(), ".vdevid"));
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            jcVar = jc.a(context, file);
            try {
                str = jg.b(file);
                if (jcVar != null) {
                    jcVar.a();
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    c.a("check id failure :" + e2.getMessage());
                    if (jcVar != null) {
                        jcVar.a();
                    }
                    str = null;
                    if (!TextUtils.isEmpty(b2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jcVar2 = jcVar;
                    if (jcVar2 != null) {
                        jcVar2.a();
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            jcVar = null;
            c.a("check id failure :" + e2.getMessage());
            if (jcVar != null) {
            }
            str = null;
            if (!TextUtils.isEmpty(b2)) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (jcVar2 != null) {
            }
            throw th;
        }
        if (!TextUtils.isEmpty(b2)) {
            g = b2;
            if (TextUtils.isEmpty(str) || str.length() > 128) {
                c.a("recover vid :" + str);
                a(context, b2);
            } else if (!TextUtils.equals(b2, str)) {
                c.a("vid changed, need sync");
                return str;
            }
            c.c("vdevid = " + g + " " + str);
            return null;
        }
        c.a("empty local vid");
        return "F*";
    }

    public static String e() {
        double a2 = a(((((double) a(Environment.getDataDirectory())) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static String f() {
        return d() + "KB";
    }

    public static String f(Context context) {
        int h2 = h();
        String g2 = g(context);
        while (g2 == null) {
            int i = h2 - 1;
            if (h2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            h2 = i;
        }
        return g2;
    }

    public static String g() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    public static String g(Context context) {
        Object a2;
        Object a3;
        Object a4;
        if (it.g()) {
            return "";
        }
        String str = a;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (!it.a() || (a3 = ac.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a4 = ac.a(a3, "getMiuiDeviceId", new Object[0])) == null || !(a4 instanceof String)) ? null : (String) String.class.cast(a4);
            if (str2 == null && t(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str2 = telephonyManager.getDeviceId();
                } else {
                    if (1 == telephonyManager.getPhoneType()) {
                        a2 = ac.a(telephonyManager, "getImei", (Object[]) null);
                    } else if (2 == telephonyManager.getPhoneType()) {
                        a2 = ac.a(telephonyManager, "getMeid", (Object[]) null);
                    }
                    str2 = (String) a2;
                }
            }
            if (!c(str2)) {
                return "";
            }
            a = str2;
            return str2;
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    private static int h() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    public static String h(Context context) {
        int h2 = h();
        String j = j(context);
        while (j == null) {
            int i = h2 - 1;
            if (h2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            j = j(context);
            h2 = i;
        }
        return j;
    }

    public static String i(Context context) {
        Object a2;
        if (it.g() || Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        if (!t(context)) {
            return "";
        }
        g(context);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Integer num = (Integer) ac.a(telephonyManager, "getPhoneCount", new Object[0]);
            if (num == null || num.intValue() <= 1) {
                return "";
            }
            String str = null;
            for (int i = 0; i < num.intValue(); i++) {
                if (Build.VERSION.SDK_INT < 26) {
                    a2 = ac.a(telephonyManager, "getDeviceId", Integer.valueOf(i));
                } else if (1 == telephonyManager.getPhoneType()) {
                    a2 = ac.a(telephonyManager, "getImei", Integer.valueOf(i));
                } else {
                    if (2 == telephonyManager.getPhoneType()) {
                        a2 = ac.a(telephonyManager, "getMeid", Integer.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(a, str) && c(str)) {
                        b += str + ",";
                    }
                }
                str = (String) a2;
                b += str + ",";
            }
            int length = b.length();
            if (length > 0) {
                b = b.substring(0, length - 1);
            }
            return b;
        } catch (Exception e2) {
            c.d(e2.toString());
            return "";
        }
    }

    public static String j(Context context) {
        i(context);
        String str = "";
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String[] split = b.split(",");
        for (String str2 : split) {
            if (c(str2)) {
                str = str + ah.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String k(Context context) {
        synchronized (gw.class) {
            String str = d;
            if (str != null) {
                return str;
            }
            String e2 = e(context);
            String a2 = a();
            String b2 = ah.b(e2 + a2);
            d = b2;
            return b2;
        }
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (gw.class) {
            String e2 = e(context);
            b2 = ah.b(e2 + ((String) null));
        }
        return b2;
    }

    public static String m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String n(Context context) {
        return "";
    }

    public static boolean o(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean p(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean q(Context context) {
        boolean z = false;
        if (!iu.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") || it.a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        }
        return !z ? jb.b(context) : z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r1 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        if (r1 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        return r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009c  */
    private static String r(Context context) {
        Throwable th;
        String str;
        IOException e2;
        jc jcVar = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        jcVar = null;
        if (!q(context)) {
            c.a("not support read lvdd.");
            return null;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
            if (!file.exists() || !file.isFile()) {
                c.b("lvdf not exists");
                str = null;
            } else {
                jc a2 = jc.a(context, file);
                try {
                    String b2 = jg.b(file);
                    if (!TextUtils.isEmpty(b2)) {
                        String[] split = b2.split(e);
                        if (split.length == 2) {
                            String str3 = split[0];
                            try {
                                if (b(str3) == Integer.parseInt(split[1])) {
                                    str2 = str3;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        jg.a(file);
                        c.b("lvdd content invalid, remove it.");
                    }
                    jcVar = a2;
                    str = str2;
                } catch (IOException e3) {
                    e2 = e3;
                    jcVar = a2;
                    str = null;
                    try {
                        c.a("get lvdd failure :" + e2.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        if (jcVar != null) {
                            jcVar.a();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jcVar = a2;
                    if (jcVar != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            str = null;
            c.a("get lvdd failure :" + e2.getMessage());
        }
    }

    private static String s(Context context) {
        int h2 = h();
        String g2 = g(context);
        while (TextUtils.isEmpty(g2)) {
            int i = h2 - 1;
            if (h2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            h2 = i;
        }
        return g2;
    }

    private static boolean t(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }
}
