package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.base.executor.DnsExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: CountDownManager */
public final class b {
    static c a() {
        return new c();
    }

    /* access modifiers changed from: private */
    public static CountDownLatch b(c cVar) {
        CountDownLatch countDownLatch = cVar.b;
        if (countDownLatch == null) {
            int i = 0;
            for (RunnableC0148b bVar : cVar.a) {
                if (!bVar.b) {
                    i++;
                }
            }
            countDownLatch = new CountDownLatch(i);
        }
        for (RunnableC0148b bVar2 : cVar.a) {
            DnsExecutors.b.execute(new a(bVar2, countDownLatch));
        }
        cVar.a.clear();
        return countDownLatch;
    }

    /* compiled from: CountDownManager */
    public static class c {
        private List<RunnableC0148b> a = Collections.emptyList();
        private CountDownLatch b = null;

        public c a(Runnable runnable) {
            return a(runnable, false);
        }

        public synchronized c a(Runnable runnable, boolean z) {
            if (runnable != null) {
                if (Collections.emptyList() == this.a) {
                    this.a = new ArrayList();
                }
                this.a.add(new RunnableC0148b(runnable, z));
            } else {
                throw new IllegalArgumentException("task".concat(" can not be null"));
            }
            return this;
        }

        public CountDownLatch a() {
            CountDownLatch b2 = b.b(this);
            this.b = b2;
            return b2;
        }
    }

    /* renamed from: com.tencent.msdk.dns.core.b$b  reason: collision with other inner class name */
    /* compiled from: CountDownManager */
    private static class RunnableC0148b implements Runnable {
        private final Runnable a;
        private final boolean b;

        public RunnableC0148b(Runnable runnable, boolean z) {
            this.a = runnable;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    /* compiled from: CountDownManager */
    private static class a implements Runnable {
        private final RunnableC0148b a;
        private final CountDownLatch b;

        a(RunnableC0148b bVar, CountDownLatch countDownLatch) {
            this.a = bVar;
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception unused) {
            }
            if (!this.a.b) {
                this.b.countDown();
            }
        }
    }
}
