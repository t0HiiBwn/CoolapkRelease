package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ErrorLogManager */
public class ch {
    private static WeakReference<da> a = null;
    private static boolean b = true;
    private static WeakReference<dt> c;
    private static WeakReference<dt> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static br i;

    private static boolean a(br brVar) {
        return brVar != null && brVar.f();
    }

    static void a(Context context) {
        String a2;
        br brVar;
        List<br> a3 = ce.a();
        if (a3 != null && a3.size() != 0 && (a2 = a(a3)) != null && !"".equals(a2) && (brVar = i) != null) {
            a(context, brVar, 2, "ANR", a2);
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = bs.a(th);
        br a3 = a(a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                a(context, a3, i2, th2, sb.toString());
            }
        }
    }

    static void a(br brVar, Context context, String str, String str2) {
        if (a(brVar) && str != null && !"".equals(str)) {
            a(context, brVar, 1, str, str2);
        }
    }

    static void b(Context context) {
        dr drVar = new dr(b);
        b = false;
        a(context, drVar, ce.c);
    }

    static void c(Context context) {
        WeakReference<dt> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new ds(context, 3600000, "hKey", new du(context)));
        }
        a(context, c.get(), ce.d);
    }

    static void d(Context context) {
        WeakReference<dt> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new ds(context, 3600000, "gKey", new du(context)));
        }
        a(context, d.get(), ce.b);
    }

    private static void a(final Context context, final dt dtVar, final String str) {
        cg.c().submit(new Runnable() {
            /* class com.amap.api.col.s.ch.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    synchronized (ch.class) {
                        da a2 = dg.a(ch.a);
                        dg.a(context, a2, str, 1000, 4096000, "1");
                        a2.f = dtVar;
                        if (a2.g == null) {
                            a2.g = new dk(new dj(context, new Cdo(), new cl(new cn(new co())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", bi.f(context), bm.t(context), bm.s(context), bi.c(context), Build.MODEL, bi.b(context), bi.d(context), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        db.a(a2);
                    }
                } catch (Throwable th) {
                    cg.c(th, "lg", "pul");
                }
            }
        });
    }

    private static br a(String str) {
        List<br> a2 = ce.a();
        if (a2 == null) {
            a2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (br brVar : a2) {
                if (ce.a(brVar.g(), str)) {
                    return brVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return bs.a();
                } catch (bh e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    br b2 = bs.b();
                    b2.a();
                    return b2;
                } catch (bh e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bc A[SYNTHETIC, Splitter:B:58:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e4 A[SYNTHETIC, Splitter:B:80:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ff A[RETURN] */
    private static String a(List<br> list) {
        FileInputStream fileInputStream;
        cq cqVar;
        Throwable th;
        try {
            File file = new File("/data/anr/traces.txt");
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                int available = fileInputStream.available();
                if (available > 1024000) {
                    fileInputStream.skip((long) (available - 1024000));
                }
                cqVar = new cq(fileInputStream, cp.b);
                boolean z = false;
                while (true) {
                    try {
                        String trim = cqVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = cqVar.a();
                            }
                            z = true;
                        }
                        if (!trim.equals("") || !z) {
                            if (z) {
                                try {
                                    if (f > 9) {
                                        f = 0;
                                    }
                                    String[] strArr = e;
                                    int i2 = f;
                                    strArr[i2] = trim;
                                    f = i2 + 1;
                                } catch (Throwable th2) {
                                    cg.c(th2, "alg", "aDa");
                                }
                                int i3 = h;
                                if (i3 != 5) {
                                    if (!g) {
                                        Iterator<br> it2 = list.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            br next = it2.next();
                                            boolean b2 = ce.b(next.g(), trim);
                                            g = b2;
                                            if (b2) {
                                                i = next;
                                                break;
                                            }
                                        }
                                    } else {
                                        h = i3 + 1;
                                    }
                                }
                            }
                        }
                    } catch (EOFException unused) {
                    } catch (FileNotFoundException unused2) {
                        if (cqVar != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (g) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            cg.c(th, "alg", "getA");
                            if (cqVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (g) {
                            }
                        } catch (Throwable th4) {
                            cg.c(th4, "alg", "getA");
                        }
                    }
                    try {
                        cqVar.close();
                    } catch (Throwable th5) {
                        cg.c(th5, "alg", "getA");
                    }
                    try {
                        fileInputStream.close();
                        break;
                    } catch (Throwable th6) {
                        cg.c(th6, "alg", "getA");
                    }
                }
            } catch (FileNotFoundException unused3) {
                cqVar = null;
                if (cqVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th7) {
                th = th7;
                cqVar = null;
                cg.c(th, "alg", "getA");
                if (cqVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            }
            if (g) {
                return b();
            }
            return null;
        } catch (FileNotFoundException unused4) {
            cqVar = null;
            fileInputStream = null;
            if (cqVar != null) {
                try {
                    cqVar.close();
                } catch (Throwable th8) {
                    cg.c(th8, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        } catch (Throwable th9) {
            th = th9;
            cqVar = null;
            fileInputStream = null;
            cg.c(th, "alg", "getA");
            if (cqVar != null) {
                try {
                    cqVar.close();
                } catch (Throwable th10) {
                    cg.c(th10, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw th;
        throw th;
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (i2 < 10 && i2 <= 9) {
                sb.append(e[i2]);
                i2++;
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            cg.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    private static void a(Context context, br brVar, int i2, String str, String str2) {
        String str3;
        String a2 = bs.a(System.currentTimeMillis());
        String a3 = dg.a(context, brVar);
        bi.a(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a3);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(a2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i2);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !"".equals(stringBuffer2)) {
            String b2 = bq.b(str2);
            if (i2 == 1) {
                str3 = ce.b;
            } else if (i2 == 2) {
                str3 = ce.d;
            } else if (i2 == 0) {
                str3 = ce.c;
            } else {
                return;
            }
            da a4 = dg.a(a);
            dg.a(context, a4, str3, 1000, 4096000, "1");
            if (a4.e == null) {
                a4.e = new ck(new cl(new cn(new co())));
            }
            try {
                db.a(b2, bs.a(stringBuffer2.replaceAll("\n", "<br/>")), a4);
            } catch (Throwable unused) {
            }
        }
    }
}
