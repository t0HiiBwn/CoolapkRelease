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
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class i {
    private static String a = null;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f707a = false;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f708a = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String b = "";
    private static String c;
    private static String d;
    private static final String e = String.valueOf((char) 2);
    private static String f = null;

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

    private static float a(int i) {
        float f2 = (((float) (((((i + 102400) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d2 = (double) f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    public static int a() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = bd.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    private static int a(String str) {
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

    /* renamed from: a  reason: collision with other method in class */
    public static String m468a() {
        return a(b()) + "GB";
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m469a(int i) {
        if (i > 0) {
            String[] strArr = f708a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f708a[0];
    }

    public static String a(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            b.m41a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        if (c == null) {
            String e2 = e(context);
            String f2 = !l.d() ? z ? f(context) : o(context) : "";
            String d2 = d(context);
            int i = 1;
            if ((Build.VERSION.SDK_INT < 26) || !b(f2) || !b(d2)) {
                e2 = f2 + e2 + d2;
            } else {
                String a2 = ax.a(context).mo105a();
                if (!TextUtils.isEmpty(a2)) {
                    e2 = a2 + e2;
                    i = 2;
                } else {
                    String n = n(context);
                    if (!TextUtils.isEmpty(n)) {
                        e2 = n;
                        i = 3;
                    } else {
                        String b2 = ax.a(context).mo106b();
                        if (!TextUtils.isEmpty(b2)) {
                            i = 4;
                            e2 = b2;
                        } else {
                            i = 5;
                        }
                    }
                }
            }
            b.b("devid rule select:" + i);
            if (i == 3) {
                c = e2;
            } else {
                c = m469a(i) + bi.b(e2);
            }
            b(context, c);
        }
        return c;
    }

    public static void a(Context context, String str) {
        b.c("update vdevid = " + str);
        if (!TextUtils.isEmpty(str)) {
            f = str;
            u uVar = null;
            try {
                if (m475c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    uVar = u.a(context, file2);
                    y.m680a(file2);
                    y.a(file2, f);
                }
                y.a(new File(context.getFilesDir(), ".vdevid"), f);
                if (uVar == null) {
                    return;
                }
            } catch (IOException unused) {
                b.m41a("update vdevid failure.");
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    uVar.a();
                }
                throw th;
            }
            uVar.a();
        }
    }

    public static void a(Context context, Map<String, String> map) {
        if (map != null && context != null) {
            String n = n(context);
            if (!TextUtils.isEmpty(n)) {
                map.put("local_virt_devid", n);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m470a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m471a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f708a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056  */
    public static int b() {
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

    /* renamed from: b  reason: collision with other method in class */
    public static String m472b() {
        double a2 = a(((((double) a(Environment.getDataDirectory())) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String b(Context context) {
        u uVar = null;
        if (!m475c(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String a2 = y.a(new File(context.getFilesDir(), ".vdevid"));
        f = a2;
        if (!TextUtils.isEmpty(a2)) {
            return f;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            u a3 = u.a(context, file);
            f = "";
            String a4 = y.a(file);
            if (a4 != null) {
                f = a4;
            }
            String str = f;
            if (a3 != null) {
                a3.a();
            }
            return str;
        } catch (IOException unused) {
            b.m41a("getVDevID failure.");
            if (0 != 0) {
                uVar.a();
            }
            return f;
        } catch (Throwable th) {
            if (0 != 0) {
                uVar.a();
            }
            throw th;
        }
    }

    private static void b(Context context, String str) {
        b.c("write lvdd = " + str);
        if (!TextUtils.isEmpty(str)) {
            u uVar = null;
            try {
                if (m475c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (!file2.exists() || !file2.isFile()) {
                        uVar = u.a(context, file2);
                        y.m680a(file2);
                        y.a(file2, c + e + a(c));
                        b.b("lvdd write succ.");
                    } else {
                        b.b("vdr exists, not rewrite.");
                        return;
                    }
                } else {
                    b.m41a("not support write lvdd.");
                }
                if (uVar == null) {
                    return;
                }
            } catch (IOException unused) {
                b.m41a("write lvdd failure.");
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    uVar.a();
                }
                throw th;
            }
            uVar.a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m473b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    private static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m474c() {
        return b() + "KB";
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    public static String c(Context context) {
        Throwable th;
        String str;
        u uVar;
        u uVar2 = null;
        if (!m475c(context) || f707a) {
            return null;
        }
        f707a = true;
        String a2 = y.a(new File(context.getFilesDir(), ".vdevid"));
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            uVar = u.a(context, file);
            try {
                str = y.a(file);
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException unused) {
                try {
                    b.m41a("check id failure.");
                    if (uVar != null) {
                    }
                    str = null;
                    if (!TextUtils.isEmpty(a2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    uVar2 = uVar;
                    if (uVar2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException unused2) {
            uVar = null;
            b.m41a("check id failure.");
            if (uVar != null) {
                uVar.a();
            }
            str = null;
            if (!TextUtils.isEmpty(a2)) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (uVar2 != null) {
                uVar2.a();
            }
            throw th;
        }
        if (!TextUtils.isEmpty(a2)) {
            f = a2;
            if (TextUtils.isEmpty(str) || str.length() > 128) {
                b.m41a("recover vid :" + str);
                a(context, a2);
            } else if (!TextUtils.equals(a2, str)) {
                b.m41a("vid changed, need sync");
                return str;
            }
            b.c("vdevid = " + f + " " + str);
            return null;
        }
        b.m41a("empty local vid");
        return "F*";
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m475c(Context context) {
        boolean z = false;
        if ((Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || !m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") || l.m568a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        }
        return !z ? t.m678a(context) : z;
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bi.m140b(str) && !bi.c(str);
    }

    public static String d() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    public static String d(Context context) {
        if (!m476d(context)) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 8 && Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return (String) bd.a("android.os.Build", "getSerial", (Object[]) null);
        }
        return null;
    }

    /* renamed from: d  reason: collision with other method in class */
    private static boolean m476d(Context context) {
        String packageName = context.getPackageName();
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            b.m41a("failure to get androidId: " + th.getMessage());
            return null;
        }
    }

    public static String f(Context context) {
        int c2 = c();
        String g = g(context);
        while (g == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g = g(context);
            c2 = i;
        }
        return g;
    }

    public static String g(Context context) {
        String str;
        Object a2;
        Object a3;
        Object a4;
        if (l.d()) {
            return "";
        }
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (m476d(context)) {
                str = (!l.m568a() || (a3 = bd.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a4 = bd.a(a3, "getMiuiDeviceId", new Object[0])) == null || !(a4 instanceof String)) ? null : (String) String.class.cast(a4);
                if (str == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 26) {
                        str = telephonyManager.getDeviceId();
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            a2 = bd.a((Object) telephonyManager, "getImei", (Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            a2 = bd.a((Object) telephonyManager, "getMeid", (Object[]) null);
                        }
                        str = (String) a2;
                    }
                }
            } else {
                str = null;
            }
            if (!c(str)) {
                return "";
            }
            a = str;
            return str;
        } catch (Throwable th) {
            b.m41a("failure to get id:" + th);
            return null;
        }
    }

    public static String h(Context context) {
        int c2 = c();
        String j = j(context);
        while (j == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            j = j(context);
            c2 = i;
        }
        return j;
    }

    public static String i(Context context) {
        Object a2;
        if (l.d() || Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        g(context);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        try {
            if (m476d(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Integer num = (Integer) bd.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                if (num != null && num.intValue() > 1) {
                    String str = null;
                    for (int i = 0; i < num.intValue(); i++) {
                        if (Build.VERSION.SDK_INT < 26) {
                            a2 = bd.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                        } else if (1 == telephonyManager.getPhoneType()) {
                            a2 = bd.a((Object) telephonyManager, "getImei", Integer.valueOf(i));
                        } else {
                            if (2 == telephonyManager.getPhoneType()) {
                                a2 = bd.a((Object) telephonyManager, "getMeid", Integer.valueOf(i));
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
                }
            }
            return "";
        } catch (Exception e2) {
            b.m41a("failure to get ids: " + e2);
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
                str = str + bi.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String k(Context context) {
        synchronized (i.class) {
            String str = d;
            if (str != null) {
                return str;
            }
            String e2 = e(context);
            String d2 = d(context);
            String b2 = bi.b(e2 + d2);
            d = b2;
            return b2;
        }
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (i.class) {
            String e2 = e(context);
            b2 = bi.b(e2 + ((String) null));
        }
        return b2;
    }

    public static String m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r1 != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0081, code lost:
        if (r1 != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        return r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0087  */
    private static String n(Context context) {
        Throwable th;
        String str;
        u uVar = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        uVar = null;
        if (!m475c(context)) {
            b.m41a("not support read lvdd.");
            return null;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
            if (!file.exists() || !file.isFile()) {
                b.b("lvdf not exists");
                str = null;
            } else {
                u a2 = u.a(context, file);
                try {
                    String a3 = y.a(file);
                    if (!TextUtils.isEmpty(a3)) {
                        String[] split = a3.split(e);
                        if (split.length == 2) {
                            String str3 = split[0];
                            try {
                                if (a(str3) == Integer.parseInt(split[1])) {
                                    str2 = str3;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        y.m680a(file);
                        b.b("lvdd content invalid, remove it.");
                    }
                    uVar = a2;
                    str = str2;
                } catch (IOException unused2) {
                    uVar = a2;
                    str = null;
                    try {
                        b.m41a("get lvdd failure.");
                    } catch (Throwable th2) {
                        th = th2;
                        if (uVar != null) {
                            uVar.a();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    uVar = a2;
                    if (uVar != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException unused3) {
            str = null;
            b.m41a("get lvdd failure.");
        }
    }

    private static String o(Context context) {
        int c2 = c();
        String g = g(context);
        while (TextUtils.isEmpty(g)) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g = g(context);
            c2 = i;
        }
        return g;
    }
}
