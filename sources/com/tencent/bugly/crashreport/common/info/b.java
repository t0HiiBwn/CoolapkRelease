package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: BUGLY */
public class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static final String[] b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    private static final String[] c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    public static String j() {
        return "";
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                return "null";
            }
            return string.toLowerCase();
        } catch (Throwable th) {
            if (!x.a(th)) {
                x.a("Failed to get Android ID.", new Object[0]);
            }
            return "fail";
        }
    }

    private static boolean n() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static String a(Context context, boolean z) {
        String str = null;
        if (z) {
            try {
                String a2 = z.a(context, "ro.product.cpu.abilist");
                if (z.a(a2) || a2.equals("fail")) {
                    a2 = z.a(context, "ro.product.cpu.abi");
                }
                if (!z.a(a2)) {
                    if (!a2.equals("fail")) {
                        x.b(b.class, "ABI list: " + a2, new Object[0]);
                        str = a2.split(",")[0];
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        if (str == null) {
            str = System.getProperty("os.arch");
        }
        return str;
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088 A[SYNTHETIC, Splitter:B:44:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0098 A[SYNTHETIC, Splitter:B:51:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    public static long f() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1;
                        } catch (IOException e2) {
                            if (x.a(e2)) {
                                return -1;
                            }
                            e2.printStackTrace();
                            return -1;
                        }
                    } else {
                        long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!x.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return parseLong;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2;
                        }
                        try {
                            return -2;
                        } catch (IOException e5) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                if (!x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e5) {
                                if (!x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (!x.a(th)) {
                }
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
            if (!x.a(th)) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fb A[Catch:{ all -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0100 A[SYNTHETIC, Splitter:B:76:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0110 A[SYNTHETIC, Splitter:B:83:0x0110] */
    public static long g() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!x.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!x.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!x.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!x.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!x.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2;
                        }
                        try {
                            return -2;
                        } catch (IOException e9) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                if (!x.a(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e9) {
                                if (!x.a(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!x.a(th)) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            if (!x.a(th)) {
            }
        }
    }

    public static long h() {
        if (!n()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (x.a(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static long i() {
        if (!n()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (x.a(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static String k() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
        } catch (Exception e) {
            if (x.a(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }

    public static String c(Context context) {
        String a2 = z.a(context, "ro.miui.ui.version.name");
        if (z.a(a2) || a2.equals("fail")) {
            String a3 = z.a(context, "ro.build.version.emui");
            if (z.a(a3) || a3.equals("fail")) {
                String a4 = z.a(context, "ro.lenovo.series");
                if (z.a(a4) || a4.equals("fail")) {
                    String a5 = z.a(context, "ro.build.nubia.rom.name");
                    if (z.a(a5) || a5.equals("fail")) {
                        String a6 = z.a(context, "ro.meizu.product.model");
                        if (z.a(a6) || a6.equals("fail")) {
                            String a7 = z.a(context, "ro.build.version.opporom");
                            if (z.a(a7) || a7.equals("fail")) {
                                String a8 = z.a(context, "ro.vivo.os.build.display.id");
                                if (z.a(a8) || a8.equals("fail")) {
                                    String a9 = z.a(context, "ro.aa.romver");
                                    if (z.a(a9) || a9.equals("fail")) {
                                        String a10 = z.a(context, "ro.lewa.version");
                                        if (z.a(a10) || a10.equals("fail")) {
                                            String a11 = z.a(context, "ro.gn.gnromvernumber");
                                            if (z.a(a11) || a11.equals("fail")) {
                                                String a12 = z.a(context, "ro.build.tyd.kbstyle_version");
                                                if (z.a(a12) || a12.equals("fail")) {
                                                    return z.a(context, "ro.build.fingerprint") + "/" + z.a(context, "ro.build.rom.id");
                                                }
                                                return "dido/" + a12;
                                            }
                                            return "amigo/" + a11 + "/" + z.a(context, "ro.build.display.id");
                                        }
                                        return "tcl/" + a10 + "/" + z.a(context, "ro.build.display.id");
                                    }
                                    return "htc/" + a9 + "/" + z.a(context, "ro.build.description");
                                }
                                return "vivo/FUNTOUCH/" + a8;
                            }
                            return "Oppo/COLOROS/" + a7;
                        }
                        return "Meizu/FLYME/" + z.a(context, "ro.build.display.id");
                    }
                    return "Zte/NUBIA/" + a5 + "_" + z.a(context, "ro.build.nubia.rom.code");
                }
                String a13 = z.a(context, "ro.build.version.incremental");
                return "Lenovo/VIBE/" + a13;
            }
            return "HuaWei/EMOTION/" + a3;
        }
        return "XiaoMi/MIUI/" + a2;
    }

    public static String d(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static boolean l() {
        boolean z;
        String[] strArr = a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    public static boolean e(Context context) {
        File file;
        if (g(context) != null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = c;
            if (i >= strArr.length) {
                break;
            }
            if (i == 0) {
                String str = strArr[i];
                if (file.exists()) {
                    i++;
                }
            } else {
                file = new File(strArr[i]);
                if (!file.exists()) {
                    i++;
                }
            }
            arrayList.add(Integer.valueOf(i));
            i++;
        }
        return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
    }

    private static String g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static boolean f(Context context) {
        return (((h(context) | p()) | q()) | o()) > 0;
    }

    private static int o() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            if (method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy")) {
                return 256;
            }
            return 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    private static int h(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int p() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba A[SYNTHETIC, Splitter:B:48:0x00ba] */
    private static int q() {
        Throwable th;
        BufferedReader bufferedReader;
        UnsupportedEncodingException e;
        FileNotFoundException e2;
        IOException e3;
        int i = 0;
        BufferedReader bufferedReader2 = null;
        try {
            HashSet hashSet = new HashSet();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                    }
                } catch (UnsupportedEncodingException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                } catch (FileNotFoundException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                } catch (IOException e6) {
                    e3 = e6;
                    try {
                        e3.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                }
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (((String) next).toLowerCase().contains("xposed")) {
                    i |= 64;
                }
                if (((String) next).contains("com.saurik.substrate")) {
                    i |= 128;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        } catch (UnsupportedEncodingException e8) {
            bufferedReader = null;
            e = e8;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            return i;
        } catch (FileNotFoundException e9) {
            bufferedReader = null;
            e2 = e9;
            e2.printStackTrace();
            if (bufferedReader != null) {
            }
            return i;
        } catch (IOException e10) {
            bufferedReader = null;
            e3 = e10;
            e3.printStackTrace();
            if (bufferedReader != null) {
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        return i;
    }

    public static boolean m() {
        float maxMemory = (float) (((double) Runtime.getRuntime().maxMemory()) / 1048576.0d);
        float f = (float) (((double) Runtime.getRuntime().totalMemory()) / 1048576.0d);
        float f2 = maxMemory - f;
        x.c("maxMemory : %f", Float.valueOf(maxMemory));
        x.c("totalMemory : %f", Float.valueOf(f));
        x.c("freeMemory : %f", Float.valueOf(f2));
        if (f2 < 10.0f) {
            return true;
        }
        return false;
    }
}
