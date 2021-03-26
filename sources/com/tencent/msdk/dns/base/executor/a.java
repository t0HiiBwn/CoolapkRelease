package com.tencent.msdk.dns.base.executor;

import java.util.concurrent.Executor;

/* compiled from: IScheduledExecutor */
public interface a extends Executor {
    void a(Runnable runnable);

    void a(Runnable runnable, long j);
}
