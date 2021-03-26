package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;
import com.xiaomi.push.service.u;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class em {
    public static boolean a;
    private static final AtomicInteger o = new AtomicInteger(0);
    protected int b = 0;
    protected long c = -1;
    protected volatile long d = 0;
    protected volatile long e = 0;
    protected final Map<er, a> f = new ConcurrentHashMap();
    protected final Map<er, a> g = new ConcurrentHashMap();
    protected ez h = null;
    protected String i = "";
    protected String j = "";
    protected final int k = o.getAndIncrement();
    protected en l;
    protected XMPushService m;
    protected long n = 0;
    private LinkedList<Pair<Integer, Long>> p = new LinkedList<>();
    private final Collection<ep> q = new CopyOnWriteArrayList();
    private int r = 2;
    private long s = 0;

    public static class a {
        private er a;
        private fa b;

        public a(er erVar, fa faVar) {
            this.a = erVar;
            this.b = faVar;
        }

        public void a(ef efVar) {
            this.a.a(efVar);
        }

        public void a(fe feVar) {
            fa faVar = this.b;
            if (faVar == null || faVar.a(feVar)) {
                this.a.b(feVar);
            }
        }
    }

    static {
        a = false;
        try {
            a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        es.a();
    }

    protected em(XMPushService xMPushService, en enVar) {
        this.l = enVar;
        this.m = xMPushService;
        h();
    }

    private String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    private void b(int i2) {
        synchronized (this.p) {
            if (i2 == 1) {
                this.p.clear();
            } else {
                this.p.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.p.size() > 6) {
                    this.p.remove(0);
                }
            }
        }
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.r;
        if (i2 != i4) {
            c.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), u.a(i3)));
        }
        if (aa.c(this.m)) {
            b(i2);
        }
        if (i2 == 1) {
            this.m.a(10);
            if (this.r != 0) {
                c.a("try set connected while not connecting.");
            }
            this.r = i2;
            for (ep epVar : this.q) {
                epVar.a(this);
            }
        } else if (i2 == 0) {
            if (this.r != 2) {
                c.a("try set connecting while not disconnected.");
            }
            this.r = i2;
            for (ep epVar2 : this.q) {
                epVar2.b(this);
            }
        } else if (i2 == 2) {
            this.m.a(10);
            int i5 = this.r;
            if (i5 == 0) {
                for (ep epVar3 : this.q) {
                    epVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                for (ep epVar4 : this.q) {
                    epVar4.a(this, i3, exc);
                }
            }
            this.r = i2;
        }
    }

    public void a(ep epVar) {
        if (epVar != null && !this.q.contains(epVar)) {
            this.q.add(epVar);
        }
    }

    public void a(er erVar, fa faVar) {
        Objects.requireNonNull(erVar, "Packet listener is null.");
        this.f.put(erVar, new a(erVar, faVar));
    }

    public abstract void a(fe feVar);

    public abstract void a(q.b bVar);

    public synchronized void a(String str) {
        if (this.r == 0) {
            c.a("setChallenge hash = " + ag.a(str).substring(0, 8));
            this.i = str;
            a(1, 0, null);
        } else {
            c.a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(ef[] efVarArr);

    public synchronized boolean a(long j2) {
        return this.s >= j2;
    }

    public abstract void b(int i2, Exception exc);

    public abstract void b(ef efVar);

    public void b(ep epVar) {
        this.q.remove(epVar);
    }

    public void b(er erVar, fa faVar) {
        Objects.requireNonNull(erVar, "Packet listener is null.");
        this.g.put(erVar, new a(erVar, faVar));
    }

    public abstract void b(boolean z);

    public boolean b() {
        return false;
    }

    public en d() {
        return this.l;
    }

    public String e() {
        return this.l.e();
    }

    public String f() {
        return this.l.b();
    }

    public long g() {
        return this.e;
    }

    protected void h() {
        String str;
        if (this.l.f() && this.h == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.h = new ap(this);
                return;
            }
            try {
                this.h = (ez) cls.getConstructor(em.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public boolean i() {
        return this.r == 0;
    }

    public boolean j() {
        return this.r == 1;
    }

    public int k() {
        return this.b;
    }

    public int l() {
        return this.r;
    }

    public synchronized void m() {
        this.s = System.currentTimeMillis();
    }

    public synchronized boolean n() {
        return System.currentTimeMillis() - this.s < ((long) es.b());
    }

    public synchronized boolean o() {
        boolean z;
        z = true;
        if (System.currentTimeMillis() - this.n >= ((long) (es.b() << 1))) {
            z = false;
        }
        return z;
    }

    public void p() {
        synchronized (this.p) {
            this.p.clear();
        }
    }
}
