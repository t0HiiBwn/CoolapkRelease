package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: DMLibManager */
public class d implements com.bytedance.sdk.openadsdk.downloadnew.core.a, al.a {
    private a A = new a();
    private List<ITTAppDownloadListener> B = new ArrayList();
    private boolean C = false;
    private boolean D = true;
    protected WeakReference<Context> a;
    protected final com.bytedance.sdk.openadsdk.core.d.b b;
    protected final l c;
    protected String d;
    protected final AtomicInteger e = new AtomicInteger(1);
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = true;
    protected IListenerManager j;
    private int k = -1;

    /* renamed from: l  reason: collision with root package name */
    private com.ss.android.a.a.b.a f1329l;
    private com.ss.android.a.a.b.b m;
    private c n;
    private boolean o;
    private final AtomicLong p = new AtomicLong();
    private final AtomicBoolean q = new AtomicBoolean(false);
    private WeakReference<View> r;
    private boolean s = false;
    private HashSet<Integer> t;
    private com.bytedance.sdk.openadsdk.downloadnew.core.c u;
    private final al v = new al(Looper.getMainLooper(), this);
    private boolean w = true;
    private String x;
    private int y;
    private final com.ss.android.a.a.b.d z = new com.ss.android.a.a.b.d() {
        /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass1 */

        @Override // com.ss.android.a.a.b.d
        public void a() {
            d.this.e.set(1);
            d.c("onIdle");
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onIdle", 0, 0, (String) null, (String) null);
            } else if (d.this.u != null) {
                d.this.u.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(c cVar, com.ss.android.a.a.b.a aVar) {
            d.this.e.set(2);
            d.c("onDownloadStart: " + cVar.d());
            d.this.a(cVar.d());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onIdle", 0, 0, (String) null, (String) null);
            } else if (d.this.u != null) {
                d.this.u.onIdle();
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(e eVar, int i) {
            d.this.e.set(3);
            d.this.f.set(false);
            d.this.a(eVar.a);
            d.c("onDownloadActive: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadActive", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadActive(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(e eVar, int i) {
            d.this.e.set(4);
            d.this.f.set(false);
            d.this.a(eVar.a);
            d.c("onDownloadPaused: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadPaused", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadPaused(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void a(e eVar) {
            d.this.e.set(5);
            d.this.a(eVar.a);
            d.c("onDownloadFailed: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadFailed", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadFailed(eVar.c, eVar.d, eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void b(e eVar) {
            d.this.e.set(7);
            d.this.f.set(true);
            d.this.a(eVar.a);
            d.c("onInstalled: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onInstalled", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onInstalled(eVar.e, d.this.b.c());
            }
        }

        @Override // com.ss.android.a.a.b.d
        public void c(e eVar) {
            d.this.e.set(6);
            d.this.a(eVar.a);
            d.c("onDownloadFinished: " + eVar.c + ", " + eVar.d);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                d.this.a("onDownloadFinished", eVar.c, eVar.d, eVar.e, d.this.b.c());
            } else if (d.this.u != null) {
                d.this.u.onDownloadFinished(eVar.c, eVar.e, d.this.b.c());
            }
        }
    };

    /* compiled from: DMLibManager */
    public interface b {
        void a();
    }

    private void o() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z2) {
        return false;
    }

    /* access modifiers changed from: private */
    public void a(String str, long j2, long j3, String str2, String str3) {
        a aVar = this.A;
        if (aVar == null) {
            this.A = new a(str, j2, j3, str2, str3);
        } else {
            aVar.a(str);
            this.A.a(j2);
            this.A.b(j3);
            this.A.b(str2);
            this.A.c(str3);
        }
        com.bytedance.sdk.openadsdk.j.e.b().execute(this.A);
    }

    protected IListenerManager l() {
        if (this.j == null) {
            this.j = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
        }
        return this.j;
    }

    /* access modifiers changed from: private */
    public static void c(String str) {
        u.b("DMLibManager", str);
    }

    public d(Context context, l lVar, String str) {
        this.a = new WeakReference<>(context);
        this.c = lVar;
        com.bytedance.sdk.openadsdk.core.d.b ah = lVar.ah();
        this.b = ah;
        this.d = str;
        this.k = aj.c(lVar.aj());
        this.x = j.a(lVar.hashCode() + lVar.aF().toString());
        c("====tag===" + str);
        if (ah == null) {
            u.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (p.a() == null) {
            p.a(context);
        }
        this.u = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.n = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.d, lVar, null).a();
        this.f1329l = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(lVar).a();
        this.m = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(lVar, this.d).a();
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        r();
        o();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        if (p.a() == null) {
            p.a(m());
        }
        this.o = true;
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        this.o = false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.u;
        if (cVar != null) {
            cVar.a();
        }
        q();
        HashSet<Integer> hashSet = this.t;
        if (hashSet != null) {
            Iterator<Integer> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                g.a(it2.next().intValue());
                it2.remove();
            }
        }
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(Activity activity) {
        u.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
        if (activity != null) {
            this.a = new WeakReference<>(activity);
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        if (view != null) {
            this.r = new WeakReference<>(view);
        }
    }

    private void p() {
        c("tryReleaseResource==");
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null) {
            c("tryReleaseResource==  mContext is null");
            return;
        }
        Activity activity = weakReference.get() instanceof Activity ? (Activity) this.a.get() : null;
        if (activity == null) {
            c("tryReleaseResource==  activity is null");
        } else if (i.d().a(activity)) {
            c("tryReleaseResource==  isActivityAlive is true");
        } else {
            y();
        }
    }

    public void c(boolean z2) {
        this.s = z2;
    }

    private synchronized void q() {
        c("unbindDownload==" + this.q.get());
        if (this.b != null) {
            if (this.q.get()) {
                this.q.set(false);
                g.d().a(this.n.a(), hashCode());
            }
            p();
        }
    }

    private synchronized void r() {
        c("bindDownload==" + this.q.get());
        if (this.b != null) {
            this.q.get();
            this.q.set(true);
            g.d().a(m(), hashCode(), this.z, this.n);
        }
    }

    public void a(long j2) {
        this.p.set(j2);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        s();
    }

    private void s() {
        if (m() != null && this.b != null) {
            TTCustomController e2 = i.d().e();
            if (e2 != null && !e2.isCanUseWriteExternal()) {
                try {
                    String str = g.a;
                    String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                    if (str != null && !str.startsWith(absolutePath)) {
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!this.c.E() && g.a(m(), this.b.b())) {
                c("changeDownloadStatus, not support pause/continue function");
                try {
                    Toast.makeText(m(), "应用正在下载...", 0).show();
                } catch (Exception unused2) {
                }
            } else if (!t()) {
                c("changeDownloadStatus, the current status is1: " + this.e);
                g.d().a(this.b.b(), this.n.d(), 2, this.m, this.f1329l, null, new n() {
                    /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass3 */

                    @Override // com.ss.android.a.a.a.n
                    public void a(boolean z) {
                        if (z) {
                            d dVar = d.this;
                            if (dVar.a(dVar.c)) {
                                d dVar2 = d.this;
                                dVar2.a(dVar2.c, new b() {
                                    /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                                    public void a() {
                                        g.d().a(d.this.b.b(), d.this.n.d(), 2, d.this.m, d.this.f1329l);
                                    }
                                });
                                return;
                            }
                        }
                        g.d().a(d.this.b.b(), d.this.n.d(), 2, d.this.m, d.this.f1329l);
                    }
                });
                c("changeDownloadStatus, the current status is2: " + this.e);
            } else if (a(this.c)) {
                a(this.c, new b() {
                    /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass2 */

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                    public void a() {
                        g.d().a(d.this.b.b(), d.this.n.d(), 2, d.this.m, d.this.f1329l);
                    }
                });
            } else {
                g.d().a(this.b.b(), this.n.d(), 2, this.m, this.f1329l);
            }
        }
    }

    private boolean t() {
        l lVar = this.c;
        if (lVar == null) {
            return false;
        }
        int T = lVar.T();
        String au = this.c.au();
        if (T != 4 || TextUtils.isEmpty(au)) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        b(0);
    }

    public void b(long j2) {
        if (this.b != null) {
            this.q.set(false);
            g.d().a(this.n.a(), true);
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        if (m() != null && this.b != null) {
            if (!"feed_video_middle_page".equals(this.d)) {
                TTMiddlePageActivity.b(m(), this.c);
            }
            if (k()) {
                this.f.set(true);
            } else if (!j()) {
                if (u()) {
                    this.f.set(true);
                } else if (b(this.w)) {
                    this.f.set(true);
                } else {
                    z();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        l lVar = this.c;
        return (lVar == null || lVar.O() == null || this.b == null || this.c.O().b() != 3 || this.b.a() == null) ? false : true;
    }

    private boolean u() {
        if (this.b == null || !h()) {
            return false;
        }
        boolean a2 = a(m(), this.b.a(), this.c, this.d, this.h);
        if (a2) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.v.sendMessageDelayed(obtain, 3000);
        } else {
            h(false);
        }
        return a2;
    }

    public static boolean a(Context context, String str, l lVar, String str2, boolean z2) {
        if (context == null) {
            return false;
        }
        try {
            if (lVar.aw() && !z2) {
                aj.a(lVar, str2);
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected Context m() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.a.get();
    }

    public boolean k() {
        if (this.c.ai() != null) {
            String a2 = this.c.ai().a();
            u.b("DMLibManager", "含有deeplink链接 " + this.h);
            u.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.h);
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(a2);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.h) {
                    u.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                    com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", a(a2));
                }
                if (aj.a(m(), intent)) {
                    u.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                    if (!(m() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        n();
                        if (!a(this.d, "open_url_app", this.c)) {
                            com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_url_app", null);
                        }
                        m().startActivity(intent);
                        k.a().a(this.c, this.d, this.h);
                        if (this.h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_success_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_success_realtime");
                        }
                        return true;
                    } catch (Throwable unused) {
                        if (!TextUtils.isEmpty(this.c.W())) {
                            z.a(m(), this.c.W(), this.c, aj.a(this.d), this.d, true, null);
                        }
                        if (this.h) {
                            u.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                        }
                        return false;
                    }
                } else if (this.h) {
                    u.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "lp_deeplink_fail_realtime");
                } else {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), this.c, this.d, "deeplink_fail_realtime");
                }
            }
            if (!(this.e.get() == 4 || this.e.get() == 3 || (this.g && !this.f.get()))) {
                this.g = true;
                if (!a(this.d, "open_fallback_url", this.c)) {
                    com.bytedance.sdk.openadsdk.c.d.i(m(), this.c, this.d, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z2) {
        this.w = z2;
        return u();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        if (this.e.get() != 1) {
            if (aj.c(m())) {
                n();
            }
            e();
            if (this.e.get() == 3 || this.e.get() == 4) {
                this.f.set(false);
            } else if (this.e.get() == 6) {
                this.f.set(true);
            }
            return false;
        } else if (x.c(m()) == 0) {
            try {
                Toast.makeText(m(), ac.b(m(), "tt_no_network"), 0).show();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } else {
            if (aj.c(m())) {
                n();
            }
            w();
            return true;
        }
    }

    private boolean a(int i2) {
        int e2 = p.h().e();
        if (e2 == -1) {
            return !i.d().b(i2);
        }
        if (e2 == 0) {
            return false;
        }
        if (e2 != 2) {
            if (e2 != 3) {
                if (i.d().b(i2)) {
                    return false;
                }
                int i3 = 104857600;
                com.bytedance.sdk.openadsdk.core.d.b bVar = this.b;
                if (bVar != null && bVar.g() > 0) {
                    i3 = this.b.g();
                }
                if (i3 <= p.h().f()) {
                    return false;
                }
            }
        } else if (i2 == 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        if (!this.i) {
            return false;
        }
        int c2 = x.c(m());
        if (c2 == 0) {
            try {
                Toast.makeText(m(), ac.b(m(), "tt_no_network"), 0).show();
            } catch (Exception unused) {
            }
        }
        boolean a2 = a(c2);
        boolean z2 = lVar.J() == 0;
        boolean z3 = lVar.K() == 0;
        boolean z4 = lVar.K() == 2;
        boolean z5 = lVar.L() == 0;
        if (t()) {
            if (this.h || z4) {
                return false;
            }
            this.y = 2;
            if (z3) {
                return a2;
            }
            return true;
        } else if (!this.h) {
            this.y = 1;
            if (z2) {
                return a2;
            }
            if (lVar.J() != 2 || !this.C || this.D) {
                return true;
            }
            return a2;
        } else if (z5) {
            return false;
        } else {
            this.y = 3;
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void a(final l lVar, final b bVar) {
        if (lVar != null) {
            String Q = lVar.Q();
            String a2 = f.a(lVar);
            com.bytedance.sdk.openadsdk.core.d.k U = lVar.U();
            String a3 = U != null ? U.a() : "";
            boolean z2 = lVar.T() == 4;
            com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, this.d, "pop_up", v());
            g.a(lVar.ag(), Q, new g.a() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, d.this.d, "pop_up_download", d.this.v());
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), lVar, d.this.d, "pop_up_cancel", d.this.v());
                }
            }, a2, a3, z2);
        }
    }

    /* access modifiers changed from: private */
    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_type", this.y);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private void w() {
        x();
        this.f.set(true);
    }

    protected void n() {
        l lVar = this.c;
        if (lVar != null && lVar.aw() && !this.h && !TTMiddlePageActivity.a(this.c)) {
            aj.a(this.c, this.d);
        }
    }

    private void x() {
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.b;
        boolean z2 = false;
        if (bVar == null) {
            return false;
        }
        String d2 = bVar.d();
        if (!TextUtils.isEmpty(d2) && a(m(), d2)) {
            z2 = true;
            this.f.set(true);
            if (!a(this.d, "click_open", this.c)) {
                com.bytedance.sdk.openadsdk.c.d.j(m(), this.c, this.d, aj.h(this.c), null);
            }
        }
        return z2;
    }

    public boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            u.b("DMLibManager", "使用包名调起 " + this.h);
            if (this.h) {
                u.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
                com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "lp_open_dpl", str);
            }
            try {
                if (aj.c(context, str)) {
                    try {
                        Intent b2 = aj.b(context, str);
                        if (b2 == null) {
                            return false;
                        }
                        n();
                        b2.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(b2);
                        if (this.h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl");
                        }
                        if (this.h) {
                            k.a().a(this.c, this.d, true);
                        }
                        return true;
                    } catch (Exception unused) {
                        if (this.c.W() != null) {
                            z.a(m(), this.c.W(), this.c, aj.a(this.d), this.d, true, null);
                        }
                        if (this.h) {
                            u.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                            com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                        }
                        return true;
                    }
                } else if (this.h) {
                    u.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
                    com.bytedance.sdk.openadsdk.c.d.b(m(), this.c, this.d, "lp_openurl_failed");
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    protected boolean a(String str, String str2, l lVar) {
        return g.a(str, str2, lVar, (Object) 1);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        a(tTAppDownloadListener, true);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z2) {
        if (tTAppDownloadListener != null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.u;
            if (cVar != null) {
                cVar.a(tTAppDownloadListener);
            }
            if (z2) {
                b(tTAppDownloadListener);
            }
            r();
        }
    }

    private void b(final TTAppDownloadListener tTAppDownloadListener) {
        u.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.x);
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && tTAppDownloadListener != null) {
            com.bytedance.sdk.openadsdk.j.e.b().execute(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a());
                    com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(tTAppDownloadListener);
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a2.a(3));
                    if (asInterface != null) {
                        try {
                            asInterface.registerTTAppDownloadListener(d.this.x, eVar);
                            d.this.B.add(eVar);
                            u.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void d(boolean z2) {
        this.C = z2;
    }

    public void e(boolean z2) {
        this.D = z2;
    }

    private void y() {
        u.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.x);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.j.e.b().execute(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.d.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(3));
                    try {
                        u.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + d.this.B.size());
                        if (asInterface != null && d.this.B.size() > 0) {
                            for (ITTAppDownloadListener iTTAppDownloadListener : d.this.B) {
                                asInterface.unregisterTTAppDownloadListener(d.this.x, iTTAppDownloadListener);
                            }
                            d.this.B.clear();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i2, a.AbstractC0050a aVar) {
        if (this.t == null) {
            this.t = new HashSet<>();
        }
        this.t.add(Integer.valueOf(i2));
        g.a(i2, aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 9) {
            if (i.d() == null || i.d().a()) {
                h(true);
                return;
            }
            h(false);
            boolean z2 = this.w;
            if (z2 && !b(z2)) {
                z();
            }
        }
    }

    public void f(boolean z2) {
        this.h = z2;
    }

    public void g(boolean z2) {
        this.i = z2;
    }

    private void h(boolean z2) {
        if (z2) {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.c.d.a(m(), this.c, this.d, "quickapp_fail");
        }
    }

    private void z() {
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.b;
        if (bVar != null && bVar.b() != null) {
            i();
        }
    }

    protected String a(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && !TextUtils.isEmpty(parse.getScheme())) {
            return parse.getScheme().toLowerCase();
        }
        return "";
    }

    /* compiled from: DMLibManager */
    private class a extends com.bytedance.sdk.openadsdk.j.g {
        String a;
        long b;
        long c;
        String d;
        String e;

        public a() {
        }

        public a(String str, long j, long j2, String str2, String str3) {
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = str2;
            this.e = str3;
        }

        public void a(String str) {
            this.a = str;
        }

        public void a(long j) {
            this.b = j;
        }

        public void b(long j) {
            this.c = j;
        }

        public void b(String str) {
            this.d = str;
        }

        public void c(String str) {
            this.e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.l().executeAppDownloadCallback(d.this.x, this.a, this.b, this.c, this.d, this.e);
            } catch (Throwable th) {
                u.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }
}
