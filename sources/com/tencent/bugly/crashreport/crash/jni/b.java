package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public final class b {
    private static List<File> a = new ArrayList();

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    x.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            x.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    protected static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (a.a(context) == null) {
            x.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 == null || str3.trim().length() <= 0) {
            x.e("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> d = d(str3);
        if (d == null) {
            x.e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            d.get("sino").intValue();
            d.get("sud").intValue();
            String str4 = map.get("soVersion");
            if (TextUtils.isEmpty(str4)) {
                x.e("error format at version", new Object[0]);
                return null;
            }
            String str5 = map.get("errorAddr");
            String str6 = "unknown";
            String str7 = str5 == null ? str6 : str5;
            String str8 = map.get("codeMsg");
            if (str8 == null) {
                str8 = str6;
            }
            String str9 = map.get("tombPath");
            String str10 = str9 == null ? str6 : str9;
            String str11 = map.get("signalName");
            if (str11 == null) {
                str11 = str6;
            }
            map.get("errnoMsg");
            String str12 = map.get("stack");
            if (str12 == null) {
                str12 = str6;
            }
            String str13 = map.get("jstack");
            if (str13 != null) {
                str12 = str12 + "java:\n" + str13;
            }
            Integer num = d.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str8;
                str2 = str11;
            } else {
                str2 = str11 + "(" + str8 + ")";
                str = "KERNEL";
            }
            String str14 = map.get("nativeLog");
            byte[] a2 = (str14 == null || str14.isEmpty()) ? null : z.a((File) null, str14, "BuglyNativeLog.txt");
            String str15 = map.get("sendingProcess");
            if (str15 == null) {
                str15 = str6;
            }
            Integer num2 = d.get("spd");
            if (num2 != null) {
                str15 = str15 + "(" + num2 + ")";
            }
            String str16 = map.get("threadName");
            if (str16 == null) {
                str16 = str6;
            }
            Integer num3 = d.get("et");
            if (num3 != null) {
                str16 = str16 + "(" + num3 + ")";
            }
            String str17 = map.get("processName");
            if (str17 != null) {
                str6 = str17;
            }
            Integer num4 = d.get("ep");
            if (num4 != null) {
                str6 = str6 + "(" + num4 + ")";
            }
            String str18 = map.get("key-value");
            if (str18 != null) {
                HashMap hashMap2 = new HashMap();
                String[] split = str18.split("\n");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split("=");
                    if (split2.length == 2) {
                        hashMap2.put(split2[0], split2[1]);
                    }
                    i++;
                    split = split;
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str6, str16, (((long) d.get("etms").intValue()) / 1000) + (((long) d.get("ets").intValue()) * 1000), str2, str7, a(str12), str, str15, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, a2, hashMap, false, false);
            if (packageCrashDatas != null) {
                String str19 = map.get("userId");
                if (str19 != null) {
                    x.c("[Native record info] userId: %s", str19);
                    packageCrashDatas.m = str19;
                }
                String str20 = map.get("sysLog");
                if (str20 != null) {
                    packageCrashDatas.w = str20;
                }
                String str21 = map.get("appVersion");
                if (str21 != null) {
                    x.c("[Native record info] appVersion: %s", str21);
                    packageCrashDatas.f = str21;
                }
                String str22 = map.get("isAppForeground");
                if (str22 != null) {
                    x.c("[Native record info] isAppForeground: %s", str22);
                    packageCrashDatas.N = str22.equalsIgnoreCase("true");
                }
                String str23 = map.get("launchTime");
                if (str23 != null) {
                    x.c("[Native record info] launchTime: %s", str23);
                    try {
                        packageCrashDatas.M = Long.parseLong(str23);
                    } catch (NumberFormatException e) {
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                packageCrashDatas.z = null;
                packageCrashDatas.k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            x.e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[DONT_GENERATE] */
    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            x.a(th);
            return null;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008b A[SYNTHETIC, Splitter:B:49:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0098 A[SYNTHETIC, Splitter:B:57:0x0098] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        IOException e;
        String str2;
        String a2;
        BufferedInputStream bufferedInputStream2 = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            x.e("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                String a3 = a(bufferedInputStream);
                if (a3 != null) {
                    if (a3.equals("NATIVE_RQD_REPORT")) {
                        HashMap hashMap = new HashMap();
                        loop0:
                        while (true) {
                            str2 = null;
                            while (true) {
                                a2 = a(bufferedInputStream);
                                if (a2 != null) {
                                    if (str2 != null) {
                                        break;
                                    }
                                    str2 = a2;
                                } else {
                                    break loop0;
                                }
                            }
                            hashMap.put(str2, a2);
                        }
                        if (str2 != null) {
                            x.e("record not pair! drop! %s", str2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return null;
                        }
                        CrashDetailBean a4 = a(context, hashMap, nativeExceptionHandler);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return a4;
                    }
                }
                x.e("record read fail! %s", a3);
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return null;
            } catch (IOException e5) {
                e = e5;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            bufferedInputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
    }

    private static String b(String str, String str2) {
        BufferedReader a2 = z.a(str, "reg_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    int i = 18;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        String readLine2 = a2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (i2 % 4 == 0) {
                            if (i2 > 0) {
                                sb.append("\n");
                            }
                            sb.append("  ");
                        } else {
                            if (readLine2.length() > 16) {
                                i = 28;
                            }
                            sb.append("                ".substring(0, i - i3));
                        }
                        i3 = readLine2.length();
                        sb.append(readLine2);
                        i2++;
                    }
                    sb.append("\n");
                    String sb2 = sb.toString();
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Exception e) {
                            x.a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e2) {
                    x.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e3) {
                    x.a(e3);
                }
            }
            throw th;
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a2 = z.a(str, "map_record.txt");
        if (a2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = a2.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    while (true) {
                        String readLine2 = a2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb.append("  ");
                        sb.append(readLine2);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Exception e) {
                            x.a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e2) {
                    x.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Exception e3) {
                    x.a(e3);
                }
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c = c(str, str2);
        if (c != null && !c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c);
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void c(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                            file2.delete();
                            x.c("Delete empty record file %s", file2.getAbsoluteFile());
                        }
                    }
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            a.add(new File(str, "rqd_record.eup"));
            a.add(new File(str, "reg_record.txt"));
            a.add(new File(str, "map_record.txt"));
            a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = a;
        if (list != null && list.size() > 0) {
            for (File file : a) {
                if (file.exists() && file.canWrite()) {
                    file.delete();
                    x.c("Delete record file %s", file.getAbsoluteFile());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    public static String a(String str, int i, String str2, boolean z) {
        Throwable th;
        BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                x.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                a.add(file);
                x.c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return z.a(new File(str), i, z);
                }
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            if (i > 0 && sb.length() > i) {
                                if (z) {
                                    sb.delete(i, sb.length());
                                    break;
                                }
                                sb.delete(0, sb.length() - i);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            try {
                                x.a(th);
                                sb.append("\n[error:" + th.toString() + "]");
                                String sb2 = sb.toString();
                                if (bufferedReader != null) {
                                    return sb2;
                                }
                                bufferedReader.close();
                                return sb2;
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e) {
                                        x.a(e);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    String sb3 = sb.toString();
                    try {
                        bufferedReader2.close();
                        return sb3;
                    } catch (Exception e2) {
                        x.a(e2);
                        return sb3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    x.a(th);
                    sb.append("\n[error:" + th.toString() + "]");
                    String sb2 = sb.toString();
                    if (bufferedReader != null) {
                    }
                }
            }
        }
        return null;
    }
}
