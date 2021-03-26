package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/view/ADFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "minAspectRatio", "", "getMinAspectRatio", "()F", "setMinAspectRatio", "(F)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ADFrameLayout.kt */
public final class ADFrameLayout extends FrameLayout {
    private float minAspectRatio;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ADFrameLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ADFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final float getMinAspectRatio() {
        return this.minAspectRatio;
    }

    public final void setMinAspectRatio(float f) {
        this.minAspectRatio = f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < 5) {
            int size = View.MeasureSpec.getSize(i);
            if (this.minAspectRatio > ((float) 0)) {
                setMeasuredDimension(getMeasuredWidth(), (int) (((float) size) / this.minAspectRatio));
            }
        }
        LogUtils.d("measuredHeight: " + getMeasuredHeight() + ", measuredWidth: " + getMeasuredWidth(), new Object[0]);
    }
}
