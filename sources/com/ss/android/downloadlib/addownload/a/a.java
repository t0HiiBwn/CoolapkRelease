package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.ss.android.a.a.c.c;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: AdDownloadDialogManager */
public class a {
    private static final String a = "a";
    private static a b;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> c;
    private boolean d = false;
    private String e;
    private b f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* compiled from: AdDownloadDialogManager */
    public interface AbstractC0095a {
        void a();
    }

    private a() {
        b bVar = new b();
        this.f = bVar;
        this.c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, AbstractC0095a aVar) {
        if (downloadInfo == null) {
            try {
                if (this.c.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null) {
            if (!activity.isFinishing()) {
                boolean z2 = true;
                if (downloadInfo == null || !this.c.isEmpty()) {
                    long j = 0;
                    if (downloadInfo != null) {
                        j = new File(downloadInfo.getTargetFilePath()).lastModified();
                    }
                    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = this.c;
                    ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            z2 = false;
                            break;
                        }
                        com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                        if (previous != null) {
                            if (k.d(com.ss.android.downloadlib.addownload.k.a(), previous.d)) {
                                continue;
                            } else if (k.a(previous.g)) {
                                if (new File(previous.g).lastModified() >= j) {
                                    a(activity, previous, z, aVar);
                                } else {
                                    a(activity, new com.ss.android.downloadlib.addownload.b.a((long) downloadInfo.getId(), 0, 0, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, aVar);
                                }
                            }
                        }
                    }
                    String str = a;
                    j.a(str, "tryShowInstallDialog isShow:" + z2, null);
                    return z2;
                }
                a(activity, new com.ss.android.downloadlib.addownload.b.a((long) downloadInfo.getId(), 0, 0, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, aVar);
                return true;
            }
        }
        return false;
    }

    public boolean a(Activity activity, boolean z, AbstractC0095a aVar) {
        if (com.ss.android.downloadlib.addownload.k.i().optInt("disable_install_app_dialog") == 1 || this.d) {
            return false;
        }
        return a(activity, a(activity), z, aVar);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, AbstractC0095a aVar2) {
        this.c.clear();
        a(context, aVar, aVar2, z);
        this.d = true;
        g.a(context).c();
        this.f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        j.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            long b2 = g.a(context).b();
            if (!(com.ss.android.downloadlib.addownload.k.i().optInt("enable_miniapp_dialog", 0) == 0 || (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) == null)) {
                if (!successedDownloadInfosWithMimeType.isEmpty()) {
                    long j = 0;
                    for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                        if (downloadInfo2 != null) {
                            if (!k.d(context, downloadInfo2.getPackageName())) {
                                if (k.a(downloadInfo2.getTargetFilePath())) {
                                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                                    if (lastModified >= b2) {
                                        if (downloadInfo2.getExtra() != null) {
                                            try {
                                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                                    downloadInfo = downloadInfo2;
                                                    j = lastModified;
                                                }
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return downloadInfo;
                }
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.c.size(); i++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.c.get(i);
            if (aVar != null && aVar.b == j2) {
                this.c.set(i, new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
                this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
                return;
            }
        }
        this.c.add(new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
        this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0038: APUT  (r3v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r4v2 java.lang.String) */
    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final AbstractC0095a aVar2, boolean z) {
        String str;
        final b d2 = f.a().d(aVar.b);
        if (d2 == null) {
            k.b();
            return;
        }
        com.ss.android.a.a.a.k d3 = com.ss.android.downloadlib.addownload.k.d();
        c.a a2 = new c.a(context).a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.e) ? "刚刚下载的应用" : aVar.e;
        c.a c2 = a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装");
        if (z) {
            str = "暂不安装";
        } else {
            str = String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes));
        }
        d3.b(c2.d(str).a(false).a(k.a(context, aVar.g)).a(new c.b() {
            /* class com.ss.android.downloadlib.addownload.a.a.AnonymousClass1 */

            @Override // com.ss.android.a.a.c.c.b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.a().a("backdialog_install", (com.ss.android.downloadad.a.b.a) d2);
                d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.c.c.b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.a().a("backdialog_exit", (com.ss.android.downloadad.a.b.a) d2);
                AbstractC0095a aVar = aVar2;
                if (aVar != null) {
                    aVar.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.c.c.b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.e.a.a().a("backdialog_show", (com.ss.android.downloadad.a.b.a) d2);
        this.e = aVar.d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.e, str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e = "";
        } else if (TextUtils.equals(this.e, str)) {
            this.e = "";
        }
    }

    public void a(b bVar) {
        if (com.ss.android.downloadlib.addownload.k.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Y() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
