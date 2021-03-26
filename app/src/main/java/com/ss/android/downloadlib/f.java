package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.a.s;
import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.downloadlib.addownload.g;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownloadDispatcher */
public class f {
    private static volatile f b;
    public final Handler a = new Handler(Looper.getMainLooper());
    private final List<g> c = new CopyOnWriteArrayList();
    private final Map<String, g> d = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> e = new CopyOnWriteArrayList<>();
    private long f;

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    public void a(Context context, int i, d dVar, c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.a())) {
            g gVar = this.d.get(cVar.a());
            if (gVar != null) {
                gVar.b(context).b(i, dVar).b(cVar).a();
            } else if (!this.c.isEmpty()) {
                b(context, i, dVar, cVar);
            } else {
                c(context, i, dVar, cVar);
            }
        }
    }

    public com.ss.android.downloadlib.addownload.f a(String str) {
        Map<String, g> map = this.d;
        if (!(map == null || map.size() == 0 || TextUtils.isEmpty(str))) {
            g gVar = this.d.get(str);
            if (gVar instanceof com.ss.android.downloadlib.addownload.f) {
                return (com.ss.android.downloadlib.addownload.f) gVar;
            }
        }
        return null;
    }

    private synchronized void b(Context context, int i, d dVar, c cVar) {
        if (this.c.size() <= 0) {
            c(context, i, dVar, cVar);
        } else {
            g remove = this.c.remove(0);
            remove.b(context).b(i, dVar).b(cVar).a();
            this.d.put(cVar.a(), remove);
        }
    }

    private void c(Context context, int i, d dVar, c cVar) {
        if (cVar != null) {
            com.ss.android.downloadlib.addownload.f fVar = new com.ss.android.downloadlib.addownload.f();
            fVar.b(context).b(i, dVar).b(cVar).a();
            this.d.put(cVar.a(), fVar);
        }
    }

    public void a(String str, int i) {
        g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            if (gVar.a(i)) {
                this.c.add(gVar);
                this.d.remove(str);
            }
            c();
        }
    }

    public void a(String str, boolean z) {
        g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            gVar.a(z);
        }
    }

    public void a(String str, long j, int i, b bVar, a aVar) {
        a(str, j, i, bVar, aVar, null, null);
    }

    public void a(String str, long j, int i, b bVar, a aVar, s sVar, n nVar) {
        g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            gVar.a(j).b(bVar).b(aVar).a(sVar).a(nVar).b(i);
        }
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_listener_oom", false)) {
            this.e.add(new SoftReference(aVar));
        } else {
            this.e.add(aVar);
        }
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= 300000) {
            this.f = currentTimeMillis;
            if (!this.c.isEmpty()) {
                d();
            }
        }
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.c) {
            if (!gVar.b() && currentTimeMillis - gVar.d() > 300000) {
                gVar.g();
                arrayList.add(gVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.c.removeAll(arrayList);
        }
    }

    public void a(final c cVar, final a aVar, final b bVar) {
        this.a.post(new Runnable() {
            /* class com.ss.android.downloadlib.f.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = f.this.e.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof com.ss.android.a.a.b.a.a) {
                        ((com.ss.android.a.a.b.a.a) next).a(cVar, aVar, bVar);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.a.a.b.a.a) {
                            ((com.ss.android.a.a.b.a.a) softReference.get()).a(cVar, aVar, bVar);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.a.post(new Runnable() {
            /* class com.ss.android.downloadlib.f.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = f.this.e.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof com.ss.android.a.a.b.a.a) {
                        ((com.ss.android.a.a.b.a.a) next).a(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.a.a.b.a.a) {
                            ((com.ss.android.a.a.b.a.a) softReference.get()).a(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final String str) {
        this.a.post(new Runnable() {
            /* class com.ss.android.downloadlib.f.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = f.this.e.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof com.ss.android.a.a.b.a.a) {
                        ((com.ss.android.a.a.b.a.a) next).a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.a.a.b.a.a) {
                            ((com.ss.android.a.a.b.a.a) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void b(final DownloadInfo downloadInfo, final String str) {
        this.a.post(new Runnable() {
            /* class com.ss.android.downloadlib.f.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = f.this.e.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof com.ss.android.a.a.b.a.a) {
                        ((com.ss.android.a.a.b.a.a) next).b(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.a.a.b.a.a) {
                            ((com.ss.android.a.a.b.a.a) softReference.get()).b(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo) {
        this.a.post(new Runnable() {
            /* class com.ss.android.downloadlib.f.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = f.this.e.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof com.ss.android.a.a.b.a.a) {
                        ((com.ss.android.a.a.b.a.a) next).a(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.a.a.b.a.a) {
                            ((com.ss.android.a.a.b.a.a) softReference.get()).a(downloadInfo);
                        }
                    }
                }
            }
        });
    }

    public Handler b() {
        return this.a;
    }
}
