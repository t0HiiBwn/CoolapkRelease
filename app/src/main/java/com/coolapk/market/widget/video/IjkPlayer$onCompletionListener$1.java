package com.coolapk.market.widget.video;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onCompletionListener$1 implements IMediaPlayer.OnCompletionListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onCompletionListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public final void onCompletion(IMediaPlayer iMediaPlayer) {
        this.this$0.updateStatus(6);
        this.this$0.targetState = 6;
        this.this$0.submitPlayerEvent(-99016, null);
    }
}
