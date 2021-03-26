package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TTAdNativeImpl */
public class w implements TTAdNative {
    private final q a = p.f();
    private final Context b;

    public w(Context context) {
        this.b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        if (!a(feedAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, feedAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        if (!a(feedAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, feedAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        if (!a(drawFeedAdListener)) {
            a(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, drawFeedAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(final AdSlot adSlot, final TTAdNative.NativeAdListener nativeAdListener) {
        if (!a(nativeAdListener)) {
            b(adSlot);
            this.a.a(adSlot, null, adSlot.getNativeAdType(), new q.b() {
                /* class com.bytedance.sdk.openadsdk.core.w.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(a aVar) {
                    if (aVar.c() == null || aVar.c().isEmpty()) {
                        nativeAdListener.onError(-3, h.a(-3));
                        return;
                    }
                    List<l> c2 = aVar.c();
                    ArrayList arrayList = new ArrayList(c2.size());
                    for (l lVar : c2) {
                        if (lVar.aB()) {
                            arrayList.add(new com.bytedance.sdk.openadsdk.core.e.a(w.this.b, lVar, adSlot.getNativeAdType(), adSlot) {
                                /* class com.bytedance.sdk.openadsdk.core.w.AnonymousClass1.AnonymousClass1 */
                            });
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    } else {
                        nativeAdListener.onError(-4, h.a(-4));
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(AdSlot adSlot, TTAdNative.BannerAdListener bannerAdListener) {
        if (!a(bannerAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, bannerAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
        if (!a(interactionAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, interactionAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i) {
        if (!a(splashAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, splashAdListener, Integer.valueOf(i));
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
        if (!a(splashAdListener)) {
            c(adSlot);
            if (!a(adSlot, true)) {
                splashAdListener.onError(110, h.a(110));
            } else {
                loadSplashAd(adSlot, splashAdListener, -1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (!a(rewardVideoAdListener)) {
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, rewardVideoAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (!a(fullScreenVideoAdListener)) {
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, fullScreenVideoAdListener);
                }
            } catch (Throwable th) {
                u.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
            } else {
                b.a(this.b).a(adSlot, 5, nativeExpressAdListener, 5000);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
            } else {
                b.a(this.b).a(adSlot, 9, nativeExpressAdListener, 5000);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
                return;
            }
            adSlot.setNativeAdType(1);
            b.a(this.b).a(adSlot, 1, nativeExpressAdListener, 5000);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
                return;
            }
            adSlot.setNativeAdType(2);
            b.a(this.b).a(adSlot, 2, nativeExpressAdListener, 5000);
        }
    }

    private void a(AdSlot adSlot) {
        boolean z = true;
        z.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
        if (adSlot.getImgAcceptedHeight() <= 0) {
            z = false;
        }
        z.a(z, "必须设置图片素材尺寸");
    }

    private void b(AdSlot adSlot) {
        a(adSlot);
        z.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型， ");
    }

    private void c(AdSlot adSlot) {
        a(adSlot);
        z.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }

    private boolean a(com.bytedance.sdk.openadsdk.a.b bVar) {
        if (g.a()) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
        return true;
    }

    private boolean a(AdSlot adSlot, boolean z) {
        if (adSlot == null) {
            return false;
        }
        if ((!z || p.h().i(adSlot.getCodeId())) && adSlot.getExpressViewAcceptedWidth() <= 0.0f) {
            return false;
        }
        return true;
    }
}
