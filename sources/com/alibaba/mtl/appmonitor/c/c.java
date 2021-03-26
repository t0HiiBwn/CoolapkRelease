package com.alibaba.mtl.appmonitor.c;

import com.alibaba.mtl.appmonitor.c.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ReuseItemPool */
public class c<T extends b> {
    private static AtomicLong c = new AtomicLong(0);
    private static AtomicLong d = new AtomicLong(0);
    private ConcurrentLinkedQueue<T> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private AtomicLong f47a = new AtomicLong(0);
    private Integer b = null;

    /* renamed from: b  reason: collision with other field name */
    private Set<Integer> f48b = new HashSet();

    /* renamed from: b  reason: collision with other field name */
    private AtomicLong f49b = new AtomicLong(0);
    private final int m = 20;

    public T a() {
        c.getAndIncrement();
        this.f47a.getAndIncrement();
        T poll = this.a.poll();
        if (poll != null) {
            this.f48b.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.f49b.getAndIncrement();
            d.getAndIncrement();
        }
        return poll;
    }

    public void a(T t) {
        t.clean();
        if (this.a.size() < 20) {
            synchronized (this.f48b) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.f48b.contains(Integer.valueOf(identityHashCode))) {
                    this.f48b.add(Integer.valueOf(identityHashCode));
                    this.a.offer(t);
                }
            }
        }
    }
}
