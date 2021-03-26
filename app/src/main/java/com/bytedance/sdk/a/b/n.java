package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher */
public final class n {
    private int a = 64;
    private int b = 5;
    private Runnable c;
    private ExecutorService d;
    private final Deque<x.a> e = new ArrayDeque();
    private final Deque<x.a> f = new ArrayDeque();
    private final Deque<x> g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private void c() {
        if (this.f.size() < this.a && !this.e.isEmpty()) {
            Iterator<x.a> it2 = this.e.iterator();
            while (it2.hasNext()) {
                x.a next = it2.next();
                if (b(next) < this.b) {
                    it2.remove();
                    this.f.add(next);
                    a().execute(next);
                }
                if (this.f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    private int b(x.a aVar) {
        int i = 0;
        for (x.a aVar2 : this.f) {
            if (aVar2.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    synchronized void a(x xVar) {
        this.g.add(xVar);
    }

    void a(x.a aVar) {
        a(this.f, aVar, true);
    }

    void b(x xVar) {
        a(this.g, xVar, false);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b2;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    c();
                }
                b2 = b();
                runnable = this.c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b2 == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized int b() {
        return this.f.size() + this.g.size();
    }
}
