package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.a.q;
import com.ss.android.a.a.a.s;
import com.ss.android.a.a.b.d;
import com.ss.android.a.a.b.g;
import com.ss.android.a.a.c.e;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.h;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.l;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: CommonDownloadHandler */
public class f implements g, l.a {
    private static final String a = "f";
    private final l b;
    private h c;
    private e d;
    private WeakReference<Context> e;
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private e g;
    private DownloadInfo h;
    private c i;
    private final IDownloadListener j;
    private boolean k;
    private long l;
    private long m;
    private com.ss.android.a.a.b.c n;
    private com.ss.android.a.a.b.b o;
    private com.ss.android.a.a.b.a p;
    private SoftReference<s> q;
    private boolean r;
    private final boolean s;
    private SoftReference<n> t;

    /* compiled from: CommonDownloadHandler */
    interface a {
        void a();
    }

    /* compiled from: CommonDownloadHandler */
    interface b {
        void a(long j);
    }

    public f() {
        l lVar = new l(Looper.getMainLooper(), this);
        this.b = lVar;
        this.j = new h.a(lVar);
        this.m = -1;
        this.n = null;
        this.o = null;
        this.p = null;
        this.c = new h();
        this.d = new e(lVar);
        this.s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");
    }

    /* renamed from: a */
    public f b(Context context) {
        if (context != null) {
            this.e = new WeakReference<>(context);
        }
        k.b(context);
        return this;
    }

    /* renamed from: a */
    public f b(int i2, d dVar) {
        if (dVar != null) {
            if (k.i().optInt("back_use_softref_listener") == 1) {
                this.f.put(Integer.valueOf(i2), dVar);
            } else {
                this.f.put(Integer.valueOf(i2), new SoftReference(dVar));
            }
        }
        return this;
    }

