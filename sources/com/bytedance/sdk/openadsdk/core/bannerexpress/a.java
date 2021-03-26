package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: BannerExpressView */
class a extends FrameLayout {
    protected final Context a;
    protected NativeExpressView b;
    protected NativeExpressView c;
    protected l d;
    protected AdSlot e;
    protected TTNativeExpressAd.ExpressAdInteractionListener f;
    protected TTNativeExpressAd.ExpressVideoAdListener g;
    protected int h;
    protected boolean i;
    protected String j = "banner_ad";

    public a(Context context, l lVar, AdSlot adSlot) {
        super(context);
        this.a = context;
        this.d = lVar;
        this.e = adSlot;
        a();
    }

    protected void a() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, this.d, this.e, this.j);
        this.b = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(l lVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, lVar, adSlot, this.j);
        this.c = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
            /* class com.bytedance.sdk.openadsdk.core.bannerexpress.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f != null) {
                    a.this.f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                a.this.a(f, f2);
                a.this.f();
            }
        });
        ak.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.g = expressVideoAdListener;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f = expressAdInteractionListener;
        this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
            /* class com.bytedance.sdk.openadsdk.core.bannerexpress.a.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f != null) {
                    a.this.f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (a.this.f != null) {
                    a.this.f.onRenderFail(a.this, str, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f, f2);
                }
                if (a.this.f != null) {
                    a.this.f.onRenderSuccess(a.this, f, f2);
                }
            }
        });
    }

    protected void a(float f2, float f3) {
        int a2 = (int) ak.a(this.a, f2);
        int a3 = (int) ak.a(this.a, f3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        setLayoutParams(layoutParams);
    }

    public void e() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void d() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.b.k();
            this.b = null;
        }
        NativeExpressView nativeExpressView2 = this.c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.c.k();
            this.c = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.b;
    }

    public NativeExpressView getNextView() {
        return this.c;
    }

    public void setDuration(int i2) {
        this.h = i2;
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, (float) (-getWidth()));
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", (float) getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.bytedance.sdk.openadsdk.core.bannerexpress.a.AnonymousClass3 */

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.i = false;
                a.this.g();
            }
        });
        return ofFloat;
    }

    public void c() {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    protected void f() {
        try {
            if (!this.i && this.c != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(a(this.b)).with(b(this.c));
                animatorSet.setDuration((long) this.h).start();
                ak.a((View) this.c, 0);
                this.i = true;
            }
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        return this.c != null;
    }

    /* access modifiers changed from: private */
    public void g() {
        NativeExpressView nativeExpressView = this.b;
        this.b = this.c;
        this.c = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.c.k();
            this.c = null;
        }
    }
}
