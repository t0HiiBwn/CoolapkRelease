package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;

public class FullRewardExpressView extends NativeExpressView implements g {
    g a;
    FullRewardExpressBackupView b;

    public FullRewardExpressView(Context context, l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void a() {
        this.p = true;
        this.n = new FrameLayout(this.g);
        addView(this.n, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
        c();
    }

    private void c() {
        setBackupListener(new c() {
            /* class com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                try {
                    nativeExpressView.l();
                    FullRewardExpressView.this.b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                    FullRewardExpressView.this.b.a(FullRewardExpressView.this.f1315l, nativeExpressView, null);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void b() {
        super.b();
        this.i.a((g) this);
    }

    public void setExpressVideoListenerProxy(g gVar) {
        this.a = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(o oVar) {
        if (oVar != null && oVar.b()) {
            b(oVar);
        }
        super.a(oVar);
    }

    private void b(final o oVar) {
        if (oVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(oVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        FullRewardExpressView.this.c(oVar);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(o oVar) {
        if (oVar != null) {
            double e = oVar.e();
            double f = oVar.f();
            double g = oVar.g();
            double h = oVar.h();
            int a2 = (int) ak.a(this.g, (float) e);
            int a3 = (int) ak.a(this.g, (float) f);
            int a4 = (int) ak.a(this.g, (float) g);
            int a5 = (int) ak.a(this.g, (float) h);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a4, a5);
            }
            layoutParams.width = a4;
            layoutParams.height = a5;
            layoutParams.topMargin = a3;
            layoutParams.leftMargin = a2;
            this.n.setLayoutParams(layoutParams);
            this.n.removeAllViews();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        u.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        g gVar = this.a;
        if (gVar != null) {
            gVar.f(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        u.b("FullRewardExpressView", "onSkipVideo");
        g gVar = this.a;
        if (gVar != null) {
            gVar.Q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i);
        g gVar = this.a;
        if (gVar != null) {
            gVar.d(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        u.b("FullRewardExpressView", "onGetCurrentPlayTime");
        g gVar = this.a;
        if (gVar != null) {
            return gVar.R();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        u.b("FullRewardExpressView", "onGetVideoState");
        g gVar = this.a;
        if (gVar != null) {
            return gVar.S();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
        g gVar = this.a;
        if (gVar != null) {
            gVar.T();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar) {
        if (i == -1 || jVar == null || i != 3) {
            super.a(i, jVar);
        } else {
            T();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar, boolean z) {
        if (!(i == -1 || jVar == null || i != 3)) {
            T();
        }
        super.a(i, jVar, z);
    }

    public FrameLayout getVideoFrameLayout() {
        if (m()) {
            return this.b.getVideoContainer();
        }
        return this.n;
    }
}
