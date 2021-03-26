package com.bytedance.sdk.openadsdk;

public interface TTAdDislike {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onRefuse();

        void onSelected(int i, String str);
    }

    void sendDislikeSource(String str);

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setIsInteractionAd();

    void showDislikeDialog();

    void showDislikeDialog(int i);
}
