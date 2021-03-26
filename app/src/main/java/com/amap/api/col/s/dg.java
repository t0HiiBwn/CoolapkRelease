package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.cp;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public final class dg {
    public static void a(Context context, da daVar, String str, int i, int i2, String str2) {
        daVar.a = ce.c(context, str);
        daVar.d = i;
        daVar.b = (long) i2;
        daVar.c = str2;
    }

    public static da a(WeakReference<da> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new da());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x005b A[SYNTHETIC, Splitter:B:43:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0065 A[SYNTHETIC, Splitter:B:48:0x0065] */
    static byte[] a(cp cpVar, String str) {
        Throwable th;
        cp.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = cpVar.a(str);
            if (bVar != null) {
                try {
                    InputStream a = bVar.a();
                    if (a == null) {
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                    byte[] bArr2 = new byte[a.available()];
                    a.read(bArr2);
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return bArr2;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        cg.c(th, "sui", "rdS");
                        if (0 != 0) {
                        }
                        if (bVar != null) {
                        }
                        return bArr;
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
            } else {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                return bArr;
            }
        } catch (Throwable th9) {
            th = th9;
            bVar = null;
            cg.c(th, "sui", "rdS");
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Throwable th11) {
                    th11.printStackTrace();
                }
            }
            return bArr;
        }
        throw th;
        if (bVar != null) {
            bVar.close();
        }
        throw th;
    }

    public static String a(Context context, br brVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String f = bm.f(context);
            sb.append("\"sim\":\"");
            sb.append(f);
            sb.append("\",\"sdkversion\":\"");
            sb.append(brVar.d());
            sb.append("\",\"product\":\"");
            sb.append(brVar.b());
            sb.append("\",\"ed\":\"");
            sb.append(brVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(bm.d(context));
            sb.append("\",\"np\":\"");
            sb.append(bm.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(bm.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(bm.e(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
