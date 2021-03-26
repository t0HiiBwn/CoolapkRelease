package com.tencent.tpns.dataacquisition.a;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private static String a;
    private static final String[] b = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    private static final String[] c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};
    private static DisplayMetrics d = null;
    private static int e = -1;
    private static Boolean f = null;
    private static String g = null;
    private static long h = -1;
    private static C0159a i = null;

    /* renamed from: com.tencent.tpns.dataacquisition.a.a$a  reason: collision with other inner class name */
    static class C0159a {

        /* renamed from: com.tencent.tpns.dataacquisition.a.a$a$a  reason: collision with other inner class name */
        class C0160a implements FileFilter {
            C0160a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        C0159a() {
        }

        static int a() {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0160a());
                if (listFiles != null) {
                    return listFiles.length;
                }
                return 1;
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }

        static int b() {
            StringBuilder sb;
            int i = 0;
            InputStream inputStream = null;
            String str = "";
            try {
                InputStream inputStream2 = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream2.read(bArr) != -1) {
                    str = str + new String(bArr);
                }
                String trim = str.trim();
                if (trim.length() > 0) {
                    i = Integer.valueOf(trim).intValue();
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th) {
                        th = th;
                        sb = new StringBuilder();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
            }
            return i * 1000;
            sb.append("unexpected for:");
            sb.append(th.getMessage());
            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
            return i * 1000;
        }

        static int c() {
            StringBuilder sb;
            int i = 0;
            InputStream inputStream = null;
            String str = "";
            try {
                InputStream inputStream2 = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
                byte[] bArr = new byte[24];
                while (inputStream2.read(bArr) != -1) {
                    str = str + new String(bArr, "UTF-8");
                }
                String trim = str.trim();
                if (trim.length() > 0) {
                    i = Integer.valueOf(trim).intValue();
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th) {
                        th = th;
                        sb = new StringBuilder();
                    }
                }
            } catch (IOException e) {
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("getMinCpuFreq", e);
                    if (0 != 0) {
                        inputStream.close();
                    }
                } catch (Throwable th2) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th2.getMessage());
                }
            } catch (Throwable th3) {
                th = th3;
                sb = new StringBuilder();
            }
            return i * 1000;
            throw th;
            sb.append("unexpected for: ");
            sb.append(th.getMessage());
            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
            return i * 1000;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[SYNTHETIC, Splitter:B:25:0x005a] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        static String d() {
            StringBuilder sb;
            Throwable th;
            BufferedReader bufferedReader;
            Throwable th2;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        String[] split = readLine.split(":\\s+", 2);
                        if (split.length > 0) {
                            String str = split[1];
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th3.getMessage());
                            }
                            return str;
                        }
                    }
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Throwable th4) {
                        th = th4;
                        sb = new StringBuilder();
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    try {
                        com.tencent.tpns.dataacquisition.b.a.a("getCpuName", th2);
                        if (bufferedReader != null) {
                        }
                    } catch (Throwable th6) {
                        com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th6.getMessage());
                    }
                }
                sb.append("unexpected for: ");
                sb.append(th.getMessage());
                com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                return "";
                throw th;
            } catch (Throwable th7) {
                bufferedReader = null;
                th2 = th7;
                com.tencent.tpns.dataacquisition.b.a.a("getCpuName", th2);
                if (bufferedReader != null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Throwable th8) {
                    th = th8;
                    sb = new StringBuilder();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for br.close");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
            if (r4 != null) goto L_0x0037;
         */
        static String e() {
            BufferedReader bufferedReader;
            Throwable th;
            String str = "";
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(":\\s+", 2);
                            if (split != null && split[0].trim().toLowerCase().startsWith("hardware")) {
                                str = split[1];
                                break;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.tencent.tpns.dataacquisition.b.a.a("getCpuManufacturer", th);
                        } catch (Throwable unused) {
                            com.tencent.tpns.dataacquisition.b.a.a("unexpected for br.close");
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                com.tencent.tpns.dataacquisition.b.a.a("getCpuManufacturer", th);
            }
            return str;
            throw th;
        }
    }

    static class b {
        private static int a = -1;

        public static boolean a() {
            int i = a;
            if (i == 1) {
                return true;
            }
            if (i == 0) {
                return false;
            }
            String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
            for (int i2 = 0; i2 < 6; i2++) {
                try {
                    if (new File(strArr[i2] + "su").exists()) {
                        a = 1;
                        return true;
                    }
                } catch (Throwable th) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th.getMessage());
                }
            }
            a = 0;
            return false;
        }
    }

    public static Integer a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for getTelephonyNetworkType");
            return null;
        }
    }

    private static String a(List<String> list) {
        if (list.size() == 0) {
            return "unknown";
        }
        String str = list.get(0);
        return str.contains("mumu") ? "mumu" : str.contains("ami") ? "AMIDuOS" : str.contains("bluestacks") ? "蓝叠" : (str.contains("kaopu001") || str.contains("tiantian")) ? "天天" : str.contains("kpzs") ? "靠谱助手" : str.contains("genymotion") ? Build.MODEL.contains("iTools") ? "iTools" : Build.MODEL.contains("ChangWan") ? "畅玩" : "genymotion" : str.contains("uc") ? "uc" : str.contains("blue") ? "blue" : str.contains("microvirt") ? "逍遥" : str.contains("itools") ? "itools" : str.contains("syd") ? "手游岛" : str.contains("bignox") ? "夜神" : str.contains("haimawan") ? "海马玩" : str.contains("windroy") ? "windroy" : str.contains("flysilkworm") ? "雷电" : str.contains("emu") ? "emu" : str.contains("le8") ? "le8" : str.contains("vphone") ? "vphone" : str.contains("duoyi") ? "多益" : Build.MANUFACTURER.toLowerCase().contains("google") ? "Google" : "unknown";
    }

    public static boolean a() {
        try {
            String str = Build.CPU_ABI;
            return !TextUtils.isEmpty(str) && !str.toLowerCase().contains("x86") && !str.toLowerCase().contains("amd");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e A[SYNTHETIC, Splitter:B:30:0x007e] */
    public static String b() {
        String str;
        RandomAccessFile randomAccessFile;
        Throwable th;
        StringBuilder sb;
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        str = "";
        try {
            byte[] bArr = new byte[1024];
            randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
            try {
                if (randomAccessFile.read(bArr) < 0) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th2.getMessage());
                    }
                    return str;
                }
                String str2 = new String(bArr);
                int indexOf = str2.indexOf(0);
                str = indexOf != -1 ? str2.substring(0, indexOf) : str2;
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th = th3;
                    sb = new StringBuilder();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("getCpuString", th);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th5) {
                            th = th5;
                            sb = new StringBuilder();
                        }
                    }
                    return str;
                } catch (Throwable th6) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th6.getMessage());
                }
            }
        } catch (Throwable th7) {
            randomAccessFile = null;
            th = th7;
            com.tencent.tpns.dataacquisition.b.a.a("getCpuString", th);
            if (randomAccessFile != null) {
            }
            return str;
        }
        sb.append("unexpected for: ");
        sb.append(th.getMessage());
        com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
        return str;
        throw th;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            com.tencent.tpns.dataacquisition.b.a.a("Network error");
            return false;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("isNetworkAvailable error", th);
            return false;
        }
    }

    public static byte c(Context context) {
        if (context != null) {
            try {
                if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return 0;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        if (activeNetworkInfo.isConnected()) {
                            if (activeNetworkInfo.getType() == 1) {
                                return 1;
                            }
                            if (activeNetworkInfo.getType() != 0) {
                                return 0;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 15:
                                    return 3;
                                case 12:
                                case 14:
                                default:
                                    return 0;
                                case 13:
                                    return 4;
                            }
                        }
                    }
                    return -1;
                }
            } catch (Throwable th) {
                com.tencent.tpns.dataacquisition.b.a.a("getNetworkType: ", th);
            }
        }
        return -1;
    }

    public static String c() {
        String str;
        StringBuilder sb;
        String str2;
        String b2 = b();
        if (b2.contains("ARMv5")) {
            str = "armv5";
        } else if (b2.contains("ARMv6")) {
            str = "armv6";
        } else if (b2.contains("ARMv7")) {
            str = "armv7";
        } else if (!b2.contains("Intel")) {
            return "unknown";
        } else {
            str = "x86";
        }
        if (b2.contains("neon")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_neon";
        } else if (b2.contains("vfpv3")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfpv3";
        } else if (b2.contains(" vfp")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfp";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_none";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static String d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(e() / 1000000);
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName());
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("Check isWiFiActive error", th);
            return false;
        }
    }

    public static long e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static String e(Context context) {
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.INTERNET") || !com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                com.tencent.tpns.dataacquisition.b.a.b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return null;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (typeName == null) {
                return null;
            }
            if ("WIFI".equalsIgnoreCase(typeName)) {
                return "WIFI";
            }
            if ("MOBILE".equalsIgnoreCase(typeName)) {
                if (extraInfo == null) {
                    return "MOBILE";
                }
            } else if (extraInfo == null) {
                return typeName;
            }
            return extraInfo;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.b(th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r0 != null) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[SYNTHETIC, Splitter:B:26:0x0065] */
    public static long f() {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        long j = h;
        long j2 = 0;
        if (j > 0) {
            return j;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j2 = ((long) Integer.valueOf(readLine.split("\\s+")[1]).intValue()) * 1024;
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + e2.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            bufferedReader = null;
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + e2.getMessage());
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused2) {
        }
        h = j2;
        return j2;
    }

    public static DisplayMetrics f(Context context) {
        if (d == null) {
            d = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(d);
        }
        return d;
    }

    public static String g(Context context) {
        if (a == null) {
            a = Build.MODEL;
        }
        return a;
    }

    public static boolean g() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("isSDCardMounted", th);
            return false;
        }
    }

    public static String h() {
        try {
            NumberFormat instance = NumberFormat.getInstance();
            instance.setGroupingUsed(false);
            return instance.format(((double) (System.currentTimeMillis() - SystemClock.elapsedRealtime())) / 1000.0d);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean h(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    public static int i(Context context) {
        int i2 = e;
        if (i2 >= 0) {
            return i2;
        }
        try {
            return b.a() ? 1 : 0;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("call hasRootAccess Error:", th);
            return 0;
        }
    }

    public static String i() {
        return "";
    }

    public static String j(Context context) {
        String path;
        try {
            if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!(externalStorageState == null || !externalStorageState.equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null)) {
                    StatFs statFs = new StatFs(path);
                    return String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000);
                }
                return null;
            }
            com.tencent.tpns.dataacquisition.b.a.a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getExternalStorageInfo err:", th);
        }
    }

    public static int k(Context context) {
        if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            return 0;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return -1;
        }
        return defaultAdapter.isEnabled() ? 1 : 0;
    }

    public static boolean l(Context context) {
        if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            return true;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return defaultAdapter != null && !TextUtils.isEmpty(defaultAdapter.getName());
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean m(Context context) {
        try {
            Sensor defaultSensor = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5);
            return defaultSensor != null && !TextUtils.isEmpty(defaultSensor.getName());
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean n(Context context) {
        if (f == null) {
            f = Boolean.valueOf(!a() || !l(context) || !m(context));
        }
        return f.booleanValue();
    }

    public static String o(Context context) {
        if (g == null) {
            g = a(x(context));
        }
        return g;
    }

    public static String p(Context context) {
        return String.valueOf(y(context) / 1000000) + "/" + String.valueOf(f() / 1000000);
    }

    public static JSONObject q(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            z(context);
            int b2 = C0159a.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / 1000000);
            }
            z(context);
            int c2 = C0159a.c();
            if (c2 > 0) {
                jSONObject.put("fn", c2 / 1000000);
            }
            z(context);
            int a2 = C0159a.a();
            if (a2 > 0) {
                jSONObject.put("n", a2);
            }
            z(context);
            String d2 = C0159a.d();
            if (!(d2 == null || d2.length() == 0)) {
                z(context);
                jSONObject.put("na", C0159a.d());
            }
            z(context);
            jSONObject.put("m", C0159a.e());
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getCpuInfo", th);
        }
        return jSONObject;
    }

    public static String r(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                sb.append(sensorList.get(i2).getType());
                if (i2 != sensorList.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getAllSensors", th);
            return "";
        }
    }

    public static JSONArray s(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                Sensor sensor = sensorList.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getSensors:" + th.toString());
            return null;
        }
    }

    public static boolean t(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("Util -> isScreenOn", th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ all -> 0x0027 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ all -> 0x0027 }] */
    public static int u(Context context) {
        boolean z;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra != 2) {
                if (intExtra != 5) {
                    z = false;
                    if (z) {
                        return -1;
                    }
                    return registerReceiver.getIntExtra("plugged", -1);
                }
            }
            z = true;
            if (z) {
            }
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("Util -> getChangedStatus", th);
            return -1;
        }
    }

    public static String v(Context context) {
        String name;
        if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            return "";
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (defaultAdapter == null || (name = defaultAdapter.getName()) == null) ? "" : name;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String w(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static List<String> x(Context context) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                String[] strArr = b;
                if (i3 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i3], 1);
                    arrayList.add(strArr[i3]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i3++;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = c;
                if (i2 >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i2]).exists()) {
                    arrayList.add(strArr2[i2]);
                }
                i2++;
            }
        }
        return arrayList;
    }

    private static long y(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static synchronized C0159a z(Context context) {
        C0159a aVar;
        synchronized (a.class) {
            if (i == null) {
                i = new C0159a();
            }
            aVar = i;
        }
        return aVar;
    }
}
