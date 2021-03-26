package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.constants.h;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.c;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: AbsDownloadEngine */
public abstract class a implements g.a {
    protected final g a = new g(Looper.getMainLooper(), this);
    private final SparseArray<DownloadTask> b = new SparseArray<>();
    private final SparseArray<DownloadTask> c = new SparseArray<>();
    private final SparseArray<DownloadTask> d = new SparseArray<>();
    private final SparseArray<DownloadTask> e = new SparseArray<>();
    private final SparseArray<DownloadTask> f = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.i.g<Integer, DownloadTask> g = new com.ss.android.socialbase.downloader.i.g<>();
    private final SparseArray<Long> h = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> i = new LinkedBlockingDeque<>();
    private final i j = b.x();

    protected abstract List<Integer> a();

    public abstract void a(int i2, long j2);

    protected abstract void a(int i2, DownloadTask downloadTask);

    public abstract void a(c cVar);

    public abstract boolean a(int i2);

    protected abstract void b(int i2);

    protected abstract c c(int i2);

    protected a() {
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i2;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTask2;
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.isEntityInvalid()) {
                z monitorDepend = downloadTask.getMonitorDepend();
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
                return;
            }
            boolean z2 = false;
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) != 1 || e.c(b.L()) || downloadInfo.isFirstDownload()) {
                int id = downloadInfo.getId();
                if (z) {
                    a(downloadInfo);
                }
                synchronized (this.d) {
                    if (this.d.get(id) != null) {
                        this.d.remove(id);
                    }
                }
                synchronized (this.c) {
                    if (this.c.get(id) != null) {
                        this.c.remove(id);
                    }
                }
                synchronized (this.e) {
                    if (this.e.get(id) != null) {
                        this.e.remove(id);
                    }
                }
                synchronized (this.f) {
                    if (this.f.get(id) != null) {
                        this.f.remove(id);
                    }
                }
                if (!a(id) || downloadInfo.canReStartAsyncTask()) {
                    if (downloadInfo.canReStartAsyncTask()) {
                        downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
                    }
                    if (com.ss.android.socialbase.downloader.i.a.a(32768)) {
                        synchronized (this.g) {
                            downloadTask2 = (DownloadTask) this.g.remove(Integer.valueOf(id));
                        }
                        if (downloadTask2 != null) {
                            downloadTask.copyListenerFromPendingTask(downloadTask2);
                        }
                    }
                    synchronized (this.b) {
                        Long l2 = this.h.get(id);
                        long longValue = l2 != null ? l2.longValue() : 0;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (uptimeMillis - longValue < 50) {
                            DownloadTask downloadTask3 = this.b.get(id);
                            if (downloadTask3 == null || (downloadInfo2 = downloadTask3.getDownloadInfo()) == null) {
                                i2 = 0;
                            } else {
                                i2 = downloadInfo2.getStatus();
                                if (i2 == 0 || DownloadStatus.isDownloading(i2)) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "can add listener, oldTaskStatus is :" + i2);
                                if (i2 >= 0 && i2 < 2) {
                                    downloadTask.addListenerToDownloadingSameTask();
                                } else if (downloadInfo.isAddListenerToSameTask()) {
                                    downloadTask.addListenerToDownloadingSameTask();
                                } else {
                                    com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "has another same task within 50 milliseconds and addListenerToSameTask is false"), downloadInfo.getStatus());
                                    this.b.put(id, downloadTask);
                                    this.h.put(id, Long.valueOf(uptimeMillis));
                                    a(id, downloadTask);
                                }
                            } else {
                                this.b.put(id, downloadTask);
                                this.h.put(id, Long.valueOf(uptimeMillis));
                                a(id, downloadTask);
                            }
                        } else {
                            this.b.put(id, downloadTask);
                            this.h.put(id, Long.valueOf(uptimeMillis));
                            a(id, downloadTask);
                        }
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
                if (downloadInfo.isAddListenerToSameTask()) {
                    downloadTask.addListenerToDownloadingSameTask();
                }
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
                return;
            }
            new com.ss.android.socialbase.downloader.downloader.e(downloadTask, this.a).a(new BaseException(1049, "network_not_available"));
        }
    }

    public void a(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
            if (downloadInfo.getEnqueueType() != f.ENQUEUE_NONE) {
                b(downloadTask);
            } else {
                a(downloadTask, true);
            }
        }
    }

    private void b(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            try {
                synchronized (this.i) {
                    if (this.i.isEmpty()) {
                        a(downloadTask, true);
                        this.i.put(downloadTask);
                    } else if (downloadInfo.getEnqueueType() != f.ENQUEUE_TAIL) {
                        DownloadTask first = this.i.getFirst();
                        if (first.getDownloadId() != downloadTask.getDownloadId() || !a(downloadTask.getDownloadId())) {
                            e(first.getDownloadId());
                            a(downloadTask, true);
                            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                                this.i.putFirst(downloadTask);
                            }
                        }
                    } else if (this.i.getFirst().getDownloadId() != downloadTask.getDownloadId() || !a(downloadTask.getDownloadId())) {
                        Iterator<DownloadTask> it2 = this.i.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                DownloadTask next = it2.next();
                                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                                    it2.remove();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        this.i.put(downloadTask);
                        new com.ss.android.socialbase.downloader.downloader.e(downloadTask, this.a).a();
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public DownloadInfo d(int i2) {
        DownloadInfo b2 = this.j.b(i2);
        if (b2 == null) {
            synchronized (this.b) {
                DownloadTask downloadTask = this.b.get(i2);
                if (downloadTask != null) {
                    b2 = downloadTask.getDownloadInfo();
                }
            }
        }
        return b2;
    }

    public List<DownloadInfo> a(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a2 = this.j.a(str);
        if (!(a2 == null || a2.isEmpty())) {
            return a2;
        }
        synchronized (this.b) {
            arrayList = new ArrayList();
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadTask valueAt = this.b.valueAt(i2);
                if (!(valueAt == null || valueAt.getDownloadInfo() == null || !str.equals(valueAt.getDownloadInfo().getUrl()))) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
        }
        return arrayList;
    }

    public boolean e(int i2) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i2);
        DownloadInfo b2 = this.j.b(i2);
        if (b2 != null && b2.getStatus() == 11) {
            return false;
        }
        synchronized (this.b) {
            b(i2);
        }
        if (b2 == null) {
            synchronized (this.b) {
                DownloadTask downloadTask = this.b.get(i2);
                if (downloadTask != null) {
                    new com.ss.android.socialbase.downloader.downloader.e(downloadTask, this.a).d();
                    return true;
                }
            }
        } else {
            a(b2);
            if (b2.getStatus() == 1) {
                synchronized (this.b) {
                    DownloadTask downloadTask2 = this.b.get(i2);
                    if (downloadTask2 != null) {
                        new com.ss.android.socialbase.downloader.downloader.e(downloadTask2, this.a).d();
                        return true;
                    }
                }
            } else if (DownloadStatus.isDownloading(b2.getStatus())) {
                b2.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public boolean a(int i2, boolean z) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
            downloadTask = o(i2);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.g.a.a(i2).b("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.e(downloadTask, this.a).c();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.g.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            this.a.post(new Runnable() {
                /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i = 0; i < downloadListeners.size(); i++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo = downloadInfo;
                    if (!(downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = downloadListeners2) == null)) {
                        synchronized (sparseArray) {
                            for (int i2 = 0; i2 < downloadListeners2.size(); i2++) {
                                IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i2));
                                if (iDownloadListener2 != null) {
                                    iDownloadListener2.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo b2 = this.j.b(i2);
        if (com.ss.android.socialbase.downloader.i.a.a(65536)) {
            if (b2 != null) {
                b2.setStatus(-4);
            }
        } else if (b2 != null && DownloadStatus.isDownloading(b2.getStatus())) {
            b2.setStatus(-4);
        }
        b(i2, z);
        return true;
    }

    public synchronized boolean f(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
        } else {
            g(i2);
        }
        return true;
    }

    public synchronized boolean g(int i2) {
        DownloadTask downloadTask = this.d.get(i2);
        if (downloadTask == null) {
            downloadTask = this.e.get(i2);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        a(downloadTask);
        return true;
    }

    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != h.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(h.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(int i2, ab abVar) {
        synchronized (this.b) {
            DownloadTask downloadTask = this.b.get(i2);
            if (downloadTask != null) {
                downloadTask.setNotificationEventListener(abVar);
            }
        }
    }

    public synchronized ah h(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized ab i(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized t j(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean k(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.e.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null && b2.canStartRetryDelayTask()) {
                a(new DownloadTask(b2), false);
            }
            return false;
        }
        if (downloadInfo.canStartRetryDelayTask()) {
            a(downloadTask, false);
        }
        return true;
    }

    public synchronized boolean l(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            a(downloadTask);
        }
        return true;
    }

    public synchronized void a(List<String> list) {
        try {
            boolean b2 = com.ss.android.socialbase.downloader.i.a.a(1048576) ? e.b(b.L()) : true;
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                DownloadTask downloadTask = this.d.get(this.d.keyAt(i2));
                if (downloadTask != null) {
                    DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                    if (!(downloadInfo == null || downloadInfo.getMimeType() == null || !list.contains(downloadInfo.getMimeType()))) {
                        if (!downloadInfo.isOnlyWifi() || b2) {
                            downloadInfo.setAutoResumed(true);
                            downloadInfo.setShowNotificationForNetworkResumed(true);
                            a(downloadTask);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return;
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (e.b(b.L())) {
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    DownloadTask downloadTask = this.b.get(this.b.keyAt(i2));
                    if (!(downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null || downloadInfo.getMimeType() == null || !list.contains(downloadInfo.getMimeType()) || !b(downloadInfo))) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        a(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        p reserveWifiStatusListener = Downloader.getInstance(b.L()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.a(downloadInfo, 5, 2);
                        }
                    }
                }
                return;
            }
            return;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void b() {
        List<Integer> a2 = a();
        if (a2 != null) {
            for (Integer num : a2) {
                e(num.intValue());
            }
        }
    }

    public void b(final int i2, final boolean z) {
        DownloadInfo b2 = this.j.b(i2);
        if (b2 != null) {
            a(b2);
        }
        this.a.post(new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        b.a((Runnable) new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i2);
                a.this.d(i2, z);
            }
        }, true);
    }

    /* access modifiers changed from: private */
    public synchronized void d(int i2, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        try {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null) {
                if (z) {
                    e.a(b2);
                } else {
                    e.c(b2.getTempPath(), b2.getTempName());
                }
                b2.erase();
            }
            try {
                this.j.f(i2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            a(i2, -4);
            if (this.d.get(i2) != null) {
                this.d.remove(i2);
            }
            if (this.c.get(i2) != null) {
                this.c.remove(i2);
            }
            synchronized (this.g) {
                this.g.remove(Integer.valueOf(i2));
            }
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(final int i2, final boolean z) {
        DownloadInfo b2 = this.j.b(i2);
        if (b2 != null) {
            a(b2);
        }
        this.a.post(new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        b.a((Runnable) new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i2);
                a.this.e(i2, z);
            }
        }, true);
    }

    /* access modifiers changed from: private */
    public void e(int i2, boolean z) {
        try {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null) {
                e.a(b2, z);
                b2.erase();
            }
            try {
                this.j.d(i2);
                this.j.a(b2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.d.get(i2) != null) {
                this.d.remove(i2);
            }
            if (this.c.get(i2) != null) {
                this.c.remove(i2);
            }
            synchronized (this.g) {
                this.g.remove(Integer.valueOf(i2));
            }
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void m(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.b.get(i2);
        if (!(downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null)) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            a(downloadTask);
        }
    }

    public synchronized boolean n(int i2) {
        boolean z;
        if (i2 != 0) {
            if (!(this.b.get(i2) == null && this.d.get(i2) == null)) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        DownloadTask o = o(i2);
        if (o == null) {
            o = (DownloadTask) this.g.get(Integer.valueOf(i2));
        }
        if (o != null) {
            o.removeDownloadListener(i3, iDownloadListener, gVar, z);
        }
    }

    public synchronized void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        a(i2, i3, iDownloadListener, gVar, z, true);
    }

    public synchronized void a(int i2, int i3, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        DownloadInfo b2;
        DownloadTask o = o(i2);
        if (o != null) {
            o.addDownloadListener(i3, iDownloadListener, gVar, z);
            final DownloadInfo downloadInfo = o.getDownloadInfo();
            if (z2 && downloadInfo != null && !a(i2) && (gVar == com.ss.android.socialbase.downloader.constants.g.MAIN || gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION)) {
                boolean z3 = true;
                if (gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.impls.a.AnonymousClass6 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener == null) {
                                return;
                            }
                            if (downloadInfo.getStatus() == -3) {
                                iDownloadListener.onSuccessed(downloadInfo);
                            } else if (downloadInfo.getStatus() == -1) {
                                iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                            }
                        }
                    });
                }
            }
        } else if (!(!com.ss.android.socialbase.downloader.i.a.a(32768) || (b2 = this.j.b(i2)) == null || b2.getStatus() == -3)) {
            DownloadTask downloadTask = (DownloadTask) this.g.get(Integer.valueOf(i2));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(b2);
                synchronized (this.g) {
                    this.g.put(Integer.valueOf(i2), downloadTask);
                }
            }
            downloadTask.addDownloadListener(i3, iDownloadListener, gVar, z);
        }
    }

    private DownloadTask o(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.d.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.c.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.e.get(i2);
        return downloadTask4 == null ? this.f.get(i2) : downloadTask4;
    }

    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : a()) {
            DownloadInfo d2 = d(num.intValue());
            if (d2 != null && str.equals(d2.getMimeType())) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    private void a(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.g.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void p(int i2) {
        if (!this.i.isEmpty()) {
            synchronized (this.i) {
                DownloadTask first = this.i.getFirst();
                if (first != null && first.getDownloadId() == i2) {
                    this.i.poll();
                }
                if (!this.i.isEmpty()) {
                    DownloadTask first2 = this.i.getFirst();
                    if (first2 != null) {
                        a(first2, true);
                    }
                }
            }
        }
    }

    public synchronized void a(int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                this.c.put(i2, this.b.get(i2));
                this.b.remove(i2);
            } else if (i3 == -4) {
                this.b.remove(i2);
                p(i2);
            } else if (i3 == -3) {
                this.c.put(i2, this.b.get(i2));
                this.b.remove(i2);
                p(i2);
            } else if (i3 != -1) {
                if (i3 == 7) {
                    DownloadTask downloadTask = this.b.get(i2);
                    if (downloadTask != null) {
                        if (this.e.get(i2) == null) {
                            this.e.put(i2, downloadTask);
                        }
                        this.b.remove(i2);
                    }
                    p(i2);
                } else if (i3 == 8) {
                    DownloadTask downloadTask2 = this.b.get(i2);
                    if (downloadTask2 != null && this.f.get(i2) == null) {
                        this.f.put(i2, downloadTask2);
                    }
                    p(i2);
                }
            }
        }
        DownloadTask downloadTask3 = this.b.get(i2);
        if (downloadTask3 != null) {
            if (this.d.get(i2) == null) {
                this.d.put(i2, downloadTask3);
            }
            this.b.remove(i2);
        }
        p(i2);
    }

    @Override // com.ss.android.socialbase.downloader.h.g.a
    public void a(Message message) {
        int i2 = message.arg1;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (a.class) {
            DownloadTask downloadTask = this.b.get(i2);
            if (downloadTask != null) {
                a(message.what, baseException, downloadTask);
                a(i2, message.what);
            }
        }
    }

    public void b(int i2, long j2) {
        DownloadInfo b2 = this.j.b(i2);
        if (b2 != null) {
            b2.setThrottleNetSpeed(j2);
        }
        a(i2, j2);
    }
}
