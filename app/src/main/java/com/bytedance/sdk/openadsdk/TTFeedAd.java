package com.bytedance.sdk.openadsdk;

public interface TTFeedAd extends TTNativeAd {

    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i, int i2);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);
}
