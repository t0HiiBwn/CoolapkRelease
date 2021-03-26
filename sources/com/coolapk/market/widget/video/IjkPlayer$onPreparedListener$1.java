package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "mp", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onPreparedListener$1 implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onPreparedListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public final void onPrepared(IMediaPlayer iMediaPlayer) {
        this.this$0.updateStatus(2);
        IjkPlayer ijkPlayer = this.this$0;
        Intrinsics.checkNotNullExpressionValue(iMediaPlayer, "mp");
        ijkPlayer.videoWidth = iMediaPlayer.getVideoWidth();
        this.this$0.videoHeight = iMediaPlayer.getVideoHeight();
        Bundle obtain = BundlePool.obtain();
        obtain.putInt("int_arg1", this.this$0.videoWidth);
        obtain.putInt("int_arg2", this.this$0.videoHeight);
        this.this$0.submitPlayerEvent(-99018, obtain);
        int i = this.this$0.startSeekPos;
        if (i != 0) {
            this.this$0.mediaPlayer.seekTo((long) i);
            this.this$0.startSeekPos = 0;
        }
        if (this.this$0.targetState == 3) {
            this.this$0.start();
        } else if (this.this$0.targetState == 4) {
            this.this$0.pause();
        } else if (this.this$0.targetState == 5 || this.this$0.targetState == 0) {
            this.this$0.reset();
        }
    }
}
