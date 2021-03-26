package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* compiled from: ProcessDownloadHandler */
public class p implements l {
    private final a a;
    private final i b;
    private final n c;
    private final boolean d;

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void d() {
    }

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.a = b.C();
        this.b = b.x();
        if (!z) {
            this.c = b.y();
        } else {
            this.c = b.z();
        }
        this.d = a.c().b("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.n(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.f(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void d(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> b(String str) {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(List<String> list) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public long e(int i) {
        DownloadInfo b2;
        i iVar = this.b;
        if (iVar == null || (b2 = iVar.b(i)) == null) {
            return 0;
        }
        int chunkCount = b2.getChunkCount();
        if (chunkCount <= 1) {
            return b2.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.b.c(i);
        if (c2 == null || c2.size() != chunkCount) {
            return 0;
        }
        return e.b(c2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int f(int i) {
        DownloadInfo d2;
        a aVar = this.a;
        if (aVar == null || (d2 = aVar.d(i)) == null) {
            return 0;
        }
        return d2.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean g(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo h(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> a(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<com.ss.android.socialbase.downloader.model.b> i(int i) {
        return this.b.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public DownloadInfo b(String str, String str2) {
        return h(b.a(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int a(String str, String str2) {
        return b.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> c(String str) {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, z);
        }
    }

    public void d(int i, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void j(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, i2, iDownloadListener, gVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z, boolean z2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, iDownloadListener, gVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, int i2, IDownloadListener iDownloadListener, g gVar, boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, iDownloadListener, gVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a2 = e.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (a2) {
            if (com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                b(downloadInfo.getId(), true);
            } else {
                d(downloadInfo.getId(), true);
            }
        }
        return a2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, Notification notification) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(boolean z, boolean z2) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.a(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean b() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.b();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c() {
        return b.M();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> d(String str) {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<DownloadInfo> e(String str) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(DownloadTask downloadTask) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.b(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadTask downloadTask) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.c(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean l(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.k(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void k(int i) {
        com.ss.android.socialbase.downloader.c.a.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean e() {
        return this.b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(DownloadInfo downloadInfo) {
        this.b.b(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.a(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void c(int i, boolean z) {
        c.a().a(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public int m(int i) {
        return c.a().a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean c(DownloadInfo downloadInfo) {
        return this.b.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean n(int i) {
        return this.b.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void o(int i) {
        this.b.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, long j) {
        this.b.a(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, int i3, long j) {
        this.b.a(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2, int i3, int i4) {
        this.b.a(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean p(int i) {
        return this.b.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void f() {
        this.b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        this.b.b(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public boolean g() {
        n nVar;
        if (!this.d || (nVar = this.c) == null || !nVar.a()) {
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(al alVar) {
        b.a(alVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, int i2) {
        if (b.e() != null) {
            for (al alVar : b.e()) {
                if (alVar != null) {
                    alVar.a(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ab q(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.i(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public ah r(int i) {
        a aVar = this.a;
        ah h = aVar != null ? aVar.h(i) : null;
        return h == null ? b.I() : h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, ab abVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, abVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public t s(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.j(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void a(int i, long j) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i, j);
        }
    }
}
