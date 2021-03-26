package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.a.b;
import java.util.List;

public interface TTAdNative {

    public interface BannerAdListener extends b {
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);
    }

    public interface DrawFeedAdListener extends b {
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);
    }

    public interface FeedAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onFeedAdLoad(List<TTFeedAd> list);
    }

    public interface FullScreenVideoAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        void onFullScreenVideoCached();
    }

    public interface InteractionAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    public interface NativeAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    public interface NativeExpressAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    public interface RewardVideoAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        void onRewardVideoCached();
    }

    public interface SplashAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        void onError(int i, String str);

        void onSplashAdLoad(TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerAd(AdSlot adSlot, BannerAdListener bannerAdListener);

    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    void loadInteractionAd(AdSlot adSlot, InteractionAdListener interactionAdListener);

    void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener);

    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener, int i);

    void loadStream(AdSlot adSlot, FeedAdListener feedAdListener);
}
