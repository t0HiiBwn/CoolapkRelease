package com.bytedance.tea.crash.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LooperTrace */
public class g {
    private static final AtomicReference<Long> a = new AtomicReference<>(0L);

    public static void a(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (((long) i) < 5) {
                AtomicReference<Long> atomicReference = a;
                long longValue = atomicReference.get().longValue();
                if (!atomicReference.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
