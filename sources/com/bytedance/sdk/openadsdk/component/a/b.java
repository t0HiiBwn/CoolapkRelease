package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.x;

/* compiled from: TTDrawFeedAdImpl */
public class b extends c implements TTDrawFeedAd {
    private boolean n;
    private Bitmap o;
    private int p;
    private TTDrawFeedAd.DrawVideoListener q;

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public /* bridge */ /* synthetic */ void a(int i, int i2) {
        super.a(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j, long j2) {
        super.a(j, j2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d_() {
        super.d_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.multipro.b.a.AbstractC0059a
    public /* bridge */ /* synthetic */ a e() {
        return super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e_() {
        super.e_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.multipro.b.a.AbstractC0059a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewHeight() {
        return super.getAdViewHeight();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewWidth() {
        return super.getAdViewWidth();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ TTFeedAd.CustomizeVideo getCustomVideo() {
        return super.getCustomVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    public b(Context context, l lVar, int i, AdSlot adSlot) {
        super(context, lVar, i, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        if (!(this.h == null || this.i == null)) {
            if (h()) {
                try {
                    nativeDrawVideoTsView = new NativeDrawVideoTsView(this.i, this.h);
                    nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() {
                        /* class com.bytedance.sdk.openadsdk.component.a.b.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            b.this.a.a = z;
                            b.this.a.e = j;
                            b.this.a.f = j2;
                            b.this.a.g = j3;
                            b.this.a.d = z2;
                        }
                    });
                    nativeDrawVideoTsView.setVideoAdLoadListener(this);
                    nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                    int d = aj.d(this.h.aj());
                    nativeDrawVideoTsView.setIsAutoPlay(a(d));
                    nativeDrawVideoTsView.setIsQuiet(p.h().a(d));
                    nativeDrawVideoTsView.setCanInterruptVideoPlay(this.n);
                    Bitmap bitmap = this.o;
                    if (bitmap != null) {
                        nativeDrawVideoTsView.a(bitmap, this.p);
                    }
                    nativeDrawVideoTsView.setDrawVideoListener(this.q);
                } catch (Exception unused) {
                }
                if (!h() && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0, true, false)) {
                    return nativeDrawVideoTsView;
                }
            }
            nativeDrawVideoTsView = null;
            if (!h()) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i) {
        this.o = bitmap;
        this.p = i;
        i();
    }

    private boolean a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            return false;
        }
        if (1 != c || !x.d(this.i)) {
            if (2 != c) {
                return false;
            }
            if (!x.e(this.i) && !x.d(this.i)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.q = drawVideoListener;
    }

    private void i() {
        int i = this.p;
        if (i >= 200) {
            this.p = 200;
        } else if (i <= 20) {
            this.p = 20;
        }
    }
}
