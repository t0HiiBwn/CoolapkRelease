package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.assist.RelationAssist;

/* compiled from: VideoPlayerBridge.kt */
public interface VideoPlayerBridge {
    PlayerArg getPlayerArg();

    void onAction(String str, Object[] objArr);

    void onAttach(RelationAssist relationAssist);

    void onDetach();

    void onEvent(int i, Bundle bundle);

    /* compiled from: VideoPlayerBridge.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onAction$default(VideoPlayerBridge videoPlayerBridge, String str, Object[] objArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    objArr = null;
                }
                videoPlayerBridge.onAction(str, objArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAction");
        }
    }
}
