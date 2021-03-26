package com.loc;

import android.content.Context;
import com.loc.ao;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils */
public final class bd {
    public static ax a(WeakReference<ax> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ax());
        }
        return weakReference.get();
    }

    public static String a(Context context, t tVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String f = n.f(context);
            sb.append("\"sim\":\"");
            sb.append(f);
            sb.append("\",\"sdkversion\":\"");
            sb.append(tVar.c());
            sb.append("\",\"product\":\"");
            sb.append(tVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(tVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(n.d(context));
            sb.append("\",\"np\":\"");
            sb.append(n.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(n.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(n.e(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static void a(Context context, ax axVar, String str, int i, int i2, String str2) {
        axVar.a = z.c(context, str);
        axVar.d = i;
        axVar.b = (long) i2;
        axVar.c = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x005b A[SYNTHETIC, Splitter:B:43:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0065 A[SYNTHETIC, Splitter:B:48:0x0065] */
    static byte[] a(ao aoVar, String str) {
        Throwable th;
        ao.b bVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            bVar = aoVar.a(str);
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
                        ab.b(th, "sui", "rdS");
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
            ab.b(th, "sui", "rdS");
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
}
