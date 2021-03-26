package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J(\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0014J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J \u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0013H\u0016J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u00062"}, d2 = {"Lcom/coolapk/market/widget/PreventAutoScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hadTouchBefore", "", "isPreventAutoScroll", "()Z", "setPreventAutoScroll", "(Z)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "offsetChildrenVertical", "", "dy", "", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onScrollChanged", "l", "t", "oldl", "oldt", "onScrollStateChanged", "requestChildFocus", "child", "Landroid/view/View;", "focused", "requestChildRectangleOnScreen", "rect", "Landroid/graphics/Rect;", "immediate", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "smoothScrollBy", "dx", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "SnapToStartScroller", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PreventAutoScrollRecyclerView.kt */
public final class PreventAutoScrollRecyclerView extends RecyclerView {
    private boolean hadTouchBefore;
    private boolean isPreventAutoScroll;

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(rect, "rect");
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreventAutoScrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean isPreventAutoScroll() {
        return this.isPreventAutoScroll;
    }

    public final void setPreventAutoScroll(boolean z) {
        this.isPreventAutoScroll = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "focused");
        if (!this.isPreventAutoScroll) {
            super.requestChildFocus(view, view2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollTo(int i, int i2) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.scrollTo(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int i, int i2) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.scrollBy(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.scrollToPosition(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putBoolean("TOUCH_BEFORE", this.hadTouchBefore);
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.hadTouchBefore = bundle.getBoolean("TOUCH_BEFORE", true);
            super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.smoothScrollBy(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.smoothScrollBy(i, i2, interpolator);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void offsetChildrenVertical(int i) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            super.offsetChildrenVertical(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (!this.hadTouchBefore) {
            this.hadTouchBefore = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        if (!this.isPreventAutoScroll || this.hadTouchBefore) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SnapToStartScroller snapToStartScroller = new SnapToStartScroller(context);
            snapToStartScroller.setTargetPosition(i);
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(snapToStartScroller);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/PreventAutoScrollRecyclerView$SnapToStartScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getVerticalSnapPreference", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PreventAutoScrollRecyclerView.kt */
    private static final class SnapToStartScroller extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SnapToStartScroller(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }
}
