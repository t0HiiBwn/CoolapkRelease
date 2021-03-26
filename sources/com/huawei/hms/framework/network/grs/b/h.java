package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b.b;
import com.huawei.hms.framework.network.grs.c.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class h {
    private ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private Map<String, b> b = new ConcurrentHashMap(16);
    private final Object c = new Object();
    private a d;

    /* access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar == null) {
            return;
        }
        if (dVar == null) {
            Logger.v("RequestController", "GrsResponse is null");
            bVar.a();
            return;
        }
        Logger.v("RequestController", "GrsResponse is not null");
        bVar.a(dVar);
    }

    public d a(final GrsBaseInfo grsBaseInfo, final Context context, final String str) {
        Future<d> future;
        String str2;
        String str3;
        Throwable e;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
        synchronized (this.c) {
            d.a a2 = d.a(grsParasKey);
            b bVar = this.b.get(grsParasKey);
            if (bVar != null) {
                if (bVar.b()) {
                    future = bVar.a();
                    return future.get();
                }
            }
            if (a2 != null) {
                if (a2.a()) {
                    return null;
                }
            }
            Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
            future = this.a.submit(new Callable<d>() {
                /* class com.huawei.hms.framework.network.grs.b.h.AnonymousClass1 */

                /* renamed from: a */
                public d call() {
                    return new c(grsBaseInfo, context, h.this.d).a(h.this.a, str);
                }
            });
            this.b.put(grsParasKey, new b(future));
            try {
                return future.get();
            } catch (CancellationException e2) {
                e = e2;
                str3 = "RequestController";
                str2 = "when check result, find CancellationException, check others";
                Logger.w(str3, str2, e);
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str3 = "RequestController";
                str2 = "when check result, find ExecutionException, check others";
                Logger.w(str3, str2, e);
                return null;
            } catch (InterruptedException e4) {
                e = e4;
                str3 = "RequestController";
                str2 = "when check result, find InterruptedException, check others";
                Logger.w(str3, str2, e);
                return null;
            }
        }
    }

    public void a(final GrsBaseInfo grsBaseInfo, final Context context, final com.huawei.hms.framework.network.grs.b bVar, final String str) {
        this.a.submit(new Runnable() {
            /* class com.huawei.hms.framework.network.grs.b.h.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                hVar.a(hVar.a(grsBaseInfo, context, str), bVar);
            }
        });
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(String str) {
        synchronized (this.c) {
            this.b.remove(str);
        }
    }
}
