package com.coolapk.market.widget.video;

import android.view.Surface;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IjkWrapMediaPlayer.kt */
final class IjkWrapMediaPlayer$setSurface$1 implements Runnable {
    final /* synthetic */ Surface $p0;
    final /* synthetic */ IjkWrapMediaPlayer this$0;

    IjkWrapMediaPlayer$setSurface$1(IjkWrapMediaPlayer ijkWrapMediaPlayer, Surface surface) {
        this.this$0 = ijkWrapMediaPlayer;
        this.$p0 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.getIjkPlayer().setSurface(this.$p0);
    }
}
