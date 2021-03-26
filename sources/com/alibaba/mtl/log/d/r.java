package com.alibaba.mtl.log.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TaskExecutor */
public class r {
    private static int G = 1;
    private static int H = 2;
    private static int I = 10;
    private static int J = 60;
    public static r a;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f66a;
    private static final AtomicInteger f = new AtomicInteger();
    private HandlerThread b;
    private Handler mHandler = new Handler(this.b.getLooper()) {
        /* class com.alibaba.mtl.log.d.r.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (message.obj != null && (message.obj instanceof Runnable)) {
                    r.m18a().submit((Runnable) message.obj);
                }
            } catch (Throwable unused) {
            }
        }
    };

    /* compiled from: TaskExecutor */
    static class a implements ThreadFactory {
        private int priority;

        public a(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = r.f.getAndIncrement();
            Thread thread = new Thread(runnable, "AppMonitor:" + andIncrement);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    private static ThreadPoolExecutor a(int i, int i2, int i3, int i4, int i5) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i5 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i5);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        return new ThreadPoolExecutor(i2, i3, (long) i4, TimeUnit.SECONDS, linkedBlockingQueue, new a(i), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    /* access modifiers changed from: private */
    /* renamed from: a  reason: collision with other method in class */
    public static synchronized ThreadPoolExecutor m18a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (r.class) {
            if (f66a == null) {
                f66a = a(G, H, I, J, 500);
            }
            threadPoolExecutor = f66a;
        }
        return threadPoolExecutor;
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r();
            }
            rVar = a;
        }
        return rVar;
    }

    private r() {
        HandlerThread handlerThread = new HandlerThread("AppMonitor");
        this.b = handlerThread;
        handlerThread.start();
    }

    public final void a(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.mHandler, i);
            obtain.obj = runnable;
            this.mHandler.sendMessageDelayed(obtain, j);
        } catch (Exception e) {
            b.m9a((Throwable) e);
        }
    }

    public final void f(int i) {
        this.mHandler.removeMessages(i);
    }

    public final boolean b(int i) {
        return this.mHandler.hasMessages(i);
    }

    public void b(Runnable runnable) {
        try {
            m18a().submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
