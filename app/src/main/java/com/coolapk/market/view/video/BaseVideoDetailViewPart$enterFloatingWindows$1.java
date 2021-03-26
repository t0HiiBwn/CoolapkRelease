package com.coolapk.market.view.video;

import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0006\b\u0001\u0010\u0004 \u0000H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "B", "Landroidx/databinding/ViewDataBinding;", "DATA", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseVideoDetailViewPart.kt */
final class BaseVideoDetailViewPart$enterFloatingWindows$1 implements Runnable {
    final /* synthetic */ FloatWindowBridge $floatWindowBridge;

    BaseVideoDetailViewPart$enterFloatingWindows$1(FloatWindowBridge floatWindowBridge) {
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
