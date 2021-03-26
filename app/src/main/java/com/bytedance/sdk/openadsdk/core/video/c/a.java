package com.bytedance.sdk.openadsdk.core.video.c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BaseVideoController */
public abstract class a implements c, d, al.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private WeakReference<e> D;
    private int E;
    private boolean F;
    private boolean G;
    private final Runnable H;
    private final Runnable I;
    private final Runnable J;
    private boolean K;
    private long L;
    private final BroadcastReceiver M;
    private int N;
    private boolean O;
    public final WeakReference<Context> a;
    public final l b;
    public long c;
    protected Map<String, Object> d;
    protected long e;
    protected long f;
    protected boolean g;
    protected boolean h;
    public long i;
    private h j;
    private final ViewGroup k;

    /* renamed from: l  reason: collision with root package name */
    private final al f1318l = new al(this);
    private long m = 0;
    private long n = 0;
    private com.bytedance.sdk.openadsdk.core.video.d.d o;
    private c.a p;
    private long q = 0;
    private long r = 0;
    private ArrayList<Runnable> s;
    private boolean t;
    private final boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private long z;

    protected abstract int a();

    protected abstract void a(int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void a(b bVar, View view, boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.AbstractC0046c cVar) {
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z2) {
    }

    protected abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    private void a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        h hVar = new h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(ac.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.b, this);
        this.j = hVar;
        hVar.a(this);
    }

    protected a(Context context, ViewGroup viewGroup, l lVar) {
        boolean z2 = false;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = false;
        this.z = 0;
        this.A = false;
        this.B = false;
        this.C = false;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.F = false;
        this.G = true;
        this.H = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o != null) {
                    a.this.o.e();
                }
            }
        };
        this.I = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.p != null) {
                    a.this.p.a();
                }
            }
        };
        this.J = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o != null) {
                    if (a.this.c <= 0) {
                        a.this.o.e();
                    }
                    a.this.o.f();
                }
                a.this.f1318l.postDelayed(this, 200);
            }
        };
        this.K = false;
        this.M = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass5 */

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    a.this.h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    a.this.b(context);
                }
            }
        };
        this.N = 1;
        this.O = false;
        this.N = x.c(context);
        this.k = viewGroup;
        this.a = new WeakReference<>(context);
        this.b = lVar;
        a(context);
        this.E = aj.d(lVar.aj());
        this.u = Build.VERSION.SDK_INT >= 17 ? true : z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z2) {
        u.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            u.f("BaseVideoController", "No video info");
            return false;
        }
        this.g = !str.startsWith("http");
        this.y = z2;
        if (j2 > 0) {
            this.q = j2;
            long j3 = this.r;
            if (j3 > j2) {
                j2 = j3;
            }
            this.r = j2;
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.e();
            this.j.d();
            this.j.c(i2, i3);
            this.j.c(this.k);
        }
        if (this.o == null) {
            this.o = new com.bytedance.sdk.openadsdk.core.video.d.d(this.f1318l);
        }
        this.n = 0;
        try {
            a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.d.d u() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h v() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.q = j2;
        long j3 = this.r;
        if (j3 > j2) {
            j2 = j3;
        }
        this.r = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z2) {
        this.x = z2;
        this.j.c(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.z = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.c = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (u() == null) {
            return 0;
        }
        return u().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return 0;
        }
        return dVar.o() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z2) {
        this.y = z2;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return 0;
        }
        return dVar.p() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z2) {
        this.C = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.F;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z2) {
        this.G = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.r, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.d = map;
    }

    private void a(String str) throws Exception {
        if (this.o != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.a = str;
            l lVar = this.b;
            if (lVar != null) {
                if (lVar.R() != null) {
                    aVar.d = this.b.R().l();
                }
                aVar.b = String.valueOf(aj.d(this.b.aj()));
            }
            aVar.c = 1;
            this.o.a(aVar);
        }
        this.m = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.j.d(8);
            this.j.d(0);
            a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    a.this.m = System.currentTimeMillis();
                    a.this.j.c(0);
                    if (a.this.o != null && a.this.q == 0) {
                        a.this.o.a(true, 0L, !a.this.y);
                    } else if (a.this.o != null) {
                        a.this.o.a(true, a.this.q, !a.this.y);
                    }
                    if (a.this.f1318l != null) {
                        a.this.f1318l.postDelayed(a.this.H, 100);
                    }
                    a.this.E();
                }
            });
        }
    }

    private void D() {
        int i2;
        int a2 = a();
        if (a2 == 2 || a2 == 1) {
            i2 = p.h().H() * 1000;
        } else {
            i2 = a2 == 3 ? p.h().f(String.valueOf(this.E)) : 5;
        }
        this.f1318l.removeCallbacks(this.I);
        this.f1318l.postDelayed(this.I, (long) i2);
    }

    /* access modifiers changed from: private */
    public void E() {
        F();
        this.f1318l.postDelayed(this.J, 800);
    }

    private void F() {
        this.f1318l.removeCallbacks(this.J);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.D = new WeakReference<>(eVar);
    }

    private void b(int i2) {
        if (G() && this.j != null) {
            this.f1318l.removeCallbacks(this.I);
            this.j.w();
            long currentTimeMillis = System.currentTimeMillis() - this.m;
            this.n = currentTimeMillis;
            c.a aVar = this.p;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.c));
            }
            if (aj.d(this.b)) {
                this.j.a(this.b, this.a, true);
            }
            if (!this.w) {
                b();
                this.w = true;
                long j2 = this.c;
                a(j2, j2);
                long j3 = this.c;
                this.q = j3;
                this.r = j3;
            }
            this.C = true;
        }
    }

    private boolean G() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (!this.j.k() || !this.t) {
                b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(runnable);
    }

    private void H() {
        ArrayList<Runnable> arrayList = this.s;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = new ArrayList(this.s).iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
            this.s.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.p = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.i = p();
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b();
        }
        if (!this.w && this.v) {
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.e();
            this.j.q();
            this.j.u();
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false, this.q, !this.y);
            E();
        }
        if (!this.w && this.v) {
            d();
        }
    }

    public void y() {
        if (!this.w && this.v) {
            d();
        }
    }

    public void d(long j2) {
        this.q = j2;
        long j3 = this.r;
        if (j3 > j2) {
            j2 = j3;
        }
        this.r = j2;
        h hVar = this.j;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(true, this.q, !this.y);
            E();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.c();
            this.o = null;
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.g();
        }
        al alVar = this.f1318l;
        if (alVar != null) {
            alVar.removeCallbacks(this.I);
            this.f1318l.removeCallbacks(this.H);
            this.f1318l.removeCallbacksAndMessages(null);
            F();
        }
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z2) {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        if (this.j != null && message != null && (weakReference = this.a) != null && weakReference.get() != null) {
            int i2 = message.what;
            if (i2 != 108) {
                if (i2 != 109) {
                    if (i2 == 308) {
                        a(308, 0);
                    } else if (i2 == 311) {
                        l lVar = this.b;
                        if (lVar == null || lVar.l() != 0) {
                            J();
                        } else {
                            K();
                        }
                    } else if (i2 != 314) {
                        switch (i2) {
                            case 302:
                                b(message.what);
                                return;
                            case 303:
                                a(message.arg1, message.arg2);
                                this.f1318l.removeCallbacks(this.I);
                                h hVar = this.j;
                                if (hVar != null) {
                                    hVar.w();
                                }
                                c.a aVar = this.p;
                                if (aVar != null) {
                                    aVar.b(this.n, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.c));
                                    return;
                                }
                                return;
                            case 304:
                                int i3 = message.arg1;
                                h hVar2 = this.j;
                                if (hVar2 != null) {
                                    if (i3 == 3 || i3 == 702) {
                                        hVar2.w();
                                        this.f1318l.removeCallbacks(this.I);
                                        this.F = false;
                                    } else if (i3 == 701) {
                                        hVar2.t();
                                        D();
                                        this.F = true;
                                    }
                                }
                                if (this.u && i3 == 3 && !this.v) {
                                    this.f = SystemClock.elapsedRealtime() - this.e;
                                    e();
                                    this.v = true;
                                    this.h = true;
                                    return;
                                }
                                return;
                            case 305:
                                al alVar = this.f1318l;
                                if (alVar != null) {
                                    alVar.removeCallbacks(this.I);
                                }
                                if (!this.u && !this.v) {
                                    this.f = SystemClock.elapsedRealtime() - this.e;
                                    f();
                                    this.v = true;
                                }
                                h hVar3 = this.j;
                                if (hVar3 != null) {
                                    hVar3.w();
                                    return;
                                }
                                return;
                            case 306:
                                this.f1318l.removeCallbacks(this.I);
                                h hVar4 = this.j;
                                if (hVar4 != null) {
                                    hVar4.w();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        this.e = SystemClock.elapsedRealtime();
                    }
                } else if (message.obj instanceof Long) {
                    long longValue = ((Long) message.obj).longValue();
                    this.q = longValue;
                    long j2 = this.r;
                    if (j2 <= longValue) {
                        j2 = longValue;
                    }
                    this.r = j2;
                    a(longValue, this.c);
                }
            } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                this.c = ((Long) message.obj).longValue();
            }
        }
    }

    private boolean I() throws Throwable {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar;
        l lVar;
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || L() == null || (dVar = this.o) == null || dVar.a() == null || (lVar = this.b) == null || lVar.M() != null || this.b.n() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0120 A[Catch:{ all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013d A[Catch:{ all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0151 A[Catch:{ all -> 0x018b }] */
    private void J() {
        try {
            u.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.b.p());
            if (!I()) {
                u.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
                int[] b2 = ak.b(p.a());
                MediaPlayer a2 = this.o.a();
                boolean z2 = false;
                boolean z3 = this.b.ak() == 15;
                float f2 = (float) b2[0];
                float f3 = (float) b2[1];
                float videoWidth = (float) a2.getVideoWidth();
                float videoHeight = (float) a2.getVideoHeight();
                if (z3) {
                    if (videoWidth > videoHeight) {
                        u.b("changeVideoSize", "横转竖屏单独适配.....");
                        a(f2, f3, videoWidth, videoHeight, true);
                        return;
                    }
                } else if (videoWidth < videoHeight) {
                    u.b("changeVideoSize", "竖屏转横单独适配.....");
                    a(f2, f3, videoWidth, videoHeight, false);
                    return;
                }
                float f4 = videoWidth / videoHeight;
                float f5 = f2 / f3;
                u.b("changeVideoSize", "screenHeight=" + f3 + ",screenWidth=" + f2);
                u.b("changeVideoSize", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                u.b("changeVideoSize", "视频宽高比,videoScale=" + f4 + ",屏幕宽高比.screenScale=" + f5 + ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778");
                if (z3) {
                    if (f5 < 0.5625f && f4 == 0.5625f) {
                        videoWidth = (9.0f * f3) / 16.0f;
                        videoHeight = f3;
                    }
                    u.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                    if (!z2) {
                        u.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                    } else {
                        f2 = videoWidth;
                        f3 = videoHeight;
                    }
                    int i2 = (int) f2;
                    int i3 = (int) f3;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
                    layoutParams.addRule(13);
                    if (L() != null) {
                        if (L() instanceof TextureView) {
                            ((TextureView) L()).setLayoutParams(layoutParams);
                        } else if (L() instanceof SurfaceView) {
                            ((SurfaceView) L()).setLayoutParams(layoutParams);
                        }
                        ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = i3;
                            layoutParams2.width = i2;
                            this.k.setLayoutParams(layoutParams2);
                        }
                    }
                    u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
                }
                if (f5 > 1.7777778f && f4 == 1.7777778f) {
                    videoHeight = (9.0f * f2) / 16.0f;
                    videoWidth = f2;
                }
                u.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                if (!z2) {
                }
                int i2 = (int) f2;
                int i3 = (int) f3;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
                layoutParams.addRule(13);
                if (L() != null) {
                }
                u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
                z2 = true;
                u.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                if (!z2) {
                }
                int i2 = (int) f2;
                int i3 = (int) f3;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
                layoutParams.addRule(13);
                if (L() != null) {
                }
                u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            u.c("changeVideoSize", "changeSize error", th);
        }
    }

    private void K() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar;
        try {
            WeakReference<Context> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null && L() != null && (dVar = this.o) != null && dVar.a() != null) {
                l lVar = this.b;
                if (lVar != null) {
                    boolean z2 = lVar.ak() == 15;
                    int[] b2 = ak.b(p.a());
                    float f2 = (float) b2[1];
                    MediaPlayer a2 = this.o.a();
                    a((float) b2[0], f2, (float) a2.getVideoWidth(), (float) a2.getVideoHeight(), z2);
                    u.b("changeVideoSize", "changeSize=end");
                }
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    private void a(float f2, float f3, float f4, float f5, boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            u.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
            u.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
            if (f4 <= 0.0f || f5 <= 0.0f) {
                f4 = (float) this.b.R().c();
                f5 = (float) this.b.R().b();
            }
            if (f5 <= 0.0f) {
                return;
            }
            if (f4 > 0.0f) {
                if (z2) {
                    if (f4 >= f5) {
                        u.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                        layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                        layoutParams.addRule(13);
                    } else {
                        return;
                    }
                } else if (f4 <= f5) {
                    u.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                    layoutParams2.addRule(13);
                    layoutParams = layoutParams2;
                } else {
                    return;
                }
                if (L() == null) {
                    return;
                }
                if (L() instanceof TextureView) {
                    ((TextureView) L()).setLayoutParams(layoutParams);
                } else if (L() instanceof SurfaceView) {
                    ((SurfaceView) L()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.o != null && G()) {
            if (this.o.g()) {
                h();
                this.j.b(true, false);
                this.j.c();
            } else if (!this.o.i()) {
                h hVar = this.j;
                if (hVar != null) {
                    hVar.c(this.k);
                }
                d(this.q);
                h hVar2 = this.j;
                if (hVar2 != null) {
                    hVar2.b(false, false);
                }
            } else {
                k();
                h hVar3 = this.j;
                if (hVar3 != null) {
                    hVar3.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        if (this.o != null) {
            E();
            a(this.L, c(i2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        if (this.o != null) {
            F();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z2) {
        if (G()) {
            long l2 = (long) ((((float) (((long) i2) * this.c)) * 1.0f) / ((float) ac.l(this.a.get(), "tt_video_progress_max")));
            if (this.c > 0) {
                this.L = (long) ((int) l2);
            } else {
                this.L = 0;
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.a(this.L);
            }
        }
    }

    private void a(long j2, long j3) {
        this.q = j2;
        this.c = j3;
        this.j.a(j2, j3);
        this.j.a(com.bytedance.sdk.openadsdk.core.video.e.a.a(j2, j3));
        try {
            c.a aVar = this.p;
            if (aVar != null) {
                aVar.a(j2, j3);
            }
        } catch (Throwable th) {
            u.c("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (G()) {
            g(!this.K);
            if (!(this.a.get() instanceof Activity)) {
                u.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.K) {
                a(z2 ? 8 : 0);
                h hVar = this.j;
                if (hVar != null) {
                    hVar.a(this.k);
                    this.j.b(false);
                }
            } else {
                a(1);
                h hVar2 = this.j;
                if (hVar2 != null) {
                    hVar2.b(this.k);
                    this.j.b(false);
                }
            }
            WeakReference<e> weakReference = this.D;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.K);
            }
        }
    }

    public void a(int i2) {
        if (G()) {
            boolean z2 = i2 == 0 || i2 == 8;
            Context context = this.a.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z2) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        h hVar = this.j;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.x) {
            h();
        }
        if (z2 && !this.x && !z()) {
            this.j.b(!A(), false);
            this.j.a(z3, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null || !dVar.g()) {
            this.j.c();
            return;
        }
        this.j.c();
        this.j.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.K) {
            g(false);
            h hVar = this.j;
            if (hVar != null) {
                hVar.b(this.k);
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    private void g(boolean z2) {
        this.K = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.t = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            if (dVar != null) {
                dVar.a(true);
            }
            this.o.a(surfaceHolder);
            H();
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b L() {
        h hVar;
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || (hVar = this.j) == null) {
            return null;
        }
        return hVar.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.t = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.t = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            if (dVar != null) {
                dVar.a(true);
            }
            this.o.a(surfaceTexture);
            H();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.t = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    public boolean z() {
        return this.o.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.b();
            this.j.e();
        }
        h hVar2 = this.j;
        if (hVar2 != null) {
            hVar2.u();
        }
        d(-1L);
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.m();
        }
    }

    public boolean A() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        return dVar != null && dVar.g();
    }

    private void a(long j2, boolean z2) {
        if (this.o != null) {
            if (z2) {
                M();
            }
            this.o.a(j2);
        }
    }

    private boolean c(int i2) {
        return this.j.b(i2);
    }

    private void M() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c(0);
            this.j.a(false, false);
            this.j.b(false);
            this.j.b();
            this.j.d();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.a$6  reason: invalid class name */
    /* compiled from: BaseVideoController */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.values().length];
            a = iArr;
            try {
                iArr[h.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(h.a aVar, String str) {
        int i2 = AnonymousClass6.a[aVar.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 == 3) {
            k();
            this.A = false;
            this.B = true;
        }
    }

    private boolean d(int i2) {
        l lVar;
        int c2 = x.c(p.a());
        if (c2 != 4 && c2 != 0) {
            h();
            this.A = true;
            this.B = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
            if (!(hVar == null || (lVar = this.b) == null)) {
                return hVar.a(i2, lVar.R(), true);
            }
        } else if (c2 == 4) {
            this.A = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
            if (hVar2 != null) {
                hVar2.q();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        int c2;
        if (G() && this.N != (c2 = x.c(context))) {
            if (!this.B) {
                d(2);
            }
            this.N = c2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.d();
        }
    }

    protected Map<String, Object> B() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.d;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a2 = aj.a(this.f, this.b, u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    protected Map<String, Object> C() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a2 = aj.a(this.b, o(), u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry : a2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map = this.d;
        if (map != null) {
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }
}
