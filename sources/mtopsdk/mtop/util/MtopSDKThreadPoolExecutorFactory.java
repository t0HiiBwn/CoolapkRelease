package mtopsdk.mtop.util;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

public class MtopSDKThreadPoolExecutorFactory {
    private static int a = 10;
    private static volatile ThreadPoolExecutor b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ExecutorService[] e;

    static class MtopSDKThreadFactory implements ThreadFactory {
        int a = 10;
        private final AtomicInteger b = new AtomicInteger();
        private String c = "";

        public MtopSDKThreadFactory(int i) {
            this.a = i;
        }

        public MtopSDKThreadFactory(int i, String str) {
            this.a = i;
            this.c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK ");
            if (StringUtils.isNotBlank(this.c)) {
                sb.append(this.c);
                sb.append(" ");
            } else {
                sb.append("DefaultPool ");
            }
            sb.append("Thread:");
            sb.append(this.b.getAndIncrement());
            return new Thread(runnable, sb.toString()) {
                /* class mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory.MtopSDKThreadFactory.AnonymousClass1 */

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Process.setThreadPriority(MtopSDKThreadFactory.this.a);
                    } catch (Throwable th) {
                        TBSdkLog.e("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[run]Thread set thread priority error ---" + th.toString());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        TBSdkLog.e("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[run]Thread run error ---" + th2.toString());
                    }
                }
            };
        }
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        if (b == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (b == null) {
                    b = createExecutor(3, 3, 60, 128, new MtopSDKThreadFactory(a));
                }
            }
        }
        return b;
    }

    public static ThreadPoolExecutor getRequestThreadPoolExecutor() {
        if (c == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (c == null) {
                    c = createExecutor(4, 4, 60, 0, new MtopSDKThreadFactory(a, "RequestPool"));
                }
            }
        }
        return c;
    }

    public static ExecutorService[] getCallbackExecutorServices() {
        if (RemoteConfig.getInstance().enableNewExecutor) {
            if (d == null) {
                synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                    if (d == null) {
                        d = createExecutor(2, 2, 20, 0, new MtopSDKThreadFactory(a, "CallbackPool"));
                    }
                }
            }
            return new ExecutorService[]{d};
        }
        if (e == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (e == null) {
                    ExecutorService[] executorServiceArr = new ExecutorService[2];
                    for (int i = 0; i < 2; i++) {
                        int i2 = a;
                        executorServiceArr[i] = createExecutor(1, 1, 60, 0, new MtopSDKThreadFactory(i2, "CallbackPool" + i));
                    }
                    e = executorServiceArr;
                }
            }
        }
        return e;
    }

    public static void setDefaultThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            b = threadPoolExecutor;
        }
    }

    public static void setCallbackExecutorServices(ExecutorService[] executorServiceArr) {
        if (executorServiceArr != null && executorServiceArr.length > 0) {
            if (RemoteConfig.getInstance().enableNewExecutor) {
                d = (ThreadPoolExecutor) executorServiceArr[0];
            } else {
                e = executorServiceArr;
            }
        }
    }

    public static void setRequestThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            c = threadPoolExecutor;
        }
    }

    public static Future<?> submit(Runnable runnable) {
        try {
            return getDefaultThreadPoolExecutor().submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[submit]submit runnable to Mtop Default ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static Future<?> submitCallbackTask(int i, Runnable runnable) {
        try {
            if (RemoteConfig.getInstance().enableNewExecutor) {
                return getCallbackExecutorServices()[0].submit(runnable);
            }
            ExecutorService[] callbackExecutorServices = getCallbackExecutorServices();
            return callbackExecutorServices[Math.abs(i % callbackExecutorServices.length)].submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[submitCallbackTask]submit runnable to Mtop Callback ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static Future<?> submitRequestTask(Runnable runnable) {
        try {
            return getRequestThreadPoolExecutor().submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.MtopSDKThreadPoolExecutorFactory", "[submitRequestTask]submit runnable to Mtop Request ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static ThreadPoolExecutor createExecutor(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i4 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i4);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, (long) i3, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        if (i3 > 0) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor;
    }
}
