package com.coolapk.market.widget.video;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "mp", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onBufferingUpdateListener$1 implements IMediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onBufferingUpdateListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
        if (i > 95) {
            i = 100;
        }
        this.this$0.submitBufferingUpdate(i, null);
    }
}
