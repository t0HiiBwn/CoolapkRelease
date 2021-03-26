package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coolapk.market.extend.NumberExtendsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/widget/view/TimeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recentWidths", "", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TimeTextView.kt */
public final class TimeTextView extends AppCompatTextView {
    private final List<Integer> recentWidths = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setGravity(17);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) this.recentWidths);
        if (num == null) {
            this.recentWidths.add(Integer.valueOf(measuredWidth));
        } else if (num.intValue() < measuredWidth) {
            this.recentWidths.add(Integer.valueOf(measuredWidth));
        } else if (num.intValue() - getMaxWidth() < NumberExtendsKt.getDp((Number) 4)) {
            setMeasuredDimension(num.intValue(), getMeasuredHeight());
        } else {
            this.recentWidths.clear();
        }
    }
}
