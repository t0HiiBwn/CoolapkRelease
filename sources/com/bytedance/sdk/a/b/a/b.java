package com.bytedance.sdk.a.b.a;

/* compiled from: NamedRunnable */
public abstract class b implements Runnable {
    protected final String b;

    protected abstract void b();

    public b(String str, Object... objArr) {
        this.b = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("tt_pangle_thread_" + this.b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
