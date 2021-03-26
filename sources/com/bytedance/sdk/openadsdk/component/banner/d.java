package com.bytedance.sdk.openadsdk.component.banner;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: BannerView */
class d extends FrameLayout {
    private final Context a;
    private c b;
    private c c;
    private ImageView d;
    private ImageView e;
    private b f;
    private int g;
    private boolean h;
    private boolean i = false;
    private boolean j = false;

    public d(Context context) {
        super(context);
        this.a = context;
        g();
    }

    private void g() {
        c cVar = new c(this.a);
        this.b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.j = false;
    }

    private void h() {
        if (!this.j) {
            this.j = true;
            ImageView imageView = new ImageView(this.a);
            this.d = imageView;
            imageView.setImageResource(ac.d(p.a(), "tt_dislike_icon"));
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.component.banner.d.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.f != null) {
                        d.this.f.showDislikeDialog();
                    }
                }
            });
            int a2 = (int) ak.a(this.a, 15.0f);
            int a3 = (int) ak.a(this.a, 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = a3;
            layoutParams.rightMargin = a3;
            addView(this.d, layoutParams);
            ak.a(this.d, a2, a2, a2, a2);
        }
    }

    private void i() {
        if (!this.i) {
            this.i = true;
            ImageView imageView = new ImageView(this.a);
            this.e = imageView;
            imageView.setImageResource(ac.d(p.a(), "tt_ad_logo_small"));
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
            layoutParams.gravity = 8388693;
            addView(this.e, layoutParams);
        }
    }

    public void a() {
        c cVar = new c(this.a);
        this.c = cVar;
        cVar.setVisibility(8);
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    private void j() {
        ImageView imageView = this.e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        super.addView(view, i2);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        super.addView(view, i2, i3);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        j();
    }

    void a(b bVar) {
        this.f = bVar;
    }

    public c b() {
        return this.b;
    }

    public c c() {
        return this.c;
    }

    public View d() {
        return this.d;
    }

    public void a(int i2) {
        this.g = i2;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, (float) (-getWidth()));
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", (float) getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.bytedance.sdk.openadsdk.component.banner.d.AnonymousClass2 */

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                u.b("TTBannerAd", "SLIDE START");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.h = false;
                d.this.k();
                c cVar = cVar;
                if (cVar != null) {
                    d.this.a(cVar.a());
                }
                u.b("TTBannerAd", "SLIDE END");
            }
        });
        return ofFloat;
    }

    public void e() {
        if (!this.h) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a(this.b)).with(b(this.c));
            animatorSet.setDuration((long) this.g).start();
            this.c.setVisibility(0);
            this.h = true;
        }
    }

    /* access modifiers changed from: private */
    public void a(l lVar) {
        b bVar = this.f;
        if (bVar != null && lVar != null) {
            bVar.a(lVar);
        }
    }

    public boolean f() {
        c cVar = this.c;
        return (cVar == null || cVar.a() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void k() {
        c cVar = this.b;
        this.b = this.c;
        this.c = cVar;
        cVar.b();
    }
}
