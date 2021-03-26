package com.ss.android.socialbase.appdownloader.e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: AppNotificationItem */
public class a extends com.ss.android.socialbase.downloader.notification.a {
    private final Context b;
    private final Resources c;
    private String d;
    private String e;
    private String f;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = applicationContext.getResources();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        super.a(downloadInfo);
        this.e = downloadInfo.getSavePath();
        this.d = downloadInfo.getName();
        this.f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        if (this.b != null) {
            try {
                this.a = b(baseException, z);
                a(this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0569  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0573  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x05a4  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x05ae  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x05c6  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05cd  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015b  */
    private Notification b(BaseException baseException, boolean z) {
        boolean z2;
        String d2;
        RemoteViews j;
        boolean z3;
        String str;
        String str2;
        String str3;
        boolean z4;
        int i;
        String str4;
        int i2;
        int i3;
        int i4;
        int i5;
        int e2 = e();
        int a = c.a(e2);
        if (a == 0) {
            return null;
        }
        NotificationCompat.Builder k = k();
        k.setWhen(f());
        int a2 = a();
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(a2);
        if (Build.VERSION.SDK_INT >= 24 && a3.a("set_notification_group", 0) == 1) {
            k.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            k.setGroupSummary(false);
        }
        int a4 = a(a, a2);
        if (a4 != 0) {
            k.setSmallIcon(a4);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (a == 1 || a == 4 || a == 2) {
            k.setContentIntent(a(str5, a, a2));
            k.setOngoing(a == 1 || a == 4);
            k.setAutoCancel(false);
        } else if (a == 3) {
            k.setOngoing(false);
            k.setAutoCancel(true);
            if (!(e2 == -1 || e2 == -4)) {
                if (e2 == -3 && a3.a("notification_click_install_auto_cancel", 1) == 0) {
                    k.setAutoCancel(false);
                    if (h() > 0) {
                        k.setOngoing(false);
                        str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                        z2 = false;
                        k.setContentIntent(a(str5, a, a2));
                        k.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a, a2));
                        long b2 = b();
                        long c2 = c();
                        int i6 = c2 > 0 ? (int) ((b2 * 100) / c2) : 0;
                        d2 = d();
                        if (TextUtils.isEmpty(d2)) {
                            d2 = this.c.getString(i.b("tt_appdownloader_download_unknown_title"));
                        }
                        j = j();
                        int k2 = e.k();
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
                            j.setOnClickPendingIntent(k2, a("android.ss.intent.action.DOWNLOAD_CLICK_BTN", a, a2));
                        }
                        z3 = z2;
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
                            j.setInt(k2, "setBackgroundResource", e.s());
                            j.setTextColor(k2, -1);
                        }
                        j.setTextViewText(e.m(), d2);
                        int a5 = a(a2);
                        j.setViewVisibility(a5, 0);
                        j.setProgressBar(a5, 100, i6, z);
                        int l = e.l();
                        if (a4 != 0) {
                            j.setImageViewResource(l, a4);
                        }
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
                            Bitmap a6 = c.a().a(a2);
                            if (a6 != null) {
                                j.setInt(l, "setBackgroundColor", 0);
                                j.setImageViewBitmap(l, a6);
                            } else {
                                j.setInt(l, "setBackgroundResource", e.s());
                            }
                        }
                        str = "";
                        if (a != 1 || a == 4) {
                            str = c.a(b()) + "/" + c.a(c());
                            if (a != 1) {
                                i = i.b("tt_appdownloader_notification_prepare");
                            } else if (e() == 11) {
                                i = i.b("tt_appdownloader_notification_waiting_download_complete_handler");
                            } else {
                                i = i.b("tt_appdownloader_notification_downloading");
                            }
                            String string = this.b.getResources().getString(i);
                            String string2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
                            j.setViewVisibility(a(a2), 0);
                            j.setViewVisibility(e.i(), 8);
                            j.setViewVisibility(e.j(), 0);
                            int k3 = e.k();
                            if (c.a(this.f)) {
                                j.setViewVisibility(k3, 8);
                            } else {
                                j.setViewVisibility(k3, 0);
                            }
                            if (a3.b("enable_notification_ui") >= 2) {
                                j.setViewVisibility(k3, 8);
                            }
                            str3 = string;
                            str2 = string2;
                        } else if (a == 2) {
                            String str6 = c.a(b()) + "/" + c.a(c());
                            String string3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_pausing"));
                            String string4 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                            if (a3.b("notification_opt_2") != 1) {
                                j.setViewVisibility(e.j(), 0);
                                int a7 = a(a2);
                                if (a3.b("enable_notification_ui") >= 2) {
                                    j.setViewVisibility(a7, 0);
                                } else {
                                    j.setViewVisibility(a7, 8);
                                }
                                j.setViewVisibility(e.i(), 8);
                            } else if (i6 >= a3.a("noti_progress_show_th", 70)) {
                                j.setViewVisibility(a(a2), 0);
                                j.setViewVisibility(e.j(), 0);
                                j.setViewVisibility(e.i(), 8);
                            } else {
                                j.setViewVisibility(a(a2), 8);
                                j.setViewVisibility(e.j(), 8);
                                j.setViewVisibility(e.i(), 0);
                                j.setViewVisibility(e.o(), 8);
                                string3 = this.c.getString(i.b("tt_appdownloader_notification_download_continue"));
                            }
                            int k4 = e.k();
                            if (c.a(this.f)) {
                                j.setViewVisibility(k4, 8);
                            } else {
                                j.setViewVisibility(k4, 0);
                                if (a3.b("enable_notification_ui") >= 2) {
                                    str6 = c.a(b(), false) + "/" + c.a(c(), false);
                                }
                            }
                            str3 = string3;
                            str2 = string4;
                            str = str6;
                        } else if (a == 3) {
                            DownloadInfo downloadInfo = Downloader.getInstance(b.L()).getDownloadInfo(a2);
                            if (e() == -1 || e() == -4) {
                                if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (com.ss.android.socialbase.downloader.i.e.h(baseException) || com.ss.android.socialbase.downloader.i.e.g(baseException))) {
                                    str = c.a(b()) + "/" + c.a(c());
                                }
                                j.setViewVisibility(e.o(), 8);
                                if (baseException != null && baseException.getErrorCode() == 1006) {
                                    str3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_space_failed"));
                                } else if (a(baseException, a3, downloadInfo)) {
                                    if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                                        i3 = i.b("tt_appdownloader_notification_download_waiting_wifi");
                                    } else {
                                        i3 = i.b("tt_appdownloader_notification_download_waiting_net");
                                    }
                                    str3 = this.b.getResources().getString(i3);
                                } else {
                                    str3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_failed"));
                                }
                                str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_restart"));
                                j.setViewVisibility(e.k(), 8);
                                if (a3.b("enable_notification_ui") >= 2 && e() == -1) {
                                    if (com.ss.android.socialbase.downloader.i.e.h(baseException)) {
                                        if (com.ss.android.socialbase.downloader.i.e.b(baseException, downloadInfo)) {
                                            str3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_no_wifi_and_in_net"));
                                            str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                                        } else {
                                            str3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_no_internet_error"));
                                        }
                                    } else if (com.ss.android.socialbase.downloader.i.e.g(baseException)) {
                                        str4 = str;
                                        i2 = 0;
                                        str3 = this.b.getResources().getString(i.b("tt_appdownloader_notification_insufficient_space_error"), c.b(c() - b()));
                                        j.setViewVisibility(a(a2), 8);
                                        j.setViewVisibility(e.i(), i2);
                                        j.setViewVisibility(e.j(), 8);
                                        if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (com.ss.android.socialbase.downloader.i.e.h(baseException) || com.ss.android.socialbase.downloader.i.e.g(baseException))) {
                                            j.setViewVisibility(a(a2), 0);
                                            j.setViewVisibility(e.i(), 8);
                                            j.setViewVisibility(e.j(), 0);
                                            int k5 = e.k();
                                            if (!com.ss.android.socialbase.downloader.i.e.b(baseException, downloadInfo)) {
                                                j.setViewVisibility(k5, 0);
                                                str = c.a(b(), false) + "/" + c.a(c(), false);
                                            } else {
                                                j.setViewVisibility(k5, 8);
                                            }
                                        }
                                        str = str4;
                                    }
                                }
                                str4 = str;
                            } else if (e() == -3) {
                                String a8 = c.a(c());
                                if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                                    i5 = i.b("tt_appdownloader_notification_download_complete_without_install");
                                    if (com.ss.android.socialbase.downloader.downloader.c.a().m(a2) != null) {
                                        i5 = i.b("tt_appdownloader_notification_download_complete_open");
                                    }
                                    i4 = 0;
                                } else if (c.a(this.b, downloadInfo, !a3.b("fix_ui_thread_parser_apk_file", true))) {
                                    i5 = i.b("tt_appdownloader_notification_install_finished_open");
                                    i4 = i.b("tt_appdownloader_notification_download_open");
                                } else {
                                    i5 = i.b("tt_appdownloader_notification_download_complete_with_install");
                                    i4 = i.b("tt_appdownloader_notification_download_install");
                                }
                                str3 = this.c.getString(i5);
                                k.setContentText(str3);
                                if (i4 != 0) {
                                    str = this.c.getString(i4);
                                }
                                if (a3.b("notification_opt_2") == 1) {
                                    j.setTextViewText(e.k(), str);
                                    j.setViewVisibility(e.o(), 8);
                                } else {
                                    j.setViewVisibility(e.k(), 8);
                                }
                                str2 = str;
                                str4 = a8;
                            } else {
                                str3 = str;
                                str2 = str3;
                                str4 = str2;
                            }
                            i2 = 0;
                            j.setViewVisibility(a(a2), 8);
                            j.setViewVisibility(e.i(), i2);
                            j.setViewVisibility(e.j(), 8);
                            j.setViewVisibility(a(a2), 0);
                            j.setViewVisibility(e.i(), 8);
                            j.setViewVisibility(e.j(), 0);
                            int k5 = e.k();
                            if (!com.ss.android.socialbase.downloader.i.e.b(baseException, downloadInfo)) {
                            }
                        } else {
                            str3 = str;
                            str2 = str3;
                        }
                        j.setTextViewText(e.n(), str);
                        j.setTextViewText(e.p(), str3);
                        j.setTextViewText(e.o(), str);
                        j.setTextViewText(e.q(), str3);
                        int k6 = e.k();
                        if (TextUtils.isEmpty(str2)) {
                            j.setViewVisibility(k6, 8);
                        } else {
                            j.setTextViewText(k6, str2);
                        }
                        if (a3.b("notification_opt_2") == 1) {
                            k.setAutoCancel(true);
                            z4 = false;
                            if (a3.a("notification_ongoing", 0) == 1) {
                                k.setOngoing(true);
                                z3 = true;
                            } else {
                                k.setOngoing(false);
                                z3 = false;
                            }
                        } else {
                            z4 = false;
                        }
                        Notification build = k.build();
                        if (z3) {
                            build.flags |= 2;
                            a(true);
                        } else {
                            a(z4);
                        }
                        build.contentView = j;
                        return build;
                    }
                    k.setOngoing(true);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            z2 = true;
            k.setContentIntent(a(str5, a, a2));
            k.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a, a2));
            long b2 = b();
            long c2 = c();
            if (c2 > 0) {
            }
            d2 = d();
            if (TextUtils.isEmpty(d2)) {
            }
            j = j();
            int k2 = e.k();
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
            }
            z3 = z2;
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            }
            j.setTextViewText(e.m(), d2);
            int a5 = a(a2);
            j.setViewVisibility(a5, 0);
            j.setProgressBar(a5, 100, i6, z);
            int l = e.l();
            if (a4 != 0) {
            }
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            }
            str = "";
            if (a != 1) {
            }
            str = c.a(b()) + "/" + c.a(c());
            if (a != 1) {
            }
            String string = this.b.getResources().getString(i);
            String string2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
            j.setViewVisibility(a(a2), 0);
            j.setViewVisibility(e.i(), 8);
            j.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (c.a(this.f)) {
            }
            if (a3.b("enable_notification_ui") >= 2) {
            }
            str3 = string;
            str2 = string2;
            j.setTextViewText(e.n(), str);
            j.setTextViewText(e.p(), str3);
            j.setTextViewText(e.o(), str);
            j.setTextViewText(e.q(), str3);
            int k6 = e.k();
            if (TextUtils.isEmpty(str2)) {
            }
            if (a3.b("notification_opt_2") == 1) {
            }
            Notification build = k.build();
            if (z3) {
            }
            build.contentView = j;
            return build;
        }
        z2 = true;
        long b2 = b();
        long c2 = c();
        if (c2 > 0) {
        }
        d2 = d();
        if (TextUtils.isEmpty(d2)) {
        }
        j = j();
        int k2 = e.k();
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
        }
        z3 = z2;
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
        }
        j.setTextViewText(e.m(), d2);
        int a5 = a(a2);
        j.setViewVisibility(a5, 0);
        j.setProgressBar(a5, 100, i6, z);
        int l = e.l();
        if (a4 != 0) {
        }
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
        }
        str = "";
        if (a != 1) {
        }
        str = c.a(b()) + "/" + c.a(c());
        if (a != 1) {
        }
        String string = this.b.getResources().getString(i);
        String string2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
        j.setViewVisibility(a(a2), 0);
        j.setViewVisibility(e.i(), 8);
        j.setViewVisibility(e.j(), 0);
        int k3 = e.k();
        if (c.a(this.f)) {
        }
        if (a3.b("enable_notification_ui") >= 2) {
        }
        str3 = string;
        str2 = string2;
        j.setTextViewText(e.n(), str);
        j.setTextViewText(e.p(), str3);
        j.setTextViewText(e.o(), str);
        j.setTextViewText(e.q(), str3);
        int k6 = e.k();
        if (TextUtils.isEmpty(str2)) {
        }
        if (a3.b("notification_opt_2") == 1) {
        }
        Notification build = k.build();
        if (z3) {
        }
        build.contentView = j;
        return build;
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        if (baseException == null || ((baseException.getErrorCode() != 1013 && baseException.getErrorCode() != 1049) || downloadInfo == null || !"application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) || aVar.a("notification_text_opt", 0) != 1)) {
            return false;
        }
        return true;
    }

    private RemoteViews j() {
        RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (c.a(this.b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.b.getResources().getColor(e.r()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    private int a(int i, int i2) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("notification_opt_2") == 1) {
            return e.v();
        }
        if (i == 1 || i == 4) {
            return e.t();
        }
        if (i == 2) {
            return e.u();
        }
        if (i == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i, int i2) {
        Intent intent = new Intent(this.b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.b, i2, intent, 134217728);
    }

    private NotificationCompat.Builder k() {
        String i = d.j().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.b);
        }
        if (TextUtils.isEmpty(i)) {
            i = c.b(this.b);
        }
        try {
            if (d.j().k() != null) {
                return d.j().k().a(this.b, i);
            }
            return new NotificationCompat.Builder(this.b, i);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.b);
        }
    }

    private int a(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).b("enable_notification_ui") >= 1) {
            return e.h();
        }
        return e.g();
    }
}
