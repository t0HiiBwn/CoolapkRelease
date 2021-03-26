package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "mp", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "sarNum", "sarDen", "onVideoSizeChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onVideoSizeChangedListener$1 implements IMediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onVideoSizeChangedListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
        IjkPlayer ijkPlayer = this.this$0;
        Intrinsics.checkNotNullExpressionValue(iMediaPlayer, "mp");
        ijkPlayer.videoWidth = iMediaPlayer.getVideoWidth();
        this.this$0.videoHeight = iMediaPlayer.getVideoHeight();
        Bundle obtain = BundlePool.obtain();
        obtain.putInt("int_arg1", this.this$0.videoWidth);
        obtain.putInt("int_arg2", this.this$0.videoHeight);
        obtain.putInt("int_arg3", i3);
        obtain.putInt("int_arg4", i4);
        this.this$0.submitPlayerEvent(-99017, obtain);
    }
}
