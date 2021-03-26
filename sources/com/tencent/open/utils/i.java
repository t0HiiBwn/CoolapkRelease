package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class i {
    public static final Executor a = c();
    private static Object b = new Object();
    private static Handler c;
    private static HandlerThread d;

    private static Executor c() {
        Executor executor;
        if (Build.VERSION.SDK_INT >= 11) {
            executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                executor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (executor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executor).setCorePoolSize(3);
        }
        return executor;
    }

    public static Handler a() {
        if (c == null) {
            synchronized (i.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }

    public static Executor b() {
        return new a();
    }

    /* compiled from: ProGuard */
    private static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        private a() {
            this.a = new LinkedList();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                /* class com.tencent.open.utils.i.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                i.a.execute(this.b);
            }
        }
    }
}
