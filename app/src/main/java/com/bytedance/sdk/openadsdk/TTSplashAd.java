package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.Map;

public interface TTSplashAd {

    public interface AdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);

        void onAdSkip();

        void onAdTimeOver();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    View getSplashView();

    void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setNotAllowSdkCountdown();

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);
}
