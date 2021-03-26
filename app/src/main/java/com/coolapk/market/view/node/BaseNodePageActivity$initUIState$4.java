package com.coolapk.market.view.node;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$initUIState$4", "Landroid/view/View$OnLayoutChangeListener;", "lastHeight", "", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$initUIState$4 implements View.OnLayoutChangeListener {
    private int lastHeight;
    final /* synthetic */ BaseNodePageActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$initUIState$4(BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = baseNodePageActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.lastHeight == 0) {
            this.lastHeight = i4 - i2;
        }
        int i9 = i4 - i2;
        if (this.lastHeight != i9) {
            DrawSystemBarFrameLayout drawSystemBarFrameLayout = this.this$0.getBinding$presentation_coolapkAppRelease().mainContent;
            Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
            Rect lastInsetsRect = drawSystemBarFrameLayout.getLastInsetsRect();
            this.this$0.getHelper$presentation_coolapkAppRelease().syncUIState(lastInsetsRect.top + UiUtils.getActionBarSize(this.this$0.getActivity()) + ((int) this.this$0.getCornerRadiusHeight$presentation_coolapkAppRelease()), lastInsetsRect.bottom);
            FrameLayout frameLayout = this.this$0.getBinding$presentation_coolapkAppRelease().appBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appBar");
            FrameLayout frameLayout2 = frameLayout;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), lastInsetsRect.top, frameLayout2.getPaddingRight(), frameLayout2.getPaddingBottom());
            this.lastHeight = i9;
        }
    }
}
