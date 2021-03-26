package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

/* compiled from: NetManger */
public class ev extends er {
    private static ev c;
    private fw d;
    private Handler e;

    public static ev a(boolean z) {
        return a(z, 5);
    }

    private static synchronized ev a(boolean z, int i) {
        ev evVar;
        synchronized (ev.class) {
            try {
                ev evVar2 = c;
                if (evVar2 == null) {
                    c = new ev(z, i);
                } else if (z && evVar2.d == null) {
                    evVar2.d = fw.a(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            evVar = c;
        }
        return evVar;
    }

    private ev(boolean z, int i) {
        if (z) {
            try {
                this.d = fw.a(i);
            } catch (Throwable th) {
                Cdo.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), null);
        } else {
            this.e = new a();
        }
    }

    /* renamed from: com.amap.api.mapcore2d.ev$1  reason: invalid class name */
    /* compiled from: NetManger */
    class AnonymousClass1 extends fx {
        final /* synthetic */ ew a;
        final /* synthetic */ ex b;
        final /* synthetic */ ev c;

        @Override // com.amap.api.mapcore2d.fx
        public void a() {
            try {
                this.c.a(this.c.b(this.a, false), this.b);
            } catch (cp e) {
                this.c.a(e, this.b);
            }
        }
    }

    @Override // com.amap.api.mapcore2d.er
    public byte[] b(ew ewVar) throws cp {
        try {
            ey a2 = a(ewVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (cp e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            Cdo.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new cp("未知的错误");
        }
    }

    public byte[] d(ew ewVar) throws cp {
        try {
            ey b = b(ewVar, false);
            if (b != null) {
                return b.a;
            }
            return null;
        } catch (cp e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new cp("未知的错误");
        }
    }

    public byte[] e(ew ewVar) throws cp {
        try {
            ey b = b(ewVar, true);
            if (b != null) {
                return b.a;
            }
            return null;
        } catch (cp e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new cp("未知的错误");
        }
    }

    public ey b(ew ewVar, boolean z) throws cp {
        Proxy proxy;
        try {
            c(ewVar);
            if (ewVar.e == null) {
                proxy = null;
            } else {
                proxy = ewVar.e;
            }
            return new eu(ewVar.c, ewVar.d, proxy, z).a(ewVar.h(), ewVar.n(), ewVar.m(), ewVar.f(), ewVar.g(), ewVar.o());
        } catch (cp e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new cp("未知的错误");
        }
    }

    /* access modifiers changed from: private */
    public void a(cp cpVar, ex exVar) {
        ez ezVar = new ez();
        ezVar.a = cpVar;
        ezVar.b = exVar;
        Message obtain = Message.obtain();
        obtain.obj = ezVar;
        obtain.what = 1;
        this.e.sendMessage(obtain);
    }

    /* access modifiers changed from: private */
    public void a(ey eyVar, ex exVar) {
        exVar.a(eyVar.b, eyVar.a);
        ez ezVar = new ez();
        ezVar.b = exVar;
        Message obtain = Message.obtain();
        obtain.obj = ezVar;
        obtain.what = 0;
        this.e.sendMessage(obtain);
    }

    /* compiled from: NetManger */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, AnonymousClass1 r2) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    ((ez) message.obj).b.a();
                } else if (i == 1) {
                    ez ezVar = (ez) message.obj;
                    ezVar.b.a(ezVar.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
