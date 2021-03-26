package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public final class v implements Runnable {
    private int a;
    private int b;
    private final Context c;
    private final int d;
    private final byte[] e;
    private final a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, tVar, 2, 30000, z2, null);
    }

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, int i4, int i5, boolean z, Map<String, String> map) {
        this.a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.c = context;
        this.f = a.a(context);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context);
        this.i = u.a();
        this.j = i2;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.d = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.b = i5;
        }
        this.s = z;
        this.o = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    private void a(an anVar, boolean z, int i2, String str) {
        String str2;
        t tVar;
        t tVar2;
        int i3 = this.d;
        if (i3 != 630) {
            if (i3 != 640) {
                if (i3 != 830) {
                    if (i3 != 840) {
                        str2 = String.valueOf(i3);
                        if (z) {
                            x.a("[Upload] Success: %s", str2);
                        } else {
                            x.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i2), str2, str);
                        }
                        if (this.q + this.r > 0) {
                            this.i.a(this.i.a(this.s) + this.q + this.r, this.s);
                        }
                        tVar = this.k;
                        if (tVar != null) {
                            tVar.a(z);
                        }
                        tVar2 = this.l;
                        if (tVar2 != null) {
                            tVar2.a(z);
                            return;
                        }
                        return;
                    }
                }
            }
            str2 = "userinfo";
            if (z) {
            }
            if (this.q + this.r > 0) {
            }
            tVar = this.k;
            if (tVar != null) {
            }
            tVar2 = this.l;
            if (tVar2 != null) {
            }
        }
        str2 = "crash";
        if (z) {
        }
        if (this.q + this.r > 0) {
        }
        tVar = this.k;
        if (tVar != null) {
        }
        tVar2 = this.l;
        if (tVar2 != null) {
        }
    }

    private static boolean a(an anVar, a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        } else if (anVar.a != 0) {
            x.e("resp result error %d", Byte.valueOf(anVar.a));
            return false;
        } else {
            try {
                if (!z.a(anVar.e) && !a.b().i().equals(anVar.e)) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "device", anVar.e.getBytes("UTF-8"), (o) null, true);
                    aVar.e(anVar.e);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            aVar.j = anVar.d;
            if (anVar.b == 510) {
                if (anVar.c == null) {
                    x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                ap apVar = (ap) a.a(anVar.c, ap.class);
                if (apVar == null) {
                    x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                aVar2.a(apVar);
            }
            return true;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x02dc: APUT  
      (r5v16 java.lang.Object[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: java.lang.Integer : 0x02d8: INVOKE  (r4v10 java.lang.Integer) = (r4v9 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0221 A[SYNTHETIC, Splitter:B:70:0x0221] */
    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.bugly.crashreport.common.strategy.a aVar;
        String str;
        boolean z;
        String str2 = "Bugly-Version";
        try {
            this.p = 0;
            this.q = 0;
            this.r = 0;
            byte[] bArr = this.e;
            if (b.b(this.c) == null) {
                a(null, false, 0, "network is not available");
                return;
            }
            if (bArr != null) {
                if (bArr.length != 0) {
                    x.c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.d));
                    if (!(this.c == null || this.f == null || (aVar = this.g) == null)) {
                        if (this.h != null) {
                            StrategyBean c2 = aVar.c();
                            if (c2 == null) {
                                a(null, false, 0, "illegal local strategy");
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("tls", "1");
                            hashMap.put("prodId", this.f.f());
                            hashMap.put("bundleId", this.f.c);
                            hashMap.put("appVer", this.f.k);
                            Map<String, String> map = this.o;
                            if (map != null) {
                                hashMap.putAll(map);
                            }
                            hashMap.put("cmd", Integer.toString(this.d));
                            hashMap.put("platformId", Byte.toString((byte) 1));
                            hashMap.put("sdkVer", this.f.f);
                            hashMap.put("strategylastUpdateTime", Long.toString(c2.n));
                            int i2 = 2;
                            byte[] a2 = z.a(bArr, 2);
                            if (a2 == null) {
                                a(null, false, 0, "failed to zip request body");
                                return;
                            } else if (a2 == null) {
                                a(null, false, 0, "failed to encrypt request body");
                                return;
                            } else {
                                this.i.a(this.j, System.currentTimeMillis());
                                t tVar = this.k;
                                t tVar2 = this.l;
                                String str3 = this.m;
                                int i3 = -1;
                                int i4 = 0;
                                int i5 = 0;
                                while (true) {
                                    int i6 = i4 + 1;
                                    if (i4 < this.a) {
                                        if (i6 > 1) {
                                            x.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                                            z.b((long) this.b);
                                            if (i6 == this.a) {
                                                x.d("[Upload] Use the back-up url at the last time: %s", this.n);
                                                str3 = this.n;
                                            }
                                        }
                                        x.c("[Upload] Send %d bytes", Integer.valueOf(a2.length));
                                        str3 = a(str3);
                                        Object[] objArr = new Object[4];
                                        objArr[0] = str3;
                                        objArr[1] = Integer.valueOf(this.d);
                                        objArr[i2] = Integer.valueOf(Process.myPid());
                                        objArr[3] = Integer.valueOf(Process.myTid());
                                        x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", objArr);
                                        byte[] a3 = this.h.a(str3, a2, this, hashMap);
                                        if (a3 == null) {
                                            Object[] objArr2 = new Object[i2];
                                            objArr2[0] = 1;
                                            objArr2[1] = "Failed to upload for no response!";
                                            x.e("[Upload] Failed to upload(%d): %s", objArr2);
                                            i4 = i6;
                                        } else {
                                            Map<String, String> map2 = this.h.a;
                                            if (map2 == null || map2.size() == 0) {
                                                str = str2;
                                                x.d("[Upload] Headers is empty.", new Object[0]);
                                            } else {
                                                if (!map2.containsKey("status")) {
                                                    x.d("[Upload] Headers does not contain %s", "status");
                                                } else if (!map2.containsKey(str2)) {
                                                    x.d("[Upload] Headers does not contain %s", str2);
                                                } else {
                                                    String str4 = map2.get(str2);
                                                    if (!str4.contains("bugly")) {
                                                        str = str2;
                                                        x.d("[Upload] Bugly version is not valid: %s", str4);
                                                    } else {
                                                        str = str2;
                                                        x.c("[Upload] Bugly version from headers is: %s", str4);
                                                        z = true;
                                                        if (z) {
                                                            x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                            x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                                            if (map2 != null) {
                                                                for (Map.Entry<String, String> entry : map2.entrySet()) {
                                                                    x.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                                                }
                                                            }
                                                            x.c("[Upload] Failed to upload for no status header.", new Object[0]);
                                                            i4 = i6;
                                                            str2 = str;
                                                            i2 = 2;
                                                        } else {
                                                            try {
                                                                int parseInt = Integer.parseInt(map2.get("status"));
                                                                try {
                                                                    x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(parseInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                                    if (parseInt != 0) {
                                                                        a(null, false, 1, "status of server is " + parseInt);
                                                                        return;
                                                                    }
                                                                    x.c("[Upload] Received %d bytes", Integer.valueOf(a3.length));
                                                                    if (a3.length == 0) {
                                                                        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                                                                            x.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                                                                        }
                                                                        a(null, false, 1, "response data from server is empty");
                                                                        return;
                                                                    } else if (a3 == null) {
                                                                        a(null, false, 1, "failed to decrypt response from server");
                                                                        return;
                                                                    } else {
                                                                        byte[] b2 = z.b(a3, 2);
                                                                        if (b2 != null) {
                                                                            a3 = b2;
                                                                        }
                                                                        an b3 = a.b(a3);
                                                                        if (b3 == null) {
                                                                            a(null, false, 1, "failed to decode response package");
                                                                            return;
                                                                        }
                                                                        Object[] objArr3 = new Object[2];
                                                                        objArr3[0] = Integer.valueOf(b3.b);
                                                                        objArr3[1] = Integer.valueOf(b3.c == null ? 0 : b3.c.length);
                                                                        x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr3);
                                                                        if (!a(b3, this.f, this.g)) {
                                                                            a(b3, false, 2, "failed to process response package");
                                                                            return;
                                                                        } else {
                                                                            a(b3, true, 2, "successfully uploaded");
                                                                            return;
                                                                        }
                                                                    }
                                                                } catch (Throwable unused) {
                                                                    i3 = parseInt;
                                                                }
                                                            } catch (Throwable unused2) {
                                                                i2 = 2;
                                                                x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i3));
                                                                i4 = i6;
                                                                str2 = str;
                                                                i5 = 1;
                                                            }
                                                        }
                                                    }
                                                }
                                                str = str2;
                                            }
                                            z = false;
                                            if (z) {
                                            }
                                        }
                                        i5 = 1;
                                    } else {
                                        a(null, false, i5, "failed after many attempts");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    a(null, false, 0, "illegal access error");
                    return;
                }
            }
            a(null, false, 0, "request package is empty!");
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void a(long j2) {
        this.p++;
        this.q += j2;
    }

    public final void b(long j2) {
        this.r += j2;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
