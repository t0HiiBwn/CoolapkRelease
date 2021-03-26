package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.d;
import com.huawei.hms.framework.network.grs.local.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

public class c implements a {
    private static final String a = "c";
    private GrsBaseInfo b;
    private Context c;
    private a d;
    private d e;
    private ArrayList<Future<d>> f = new ArrayList<>();
    private ArrayList<d> g = new ArrayList<>();
    private JSONArray h = new JSONArray();
    private ArrayList<String> i = new ArrayList<>();
    private ArrayList<String> j = new ArrayList<>();
    private com.huawei.hms.framework.network.grs.b.b.c k;
    private long l = 1;

    public c(GrsBaseInfo grsBaseInfo, Context context, a aVar) {
        this.b = grsBaseInfo;
        this.c = context;
        this.d = aVar;
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088 A[LOOP:0: B:1:0x0003->B:34:0x0088, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080 A[SYNTHETIC] */
    private d a(ExecutorService executorService, ArrayList<String> arrayList, String str) {
        d dVar;
        ExecutionException e2;
        InterruptedException e3;
        d dVar2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            String str2 = arrayList.get(i2);
            boolean z = true;
            if (!TextUtils.isEmpty(str2)) {
                Future<d> submit = executorService.submit(new b(str2, i2, this, this.c, str).f());
                this.f.add(submit);
                try {
                    dVar = submit.get(this.l, TimeUnit.SECONDS);
                    if (dVar != null) {
                        try {
                            if (dVar.h()) {
                                Logger.i(a, "grs request return body is not null and is OK.");
                                dVar2 = dVar;
                                if (z) {
                                    Logger.v(a, "needBreak is true so need break current circulation");
                                    break;
                                }
                                i2++;
                            }
                        } catch (CancellationException unused) {
                            dVar2 = dVar;
                            Logger.i(a, "{requestServer} the computation was cancelled");
                            if (z) {
                            }
                        } catch (ExecutionException e4) {
                            e2 = e4;
                            Logger.w(a, "the computation threw an ExecutionException", e2);
                            dVar2 = dVar;
                            z = false;
                            if (z) {
                            }
                        } catch (InterruptedException e5) {
                            e3 = e5;
                            Logger.w(a, "the current thread was interrupted while waiting", e3);
                            dVar2 = dVar;
                            if (z) {
                            }
                        } catch (TimeoutException unused2) {
                            dVar2 = dVar;
                            Logger.w(a, "the wait timed out");
                            z = false;
                            if (z) {
                            }
                        }
                    }
                    z = false;
                } catch (CancellationException unused3) {
                    Logger.i(a, "{requestServer} the computation was cancelled");
                    if (z) {
                    }
                } catch (ExecutionException e6) {
                    dVar = dVar2;
                    e2 = e6;
                    Logger.w(a, "the computation threw an ExecutionException", e2);
                    dVar2 = dVar;
                    z = false;
                    if (z) {
                    }
                } catch (InterruptedException e7) {
                    dVar = dVar2;
                    e3 = e7;
                    Logger.w(a, "the current thread was interrupted while waiting", e3);
                    dVar2 = dVar;
                    if (z) {
                    }
                } catch (TimeoutException unused4) {
                    Logger.w(a, "the wait timed out");
                    z = false;
                    if (z) {
                    }
                }
                dVar2 = dVar;
                if (z) {
                }
            }
            z = false;
            if (z) {
            }
        }
        return b(dVar2);
    }

    private d b(d dVar) {
        String str;
        String str2;
        Throwable e2;
        int size = this.f.size();
        for (int i2 = 0; i2 < size && (dVar == null || !dVar.h()); i2++) {
            try {
                dVar = this.f.get(i2).get(40000, TimeUnit.MILLISECONDS);
            } catch (CancellationException unused) {
                Logger.i(a, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e2 = e3;
                str2 = a;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str2, str, e2);
            } catch (InterruptedException e4) {
                e2 = e4;
                str2 = a;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str2, str, e2);
            } catch (TimeoutException unused2) {
                Logger.w(a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!this.f.get(i2).isCancelled()) {
                    this.f.get(i2).cancel(true);
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    public d b(ExecutorService executorService, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a2 = a(executorService, this.j, str);
        int l2 = a2 == null ? 0 : a2.l();
        String str2 = a;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(l2));
        if (l2 == 404 || l2 == 401) {
            if (!TextUtils.isEmpty(c()) || !TextUtils.isEmpty(this.b.getAppName())) {
                this.f.clear();
                Logger.i(str2, "this env has not deploy new interface,so use old interface.");
                a2 = a(executorService, this.i, str);
            } else {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
        }
        e.a(this.g, SystemClock.elapsedRealtime() - elapsedRealtime, this.h, this.c);
        return a2;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x007a: APUT  (r8v0 java.lang.Object[]), (0 ??[int, short, byte, char]), (r9v2 java.lang.String) */
    private void b() {
        com.huawei.hms.framework.network.grs.b.b.c a2 = com.huawei.hms.framework.network.grs.b.a.a.a(this.c);
        if (a2 == null) {
            Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a2);
        List<String> c2 = a2.c();
        if (c2 == null || c2.size() <= 0) {
            Logger.v(a, "maybe grs_base_url config with [],please check.");
        } else if (c2.size() <= 10) {
            String a3 = a2.a();
            String b2 = a2.b();
            if (c2.size() > 0) {
                for (String str : c2) {
                    if (!str.startsWith("https://")) {
                        Logger.w(a, "grs server just support https scheme url,please check.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        Locale locale = Locale.ROOT;
                        Object[] objArr = new Object[1];
                        objArr[0] = TextUtils.isEmpty(c()) ? this.b.getAppName() : c();
                        sb.append(String.format(locale, a3, objArr));
                        String grsReqParamJoint = this.b.getGrsReqParamJoint(false, false, "1.0", this.c);
                        if (!TextUtils.isEmpty(grsReqParamJoint)) {
                            sb.append("?");
                            sb.append(grsReqParamJoint);
                        }
                        this.i.add(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(b2);
                        String grsReqParamJoint2 = this.b.getGrsReqParamJoint(false, false, c(), this.c);
                        if (!TextUtils.isEmpty(grsReqParamJoint2)) {
                            sb2.append("?");
                            sb2.append(grsReqParamJoint2);
                        }
                        this.j.add(sb2.toString());
                    }
                }
            }
            Logger.v(a, "request to GRS server url is{%s} and {%s}", this.i, this.j);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    private String c() {
        com.huawei.hms.framework.network.grs.local.model.a a2 = b.a(this.c.getPackageName()).a();
        if (a2 == null) {
            return "";
        }
        String a3 = a2.a();
        Logger.v(a, "get appName from local assets is{%s}", a3);
        return a3;
    }

    public com.huawei.hms.framework.network.grs.b.b.c a() {
        return this.k;
    }

    public d a(final ExecutorService executorService, final String str) {
        String str2;
        Throwable e2;
        String str3;
        if (this.i == null || this.j == null) {
            return null;
        }
        try {
            com.huawei.hms.framework.network.grs.b.b.c a2 = a();
            return (d) executorService.submit(new Callable<d>() {
                /* class com.huawei.hms.framework.network.grs.b.c.AnonymousClass1 */

                /* renamed from: a */
                public d call() {
                    return c.this.b(executorService, str);
                }
            }).get((long) (a2 != null ? a2.d() : 10), TimeUnit.SECONDS);
        } catch (CancellationException unused) {
            Logger.i(a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e3) {
            e2 = e3;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e2);
            return null;
        } catch (InterruptedException e4) {
            e2 = e4;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e2);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(a, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e5) {
            e2 = e5;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e2);
            return null;
        }
    }

    public void a(com.huawei.hms.framework.network.grs.b.b.c cVar) {
        this.k = cVar;
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public synchronized void a(d dVar) {
        this.g.add(dVar);
        d dVar2 = this.e;
        if (dVar2 == null || !dVar2.h()) {
            if (dVar.i()) {
                Logger.i(a, "GRS server open 503 limiting strategy.");
                d.a(this.b.getGrsParasKey(false, true, this.c), new d.a(dVar.e(), SystemClock.elapsedRealtime()));
            } else if (!dVar.h()) {
                Logger.v(a, "grsResponseResult has exception so need return");
            } else {
                this.e = dVar;
                this.d.a(this.b, dVar, this.c);
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    if (!this.i.get(i2).equals(dVar.k()) && !this.j.get(i2).equals(dVar.k()) && !this.f.get(i2).isCancelled()) {
                        Logger.i(a, "future cancel");
                        this.f.get(i2).cancel(true);
                    }
                }
            }
        } else {
            Logger.v(a, "grsResponseResult is ok");
        }
    }
}
