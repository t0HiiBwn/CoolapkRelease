package com.coolapk.market.widget.video.cover;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: GestureCover.kt */
final class GestureCover$seekEventRunnable$1 implements Runnable {
    final /* synthetic */ GestureCover this$0;

    GestureCover$seekEventRunnable$1(GestureCover gestureCover) {
        this.this$0 = gestureCover;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (GestureCover.access$getSeekProgress$p(this.this$0) >= 0) {
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", GestureCover.access$getSeekProgress$p(this.this$0));
            this.this$0.requestSeek(obtain);
        }
    }
}
