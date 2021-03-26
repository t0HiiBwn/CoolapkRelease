package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.Map;

public interface TTBannerAd {

    public interface AdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);
    }

    View getBannerView();

    TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setBannerInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setSlideIntervalTime(int i);
}
