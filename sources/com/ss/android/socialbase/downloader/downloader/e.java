package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.constants.h;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.f;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.c;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: DownloadStatusHandler */
public class e {
    private static final String a = "e";
    private final boolean b;
    private DownloadInfo c;
    private final i d;
    private final Handler e;
    private DownloadTask f;
    private SparseArray<IDownloadListener> g;
    private SparseArray<IDownloadListener> h;
    private SparseArray<IDownloadListener> i;
    private boolean j = false;
    private volatile long k = 0;
    private final AtomicLong l = new AtomicLong();
    private boolean m = false;
    private int n;
    private long o;
    private n p;
    private z q;

    public e(DownloadTask downloadTask, Handler handler) {
        this.f = downloadTask;
        j();
        this.e = handler;
        this.d = b.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.b = a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f;
        if (downloadTask != null) {
            this.c = downloadTask.getDownloadInfo();
            this.g = this.f.getDownloadListeners(g.MAIN);
            this.i = this.f.getDownloadListeners(g.NOTIFICATION);
            this.h = this.f.getDownloadListeners(g.SUB);
            this.p = this.f.getDepend();
            this.q = this.f.getMonitorDepend();
        }
    }

    public void a() {
        if (!this.c.canSkipStatusHandler()) {
            this.c.setStatus(1);
            k();
        }
    }

