package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

public class DownloadHandlerService extends Service {
    private static final String a = "DownloadHandlerService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (a.a()) {
            a.b(a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        d b = d.j().b();
        ab downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.g.a.a(intExtra).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            a(this, downloadInfo, b, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.g.a.a(intExtra).a("no_hide_notification", 0) == 0) {
                if (com.ss.android.socialbase.downloader.g.a.a(intExtra).b("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1) {
                    z = false;
                }
                if (!z) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
                    com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(downloadInfo, b, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            b.l().execute(new Runnable() {
                /* class com.ss.android.socialbase.appdownloader.DownloadHandlerService.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(b.L()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void a(Context context, DownloadInfo downloadInfo) {
        if (e.b(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void a(Context context, final d dVar, final DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            final ab downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
            if (dVar != null || downloadNotificationEventListener != null) {
                b.l().execute(new Runnable() {
                    /* class com.ss.android.socialbase.appdownloader.DownloadHandlerService.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        PackageInfo a2;
                        try {
                            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                            if (file.exists()) {
                                try {
                                    if (b.L() == null || (a2 = c.a(downloadInfo, file)) == null) {
                                        str = "";
                                    } else {
                                        str = a2.packageName;
                                    }
                                    d dVar = dVar;
                                    if (dVar != null) {
                                        dVar.a(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                                    }
                                    ab abVar = downloadNotificationEventListener;
                                    if (abVar != null) {
                                        abVar.a(3, downloadInfo, str, "");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a  */
    private void a(DownloadInfo downloadInfo, d dVar, ab abVar) {
        boolean z;
        int id = downloadInfo.getId();
        ah m = c.a().m(id);
        if (m != null) {
            try {
                z = m.a(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
                intent.putExtra("extra_click_download_ids", id);
                intent.addFlags(268435456);
                startActivity(intent);
                com.ss.android.socialbase.downloader.notification.b.a().a(id);
                downloadInfo.updateDownloadTime();
                if (dVar != null) {
                    dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (abVar != null) {
                    abVar.a(7, downloadInfo, "", "");
                    return;
                }
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    private void b(DownloadInfo downloadInfo, d dVar, ab abVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.b.a().a(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (abVar != null) {
            abVar.a(7, downloadInfo, "", "");
        }
    }

    private static void a(Context context, int i, boolean z) {
        boolean z2;
        ah m;
        if (z && (m = c.a().m(i)) != null) {
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo != null) {
                    z2 = m.b(downloadInfo);
                    if (!z2 && c.a(context, i, true) == 0) {
                        Toast.makeText(context, "Open Fail!", 0).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        z2 = false;
        if (!z2) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    public static void a(Context context, DownloadInfo downloadInfo, d dVar, ab abVar) {
        com.ss.android.socialbase.downloader.notification.a e;
        int id = downloadInfo.getId();
        ah m = c.a().m(id);
        if (!"application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) || m == null || !c.a(context, downloadInfo) || !m.c(downloadInfo)) {
            boolean z = false;
            switch (downloadInfo.getStatus()) {
                case -4:
                case -1:
                    if (com.ss.android.socialbase.downloader.g.a.a(id).b("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                        downloadInfo.setOnlyWifi(false);
                    }
                    Downloader.getInstance(context).restart(id);
                    return;
                case -3:
                    a(b.L(), id, true);
                    a(context, dVar, downloadInfo);
                    if (com.ss.android.socialbase.downloader.g.a.a(id).a("notification_click_install_auto_cancel", 1) != 0 || (e = com.ss.android.socialbase.downloader.notification.b.a().e(id)) == null) {
                        z = true;
                    } else {
                        e.g();
                        e.a(-3, null, false, true);
                    }
                    if (z) {
                        com.ss.android.socialbase.downloader.notification.b.a().a(id);
                        return;
                    }
                    return;
                case -2:
                    if (c.a().e(id)) {
                        Downloader.getInstance(context).resume(id);
                    } else {
                        c.a(downloadInfo, true, false);
                    }
                    if (dVar != null) {
                        dVar.a(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                    }
                    if (abVar != null) {
                        abVar.a(6, downloadInfo, "", "");
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    Downloader.getInstance(context).pause(id);
                    a(context, downloadInfo);
                    if (dVar != null) {
                        dVar.a(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                    }
                    if (abVar != null) {
                        abVar.a(5, downloadInfo, "", "");
                        return;
                    }
                    return;
            }
        }
    }
}
