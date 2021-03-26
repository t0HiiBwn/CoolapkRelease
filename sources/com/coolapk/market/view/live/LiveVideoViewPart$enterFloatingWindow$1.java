package com.coolapk.market.view.live;

import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$enterFloatingWindow$1 implements Runnable {
    final /* synthetic */ FloatWindowBridge $floatWindowBridge;

    LiveVideoViewPart$enterFloatingWindow$1(FloatWindowBridge floatWindowBridge) {
        this.$floatWindowBridge = floatWindowBridge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
        if ((optSharePlayer != null ? optSharePlayer.getPlayerBridge() : null) == null) {
            VideoManager.INSTANCE.getSharedPlayer().attachPlayerBridge(this.$floatWindowBridge);
        }
    }
}
