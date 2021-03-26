package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadProcessDispatcher */
public class c {
    private static volatile c a;
    private volatile SparseArray<Boolean> b = new SparseArray<>();
    private Handler c = new Handler(Looper.getMainLooper());
    private volatile List<ae> d = new ArrayList();

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                a = new c();
            }
        }
        return a;
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            if (e.c()) {
                aeVar.a();
                return;
            }
            if (l.a(true).g()) {
                aeVar.a();
            }
            synchronized (this.d) {
                if (!this.d.contains(aeVar)) {
                    this.d.add(aeVar);
                }
            }
        }
    }

    public void b(ae aeVar) {
        if (aeVar != null) {
            synchronized (this.d) {
                if (this.d.contains(aeVar)) {
                    this.d.remove(aeVar);
                }
            }
        }
    }

    public void b() {
        synchronized (this.d) {
            for (ae aeVar : this.d) {
                if (aeVar != null) {
                    aeVar.a();
                }
            }
        }
    }

    public void a(int i, boolean z) {
        b(i, z);
        if (!e.c() && l.a(true).g()) {
            l.a(true).c(i, z);
        }
        if (!b.c() && !e.c() && !e.a()) {
            try {
                Intent intent = new Intent(b.L(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                b.L().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void b(int i, boolean z) {
        this.b.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int a(int i) {
        if (e.c() || !l.a(true).g()) {
            return b(i);
        }
        return l.a(true).m(i);
    }

    public synchronized int b(int i) {
        if (this.b.get(i) == null) {
            return -1;
        }
        return this.b.get(i).booleanValue() ? 1 : 0;
    }

    public l c(int i) {
        boolean z = true;
        if (a(i) != 1 || e.c()) {
            z = false;
        }
        return l.a(z);
    }

    private l b(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<b> i;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean isNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        boolean z = true;
        if (e.c() || !e.a()) {
            isNeedIndependentProcess = true;
        }
        int a2 = a(downloadInfo.getId());
        if (a2 >= 0 && a2 != isNeedIndependentProcess) {
            if (a2 == 1) {
                try {
                    if (e.a()) {
                        l.a(true).a(downloadInfo.getId());
                        DownloadInfo h = l.a(true).h(downloadInfo.getId());
                        if (h != null) {
                            l.a(false).b(h);
                        }
                        if (h.getChunkCount() > 1 && (i = l.a(true).i(downloadInfo.getId())) != null) {
                            l.a(false).a(downloadInfo.getId(), e.a(i));
                        }
                    }
                } catch (Throwable unused) {
                }
            } else if (e.a()) {
                l.a(false).a(downloadInfo.getId());
                List<b> i2 = l.a(false).i(downloadInfo.getId());
                if (i2 != null) {
                    l.a(true).a(downloadInfo.getId(), e.a(i2));
                }
            } else {
                downloadTask.setNeedDelayForCacheSync(true);
                l.a(true).a(1, downloadInfo.getId());
            }
        }
        a(downloadInfo.getId(), isNeedIndependentProcess);
        if (!isNeedIndependentProcess) {
            z = false;
        }
        return l.a(z);
    }

    public void d(int i) {
        l c2 = c(i);
        if (c2 != null) {
            c2.a(i);
        }
    }

    public void c(int i, boolean z) {
        if (!e.a()) {
            l c2 = c(i);
            if (c2 != null) {
                c2.a(i, z);
            }
            l.a(true).a(2, i);
        } else if (a.a(8388608)) {
            l a2 = l.a(true);
            if (a2 != null) {
                a2.a(i, z);
            }
            l a3 = l.a(false);
            if (a3 != null) {
                a3.a(i, z);
            }
        } else {
            l a4 = l.a(false);
            if (a4 != null) {
                a4.a(i, z);
            }
            l a5 = l.a(true);
            if (a5 != null) {
                a5.a(i, z);
            }
        }
    }

    public boolean e(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return false;
        }
        return c2.b(i);
    }

    public void f(int i) {
        l c2 = c(i);
        if (c2 != null) {
            c2.c(i);
        }
    }

    public void g(int i) {
        l c2 = c(i);
        if (c2 != null) {
            c2.d(i);
        }
    }

    public void c() {
        l a2 = l.a(false);
        if (a2 != null) {
            a2.a();
        }
        l a3 = l.a(true);
        if (a3 != null) {
            a3.a();
        }
    }

    public long h(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return 0;
        }
        return c2.e(i);
    }

    public int i(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return 0;
        }
        return c2.f(i);
    }

    public boolean j(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return false;
        }
        return c2.g(i);
    }

    public DownloadInfo k(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.h(i);
    }

    public int a(String str, String str2) {
        return b.a(str, str2);
    }

    public DownloadInfo b(String str, String str2) {
        int a2 = a(str, str2);
        l c2 = c(a2);
        if (c2 == null) {
            return null;
        }
        return c2.h(a2);
    }

    public List<DownloadInfo> a(String str) {
        List<DownloadInfo> a2 = l.a(false).a(str);
        List<DownloadInfo> a3 = l.a(true).a(str);
        if (a2 == null && a3 == null) {
            return null;
        }
        if (a2 == null || a3 == null) {
            return a2 != null ? a2 : a3;
        }
        ArrayList arrayList = new ArrayList(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    public ab l(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.q(i);
    }

    public ah m(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.r(i);
    }

    public void a(int i, ab abVar) {
        l c2 = c(i);
        if (c2 != null) {
            c2.a(i, abVar);
        }
    }

    public List<DownloadInfo> b(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        l a2 = l.a(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> b2 = a2 != null ? a2.b(str) : null;
        l a3 = l.a(true);
        if (a3 != null) {
            list = a3.b(str);
        }
        return a(b2, list, sparseArray);
    }

    private List<DownloadInfo> a(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public List<DownloadInfo> c(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        l a2 = l.a(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> c2 = a2 != null ? a2.c(str) : null;
        l a3 = l.a(true);
        if (a3 != null) {
            list = a3.c(str);
        }
        return a(c2, list, sparseArray);
    }

    public void a(List<String> list) {
        l a2 = l.a(false);
        if (a2 != null) {
            a2.a(list);
        }
        l a3 = l.a(true);
        if (a3 != null) {
            a3.a(list);
        }
    }

    public void b(List<String> list) {
        l a2 = l.a(false);
        if (a2 != null) {
            a2.b(list);
        }
        l a3 = l.a(true);
        if (a3 != null) {
            a3.b(list);
        }
    }

    public void d(int i, boolean z) {
        l c2 = c(i);
        if (c2 != null) {
            c2.b(i, z);
        }
    }

    public void n(int i) {
        l c2 = c(i);
        if (c2 != null) {
            c2.j(i);
        }
    }

    public void a(int i, IDownloadListener iDownloadListener, g gVar, boolean z) {
        int i2;
        l c2 = c(i);
        if (c2 != null) {
            if (iDownloadListener == null) {
                i2 = 0;
            } else {
                i2 = iDownloadListener.hashCode();
            }
            c2.b(i, i2, iDownloadListener, gVar, z);
        }
    }

    public void b(int i, IDownloadListener iDownloadListener, g gVar, boolean z) {
        l c2 = c(i);
        if (c2 != null) {
            c2.a(i, iDownloadListener.hashCode(), iDownloadListener, gVar, z);
        }
    }

    public void a(int i, IDownloadListener iDownloadListener, g gVar, boolean z, boolean z2) {
        l c2 = c(i);
        if (c2 != null) {
            c2.a(i, iDownloadListener.hashCode(), iDownloadListener, gVar, z, z2);
        }
    }

    public boolean a(DownloadInfo downloadInfo) {
        l c2;
        if (downloadInfo == null || (c2 = c(downloadInfo.getId())) == null) {
            return false;
        }
        return c2.a(downloadInfo);
    }

    public boolean d() {
        return b.M();
    }

    public List<DownloadInfo> d(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        l a2 = l.a(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> d2 = a2 != null ? a2.d(str) : null;
        l a3 = l.a(true);
        if (a3 != null) {
            list = a3.d(str);
        }
        return a(d2, list, sparseArray);
    }

    public List<DownloadInfo> e(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        l a2 = l.a(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> e = a2 != null ? a2.e(str) : null;
        l a3 = l.a(true);
        if (a3 != null) {
            list = a3.e(str);
        }
        return a(e, list, sparseArray);
    }

    public void a(final DownloadTask downloadTask) {
        final l b2 = b(downloadTask);
        if (b2 == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.c.postDelayed(new Runnable() {
                /* class com.ss.android.socialbase.downloader.downloader.c.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    b2.a(downloadTask);
                }
            }, 500);
        } else {
            b2.a(downloadTask);
        }
    }

    public boolean o(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return false;
        }
        return c2.l(i);
    }

    public void p(int i) {
        l a2 = l.a(false);
        if (a2 != null) {
            a2.k(i);
        }
        l a3 = l.a(true);
        if (a3 != null) {
            a3.k(i);
        }
    }

    public void q(int i) {
        if (i != 0) {
            Boolean bool = Boolean.TRUE;
            b(i, true);
            l a2 = l.a(true);
            if (a2 != null) {
                a2.d();
            }
        }
    }

    public void a(k kVar) {
        b.a(kVar);
    }

    public void b(k kVar) {
        b.b(kVar);
    }

    public boolean e() {
        l a2 = l.a(false);
        if (a2 != null) {
            return a2.e();
        }
        return false;
    }

    public t r(int i) {
        l c2 = c(i);
        if (c2 == null) {
            return null;
        }
        return c2.s(i);
    }

    public void a(int i, long j) {
        l c2 = c(i);
        if (c2 != null) {
            c2.a(i, j);
        }
    }
}
