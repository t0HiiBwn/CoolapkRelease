package it.sephiroth.android.library.xtooltip;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: Tooltip.kt */
final class Tooltip$activateRunnable$1 implements Runnable {
    final /* synthetic */ Tooltip this$0;

    Tooltip$activateRunnable$1(Tooltip tooltip) {
        this.this$0 = tooltip;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.mActivated = true;
    }
}
