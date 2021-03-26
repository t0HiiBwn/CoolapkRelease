package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: StatisticsManager */
public class df {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<da> d;
    private static int e;

    /* compiled from: StatisticsManager */
    static class a implements Runnable {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private de e;
        private int f;
        private List<de> g;

        a(Context context, int i) {
            this.d = context;
            this.f = i;
        }

        a(Context context, int i, List<de> list) {
            this(context, i);
            this.g = list;
        }

        a(Context context, int i, de deVar) {
            this(context, i);
            this.e = deVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x0083 A[SYNTHETIC, Splitter:B:61:0x0083] */
        @Override // java.lang.Runnable
        public final void run() {
            Throwable th;
            Throwable th2;
            int i = this.f;
            if (i == 1) {
                try {
                    if (this.d == null) {
                        return;
                    }
                    if (this.e != null) {
                        synchronized (df.class) {
                            Context context = this.d;
                            if (context != null) {
                                de deVar = this.e;
                                if (deVar != null) {
                                    df.a(context, deVar.a());
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    cg.c(th3, "stm", "as");
                    return;
                }
            } else if (i == 2) {
                try {
                    synchronized (df.class) {
                        if (this.g != null) {
                            if (this.d != null) {
                                ByteArrayOutputStream byteArrayOutputStream = null;
                                byte[] bArr = new byte[0];
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        for (de deVar2 : this.g) {
                                            if (deVar2 != null) {
                                                byteArrayOutputStream2.write(deVar2.a());
                                            }
                                        }
                                        bArr = byteArrayOutputStream2.toByteArray();
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        try {
                                            cg.c(th, "stm", "aStB");
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                            df.a(this.d, bArr);
                                            return;
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    cg.c(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                    }
                                    df.a(this.d, bArr);
                                    return;
                                }
                                df.a(this.d, bArr);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th9) {
                    cg.c(th9, "stm", "apb");
                    return;
                }
            } else if (i == 3) {
                try {
                    if (this.d != null) {
                        da a2 = dg.a(df.d);
                        dg.a(this.d, a2, ce.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new dh(new dl(this.d, new di(new dm(new Cdo()))));
                        }
                        a2.h = 3600000;
                        if (TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            a2.f = new ds(this.d, a2.h, a2.i, new dp(a2.a, new dq(this.d, df.a, df.c * 1024, df.b * 1024, "staticUpdate", df.e * 1024)));
                        }
                        db.a(a2);
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    cg.c(th10, "stm", "usd");
                    return;
                }
            } else {
                return;
            }
            th2.printStackTrace();
            df.a(this.d, bArr);
            return;
            throw th;
        }
    }

    public static synchronized void a(de deVar, Context context) {
        synchronized (df.class) {
            cg.c().submit(new a(context, a.a, deVar));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r4.size() == 0) goto L_0x001f;
     */
    public static synchronized void a(List<de> list, Context context) {
        synchronized (df.class) {
            if (list != null) {
            }
            return;
        }
        cg.c().submit(new a(context, a.b, list));
    }

    public static void a(Context context) {
        cg.c().submit(new a(context, a.c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        da a2 = dg.a(d);
        dg.a(context, a2, ce.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new cj();
        }
        Random random = new Random();
        try {
            db.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            cg.c(th, "stm", "wts");
        }
    }
}
