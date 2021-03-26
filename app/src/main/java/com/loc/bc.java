package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: StatisticsManager */
public class bc {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<ax> d;
    private static int e;

    /* compiled from: StatisticsManager */
    static class a implements Runnable {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private bb e;
        private int f;
        private List<bb> g;

        a(Context context, int i) {
            this.d = context;
            this.f = i;
        }

        a(Context context, int i, bb bbVar) {
            this(context, i);
            this.e = bbVar;
        }

        a(Context context, int i, List<bb> list) {
            this(context, i);
            this.g = list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x0083 A[SYNTHETIC, Splitter:B:62:0x0083] */
        @Override // java.lang.Runnable
        public final void run() {
            String str;
            String str2;
            Throwable th;
            Throwable th2;
            int i = this.f;
            if (i == 1) {
                try {
                    if (this.d == null) {
                        return;
                    }
                    if (this.e != null) {
                        synchronized (bc.class) {
                            Context context = this.d;
                            if (context != null) {
                                bb bbVar = this.e;
                                if (bbVar != null) {
                                    bc.a(context, bbVar.a());
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    str = "stm";
                    str2 = "as";
                    ab.b(th, str, str2);
                    return;
                }
            } else if (i == 2) {
                try {
                    synchronized (bc.class) {
                        if (this.g != null) {
                            if (this.d != null) {
                                ByteArrayOutputStream byteArrayOutputStream = null;
                                byte[] bArr = new byte[0];
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        for (bb bbVar2 : this.g) {
                                            if (bbVar2 != null) {
                                                byteArrayOutputStream2.write(bbVar2.a());
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
                                            ab.b(th, "stm", "aStB");
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                            bc.a(this.d, bArr);
                                            return;
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    ab.b(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bc.a(this.d, bArr);
                                    return;
                                }
                                bc.a(this.d, bArr);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str = "stm";
                    str2 = "apb";
                    ab.b(th, str, str2);
                    return;
                }
            } else if (i == 3) {
                try {
                    if (this.d != null) {
                        ax a2 = bd.a(bc.d);
                        bd.a(this.d, a2, z.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new be(new bi(this.d, new bf(new bj(new bl()))));
                        }
                        a2.h = 3600000;
                        if (TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            a2.f = new bp(this.d, a2.h, a2.i, new bm(a2.a, new bn(this.d, bc.a, bc.c * 1024, bc.b * 1024, "staticUpdate", bc.e * 1024)));
                        }
                        ay.a(a2);
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    ab.b(th10, "stm", "usd");
                    return;
                }
            } else {
                return;
            }
            th2.printStackTrace();
            bc.a(this.d, bArr);
            return;
            throw th;
        }
    }

    public static void a(Context context) {
        ab.d().submit(new a(context, a.c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        ax a2 = bd.a(d);
        bd.a(context, a2, z.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new am();
        }
        Random random = new Random();
        try {
            ay.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            ab.b(th, "stm", "wts");
        }
    }

    public static synchronized void a(bb bbVar, Context context) {
        synchronized (bc.class) {
            ab.d().submit(new a(context, a.a, bbVar));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r4.size() == 0) goto L_0x001f;
     */
    public static synchronized void a(List<bb> list, Context context) {
        synchronized (bc.class) {
            if (list != null) {
            }
            return;
        }
        ab.d().submit(new a(context, a.b, list));
    }

    public static synchronized void a(boolean z, int i) {
        synchronized (bc.class) {
            a = z;
            e = Math.max(0, i);
        }
    }

    public static synchronized void b(List<bb> list, Context context) {
        synchronized (bc.class) {
            try {
                List<bb> b2 = as.b();
                if (b2 != null && b2.size() > 0) {
                    list.addAll(b2);
                }
            } catch (Throwable unused) {
            }
            a(list, context);
        }
    }
}
