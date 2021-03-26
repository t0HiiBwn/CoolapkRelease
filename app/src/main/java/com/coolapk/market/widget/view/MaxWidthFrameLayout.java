package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0014R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/view/MaxWidthFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "maxWidth", "", "getMaxWidth", "()I", "setMaxWidth", "(I)V", "onMeasureWidth", "Lkotlin/Function1;", "", "getOnMeasureWidth", "()Lkotlin/jvm/functions/Function1;", "setOnMeasureWidth", "(Lkotlin/jvm/functions/Function1;)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MaxWidthFrameLayout.kt */
public final class MaxWidthFrameLayout extends FrameLayout {
    private float aspectRatio;
    private int maxWidth;
    private Function1<? super Integer, Unit> onMeasureWidth;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxWidthFrameLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxWidthFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxWidth = Integer.MAX_VALUE;
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> */
    public final Function1<Integer, Unit> getOnMeasureWidth() {
        return this.onMeasureWidth;
    }

    public final void setOnMeasureWidth(Function1<? super Integer, Unit> function1) {
        this.onMeasureWidth = function1;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.maxWidth;
        if (size > i3) {
            size = i3;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.getMode(i));
        Function1<? super Integer, Unit> function1 = this.onMeasureWidth;
        if (function1 != null) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(size));
            }
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824));
        } else if (this.aspectRatio > ((float) 0)) {
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) ((((float) ((size - getPaddingLeft()) - getPaddingRight())) / this.aspectRatio) + ((float) getPaddingTop()) + ((float) getPaddingBottom())), 1073741824));
        } else {
            super.onMeasure(makeMeasureSpec, i2);
        }
    }
}
