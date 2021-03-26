package com.coolapk.market.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JP\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/widget/OnVisibleWidthChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "callback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "lastMeasureWidth", "", "getLastMeasureWidth", "()I", "setLastMeasureWidth", "(I)V", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OnVisibleWidthChangeListener.kt */
public final class OnVisibleWidthChangeListener implements View.OnLayoutChangeListener {
    private final Function0<Unit> callback;
    private int lastMeasureWidth;

    public OnVisibleWidthChangeListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.callback = function0;
    }

    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    public final int getLastMeasureWidth() {
        return this.lastMeasureWidth;
    }

    public final void setLastMeasureWidth(int i) {
        this.lastMeasureWidth = i;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, "v");
        int i9 = i3 - i;
        int i10 = this.lastMeasureWidth;
        if (!(i10 == 0 || i9 == i10)) {
            this.callback.invoke();
        }
        this.lastMeasureWidth = i9;
    }
}
