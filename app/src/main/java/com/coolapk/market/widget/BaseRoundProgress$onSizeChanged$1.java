package com.coolapk.market.widget;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseRoundProgress.kt */
final class BaseRoundProgress$onSizeChanged$1 implements Runnable {
    final /* synthetic */ BaseRoundProgress this$0;

    BaseRoundProgress$onSizeChanged$1(BaseRoundProgress baseRoundProgress) {
        this.this$0 = baseRoundProgress;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseRoundProgress.access$drawPrimaryProgress(this.this$0);
        BaseRoundProgress.access$drawSecondaryProgress(this.this$0);
    }
}
