package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.Map;

public interface TTInteractionAd {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void showInteractionAd(Activity activity);
}
