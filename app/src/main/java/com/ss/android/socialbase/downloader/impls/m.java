package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
import com.ss.android.socialbase.downloader.model.b;
import java.util.List;

/* compiled from: IndependentDownloadBinder */
public class m extends h.a {
    private static final String a = "m";
    private final l b = new p(true);

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(a aVar) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(f.a(aVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean b(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void c(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void d(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.d(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a() throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public long e(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return 0;
        }
        return lVar.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int f(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return 0;
        }
        return lVar.f(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean g(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo h(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.h(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String str) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<b> i(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.i(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int a(String str, String str2) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return 0;
        }
        return lVar.a(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(String str, String str2) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.b(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> b(String str) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> c(String str) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> d(String str) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.e(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(List<String> list) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(List<String> list) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(int i, boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void c(int i, boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void j(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.j(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2, i iVar, int i3, boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(i, i2, f.a(iVar), e.e(i3), z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(int i, int i2, i iVar, int i3, boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2, f.a(iVar), e.e(i3), z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2, i iVar, int i3, boolean z, boolean z2) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2, f.a(iVar), e.e(i3), z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(DownloadInfo downloadInfo) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, Notification notification) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(boolean z) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(true, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean e() throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, long j) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean b() throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> e(String str) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return lVar.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean k(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.l(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void l(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.k(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c() throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void d(int i, boolean z) throws RemoteException {
        c.a().b(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int m(int i) throws RemoteException {
        return c.a().b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(b bVar) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean b(DownloadInfo downloadInfo) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean n(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.n(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void o(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.o(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2, long j) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2, int i3, long j) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2, int i3, int i4) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2, i3, i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean p(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.p(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void d() throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, List<b> list) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(int i, List<b> list) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(ak akVar) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(f.a(akVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, int i2) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public aa q(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return f.a(lVar.q(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public ag r(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return f.a(lVar.r(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(int i, aa aaVar) throws RemoteException {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i, f.a(aaVar));
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public g s(int i) throws RemoteException {
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        return f.a(lVar.s(i));
    }
}
