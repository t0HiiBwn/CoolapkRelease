package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.b.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.e.a;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AdQuickAppManager */
public class c implements l.a {
    private static String a = "c";
    private static volatile c b;
    private l c;
    private ConcurrentHashMap<Long, Runnable> d;

    public c() {
        this.d = null;
        this.d = new ConcurrentHashMap<>();
        this.c = new l(Looper.getMainLooper(), this);
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    @Override // com.ss.android.downloadlib.h.l.a
    public void a(Message message) {
        if (message != null) {
            boolean a2 = k.k() != null ? k.k().a() : false;
            long j = 0;
            if (message.obj instanceof Long) {
                j = ((Long) message.obj).longValue();
            }
            com.ss.android.a.a.b.c a3 = f.a().a(j);
            if (a3 instanceof com.ss.android.downloadad.a.a.c) {
                ((com.ss.android.downloadad.a.a.c) a3).a(3);
            }
            int i = message.what;
            if (i != 4) {
                if (i != 5) {
                    if (i == 7) {
                        Runnable runnable = this.d.get(Long.valueOf(j));
                        this.d.remove(Long.valueOf(j));
                        if (a2) {
                            a.a().a(j, 1);
                            a.a().a(j, true, 1);
                            return;
                        }
                        if (runnable != null) {
                            this.c.post(runnable);
                        }
                        a.a().a(j, false, 1);
                    }
                } else if (a2) {
                    a.a().a(j, true, 1);
                }
            } else if (a2) {
                a.a().a(j, true, 2);
            }
        }
    }

    public void a(int i, com.ss.android.a.a.b.c cVar, b bVar) {
        String str = a;
        j.a(str, "sendQuickAppMsg msgWhat:" + i, null);
        if (this.c != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = Long.valueOf(cVar.d());
            this.c.sendMessageDelayed(obtain, b());
        }
    }

    public long b() {
        return k.i().optLong("quick_app_check_internal", 1200);
    }

    public static boolean a(com.ss.android.a.a.b.c cVar) {
        return (cVar == null || cVar.B() == null || TextUtils.isEmpty(cVar.B().a())) ? false : true;
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
