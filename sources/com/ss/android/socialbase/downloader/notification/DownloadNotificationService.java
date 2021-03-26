package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;

public class DownloadNotificationService extends Service {
    private static final String a = "DownloadNotificationService";
    private static int b = -1;
    private static int c = -1;
    private static boolean d = true;
    private static boolean e = false;
    private static volatile long f = 0;
    private static volatile long g = 0;
    private static boolean h = false;
    private static long i = 900;
    private HandlerThread j;
    private Handler k;
    private final SparseArray<Notification> l = new SparseArray<>(2);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        b.a(this);
        a c2 = a.c();
        int a2 = c2.a("download_service_foreground", 0);
        if ((a2 == 1 || a2 == 3) && b == -1) {
            b = 0;
        }
        if ((a2 == 2 || a2 == 3) && c == -1) {
            c = 0;
        }
        e = c2.b("non_going_notification_foreground", false);
        h = c2.b("notify_too_fast", false);
        long a3 = c2.a("notification_time_window", 900L);
        i = a3;
        if (a3 < 0 || a3 > 1200) {
            i = 900;
        }
    }

    private void d() {
        if (this.j == null) {
            HandlerThread handlerThread = new HandlerThread("DownloaderNotifyThread");
            this.j = handlerThread;
            handlerThread.start();
            this.k = new Handler(this.j.getLooper());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        HandlerThread handlerThread = this.j;
        if (handlerThread != null) {
            try {
                handlerThread.quit();
            } catch (Throwable unused) {
            }
            this.j = null;
            this.k = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        a(intent);
        return 2;
    }

    private void a(final Intent intent) {
        Handler handler;
        if (intent != null) {
            final String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && (handler = this.k) != null) {
                handler.post(new Runnable() {
                    /* class com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityManager connectivityManager;
                        NetworkInfo activeNetworkInfo;
                        final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                        final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                        if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                            final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                            if (intExtra != 0 && notification != null && notificationManager != null) {
                                if (intExtra2 == 4) {
                                    if (Downloader.getInstance(b.L()).isDownloading(intExtra)) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(b.L()).getDownloadInfo(intExtra);
                                        if (DownloadNotificationService.h) {
                                            if (downloadInfo != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - DownloadNotificationService.g > DownloadNotificationService.i) {
                                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                                downloadInfo.setLastNotifyProgressTime();
                                            }
                                        } else if (downloadInfo != null && downloadInfo.canNotifyProgress()) {
                                            DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                            downloadInfo.setLastNotifyProgressTime();
                                        }
                                    }
                                } else if (intExtra2 == -2 || intExtra2 == -3) {
                                    if (DownloadNotificationService.h) {
                                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                    } else if (DownloadNotificationService.this.k != null) {
                                        DownloadNotificationService.this.k.postDelayed(new Runnable() {
                                            /* class com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass1.AnonymousClass1 */

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                            }
                                        }, intExtra2 == -2 ? 50 : 200);
                                    }
                                } else if (DownloadNotificationService.h) {
                                    DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                } else {
                                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                }
                            }
                        } else if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                            if (intExtra != 0) {
                                DownloadNotificationService.this.b(notificationManager, intExtra);
                            }
                        } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            try {
                                if (e.a((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                                    if (activeNetworkInfo.isConnected()) {
                                        ArrayList arrayList = new ArrayList();
                                        if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.a)) {
                                            arrayList.add(com.ss.android.socialbase.downloader.constants.e.a);
                                        }
                                        arrayList.add("mime_type_plg");
                                        Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                                        if (applicationContext != null) {
                                            Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                            Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.l) {
            int indexOfKey = this.l.indexOfKey(i2);
            if (indexOfKey >= 0 && indexOfKey < this.l.size()) {
                this.l.setValueAt(indexOfKey, notification);
                return;
            }
        }
        long currentTimeMillis = i - (System.currentTimeMillis() - f);
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis > 20000) {
            currentTimeMillis = 20000;
        }
        long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
        g = currentTimeMillis2;
        f = currentTimeMillis2;
        if (currentTimeMillis <= 0) {
            b(notificationManager, i2, notification);
        } else if (this.k != null) {
            synchronized (this.l) {
                this.l.put(i2, notification);
            }
            this.k.postDelayed(new Runnable() {
                /* class com.ss.android.socialbase.downloader.notification.DownloadNotificationService.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    DownloadNotificationService.this.a(notificationManager, i2);
                }
            }, currentTimeMillis);
        }
    }

    /* access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.l) {
            notification = this.l.get(i2);
            this.l.remove(i2);
        }
        if (notification != null) {
            b(notificationManager, i2, notification);
        }
    }

    private boolean a(int i2, Notification notification) {
        int i3;
        int i4;
        if (!d || (i3 = b) == i2 || (i4 = c) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (e && (notification.flags & 2) == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[Catch:{ all -> 0x0080 }] */
    public void b(NotificationManager notificationManager, int i2, Notification notification) {
        if (a(i2, notification)) {
            try {
                boolean z = false;
                boolean z2 = c.a().a(i2) == 1 && !e.c();
                if (z2 || b != 0) {
                    if (z2 && c == 0) {
                    }
                    if (z) {
                        l c2 = c.a().c(i2);
                        if (!c2.g() || c2.b()) {
                            String str = a;
                            com.ss.android.socialbase.downloader.c.a.c(str, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                        } else {
                            String str2 = a;
                            com.ss.android.socialbase.downloader.c.a.c(str2, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                            if (z2) {
                                c = i2;
                            } else {
                                b = i2;
                            }
                            c2.a(i2, notification);
                        }
                    }
                }
                z = true;
                if (z) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((b == i2 || c == i2) && e && (notification.flags & 2) == 0) {
            b(notificationManager, i2);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f < currentTimeMillis) {
                f = currentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4 A[Catch:{ all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    public void b(NotificationManager notificationManager, int i2) {
        boolean z;
        a aVar;
        int a2;
        int i3 = b;
        if (i3 == i2 || c == i2) {
            boolean z2 = true;
            if (i3 == i2) {
                b = 0;
                z = false;
            } else {
                c = 0;
                z = true;
            }
            try {
                l c2 = c.a().c(i2);
                if (!c2.b()) {
                    d = false;
                    com.ss.android.socialbase.downloader.c.a.d(a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
                }
                com.ss.android.socialbase.downloader.c.a.c(a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
                c2.a(false, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                notificationManager.cancel(i2);
            } catch (Throwable unused) {
            }
            if (d) {
                try {
                    SparseArray<a> b2 = b.a().b();
                    if (b2 != null) {
                        int size = b2.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            aVar = b2.valueAt(size);
                            if (!(aVar == null || (a2 = aVar.a()) == i2 || a2 == b || a2 == c || !aVar.i())) {
                                if ((c.a().a(aVar.a()) == 1 && !e.c()) == z) {
                                    break;
                                }
                            }
                            size--;
                        }
                        if (aVar == null) {
                            int a3 = aVar.a();
                            try {
                                notificationManager.cancel(a3);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            if (Downloader.getInstance(this).getStatus(a3) != 1) {
                                z2 = false;
                            }
                            com.ss.android.socialbase.downloader.c.a.c(a, "doCancel, updateNotification id = " + a3);
                            aVar.a((BaseException) null, z2);
                            return;
                        }
                        return;
                    }
                    aVar = null;
                    if (aVar == null) {
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        } else {
            try {
                notificationManager.cancel(i2);
            } catch (Throwable unused2) {
            }
        }
    }
}
