package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mp", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "framework_err", "", "impl_err", "onError"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkPlayer.kt */
final class IjkPlayer$onErrorListener$1 implements IMediaPlayer.OnErrorListener {
    final /* synthetic */ IjkPlayer this$0;

    IjkPlayer$onErrorListener$1(IjkPlayer ijkPlayer) {
        this.this$0 = ijkPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        this.this$0.updateStatus(-1);
        this.this$0.targetState = -1;
        Bundle obtain = BundlePool.obtain();
        obtain.putInt("int_arg1", i);
        obtain.putInt("int_arg2", i2);
        this.this$0.submitErrorEvent(-88011, obtain);
        return true;
    }
}
