package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: CpuUtil */
public class d {

    /* compiled from: CpuUtil */
    public static class a {
        public String a;
        public String b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0123, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0124, code lost:
        r3 = null;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0134, code lost:
        r2 = null;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0119, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0123 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0129 A[SYNTHETIC, Splitter:B:110:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0130 A[SYNTHETIC, Splitter:B:114:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0138 A[SYNTHETIC, Splitter:B:121:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x013f A[SYNTHETIC, Splitter:B:125:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0119 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0013] */
    public static a a() {
        int i;
        a aVar;
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        int i2 = 0;
        try {
            aVar = new a();
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
            } catch (Exception unused) {
                bufferedReader = null;
                fileReader = fileReader2;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                i = i2;
                aVar.c = i;
                return aVar;
            } catch (Throwable th) {
                Throwable th2 = th;
                bufferedReader = null;
                Throwable th3 = th2;
                if (fileReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th3;
            }
            try {
                String readLine = bufferedReader.readLine();
                int i3 = 0;
                boolean z = true;
                i = 0;
                while (true) {
                    if (!TextUtils.isEmpty(readLine)) {
                        i3++;
                        if (i3 >= 30) {
                            break;
                        }
                        String[] split = readLine.split(":\\s+", 2);
                        if (z && split != null && split.length > 1) {
                            aVar.a = split[1];
                            z = false;
                        }
                        if (split != null && split.length > 1 && split[0].contains("processor")) {
                            i++;
                        }
                        if (split != null && split.length > 1 && split[0].contains("Features")) {
                            aVar.d = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("implementer")) {
                            aVar.e = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("architecture")) {
                            aVar.f = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("variant")) {
                            aVar.g = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("part")) {
                            aVar.h = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("revision")) {
                            aVar.i = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("Hardware")) {
                            aVar.j = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("Revision")) {
                            aVar.k = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("Serial")) {
                            aVar.l = split[1];
                        }
                        if (split != null && split.length > 1 && split[0].contains("implementer")) {
                            aVar.e = split[1];
                        }
                        readLine = bufferedReader.readLine();
                    }
                }
                try {
                    fileReader2.close();
                } catch (IOException unused2) {
                }
                try {
                    bufferedReader.close();
                    break;
                } catch (IOException unused3) {
                }
            } catch (Exception unused4) {
                fileReader = fileReader2;
                i2 = i;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                i = i2;
                aVar.c = i;
                return aVar;
            } catch (Throwable th4) {
            }
        } catch (Exception unused5) {
            bufferedReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            i = i2;
            aVar.c = i;
            return aVar;
        } catch (Throwable th5) {
        }
        aVar.c = i;
        return aVar;
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022 A[SYNTHETIC, Splitter:B:13:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028 A[SYNTHETIC, Splitter:B:19:0x0028] */
    public static String d() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return trim;
                } catch (Throwable unused) {
                    return trim;
                }
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }
}
