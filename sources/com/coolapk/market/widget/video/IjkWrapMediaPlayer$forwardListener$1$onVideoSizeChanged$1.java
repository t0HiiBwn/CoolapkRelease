package com.coolapk.market.widget.video;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$forwardListener$1$onVideoSizeChanged$1 implements Runnable {
    final /* synthetic */ IMediaPlayer $p0;
    final /* synthetic */ int $p1;
    final /* synthetic */ int $p2;
    final /* synthetic */ int $p3;
    final /* synthetic */ int $p4;
    final /* synthetic */ IjkWrapMediaPlayer$forwardListener$1 this$0;

    IjkWrapMediaPlayer$forwardListener$1$onVideoSizeChanged$1(IjkWrapMediaPlayer$forwardListener$1 ijkWrapMediaPlayer$forwardListener$1, IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        this.this$0 = ijkWrapMediaPlayer$forwardListener$1;
        this.$p0 = iMediaPlayer;
        this.$p1 = i;
        this.$p2 = i2;
        this.$p3 = i3;
        this.$p4 = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.this$0.getOnVideoSizeChangedListener();
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this.$p0, this.$p1, this.$p2, this.$p3, this.$p4);
        }
    }
}
