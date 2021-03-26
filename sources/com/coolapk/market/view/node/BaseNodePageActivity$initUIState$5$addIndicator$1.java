package com.coolapk.market.view.node;

import android.view.View;
import com.coolapk.market.widget.ViewVisibilityController;
import com.coolapk.market.widget.view.FloatingState;
import com.coolapk.market.widget.view.ScrollStateHelperCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$initUIState$5$addIndicator$1", "Lcom/coolapk/market/widget/view/ScrollStateHelperCallback;", "controller", "Lcom/coolapk/market/widget/ViewVisibilityController;", "lastState", "Lcom/coolapk/market/widget/view/FloatingState;", "onFloatingStateChanged", "", "state", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$initUIState$5$addIndicator$1 implements ScrollStateHelperCallback {
    final /* synthetic */ View $indicator;
    private final ViewVisibilityController controller;
    private FloatingState lastState;
    final /* synthetic */ BaseNodePageActivity$initUIState$5 this$0;

    BaseNodePageActivity$initUIState$5$addIndicator$1(BaseNodePageActivity$initUIState$5 baseNodePageActivity$initUIState$5, View view) {
        this.this$0 = baseNodePageActivity$initUIState$5;
        this.$indicator = view;
        this.lastState = baseNodePageActivity$initUIState$5.this$0.getHelper$presentation_coolapkAppRelease().getFloatingState();
        this.controller = new ViewVisibilityController(view, null, null, 0, 14, null);
    }

    @Override // com.coolapk.market.widget.view.ScrollStateHelperCallback
    public void onFloatingStateChanged(FloatingState floatingState) {
        Intrinsics.checkNotNullParameter(floatingState, "state");
        if (this.lastState == FloatingState.COLLAPSED && floatingState == FloatingState.APPENDED) {
            this.controller.requestVisible(false);
        } else if (this.lastState == FloatingState.APPENDED && floatingState == FloatingState.COLLAPSED) {
            this.controller.requestVisible(true);
        }
        this.lastState = floatingState;
    }
}
