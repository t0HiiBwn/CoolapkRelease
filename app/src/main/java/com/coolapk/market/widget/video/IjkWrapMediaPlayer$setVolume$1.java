package com.coolapk.market.widget.video;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$setVolume$1 implements Runnable {
    final /* synthetic */ float $p0;
    final /* synthetic */ float $p1;
    final /* synthetic */ IjkWrapMediaPlayer this$0;

    IjkWrapMediaPlayer$setVolume$1(IjkWrapMediaPlayer ijkWrapMediaPlayer, float f, float f2) {
        this.this$0 = ijkWrapMediaPlayer;
        this.$p0 = f;
        this.$p1 = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.getIjkPlayer().setVolume(this.$p0, this.$p1);
    }
}
