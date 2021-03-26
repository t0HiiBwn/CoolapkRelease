package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.preload.b.a.a;
import com.bytedance.sdk.openadsdk.preload.b.i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: ParallelInterceptor */
public class g<T> extends d<List<T>, T> {
    private Executor d;

    /* renamed from: a */
    public final Object a_(final b<T> bVar, List<T> list) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        final CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (final T t : list) {
            this.d.execute(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.preload.b.g.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        copyOnWriteArrayList.add(bVar.a((b) t));
                    } catch (i.a e2) {
                        Throwable cause = e2.getCause();
                        copyOnWriteArrayList2.add(cause);
                        g.this.d(cause);
                    } catch (Throwable th) {
                        countDownLatch.countDown();
                        throw th;
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        if (copyOnWriteArrayList2.isEmpty()) {
            return copyOnWriteArrayList;
        }
        throw new a(copyOnWriteArrayList2);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null) {
            this.d = e.a();
        } else if (objArr.length != 1) {
            throw new IllegalArgumentException("ParallelInterceptor only need one param");
        } else if (objArr[0] instanceof Executor) {
            this.d = (Executor) objArr[0];
        } else {
            throw new IllegalArgumentException("ParallelInterceptor args must be instance of Executor");
        }
    }
}
