package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.d;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: RetryScheduler */
public class r implements Handler.Callback, a.AbstractC0092a {
    private static volatile r a;
    private static b i;
    private final Context b = com.ss.android.socialbase.downloader.downloader.b.L();
    private final Handler c = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<a> d = new SparseArray<>();
    private final boolean e;
    private long f;
    private int g = 0;
    private ConnectivityManager h;

    /* compiled from: RetryScheduler */
    public interface b {
        void a(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private r() {
        f();
        this.e = e.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static r a() {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r();
                }
            }
        }
        return a;
    }

    public static void a(b bVar) {
        i = bVar;
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) == 1) {
            com.ss.android.socialbase.downloader.downloader.b.l().execute(new Runnable() {
                /* class com.ss.android.socialbase.downloader.impls.r.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (r.this.b != null && Build.VERSION.SDK_INT >= 21) {
                            r rVar = r.this;
                            rVar.h = (ConnectivityManager) rVar.b.getApplicationContext().getSystemService("connectivity");
                            r.this.h.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() {
                                /* class com.ss.android.socialbase.downloader.impls.r.AnonymousClass1.AnonymousClass1 */

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public void onAvailable(Network network) {
                                    com.ss.android.socialbase.downloader.c.a.b("RetryScheduler", "network onAvailable: ");
                                    r.this.a(1, true);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a) && com.ss.android.socialbase.downloader.constants.e.a.equals(downloadInfo.getMimeType())) {
            a(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), g());
        }
    }

    private void a(DownloadInfo downloadInfo, boolean z, int i2) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            a b2 = b(downloadInfo.getId());
            if (b2.i > b2.c) {
                com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "tryStartScheduleRetry, id = " + b2.a + ", mRetryCount = " + b2.i + ", maxCount = " + b2.c);
                return;
            }
            int errorCode = failedException.getErrorCode();
            if (!e.g(failedException) && !e.h(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
                if (a(b2, errorCode)) {
                    com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "allow error code, id = " + b2.a + ", error code = " + errorCode);
                } else {
                    return;
                }
            }
            b2.j = z;
            synchronized (this.d) {
                if (!b2.f1417l) {
                    b2.f1417l = true;
                    this.g++;
                }
            }
            int d2 = b2.d();
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "tryStartScheduleRetry: id = " + b2.a + ", delayTimeMills = " + d2 + ", mWaitingRetryTasks = " + this.g);
            if (b2.f) {
                if (i2 == 0) {
                    b2.c();
                }
                b bVar = i;
                if (bVar != null) {
                    bVar.a(downloadInfo, (long) d2, z, i2);
                }
                if (this.e) {
                    b2.a(System.currentTimeMillis());
                    b2.b();
                    b2.a();
                }
            } else if (!z) {
                this.c.removeMessages(downloadInfo.getId());
                this.c.sendEmptyMessageDelayed(downloadInfo.getId(), (long) d2);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            a(message.what);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (this.g > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                if (!z) {
                    if (currentTimeMillis - this.f < 10000) {
                        return;
                    }
                }
                this.f = currentTimeMillis;
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "scheduleAllTaskRetry, level = [" + i2 + "], force = [" + z + "]");
            if (z) {
                this.c.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i2;
            obtain.arg2 = z ? 1 : 0;
            this.c.sendMessageDelayed(obtain, 2000);
        }
    }

    private void b(final int i2, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.b.l().execute(new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.r.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                int g;
                try {
                    if (r.this.g > 0 && (g = r.this.g()) != 0) {
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + r.this.g);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<a> arrayList = new ArrayList();
                        synchronized (r.this.d) {
                            for (int i = 0; i < r.this.d.size(); i++) {
                                a aVar = (a) r.this.d.valueAt(i);
                                if (aVar != null && aVar.a(currentTimeMillis, i2, g, z)) {
                                    if (z) {
                                        aVar.c();
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (a aVar2 : arrayList) {
                                r.this.a(aVar2.a, g, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void a(final int i2) {
        com.ss.android.socialbase.downloader.downloader.b.l().execute(new Runnable() {
            /* class com.ss.android.socialbase.downloader.impls.r.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    r rVar = r.this;
                    rVar.a(i2, rVar.g(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, boolean z) {
        a aVar;
        boolean z2;
        p reserveWifiStatusListener;
        boolean z3;
        Context context = this.b;
        if (context != null) {
            synchronized (this.d) {
                aVar = this.d.get(i2);
                if (aVar != null) {
                    z2 = true;
                    if (aVar.f1417l) {
                        aVar.f1417l = false;
                        int i4 = this.g - 1;
                        this.g = i4;
                        if (i4 < 0) {
                            this.g = 0;
                        }
                    }
                } else {
                    return;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i2 + ", retryCount = " + aVar.i + ", mWaitingRetryTasksCount = " + this.g);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            if (downloadInfo == null) {
                c(i2);
                return;
            }
            com.ss.android.socialbase.downloader.c.a.e("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i2);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                c(i2);
            } else if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.b.L()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.a(downloadInfo, 4, 3);
                }
                k w = com.ss.android.socialbase.downloader.downloader.b.w();
                if (w != null) {
                    w.a(Collections.singletonList(downloadInfo), 3);
                }
                c(i2);
            } else if (realStatus == -1) {
                if (i3 != 0) {
                    z3 = true;
                } else if (aVar.f) {
                    z3 = false;
                } else {
                    return;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (z3 && e.g(failedException)) {
                    z3 = a(downloadInfo, failedException);
                }
                aVar.b();
                if (z3) {
                    com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + aVar.a);
                    aVar.a(System.currentTimeMillis());
                    if (z) {
                        aVar.a();
                    }
                    downloadInfo.setRetryScheduleCount(aVar.i);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z) {
                    aVar.a();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z2 = false;
                }
                a(downloadInfo, z2, i3);
            }
        }
    }

    private boolean a(a aVar, int i2) {
        int[] iArr = aVar.g;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private a b(int i2) {
        a aVar = this.d.get(i2);
        if (aVar == null) {
            synchronized (this.d) {
                aVar = this.d.get(i2);
                if (aVar == null) {
                    aVar = d(i2);
                }
                this.d.put(i2, aVar);
            }
        }
        return aVar;
    }

    private void c(int i2) {
        synchronized (this.d) {
            this.d.remove(i2);
        }
    }

    private a d(int i2) {
        int[] iArr;
        boolean z;
        int i3;
        int i4;
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(i2);
        boolean z2 = false;
        int a3 = a2.a("retry_schedule", 0);
        JSONObject d2 = a2.d("retry_schedule_config");
        int i5 = 60;
        if (d2 != null) {
            int optInt = d2.optInt("max_count", 60);
            int optInt2 = d2.optInt("interval_sec", 60);
            int optInt3 = d2.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && i != null && d2.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = a(d2.optString("allow_error_code"));
            i4 = optInt3;
            z = z2;
            i3 = optInt;
            i5 = optInt2;
        } else {
            iArr = null;
            i4 = 60;
            i3 = 60;
            z = false;
        }
        return new a(i2, a3, i3, i5 * 1000, i4 * 1000, z, iArr);
    }

    private int[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                iArr[i2] = Integer.parseInt(split[i2]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
    public void b() {
        a(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
    public void c() {
        a(3, false);
    }

    public void d() {
        a(2, true);
    }

    public void e() {
        a(5, false);
    }

    /* access modifiers changed from: private */
    public int g() {
        try {
            if (this.h == null) {
                this.h = (ConnectivityManager) this.b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.h.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType() == 1 ? 2 : 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean a(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        long j2;
        try {
            j = e.d(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            j = 0;
        }
        if (baseException instanceof d) {
            j2 = ((d) baseException).b();
        } else {
            j2 = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j < j2) {
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (a2.a("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int a3 = a2.a("space_fill_min_keep_mb", 100);
                    if (a3 > 0) {
                        long j3 = j - (((long) a3) * 1048576);
                        com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "retry schedule: available = " + e.a(j) + "MB, minKeep = " + a3 + "MB, canDownload = " + e.a(j3) + "MB");
                        if (j3 <= 0) {
                            com.ss.android.socialbase.downloader.c.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (a2.a("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    /* compiled from: RetryScheduler */
    private static class a {
        final int a;
        final int b;
        final int c;
        final int d;
        final int e;
        final boolean f;
        final int[] g;
        private int h;
        private int i;
        private boolean j;
        private long k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f1417l;

        a(int i2, int i3, int i4, int i5, int i6, boolean z, int[] iArr) {
            i5 = i5 < 3000 ? 3000 : i5;
            i6 = i6 < 5000 ? 5000 : i6;
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = z;
            this.g = iArr;
            this.h = i5;
        }

        boolean a(long j2, int i2, int i3, boolean z) {
            if (!this.f1417l) {
                com.ss.android.socialbase.downloader.c.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.b < i2 || this.i >= this.c) {
                return false;
            } else {
                if (this.j && i3 != 2) {
                    return false;
                }
                if (z || j2 - this.k >= ((long) this.d)) {
                    return true;
                }
                return false;
            }
        }

        synchronized void a() {
            this.h += this.e;
        }

        synchronized void a(long j2) {
            this.k = j2;
        }

        synchronized void b() {
            this.i++;
        }

        void c() {
            this.h = this.d;
        }

        int d() {
            return this.h;
        }
    }
}
