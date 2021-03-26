package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/view/IndicatorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "selectedDrawable", "Landroid/graphics/drawable/ColorDrawable;", "selectedIndex", "", "totalCount", "unselectedDrawable", "checkIndicatorCount", "", "createIndicatorView", "Landroid/widget/ImageView;", "ensureIndicatorCount", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "selectIndicator", "setSelectedDrawableColor", "color", "setSelectedIndex", "index", "setTotalIndicatorCount", "count", "setUnSelectedDrawableColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IndicatorView.kt */
public final class IndicatorView extends LinearLayout {
    private ColorDrawable selectedDrawable = new ColorDrawable(ResourceUtils.getColorInt(getContext(), 2131099896));
    private int selectedIndex = -1;
    private int totalCount = -1;
    private ColorDrawable unselectedDrawable = new ColorDrawable(ResourceUtils.getColorInt(getContext(), 2131099898));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setTotalIndicatorCount(int i) {
        if (this.totalCount != i) {
            this.totalCount = i;
            requestLayout();
        }
    }

    public final void setSelectedIndex(int i) {
        if (this.selectedIndex != i) {
            this.selectedIndex = i;
            requestLayout();
        }
    }

    public final void setSelectedDrawableColor(int i) {
        this.selectedDrawable = new ColorDrawable(i);
    }

    public final void setUnSelectedDrawableColor(int i) {
        this.unselectedDrawable = new ColorDrawable(i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        checkIndicatorCount();
        super.onMeasure(i, i2);
    }

    private final void checkIndicatorCount() {
        if (this.totalCount > 0 && this.selectedIndex >= 0) {
            ensureIndicatorCount();
            selectIndicator();
        } else if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    private final void ensureIndicatorCount() {
        IndicatorView indicatorView = this;
        int childCount = indicatorView.getChildCount();
        int i = this.totalCount;
        if (i < childCount) {
            int i2 = childCount - i;
            for (int i3 = 0; i3 < i2; i3++) {
                indicatorView.removeViewAt(0);
            }
        } else if (i > childCount) {
            int i4 = i - childCount;
            for (int i5 = 0; i5 < i4; i5++) {
                addView(createIndicatorView());
            }
        }
    }

    private final ImageView createIndicatorView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 5), NumberExtendsKt.getDp((Number) 5));
        layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.topMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 4);
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        ViewExtendsKt.clipView$default(imageView, 1, 0.0f, 2, null);
        return imageView;
    }

    private final void selectIndicator() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            if (i == this.selectedIndex) {
                imageView.setImageDrawable(this.selectedDrawable);
            } else {
                imageView.setImageDrawable(this.unselectedDrawable);
            }
        }
    }
}
