package com.coolapk.market.widget.video;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$forwardListener$1$onPrepared$1 implements Runnable {
    final /* synthetic */ IMediaPlayer $p0;
    final /* synthetic */ IjkWrapMediaPlayer$forwardListener$1 this$0;

    IjkWrapMediaPlayer$forwardListener$1$onPrepared$1(IjkWrapMediaPlayer$forwardListener$1 ijkWrapMediaPlayer$forwardListener$1, IMediaPlayer iMediaPlayer) {
        this.this$0 = ijkWrapMediaPlayer$forwardListener$1;
        this.$p0 = iMediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IMediaPlayer.OnPreparedListener onPreparedListener = this.this$0.getOnPreparedListener();
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.$p0);
        }
    }
}
