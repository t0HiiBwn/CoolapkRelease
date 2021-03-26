package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.HashMap;
import java.util.Map;

public interface UIADI extends ApkDownloadComplianceInterface {
    public static final Map<String, String> ext = new HashMap();

    void close();

    void destory();

    String getAdNetWorkName();

    int getAdPatternType();

    int getECPM();

    String getECPMLevel();

    boolean isValid();

    void loadAd();

    void loadFullScreenAD();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setMaxVideoDuration(int i);

    void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    void setMinVideoDuration(int i);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);

    void showFullScreenAD(Activity activity);
}
