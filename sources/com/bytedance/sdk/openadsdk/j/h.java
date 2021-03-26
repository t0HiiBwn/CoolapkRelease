package com.bytedance.sdk.openadsdk.j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TTThreadFactory */
public class h implements ThreadFactory {
    private final ThreadGroup a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final String c;
    private final int d;

    public h(int i, String str) {
        this.d = i;
        this.a = new ThreadGroup("tt_pangle_group_" + str);
        this.c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.a;
        Thread thread = new Thread(threadGroup, runnable, this.c + "_" + this.b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.d == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
