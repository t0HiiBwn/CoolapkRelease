package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.List;
import java.util.Map;

public interface TTNativeAd {

    public interface AdInteractionListener {
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

    public interface ExpressRenderListener {
        void onRenderSuccess(View view, float f, float f2, boolean z);
    }

    void destroy();

    Bitmap getAdLogo();

    View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    String getButtonText();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    DownloadStatusController getDownloadStatusController();

    List<FilterWord> getFilterWords();

    TTImage getIcon();

    List<TTImage> getImageList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    PersonalizationPrompt getPersonalizationPrompt();

    String getSource();

    String getTitle();

    TTImage getVideoCoverImage();

    void registerViewForInteraction(ViewGroup viewGroup, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, AdInteractionListener adInteractionListener);

    void render();

    void setActivityForDownloadApp(Activity activity);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    void showInteractionExpressAd(Activity activity);
}
