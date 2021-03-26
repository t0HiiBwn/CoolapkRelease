package com.tencent.beacon.core.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.d.a;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.upload.TunnelInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: BeaconInfo */
public final class b {
    public static String a;
    public static String b;
    public static String c;
    private static b d;
    private Context e = null;
    private Map<String, TunnelInfo> f = new HashMap();
    private String g = "";
    private String h = "";
    private byte i = -1;
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private long o = 0;
    private String p = "";
    private String q = "";
    private String r = "";

    public static synchronized b a(Context context) {
        String str;
        synchronized (b.class) {
            if (context == null) {
                return null;
            }
            if (d == null) {
                b bVar = new b();
                d = bVar;
                bVar.e = context;
                e.a(context);
                d.g = e.b();
                d.h = e.a();
                b bVar2 = d;
                bVar2.i = 1;
                bVar2.j = a.c(context);
                d.k = a.e(context);
                b bVar3 = d;
                bVar3.l = "beacon";
                bVar3.m = "3.1.2";
                bVar3.n = "unknown";
                bVar3.p = b(context);
                b bVar4 = d;
                if (context == null) {
                    str = "";
                } else {
                    String c2 = c(context);
                    if (!g.a(c2)) {
                        str = c2;
                    } else {
                        str = d(context);
                    }
                }
                bVar4.q = a.a(str);
            }
            return d;
        }
    }

    public final synchronized String a() {
        if (!g.a(a)) {
            return a;
        } else if (!g.a(this.p)) {
            return this.p;
        } else {
            return this.j;
        }
    }

    public final synchronized String a(String str) {
        TunnelInfo tunnelInfo;
        if (!g.a(str) && (tunnelInfo = this.f.get(str)) != null && !g.a(tunnelInfo.channel)) {
            return tunnelInfo.channel;
        }
        if (!g.a(c)) {
            return c;
        }
        return this.q;
    }

    public final synchronized String b(String str) {
        TunnelInfo tunnelInfo;
        if (!g.a(str) && (tunnelInfo = this.f.get(str)) != null && !g.a(tunnelInfo.version)) {
            return tunnelInfo.version;
        }
        if (!g.a(b)) {
            return b;
        }
        return this.k;
    }

    public final synchronized String b() {
        return this.l;
    }

    public final synchronized String c() {
        return this.m;
    }

    public final String d() {
        return this.g;
    }

    public final String e() {
        return this.h;
    }

    public final synchronized byte f() {
        return this.i;
    }

    public final synchronized String g() {
        return this.n;
    }

    public final synchronized long h() {
        return this.o;
    }

    public final Context i() {
        return this.e;
    }

    public final void c(String str) {
        this.n = str;
    }

    public final void a(long j2) {
        this.o = j2;
    }

    public final void d(String str) {
        if (str != null) {
            this.r = str;
            com.tencent.beacon.core.d.b.b("[core] -> JavaScript clientID:" + this.r, new Object[0]);
        }
    }

    public final String j() {
        return this.r;
    }

    private static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
            if (obj != null) {
                return obj.toString().trim();
            }
        } catch (Throwable unused) {
            com.tencent.beacon.core.d.b.d("[core] not set 'APPKEY_DENGTA' in manifest", new Object[0]);
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[SYNTHETIC, Splitter:B:29:0x008c] */
    private static String c(Context context) {
        String str;
        String str2 = "";
        AssetManager assets = context.getAssets();
        c a2 = c.a(context);
        InputStream inputStream = null;
        try {
            String a3 = a2.a("key_channelpath", str2);
            if (g.a(a3)) {
                a3 = "channel.ini";
                a2.a().a("key_channelpath", (Object) a3).b();
            }
            com.tencent.beacon.core.d.b.b("[core] channel path: %s", a3);
            if (!a3.equals(str2)) {
                inputStream = assets.open(a3);
                Properties properties = new Properties();
                properties.load(inputStream);
                str = properties.getProperty("CHANNEL", str2);
                try {
                    com.tencent.beacon.core.d.b.a("[core] channel from assets " + str, new Object[0]);
                    if (!g.a(str)) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                com.tencent.beacon.core.d.b.a(e2);
                            }
                        }
                        return str;
                    }
                    str2 = str;
                } catch (Exception unused) {
                    try {
                        a2.a().a("key_channelpath", (Object) str2).b();
                        com.tencent.beacon.core.d.b.c("[core] get app channel fail!", new Object[0]);
                        return str;
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                com.tencent.beacon.core.d.b.a(e3);
                            }
                        }
                    }
                }
            }
            if (inputStream == null) {
                return str2;
            }
            try {
                inputStream.close();
                return str2;
            } catch (IOException e4) {
                com.tencent.beacon.core.d.b.a(e4);
                return str2;
            }
        } catch (Exception unused2) {
            str = str2;
            a2.a().a("key_channelpath", (Object) str2).b();
            com.tencent.beacon.core.d.b.c("[core] get app channel fail!", new Object[0]);
            return str;
        }
    }

    private static String d(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            if (obj != null) {
                return obj.toString();
            }
            return "";
        } catch (Throwable unused) {
            com.tencent.beacon.core.d.b.d("[core] not set 'CHANNEL_DENGTA' in manifest", new Object[0]);
            return "";
        }
    }

    public final void a(String str, TunnelInfo tunnelInfo) {
        this.f.put(str, tunnelInfo);
    }
}
