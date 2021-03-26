package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: DownloadThreadPool */
public class d {
    private volatile SparseArray<c> a = new SparseArray<>();
    private int b = 0;

    public void a(c cVar) {
        int i;
        cVar.f();
        synchronized (d.class) {
            int i2 = this.b;
            i = 0;
            if (i2 >= 500) {
                b();
                this.b = 0;
            } else {
                this.b = i2 + 1;
            }
            this.a.put(cVar.e(), cVar);
        }
        DownloadTask c = cVar.c();
        try {
            ExecutorService p = b.p();
            if (!(c == null || c.getDownloadInfo() == null)) {
                if ("mime_type_plg".equals(c.getDownloadInfo().getMimeType()) && a.c().a("divide_plugin", 1) == 1) {
                    c.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = c.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = b.n();
                } else if (executorGroup == 4) {
                    p = b.o();
                }
            }
            if (p == null) {
                com.ss.android.socialbase.downloader.d.a.a(c.getMonitorDepend(), c.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), c.getDownloadInfo() != null ? c.getDownloadInfo().getStatus() : 0);
            } else if (a.a(cVar.e()).b("pause_with_interrupt", false)) {
                cVar.a(p.submit(cVar));
            } else {
                p.execute(cVar);
            }
        } catch (Exception e) {
            if (c != null) {
                z monitorDepend = c.getMonitorDepend();
                DownloadInfo downloadInfo = c.getDownloadInfo();
                BaseException baseException = new BaseException(1003, e.b(e, "DownloadThreadPoolExecute"));
                if (c.getDownloadInfo() != null) {
                    i = c.getDownloadInfo().getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (c != null) {
                z monitorDepend2 = c.getMonitorDepend();
                DownloadInfo downloadInfo2 = c.getDownloadInfo();
                BaseException baseException2 = new BaseException(1003, "execute OOM");
                if (c.getDownloadInfo() != null) {
                    i = c.getDownloadInfo().getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend2, downloadInfo2, baseException2, i);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                int keyAt = this.a.keyAt(i);
                if (!this.a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.a.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar != null) {
            synchronized (d.class) {
                try {
                    if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                        int indexOfValue = this.a.indexOfValue(cVar);
                        if (indexOfValue >= 0) {
                            this.a.removeAt(indexOfValue);
                        }
                    } else {
                        this.a.remove(cVar.e());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            boolean z = false;
            if (this.a != null) {
                if (this.a.size() > 0) {
                    c cVar = this.a.get(i);
                    if (cVar != null && cVar.d()) {
                        z = true;
                    }
                    return z;
                }
            }
            return false;
        }
    }

    public c b(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.a.get(i);
            if (cVar == null) {
                return null;
            }
            cVar.b();
            c(cVar);
            this.a.remove(i);
            return cVar;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future g;
        if (cVar != null) {
            try {
                ExecutorService p = b.p();
                DownloadTask c = cVar.c();
                if (!(c == null || c.getDownloadInfo() == null)) {
                    int executorGroup = c.getDownloadInfo().getExecutorGroup();
                    if (executorGroup == 3) {
                        p = b.n();
                    } else if (executorGroup == 4) {
                        p = b.o();
                    }
                }
                if (p != null && (p instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) p).remove(cVar);
                    if (a.a(cVar.e()).b("pause_with_interrupt", false) && (g = cVar.g()) != null) {
                        g.cancel(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(this.a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.a.get(i);
        if (cVar != null) {
            cVar.c(j);
        }
    }
}
