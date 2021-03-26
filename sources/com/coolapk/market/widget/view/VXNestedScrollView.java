package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ReflectUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u001aJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0011J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\bJ(\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0014J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/coolapk/market/widget/view/VXNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "disableScroll", "getDisableScroll", "()Z", "setDisableScroll", "(Z)V", "isBeingTouched", "onScrollListeners", "", "Lcom/coolapk/market/widget/view/VXNestedScrollView$OnScrollYChangedListener;", "totalScrollRange", "", "getTotalScrollRange", "()I", "abortScrolling", "", "addOnScrollYChangedListener", "func", "Lkotlin/Function1;", "l", "dispatchScrollYChanged", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isBeingTouchOrDisabledScrolled", "onScrollChanged", "t", "oldl", "oldt", "removeOnScrollYChangedListener", "scrollByDy", "dy", "OnScrollYChangedListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXNestedScrollView.kt */
public final class VXNestedScrollView extends NestedScrollView {
    private boolean disableScroll;
    private boolean isBeingTouched;
    private final Set<OnScrollYChangedListener> onScrollListeners = new LinkedHashSet();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/view/VXNestedScrollView$OnScrollYChangedListener;", "", "onScrollYChanged", "", "view", "Lcom/coolapk/market/widget/view/VXNestedScrollView;", "scrollY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VXNestedScrollView.kt */
    public interface OnScrollYChangedListener {
        void onScrollYChanged(VXNestedScrollView vXNestedScrollView, int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VXNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public final boolean getDisableScroll() {
        return this.disableScroll;
    }

    public final void setDisableScroll(boolean z) {
        this.disableScroll = z;
        if (z) {
            abortScrolling();
        }
    }

    public final int getTotalScrollRange() {
        if (getChildCount() == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        int height = childAt.getHeight();
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(childAt);
        Intrinsics.checkNotNull(marginParams);
        return KotlinExtendKt.constrain$default(((height + (marginParams.topMargin + marginParams.bottomMargin)) - getHeight()) + getPaddingTop() + getPaddingBottom(), 0, 0, 1, (Object) null);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        dispatchScrollYChanged();
    }

    private final void dispatchScrollYChanged() {
        for (OnScrollYChangedListener onScrollYChangedListener : CollectionsKt.toList(this.onScrollListeners)) {
            onScrollYChangedListener.onScrollYChanged(this, getScrollY());
        }
    }

    public final void addOnScrollYChangedListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.onScrollListeners.add(new VXNestedScrollView$addOnScrollYChangedListener$1(function1));
    }

    public final void addOnScrollYChangedListener(OnScrollYChangedListener onScrollYChangedListener) {
        Intrinsics.checkNotNullParameter(onScrollYChangedListener, "l");
        this.onScrollListeners.add(onScrollYChangedListener);
    }

    public final void removeOnScrollYChangedListener(OnScrollYChangedListener onScrollYChangedListener) {
        Intrinsics.checkNotNullParameter(onScrollYChangedListener, "l");
        this.onScrollListeners.remove(onScrollYChangedListener);
    }

    public final int scrollByDy(int i) {
        if (i > 0) {
            if (getScrollY() + i >= getTotalScrollRange()) {
                i = getTotalScrollRange() - getScrollY();
            }
            scrollBy(0, i);
            return i;
        }
        if (getScrollY() <= Math.abs(i)) {
            i = -getScrollY();
        }
        scrollBy(0, i);
        return i;
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.isBeingTouched = true;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.isBeingTouched = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean isBeingTouchOrDisabledScrolled() {
        return this.isBeingTouched || this.disableScroll;
    }

    private final void abortScrolling() {
        try {
            ((OverScroller) ReflectUtils.wrap(this).getChildField("mScroller").get()).abortAnimation();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
