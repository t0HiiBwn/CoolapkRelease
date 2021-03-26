package com.ss.android.socialbase.downloader.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.j;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadPreconnecter */
public class b {
    static long a;
    static long b;
    private static final HandlerThread c;
    private static final Handler d;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        c = handlerThread;
        b();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        d = handler;
        handler.post(new Runnable() {
            /* class com.ss.android.socialbase.downloader.network.a.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper a() {
        return c.getLooper();
    }

    public static void a(final String str, final j jVar) {
        d.post(new Runnable() {
            /* class com.ss.android.socialbase.downloader.network.a.b.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                Throwable th;
                Exception e;
                c cVar = null;
                if (TextUtils.isEmpty(str)) {
                    j jVar = jVar;
                    if (jVar != null) {
                        jVar.a(null);
                        return;
                    }
                    return;
                }
                try {
                    List<c> b2 = b.b(0, null, null);
                    if (a.a().a(str)) {
                        cVar = a.a().a(str, b2);
                    }
                    if (cVar == null) {
                        c cVar2 = new c(str, b2, 0);
                        try {
                            cVar2.a();
                            if (cVar2.e()) {
                                a.a().a(str, cVar2);
                            }
                            cVar = cVar2;
                        } catch (Exception e2) {
                            e = e2;
                            cVar = cVar2;
                            try {
                                e.printStackTrace();
                                cVar.c();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cVar = cVar2;
                            try {
                                cVar.c();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    }
                    Map<String, String> i = cVar.i();
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.a(i);
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    cVar.c();
                }
                try {
                    cVar.c();
                } catch (Throwable unused2) {
                }
            }
        });
    }

    private static void b() {
        a = a.c().a("preconnect_connection_outdate_time", 300000L);
        b = a.c().a("preconnect_head_info_outdate_time", 300000L);
        a.a().a(a.c().a("preconnect_max_cache_size", 3));
    }

    /* access modifiers changed from: private */
    public static List<c> b(long j, DownloadInfo downloadInfo, List<c> list) {
        return e.a(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0);
    }
}
