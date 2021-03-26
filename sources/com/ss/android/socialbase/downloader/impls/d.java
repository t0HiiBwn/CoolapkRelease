package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.e;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultDownloadCache */
public class d implements i {
    private final k a = new k();
    private r b;
    private volatile boolean c;
    private volatile boolean d;
    private g.a e = new g.a() {
        /* class com.ss.android.socialbase.downloader.impls.d.AnonymousClass1 */

        @Override // com.ss.android.socialbase.downloader.h.g.a
        public void a(Message message) {
            if (message.what == 1) {
                b.l().execute(new Runnable() {
                    /* class com.ss.android.socialbase.downloader.impls.d.AnonymousClass1.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.h();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private g f = null;

    public d() {
        if (!a.c().a("fix_sigbus_downloader_db")) {
            this.b = new e();
        } else if (com.ss.android.socialbase.downloader.i.e.a()) {
            this.b = new e();
        } else {
            f fVar = new f();
            fVar.a(new f.a() {
                /* class com.ss.android.socialbase.downloader.impls.d.AnonymousClass2 */

                @Override // com.ss.android.socialbase.downloader.b.f.a
                public void a() {
                    d.this.b = new e();
                    Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
            this.b = fVar;
        }
        this.c = false;
        this.f = new g(Looper.getMainLooper(), this.e);
        f();
    }

    public k a() {
        return this.a;
    }

    public r e() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo g(int i) {
        DownloadInfo g = this.a.g(i);
        c(g);
        return g;
    }

    public void f() {
        b.a(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        this.b.a(this.a.a(), this.a.e(), new com.ss.android.socialbase.downloader.b.d() {
            /* class com.ss.android.socialbase.downloader.impls.d.AnonymousClass3 */

            @Override // com.ss.android.socialbase.downloader.b.d
            public void a() {
                d.this.i();
                d.this.g();
                b.a(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
            }
        });
    }

    /* access modifiers changed from: private */
    public void i() {
        synchronized (this) {
            this.c = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean d() {
        if (this.c) {
            return true;
        }
        synchronized (this) {
            if (!this.c) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean c() {
        return this.c;
    }

    public void g() {
        long j;
        if (a.c().a("task_resume_delay")) {
            j = 4000;
        } else {
            j = Build.VERSION.SDK_INT >= 23 ? 1000 : 5000;
        }
        this.f.sendMessageDelayed(this.f.obtainMessage(1), j);
    }

    public void h() {
        ArrayList arrayList;
        List<String> list;
        if (this.c) {
            if (this.d) {
                com.ss.android.socialbase.downloader.c.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.d = true;
            if (com.ss.android.socialbase.downloader.i.e.a()) {
                k w = b.w();
                if (w != null) {
                    list = w.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray<DownloadInfo> a2 = this.a.a();
                if (a2 != null) {
                    synchronized (a2) {
                        for (int i = 0; i < a2.size(); i++) {
                            int keyAt = a2.keyAt(i);
                            if (keyAt != 0) {
                                DownloadInfo downloadInfo = a2.get(keyAt);
                                if (downloadInfo != null) {
                                    int realStatus = downloadInfo.getRealStatus();
                                    int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                                    if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                                        com.ss.android.socialbase.downloader.d.a.a(b.g(), downloadInfo, (BaseException) null, -5);
                                    }
                                    if (list != null) {
                                        if (arrayList != null) {
                                            if (downloadInfo.getMimeType() != null) {
                                                if (list.contains(downloadInfo.getMimeType())) {
                                                    if (a.a(downloadInfo.getId()).b("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi()) {
                                                        downloadInfo.setDownloadFromReserveWifi(false);
                                                        arrayList.add(downloadInfo);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!(w == null || arrayList == null || arrayList.isEmpty())) {
                        w.a(arrayList, 1);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i) {
        return this.a.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> a(String str) {
        return this.a.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b(String str) {
        return this.a.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> c(String str) {
        return this.a.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> d(String str) {
        return this.a.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        return this.a.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i) {
        this.a.d(i);
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.o(i);
            } else {
                this.b.d(i);
            }
        } else {
            this.b.d(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.a.a(bVar);
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(bVar);
            } else {
                this.b.a(bVar);
            }
        } else {
            this.b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(bVar);
            } else {
                this.b.a(bVar);
            }
        } else {
            this.b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, long j) {
        this.a.a(i, i2, j);
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(i, i2, j);
            } else {
                this.b.a(i, i2, j);
            }
        } else {
            this.b.a(i, i2, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(i, i2, i3, j);
            } else {
                this.b.a(i, i2, i3, j);
            }
        } else {
            this.b.a(i, i2, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(i, i2, i3, i4);
            } else {
                this.b.a(i, i2, i3, i4);
            }
        } else {
            this.b.a(i, i2, i3, i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, int i2) {
        DownloadInfo a2 = this.a.a(i, i2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a2 = this.a.a(downloadInfo);
        c(downloadInfo);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean e(int i) {
        try {
            if (com.ss.android.socialbase.downloader.i.e.b()) {
                l a2 = l.a(true);
                if (a2 != null) {
                    a2.n(i);
                } else {
                    this.b.e(i);
                }
            } else {
                this.b.e(i);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.a.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean f(int i) {
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.p(i);
            } else {
                this.b.f(i);
            }
        } else {
            this.b.f(i);
        }
        return this.a.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b() {
        try {
            this.a.b();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.e.b()) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.f();
            } else {
                this.b.b();
            }
        } else {
            this.b.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo a2 = this.a.a(i, j, str, str2);
        c(a2);
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i, long j) {
        DownloadInfo a2 = this.a.a(i, j);
        a(a2, false);
        return a2;
    }

    private void c(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    private void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo != null) {
            if (!com.ss.android.socialbase.downloader.i.e.b()) {
                this.b.a(downloadInfo);
            } else if (z) {
                l a2 = l.a(true);
                if (a2 != null) {
                    a2.c(downloadInfo);
                } else {
                    this.b.a(downloadInfo);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i, long j) {
        DownloadInfo b2 = this.a.b(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo h(int i) {
        DownloadInfo h = this.a.h(i);
        c(h);
        return h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo c(int i, long j) {
        DownloadInfo c2 = this.a.c(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return c2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo d(int i, long j) {
        DownloadInfo d2 = this.a.d(i, j);
        b(i, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return d2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo i(int i) {
        DownloadInfo i2 = this.a.i(i);
        c(i2);
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo j(int i) {
        DownloadInfo j = this.a.j(i);
        c(j);
        return j;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            this.a.a(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list != null && list.size() != 0) {
            this.a.a(i, list);
            if (com.ss.android.socialbase.downloader.i.e.c()) {
                this.b.b(i, list);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            a(this.a.b(i));
            if (list == null) {
                list = this.a.c(i);
            }
            if (com.ss.android.socialbase.downloader.i.e.b()) {
                l a2 = l.a(true);
                if (a2 != null) {
                    a2.b(i, list);
                } else {
                    this.b.b(i, list);
                }
            } else {
                this.b.b(i, list);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.f.i> n(int i) {
        List<com.ss.android.socialbase.downloader.f.i> n = this.a.n(i);
        return (n == null || n.size() == 0) ? this.b.n(i) : n;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> l = this.a.l(i);
        if (l != null && !l.isEmpty()) {
            return l;
        }
        Map<Long, com.ss.android.socialbase.downloader.f.i> l2 = this.b.l(i);
        this.a.a(i, l2);
        return l2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.a.a(i, map);
        this.b.a(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void m(int i) {
        this.a.m(i);
        this.b.m(i);
    }
}
