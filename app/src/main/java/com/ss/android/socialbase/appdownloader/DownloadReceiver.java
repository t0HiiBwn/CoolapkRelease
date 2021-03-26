package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

public class DownloadReceiver extends BroadcastReceiver {
    private static final String a = "DownloadReceiver";
    private Handler b = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                c a2 = d.j().a();
                if (action.equals("android.intent.action.BOOT_COMPLETED") && (a2 == null || a2.a())) {
                    if (a.a()) {
                        a.a(a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    if (a.a()) {
                        a.a(a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    b.l().execute(new Runnable() {
                        /* class com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            Uri data = intent.getData();
                            if (data != null) {
                                String schemeSpecificPart = data.getSchemeSpecificPart();
                                d b2 = d.j().b();
                                if (b2 != null) {
                                    b2.a(context, schemeSpecificPart);
                                }
                                List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                                if (successedDownloadInfosWithMimeType != null) {
                                    for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                                        if (downloadInfo != null && c.a(downloadInfo, schemeSpecificPart)) {
                                            ab downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                            if (downloadNotificationEventListener != null && e.f(downloadNotificationEventListener.a())) {
                                                downloadNotificationEventListener.a(9, downloadInfo, schemeSpecificPart, "");
                                            }
                                            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                                            boolean z = false;
                                            if (e != null) {
                                                e.a((BaseException) null, false);
                                            }
                                            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_queue_enable", 0) == 1) {
                                                z = true;
                                            }
                                            if (z) {
                                                h.a().a(downloadInfo, schemeSpecificPart);
                                            }
                                            DownloadReceiver.this.b.postDelayed(new Runnable() {
                                                /* class com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.AnonymousClass1 */

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    b.l().execute(new Runnable() {
                                                        /* class com.ss.android.socialbase.appdownloader.DownloadReceiver.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            try {
                                                                if (downloadInfo.isSavePathRedirected()) {
                                                                    e.b(downloadInfo);
                                                                }
                                                            } catch (Throwable th) {
                                                                th.printStackTrace();
                                                            }
                                                        }
                                                    });
                                                }
                                            }, 1000);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private void a(Context context, String str) {
        if (b.F()) {
            try {
                Intent intent = new Intent(context, DownloadHandlerService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
