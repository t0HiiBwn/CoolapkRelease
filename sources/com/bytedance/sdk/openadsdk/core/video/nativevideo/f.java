package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.d.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: NativeVideoController */
public class f implements c, d, al.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private WeakReference<c.AbstractC0046c> E;
    private WeakReference<a> F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;
    private final Runnable L;
    private final Runnable M;
    private final Runnable N;
    private int O;
    private long P;
    private long Q;
    private long R;
    private boolean S;
    private long T;
    private final BroadcastReceiver U;
    private int V;
    private boolean W;
    Runnable a;
    private h b;
    private final WeakReference<ViewGroup> c;
    private final al d = new al(this);
    private long e = 0;
    private long f = 0;
    private d g;
    private c.a h;
    private long i = 0;
    private long j = 0;
    private long k;
    private List<Runnable> l;
    private boolean m;
    private final WeakReference<Context> n;
    private final boolean o;
    private boolean p;
    private boolean q;
    private final l r;
    private boolean s;
    private boolean t;
    private String u;
    private boolean v;
    private boolean w;
    private WeakReference<e> x;
    private long y;
    private boolean z;

    /* compiled from: NativeVideoController */
    public interface a {
        void a(int i);

        void f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        return 0;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(drawVideoListener);
        }
    }

    public void a(final NativeVideoTsView.b bVar) {
        h hVar;
        if (this.s && (hVar = this.b) != null) {
            hVar.a(new NativeVideoTsView.b() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                public void a(View view, int i) {
                    NativeVideoTsView.b bVar = bVar;
                    if (bVar != null) {
                        bVar.a(view, i);
                    }
                }
            });
        }
    }

    public void a(int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            this.G = i2;
            this.H = i3;
            u.b("NativeVideoController", "width=" + i2 + "height=" + i3);
        }
    }

    private boolean z() {
        u.b("NativeVideoController", "retryCount=" + this.I);
        int i2 = this.I;
        if (1 <= i2) {
            h hVar = this.b;
            if (hVar != null) {
                hVar.w();
                this.b.a(this.r, this.n, false);
            }
            return false;
        } else if (this.g == null) {
            return false;
        } else {
            this.I = i2 + 1;
            u.b("NativeVideoController", "isPlaying=" + this.g.g() + ",isPaused=" + this.g.i() + ",isPrepared=" + this.g.k() + ",isStarted=" + this.g.h());
            if (!this.g.g() || !this.g.i() || !this.g.k() || !this.g.h()) {
                return true;
            }
            return false;
        }
    }

    private void b(Context context) {
        View view;
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        if (this.s) {
            view = c(context);
        } else {
            view = LayoutInflater.from(context.getApplicationContext()).inflate(ac.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        }
        if (view != null) {
            if (this.s) {
                this.b = new h(context, view, true, noneOf, this.r, this, a());
            } else {
                this.b = new g(context, view, true, noneOf, this.r, this, false);
            }
            this.b.a(this);
        }
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(ac.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(ac.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(ac.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(ac.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(ac.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(ac.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(ac.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, ac.g(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(ac.e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(ac.c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(ac.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(ac.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(ac.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(ac.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public f(Context context, ViewGroup viewGroup, l lVar, String str, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.L = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.g != null) {
                    f.this.g.e();
                }
            }
        };
        this.M = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.h != null) {
                    f.this.h.a();
                }
            }
        };
        this.N = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.g != null) {
                    if (f.this.k <= 0) {
                        f.this.g.e();
                    }
                    f.this.g.f();
                }
                f.this.d.postDelayed(this, 200);
            }
        };
        this.O = 0;
        this.P = 0;
        this.a = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.b != null) {
                    f.this.b.a(f.this.r, f.this.n, false);
                    f.this.b.w();
                    f.this.d(true);
                    u.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.U = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass7 */

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    f.this.h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    f.this.d(context);
                }
            }
        };
        this.V = 1;
        this.W = false;
        this.V = x.c(context);
        b(z2);
        this.u = str;
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17 ? true : z5;
        this.v = z3;
        this.w = z4;
    }

    public f(Context context, ViewGroup viewGroup, l lVar, String str, boolean z2, boolean z3) {
        boolean z4 = false;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.y = 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.L = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.g != null) {
                    f.this.g.e();
                }
            }
        };
        this.M = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.h != null) {
                    f.this.h.a();
                }
            }
        };
        this.N = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.g != null) {
                    if (f.this.k <= 0) {
                        f.this.g.e();
                    }
                    f.this.g.f();
                }
                f.this.d.postDelayed(this, 200);
            }
        };
        this.O = 0;
        this.P = 0;
        this.a = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.b != null) {
                    f.this.b.a(f.this.r, f.this.n, false);
                    f.this.b.w();
                    f.this.d(true);
                    u.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.U = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass7 */

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    f.this.h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    f.this.d(context);
                }
            }
        };
        this.V = 1;
        this.W = false;
        this.V = x.c(context);
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17 ? true : z4;
        this.v = z2;
        this.w = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h v() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.AbstractC0046c cVar) {
        this.E = new WeakReference<>(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z2) {
        u.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + str);
        if (TextUtils.isEmpty(str)) {
            u.f("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.t = z2;
        this.i = j2;
        int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i4 <= 0) {
            this.q = false;
            this.p = false;
        }
        if (i4 > 0) {
            this.i = j2;
            long j3 = this.j;
            if (j3 > j2) {
                j2 = j3;
            }
            this.j = j2;
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
            if (this.O == 0) {
                this.b.d();
            }
            this.b.c(i2, i3);
            this.b.c(this.c.get());
            this.b.a(i2, i3);
        }
        if (this.g == null) {
            this.g = new d(this.d);
        }
        u.b("tag_video_play", "[video] new MediaPlayer");
        this.f = 0;
        try {
            a(str);
            return true;
        } catch (Exception e2) {
            u.f("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e2.toString());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public d u() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.i = j2;
        long j3 = this.j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.j = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z2) {
        this.s = z2;
        h hVar = this.b;
        if (hVar != null) {
            hVar.c(z2);
        }
    }

    public boolean a() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.y = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.k = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        d dVar = this.g;
        if (dVar == null) {
            return 0;
        }
        return dVar.o() + this.y;
    }

    public boolean b() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z2) {
        this.t = z2;
        d dVar = this.g;
        if (dVar != null) {
            dVar.b(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.j, this.k);
    }

    private void a(String str) {
        u.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.a = str;
            l lVar = this.r;
            if (lVar != null) {
                if (lVar.R() != null) {
                    aVar.d = this.r.R().l();
                }
                aVar.b = String.valueOf(aj.d(this.r.aj()));
            }
            aVar.c = 0;
            this.g.a(aVar);
            u.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.b.d(8);
            this.b.d(0);
            a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    f.this.e = System.currentTimeMillis();
                    f.this.b.c(0);
                    if (f.this.g != null && f.this.i == 0) {
                        f.this.g.a(true, 0L, !f.this.t);
                    } else if (f.this.g != null) {
                        f.this.g.a(true, f.this.i, !f.this.t);
                    }
                    if (f.this.d != null) {
                        f.this.d.postDelayed(f.this.L, 100);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            f();
        }
    }

    /* access modifiers changed from: private */
    public void A() {
        B();
        this.d.postDelayed(this.N, 800);
    }

    private void B() {
        this.d.removeCallbacks(this.N);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.x = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (u() == null) {
            return 0;
        }
        return u().n();
    }

    private void b(int i2) {
        h hVar;
        this.O++;
        if (C() && (hVar = this.b) != null) {
            hVar.w();
            c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
            }
            this.f = System.currentTimeMillis() - this.e;
            if (!aj.b(this.r) || this.O >= 2) {
                this.b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", p(), 100, c());
                this.q = true;
                long j2 = this.k;
                a(j2, j2);
                long j3 = this.k;
                this.i = j3;
                this.j = j3;
            }
            if (!this.s && this.S) {
                e(this.b, null);
            }
            this.B = true;
            if (aj.b(this.r) && this.O < 2) {
                g();
            }
        }
    }

    private boolean C() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (!this.b.k() || !this.m) {
                b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.l == null) {
            this.l = Collections.synchronizedList(new ArrayList());
        }
        this.l.add(runnable);
    }

    private void D() {
        List<Runnable> list = this.l;
        if (list != null && !list.isEmpty()) {
            Iterator it2 = new ArrayList(this.l).iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
            this.l.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.h = aVar;
    }

    protected Map<String, Object> c() {
        return aj.a(this.r, o(), u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
        if (!this.q && this.p) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.u.a().b()) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
            }
            com.bytedance.sdk.openadsdk.core.u.a().a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.b;
        if (hVar2 != null) {
            hVar2.u();
        }
        E();
    }

    public void g(boolean z2) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.b;
        if (hVar2 != null && z2) {
            hVar2.u();
        }
        E();
    }

    private void E() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(false, this.i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", p(), r(), c());
        }
    }

    public void d(long j2) {
        this.i = j2;
        long j3 = this.j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.j = j2;
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(true, this.i, !this.t);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z2) {
        if (this.s) {
            this.P = p();
        }
        if (!this.q && this.p) {
            if (z2) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_break", this.P, r(), c());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", this.P, r(), c());
            }
        }
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.c();
            this.g = null;
        }
        if (!aj.b(this.r) || this.O == 2) {
            this.b.a(this.r, this.n, true);
        }
        al alVar = this.d;
        if (alVar != null) {
            alVar.removeCallbacks(this.N);
            this.d.removeCallbacks(this.M);
            this.d.removeCallbacks(this.L);
            this.d.removeCallbacksAndMessages(null);
        }
        B();
        List<Runnable> list = this.l;
        if (list != null) {
            list.clear();
        }
        if (this.s) {
            y();
        }
    }

    private void F() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.Q;
        this.R = elapsedRealtime;
        if (!this.p) {
            Map<String, Object> a2 = aj.a(elapsedRealtime, this.r, u());
            if (this.D) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_auto_play", a2);
            } else if (this.i <= 0) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_play", a2);
            }
            this.p = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        if (this.b != null && message != null && (weakReference = this.n) != null && weakReference.get() != null) {
            int i2 = message.what;
            if (i2 != 108) {
                if (i2 != 109) {
                    if (i2 == 308) {
                        u.f("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
                        G();
                        b(308, 0);
                    } else if (i2 != 309) {
                        switch (i2) {
                            case 302:
                                b(message.what);
                                return;
                            case 303:
                                int i3 = message.arg1;
                                int i4 = message.arg2;
                                b(i3, i4);
                                u.f("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                                if (!e() || i4 == -1004) {
                                    u.f("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i3 + "," + i4);
                                    if (c(i3, i4)) {
                                        u.f("NativeVideoController", "出错后展示结果页、、、、、、、");
                                        this.b.a(this.r, this.n, false);
                                        d(true);
                                        m();
                                    }
                                    h hVar = this.b;
                                    if (hVar != null) {
                                        hVar.w();
                                    }
                                    c.a aVar = this.h;
                                    if (aVar != null) {
                                        aVar.b(this.f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
                                    }
                                    WeakReference<c.AbstractC0046c> weakReference3 = this.E;
                                    if (weakReference3 != null && weakReference3.get() != null && !e()) {
                                        this.E.get().a(i3, i4);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 304:
                                int i5 = message.arg1;
                                h hVar2 = this.b;
                                if (hVar2 != null) {
                                    if (i5 == 3 || i5 == 702) {
                                        hVar2.w();
                                        this.d.removeCallbacks(this.a);
                                        this.J = false;
                                    } else if (i5 == 701) {
                                        hVar2.t();
                                        this.d.postDelayed(this.a, 8000);
                                        this.J = true;
                                    }
                                }
                                if (this.o && i5 == 3) {
                                    if (!(!this.s || (weakReference2 = this.F) == null || weakReference2.get() == null)) {
                                        this.F.get().f();
                                    }
                                    this.d.removeCallbacks(this.a);
                                }
                                if (this.o && i5 == 3) {
                                    F();
                                    return;
                                }
                                return;
                            case 305:
                                WeakReference<c.AbstractC0046c> weakReference4 = this.E;
                                if (!(weakReference4 == null || weakReference4.get() == null)) {
                                    this.E.get().f();
                                }
                                al alVar = this.d;
                                if (alVar != null) {
                                    alVar.removeCallbacks(this.M);
                                }
                                if (!this.o) {
                                    F();
                                }
                                h hVar3 = this.b;
                                if (hVar3 != null) {
                                    hVar3.w();
                                }
                                this.d.removeCallbacks(this.a);
                                return;
                            case 306:
                                h hVar4 = this.b;
                                if (hVar4 != null) {
                                    hVar4.w();
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case 311:
                                        I();
                                        return;
                                    case 312:
                                        if (z()) {
                                            u.f("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                            m();
                                            this.g = null;
                                            a(this.r.R().i(), this.r.ag(), this.G, this.H, null, this.r.aj(), 0, b());
                                            return;
                                        }
                                        u.c("NativeVideoController", "不满足条件，无法重试");
                                        b(312, 0);
                                        return;
                                    case 313:
                                        H();
                                        WeakReference<a> weakReference5 = this.F;
                                        if (weakReference5 != null && weakReference5.get() != null) {
                                            this.F.get().f();
                                            return;
                                        }
                                        return;
                                    case 314:
                                        try {
                                            ((Boolean) message.obj).booleanValue();
                                        } catch (Throwable unused) {
                                        }
                                        this.Q = SystemClock.elapsedRealtime();
                                        return;
                                    default:
                                        return;
                                }
                        }
                    } else {
                        u.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
                    }
                } else if (message.obj instanceof Long) {
                    long longValue = ((Long) message.obj).longValue();
                    this.i = longValue;
                    long j2 = this.j;
                    if (j2 <= longValue) {
                        j2 = longValue;
                    }
                    this.j = j2;
                    a(longValue, this.k);
                }
            } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                this.k = ((Long) message.obj).longValue();
            }
        }
    }

    private void b(int i2, int i3) {
        if (this.r != null) {
            boolean e2 = e();
            String str = e2 ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.r, i2, i3, u());
            if (e2) {
                a2.put("duration", Long.valueOf(p()));
                a2.put("percent", Integer.valueOf(r()));
                a2.put("buffers_time", Long.valueOf(o()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.n.get(), this.r, this.u, str, a2);
        }
    }

    private void G() {
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.f("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
            this.b.a(this.r, this.n, false);
            d(true);
            m();
        }
    }

    private void H() {
        u.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
            i();
        }
    }

    private void I() {
        d dVar;
        WeakReference<ViewGroup> weakReference;
        int i2;
        int i3;
        u.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            WeakReference<Context> weakReference2 = this.n;
            if (!(weakReference2 == null || weakReference2.get() == null || J() == null || (dVar = this.g) == null || dVar.a() == null || (weakReference = this.c) == null)) {
                if (weakReference.get() != null) {
                    MediaPlayer a2 = this.g.a();
                    int videoWidth = a2.getVideoWidth();
                    int videoHeight = a2.getVideoHeight();
                    int width = this.c.get().getWidth();
                    int height = this.c.get().getHeight();
                    if (width > 0 && height > 0 && videoHeight > 0) {
                        if (videoWidth > 0) {
                            if (videoWidth == videoHeight) {
                                i3 = width > height ? height : width;
                                i2 = i3;
                            } else if (videoWidth > videoHeight) {
                                i3 = (int) ((((double) width) * 1.0d) / ((double) ((((float) videoWidth) * 1.0f) / ((float) videoHeight))));
                                i2 = width;
                            } else {
                                i2 = (int) ((((double) height) * 1.0d) / ((double) ((((float) videoHeight) * 1.0f) / ((float) videoWidth))));
                                i3 = height;
                            }
                            if (i3 <= height) {
                                if (i3 > 0) {
                                    height = i3;
                                }
                            }
                            if (i2 <= width) {
                                if (i2 > 0) {
                                    width = i2;
                                }
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                            layoutParams.addRule(13);
                            if (J() instanceof TextureView) {
                                ((TextureView) J()).setLayoutParams(layoutParams);
                                u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                                return;
                            } else if (J() instanceof SurfaceView) {
                                ((SurfaceView) J()).setLayoutParams(layoutParams);
                                u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    u.b("ChangeVideoSize", " container or video exist size <= 0");
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[step-1] >>>>> mContextRef=");
            sb.append(this.n);
            sb.append(",mContextRef.get()=");
            WeakReference<Context> weakReference3 = this.n;
            sb.append(weakReference3 != null ? weakReference3.get() : null);
            sb.append(",getIRenderView() =");
            sb.append(J());
            u.b("ChangeVideoSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
            boolean z2 = true;
            sb2.append(this.g == null);
            sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            d dVar2 = this.g;
            if (dVar2 == null || dVar2.a() != null) {
                z2 = false;
            }
            sb2.append(z2);
            u.b("ChangeVideoSize", sb2.toString());
        } catch (Throwable th) {
            u.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        h hVar;
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (hVar = this.b) == null) {
            return null;
        }
        return hVar.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.g != null && C()) {
            if (this.g.g()) {
                h();
                this.b.b(true, false);
                this.b.c();
            } else if (!this.g.i()) {
                h hVar = this.b;
                if (hVar != null) {
                    hVar.c(this.c.get());
                }
                d(this.i);
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.b(false, false);
                }
            } else {
                g(false);
                h hVar3 = this.b;
                if (hVar3 != null) {
                    hVar3.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        if (this.g != null) {
            A();
            a(this.T, c(i2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        if (this.g != null) {
            B();
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z2) {
        if (C()) {
            long l2 = (long) ((((float) (((long) i2) * this.k)) * 1.0f) / ((float) ac.l(this.n.get(), "tt_video_progress_max")));
            if (this.k > 0) {
                this.T = (long) ((int) l2);
            } else {
                this.T = 0;
            }
            h hVar = this.b;
            if (hVar != null) {
                hVar.a(this.T);
            }
        }
    }

    private void a(long j2, long j3) {
        this.i = j2;
        this.k = j3;
        this.b.a(j2, j3);
        this.b.a(com.bytedance.sdk.openadsdk.core.video.e.a.a(j2, j3));
        try {
            c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(j2, j3);
            }
        } catch (Throwable th) {
            u.c("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (C()) {
            h(!this.S);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.S) {
                a(z2 ? 8 : 0);
                h hVar = this.b;
                if (hVar != null) {
                    hVar.a(this.c.get());
                    this.b.b(false);
                }
            } else {
                a(1);
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.b(this.c.get());
                    this.b.b(false);
                }
            }
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    public void a(int i2) {
        if (C()) {
            boolean z2 = i2 == 0 || i2 == 8;
            Context context = this.n.get();
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
        h hVar = this.b;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.s) {
            h();
        }
        if (z2 && !this.s && !d()) {
            this.b.b(!e(), false);
            this.b.a(z3, true, false);
        }
        d dVar = this.g;
        if (dVar == null || !dVar.g()) {
            this.b.c();
            return;
        }
        this.b.c();
        this.b.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.S) {
            h(false);
            h hVar = this.b;
            if (hVar != null) {
                hVar.b(this.c.get());
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

    public void a(b bVar, View view, boolean z2) {
        K();
    }

    private void K() {
        if (C()) {
            h(!this.S);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            h hVar = this.b;
            if (hVar != null) {
                hVar.b(this.c.get());
                this.b.b(false);
            }
            a(1);
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    private void h(boolean z2) {
        this.S = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(true);
        }
        d dVar2 = this.g;
        if (dVar2 != null) {
            dVar2.a(surfaceHolder);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(true);
        }
        d dVar2 = this.g;
        if (dVar2 != null) {
            dVar2.a(surfaceTexture);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    public boolean d() {
        d dVar = this.g;
        return dVar == null || dVar.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (x.c(p.a()) != 0) {
            m();
            a(this.r.R().i(), this.r.ag(), this.G, this.H, null, this.r.aj(), 0, b());
            d(false);
        }
    }

    public boolean e() {
        d dVar = this.g;
        return dVar != null && dVar.g();
    }

    private void a(long j2, boolean z2) {
        if (this.g != null) {
            if (z2) {
                L();
            }
            this.g.a(j2);
        }
    }

    private boolean c(int i2) {
        return this.b.b(i2);
    }

    private void L() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.c(0);
            this.b.a(false, false);
            this.b.b(false);
            this.b.b();
            this.b.d();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$8  reason: invalid class name */
    /* compiled from: NativeVideoController */
    static /* synthetic */ class AnonymousClass8 {
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
        int i2 = AnonymousClass8.a[aVar.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 == 3) {
            k();
            this.z = false;
            this.A = true;
        }
    }

    private boolean d(int i2) {
        l lVar;
        int c2 = x.c(p.a());
        if (c2 == 0) {
            h();
            this.z = true;
            h hVar = this.b;
            if (hVar != null) {
                hVar.a(this.r, this.n, false);
            }
        }
        if (c2 != 4 && c2 != 0) {
            h hVar2 = this.b;
            if (hVar2 != null) {
                hVar2.e();
            }
            h();
            this.z = true;
            this.A = false;
            h hVar3 = this.b;
            if (!(hVar3 == null || (lVar = this.r) == null)) {
                return hVar3.a(i2, lVar.R(), this.w);
            }
        } else if (c2 == 4) {
            this.z = false;
            h hVar4 = this.b;
            if (hVar4 != null) {
                hVar4.q();
            }
        }
        return true;
    }

    private void a(Context context, int i2) {
        if (C() && context != null && this.V != i2) {
            this.V = i2;
            if (!(i2 == 4 || i2 == 0)) {
                this.A = false;
            }
            if (!this.A && !w() && this.v) {
                d(2);
            }
            WeakReference<a> weakReference = this.F;
            if (weakReference != null && weakReference.get() != null) {
                this.F.get().a(this.V);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(Context context) {
        int c2 = x.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.z = false;
        }
    }

    public void a(Context context) {
        int c2 = x.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.z = false;
            k();
        }
    }

    public void f() {
        if (!this.W && this.K) {
            Context applicationContext = p.a().getApplicationContext();
            this.W = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.U, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    public void y() {
        if (this.W && this.K) {
            Context applicationContext = p.a().getApplicationContext();
            this.W = false;
            try {
                applicationContext.unregisterReceiver(this.U);
            } catch (Exception unused) {
            }
        }
    }

    public void a(a aVar) {
        this.F = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z2) {
        this.B = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z2) {
        this.D = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.J;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z2) {
        this.K = z2;
    }

    private boolean c(int i2, int i3) {
        u.b("TTVideoWebPageActivity", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z2;
    }
}
