package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.beacon.core.d.f;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.a.b;
import com.tencent.beacon.core.protocol.a.c;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: StrategyBean */
public class a {
    private static a a;
    private boolean b = false;
    private String c = "http://oth.str.mdt.qq.com:8080/analytics/upload";
    private int d = 360;
    private int e = 100;
    private SparseArray<C0123a> f = null;
    private Map<String, String> g = null;
    private byte h = 3;
    private byte i = 2;
    private String j = "";
    private String k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f1427l = "";
    private boolean m = true;

    private a() {
        SparseArray<C0123a> sparseArray = new SparseArray<>(3);
        this.f = sparseArray;
        sparseArray.put(1, new C0123a(1));
        this.f.put(2, new C0123a(2));
        this.f.put(3, new C0123a(3));
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final String b() {
        String a2 = b.a(!a().h(), false, false, this.c);
        com.tencent.beacon.core.d.b.b("[net] module strategy url: %s", a2);
        return a2;
    }

    public final void a(String str) {
        if (this.b) {
            com.tencent.beacon.core.d.b.c("[strategy] url has defined by api, don't change.", new Object[0]);
        } else {
            this.c = str;
        }
    }

    public final int c() {
        return this.d;
    }

    public final void a(int i2) {
        this.d = i2;
    }

    public final Map<String, String> d() {
        return this.g;
    }

    public final void a(Map<String, String> map) {
        this.g = map;
    }

    public final synchronized SparseArray<C0123a> e() {
        if (this.f == null) {
            return null;
        }
        new f();
        return f.a(this.f);
    }

    public final synchronized C0123a b(int i2) {
        SparseArray<C0123a> sparseArray = this.f;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public final int f() {
        String str;
        Map<String, String> map = this.g;
        if (map == null || (str = map.get("maxStrategyQueryOneDay")) == null || str.trim().equals("")) {
            return this.e;
        }
        int i2 = this.e;
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return i2;
        }
    }

    public final synchronized boolean g() {
        String str;
        Map<String, String> map = this.g;
        if (map == null || (str = map.get("zeroPeak")) == null || !"y".equalsIgnoreCase(str) || Calendar.getInstance().get(11) != 0) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000d: APUT  (r0v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r1v1 java.lang.String) */
    public final boolean h() {
        Object[] objArr = new Object[1];
        objArr[0] = this.m ? "socket" : "http";
        com.tencent.beacon.core.d.b.b("[strategy] -> use %s to upload.", objArr);
        return this.m;
    }

    public final void i() {
        com.tencent.beacon.core.d.b.b("[net] -> change to http mode.", new Object[0]);
        this.m = false;
    }

    public final void j() {
        String b2 = b("isSocketOnOff");
        if (b2 != null && "n".equals(b2)) {
            i();
        }
    }

    public final synchronized byte l() {
        return this.h;
    }

    public final synchronized byte m() {
        return this.i;
    }

    public final synchronized String n() {
        return this.j;
    }

    public final synchronized void a(String str, String str2) {
        this.b = true;
        String a2 = b.a(str);
        this.c = a2;
        com.tencent.beacon.core.d.b.b("[strategy] set strategy url to %s by api.", a2);
        C0123a aVar = this.f.get(1);
        if (aVar != null) {
            aVar.c = b.a(str2);
            com.tencent.beacon.core.d.b.b("[strategy] set user event url to %s by api.", aVar.c);
        }
    }

    private synchronized void a(Context context, String str) {
        this.k = str;
        this.j = Base64.encodeToString(c.a(context, str), 2);
    }

    public final synchronized String o() {
        return this.k;
    }

    private synchronized void c(String str) {
        this.f1427l = str;
    }

    public final synchronized String p() {
        return this.f1427l;
    }

    public final synchronized void a(final Context context, final String str, final String str2) {
        com.tencent.beacon.core.d.b.b("[net] -> update local sid|time[%s|%s].", str, str2);
        this.f1427l = str;
        com.tencent.beacon.core.a.b.a().a(new Runnable() {
            /* class com.tencent.beacon.core.strategy.a.AnonymousClass1 */

            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0031: APUT  
              (r0v1 java.lang.Object[])
              (1 ??[boolean, int, float, short, byte, char])
              (wrap: java.lang.Long : 0x002d: INVOKE  (r2v1 java.lang.Long) = (r5v1 long) type: STATIC call: java.lang.Long.valueOf(long):java.lang.Long)
             */
            @Override // java.lang.Runnable
            public final void run() {
                long j;
                Object[] objArr = new Object[2];
                objArr[0] = str;
                try {
                    j = h.a(str2).getTime() / 1000;
                } catch (Exception unused) {
                    j = 0;
                }
                if (j == 0) {
                    j = (new Date().getTime() / 1000) + 86400;
                }
                objArr[1] = Long.valueOf(j);
                com.tencent.beacon.core.a.a.c.a(context, "sid", objArr);
            }
        });
    }

    public final synchronized void a(Context context) {
        Object[] a2 = com.tencent.beacon.core.a.a.c.a(context, "sid");
        if (a2 != null && a2.length == 3) {
            long time = new Date().getTime() / 1000;
            long j2 = 0;
            try {
                j2 = ((Long) a2[2]).longValue();
            } catch (Exception unused) {
            }
            if (j2 > time) {
                c((String) a2[1]);
            }
        }
        a(context, h.a(context));
    }

    /* renamed from: com.tencent.beacon.core.strategy.a$a  reason: collision with other inner class name */
    /* compiled from: StrategyBean */
    public static class C0123a {
        private final int a;
        private boolean b = false;
        private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
        private Map<String, String> d = null;
        private Set<String> e = null;
        private Set<String> f = null;

        public C0123a(int i) {
            this.a = i;
        }

        public final boolean a() {
            return this.b;
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final String b() {
            boolean z;
            boolean z2 = !a.a().h();
            String b2 = a.a().b("stopTest");
            if (b2 != null) {
                z = "y".equals(b2);
            } else {
                z = false;
            }
            String a2 = b.a(z2, true, (!z) & com.tencent.beacon.core.d.b.b, this.c);
            com.tencent.beacon.core.d.b.b("[net] module strategy url: %s", a2);
            return a2;
        }

        public final void a(String str) {
            if (this.a != 1 || !a.a().b) {
                this.c = str;
            } else {
                com.tencent.beacon.core.d.b.c("[strategy] user event url has defined by api, don't change.", new Object[0]);
            }
        }

        public final Map<String, String> c() {
            return this.d;
        }

        public final void a(Map<String, String> map) {
            this.d = map;
        }

        public final Set<String> d() {
            return this.e;
        }

        public final void a(Set<String> set) {
            this.e = set;
        }

        public final int e() {
            return this.a;
        }

        public final Set<String> f() {
            return this.f;
        }

        public final void b(Set<String> set) {
            this.f = set;
        }
    }

    public final String b(String str) {
        Map<String, String> c2;
        C0123a aVar = this.f.get(1);
        if (aVar == null || (c2 = aVar.c()) == null) {
            return null;
        }
        return c2.get(str);
    }

    public final int k() {
        Map<String, String> c2;
        String str;
        C0123a aVar = this.f.get(1);
        if (aVar == null || (c2 = aVar.c()) == null || (str = c2.get("socketPort")) == null) {
            return 8081;
        }
        return Integer.valueOf(str).intValue();
    }
}
