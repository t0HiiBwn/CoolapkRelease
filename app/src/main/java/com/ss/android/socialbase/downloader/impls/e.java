package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.h.c;
import com.ss.android.socialbase.downloader.h.d;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: DefaultDownloadEngine */
public class e extends a {
    private static d b;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService q = b.q();
        if (q != null) {
            q.invokeAll(list);
        }
    }

    public static List<Future> d(List<Runnable> list) {
        ExecutorService q = b.q();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(q.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        b = new d();
    }

    public static Runnable e(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService q = b.q();
                if ((q instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) q).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it2.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                a.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i) {
        DownloadInfo d;
        d dVar = b;
        if (dVar == null || !dVar.a(i) || (d = d(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(d.getStatus())) {
            return true;
        }
        b(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(c cVar) {
        d dVar = b;
        if (dVar != null) {
            dVar.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, DownloadTask downloadTask) {
        if (downloadTask != null) {
            a.b("DownloadTask", "start doDownload for task : " + i);
            b.a(new c(downloadTask, this.a));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        d dVar = b;
        if (dVar != null) {
            dVar.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected c c(int i) {
        d dVar = b;
        if (dVar == null) {
            return null;
        }
        return dVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return b.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        d dVar = b;
        if (dVar != null) {
            dVar.a(i, j);
        }
    }
}
