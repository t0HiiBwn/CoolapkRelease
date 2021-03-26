package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.h;
import com.huawei.hms.framework.network.grs.local.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class c {
    private static final String a = "c";
    private static ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
    private GrsBaseInfo c;
    private boolean d;
    private final Object e;
    private Context f;
    private h g;
    private a h;
    private com.huawei.hms.framework.network.grs.a.c i;
    private a j;
    private Future<Boolean> k;

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.d = false;
        Object obj = new Object();
        this.e = obj;
        this.f = context.getApplicationContext();
        this.g = new h();
        this.i = new com.huawei.hms.framework.network.grs.a.c(this.f);
        this.h = new a(this.i, this.g);
        a(grsBaseInfo);
        this.j = new a(this.c, this.h, this.g);
        if (!this.d) {
            synchronized (obj) {
                if (!this.d) {
                    final GrsBaseInfo grsBaseInfo2 = this.c;
                    final Context context2 = this.f;
                    this.k = b.submit(new Callable<Boolean>() {
                        /* class com.huawei.hms.framework.network.grs.c.AnonymousClass1 */

                        /* renamed from: a */
                        public Boolean call() {
                            new b(context2).a(grsBaseInfo2);
                            c cVar = c.this;
                            cVar.a(cVar.i.c());
                            c.this.h.a(grsBaseInfo2, context2);
                            return Boolean.valueOf(c.this.d = true);
                        }
                    });
                }
            }
        }
    }

    c(GrsBaseInfo grsBaseInfo) {
        this.d = false;
        this.e = new Object();
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.c = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(a, "GrsClient catch CloneNotSupportedException", e2);
            this.c = grsBaseInfo.copy();
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(a, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String a2 = this.i.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(a2);
                    } catch (NumberFormatException e2) {
                        Logger.w(a, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                if (!a(j2)) {
                    Logger.i(a, "init interface auto clear some invalid sp's data.");
                    this.i.a(str.substring(0, str.length() - 4));
                    this.i.a(str);
                }
            }
        }
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean c() {
        try {
            Future<Boolean> future = this.k;
            if (future != null) {
                return future.get(10, TimeUnit.SECONDS).booleanValue();
            }
            return false;
        } catch (CancellationException unused) {
            Logger.i(a, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            Logger.w(a, "init compute task failed.", e2);
            return false;
        } catch (InterruptedException e3) {
            Logger.w(a, "init compute task interrupted.", e3);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(a, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            Logger.w(a, "init compute task occur unknown Exception", e4);
            return false;
        }
    }

    String a(String str, String str2) {
        if (this.c == null || str == null || str2 == null) {
            Logger.w(a, "invalid para!");
            return null;
        } else if (c()) {
            return this.j.a(str, str2, this.f);
        } else {
            return null;
        }
    }

    Map<String, String> a(String str) {
        if (this.c != null && str != null) {
            return c() ? this.j.a(str, this.f) : new HashMap();
        }
        Logger.w(a, "invalid para!");
        return new HashMap();
    }

    void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(a, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.c == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (c()) {
            this.j.a(str, iQueryUrlsCallBack, this.f);
        }
    }

    void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(a, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.c == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (c()) {
            this.j.a(str, str2, iQueryUrlCallBack, this.f);
        }
    }

    boolean a() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!c() || (grsBaseInfo = this.c) == null || (context = this.f) == null) {
            return false;
        }
        this.h.b(grsBaseInfo, context);
        return true;
    }

    boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof c)) {
            return false;
        }
        return this.c.compare(((c) obj).c);
    }

    void b() {
        if (c()) {
            String grsParasKey = this.c.getGrsParasKey(false, true, this.f);
            this.i.a(grsParasKey);
            com.huawei.hms.framework.network.grs.a.c cVar = this.i;
            cVar.a(grsParasKey + "time");
            this.g.a(grsParasKey);
        }
    }
}
