package com.amap.api.mapcore2d;

import android.content.Context;
import com.amap.api.mapcore2d.em;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public class fh {
    public static void a(Context context, fa faVar, String str, int i, int i2, String str2) {
        faVar.a = dm.c(context, str);
        faVar.d = i;
        faVar.b = (long) i2;
        faVar.c = str2;
    }

    public static fa a(WeakReference<fa> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new fa());
        }
        return weakReference.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0060 A[SYNTHETIC, Splitter:B:45:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x006a A[SYNTHETIC, Splitter:B:50:0x006a] */
    static byte[] a(em emVar, String str, boolean z) {
        Throwable th;
        em.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = emVar.a(str);
            if (bVar == null) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream a = bVar.a(0);
                if (a == null) {
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return bArr;
                }
                byte[] bArr2 = new byte[a.available()];
                a.read(bArr2);
                if (z) {
                    emVar.c(str);
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                return bArr2;
            } catch (Throwable th7) {
                th = th7;
                try {
                    Cdo.c(th, "sui", "rdS");
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
        } catch (Throwable th11) {
            th = th11;
            bVar = null;
            Cdo.c(th, "sui", "rdS");
            if (0 != 0) {
            }
            if (bVar != null) {
            }
            return bArr;
        }
        throw th;
        if (bVar != null) {
            bVar.close();
        }
        throw th;
    }

    public static String a() {
        return db.a(System.currentTimeMillis());
    }

    public static String a(Context context, da daVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String g = cu.g(context);
            sb.append("\"sim\":\"");
            sb.append(g);
            sb.append("\",\"sdkversion\":\"");
            sb.append(daVar.c());
            sb.append("\",\"product\":\"");
            sb.append(daVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(daVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(cu.e(context));
            sb.append("\",\"np\":\"");
            sb.append(cu.c(context));
            sb.append("\",\"mnc\":\"");
            sb.append(cu.d(context));
            sb.append("\",\"ant\":\"");
            sb.append(cu.f(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append(",");
        stringBuffer.append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
