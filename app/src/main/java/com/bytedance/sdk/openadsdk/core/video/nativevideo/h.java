package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.e.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.video.renderview.a;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.g;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: NativeVideoLayout */
public class h implements b, a, g.a, h.b, al.a {
    com.bytedance.sdk.openadsdk.core.widget.h A;
    d B;
    boolean C;
    com.bytedance.sdk.openadsdk.downloadnew.core.a D;
    c E;
    com.bytedance.sdk.openadsdk.core.a.a F;
    com.bytedance.sdk.openadsdk.core.a.a G;
    TTDrawFeedAd.DrawVideoListener H;
    boolean I;
    private View J;
    private TextView K;
    private TextView L;
    private NativeVideoTsView.b M;
    private final String N;
    View a;
    b b;
    ImageView c;
    View d;
    View e;
    ImageView f;
    ViewStub g;
    View h;
    ImageView i;
    View j;
    RoundImageView k;

    /* renamed from: l  reason: collision with root package name */
    TextView f1322l;
    TextView m;
    TextView n;
    ProgressBar o;
    ViewStub p;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    boolean v;
    int w;
    EnumSet<b.a> x;
    l y;
    Context z;

    public void a(long j2) {
    }

    public void a(long j2, long j3) {
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.g.a
    public void a(View view, boolean z2) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void a(boolean z2) {
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(boolean z2) {
    }

    public boolean b(int i2) {
        return false;
    }

    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.h.b
    public boolean h() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.g.a
    public void l() {
    }

    public h(Context context, View view, boolean z2, EnumSet<b.a> enumSet, l lVar, c cVar, boolean z3) {
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (!(this instanceof g)) {
            this.z = p.a().getApplicationContext();
            c(z3);
            this.a = view;
            this.u = z2;
            this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
            this.E = cVar;
            this.y = lVar;
            c(8);
            a(context, this.a);
            a();
            n();
        }
    }

    public h(Context context, View view, boolean z2, EnumSet<b.a> enumSet, l lVar, c cVar) {
        this(context, view, z2, enumSet, lVar, cVar, true);
    }

    void n() {
        int i2;
        String str;
        com.bytedance.sdk.openadsdk.core.a.a aVar;
        String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
        if (aj.b(this.y)) {
            str = this.C ? "draw_ad" : "draw_ad_landingpage";
            i2 = 6;
        } else if (aj.e(this.y)) {
            str = "rewarded_video";
            i2 = 7;
        } else if (aj.f(this.y)) {
            str = "fullscreen_interstitial_ad";
            i2 = 5;
        } else {
            str = str2;
            i2 = 1;
        }
        if (this.y.T() == 4) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.z, this.y, str);
            this.D = a2;
            a2.a(2, new a.AbstractC0050a() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.AbstractC0050a
                public boolean a(int i, l lVar, String str, String str2, Object obj) {
                    if (i == 2 && lVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        if (str2.equals("click_start_play")) {
                            d.a(h.this.z, h.this.y, str, h.this.C ? "click_start" : "click_start_detail", (JSONObject) null);
                            return true;
                        } else if (str2.equals("click_open")) {
                            if (h.this.C) {
                                d.j(h.this.z, h.this.y, str, aj.h(h.this.y), null);
                            } else {
                                d.i(h.this.z, h.this.y, str, "click_open_detail", null);
                            }
                        }
                    }
                    return true;
                }
            });
        }
        z();
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2);
        this.F = aVar2;
        aVar2.d(true);
        this.F.b(true);
        if (this.C) {
            this.F.a(true);
        } else {
            this.F.a(false);
            this.F.c(true);
        }
        this.F.a(this.E);
        this.F.e(true);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3 = this.D;
        if (!(aVar3 == null || (aVar = this.F) == null)) {
            aVar.a(aVar3);
        }
        if (y()) {
            AnonymousClass2 r0 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2) {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean b() {
                    boolean a2 = h.this.A != null ? h.this.A.a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(a2);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(h.this.c.getVisibility() == 0);
                    u.c("ClickCreativeListener", sb.toString());
                    if (a2 || h.this.c.getVisibility() == 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean c() {
                    return (h.this.h != null && h.this.h.getVisibility() == 0) || (h.this.j != null && h.this.j.getVisibility() == 0) || ((h.this.k != null && h.this.k.getVisibility() == 0) || (h.this.f1322l != null && h.this.f1322l.getVisibility() == 0));
                }
            };
            this.G = r0;
            r0.d(true);
            this.G.a(new b.a() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.core.a.b.a
                public void a(View view, int i) {
                    if (h.this.M != null) {
                        h.this.M.a(view, i);
                    }
                }
            });
            this.G.b(true);
            if (this.C) {
                this.G.a(true);
            } else {
                this.G.a(false);
            }
            this.G.a(this.E);
            this.G.e(true);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.D;
            if (aVar4 != null) {
                this.G.a(aVar4);
            }
            View view = this.a;
            if (view != null) {
                view.setOnClickListener(this.G);
                this.a.setOnTouchListener(this.G);
            }
        }
    }

    private boolean y() {
        l lVar = this.y;
        if (lVar == null || lVar.M() != null || this.y.k() != 1 || !l.c(this.y)) {
            return false;
        }
        return true;
    }

    public void a(NativeVideoTsView.b bVar) {
        this.M = bVar;
    }

    private void z() {
        if (this.z != null && this.a != null) {
            AnonymousClass4 r0 = new View(this.z) {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass4 */
                private final AtomicBoolean b = new AtomicBoolean(true);

                @Override // android.view.View
                protected void onMeasure(int i, int i2) {
                    super.onMeasure(0, 0);
                }

                @Override // android.view.View
                public void onWindowFocusChanged(boolean z) {
                    super.onWindowFocusChanged(z);
                    if (h.this.D == null) {
                        return;
                    }
                    if (z) {
                        h.this.D.b();
                    } else {
                        h.this.D.c();
                    }
                }

                @Override // android.view.View
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    a();
                }

                @Override // android.view.View
                public void onFinishTemporaryDetach() {
                    super.onFinishTemporaryDetach();
                    a();
                }

                private void a() {
                    if (this.b.getAndSet(false) && h.this.D != null) {
                        h.this.D.a();
                    }
                }

                private void b() {
                    if (!this.b.getAndSet(true) && h.this.D != null) {
                        h.this.D.d();
                    }
                }

                @Override // android.view.View
                protected void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    b();
                }

                @Override // android.view.View
                public void onStartTemporaryDetach() {
                    super.onStartTemporaryDetach();
                    b();
                }
            };
            View view = this.a;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(r0, 0, new RelativeLayout.LayoutParams(0, 0));
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        return this.b;
    }

    private boolean A() {
        return "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N);
    }

    void a(Context context, View view) {
        View view2;
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = aj.a(context);
        if (a2 == null) {
            a2 = "0";
        }
        boolean z2 = Build.VERSION.SDK_INT != 20 || Integer.valueOf(a2).intValue() >= 1572864;
        if (A() || !z2 || !i.d().s() || Build.VERSION.SDK_INT < 14) {
            view2 = new SSRenderSurfaceView(this.z);
            u.b("NewLiveViewLayout", "use SurfaceView......");
        } else {
            view2 = new SSRenderTextureView(this.z);
            u.b("NewLiveViewLayout", "use TextureView......");
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(view2, 0, layoutParams);
            view.setBackgroundColor(-16777216);
        }
        ak.a(view2, 8);
        this.b = (com.bytedance.sdk.openadsdk.core.video.renderview.b) view2;
        this.c = (ImageView) view.findViewById(ac.e(context, "tt_video_play"));
        this.o = (ProgressBar) view.findViewById(ac.e(context, "tt_video_progress"));
        this.d = view.findViewById(ac.e(context, "tt_video_loading_retry_layout"));
        this.e = view.findViewById(ac.e(context, "tt_video_loading_progress"));
        this.f = (ImageView) view.findViewById(ac.e(context, "tt_video_loading_cover_image"));
        this.g = (ViewStub) view.findViewById(ac.e(context, "tt_video_ad_cover"));
        this.p = (ViewStub) view.findViewById(ac.e(context, "tt_video_draw_layout_viewStub"));
        u.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    void a(View view, Context context) {
        ViewStub viewStub;
        if (view != null && context != null && (viewStub = this.g) != null && viewStub.getParent() != null && this.h == null) {
            this.h = this.g.inflate();
            this.i = (ImageView) view.findViewById(ac.e(context, "tt_video_ad_finish_cover_image"));
            this.j = view.findViewById(ac.e(context, "tt_video_ad_cover_center_layout"));
            this.k = (RoundImageView) view.findViewById(ac.e(context, "tt_video_ad_logo_image"));
            this.f1322l = (TextView) view.findViewById(ac.e(context, "tt_video_btn_ad_image_tv"));
            this.m = (TextView) view.findViewById(ac.e(context, "tt_video_ad_name"));
            this.n = (TextView) view.findViewById(ac.e(context, "tt_video_ad_button"));
        }
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        if (view != null && context != null && (viewStub = this.p) != null && viewStub.getParent() != null && this.J == null) {
            this.p.inflate();
            this.J = view.findViewById(ac.e(context, "tt_video_ad_cover_center_layout_draw"));
            this.K = (TextView) view.findViewById(ac.e(context, "tt_video_ad_button_draw"));
            this.L = (TextView) view.findViewById(ac.e(context, "tt_video_ad_replay"));
        }
    }

    void p() {
        if (this.B != null && this.A == null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.widget.h hVar = new com.bytedance.sdk.openadsdk.core.widget.h();
            this.A = hVar;
            hVar.a(this.z, this.a);
            this.A.a(this.B, this);
            u.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean a(int i2, t tVar, boolean z2) {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        return hVar == null || hVar.a(i2, tVar, z2);
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        if (hVar != null) {
            hVar.a(false);
        }
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.B = (d) aVar;
            p();
        }
    }

    boolean r() {
        if (this.B != null) {
            return true;
        }
        u.f("NewLiveViewLayout", "callback is null");
        return false;
    }

    void a() {
        this.b.a(this);
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass5 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!h.this.r()) {
                        return;
                    }
                    if (h.this.n == null || h.this.n.getVisibility() != 0) {
                        h.this.B.a(h.this, view);
                    }
                }
            });
        }
    }

    public void d(int i2) {
        ak.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void c(boolean z2) {
        this.C = z2;
        if (z2) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.G;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.a(false);
            this.F.c(true);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar4 = this.G;
        if (aVar4 != null) {
            aVar4.a(false);
            this.G.c(true);
        }
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = ak.c(this.z);
        }
        if (i2 > 0) {
            this.q = i2;
            if (i() || h() || this.x.contains(b.a.fixedSize)) {
                this.r = i3;
            } else {
                this.r = e(i2);
            }
            b(this.q, this.r);
        }
    }

    public void b(boolean z2, boolean z3) {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageResource(ac.d(this.z, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(ac.d(this.z, "tt_stop_movebar_textpage"));
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.a.setLayoutParams(layoutParams);
    }

    private int e(int i2) {
        if (this.s <= 0 || this.t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(ac.h(this.z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(ac.h(this.z, "tt_video_container_minheight"));
        int i3 = (int) (((float) this.t) * ((((float) i2) * 1.0f) / ((float) this.s)));
        if (i3 > dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    public void c(int i2, int i3) {
        this.s = i2;
        this.t = i3;
    }

    public void a(int i2) {
        u.c("Progress", "setSeekProgress-percent=" + i2);
        ak.a((View) this.o, 0);
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setProgress(i2);
        }
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.a.getParent() != null) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            viewGroup.addView(this.a);
            c(0);
        }
    }

    public View s() {
        return this.a;
    }

    public void d() {
        l lVar;
        ak.g(this.d);
        ak.g(this.e);
        if (!(this.f == null || (lVar = this.y) == null || lVar.R() == null || this.y.R().h() == null)) {
            ak.g(this.f);
            com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.f);
        }
        ImageView imageView = this.c;
        if (imageView != null && imageView.getVisibility() == 0) {
            ak.a((View) this.c, 8);
        }
    }

    public void t() {
        ak.g(this.d);
        ak.g(this.e);
        ImageView imageView = this.c;
        if (imageView != null && imageView.getVisibility() == 0) {
            ak.a((View) this.c, 8);
        }
    }

    public void e() {
        a(false, this.u);
        v();
    }

    public void u() {
        ak.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            ak.a(view, 8);
            ak.a(view, 0);
        }
    }

    void v() {
        ak.a(this.h, 8);
        ak.a((View) this.i, 8);
        ak.a(this.j, 8);
        ak.a((View) this.k, 8);
        ak.a((View) this.f1322l, 8);
        ak.a((View) this.m, 8);
        ak.a((View) this.n, 8);
    }

    private void f(int i2) {
        ak.a(this.j, i2);
        ak.a(this.J, i2);
    }

    public void d(boolean z2) {
        this.I = z2;
    }

    public void a(l lVar, WeakReference<Context> weakReference, boolean z2) {
        String str;
        l lVar2;
        l lVar3;
        l lVar4;
        if (lVar != null) {
            a(false, this.u);
            a(this.a, p.a());
            View view = this.h;
            if (view != null) {
                ak.a(view, 0);
            }
            ImageView imageView = this.i;
            if (imageView != null) {
                ak.a((View) imageView, 0);
            }
            if (aj.b(this.y)) {
                b(this.a, p.a());
                ak.a(this.j, 8);
                ak.a((View) this.i, 0);
                ak.a(this.J, 0);
                ak.a((View) this.K, 0);
                ak.a((View) this.L, 0);
                if (this.L != null && x.c(p.a()) == 0) {
                    ak.a((View) this.L, 8);
                }
                View view2 = this.h;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() {
                        /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass6 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (h.this.E != null) {
                                ((a) h.this.E).g();
                                if (h.this.H != null) {
                                    h.this.H.onClickRetry();
                                }
                            }
                        }
                    });
                }
                if (!(this.i == null || (lVar4 = this.y) == null || lVar4.R() == null || this.y.R().h() == null)) {
                    com.bytedance.sdk.openadsdk.core.video.e.b.a((long) this.y.R().e(), this.y.R().i(), new b.AbstractC0045b() {
                        /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.h.AnonymousClass7 */

                        @Override // com.bytedance.sdk.openadsdk.core.video.e.b.AbstractC0045b
                        public void a(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.i.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    layoutParams.width = ak.c(p.a());
                                    layoutParams.height = (int) ((float) ((bitmap.getHeight() * ak.c(p.a())) / bitmap.getWidth()));
                                    layoutParams.addRule(13);
                                    h.this.i.setLayoutParams(layoutParams);
                                }
                                h.this.i.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.h.d.a(h.this.z).a(h.this.y.R().h(), h.this.i);
                        }
                    });
                }
            } else {
                ak.a(this.j, 0);
                if (!(this.i == null || (lVar3 = this.y) == null || lVar3.R() == null || this.y.R().h() == null)) {
                    com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.i);
                }
            }
            if (!TextUtils.isEmpty(lVar.S())) {
                str = lVar.S();
            } else if (!TextUtils.isEmpty(lVar.ad())) {
                str = lVar.ad();
            } else {
                str = !TextUtils.isEmpty(lVar.ae()) ? lVar.ae() : "";
            }
            if (this.k != null && (lVar2 = this.y) != null && lVar2.U() != null && this.y.U().a() != null) {
                ak.a((View) this.k, 0);
                ak.a((View) this.f1322l, 4);
                com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.U().a(), this.k);
                if (y()) {
                    this.k.setOnClickListener(this.G);
                    this.k.setOnTouchListener(this.G);
                } else {
                    this.k.setOnClickListener(this.F);
                    this.k.setOnTouchListener(this.F);
                }
            } else if (!TextUtils.isEmpty(str)) {
                ak.a((View) this.k, 4);
                ak.a((View) this.f1322l, 0);
                TextView textView = this.f1322l;
                if (textView != null) {
                    textView.setText(str.substring(0, 1));
                    if (y()) {
                        this.f1322l.setOnClickListener(this.G);
                        this.f1322l.setOnTouchListener(this.G);
                    } else {
                        this.f1322l.setOnClickListener(this.F);
                        this.f1322l.setOnTouchListener(this.F);
                    }
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
            }
            ak.a((View) this.m, 0);
            ak.a((View) this.n, 0);
            String af = lVar.af();
            if (TextUtils.isEmpty(af)) {
                int T = lVar.T();
                if (T == 4) {
                    af = ac.a(this.z, "tt_video_download_apk");
                } else if (T != 5) {
                    af = ac.a(this.z, "tt_video_mobile_go_detail");
                } else {
                    af = ac.a(this.z, "tt_video_dial_phone");
                }
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setText(af);
                this.n.setOnClickListener(this.F);
                this.n.setOnTouchListener(this.F);
            }
            TextView textView3 = this.K;
            if (textView3 != null) {
                textView3.setText(af);
                this.K.setOnClickListener(this.F);
                this.K.setOnTouchListener(this.F);
            }
            if (!this.I) {
                f(4);
            }
        }
    }

    public void w() {
        ak.f(this.d);
        ak.f(this.e);
        ImageView imageView = this.f;
        if (imageView != null) {
            ak.f(imageView);
        }
    }

    public void f() {
        ak.f(this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.v = true;
            if (r()) {
                this.B.a(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.v = false;
            if (r()) {
                this.B.b(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceTexture);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        this.v = false;
        if (!r()) {
            return true;
        }
        this.B.b(this, surfaceTexture);
        return true;
    }

    public void g() {
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setProgress(0);
            this.o.setSecondaryProgress(0);
        }
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        c(8);
        ak.a(this.h, 8);
        ak.a((View) this.i, 8);
        ak.a(this.j, 8);
        ak.a((View) this.k, 8);
        ak.a((View) this.f1322l, 8);
        ak.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        if (hVar != null) {
            hVar.a(true);
        }
    }

    public boolean i() {
        return this.u;
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        int i2 = 0;
        ak.a((View) this.o, 0);
        ImageView imageView = this.c;
        if (!z2 || this.d.getVisibility() == 0) {
            i2 = 8;
        }
        ak.a((View) imageView, i2);
    }

    public void a(boolean z2, boolean z3) {
        ak.a((View) this.o, z2 ? 0 : 8);
        ak.a((View) this.c, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.h.b
    public void j() {
        a(true, false);
    }

    public boolean k() {
        return this.v;
    }

    public void c(int i2) {
        this.w = i2;
        ak.a(this.a, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.g.a
    public boolean m() {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        return hVar != null && hVar.a();
    }

    boolean x() {
        return !this.x.contains(b.a.alwayShowMediaView) || this.u;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.H = drawVideoListener;
        com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
        if (aVar != null) {
            aVar.a(drawVideoListener);
        }
    }
}
