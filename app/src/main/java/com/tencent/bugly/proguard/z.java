package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: BUGLY */
public class z {
    private static Map<String, String> a;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (x.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[SYNTHETIC, Splitter:B:28:0x006f] */
    public static byte[] a(File file, String str, String str2) {
        Throwable th;
        ZipOutputStream zipOutputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        x.c("rqdp{  ZF start}", new Object[0]);
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            try {
                zipOutputStream.setMethod(8);
                zipOutputStream.putNextEntry(new ZipEntry(str2));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = byteArrayInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.flush();
                zipOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                x.c("rqdp{  ZF end}", new Object[0]);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    x.c("rqdp{  ZF end}", new Object[0]);
                    return null;
                } catch (Throwable th3) {
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    x.c("rqdp{  ZF end}", new Object[0]);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
            if (!x.a(th)) {
            }
            if (zipOutputStream != null) {
            }
            x.c("rqdp{  ZF end}", new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        x.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            ae a2 = ad.a(2);
            if (a2 == null) {
                return null;
            }
            return a2.a(bArr);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        x.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            ae a2 = ad.a(2);
            if (a2 == null) {
                return null;
            }
            return a2.b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                x.d(th.getMessage(), new Object[0]);
            } else if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc A[Catch:{ all -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c1 A[SYNTHETIC, Splitter:B:59:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cb A[SYNTHETIC, Splitter:B:64:0x00cb] */
    public static boolean a(File file, File file2, int i) {
        Throwable th;
        ZipOutputStream zipOutputStream;
        x.c("rqdp{  ZF start}", new Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            x.d("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (!file.exists() || !file.canRead()) {
            x.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        } else {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th2) {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canRead()) {
                return false;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    try {
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        byte[] bArr = new byte[5000];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        x.c("rqdp{  ZF end}", new Object[0]);
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        try {
                            if (!x.a(th)) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (zipOutputStream != null) {
                            }
                            x.c("rqdp{  ZF end}", new Object[0]);
                            return false;
                        } catch (Throwable th4) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            x.c("rqdp{  ZF end}", new Object[0]);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = null;
                    fileInputStream = fileInputStream2;
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    x.c("rqdp{  ZF end}", new Object[0]);
                    return false;
                }
            } catch (Throwable th6) {
                th = th6;
                zipOutputStream = null;
                if (!x.a(th)) {
                }
                if (fileInputStream != null) {
                }
                if (zipOutputStream != null) {
                }
                x.c("rqdp{  ZF end}", new Object[0]);
                return false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078 A[SYNTHETIC, Splitter:B:35:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082 A[SYNTHETIC, Splitter:B:40:0x0082] */
    private static ArrayList<String> a(Context context, String[] strArr) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.e(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    try {
                        if (!x.a(th)) {
                        }
                        return null;
                    } finally {
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                }
            }
            bufferedReader2.close();
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = null;
            bufferedReader = null;
            if (!x.a(th)) {
            }
            return null;
        }
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (a == null) {
            a = new HashMap();
            String str2 = "/system/bin/sh";
            if (!new File(str2).exists() || !new File(str2).canExecute()) {
                str2 = "sh";
            }
            ArrayList<String> a2 = a(context, new String[]{str2, "-c", "getprop"});
            if (a2 != null && a2.size() > 0) {
                x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String str3 : a2) {
                    Matcher matcher = compile.matcher(str3);
                    if (matcher.find()) {
                        a.put(matcher.group(1), matcher.group(2));
                    }
                }
                x.b(z.class, "Systems properties number: %d.", Integer.valueOf(a.size()));
            }
        }
        return a.containsKey(str) ? a.get(str) : "fail";
    }

    public static void b(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static void b(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v0 long)] */
    public static byte[] c(long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString("pluginKey" + i, (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginVal" + i2 + "plugInId", ((PlugInBean) arrayList2.get(i2)).a);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((PlugInBean) arrayList2.get(i2)).c);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((PlugInBean) arrayList2.get(i2)).b);
        }
        parcel.writeBundle(bundle);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey" + i));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            String string = readBundle.getString("pluginVal" + i2 + "plugInId");
            String string2 = readBundle.getString("pluginVal" + i2 + "plugInUUID");
            arrayList2.add(new PlugInBean(string, readBundle.getString("pluginVal" + i2 + "plugInVersion"), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            x.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        ArrayList<String> arrayList2 = new ArrayList<>(size);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            x.e("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            T createFromParcel = creator.createFromParcel(obtain);
            if (obtain != null) {
                obtain.recycle();
            }
            return createFromParcel;
        } catch (Throwable th) {
            if (obtain != null) {
                obtain.recycle();
            }
            throw th;
        }
    }

    public static String a(Context context, int i, String str) {
        Process process = null;
        if (!AppInfo.a(context, "android.permission.READ_LOGS")) {
            x.d("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
            }
            String sb2 = sb.toString();
            if (exec != null) {
                try {
                    exec.getOutputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    exec.getInputStream().close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    exec.getErrorStream().close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return sb2;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    process.getOutputStream().close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    process.getInputStream().close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    process.getErrorStream().close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Map<String, String> a(int i, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            int i2 = 0;
            sb.setLength(0);
            if (!(entry.getValue() == null || entry.getValue().length == 0)) {
                StackTraceElement[] value = entry.getValue();
                int length = value.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = value[i2];
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cut!]");
                        break;
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                    i2++;
                }
                hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
            }
        }
        return hashMap;
    }

    public static boolean a(Context context, String str, long j) {
        x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < 10000) {
                    return false;
                }
                x.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                x.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            x.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            x.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067 A[SYNTHETIC, Splitter:B:30:0x0067] */
    public static String a(File file, int i, boolean z) {
        Throwable th;
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    if (i > 0 && sb.length() > i) {
                        if (z) {
                            sb.delete(i, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                x.a(e);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e2) {
                x.a(e2);
            }
            return sb2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            x.a(th);
            return null;
        }
    }

    private static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                x.a(th);
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return a(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            x.a(e);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            x.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        w a2 = w.a();
        if (a2 != null) {
            return a2.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static boolean c(String str) {
        if (str == null || str.trim().length() <= 0) {
            return false;
        }
        if (str.length() > 255) {
            x.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith("http")) {
            return true;
        } else {
            x.a("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static String b(String str, String str2) {
        return (a.b() == null || a.b().F == null) ? "" : a.b().F.getString(str, str2);
    }
}
