package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoTsView extends FrameLayout implements c.a, f.a, al.a {
    private ViewStub A;
    private c.b B;
    private final AtomicBoolean C;
    private boolean D;
    private boolean E;
    private AtomicBoolean F;
    private final Context a;
    protected final l b;
    protected c c;
    protected FrameLayout d;
    protected boolean e;
    protected RelativeLayout f;
    protected ImageView g;
    protected ImageView h;
    protected ImageView i;
    protected boolean j;
    protected String k;

    /* renamed from: l  reason: collision with root package name */
    protected int f1320l;
    AtomicBoolean m;
    boolean n;
    public a o;
    private ViewGroup p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private long w;
    private final al x;
    private boolean y;
    private final String z;

    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    public interface b {
        void a(View view, int i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j2, int i2) {
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar = this.c;
        if (cVar != null) {
            ((f) cVar).a(drawVideoListener);
        }
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar = this.c;
        if (cVar != null) {
            ((f) cVar).a(bVar);
        }
    }

    public void setControllerStatusCallBack(a aVar) {
        this.o = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, int i2) {
        c.b bVar = this.B;
        if (bVar != null) {
            bVar.d();
        }
    }

    private void d() {
        a(0L, 0);
        this.B = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, long j3) {
        c.b bVar = this.B;
        if (bVar != null) {
            bVar.a(j2, j3);
        }
    }

    public NativeVideoTsView(Context context, l lVar) {
        this(context, lVar, false, false);
    }

    public NativeVideoTsView(Context context, l lVar, boolean z2, boolean z3) {
        this(context, lVar, z2, z3, "embeded_ad", false, false);
    }

    public NativeVideoTsView(Context context, l lVar, String str, boolean z2, boolean z3) {
        this(context, lVar, false, false, str, z2, z3);
    }

    public NativeVideoTsView(Context context, l lVar, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
        super(context);
        this.q = true;
        this.e = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.j = true;
        this.k = "embeded_ad";
        this.f1320l = 50;
        this.v = true;
        this.m = new AtomicBoolean(false);
        this.x = new al(this);
        this.y = false;
        this.z = Build.MODEL;
        this.n = false;
        this.C = new AtomicBoolean(false);
        this.D = true;
        this.F = new AtomicBoolean(false);
        this.k = str;
        this.a = context;
        this.b = lVar;
        this.r = z2;
        this.u = z3;
        this.s = z4;
        this.t = z5;
        setContentDescription("NativeVideoAdView");
        b();
        e();
    }

    protected void b() {
        l lVar = this.b;
        if (lVar != null) {
            int d2 = aj.d(lVar.aj());
            int c2 = p.h().c(d2);
            if (c2 == 1) {
                this.q = x.d(this.a);
            } else if (c2 == 2) {
                this.q = x.e(this.a) || x.d(this.a);
            } else if (c2 == 3) {
                this.q = false;
            } else if (c2 == 4) {
                this.n = true;
            }
            if (!this.r) {
                this.e = p.h().a(d2);
            } else {
                this.e = false;
            }
            if ("splash_ad".equals(this.k)) {
                this.q = true;
                this.e = true;
            }
            c cVar = this.c;
            if (cVar != null) {
                cVar.e(this.q);
            }
            if ("feed_video_middle_page".equals(this.k)) {
                this.q = true;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        c cVar;
        if (!(this.r || (aVar = this.o) == null || (cVar = this.c) == null)) {
            aVar.a(cVar.w(), this.c.s(), this.c.p(), this.c.n(), this.q);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(ac.e(this.a, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.p = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(ac.e(this.a, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.d = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(ac.e(this.a, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ac.f(this.a, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.A = viewStub;
        return frameLayout;
    }

    private void e() {
        addView(a(this.a));
        k();
    }

    public void g() {
        ViewStub viewStub;
        if (this.a != null && (viewStub = this.A) != null && viewStub.getParent() != null && this.b != null && this.f == null) {
            this.f = (RelativeLayout) this.A.inflate();
            this.g = (ImageView) findViewById(ac.e(this.a, "tt_native_video_img_id"));
            ImageView imageView = (ImageView) findViewById(ac.e(this.a, "tt_native_video_play"));
            this.i = imageView;
            if (this.j) {
                ak.a((View) imageView, 0);
            }
            if (!(this.b.R() == null || this.b.R().h() == null)) {
                d.a(this.a).a(this.b.R().h(), this.g);
            }
            j();
        }
    }

    private void j() {
        if ((this instanceof NativeDrawVideoTsView) && !this.m.get() && i.d().t() != null) {
            this.i.setImageBitmap(i.d().t());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            int a2 = (int) ak.a(getContext(), (float) this.f1320l);
            layoutParams.width = a2;
            layoutParams.height = a2;
            this.i.setLayoutParams(layoutParams);
            this.m.set(true);
        }
    }

    private void k() {
        this.c = new f(this.a, this.d, this.b, this.k, !v(), this.s, this.t);
        l();
        this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ((f) NativeVideoTsView.this.c).a(NativeVideoTsView.this.p.getWidth(), NativeVideoTsView.this.p.getHeight());
                NativeVideoTsView.this.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setVideoAdLoadListener(c.AbstractC0046c cVar) {
        c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.a(cVar);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public boolean a(long j2, boolean z2, boolean z3) {
        int i2;
        long j3;
        this.p.setVisibility(0);
        if (this.c == null) {
            this.c = new f(this.a, this.d, this.b, this.k, this.s, this.t);
            l();
        }
        this.w = j2;
        if (!v()) {
            return true;
        }
        this.c.b(false);
        l lVar = this.b;
        boolean a2 = (lVar == null || lVar.R() == null) ? false : this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), j2, u());
        int i3 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if ((i3 > 0 && !z2 && !z3) || (i3 > 0 && z2 && !this.u)) {
            c cVar = this.c;
            if (cVar != null) {
                j3 = cVar.p();
                i2 = this.c.r();
            } else {
                j3 = 0;
                i2 = 0;
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.a, this.b, this.k, "feed_continue", j3, i2, aj.a(this.b, this.c.o(), this.c.u()));
        }
        return a2;
    }

    private void l() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.e(this.q);
            ((f) this.c).a((f.a) this);
            this.c.a(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m();
    }

    private void m() {
        c cVar = this.c;
        if (cVar == null) {
            k();
        } else if ((cVar instanceof f) && !v()) {
            ((f) this.c).f();
        }
        if (this.c != null && this.C.get()) {
            this.C.set(false);
            b();
            if (h()) {
                ak.a((View) this.f, 8);
                ImageView imageView = this.h;
                if (imageView != null) {
                    ak.a((View) imageView, 8);
                }
                l lVar = this.b;
                if (lVar == null || lVar.R() == null) {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                    return;
                }
                this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), 0, u());
                this.c.d(false);
            } else if (this.c.w()) {
                u.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.c.w());
                b(true);
            } else {
                u.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                g();
                ak.a((View) this.f, 0);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        n();
    }

    private void n() {
        this.o = null;
        i();
        o();
    }

    private void o() {
        if (!this.C.get()) {
            this.C.set(true);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(true);
            }
        }
        this.F.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 1) {
            p();
        }
    }

    private void p() {
        c(y.a(this, 50, 5));
        this.x.sendEmptyMessageDelayed(1, 500);
    }

    private boolean q() {
        if (v()) {
            return false;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
        if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || a2) {
            return true;
        }
        return false;
    }

    private void r() {
        if (!v()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
        }
    }

    private void c(boolean z2) {
        if (this.b != null && this.c != null) {
            boolean q2 = q();
            r();
            if (q2 && this.c.w()) {
                u.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q2 + "，mNativeVideoController.isPlayComplete()=" + this.c.w());
                b(true);
                d();
            } else if (!z2 || this.c.w() || this.c.t()) {
                if (this.c.u() != null && this.c.u().g()) {
                    this.c.h();
                    c.b bVar = this.B;
                    if (bVar != null) {
                        bVar.e_();
                    }
                }
            } else if (this.c.u() == null || !this.c.u().i()) {
                if (this.q && this.c.u() == null) {
                    if (!this.C.get()) {
                        this.C.set(true);
                    }
                    this.F.set(false);
                    m();
                }
            } else if (this.q) {
                if ("ALP-AL00".equals(this.z)) {
                    this.c.k();
                } else {
                    ((f) this.c).g(q2);
                }
                c.b bVar2 = this.B;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        super.onWindowFocusChanged(z2);
        s();
        if (!q() || (cVar4 = this.c) == null || !cVar4.w()) {
            b();
            if (v() || !h() || (cVar2 = this.c) == null || cVar2.t()) {
                if (h()) {
                    return;
                }
                if (!z2 && (cVar = this.c) != null && cVar.u() != null && this.c.u().g()) {
                    this.x.removeMessages(1);
                    c(false);
                } else if (z2) {
                    this.x.obtainMessage(1).sendToTarget();
                }
            } else if (this.x == null) {
            } else {
                if (!z2 || (cVar3 = this.c) == null || cVar3.w()) {
                    this.x.removeMessages(1);
                    c(false);
                    return;
                }
                this.x.obtainMessage(1).sendToTarget();
            }
        } else {
            r();
            ak.a((View) this.f, 8);
            b(true);
            d();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        c cVar;
        l lVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i2);
        s();
        if (this.D) {
            this.D = i2 == 0;
        }
        if (!q() || (cVar3 = this.c) == null || !cVar3.w()) {
            b();
            if (!v() && h() && (cVar = this.c) != null && !cVar.t() && (lVar = this.b) != null) {
                if (!this.v || lVar.R() == null) {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                } else {
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                    this.v = false;
                    ak.a((View) this.f, 8);
                }
                if (i2 == 0 && this.x != null && (cVar2 = this.c) != null && !cVar2.w()) {
                    this.x.obtainMessage(1).sendToTarget();
                    return;
                }
                return;
            }
            return;
        }
        r();
        ak.a((View) this.f, 8);
        b(true);
        d();
    }

    private void s() {
        if (!(this.c == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false))) {
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.c.p());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.c.s());
            this.c.d(a2);
            if (a2) {
                this.c.a(a5);
            } else {
                this.c.a(a3);
            }
            this.c.b(a4);
            this.c.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
            u.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.c = cVar;
    }

    public c getNativeVideoController() {
        return this.c;
    }

    public boolean h() {
        return this.q;
    }

    public void setIsAutoPlay(boolean z2) {
        l lVar;
        if (!this.y && (lVar = this.b) != null) {
            int c2 = p.h().c(aj.d(lVar.aj()));
            if (z2 && c2 != 4 && (!x.e(this.a) ? !x.d(this.a) : !t())) {
                z2 = false;
            }
            this.q = z2;
            c cVar = this.c;
            if (cVar != null) {
                cVar.e(z2);
            }
            if (!this.q) {
                g();
                RelativeLayout relativeLayout = this.f;
                if (relativeLayout != null) {
                    ak.a((View) relativeLayout, 0);
                    if (this.b.R() != null) {
                        d.a(this.a).a(this.b.R().h(), this.g);
                    } else {
                        u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                    }
                }
            } else {
                ak.a((View) this.f, 8);
            }
            this.y = true;
        }
    }

    private boolean t() {
        return 2 == p.h().c(aj.d(this.b.aj()));
    }

    private boolean u() {
        return this.e;
    }

    public void setIsQuiet(boolean z2) {
        this.e = z2;
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(z2);
        }
    }

    private boolean v() {
        return this.r;
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.B = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void f() {
        c.b bVar = this.B;
        if (bVar != null && !this.E) {
            this.E = true;
            bVar.d_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z2) {
        this.j = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i2) {
        b();
    }

    protected void b(int i2) {
        if (x.c(p.a()) != 0) {
            if (this.c.u() != null) {
                if (this.c.u().g() && i2 == 2) {
                    c(false);
                    al alVar = this.x;
                    if (alVar != null) {
                        alVar.removeMessages(1);
                    }
                    a(true);
                    return;
                } else if (this.c.u().i() && i2 == 3) {
                    this.q = true;
                    c(true);
                    b();
                    al alVar2 = this.x;
                    if (alVar2 != null) {
                        alVar2.sendEmptyMessageDelayed(1, 500);
                    }
                    a(false);
                    return;
                }
            }
            if (!h() && !this.F.get()) {
                this.F.set(true);
                l lVar = this.b;
                if (lVar == null || lVar.R() == null) {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                } else {
                    w();
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                }
                al alVar3 = this.x;
                if (alVar3 != null) {
                    alVar3.sendEmptyMessageDelayed(1, 500);
                }
                a(false);
            }
        }
    }

    protected void c() {
        if (x.c(p.a()) != 0) {
            if (this.c.u() != null) {
                if (this.c.u().g()) {
                    c(false);
                    al alVar = this.x;
                    if (alVar != null) {
                        alVar.removeMessages(1);
                    }
                    a(true);
                    return;
                } else if (this.c.u().i()) {
                    this.q = true;
                    c(true);
                    b();
                    al alVar2 = this.x;
                    if (alVar2 != null) {
                        alVar2.sendEmptyMessageDelayed(1, 500);
                    }
                    a(false);
                    return;
                }
            }
            if (!h() && !this.F.get()) {
                this.F.set(true);
                l lVar = this.b;
                if (lVar == null || lVar.R() == null) {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                } else {
                    w();
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                }
                al alVar3 = this.x;
                if (alVar3 != null) {
                    alVar3.sendEmptyMessageDelayed(1, 500);
                }
                a(false);
            }
        }
    }

    protected void a(boolean z2) {
        if (this.h == null) {
            this.h = new ImageView(getContext());
            if (i.d().t() != null) {
                this.h.setImageBitmap(i.d().t());
            } else {
                this.h.setImageResource(ac.d(p.a(), "tt_new_play_video"));
            }
            this.h.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) ak.a(getContext(), (float) this.f1320l);
            int a3 = (int) ak.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.p.addView(this.h, layoutParams);
        }
        if (z2) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void b(boolean z2) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.d(z2);
            h v2 = this.c.v();
            if (v2 != null) {
                v2.w();
                View s2 = v2.s();
                if (s2 != null) {
                    if (s2.getParent() != null) {
                        ((ViewGroup) s2.getParent()).removeView(s2);
                    }
                    s2.setVisibility(0);
                    addView(s2);
                    v2.a(this.b, new WeakReference<>(this.a), false);
                }
            }
        }
    }

    public void i() {
        h v2;
        c cVar = this.c;
        if (cVar != null && (v2 = cVar.v()) != null) {
            v2.e();
            View s2 = v2.s();
            if (s2 != null) {
                s2.setVisibility(8);
                if (s2.getParent() != null) {
                    ((ViewGroup) s2.getParent()).removeView(s2);
                }
            }
        }
    }

    private void w() {
        ak.f(this.h);
        ak.f(this.f);
    }
}
