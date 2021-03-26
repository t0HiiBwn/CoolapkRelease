package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/view/live/LiveLineSelectViewPart$startCloseAnimation$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveLineSelectViewPart.kt */
final class LiveLineSelectViewPart$startCloseAnimation$$inlined$apply$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LiveLineSelectViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveLineSelectViewPart$startCloseAnimation$$inlined$apply$lambda$2(LiveLineSelectViewPart liveLineSelectViewPart) {
        super(0);
        this.this$0 = liveLineSelectViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        LiveLineSelectViewPart.access$setAnimating$p(this.this$0, false);
        Function0 access$getCloseListener$p = LiveLineSelectViewPart.access$getCloseListener$p(this.this$0);
        if (access$getCloseListener$p != null) {
            Unit unit = (Unit) access$getCloseListener$p.invoke();
        }
    }
}
