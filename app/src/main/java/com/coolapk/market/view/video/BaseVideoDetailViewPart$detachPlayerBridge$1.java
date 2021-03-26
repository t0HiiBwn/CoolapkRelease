package com.coolapk.market.view.video;

import com.coolapk.market.widget.video.VideoPlayerBridge;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0006\b\u0001\u0010\u0004 \u0000H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "B", "Landroidx/databinding/ViewDataBinding;", "DATA", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseVideoDetailViewPart.kt */
final class BaseVideoDetailViewPart$detachPlayerBridge$1 implements Runnable {
    final /* synthetic */ VideoPlayerBridge $sourceBridge;
    final /* synthetic */ BaseVideoDetailViewPart this$0;

    BaseVideoDetailViewPart$detachPlayerBridge$1(BaseVideoDetailViewPart baseVideoDetailViewPart, VideoPlayerBridge videoPlayerBridge) {
        this.this$0 = baseVideoDetailViewPart;
        this.$sourceBridge = videoPlayerBridge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseVideoDetailViewPart.access$getPlayer$p(this.this$0).attachPlayerBridge(this.$sourceBridge);
    }
}
