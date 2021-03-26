package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.bytedance.sdk.openadsdk.j.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PiecemealSerialExecutor */
public class j implements Executor {
    private static volatile j a;
    private ExecutorService b = e.a();

    private j() {
    }

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
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
