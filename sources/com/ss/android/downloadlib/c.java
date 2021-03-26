package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* compiled from: BaseDownloadMonitorListener */
public class c implements h {
    private static String a = "c";
    private Handler b = new Handler(Looper.getMainLooper());

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        r8 = com.ss.android.downloadlib.addownload.b.f.a().a(r0.b());
     */
    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
        b a2;
        final com.ss.android.a.a.b.c a3;
        if (downloadInfo != null && (a2 = f.a().a(downloadInfo)) != null) {
            if (i == -1) {
                BaseException baseException2 = null;
                if (baseException != null) {
                    try {
                        if (a.a(downloadInfo.getId()).a("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                            this.b.post(new Runnable() {
                                /* class com.ss.android.downloadlib.c.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    k.d().a(5, k.a(), null, "无网络，请检查网络设置", null, 0);
                                }
                            });
                        }
                        if (e.g(baseException)) {
                            if (k.l() != null) {
                                k.l().a(a2.b());
                            }
                            com.ss.android.downloadlib.e.a.a().a("download_failed_for_space", a2);
                            if (!a2.P()) {
                                com.ss.android.downloadlib.e.a.a().a("download_can_restart", a2);
                                a(downloadInfo);
                            }
                            if ((k.l() == null || !k.l().d()) && a3 != null && a3.k()) {
                                final a a4 = a.a(downloadInfo.getId());
                                if (a4.a("show_no_enough_space_toast", 0) == 1) {
                                    this.b.post(new Runnable() {
                                        /* class com.ss.android.downloadlib.c.AnonymousClass2 */

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            k.d().a(2, k.a(), a3, a4.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                        }
                                    });
                                }
                            }
                        }
                        baseException2 = new BaseException(baseException.getErrorCode(), com.ss.android.downloadlib.h.k.a(baseException.getMessage(), k.i().optInt("exception_msg_length", 500)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                com.ss.android.downloadlib.e.a.a().b(downloadInfo, baseException2);
                f.a().a(downloadInfo, baseException, "");
            } else if (i == -3) {
                a.a(downloadInfo, a2);
            } else if (i == 2001) {
                a.a().a(downloadInfo, a2, 2001);
            } else if (i == 11) {
                a.a().a(downloadInfo, a2, 2000);
                if (!a2.R()) {
                    a(downloadInfo, a2);
                }
            }
        }
    }

    private void a(final DownloadInfo downloadInfo, final b bVar) {
        final long a2 = com.ss.android.downloadlib.h.k.a(Environment.getDataDirectory(), -1);
        long min = Math.min(524288000L, com.ss.android.downloadlib.h.k.a(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (((double) totalBytes) * 2.5d) + ((double) min);
        if (a2 > -1 && totalBytes > -1) {
            double d2 = (double) a2;
            if (d2 < d && d - d2 > ((double) com.ss.android.downloadlib.addownload.e.b())) {
                com.ss.android.downloadlib.addownload.e.a(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.AbstractC0092a() {
            /* class com.ss.android.downloadlib.c.AnonymousClass3 */

            @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
            public void c() {
            }

            @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0092a
            public void b() {
                if (!com.ss.android.downloadlib.h.k.b(bVar)) {
                    long j = a2;
                    if (j > -1 && totalBytes > -1 && ((double) j) < d) {
                        com.ss.android.downloadlib.e.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.e.a("install_no_enough_space"), bVar);
                        if (com.ss.android.downloadlib.addownload.e.a(downloadInfo, ((long) d) - a2)) {
                            com.ss.android.socialbase.downloader.a.a.a().b(this);
                            bVar.g(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.a.a.a().b(this);
            }
        });
    }

    private void a(DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.h.e.f(downloadInfo.getId())) {
            d.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}
