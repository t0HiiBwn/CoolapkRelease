package com.ali.auth.third.core.task;

import android.os.Looper;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Coordinator {
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    protected static final String TAG = "Coordinator";
    static a a;
    private static final ThreadFactory b;
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;

    public static class a extends ThreadPoolExecutor {
        public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
            allowCoreThreadTimeOut(true);
        }

        public void a(Runnable runnable, int i) {
            if (runnable instanceof e) {
                super.execute(runnable);
                return;
            }
            e eVar = new e(runnable);
            if (i < 1) {
                i = 1;
            }
            eVar.b = i;
            super.execute(eVar);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            StringBuilder sb;
            super.beforeExecute(thread, runnable);
            if (runnable instanceof e) {
                sb = new StringBuilder();
                runnable = ((e) runnable).a;
            } else {
                sb = new StringBuilder();
            }
            sb.append(runnable);
            sb.append("");
            thread.setName(sb.toString());
        }
    }

    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            char c;
            Object[] array = Coordinator.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Object obj : array) {
                if (obj.getClass().isAnonymousClass()) {
                    sb.append(Coordinator.getOuterClass(obj));
                    c = '~';
                } else {
                    sb.append(obj);
                    c = '>';
                }
                sb.append(c);
                sb.append(' ');
            }
            sb.append(']');
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    static class c<Runnable> implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof e) || !(runnable2 instanceof e)) {
                return 0;
            }
            Runnable runnable3 = runnable;
            Runnable runnable4 = runnable2;
            if (runnable3.a() > runnable4.a()) {
                return 1;
            }
            return runnable3.a() < runnable4.a() ? -1 : 0;
        }
    }

    public interface d {
        int a();
    }

    static class e implements d, Runnable {
        final Runnable a;
        int b = 30;

        public e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.ali.auth.third.core.task.Coordinator.d
        public int a() {
            Runnable runnable = this.a;
            return runnable instanceof d ? ((d) runnable).a() : this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Coordinator.runWithTiming(this.a);
        }
    }

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new c());
        mPoolWorkQueue = priorityBlockingQueue;
        AnonymousClass1 r7 = new ThreadFactory() {
            /* class com.ali.auth.third.core.task.Coordinator.AnonymousClass1 */

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "login#" + runnable.getClass().getName());
            }
        };
        b = r7;
        a = new a(8, 128, 10, TimeUnit.SECONDS, priorityBlockingQueue, r7, new b());
    }

    public static void execute(Runnable runnable) {
        a.a(runnable, 30);
    }

    public static void execute(Runnable runnable, int i) {
        a.a(runnable, i);
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        return a;
    }

    protected static Object getOuterClass(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return obj;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return obj;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return obj;
        }
    }

    protected static void runWithTiming(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Process.setThreadPriority(10);
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
