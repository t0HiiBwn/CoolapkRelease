package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: NetManger */
public final class cx extends cs {
    private static cx c;
    private Handler d;

    public static cx b() {
        return c();
    }

    private static synchronized cx c() {
        cx cxVar;
        synchronized (cx.class) {
            try {
                if (c == null) {
                    c = new cx();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (bm.c() == null) {
                    bm.a(bx.a());
                }
            } catch (Throwable unused) {
            }
            cxVar = c;
        }
        return cxVar;
    }

    private cx() {
        try {
            if (Looper.myLooper() == null) {
                this.d = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.d = new a();
            }
        } catch (Throwable th) {
            cg.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.s.cs
    public final byte[] b(cy cyVar) throws bh {
        try {
            cz a2 = a(cyVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (bh e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            cg.d().b(th, "NetManager", "makeSyncPostRequest");
            throw new bh("未知的错误");
        }
    }

    public static byte[] d(cy cyVar) throws bh {
        try {
            cz b = b(cyVar, false);
            if (b != null) {
                return b.a;
            }
            return null;
        } catch (bh e) {
            throw e;
        } catch (Throwable unused) {
            throw new bh("未知的错误");
        }
    }

    public static byte[] e(cy cyVar) throws bh {
        try {
            cz b = b(cyVar, true);
            if (b != null) {
                return b.a;
            }
            return null;
        } catch (bh e) {
            throw e;
        } catch (Throwable unused) {
            throw new bh("未知的错误");
        }
    }

    private static cz b(cy cyVar, boolean z) throws bh {
        cz czVar;
        int a2 = cv.a(cyVar);
        try {
            czVar = a(cyVar, z, a2);
        } catch (bh e) {
            if (cv.a(a2)) {
                czVar = null;
            } else {
                throw e;
            }
        }
        if ((czVar != null && czVar.a != null && czVar.a.length > 0) || !cv.a(a2)) {
            return czVar;
        }
        try {
            return a(cyVar, z, 3);
        } catch (bh e2) {
            throw e2;
        }
    }

    private static cz a(cy cyVar, boolean z, int i) throws bh {
        try {
            c(cyVar);
            return new cv(cyVar, z).a(cyVar.h(), cyVar.n(), cyVar.o(), cyVar.j(), cyVar.f(), cyVar.e(), i);
        } catch (bh e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bh("未知的错误");
        }
    }

    /* compiled from: NetManger */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    Object obj = message.obj;
                } else if (i == 1) {
                    Object obj2 = message.obj;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
