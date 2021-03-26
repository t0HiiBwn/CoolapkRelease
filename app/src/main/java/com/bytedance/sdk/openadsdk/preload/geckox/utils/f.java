package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.bytedance.sdk.openadsdk.j.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: IOSerialExecutor */
public class f implements Executor {
    private static volatile f a;
    private ExecutorService b = e.a();

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
