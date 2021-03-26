package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.aw;
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

public abstract class fi {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f458a;

    /* renamed from: a  reason: collision with other field name */
    protected int f459a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f460a = -1;

    /* renamed from: a  reason: collision with other field name */
    protected fj f461a;

    /* renamed from: a  reason: collision with other field name */
    protected fu f462a = null;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f463a;

    /* renamed from: a  reason: collision with other field name */
    protected String f464a = "";

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fl> f465a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f466a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fn, a> f467a = new ConcurrentHashMap();
    protected final int b = a.getAndIncrement();

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f468b = 0;

    /* renamed from: b  reason: collision with other field name */
    protected String f469b = "";

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fn, a> f470b = new ConcurrentHashMap();
    private int c = 2;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f471c = 0;
    protected long d = 0;
    private long e = 0;

    public static class a {
        private fn a;

        /* renamed from: a  reason: collision with other field name */
        private fv f472a;

        public a(fn fnVar, fv fvVar) {
            this.a = fnVar;
            this.f472a = fvVar;
        }

        public void a(fb fbVar) {
            this.a.a(fbVar);
        }

        public void a(fz fzVar) {
            fv fvVar = this.f472a;
            if (fvVar == null || fvVar.mo148a(fzVar)) {
                this.a.mo148a(fzVar);
            }
        }
    }

    static {
        f458a = false;
        try {
            f458a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fo.m340a();
    }

    protected fi(XMPushService xMPushService, fj fjVar) {
        this.f461a = fjVar;
        this.f463a = xMPushService;
        m334b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m329a(int i) {
        synchronized (this.f466a) {
            if (i == 1) {
                this.f466a.clear();
            } else {
                this.f466a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f466a.size() > 6) {
                    this.f466a.remove(0);
                }
            }
        }
    }

    /* renamed from: a */
    public int mo328a() {
        return this.f459a;
    }

    public long a() {
        return this.f471c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fj m330a() {
        return this.f461a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m331a() {
        return this.f461a.c();
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            b.m41a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), aw.a(i2)));
        }
        if (bc.b(this.f463a)) {
            m329a(i);
        }
        if (i == 1) {
            this.f463a.a(10);
            if (this.c != 0) {
                b.m41a("try set connected while not connecting.");
            }
            this.c = i;
            for (fl flVar : this.f465a) {
                flVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                b.m41a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fl flVar2 : this.f465a) {
                flVar2.b(this);
            }
        } else if (i == 2) {
            this.f463a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fl flVar3 : this.f465a) {
                    flVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fl flVar4 : this.f465a) {
                    flVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fl flVar) {
        if (flVar != null && !this.f465a.contains(flVar)) {
            this.f465a.add(flVar);
        }
    }

    public void a(fn fnVar, fv fvVar) {
        Objects.requireNonNull(fnVar, "Packet listener is null.");
        this.f467a.put(fnVar, new a(fnVar, fvVar));
    }

    public abstract void a(fz fzVar);

    public abstract void a(as.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            b.m41a("setChallenge hash = " + bh.a(str).substring(0, 8));
            this.f464a = str;
            a(1, 0, null);
        } else {
            b.m41a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fb[] fbVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m332a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m333b() {
        return this.f461a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m334b() {
        String str;
        if (this.f461a.m338a() && this.f462a == null) {
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
                this.f462a = new bq(this);
                return;
            }
            try {
                this.f462a = (fu) cls.getConstructor(fi.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fb fbVar);

    public void b(fl flVar) {
        this.f465a.remove(flVar);
    }

    public void b(fn fnVar, fv fvVar) {
        Objects.requireNonNull(fnVar, "Packet listener is null.");
        this.f470b.put(fnVar, new a(fnVar, fvVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m335b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m336c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f466a) {
            this.f466a.clear();
        }
    }
}
