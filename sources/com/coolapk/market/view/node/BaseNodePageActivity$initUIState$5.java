package com.coolapk.market.view.node;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0002\u001a\u00020\u0003JR\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/node/BaseNodePageActivity$initUIState$5", "Landroid/view/View$OnLayoutChangeListener;", "addIndicator", "", "onLayoutChange", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public final class BaseNodePageActivity$initUIState$5 implements View.OnLayoutChangeListener {
    final /* synthetic */ BaseNodePageActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseNodePageActivity$initUIState$5(BaseNodePageActivity baseNodePageActivity) {
        this.this$0 = baseNodePageActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        float maxFloatingTop = ((float) this.this$0.getHelper$presentation_coolapkAppRelease().getMaxFloatingTop()) + this.this$0.getCornerRadiusHeight$presentation_coolapkAppRelease();
        int i9 = i4 - i2;
        if (i9 > 0 && ((float) i9) > maxFloatingTop) {
            this.this$0.getBinding$presentation_coolapkAppRelease().backgroundView.post(new BaseNodePageActivity$sam$java_lang_Runnable$0(new BaseNodePageActivity$initUIState$5$onLayoutChange$1(this)));
            this.this$0.getBinding$presentation_coolapkAppRelease().backgroundView.removeOnLayoutChangeListener(this);
        }
    }

    public final void addIndicator() {
        View view = new View(this.this$0.getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 32), NumberExtendsKt.getDp((Number) 4));
        layoutParams.gravity = 1;
        layoutParams.topMargin = NumberExtendsKt.getDp(Double.valueOf(4.5d));
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        view.setBackground(new ColorDrawable(ResourceUtils.resolveData(this.this$0.getActivity(), 2130969227)));
        ViewExtendsKt.clipView$default(view, 0, (float) NumberExtendsKt.getDp((Number) 2), 1, null);
        this.this$0.getHelper$presentation_coolapkAppRelease().addFloatingStateCallback(new BaseNodePageActivity$initUIState$5$addIndicator$1(this, view));
        this.this$0.getBinding$presentation_coolapkAppRelease().tabSuperContainer.addView(view);
    }
}
