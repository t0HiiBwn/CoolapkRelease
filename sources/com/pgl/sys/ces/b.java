package com.pgl.sys.ces;

import android.content.Context;
import android.util.Log;
import com.pgl.a.b.e;
import com.pgl.sys.ces.a.a;
import com.pgl.sys.ces.a.c;
import com.pgl.sys.ces.a.d;
import com.pgl.sys.ces.a.f;
import com.pgl.sys.ces.out.ISdkInfo;
import com.pgl.sys.ces.out.ISdkLite;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b extends Thread implements ISdkLite {
    public static boolean c;
    public static boolean d;
    private static volatile b e;
    private static boolean f;
    private static boolean m;
    private static Map<String, Object> n;
    public boolean a = false;
    public Context b = null;
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private boolean k = false;
    private ISdkInfo l = null;

    private b(Context context, String str, ISdkInfo iSdkInfo) {
        setName("CZL-00");
        this.b = context;
        this.g = str;
        this.l = iSdkInfo;
    }

    public static b a() {
        return e;
    }

    public static b a(Context context, String str, int i2, ISdkInfo iSdkInfo) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    if (context == null) {
                        context = a.b().getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    e = new b(context, str, iSdkInfo);
                }
                com.pgl.a.a.a.a(i2);
                e.a(context, "nms");
                a(context);
            }
        }
        return e;
    }

    private static void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (!f) {
                    try {
                        a.meta(101, null, "0");
                        a.meta(1020, null, "" + b());
                        a.meta(105, null, "" + a.b(context));
                        a.meta(106, null, "" + a.a(context));
                        a.meta(107, null, "" + a.c(context));
                        a.meta(108, null, "" + a.d(context));
                        a.meta(109, null, "" + a.c());
                        a.meta(110, null, "" + a.d());
                        f = true;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void a(String str) {
        new Thread("CZL-" + str) {
            /* class com.pgl.sys.ces.b.AnonymousClass1 */

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.a = 0;
                d.a(b.this.b);
            }
        }.start();
    }

    public static String b() {
        return a().g;
    }

    public static String c() {
        return a().i;
    }

    public static String d() {
        return a().h;
    }

    public static ISdkInfo e() {
        return a().l;
    }

    public static int f() {
        try {
            return a.a() != null ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean g() {
        return this.k;
    }

    private void h() {
        com.pgl.sys.a.a.a(this.b, b(), new com.pgl.sys.a.a.a() {
            /* class com.pgl.sys.ces.b.AnonymousClass2 */

            @Override // com.pgl.sys.a.a.a
            public void a(String str) {
                boolean unused = b.m = true;
            }
        });
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public void SetRegionType(int i2) {
        com.pgl.a.a.a.a(i2);
    }

    public Object a(int i2, Object obj) {
        String trim;
        String str = null;
        if (i2 == 123) {
            return com.pgl.sys.ces.a.e.a(this.b);
        }
        if (i2 == 121) {
            return c.c(this.b);
        }
        if (i2 == 122) {
            return c.a();
        }
        if (i2 == 126) {
            return c.e(this.b);
        }
        if (i2 == 127) {
            return c.a(this.b);
        }
        if (i2 == 128) {
            return c.b(this.b);
        }
        if (i2 == 120) {
            return com.pgl.sys.ces.a.b.a();
        }
        if (i2 == 124) {
            return f.b(this.b);
        }
        if (i2 == 130) {
            return f.a(this.b);
        }
        if (i2 == 125) {
            return f.c(this.b);
        }
        if (i2 == 129) {
            return d.a(this.b);
        }
        if (i2 == 131) {
            return com.pgl.sys.a.a.a();
        }
        if (i2 == 132) {
            reportNow((String) obj);
            return null;
        } else if (i2 == 134) {
            return com.pgl.sys.ces.b.b.a(this.b).c();
        } else {
            if (i2 == 140) {
                return com.pgl.sys.ces.b.a.a(this.b).e();
            }
            if (i2 == 133) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Object> entry : n.entrySet()) {
                        if (entry.getValue() == null) {
                            jSONObject.put(entry.getKey(), "");
                        } else {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    str = jSONObject.toString();
                } catch (Throwable unused) {
                }
                trim = str == null ? "{}" : str.trim();
            } else if (i2 == 135) {
                String a2 = c.a();
                trim = a2 == null ? "0000000000000000000000000000000000000000" : a2.trim();
            } else if (i2 == 136) {
                try {
                    return this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            } else if (i2 == 201) {
                return c.d(this.b);
            } else {
                if (i2 == 202) {
                    return c.b();
                }
                if (i2 != 236) {
                    return null;
                }
                try {
                    return Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, (String) obj);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return trim;
        }
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public String debugEntry(Context context, int i2) {
        return (String) a.meta(1024768, null, null);
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public String onEvent() {
        return com.pgl.sys.a.a.a();
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public String pullSg() {
        return c.a();
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public String pullVer(String str) {
        return c.a(str);
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public void reportNow(final String str) {
        try {
            new Thread("CZL-LRT") {
                /* class com.pgl.sys.ces.b.AnonymousClass3 */

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        long j = 0;
                        long timeInMillis = b.a().a ? Calendar.getInstance().getTimeInMillis() : 0;
                        byte[] bArr = (byte[]) a.meta(222, b.this.b, str);
                        if (b.a().a) {
                            j = Calendar.getInstance().getTimeInMillis();
                        }
                        if (b.a().a) {
                            Log.d("CZL_Efficient", "[Efficient] report : " + (j - timeInMillis));
                        }
                        if (bArr == null || bArr.length <= 0) {
                            throw new NullPointerException("NullPointerException");
                        }
                        new com.pgl.sys.ces.c.a(b.this.b, b.this.h).a(1, 2, bArr);
                    } catch (Throwable unused) {
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.k = true;
        a("SP1");
        com.pgl.a.b.f.a(10000);
        h();
        com.pgl.a.b.f.a(10000);
        reportNow("CZL-L1st");
        while (true) {
            int i2 = 0;
            do {
                com.pgl.sys.ces.b.b.a(this.b).b();
                com.pgl.sys.ces.b.a.a(this.b).d();
                if (((long) i2) == 10) {
                    reportNow("CZL-LLP");
                }
                i2++;
                a.meta(1213, null, Thread.currentThread().getName() + "-" + i2);
                com.pgl.a.b.f.a(180000);
            } while (((long) i2) <= 10);
        }
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public void setCustomInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            n = hashMap;
        }
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public void setEfficientDebug(boolean z) {
        this.a = z;
    }

    @Override // com.pgl.sys.ces.out.ISdkLite
    public void setParams(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.i = str;
            a.meta(103, null, str);
        }
        if (str2 != null && str2.length() > 0) {
            this.j = str2;
            a.meta(104, null, str2);
        }
        if (!isAlive() || !g()) {
            try {
                start();
            } catch (Throwable unused) {
            }
        }
    }
}
