package com.tencent.android.tpush.stat.a;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.c;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.b;
import com.tencent.tpns.baseapi.base.util.Util;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;

/* compiled from: ProGuard */
public class a {
    private static String a;
    private static String b;
    private static String c;
    private static Random d;
    private static Map<Long, String> e = new HashMap(10);
    private static String f = "";
    private static b g = null;
    private static String h = null;
    private static long i = -1;
    private static int j = 0;
    private static String k = "__MTA_FIRST_ACTIVATE__";
    private static int l = -1;

    private static synchronized Random c() {
        Random random;
        synchronized (a.class) {
            if (d == null) {
                d = new Random();
            }
            random = d;
        }
        return random;
    }

    public static String a(Context context, long j2) {
        List<ResolveInfo> a2;
        RegisterEntity registerInfoByPkgName;
        try {
            if (e.containsKey(Long.valueOf(j2))) {
                return e.get(Long.valueOf(j2));
            }
            if (context == null || (a2 = f.a(context)) == null) {
                return "0";
            }
            for (ResolveInfo resolveInfo : a2) {
                String str = resolveInfo.activityInfo.packageName;
                if (!(str == null || (registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str)) == null || registerInfoByPkgName.accessId != j2)) {
                    String str2 = registerInfoByPkgName.xgSDKVersion + "";
                    e.put(Long.valueOf(registerInfoByPkgName.accessId), str2);
                    return str2;
                }
            }
            return "0";
        } catch (Throwable th) {
            g.b(th);
            return "0";
        }
    }

    public static String a(Context context) {
        return "1.2.3.1";
    }

    public static int a() {
        return c().nextInt(Integer.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058 A[SYNTHETIC, Splitter:B:32:0x0058] */
    public static byte[] a(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    g.b((Throwable) e2);
                }
                try {
                    gZIPInputStream.close();
                } catch (IOException e3) {
                    g.b((Throwable) e3);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    g.b((Throwable) e4);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    g.b(th);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                        g.b((Throwable) e5);
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e6) {
                            g.b((Throwable) e6);
                        }
                    }
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                        g.b((Throwable) e7);
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e8) {
                            g.b((Throwable) e8);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e9) {
                        g.b((Throwable) e9);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            g.b(th);
            byteArrayInputStream.close();
            if (gZIPInputStream != null) {
            }
            byteArrayOutputStream.close();
            return bArr2;
        }
        return bArr2;
    }

    public static HttpHost b(Context context) {
        NetworkInfo activeNetworkInfo;
        String defaultHost;
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return null;
            }
            if ((activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) && activeNetworkInfo.getExtraInfo() != null && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            g.b(th);
        }
    }

    public static String b(Context context, long j2) {
        return c.a(context).a(j2);
    }

    public static String c(Context context) {
        if (b(f)) {
            return f;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f = str;
            if (str == null || str.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            g.b(th);
        }
        return f;
    }

    public static synchronized b b() {
        b bVar;
        synchronized (a.class) {
            if (g == null) {
                b bVar2 = new b("XgStat");
                g = bVar2;
                bVar2.a(true);
            }
            bVar = g;
        }
        return bVar;
    }

    public static Long a(String str, String str2, int i2, int i3, Long l2) {
        if (!(str == null || str2 == null)) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                str2 = String.format("\\%s", str2);
            }
            String[] split = str.split(str2);
            if (split.length == i3) {
                try {
                    Long l3 = 0L;
                    for (String str3 : split) {
                        l3 = Long.valueOf(((long) i2) * (l3.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l3;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l2;
    }

    public static long a(String str) {
        return a(str, ".", 100, 3, 0L).longValue();
    }

    public static boolean b(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[SYNTHETIC, Splitter:B:18:0x0049] */
    public static String d(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    g.b(th2);
                }
                return readLine;
            } catch (Throwable th3) {
                th = th3;
                try {
                    g.b(th);
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    g.b(th4);
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            g.b(th);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th6) {
                    g.b(th6);
                }
            }
            return null;
        }
        throw th;
    }

    public static String a(Context context, String str) {
        if (b.d()) {
            if (h == null) {
                h = d(context);
            }
            if (h != null) {
                str = str + "_" + h;
            }
        }
        return Util.getKey(str);
    }

    public static void e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        i = currentTimeMillis;
        c.b(context, "mta.qq.com.checktime", currentTimeMillis);
    }

    public static int a(Context context, boolean z) {
        if (z) {
            j = f(context);
        }
        return j;
    }

    public static int f(Context context) {
        return c.a(context, "mta.qq.com.difftime", 0);
    }

    public static void a(Context context, int i2) {
        j = i2;
        c.b(context, "mta.qq.com.difftime", i2);
    }
}
