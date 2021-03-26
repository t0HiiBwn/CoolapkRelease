package com.coolapk.market.widget;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/widget/MainSpareHandler$callback$1", "Lcom/coolapk/market/widget/CheckPauseCallback;", "checkNeedPause", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainSpareHandler.kt */
public final class MainSpareHandler$callback$1 extends CheckPauseCallback {
    final /* synthetic */ MainSpareHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainSpareHandler$callback$1(MainSpareHandler mainSpareHandler, long j) {
        super(j);
        this.this$0 = mainSpareHandler;
    }

    @Override // com.coolapk.market.widget.CheckPauseCallback
    public boolean checkNeedPause() {
        return this.this$0.currentUptimeNano() > getDeadlineNano();
    }
}
