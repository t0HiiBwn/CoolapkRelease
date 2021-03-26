package com.coolapk.market.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/ViewTouchAnimatorKt$SCALE_TOUCH_ANIMATOR$1", "Lcom/coolapk/market/widget/ViewTouchAnimator;", "onPressDown", "", "v", "Landroid/view/View;", "onRaiseUp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewTouchAnimator.kt */
public final class ViewTouchAnimatorKt$SCALE_TOUCH_ANIMATOR$1 extends ViewTouchAnimator {
    ViewTouchAnimatorKt$SCALE_TOUCH_ANIMATOR$1() {
    }

    @Override // com.coolapk.market.widget.ViewTouchAnimator
    public void onRaiseUp(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        view.animate().scaleX(1.0f).setDuration(100).scaleY(1.0f).start();
    }

    @Override // com.coolapk.market.widget.ViewTouchAnimator
    public void onPressDown(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        view.animate().scaleX(1.2f).setDuration(100).scaleY(1.2f).start();
    }
}
