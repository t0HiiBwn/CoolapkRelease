package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* compiled from: IndependentProcessDownloadHandler */
public class o implements l, m {
    private static final String a = "o";
    private volatile h b;
    private n<IndependentProcessDownloadService> c;
    private l d = new p();

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadInfo downloadInfo) {
    }

    public o() {
        n<IndependentProcessDownloadService> z = b.z();
        this.c = z;
        z.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i) {
        if (this.b != null) {
            try {
                this.b.a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, boolean z) {
        if (this.b != null) {
            try {
                this.b.a(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int i) {
        if (this.b != null) {
            try {
                this.b.c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void d(int i) {
        if (this.b != null) {
            try {
                this.b.d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a() {
        if (this.b != null) {
            try {
                this.b.a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public long e(int i) {
        if (this.b == null) {
            return 0;
        }
        try {
            return this.b.e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int f(int i) {
        if (this.b == null) {
            return 0;
        }
        try {
            return this.b.f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean g(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo h(int i) {
        if (this.b == null) {
            return this.d.h(i);
        }
        try {
            return this.b.h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> a(String str) {
        if (this.b == null) {
            return this.d.a(str);
        }
        try {
            return this.b.a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        if (this.b == null) {
            return this.d.i(i);
        }
        try {
            return this.b.i(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int a(String str, String str2) {
        return b.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> b(String str) {
        if (this.b == null) {
            return this.d.b(str);
        }
        try {
            return this.b.b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String str) {
        if (this.b == null) {
            return this.d.c(str);
        }
        try {
            return this.b.c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(List<String> list) {
        if (this.b == null) {
            this.d.a(list);
            return;
        }
        try {
            this.b.a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(List<String> list) {
        if (this.b == null) {
            this.d.b(list);
            return;
        }
        try {
            this.b.b(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, boolean z) {
        if (this.b == null) {
            this.d.b(i, z);
            return;
        }
        try {
            this.b.b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void j(int i) {
        if (this.b == null) {
            this.d.j(i);
            return;
        }
        try {
            this.b.j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z) {
        if (this.b != null) {
            try {
                this.b.b(i, i2, f.a(iDownloadListener, gVar != g.SUB), gVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z, boolean z2) {
        if (this.b != null) {
            try {
                this.b.a(i, i2, f.a(iDownloadListener, gVar != g.SUB), gVar.ordinal(), z, z2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z) {
        if (this.b != null) {
            try {
                this.b.a(i, i2, f.a(iDownloadListener, gVar != g.SUB), gVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(DownloadInfo downloadInfo) {
        if (this.b == null) {
            return this.d.a(downloadInfo);
        }
        try {
            this.b.a(downloadInfo);
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, Notification notification) {
        if (this.b == null) {
            a.d(a, "startForeground, aidlService is null");
            return;
        }
        String str = a;
        a.c(str, "aidlService.startForeground, id = " + i);
        try {
            this.b.a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(boolean z, boolean z2) {
        if (this.b == null) {
            a.d(a, "stopForeground, aidlService is null");
            return;
        }
        a.c(a, "aidlService.stopForeground");
        try {
            this.b.a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b() {
        if (this.b == null) {
            a.d(a, "isServiceForeground, aidlService is null");
            return false;
        }
        a.c(a, "aidlService.isServiceForeground");
        try {
            return this.b.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c() {
        return b.M();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> d(String str) {
        if (this.b == null) {
            return this.d.d(str);
        }
        try {
            return this.b.e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> e(String str) {
        if (this.b == null) {
            return null;
        }
        try {
            return this.b.d(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(DownloadTask downloadTask) {
        n<IndependentProcessDownloadService> nVar;
        if (downloadTask != null && (nVar = this.c) != null) {
            nVar.b(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadTask downloadTask) {
        n<IndependentProcessDownloadService> nVar;
        if (downloadTask != null && (nVar = this.c) != null) {
            nVar.c(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean l(int i) {
        if (this.b == null) {
            return false;
        }
        try {
            return this.b.k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void k(int i) {
        n<IndependentProcessDownloadService> nVar = this.c;
        if (nVar != null) {
            nVar.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void d() {
        n<IndependentProcessDownloadService> nVar = this.c;
        if (nVar != null) {
            nVar.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean e() {
        if (this.b == null) {
            return this.d.e();
        }
        try {
            return this.b.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.b != null) {
            try {
                this.b.b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int i, boolean z) {
        if (this.b != null) {
            try {
                this.b.d(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int m(int i) {
        if (this.b == null) {
            return c.a().b(i);
        }
        try {
            return this.b.m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.b == null) {
            this.d.a(bVar);
            return;
        }
        try {
            this.b.a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c(DownloadInfo downloadInfo) {
        if (this.b == null) {
            return this.d.c(downloadInfo);
        }
        try {
            return this.b.b(downloadInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean n(int i) {
        if (this.b == null) {
            return this.d.n(i);
        }
        try {
            return this.b.n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void o(int i) {
        if (this.b == null) {
            this.d.o(i);
            return;
        }
        try {
            this.b.o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, long j) {
        if (this.b == null) {
            this.d.a(i, i2, j);
            return;
        }
        try {
            this.b.a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, int i3, long j) {
        if (this.b == null) {
            this.d.a(i, i2, i3, j);
            return;
        }
        try {
            this.b.a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, int i3, int i4) {
        if (this.b == null) {
            this.d.a(i, i2, i3, i4);
            return;
        }
        try {
            this.b.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean p(int i) {
        if (this.b == null) {
            return this.d.p(i);
        }
        try {
            return this.b.p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void f() {
        if (this.b == null) {
            this.d.f();
            return;
        }
        try {
            this.b.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.b == null) {
            this.d.b(i, list);
            return;
        }
        try {
            this.b.a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean g() {
        return this.b != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(al alVar) {
        if (this.b != null) {
            try {
                this.b.a(f.a(alVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2) {
        if (this.b != null) {
            try {
                this.b.a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ab q(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return f.a(this.b.q(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ah r(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return f.a(this.b.r(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, ab abVar) {
        if (this.b != null) {
            try {
                this.b.a(i, f.a(abVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public t s(int i) {
        if (this.b == null) {
            return null;
        }
        try {
            return f.a(this.b.s(i));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(IBinder iBinder) {
        this.b = h.a.a(iBinder);
        if (e.a()) {
            a(new al() {
                /* class com.ss.android.socialbase.downloader.impls.o.AnonymousClass1 */

                @Override // com.ss.android.socialbase.downloader.depend.al
                public void a(int i, int i2) {
                    if (i2 == 1) {
                        Downloader.getInstance(b.L()).pause(i);
                        List<com.ss.android.socialbase.downloader.model.b> i3 = l.a(false).i(i);
                        if (i3 != null) {
                            l.a(true).a(i, e.a(i3));
                        }
                    } else if (i2 == 2) {
                        Downloader.getInstance(b.L()).cancel(i);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void h() {
        this.b = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, long j) {
        if (this.b != null) {
            try {
                this.b.a(i, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