    private void k() {
        ExecutorService l2 = b.l();
        if (l2 != null) {
            l2.execute(new Runnable() {
                /* class com.ss.android.socialbase.downloader.downloader.e.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    e.this.d.i(e.this.c.getId());
                    e.this.a(1, (BaseException) null);
                }
            });
        }
    }

    public void b() {
        if (this.c.canSkipStatusHandler()) {
            this.c.changeSkipStatus();
            return;
        }
        this.d.g(this.c.getId());
        if (this.c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void a(long j2, String str, String str2) {
        this.c.setTotalBytes(j2);
        this.c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.c.getName())) {
            this.c.setName(str2);
        }
        try {
            this.d.a(this.c.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.c.getMinByteIntervalForPostToMainThread(j2);
        this.n = this.c.getMinProgressTimeMsInterval();
        this.j = true;
        r.a().e();
    }

    public boolean a(long j2) {
        this.l.addAndGet(j2);
        this.c.increaseCurBytes(j2);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    public void d() {
        this.c.setStatus(-2);
        try {
            this.d.d(this.c.getId(), this.c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.c.setStatus(-7);
        try {
            this.d.j(this.c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void a(BaseException baseException, boolean z) {
        this.c.setFirstDownload(false);
        this.l.set(0);
        b(baseException, z);
    }

    public void a(b bVar, BaseException baseException, boolean z) {
        this.c.setFirstDownload(false);
        this.l.set(0);
        this.d.h(this.c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    public void a(BaseException baseException) {
        this.c.setFirstDownload(false);
        b(baseException);
    }

    private void b(BaseException baseException) {
        String str = a;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException == null || baseException.getCause() == null || !(baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.d.b(this.c.getId(), this.c.getCurBytes());
            } catch (SQLiteException unused) {
                try {
                    this.d.f(this.c.getId());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            try {
                this.d.f(this.c.getId());
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException c2 = c(baseException);
        this.c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (a.a(this.c.getId()).a("retry_schedule", 0) > 0) {
            r.a().a(this.c);
        }
    }

    private BaseException c(BaseException baseException) {
        Context L;
        if (a.a(this.c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.e.h(baseException) || (L = b.L()) == null || com.ss.android.socialbase.downloader.i.e.c(L)) {
            return baseException;
        }
        return new BaseException(this.c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void f() {
        this.c.setFirstDownload(false);
        if (!this.c.isIgnoreDataVerify() && this.c.getCurBytes() != this.c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        } else if (this.c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new f(1026, "curBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        } else if (this.c.isIgnoreDataVerify() || this.c.getTotalBytes() > 0) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.c.getName() + " onCompleted start save file as target name");
            z zVar = this.q;
            DownloadTask downloadTask = this.f;
            if (downloadTask != null) {
                zVar = downloadTask.getMonitorDepend();
            }
            if (this.c.isNewSaveTempFileEnable()) {
                com.ss.android.socialbase.downloader.i.e.a(this.c, zVar, new aj() {
                    /* class com.ss.android.socialbase.downloader.downloader.e.AnonymousClass2 */

                    @Override // com.ss.android.socialbase.downloader.depend.aj
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.aj
                    public void a(BaseException baseException) {
                        String str = e.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveFileAsTargetName onFailed : ");
                        sb.append(baseException != null ? baseException.getErrorMessage() : "");
                        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
                        e.this.a(baseException);
                    }
                });
            } else {
                com.ss.android.socialbase.downloader.i.e.a(this.c, new aj() {
                    /* class com.ss.android.socialbase.downloader.downloader.e.AnonymousClass3 */

                    @Override // com.ss.android.socialbase.downloader.depend.aj
                    public void a() {
                        e.this.l();
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.aj
                    public void a(BaseException baseException) {
                        String str = e.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveFileAsTargetName onFailed : ");
                        sb.append(baseException != null ? baseException.getErrorMessage() : "");
                        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
                        e.this.a(baseException);
                    }
                });
            }
        } else {
            com.ss.android.socialbase.downloader.c.a.b(a, this.c.getErrorBytesLog());
            a(new f(1044, "TotalBytes is 0, bytes changed with process : " + this.c.getByteInvalidRetryStatus()));
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.c.setFirstSuccess(false);
                this.c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.d.c(this.c.getId(), this.c.getTotalBytes());
                this.d.d(this.c.getId());
                this.d.m(this.c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.e.b(th, "onCompleted")));
        }
    }

    public void g() throws BaseException {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.c(this.c.getId(), this.c.getTotalBytes());
            this.d.d(this.c.getId());
            this.d.a(this.c);
            this.d.m(this.c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.d.c(this.c.getId(), this.c.getTotalBytes());
        this.d.d(this.c.getId());
        this.d.m(this.c.getId());
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.c.getName());
        if (this.b) {
            com.ss.android.socialbase.downloader.i.e.a(this.c, str);
            m();
            this.c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.d.a(this.c);
            return;
        }
        this.d.a(this.c);
        com.ss.android.socialbase.downloader.i.e.a(this.c, str);
        this.c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private void m() throws BaseException {
        List<m> downloadCompleteHandlers = this.f.getDownloadCompleteHandlers();
        if (!downloadCompleteHandlers.isEmpty()) {
            DownloadInfo downloadInfo = this.c;
            a(11, (BaseException) null);
            this.d.a(downloadInfo);
            for (m mVar : downloadCompleteHandlers) {
                try {
                    if (mVar.b(downloadInfo)) {
                        mVar.a(downloadInfo);
                        this.d.a(downloadInfo);
                    }
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new BaseException(1071, th);
                }
            }
        }
    }

    private boolean a(long j2, boolean z) {
        boolean z2 = false;
        if (this.c.getCurBytes() == this.c.getTotalBytes()) {
            try {
                this.d.a(this.c.getId(), this.c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.j) {
            this.j = false;
            this.c.setStatus(4);
        }
        if (this.c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    private boolean b(long j2) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j3 = j2 - this.k;
        if (this.l.get() < this.o && j3 < ((long) this.n)) {
            z = false;
        }
        if (z) {
            this.k = j2;
            this.l.set(0);
        }
        return z;
    }

    private void b(BaseException baseException, boolean z) {
        this.d.h(this.c.getId());
        a(z ? 7 : 5, baseException);
    }

    /* access modifiers changed from: private */
    public void a(int i2, BaseException baseException) {
        a(i2, baseException, true);
    }

    public void h() {
        this.c.setStatus(8);
        this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = b.C();
        if (C != null) {
            C.a(this.c.getId(), 8);
        }
    }

    private void a(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.c.getStatus();
        if (status != -3 || i2 != 4) {
            j();
            if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
                this.c.updateRealDownloadTime(false);
                if (DownloadStatus.isTimeUploadStatus(i2)) {
                    this.c.updateDownloadTime();
                }
            }
            com.ss.android.socialbase.downloader.d.a.a(this.f, baseException, i2);
            if (i2 == 6) {
                this.c.setStatus(2);
            } else if (i2 == -6) {
                this.c.setStatus(-3);
            } else {
                this.c.setStatus(i2);
            }
            if (status == -3 || status == -1) {
                if (this.c.getRetryDelayStatus() == h.DELAY_RETRY_DOWNLOADING) {
                    this.c.setRetryDelayStatus(h.DELAY_RETRY_DOWNLOADED);
                }
                if (this.c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                    this.c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
                }
                if (this.c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                    this.c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
                }
            }
            c.a(i2, this.h, true, this.c, baseException);
            if (i2 != -4) {
                if (!z || this.e == null || (((sparseArray = this.g) == null || sparseArray.size() <= 0) && ((sparseArray2 = this.i) == null || sparseArray2.size() <= 0 || (!this.c.canShowNotification() && !this.c.isAutoInstallWithoutNotification())))) {
                    com.ss.android.socialbase.downloader.impls.a C = b.C();
                    if (C != null) {
                        C.a(this.c.getId(), i2);
                        return;
                    }
                    return;
                }
                this.e.obtainMessage(i2, this.c.getId(), 0, baseException).sendToTarget();
            }
        }
    }
}
