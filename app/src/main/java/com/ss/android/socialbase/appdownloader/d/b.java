package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.c.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultDownloadLaunchHandler */
public class b implements k {
    private List<Integer> a;
    private BroadcastReceiver b;

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<String> a() {
        return c.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(final List<DownloadInfo> list, final int i) {
        if (e.d()) {
            com.ss.android.socialbase.downloader.downloader.b.l().execute(new Runnable() {
                /* class com.ss.android.socialbase.appdownloader.d.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            b(list, i);
        }
    }

    /* access modifiers changed from: private */
    public void b(List<DownloadInfo> list, int i) {
        if (list != null && !list.isEmpty()) {
            g l2 = d.j().l();
            if (l2 != null) {
                l2.a(list);
            }
            Context L = com.ss.android.socialbase.downloader.downloader.b.L();
            if (L != null) {
                boolean b2 = e.b(L);
                for (DownloadInfo downloadInfo : list) {
                    a(L, downloadInfo, b2, i);
                }
                List<Integer> list2 = this.a;
                if (list2 != null && !list2.isEmpty() && this.b == null) {
                    this.b = new BroadcastReceiver() {
                        /* class com.ss.android.socialbase.appdownloader.d.b.AnonymousClass2 */

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (e.b(applicationContext)) {
                                a.b("LaunchResume", "onReceive : wifi connected !!!");
                                com.ss.android.socialbase.downloader.downloader.b.l().execute(new Runnable() {
                                    /* class com.ss.android.socialbase.appdownloader.d.b.AnonymousClass2.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (b.this.a == null) {
                                                return;
                                            }
                                            if (!b.this.a.isEmpty()) {
                                                int size = b.this.a.size();
                                                Integer[] numArr = new Integer[size];
                                                b.this.a.toArray(numArr);
                                                b.this.a.clear();
                                                for (int i = 0; i < size; i++) {
                                                    DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i].intValue());
                                                    if (downloadInfo != null) {
                                                        if (downloadInfo.getRealStatus() != -5) {
                                                            if (downloadInfo.getRealStatus() == -2) {
                                                                if (!downloadInfo.isPauseReserveOnWifi()) {
                                                                }
                                                            }
                                                        }
                                                        b.this.a(applicationContext, downloadInfo, true, 2);
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                try {
                                    applicationContext.unregisterReceiver(b.this.b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                b.this.b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        L.registerReceiver(this.b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.b = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    public void a(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        String str;
        boolean z2;
        int i2;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        g l2;
        if (downloadInfo != null && downloadInfo.isShowNotification()) {
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
                com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                int a3 = a2.a("failed_resume_max_count", 0);
                double a4 = a2.a("failed_resume_max_hours", 72.0d);
                double a5 = a2.a("failed_resume_min_hours", 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                if (downloadInfo.getFailedResumeCount() < a3) {
                    str3 = ", canShowNotification = ";
                    str2 = "LaunchResume";
                    if (((double) (currentTimeMillis - downloadInfo.getLastDownloadTime())) < a4 * 3600000.0d && ((double) (currentTimeMillis - downloadInfo.getLastFailedResumeTime())) > a5 * 3600000.0d) {
                        z3 = true;
                        if (downloadInfo.isPauseReserveOnWifi() && z) {
                            z3 = true;
                        }
                        if (z3) {
                            boolean z5 = a2.a("failed_resume_need_wifi", 1) == 1;
                            boolean z6 = a2.a("failed_resume_need_wait_wifi", 0) == 1;
                            if (z || !z5 || !z6) {
                                z4 = true;
                                c.a(downloadInfo, true, z5);
                                downloadInfo.setLastFailedResumeTime(currentTimeMillis);
                                downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                                downloadInfo.updateSpData();
                                if (downloadInfo.isPauseReserveOnWifi() && z) {
                                    downloadInfo.setDownloadFromReserveWifi(true);
                                    p m = d.j().m();
                                    if (m != null) {
                                        m.a(downloadInfo, 5, i);
                                    }
                                }
                                a.c(str2, "launchResume, name = " + downloadInfo.getTitle() + str3 + z3 + ", downloadResumed = " + z4);
                                l2 = d.j().l();
                                if (l2 != null) {
                                    l2.a(downloadInfo, z4);
                                    return;
                                }
                                return;
                            }
                            if (this.a == null) {
                                this.a = new ArrayList();
                            }
                            int id = downloadInfo.getId();
                            if (!this.a.contains(Integer.valueOf(id))) {
                                this.a.add(Integer.valueOf(id));
                            }
                            downloadInfo.setOnlyWifi(true);
                            r.a().a(downloadInfo);
                        }
                        z4 = false;
                        a.c(str2, "launchResume, name = " + downloadInfo.getTitle() + str3 + z3 + ", downloadResumed = " + z4);
                        l2 = d.j().l();
                        if (l2 != null) {
                        }
                    }
                } else {
                    str3 = ", canShowNotification = ";
                    str2 = "LaunchResume";
                }
                z3 = false;
                z3 = true;
                if (z3) {
                }
                z4 = false;
                a.c(str2, "launchResume, name = " + downloadInfo.getTitle() + str3 + z3 + ", downloadResumed = " + z4);
                l2 = d.j().l();
                if (l2 != null) {
                }
            } else if (realStatus == -3 && a(downloadInfo)) {
                com.ss.android.socialbase.downloader.g.a a6 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                if (!c.a(context, downloadInfo)) {
                    int a7 = a6.a("uninstall_resume_max_count", 0);
                    double a8 = a6.a("uninstall_resume_max_hours", 72.0d);
                    double a9 = a6.a("uninstall_resume_min_hours", 12.0d);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (downloadInfo.getUninstallResumeCount() < a7) {
                        str = "LaunchResume";
                        if (((double) (currentTimeMillis2 - downloadInfo.getLastDownloadTime())) < a8 * 3600000.0d && ((double) (currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > a9 * 3600000.0d) {
                            z2 = true;
                            a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                            if (!z2) {
                                com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                                if (e == null) {
                                    i2 = 1;
                                    com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                                    com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
                                    e = aVar;
                                } else {
                                    i2 = 1;
                                    e.a(downloadInfo);
                                }
                                e.b(downloadInfo.getTotalBytes());
                                e.a(downloadInfo.getTotalBytes());
                                e.a(downloadInfo.getStatus(), null, false, false);
                                downloadInfo.setLastUninstallResumeTime(currentTimeMillis2);
                                downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i2);
                                downloadInfo.updateSpData();
                                return;
                            }
                            return;
                        }
                    } else {
                        str = "LaunchResume";
                    }
                    z2 = false;
                    a.c(str, "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2);
                    if (!z2) {
                    }
                }
            } else if (realStatus != -2) {
            } else {
                if (!downloadInfo.isPauseReserveOnWifi()) {
                    a(downloadInfo, context);
                } else if (z) {
                    c.a(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    g l3 = d.j().l();
                    if (l3 != null) {
                        l3.a(downloadInfo, true);
                    }
                    p m2 = d.j().m();
                    if (m2 != null) {
                        m2.a(downloadInfo, 5, i);
                    }
                } else {
                    if (this.a == null) {
                        this.a = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.a.contains(Integer.valueOf(id2))) {
                        this.a.add(Integer.valueOf(id2));
                    }
                    r.a().a(downloadInfo);
                    a(downloadInfo, context);
                }
            }
        }
    }

    private void a(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        int a3 = a2.a("paused_resume_max_count", 0);
        double a4 = a2.a("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < a3 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < a4 * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.a e = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (e == null) {
                e = new com.ss.android.socialbase.appdownloader.e.a(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.b.a().a(e);
            } else {
                e.a(downloadInfo);
            }
            e.b(downloadInfo.getTotalBytes());
            e.a(downloadInfo.getCurBytes());
            e.a(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("uninstall_can_not_resume_for_force_task", false)) {
            return e.a(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
