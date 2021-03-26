package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.i.g;
import java.net.InetAddress;
import java.util.List;

/* compiled from: DownloadDnsManager */
public class c {
    private final g<String, b> a;
    private final Handler b;
    private final Handler c;

    /* compiled from: DownloadDnsManager */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.c$c  reason: collision with other inner class name */
    /* compiled from: DownloadDnsManager */
    private static class C0115c {
        private static final c a = new c();
    }

    private c() {
        this.a = new g<>(4, 16, false);
        this.b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.c = new Handler(e.a());
    }

    public static c a() {
        return C0115c.a;
    }

    public void a(final String str, final a aVar, final long j) {
        this.b.post(new Runnable() {
            /* class com.ss.android.socialbase.downloader.network.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(str, aVar, j);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(final String str, final a aVar, long j) {
        final b bVar;
        f u;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.a) {
                bVar = (b) this.a.get(host);
            }
            if (bVar != null) {
                if (System.currentTimeMillis() - bVar.b < ((long) (com.ss.android.socialbase.downloader.g.a.c().a("dns_expire_min", 10) * 60 * 1000))) {
                    if (aVar != null) {
                        aVar.a(str, bVar.a);
                        return;
                    }
                    return;
                }
            }
            AnonymousClass2 r1 = new Runnable() {
                /* class com.ss.android.socialbase.downloader.network.c.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = aVar;
                    if (aVar != null) {
                        String str = str;
                        b bVar = bVar;
                        aVar.a(str, bVar == null ? null : bVar.a);
                    }
                }
            };
            this.c.postDelayed(r1, j);
            List<InetAddress> list = null;
            if (com.ss.android.socialbase.downloader.g.a.c().a("use_host_dns", 1) == 1 && (u = com.ss.android.socialbase.downloader.downloader.b.u()) != null) {
                try {
                    list = u.a(host);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (list == null || list.isEmpty()) {
                try {
                    list = com.ss.android.socialbase.downloader.downloader.b.v().a(host);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (list != null && !list.isEmpty()) {
                a(host, list);
            } else if (bVar != null) {
                list = bVar.a;
            }
            this.c.removeCallbacks(r1);
            if (aVar != null) {
                aVar.a(str, list);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    private void a(String str, List<InetAddress> list) {
        synchronized (this.a) {
            b bVar = (b) this.a.get(str);
            if (bVar == null) {
                bVar = new b();
                this.a.put(str, bVar);
            }
            bVar.a = list;
            bVar.b = System.currentTimeMillis();
        }
    }

    /* compiled from: DownloadDnsManager */
    private static class b {
        List<InetAddress> a;
        long b;

        private b() {
        }
    }
}
