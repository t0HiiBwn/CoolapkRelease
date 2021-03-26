package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NativeUnifiedADData extends ApkDownloadComplianceInterface {
    public static final int AD_CLICKED = 2;
    public static final int AD_ERROR = 3;
    public static final int AD_EXPOSED = 1;
    public static final int AD_STATUS_CHANGED = 4;
    public static final int MEDIA_CLICKED = 15;
    public static final int MEDIA_COMPLETED = 12;
    public static final int MEDIA_ERROR = 13;
    public static final int MEDIA_INIT = 5;
    public static final int MEDIA_LOADED = 8;
    public static final int MEDIA_LOADING = 6;
    public static final int MEDIA_PAUSE = 10;
    public static final int MEDIA_READY = 7;
    public static final int MEDIA_RESUME = 11;
    public static final int MEDIA_START = 9;
    public static final int MEDIA_STOP = 14;
    public static final Map<String, String> ext = new HashMap();

    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list);

    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2);

    void bindCTAViews(List<View> list);

    void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener);

    void destroy();

    boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData);

    int getAdPatternType();

    double getAppPrice();

    int getAppScore();

    int getAppStatus();

    String getCTAText();

    String getDesc();

    long getDownloadCount();

    int getECPM();

    String getECPMLevel();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    String getTitle();

    @Deprecated
    String getVastContent();

    @Deprecated
    String getVastTag();

    int getVideoCurrentPosition();

    int getVideoDuration();

    boolean isAppAd();

    @Deprecated
    boolean isSkippable();

    void negativeFeedback();

    @Deprecated
    void onVideoADExposured(View view);

    void pauseAppDownload();

    void pauseVideo();

    void preloadVideo(VideoPreloadListener videoPreloadListener);

    @Deprecated
    void reportVastEvent(ADEvent aDEvent);

    void resume();

    void resumeAppDownload();

    void resumeVideo();

    void setNativeAdEventListener(NativeADEventListener nativeADEventListener);

    void setVideoMute(boolean z);

    void startVideo();

    void stopVideo();
}
