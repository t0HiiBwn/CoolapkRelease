package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.e.a;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TTFeedAdImpl */
class c extends a implements TTFeedAd, c.b, c.AbstractC0046c, a.AbstractC0059a {
    com.bytedance.sdk.openadsdk.multipro.b.a a;
    boolean b = false;
    boolean c = true;
    int d;
    AdSlot e;
    int f;
    private int[] n = null;
    private TTFeedAd.VideoAdListener o;
    private TTFeedAd.CustomizeVideo p;
    private boolean q = false;

    c(Context context, l lVar, int i, AdSlot adSlot) {
        super(context, lVar, i, adSlot);
        this.f = i;
        this.e = adSlot;
        this.a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = aj.d(this.h.aj());
        this.d = d2;
        a(d2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.b.a.AbstractC0059a
    public boolean g() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.h == null || this.i == null)) {
            if (h()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.i, this.h, false, false, aj.b(this.f), false, false);
                    if (i()) {
                        nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b() {
                            /* class com.bytedance.sdk.openadsdk.component.a.c.AnonymousClass1 */

                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                            public void a(View view, int i) {
                                if (c.this.g != null) {
                                    c.this.g.a(view, i);
                                }
                            }
                        });
                    }
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() {
                        /* class com.bytedance.sdk.openadsdk.component.a.c.AnonymousClass2 */

                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            c.this.a.a = z;
                            c.this.a.e = j;
                            c.this.a.f = j2;
                            c.this.a.g = j3;
                            c.this.a.d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.f) {
                        nativeVideoTsView.setIsAutoPlay(this.b ? this.e.isAutoPlay() : this.c);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.c);
                    }
                    nativeVideoTsView.setIsQuiet(p.h().a(this.d));
                } catch (Exception unused) {
                }
                if (!h() && nativeVideoTsView != null && nativeVideoTsView.a(0, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!h()) {
            }
        }
        return null;
    }

    private boolean i() {
        if (this.h == null || this.h.M() != null || this.h.k() != 1 || !l.c(this.h)) {
            return false;
        }
        return true;
    }

    boolean h() {
        return l.c(this.h);
    }

    private void a(int i) {
        int c2 = p.h().c(i);
        if (3 == c2) {
            this.b = false;
            this.c = false;
        } else if (1 == c2 && x.d(this.i)) {
            this.b = false;
            this.c = true;
        } else if (2 == c2) {
            if (x.e(this.i) || x.d(this.i)) {
                this.b = false;
                this.c = true;
            }
        } else if (4 == c2) {
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.o = videoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        if (this.h == null || this.h.R() == null) {
            return 0.0d;
        }
        return this.h.R().e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        try {
            if (this.n == null) {
                this.n = t.a(this.h);
            }
            int[] iArr = this.n;
            if (iArr == null) {
                return 1280;
            }
            if (iArr.length < 2) {
                return 1280;
            }
            return iArr[0];
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        try {
            if (this.n == null) {
                this.n = t.a(this.h);
            }
            int[] iArr = this.n;
            if (iArr == null) {
                return 720;
            }
            if (iArr.length < 2) {
                return 720;
            }
            return iArr[1];
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        if (!l.a(this.h)) {
            return null;
        }
        if (this.p == null) {
            this.p = new TTFeedAd.CustomizeVideo() {
                /* class com.bytedance.sdk.openadsdk.component.a.c.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public String getVideoUrl() {
                    if (c.this.h == null || c.this.h.a() != 1 || c.this.h.R() == null) {
                        return null;
                    }
                    if (!c.this.q) {
                        c.this.q = true;
                    }
                    return c.this.h.R().i();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoStart() {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_play", 0, 0, (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoPause(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_pause", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoContinue(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_continue", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoFinish() {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_over", ((long) c.this.getVideoDuration()) * 1000, 100, (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoBreak(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_break", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoAutoStart() {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_auto_play", 0, 0, (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoStartError(int i, int i2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("creative_id", c.this.h.ag());
                    hashMap.put("error_code", Integer.valueOf(i));
                    hashMap.put("extra_error_code", Integer.valueOf(i2));
                    t R = c.this.h.R();
                    if (R != null) {
                        hashMap.put("video_size", Long.valueOf(R.d()));
                        hashMap.put("video_resolution", R.f());
                    }
                    d.d(c.this.i, c.this.h, aj.a(c.this.h), "play_start_error", hashMap);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoError(long j, int i, int i2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("creative_id", c.this.h.ag());
                    hashMap.put("error_code", Integer.valueOf(i));
                    hashMap.put("extra_error_code", Integer.valueOf(i2));
                    t R = c.this.h.R();
                    if (R != null) {
                        hashMap.put("video_size", Long.valueOf(R.d()));
                        hashMap.put("video_resolution", R.f());
                    }
                    hashMap.put("duration", Long.valueOf(j));
                    hashMap.put("percent", Integer.valueOf(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000)));
                    d.d(c.this.i, c.this.h, aj.a(c.this.h), "play_error", hashMap);
                }
            };
        }
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public void f() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public void a(int i, int i2) {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdContinuePlay(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.b.a.AbstractC0059a
    public com.bytedance.sdk.openadsdk.multipro.b.a e() {
        return this.a;
    }
}
