package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
public final class u {
    private static u a;
    private final p b;
    private final Context c;
    private Map<Integer, Long> d = new HashMap();
    private long e;
    private long f;
    private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private final Object i = new Object();
    private int j = 0;

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.j - 1;
        uVar.j = i2;
        return i2;
    }

    private u(Context context) {
        this.c = context;
        this.b = p.a();
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (a == null) {
                a = new u(context);
            }
            uVar = a;
        }
        return uVar;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = a;
        }
        return uVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public final void a(int i2, am amVar, String str, String str2, t tVar, long j2, boolean z) {
        Throwable th;
        try {
            try {
                a(new v(this.c, i2, amVar.g, a.a((Object) amVar), str, str2, tVar, true, z), true, true, j2);
            } catch (Throwable th2) {
                th = th2;
                if (x.a(th)) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (x.a(th)) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public final void a(int i2, am amVar, String str, String str2, t tVar, boolean z) {
        Throwable th;
        try {
            try {
                a(new v(this.c, i2, amVar.g, a.a((Object) amVar), str, str2, tVar, 0, 0, false, null), z, false, 0);
            } catch (Throwable th2) {
                th = th2;
                if (x.a(th)) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (x.a(th)) {
            }
        }
    }

    public final long a(boolean z) {
        long j2;
        long b2 = z.b();
        int i2 = z ? 5 : 3;
        List<r> a2 = this.b.a(i2);
        if (a2 == null || a2.size() <= 0) {
            j2 = z ? this.f : this.e;
        } else {
            j2 = 0;
            try {
                r rVar = a2.get(0);
                if (rVar.e >= b2) {
                    j2 = z.b(rVar.g);
                    if (i2 == 3) {
                        this.e = j2;
                    } else {
                        this.f = j2;
                    }
                    a2.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            if (a2.size() > 0) {
                this.b.a(a2);
            }
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    protected final synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        r rVar = new r();
        rVar.b = i2;
        rVar.e = z.b();
        rVar.c = "";
        rVar.d = "";
        rVar.g = z.c(j2);
        this.b.b(i2);
        this.b.a(rVar);
        if (z) {
            this.f = j2;
        } else {
            this.e = j2;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public final synchronized void a(int i2, long j2) {
        if (i2 >= 0) {
            this.d.put(Integer.valueOf(i2), Long.valueOf(j2));
            r rVar = new r();
            rVar.b = i2;
            rVar.e = j2;
            rVar.c = "";
            rVar.d = "";
            rVar.g = new byte[0];
            this.b.b(i2);
            this.b.a(rVar);
            x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), z.a(j2));
            return;
        }
        x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
    }

    public final synchronized long a(int i2) {
        long j2 = 0;
        if (i2 >= 0) {
            Long l2 = this.d.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
            List<r> a2 = this.b.a(i2);
            if (a2 != null && a2.size() > 0) {
                if (a2.size() > 1) {
                    for (r rVar : a2) {
                        if (rVar.e > j2) {
                            j2 = rVar.e;
                        }
                    }
                    this.b.b(i2);
                } else {
                    try {
                        j2 = a2.get(0).e;
                    } catch (Throwable th) {
                        x.a(th);
                    }
                }
            }
        } else {
            x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return j2;
    }

    public final boolean b(int i2) {
        if (b.c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i2);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    private void c(int i2) {
        int size;
        final int size2;
        w a2 = w.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.i) {
            x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            size = this.g.size();
            size2 = this.h.size();
            if (size == 0 && size2 == 0) {
                x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a2 == null || !a2.c()) {
                size2 = 0;
            }
            for (int i3 = 0; i3 < size; i3++) {
                Runnable peek = this.g.peek();
                if (peek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(peek);
                    this.g.poll();
                } catch (Throwable th) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
            }
            for (int i4 = 0; i4 < size2; i4++) {
                Runnable peek2 = this.h.peek();
                if (peek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(peek2);
                    this.h.poll();
                } catch (Throwable th2) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
        }
        if (size > 0) {
            x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i5 = 0; i5 < size; i5++) {
            final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
            if (runnable == null) {
                break;
            }
            synchronized (this.i) {
                if (this.j < 2 || a2 == null) {
                    x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (z.a(new Runnable() {
                        /* class com.tencent.bugly.proguard.u.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            runnable.run();
                            synchronized (u.this.i) {
                                u.b(u.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.i) {
                            this.j++;
                        }
                    } else {
                        x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                        a(runnable, true);
                    }
                } else {
                    a2.a(runnable);
                }
            }
        }
        if (size2 > 0) {
            x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        if (a2 != null) {
            a2.a(new Runnable(this) {
                /* class com.tencent.bugly.proguard.u.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    Runnable runnable;
                    for (int i = 0; i < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i++) {
                        runnable.run();
                    }
                }
            });
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.i) {
                if (z) {
                    this.g.put(runnable);
                } else {
                    this.h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
        } else if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        } else {
            x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Thread a2 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
            if (a2 == null) {
                x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
                a(runnable, true);
                return;
            }
            try {
                a2.join(j2);
            } catch (Throwable th) {
                x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
                a(runnable, true);
                c(0);
            }
        }
    }
}
