package com.loc;

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
public class ac {
    private static WeakReference<ax> a = null;
    private static boolean b = true;
    private static WeakReference<bq> c;
    private static WeakReference<bq> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static t i;

    private static t a(String str) {
        List<t> a2 = z.a();
        if (a2 == null) {
            a2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (t tVar : a2) {
                if (z.a(tVar.f(), str)) {
                    return tVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return u.a();
                } catch (j e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    t b2 = u.b();
                    b2.a(true);
                    return b2;
                } catch (j e3) {
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
    private static String a(List<t> list) {
        FileInputStream fileInputStream;
        ap apVar;
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
                apVar = new ap(fileInputStream, ao.b);
                boolean z = false;
                while (true) {
                    try {
                        String trim = apVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = apVar.a();
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
                                    ab.b(th2, "alg", "aDa");
                                }
                                int i3 = h;
                                if (i3 != 5) {
                                    if (!g) {
                                        Iterator<t> it2 = list.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            t next = it2.next();
                                            boolean b2 = z.b(next.f(), trim);
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
                        if (apVar != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (g) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            ab.b(th, "alg", "getA");
                            if (apVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (g) {
                            }
                        } catch (Throwable th4) {
                            ab.b(th4, "alg", "getA");
                        }
                    }
                    try {
                        apVar.close();
                    } catch (Throwable th5) {
                        ab.b(th5, "alg", "getA");
                    }
                    try {
                        fileInputStream.close();
                        break;
                    } catch (Throwable th6) {
                        ab.b(th6, "alg", "getA");
                    }
                }
            } catch (FileNotFoundException unused3) {
                apVar = null;
                if (apVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th7) {
                th = th7;
                apVar = null;
                ab.b(th, "alg", "getA");
                if (apVar != null) {
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
            apVar = null;
            fileInputStream = null;
            if (apVar != null) {
                try {
                    apVar.close();
                } catch (Throwable th8) {
                    ab.b(th8, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        } catch (Throwable th9) {
            th = th9;
            apVar = null;
            fileInputStream = null;
            ab.b(th, "alg", "getA");
            if (apVar != null) {
                try {
                    apVar.close();
                } catch (Throwable th10) {
                    ab.b(th10, "alg", "getA");
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

    static void a(Context context) {
        String a2;
        t tVar;
        List<t> a3 = z.a();
        if (a3 != null && a3.size() != 0 && (a2 = a(a3)) != null && !"".equals(a2) && (tVar = i) != null) {
            a(context, tVar, 2, "ANR", a2);
        }
    }

    private static void a(final Context context, final bq bqVar, final String str) {
        ab.d().submit(new Runnable() {
            /* class com.loc.ac.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    synchronized (ac.class) {
                        ax a2 = bd.a(ac.a);
                        bd.a(context, a2, str, 1000, 4096000, "1");
                        a2.f = bqVar;
                        if (a2.g == null) {
                            a2.g = new bh(new bg(context, new bl(), new aj(new al(new an())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", k.f(context), n.x(context), n.w(context), k.c(context), Build.MODEL, k.b(context), k.d(context), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        ay.a(a2);
                    }
                } catch (Throwable th) {
                    ab.b(th, "lg", "pul");
                }
            }
        });
    }

    private static void a(Context context, t tVar, int i2, String str, String str2) {
        String str3;
        String a2 = u.a(System.currentTimeMillis());
        String a3 = bd.a(context, tVar);
        k.a(context);
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
            String b2 = r.b(str2);
            if (i2 == 1) {
                str3 = z.b;
            } else if (i2 == 2) {
                str3 = z.d;
            } else if (i2 == 0) {
                str3 = z.c;
            } else {
                return;
            }
            ax a4 = bd.a(a);
            bd.a(context, a4, str3, 1000, 4096000, "1");
            if (a4.e == null) {
                a4.e = new ai(new aj(new al(new an())));
            }
            try {
                ay.a(b2, u.a(stringBuffer2.replaceAll("\n", "<br/>")), a4);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = u.a(th);
        t a3 = a(a2);
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

    static void a(t tVar, Context context, String str, String str2) {
        if (a(tVar) && str != null && !"".equals(str)) {
            a(context, tVar, 1, str, str2);
        }
    }

    private static boolean a(t tVar) {
        return tVar != null && tVar.e();
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
            ab.b(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void b(Context context) {
        bo boVar = new bo(b);
        b = false;
        a(context, boVar, z.c);
    }

    static void c(Context context) {
        WeakReference<bq> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new bp(context, 3600000, "hKey", new br(context)));
        }
        a(context, c.get(), z.d);
    }

    static void d(Context context) {
        WeakReference<bq> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new bp(context, 3600000, "gKey", new br(context)));
        }
        a(context, d.get(), z.b);
    }
}
