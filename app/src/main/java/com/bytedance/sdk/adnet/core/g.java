package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ExecutorDelivery */
class g implements c {
    private final Executor a;
    private final Executor b = Executors.newCachedThreadPool();
    private com.bytedance.sdk.adnet.c.c c = f.a();

    public g(final Handler handler) {
        this.a = new Executor() {
            /* class com.bytedance.sdk.adnet.core.g.AnonymousClass1 */

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private Executor a(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.a : this.b;
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        a(request, mVar, null);
        com.bytedance.sdk.adnet.c.c cVar = this.c;
        if (cVar != null) {
            cVar.a(request, mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        a(request).execute(new a(request, mVar, runnable));
        com.bytedance.sdk.adnet.c.c cVar = this.c;
        if (cVar != null) {
            cVar.a(request, mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        a(request).execute(new a(request, m.a(vAdError), null));
        com.bytedance.sdk.adnet.c.c cVar = this.c;
        if (cVar != null) {
            cVar.a(request, vAdError);
        }
    }

    /* compiled from: ExecutorDelivery */
    private static class a implements Runnable {
        private final Request a;
        private final m b;
        private final Runnable c;

        public a(Request request, m mVar, Runnable runnable) {
            this.a = request;
            this.b = mVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.isCanceled()) {
                this.a.a("canceled-at-delivery");
                return;
            }
            this.b.g = this.a.getExtra();
            this.b.a(SystemClock.elapsedRealtime() - this.a.getStartTime());
            this.b.b(this.a.getNetDuration());
            if (this.b.a()) {
                try {
                    this.a.a(this.b);
                } catch (Throwable unused) {
                }
            } else {
                this.a.deliverError(this.b);
            }
            if (this.b.d) {
                this.a.addMarker("intermediate-response");
            } else {
                this.a.a("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
