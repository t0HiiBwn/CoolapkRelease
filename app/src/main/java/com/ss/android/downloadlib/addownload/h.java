package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.a.q;
import com.ss.android.a.a.b.d;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.h.i;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.l;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadHelper */
public class h implements l.a {
    private long a;
    private e b;
    private boolean c = false;
    private final l d = new l(Looper.getMainLooper(), this);
    private b e;

    /* compiled from: DownloadHelper */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    @Override // com.ss.android.downloadlib.h.l.a
    public void a(Message message) {
    }

    public void a(long j) {
        this.a = j;
        e e2 = f.a().e(j);
        this.b = e2;
        if (e2.w()) {
            k.b();
        }
    }

    public void a(DownloadInfo downloadInfo) {
        this.c = false;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.e = null;
        }
    }

    boolean a(Context context, int i, boolean z) {
        if (k.a(this.b.b)) {
            com.ss.android.downloadad.a.b.b d2 = f.a().d(this.b.a);
            if (d2 != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(d2.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.b);
        } else if (!a(i) || TextUtils.isEmpty(this.b.b.v()) || k.i().optInt("disable_market") == 1) {
            return false;
        } else {
            return com.ss.android.downloadlib.b.a.a(this.b, i);
        }
    }

    private boolean a(int i) {
        if (this.b.d.b() == 2 && i == 2) {
            return true;
        }
        if (this.b.d.b() == 2 && i == 1 && k.i().optInt("disable_lp_if_market", 0) == 1) {
            return true;
        }
        return false;
    }

    boolean a(boolean z) {
        return !z && this.b.d.b() == 1;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        return this.b.b != null && !TextUtils.isEmpty(this.b.b.v()) && !TextUtils.isEmpty(this.b.b.a());
    }

    private boolean e() {
        return this.b.d.d();
    }

    void a(final q qVar) {
        if (!TextUtils.isEmpty(this.b.b.n())) {
            String n = this.b.b.n();
            if (n.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                qVar.a();
                return;
            }
            try {
                if (n.startsWith(k.a().getExternalCacheDir().getParent())) {
                    qVar.a();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        b(new q() {
            /* class com.ss.android.downloadlib.addownload.h.AnonymousClass1 */

            @Override // com.ss.android.a.a.a.q
            public void a() {
                qVar.a();
            }

            @Override // com.ss.android.a.a.a.q
            public void a(String str) {
                k.d().a(1, k.a(), h.this.b.b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.e.a.a().b(h.this.a, 1);
                qVar.a(str);
            }
        });
    }

    private void b(final q qVar) {
        if (!i.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            i.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new i.a() {
                /* class com.ss.android.downloadlib.addownload.h.AnonymousClass2 */

                @Override // com.ss.android.downloadlib.h.i.a
                public void a() {
                    q qVar = qVar;
                    if (qVar != null) {
                        qVar.a();
                    }
                }

                @Override // com.ss.android.downloadlib.h.i.a
                public void a(String str) {
                    q qVar = qVar;
                    if (qVar != null) {
                        qVar.a(str);
                    }
                }
            });
        } else if (qVar != null) {
            qVar.a();
        }
    }

    void a(Message message, com.ss.android.a.a.c.e eVar, Map<Integer, Object> map) {
        if (message != null && message.what == 3) {
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int i = 0;
            if (!(message.arg1 == 1 || message.arg1 == 6 || message.arg1 != 2)) {
                if (downloadInfo.getIsFirstDownload()) {
                    com.ss.android.downloadlib.f.a().a(this.b.b, this.b.d, this.b.c);
                    downloadInfo.setFirstDownload(false);
                }
                com.ss.android.downloadlib.e.a.a().a(downloadInfo);
            }
            eVar.a(downloadInfo);
            j.a(eVar);
            int a2 = c.a(downloadInfo.getStatus());
            long totalBytes = downloadInfo.getTotalBytes();
            if (totalBytes > 0) {
                i = (int) ((downloadInfo.getCurBytes() * 100) / totalBytes);
                b bVar = this.e;
                if (bVar != null) {
                    bVar.a(downloadInfo);
                    this.e = null;
                }
            }
            for (d dVar : a(map)) {
                if (a2 != 1) {
                    if (a2 == 2) {
                        dVar.b(eVar, j.a(downloadInfo.getId(), i));
                    } else if (a2 == 3) {
                        if (downloadInfo.getStatus() == -4) {
                            dVar.a();
                        } else if (downloadInfo.getStatus() == -1) {
                            dVar.a(eVar);
                        } else if (downloadInfo.getStatus() == -3) {
                            if (k.a(this.b.b)) {
                                dVar.b(eVar);
                            } else {
                                dVar.c(eVar);
                            }
                        }
                    }
                } else if (downloadInfo.getStatus() != 11) {
                    dVar.a(eVar, j.a(downloadInfo.getId(), i));
                } else {
                    for (com.ss.android.a.a.b.e eVar2 : b(map)) {
                        eVar2.a(downloadInfo);
                    }
                }
            }
        }
    }

    void b(DownloadInfo downloadInfo) {
        if (i.a(this.b.b) && !this.c) {
            com.ss.android.downloadlib.e.a.a().a("file_status", (downloadInfo == null || !k.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.b);
            this.c = true;
        }
    }

    void a() {
        if (this.e == null) {
            this.e = new b() {
                /* class com.ss.android.downloadlib.addownload.h.AnonymousClass3 */

                @Override // com.ss.android.downloadlib.addownload.h.b
                public void a(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.e.a.a().a(h.this.a, 2, downloadInfo);
                }
            };
        }
    }

    boolean c(DownloadInfo downloadInfo) {
        return d(downloadInfo) || f();
    }

    private boolean d(DownloadInfo downloadInfo) {
        return e(downloadInfo) && !k.a(this.b.b);
    }

    private boolean f() {
        return k.a(this.b.b) && i.a(this.b.d.a());
    }

    private boolean e(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3;
    }

    int a(Context context, IDownloadListener iDownloadListener) {
        if (context == null) {
            return 0;
        }
        Map<String, String> j = this.b.b.j();
        ArrayList arrayList = new ArrayList();
        if (j != null) {
            for (Map.Entry<String, String> entry : j.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a2 = com.ss.android.downloadlib.h.d.a(String.valueOf(this.b.b.d()), this.b.b.c(), this.b.b.k(), String.valueOf(this.b.b.A()));
        com.ss.android.socialbase.downloader.g.a b2 = com.ss.android.downloadlib.h.e.b(this.b.b);
        int F = this.b.b.F();
        if (this.b.b.t() || i.b(this.b.b)) {
            F = 4;
        }
        String a3 = a(b2);
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.b.a(this.b.b.a(), a3));
        if (downloadInfo != null && 3 == this.b.b.A()) {
            downloadInfo.setFirstDownload(true);
            com.ss.android.socialbase.downloader.i.e.a(downloadInfo);
        }
        com.ss.android.socialbase.appdownloader.f f = new com.ss.android.socialbase.appdownloader.f(context, this.b.b.a()).b(this.b.b.b()).a(this.b.b.h()).d(a2).a(arrayList).a(this.b.b.l()).c(this.b.b.m()).b(this.b.b.o()).c(a3).j(this.b.b.w()).g(this.b.b.e()).i(this.b.b.I()).a(this.b.b.f()).a(iDownloadListener).l(this.b.b.q() || b2.a("need_independent_process", 0) == 1).a(this.b.b.D()).b(this.b.b.C()).f(this.b.b.v()).d(1000).e(100).a(com.ss.android.downloadlib.h.e.a(this.b.b)).i(true).j(true).b(b2.a("retry_count", 5)).c(b2.a("backup_url_retry_count", 0)).j(true).m(b2.a("need_head_connection", 1) == 1).d(b2.a("need_https_to_http_retry", 0) == 1).h(b2.a("need_chunk_downgrade_retry", 1) == 1).g(b2.a("need_retry_delay", 0) == 1).h(b2.c("retry_delay_time_array")).k(b2.a("need_reuse_runnable", 0) == 1).a(d.a(this.b.b.a(), this.b.b.p())).a(d.a(this.b.b.p())).f(F);
        if (!TextUtils.isEmpty(this.b.b.i())) {
            f.e(this.b.b.i());
        } else {
            f.e("application/vnd.android.package-archive");
        }
        if (b2.a("notification_opt_2", 0) == 1) {
            f.a(false);
            f.b(true);
        }
        com.ss.android.downloadlib.addownload.c.a aVar = null;
        if (b2.a("clear_space_use_disk_handler", 0) == 1) {
            aVar = new com.ss.android.downloadlib.addownload.c.a();
            f.a(aVar);
        }
        int a4 = i.a(this.b, c(), f);
        if (aVar != null) {
            aVar.a(a4);
        }
        return a4;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (!TextUtils.isEmpty(this.b.b.n())) {
            return this.b.b.n();
        }
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(k.a(), this.b.b.a());
        boolean b2 = i.b("android.permission.WRITE_EXTERNAL_STORAGE");
        String b3 = b();
        if (a2 != null && !TextUtils.isEmpty(a2.getSavePath())) {
            String savePath = a2.getSavePath();
            if (b2 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(b3) && savePath.startsWith(b3)) {
                    return savePath;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.b.L()).cancel(a2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(b2 ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.a().a("label_external_permission", jSONObject, this.b);
        String str = null;
        try {
            str = c.b();
        } catch (Exception unused) {
        }
        int a3 = com.ss.android.downloadlib.h.e.a(aVar);
        if (a3 != 0) {
            if (a3 == 4 || (!b2 && a3 == 2)) {
                File filesDir = k.a().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((a3 == 3 || (!b2 && a3 == 1)) && !TextUtils.isEmpty(b3)) {
                return b3;
            }
        }
        return str;
    }

    public String b() {
        File externalFilesDir = k.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    void a(DownloadInfo downloadInfo, boolean z) {
        if (this.b.b != null && downloadInfo != null && downloadInfo.getId() != 0) {
            int status = downloadInfo.getStatus();
            if (status == -1 || status == -4) {
                com.ss.android.downloadlib.e.a.a().a(this.a, 2);
            } else if (i.a(this.b.b)) {
                com.ss.android.downloadlib.e.a.a().a(this.a, 2);
            } else if (z && com.ss.android.downloadlib.e.c.a().c() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.e.a.a().a(this.a, 2);
            }
            switch (status) {
                case -4:
                case -1:
                    a();
                    f.a().a(new com.ss.android.downloadad.a.b.b(this.b.b, this.b.c, this.b.d, downloadInfo.getId()));
                    return;
                case -3:
                    if (k.a(this.b.b)) {
                        k.b();
                        return;
                    }
                    com.ss.android.downloadlib.e.a.a().a(this.a, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.e.c.a().b() && !com.ss.android.downloadlib.e.c.a().b(this.a, this.b.b.u())) {
                        com.ss.android.downloadlib.e.a.a().a(this.a, 2);
                        return;
                    }
                    return;
                case -2:
                    com.ss.android.downloadlib.e.a.a().a(this.a, 4, downloadInfo);
                    if (z && com.ss.android.downloadlib.e.c.a().b() && !com.ss.android.downloadlib.e.c.a().b(this.a, this.b.b.u())) {
                        com.ss.android.downloadlib.e.a.a().a(this.a, 2);
                        return;
                    }
                    return;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    com.ss.android.downloadlib.e.a.a().a(this.a, 3, downloadInfo);
                    return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    void a(DownloadInfo downloadInfo, com.ss.android.a.a.c.e eVar, List<d> list) {
        int i;
        if (!list.isEmpty()) {
            if (downloadInfo == null || eVar == null) {
                for (d dVar : list) {
                    dVar.a();
                }
                return;
            }
            int i2 = 0;
            try {
                if (downloadInfo.getTotalBytes() > 0) {
                    i = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
                    if (i >= 0) {
                        i2 = i;
                    }
                    eVar.a(downloadInfo);
                    j.a(eVar);
                    for (d dVar2 : list) {
                        switch (downloadInfo.getStatus()) {
                            case -4:
                            case 0:
                                if (k.a(this.b.b)) {
                                    eVar.b = -3;
                                    dVar2.b(eVar);
                                    break;
                                } else {
                                    dVar2.a();
                                    break;
                                }
                            case -3:
                                if (k.a(this.b.b)) {
                                    dVar2.b(eVar);
                                    break;
                                } else {
                                    dVar2.c(eVar);
                                    break;
                                }
                            case -2:
                                dVar2.b(eVar, j.a(downloadInfo.getId(), i2));
                                break;
                            case -1:
                                dVar2.a(eVar);
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 7:
                            case 8:
                                dVar2.a(eVar, j.a(downloadInfo.getId(), i2));
                                break;
                            case 11:
                                if (dVar2 instanceof com.ss.android.a.a.b.e) {
                                    ((com.ss.android.a.a.b.e) dVar2).a(downloadInfo);
                                    break;
                                } else {
                                    dVar2.a(eVar, j.a(downloadInfo.getId(), i2));
                                    break;
                                }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i = 0;
            if (i >= 0) {
            }
            eVar.a(downloadInfo);
            j.a(eVar);
            while (r9.hasNext()) {
            }
        }
    }

    /* compiled from: DownloadHelper */
    static class a extends com.ss.android.socialbase.downloader.depend.a {
        private l a;

        a(l lVar) {
            this.a = lVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            a(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            a(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            a(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            a(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            a(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            a(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            a(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.s
        public void a(DownloadInfo downloadInfo) {
            a(downloadInfo, 11);
        }

        private void a(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.a.sendMessage(obtain);
        }
    }

    public static List<d> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof d) {
                    arrayList.add((d) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof d) {
                        arrayList.add((d) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<com.ss.android.a.a.b.e> b(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.a.a.b.e) {
                    arrayList.add((com.ss.android.a.a.b.e) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.a.a.b.e) {
                        arrayList.add((com.ss.android.a.a.b.e) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }
}
