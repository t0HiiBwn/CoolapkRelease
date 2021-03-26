package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.b.d;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool */
public final class j {
    static final /* synthetic */ boolean c = true;
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));
    final d a;
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<com.bytedance.sdk.a.b.a.b.c> h;

    public j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() {
            /* class com.bytedance.sdk.a.b.j.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a2 = j.this.a(System.nanoTime());
                    if (a2 != -1) {
                        if (a2 > 0) {
                            long j = a2 / 1000000;
                            long j2 = a2 - (1000000 * j);
                            synchronized (j.this) {
                                try {
                                    j.this.wait(j, (int) j2);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.a = new d();
        this.e = i;
        this.f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    com.bytedance.sdk.a.b.a.b.c a(a aVar, g gVar, ac acVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.h) {
                if (cVar.a(aVar, acVar)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    Socket a(a aVar, g gVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.h) {
                if (cVar.a(aVar, null) && cVar.d() && cVar != gVar.b()) {
                    return gVar.a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    void a(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (c || Thread.holdsLock(this)) {
            if (!this.b) {
                this.b = true;
                d.execute(this.g);
            }
            this.h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    boolean b(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.a || this.e == 0) {
            this.h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    long a(long j) {
        synchronized (this) {
            com.bytedance.sdk.a.b.a.b.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (com.bytedance.sdk.a.b.a.b.c cVar2 : this.h) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f;
            if (j2 < j4) {
                if (i <= this.e) {
                    if (i > 0) {
                        return j4 - j2;
                    } else if (i2 > 0) {
                        return j4;
                    } else {
                        this.b = false;
                        return -1;
                    }
                }
            }
            this.h.remove(cVar);
            c.a(cVar.b());
            return 0;
        }
    }

    private int a(com.bytedance.sdk.a.b.a.b.c cVar, long j) {
        List<Reference<g>> list = cVar.d;
        int i = 0;
        while (i < list.size()) {
            Reference<g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                e.b().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).a);
                list.remove(i);
                cVar.a = true;
                if (list.isEmpty()) {
                    cVar.e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
