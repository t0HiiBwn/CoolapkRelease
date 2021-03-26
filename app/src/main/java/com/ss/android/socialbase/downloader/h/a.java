package com.ss.android.socialbase.downloader.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory */
public class a implements ThreadFactory {
    private final String a;
    private final AtomicInteger b;
    private final boolean c;

    public a(String str) {
        this(str, false);
    }

    public a(String str, boolean z) {
        this.b = new AtomicInteger();
        this.a = str;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.b.incrementAndGet();
        Thread thread = new Thread(runnable, this.a + "-" + incrementAndGet);
        if (!this.c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }
}