    /* renamed from: a */
    public f b(com.ss.android.a.a.b.c cVar) {
        if (cVar != null) {
            com.ss.android.downloadlib.addownload.b.f.a().a(cVar);
            this.m = cVar.d();
            this.n = cVar;
            if (i.a(cVar)) {
                ((com.ss.android.downloadad.a.a.c) cVar).a(3L);
                com.ss.android.downloadad.a.b.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.m);
                if (!(d2 == null || d2.l() == 3)) {
                    d2.e(3L);
                    i.a().a(d2);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        JSONObject z;
        this.p = aVar;
        if (com.ss.android.downloadlib.h.e.b(this.n).b("force_auto_open") == 1) {
            m().b(1);
        }
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (z = this.n.z()) != null && z.optInt("subprocess") > 0) {
            m().a(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, m());
        return this;
    }

    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.o = bVar;
        this.r = l().k() == 0;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(s sVar) {
        if (sVar == null) {
            this.q = null;
        } else {
            this.q = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, m());
        this.c.a(this.m);
        q();
        if (k.i().optInt("enable_empty_listener", 1) == 1 && this.f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.a.a.a.a());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public boolean a(int i2) {
        if (i2 == 0) {
            this.f.clear();
        } else {
            this.f.remove(Integer.valueOf(i2));
        }
        boolean z = false;
        if (this.f.isEmpty()) {
            this.k = false;
            this.l = System.currentTimeMillis();
            if (this.h != null) {
                Downloader.getInstance(k.a()).removeTaskMainListener(this.h.getId());
            }
            c cVar = this.i;
            z = true;
            if (!(cVar == null || cVar.getStatus() == AsyncTask.Status.FINISHED)) {
                this.i.cancel(true);
            }
            this.c.a(this.h);
            String str = a;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.h;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            j.a(str, sb.toString(), null);
            this.b.removeCallbacksAndMessages(null);
            this.g = null;
            this.h = null;
        }
        return z;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void a(boolean z) {
        if (this.h == null) {
            return;
        }
        if (z) {
            com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
            if (b2 != null) {
                b2.a(this.h);
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.b.L()).cancel(this.h.getId(), true);
            return;
        }
        Intent intent = new Intent(k.a(), DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
        intent.putExtra("extra_click_download_ids", this.h.getId());
        k.a().startService(intent);
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.h != null;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public long d() {
        return this.l;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(long j2) {
        if (j2 > 0) {
            com.ss.android.a.a.b.c a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
            if (a2 != null) {
                this.n = a2;
                this.m = j2;
                this.c.a(j2);
            }
        } else {
            k.b();
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void b(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.c.a(this.m);
            if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.m).x()) {
                k.b();
            }
            if (!this.c.a(k(), i2, this.r)) {
                boolean c2 = c(i2);
                if (i2 != 1) {
                    if (i2 == 2 && !c2) {
                        String str = a;
                        j.a(str, "handleDownload id:" + this.m + ",tryPerformButtonClick:", null);
                        c(true);
                    }
                } else if (!c2) {
                    String str2 = a;
                    j.a(str2, "handleDownload id:" + this.m + ",tryPerformItemClick:", null);
                    d(true);
                }
            }
        } else {
            throw new IllegalArgumentException("error actionType");
        }
    }

    private boolean i() {
        if (k.i().optInt("quick_app_enable_switch", 0) == 0 && c.a(this.n) && c.a(this.h)) {
            return true;
        }
        return false;
    }

    private boolean c(int i2) {
        if (!i()) {
            return false;
        }
        int i3 = -1;
        String a2 = this.n.B().a();
        if (i2 == 1) {
            i3 = 5;
        } else if (i2 == 2) {
            i3 = 4;
        }
        com.ss.android.a.a.b.c cVar = this.n;
        if (cVar instanceof com.ss.android.downloadad.a.a.c) {
            ((com.ss.android.downloadad.a.a.c) cVar).a(3);
        }
        boolean c2 = com.ss.android.downloadlib.h.h.c(k.a(), a2);
        if (c2) {
            com.ss.android.downloadlib.e.a.a().a(this.m, i2);
            Message obtain = Message.obtain();
            obtain.what = i3;
            obtain.obj = Long.valueOf(this.n.d());
            this.b.sendMessageDelayed(obtain, c.a().b());
            c.a().a(i3, this.n, this.o);
        } else {
            com.ss.android.downloadlib.e.a.a().a(this.m, false, 0);
        }
        return c2;
    }

    private void c(boolean z) {
        e(z);
    }

    private void j() {
        SoftReference<s> softReference = this.q;
        if (softReference == null || softReference.get() == null) {
            k.c().a(k(), this.n, m(), l());
            return;
        }
        this.q.get().a(this.n, l(), m());
        this.q = null;
    }

    private void d(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.a().a(this.m, 1);
        }
        n();
    }

    private void e(boolean z) {
        if (com.ss.android.downloadlib.h.e.b(this.n).b("notification_opt_2") == 1 && this.h != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(this.h.getId());
        }
        f(z);
    }

    public void e() {
        this.b.post(new Runnable() {
            /* class com.ss.android.downloadlib.addownload.f.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                for (d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.r());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.h.l.a
    public void a(Message message) {
        if (message != null && this.k) {
            int i2 = message.what;
            if (i2 == 3) {
                this.h = (DownloadInfo) message.obj;
                this.c.a(message, r(), this.f);
            } else if (i2 != 4) {
                if (i2 == 5) {
                    if (k.k() == null || !k.k().a()) {
                        com.ss.android.downloadlib.e.a.a().a(this.m, false, 1);
                        d(false);
                    }
                }
            } else if (k.k() == null || !k.k().a()) {
                com.ss.android.downloadlib.e.a.a().a(this.m, false, 2);
                c(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public Context k() {
        WeakReference<Context> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return k.a();
        }
        return this.e.get();
    }

    private com.ss.android.a.a.b.b l() {
        com.ss.android.a.a.b.b bVar = this.o;
        return bVar == null ? new g.a().a() : bVar;
    }

    private com.ss.android.a.a.b.a m() {
        if (this.p == null) {
            this.p = new com.ss.android.a.a.b.f();
        }
        return this.p;
    }

    private void n() {
        String str = a;
        j.a(str, "performItemClickWithNewDownloader", null);
        if (this.c.c(this.h)) {
            j.a(str, "performItemClickWithNewDownloader ButtonClick", null);
            f(false);
            return;
        }
        j.a(str, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(final boolean z) {
        com.ss.android.a.a.b.c cVar;
        String str = a;
        j.a(str, "performButtonClickWithNewDownloader", null);
        if (this.h != null && com.ss.android.socialbase.downloader.g.a.c().a("fix_info")) {
            this.h = Downloader.getInstance(k()).getDownloadInfo(this.h.getId());
        }
        DownloadInfo downloadInfo = this.h;
        if (downloadInfo == null || ((downloadInfo.getStatus() != -3 && !Downloader.getInstance(k.a()).canResume(this.h.getId())) || this.h.getStatus() == 0)) {
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(this.m);
            DownloadInfo downloadInfo2 = this.h;
            if (downloadInfo2 != null && downloadInfo2.getStatus() != 0) {
                b(z);
            } else if (this.r) {
                if (!this.n.t() || this.t == null) {
                    b(z);
                } else if (s() && e2.d != null && e2.d.f()) {
                    b(z);
                }
            } else if (!this.n.t() || e2.d == null || !e2.d.e() || e2.b == null || !com.ss.android.downloadlib.addownload.compliance.b.a().a(e2.b) || !com.ss.android.downloadlib.addownload.compliance.b.a().a(e2)) {
                b(z);
            }
        } else {
            j.a(str, "performButtonClickWithNewDownloader continue download, status:" + this.h.getStatus(), null);
            DownloadInfo downloadInfo3 = this.h;
            if (!(downloadInfo3 == null || (cVar = this.n) == null)) {
                downloadInfo3.setOnlyWifi(cVar.m());
            }
            final int status = this.h.getStatus();
            final int id = this.h.getId();
            com.ss.android.downloadad.a.b.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.h);
            if (status == -4 || status == -2 || status == -1) {
                this.c.a(this.h, z);
                if (a2 != null) {
                    a2.h(System.currentTimeMillis());
                    a2.i(this.h.getCurBytes());
                }
                this.h.setDownloadFromReserveWifi(false);
                this.d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, l(), m()));
                this.d.a(id, this.h.getCurBytes(), this.h.getTotalBytes(), new a() {
                    /* class com.ss.android.downloadlib.addownload.f.AnonymousClass2 */

                    @Override // com.ss.android.downloadlib.addownload.f.a
                    public void a() {
                        if (!f.this.d.a()) {
                            com.ss.android.socialbase.appdownloader.d.j().a(k.a(), id, status);
                        }
                    }
                });
            } else if (m.a(status)) {
                this.d.a(true);
                com.ss.android.downloadlib.d.g.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.m));
                com.ss.android.downloadlib.addownload.d.f.a().a(a2, status, new com.ss.android.downloadlib.addownload.d.c() {
                    /* class com.ss.android.downloadlib.addownload.f.AnonymousClass3 */

                    @Override // com.ss.android.downloadlib.addownload.d.c
                    public void a(com.ss.android.downloadad.a.b.b bVar) {
                        f.this.c.a(f.this.h, z);
                        com.ss.android.socialbase.appdownloader.d.j().a(k.a(), id, status);
                    }
                });
            } else {
                this.c.a(this.h, z);
                com.ss.android.socialbase.appdownloader.d.j().a(k.a(), id, status);
            }
        }
    }

    public void b(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.a().a(this.m, 2);
        }
        if (!com.ss.android.downloadlib.h.i.b("android.permission.WRITE_EXTERNAL_STORAGE") && !m().g()) {
            this.n.a(this.c.b());
        }
        if (com.ss.android.downloadlib.h.e.c(this.n) == 0) {
            j.a(a, "performButtonClickWithNewDownloader not start", null);
            this.c.a(new q() {
                /* class com.ss.android.downloadlib.addownload.f.AnonymousClass4 */

                @Override // com.ss.android.a.a.a.q
                public void a() {
                    j.a(f.a, "performButtonClickWithNewDownloader start download", null);
                    f.this.o();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    j.a(f.a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        o();
    }

    /* access modifiers changed from: private */
    public void o() {
        this.d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, l(), m()));
        this.d.a(0, 0, 0, new a() {
            /* class com.ss.android.downloadlib.addownload.f.AnonymousClass5 */

            @Override // com.ss.android.downloadlib.addownload.f.a
            public void a() {
                if (!f.this.d.a()) {
                    f.this.p();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void p() {
        for (d dVar : h.a(this.f)) {
            dVar.a(this.n, m());
        }
        int a2 = this.c.a(k.a(), this.j);
        String str = a;
        j.a(str, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 == 0) {
            DownloadInfo a3 = new DownloadInfo.a(this.n.a()).a();
            a3.setStatus(-1);
            a(a3);
            com.ss.android.downloadlib.e.a.a().a(this.m, new BaseException(2, "start download failed, id=0"));
            k.b();
        } else if (this.h == null || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            this.c.a();
        } else {
            this.c.a(this.h, false);
        }
        if (this.c.a(c())) {
            j.a(str, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    public void f() {
        if (this.f.size() != 0) {
            for (d dVar : h.a(this.f)) {
                dVar.a();
            }
            DownloadInfo downloadInfo = this.h;
            if (downloadInfo != null) {
                downloadInfo.setStatus(-4);
            }
        }
    }

    /* compiled from: CommonDownloadHandler */
    private class c extends AsyncTask<String, Void, DownloadInfo> {
        private c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (f.this.n != null && !TextUtils.isEmpty(f.this.n.n())) {
                downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(str, f.this.n.n());
            }
            return downloadInfo == null ? com.ss.android.socialbase.appdownloader.d.j().a(k.a(), str) : downloadInfo;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (!isCancelled() && f.this.n != null) {
                try {
                    com.ss.android.downloadlib.addownload.b.c a2 = k.a(f.this.n.v(), f.this.n.r(), f.this.n.s());
                    com.ss.android.downloadlib.addownload.b.h.a().a(f.this.n.r(), a2.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                    boolean a3 = a2.a();
                    if (downloadInfo == null || downloadInfo.getId() == 0 || (!a3 && Downloader.getInstance(k.a()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                        if (downloadInfo != null && Downloader.getInstance(k.a()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                            com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                            f.this.h = null;
                        }
                        if (f.this.h != null) {
                            Downloader.getInstance(k.a()).removeTaskMainListener(f.this.h.getId());
                            if (f.this.s) {
                                Downloader.getInstance(f.this.k()).setMainThreadListener(f.this.h.getId(), f.this.j, false);
                            } else {
                                Downloader.getInstance(f.this.k()).setMainThreadListener(f.this.h.getId(), f.this.j);
                            }
                        }
                        if (a3) {
                            f fVar = f.this;
                            fVar.h = new DownloadInfo.a(fVar.n.a()).a();
                            f.this.h.setStatus(-3);
                            f.this.c.a(f.this.h, f.this.r(), h.a(f.this.f));
                        } else {
                            for (d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.h = null;
                        }
                    } else {
                        Downloader.getInstance(k.a()).removeTaskMainListener(downloadInfo.getId());
                        if (f.this.h == null || f.this.h.getStatus() != -4) {
                            f.this.h = downloadInfo;
                            if (f.this.s) {
                                Downloader.getInstance(k.a()).setMainThreadListener(f.this.h.getId(), f.this.j, false);
                            } else {
                                Downloader.getInstance(k.a()).setMainThreadListener(f.this.h.getId(), f.this.j);
                            }
                        } else {
                            f.this.h = null;
                        }
                        f.this.c.a(f.this.h, f.this.r(), h.a(f.this.f));
                    }
                    f.this.c.b(f.this.h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.b.sendMessage(obtain);
    }

    private void q() {
        c cVar = this.i;
        if (!(cVar == null || cVar.getStatus() == AsyncTask.Status.FINISHED)) {
            this.i.cancel(true);
        }
        c cVar2 = new c();
        this.i = cVar2;
        com.ss.android.downloadlib.h.b.a(cVar2, this.n.a(), this.n.v());
    }

    /* access modifiers changed from: private */
    public e r() {
        if (this.g == null) {
            this.g = new e();
        }
        return this.g;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void g() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.m);
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(n nVar) {
        if (nVar == null) {
            this.t = null;
        } else {
            this.t = new SoftReference<>(nVar);
        }
        return this;
    }

    private boolean s() {
        SoftReference<n> softReference = this.t;
        if (softReference == null || softReference.get() == null) {
            com.ss.android.downloadlib.f.a.a(this.m, new BaseException(7, "downloadSDK: mDownloadButtonClickListener has recycled"));
            return false;
        }
        this.t.get().a(true);
        this.t = null;
        return true;
    }
}
