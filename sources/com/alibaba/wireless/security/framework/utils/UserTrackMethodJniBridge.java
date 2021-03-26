package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.os.Process;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserTrackMethodJniBridge {
    private static Context a;
    private static String b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static Class g;
    private static Class h;
    private static Class i;
    private static Constructor j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static final char[] o = "0123456789abcdef".toCharArray();

    private static synchronized String a() {
        String substring;
        synchronized (UserTrackMethodJniBridge.class) {
            String str = b;
            if (str == null || str.length() == 0) {
                b = b();
            }
            String str2 = b;
            substring = str2.substring(0, str2.length() / 8);
        }
        return substring;
    }

    private static String a(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static int addUtRecord(String str, int i2, int i3, String str2, long j2, String str3, String str4, String str5, String str6, String str7) {
        if (!(utAvaiable() == 0 || str == null || str.length() == 0)) {
            String str8 = str2 != null ? str2 : "";
            try {
                String valueOf = String.valueOf(i2 % 100);
                HashMap hashMap = new HashMap();
                hashMap.put("plugin", String.valueOf(i3));
                hashMap.put("pid", String.valueOf(Process.myPid()));
                hashMap.put("tid", String.valueOf(Thread.currentThread().getId()));
                hashMap.put("time", String.valueOf(j2));
                if (d == 0) {
                    c = f.c(a) ? 1 : 0;
                    d = 1;
                }
                hashMap.put("ui", String.valueOf(c));
                hashMap.put("sid", a());
                hashMap.put("uuid", b());
                hashMap.put("msg", a(str3));
                hashMap.put("rsv1", a(str4));
                hashMap.put("rsv2", a(str5));
                hashMap.put("rsv3", a(str6));
                hashMap.put("rsv4", a(str7));
                Object newInstance = j.newInstance("Page_SecurityGuardSDK", 19999, str, str8, valueOf, hashMap);
                if (newInstance != null) {
                    Map map = (Map) k.invoke(newInstance, new Object[0]);
                    if (map != null) {
                        if (map.size() != 0) {
                            Object invoke = l.invoke(h, new Object[0]);
                            if (invoke != null) {
                                Object invoke2 = m.invoke(invoke, new Object[0]);
                                if (invoke2 != null) {
                                    n.invoke(invoke2, map);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private static String b() {
        try {
            String uuid = UUID.randomUUID().toString();
            String valueOf = String.valueOf(System.nanoTime());
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            return bytesToHex(instance.digest((uuid + valueOf).getBytes("UTF-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = o;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static String getStackTrace(int i2, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0 || i2 <= 0 || i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (int i5 = 0; i5 < stackTrace.length && i4 < i3 && sb.length() < i2; i5++) {
            if (i5 > 1) {
                i4++;
                StackTraceElement stackTraceElement = stackTrace[i5];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                if (i5 < stackTrace.length - 1) {
                    sb.append("#");
                }
            }
        }
        return sb.toString();
    }

    public static void init(Context context) {
        if (context != null) {
            a = context;
        }
    }

    public static int utAvaiable() {
        if (f == 0) {
            synchronized (UserTrackMethodJniBridge.class) {
                if (f == 0) {
                    try {
                        g = Class.forName("com.ut.mini.internal.UTOriginalCustomHitBuilder");
                        h = Class.forName("com.ut.mini.UTAnalytics");
                        i = Class.forName("com.ut.mini.UTTracker");
                        j = g.getConstructor(String.class, Integer.TYPE, String.class, String.class, String.class, Map.class);
                        k = g.getMethod("build", new Class[0]);
                        l = h.getMethod("getInstance", new Class[0]);
                        m = h.getMethod("getDefaultTracker", new Class[0]);
                        n = i.getMethod("send", Map.class);
                        e = 1;
                    } catch (ClassNotFoundException unused) {
                    }
                    f = 1;
                }
            }
        }
        return e;
    }
}
