package com.amap.api.mapcore2d;

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
public class dp {
    private static WeakReference<fa> a = null;
    private static boolean b = true;
    private static WeakReference<fu> c;
    private static WeakReference<fu> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static da i;

    private static boolean a(da daVar) {
        return daVar != null && daVar.f();
    }

    private static void a(Context context, da daVar, int i2, String str, String str2) {
        String str3;
        String a2 = fh.a();
        String a3 = fh.a(cq.a(context), fh.a(context, daVar), a2, i2, str, str2);
        if (a3 != null && !"".equals(a3)) {
            String c2 = cx.c(str2);
            if (i2 == 1) {
                str3 = dm.b;
            } else if (i2 == 2) {
                str3 = dm.d;
            } else if (i2 == 0) {
                str3 = dm.c;
            } else {
                return;
            }
            a(context, c2, str3, a3);
        }
    }

    static void a(Context context) {
        String a2;
        da daVar;
        List<da> c2 = dm.c(context);
        if (c2 != null && c2.size() != 0 && (a2 = a(c2)) != null && !"".equals(a2) && (daVar = i) != null) {
            a(context, daVar, 2, "ANR", a2);
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = db.a(th);
        da a3 = a(context, a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String a4 = a(th);
            if (a4 != null && !"".equals(a4)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$");
                    sb.append("<br/>");
                }
                sb.append(replaceAll);
                a(context, a3, i2, a4, sb.toString());
            }
        }
    }

    static void a(da daVar, Context context, String str, String str2) {
        if (a(daVar) && str != null && !"".equals(str)) {
            a(context, daVar, 0, str, str2);
        }
    }

    static void b(da daVar, Context context, String str, String str2) {
        if (a(daVar) && str != null && !"".equals(str)) {
            a(context, daVar, 1, str, str2);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        fa a2 = fh.a(a);
        fh.a(context, a2, str2, 1000, 40960, "1");
        if (a2.e == null) {
            a2.e = new dd(new de(new dg(new di())));
        }
        try {
            fb.a(str, db.a(str3.replaceAll("\n", "<br/>")), a2);
        } catch (Throwable unused) {
        }
    }

    static void b(Context context) {
        fs fsVar = new fs(b);
        b = false;
        a(context, fsVar, dm.c);
    }

    static void c(Context context) {
        WeakReference<fu> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new ft(context, 3600000, "hKey", new fv(context, false)));
        }
        a(context, c.get(), dm.d);
    }

    static void d(Context context) {
        WeakReference<fu> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new ft(context, 3600000, "gKey", new fv(context, false)));
        }
        a(context, d.get(), dm.b);
    }

    private static void a(final Context context, final fu fuVar, final String str) {
        Cdo.d().submit(new Runnable() {
            /* class com.amap.api.mapcore2d.dp.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (dp.class) {
                        fa a2 = fh.a(dp.a);
                        fh.a(context, a2, str, 1000, 40960, "1");
                        a2.f = fuVar;
                        if (a2.g == null) {
                            a2.g = new fl(new fk(context, new fp(), new de(new dg(new di())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", cq.f(context), cu.v(context), cq.c(context), Build.MODEL, cq.b(context), cq.d(context), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        fb.a(a2);
                    }
                } catch (Throwable th) {
                    Cdo.c(th, "lg", "pul");
                }
            }
        });
    }

    static da a(Context context, String str) {
        List<da> c2 = dm.c(context);
        if (c2 == null) {
            c2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (da daVar : c2) {
                if (dm.a(daVar.g(), str)) {
                    return daVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return db.a();
                } catch (cp e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    da b2 = db.b();
                    b2.a(true);
                    return b2;
                } catch (cp e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String a(Throwable th) {
        return th.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A[SYNTHETIC, Splitter:B:55:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d2 A[SYNTHETIC, Splitter:B:77:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00e8 A[RETURN] */
    static String a(List<da> list) {
        FileInputStream fileInputStream;
        eo eoVar;
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
                eoVar = new eo(fileInputStream, ep.a);
                boolean z = false;
                while (true) {
                    try {
                        String trim = eoVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = eoVar.a();
                            }
                            z = true;
                        }
                        if (trim.equals("") && z) {
                            break;
                        } else if (z) {
                            a(trim);
                            int i2 = h;
                            if (i2 == 5) {
                                break;
                            } else if (!g) {
                                Iterator<da> it2 = list.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    da next = it2.next();
                                    boolean b2 = dm.b(next.g(), trim);
                                    g = b2;
                                    if (b2) {
                                        i = next;
                                        break;
                                    }
                                }
                            } else {
                                h = i2 + 1;
                            }
                        }
                    } catch (EOFException unused) {
                    } catch (FileNotFoundException unused2) {
                        if (eoVar != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (g) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Cdo.c(th, "alg", "getA");
                            if (eoVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (g) {
                            }
                        } catch (Throwable th3) {
                            Cdo.c(th3, "alg", "getA");
                        }
                    }
                }
                try {
                    eoVar.close();
                } catch (Throwable th4) {
                    Cdo.c(th4, "alg", "getA");
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th5) {
                    Cdo.c(th5, "alg", "getA");
                }
            } catch (FileNotFoundException unused3) {
                eoVar = null;
                if (eoVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th6) {
                th = th6;
                eoVar = null;
                Cdo.c(th, "alg", "getA");
                if (eoVar != null) {
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
            eoVar = null;
            fileInputStream = null;
            if (eoVar != null) {
                try {
                    eoVar.close();
                } catch (Throwable th7) {
                    Cdo.c(th7, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        } catch (Throwable th8) {
            th = th8;
            eoVar = null;
            fileInputStream = null;
            Cdo.c(th, "alg", "getA");
            if (eoVar != null) {
                try {
                    eoVar.close();
                } catch (Throwable th9) {
                    Cdo.c(th9, "alg", "getA");
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

    private static void a(String str) {
        try {
            if (f > 9) {
                f = 0;
            }
            String[] strArr = e;
            int i2 = f;
            strArr[i2] = str;
            f = i2 + 1;
        } catch (Throwable th) {
            Cdo.c(th, "alg", "aDa");
        }
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (true) {
                if (i2 >= 10) {
                    break;
                } else if (i2 > 9) {
                    break;
                } else {
                    sb.append(e[i2]);
                    i2++;
                }
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            Cdo.c(th, "alg", "gLI");
        }
        return sb.toString();
    }
}
