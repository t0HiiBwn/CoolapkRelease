package com.coolapk.market.view.node;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
final class BaseNodePageActivity$installFloatingButton$2 implements Runnable {
    final /* synthetic */ BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 $floatingActionButtonListener;
    final /* synthetic */ BaseNodePageActivity this$0;

    BaseNodePageActivity$installFloatingButton$2(BaseNodePageActivity baseNodePageActivity, BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1) {
        this.this$0 = baseNodePageActivity;
        this.$floatingActionButtonListener = baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$floatingActionButtonListener.onFloatingTopChanged(this.this$0.getHelper$presentation_coolapkAppRelease().getCurrentFloatTop());
    }
}
