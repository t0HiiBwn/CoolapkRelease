package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: LocNetManager */
public final class ee {
    private static ee b;
    aq a = null;
    private Context c = null;
    private int d = ej.g;
    private boolean e = false;
    private int f = 0;

    private ee(Context context) {
        try {
            p.a().a(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.a = aq.a();
    }

    public static ee a(Context context) {
        if (b == null) {
            b = new ee(context);
        }
        return b;
    }

    public final int a() {
        return this.d;
    }

    public final aw a(ef efVar) throws Throwable {
        return aq.a(efVar, this.e || ep.k(this.c));
    }

    public final aw a(ef efVar, int i) throws Throwable {
        return aq.a(efVar, this.e || ep.k(this.c), i);
    }

    public final ef a(Context context, byte[] bArr, String str, String str2, boolean z) {
        String str3;
        try {
            HashMap hashMap = new HashMap(16);
            ef efVar = new ef(context, ej.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 5.2.0");
                hashMap.put("KEY", k.f(context));
                hashMap.put("enginever", "5.1");
                String a2 = m.a();
                String a3 = m.a(context, a2, "key=" + k.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                hashMap.put("encr", "1");
                efVar.f = hashMap;
                String str4 = "loc";
                if (!z) {
                    str4 = "locf";
                }
                efVar.n = true;
                efVar.f1373l = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.2.0", str4, 3);
                efVar.k = z;
                efVar.g = str;
                efVar.h = str2;
                efVar.i = ep.a(bArr);
                efVar.a(s.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i = this.f;
                if (i != 0) {
                    if (i == 1) {
                        str3 = "language:cn";
                    } else if (i == 2) {
                        str3 = "language:en";
                    }
                    hashMap2.put("custom", str3);
                    efVar.m = hashMap2;
                    efVar.a(this.d);
                    efVar.b(this.d);
                    if ((this.e && !ep.k(context)) || !str.startsWith("http:")) {
                        return efVar;
                    }
                    efVar.g = efVar.c().replace("https:", "https:");
                    return efVar;
                }
                hashMap2.remove("custom");
                efVar.m = hashMap2;
                efVar.a(this.d);
                efVar.b(this.d);
                if (this.e) {
                }
                efVar.g = efVar.c().replace("https:", "https:");
                return efVar;
            } catch (Throwable unused) {
                return efVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0090 A[SYNTHETIC, Splitter:B:15:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f7 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0106 A[Catch:{ all -> 0x0115 }] */
    public final String a(Context context, double d2, double d3) {
        byte[] bytes;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        String str;
        try {
            HashMap hashMap = new HashMap(16);
            ef efVar = new ef(context, ej.c());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 5.2.0");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", k.f(context));
            int i = this.f;
            if (i != 0) {
                if (i == 1) {
                    str = "zh-CN";
                } else if (i == 2) {
                    str = "en";
                }
                hashMap2.put("language", str);
                String a2 = m.a();
                String a3 = m.a(context, a2, u.b(hashMap2));
                hashMap2.put("ts", a2);
                hashMap2.put("scode", a3);
                bytes = ("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8");
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (bytes != null) {
                    try {
                        byteArrayOutputStream.write(u.a(bytes.length));
                        byteArrayOutputStream.write(bytes);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            efVar.n = false;
                            efVar.k = true;
                            efVar.f1373l = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.2.0", "loc", 3);
                            efVar.m = hashMap2;
                            efVar.f = hashMap;
                            efVar.a(s.a(context));
                            efVar.a(ej.g);
                            efVar.b(ej.g);
                            efVar.h = "http://dualstack-restsdk.amap.com/v3/geocode/regeo";
                            if (!ep.k(context)) {
                            }
                            return new String(bArr, "utf-8");
                        } catch (Throwable th3) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
                efVar.j = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                efVar.n = false;
                efVar.k = true;
                efVar.f1373l = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.2.0", "loc", 3);
                efVar.m = hashMap2;
                efVar.f = hashMap;
                efVar.a(s.a(context));
                efVar.a(ej.g);
                efVar.b(ej.g);
                efVar.h = "http://dualstack-restsdk.amap.com/v3/geocode/regeo";
                if (!ep.k(context)) {
                    efVar.g = "http://restsdk.amap.com/v3/geocode/regeo".replace("http:", "https:");
                    bArr = aq.a(efVar);
                } else {
                    efVar.g = "http://restsdk.amap.com/v3/geocode/regeo";
                    bArr = aq.b(efVar);
                }
                return new String(bArr, "utf-8");
            }
            hashMap2.remove("language");
            String a2 = m.a();
            String a3 = m.a(context, a2, u.b(hashMap2));
            hashMap2.put("ts", a2);
            hashMap2.put("scode", a3);
            bytes = ("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8");
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (bytes != null) {
                }
                efVar.j = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                th.printStackTrace();
                if (byteArrayOutputStream != null) {
                }
                efVar.n = false;
                efVar.k = true;
                efVar.f1373l = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.2.0", "loc", 3);
                efVar.m = hashMap2;
                efVar.f = hashMap;
                efVar.a(s.a(context));
                efVar.a(ej.g);
                efVar.b(ej.g);
                efVar.h = "http://dualstack-restsdk.amap.com/v3/geocode/regeo";
                if (!ep.k(context)) {
                }
                return new String(bArr, "utf-8");
            }
            efVar.n = false;
            efVar.k = true;
            efVar.f1373l = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "5.2.0", "loc", 3);
            efVar.m = hashMap2;
            efVar.f = hashMap;
            efVar.a(s.a(context));
            efVar.a(ej.g);
            efVar.b(ej.g);
            try {
                efVar.h = "http://dualstack-restsdk.amap.com/v3/geocode/regeo";
                if (!ep.k(context)) {
                }
                return new String(bArr, "utf-8");
            } catch (Throwable th5) {
                ej.a(th5, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.e = z;
            try {
                p.a().a(z);
            } catch (Throwable unused) {
            }
            this.d = Long.valueOf(j).intValue();
            this.f = i;
        } catch (Throwable th) {
            ej.a(th, "LocNetManager", "setOption");
        }
    }
}
