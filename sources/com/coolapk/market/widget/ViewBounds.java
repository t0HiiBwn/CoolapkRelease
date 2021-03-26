package com.coolapk.market.widget;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Pools;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.LogUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBounds.kt */
public final class ViewBounds {
    private static final TypeEvaluator<ViewBounds> BOUNDS_EVALUATOR = new ViewBounds$Companion$BOUNDS_EVALUATOR$1();
    public static final Companion Companion = new Companion(null);
    private static final Property<View, ViewBounds> VIEW_BOUNDS = new ViewBounds$Companion$VIEW_BOUNDS$1(ViewBounds.class, "view_bounds");
    private static final LinearInterpolator linearInterpolator = new LinearInterpolator();
    private static final Pools.SimplePool<ViewBounds> viewBoundsPools = new Pools.SimplePool<>(3);
    private int height;
    private int leftMargin;
    private int topMargin;
    private int width;

    public ViewBounds() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ViewBounds copy$default(ViewBounds viewBounds, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = viewBounds.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = viewBounds.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = viewBounds.width;
        }
        if ((i5 & 8) != 0) {
            i4 = viewBounds.height;
        }
        return viewBounds.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.leftMargin;
    }

    public final int component2() {
        return this.topMargin;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final ViewBounds copy(int i, int i2, int i3, int i4) {
        return new ViewBounds(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewBounds)) {
            return false;
        }
        ViewBounds viewBounds = (ViewBounds) obj;
        return this.leftMargin == viewBounds.leftMargin && this.topMargin == viewBounds.topMargin && this.width == viewBounds.width && this.height == viewBounds.height;
    }

    public int hashCode() {
        return (((((this.leftMargin * 31) + this.topMargin) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "ViewBounds(leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public ViewBounds(int i, int i2, int i3, int i4) {
        this.leftMargin = i;
        this.topMargin = i2;
        this.width = i3;
        this.height = i4;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final void setLeftMargin(int i) {
        this.leftMargin = i;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    public final void setTopMargin(int i) {
        this.topMargin = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewBounds(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    /* compiled from: ViewBounds.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ViewBounds acquire$default(Companion companion, View view, int i, Object obj) {
            if ((i & 1) != 0) {
                view = null;
            }
            return companion.acquire(view);
        }

        public final ViewBounds acquire(View view) {
            ViewBounds viewBounds = (ViewBounds) ViewBounds.viewBoundsPools.acquire();
            if (viewBounds == null) {
                viewBounds = new ViewBounds(0, 0, 0, 0, 15, null);
            }
            if (view != null) {
                viewBounds.loadFromView(view);
            }
            return viewBounds;
        }

        public final void release(ViewBounds viewBounds) {
            Intrinsics.checkNotNullParameter(viewBounds, "viewBounds");
            ViewBounds.viewBoundsPools.release(viewBounds);
            viewBounds.recycle();
        }

        public final ObjectAnimator createAnimator(View view, ViewBounds viewBounds, ViewBounds viewBounds2) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewBounds, "startBounds");
            Intrinsics.checkNotNullParameter(viewBounds2, "endBounds");
            ObjectAnimator ofObject = ObjectAnimator.ofObject(view, (Property<View, V>) ViewBounds.Companion.getVIEW_BOUNDS(), (TypeEvaluator) ViewBounds.Companion.getBOUNDS_EVALUATOR(), (Object[]) new ViewBounds[]{viewBounds, viewBounds2});
            Intrinsics.checkNotNullExpressionValue(ofObject, "ObjectAnimator.ofObject(…, startBounds, endBounds)");
            ofObject.setInterpolator(ViewBounds.linearInterpolator);
            return ofObject;
        }

        public final Property<View, ViewBounds> getVIEW_BOUNDS() {
            return ViewBounds.VIEW_BOUNDS;
        }

        public final TypeEvaluator<ViewBounds> getBOUNDS_EVALUATOR() {
            return ViewBounds.BOUNDS_EVALUATOR;
        }
    }

    public final void loadFromView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewBounds viewBounds = this;
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
        if (marginParams != null) {
            viewBounds.width = view.getWidth();
            viewBounds.height = view.getHeight();
            viewBounds.topMargin = marginParams.topMargin;
            viewBounds.leftMargin = marginParams.leftMargin;
        }
    }

    public final void applyToView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewBounds viewBounds = this;
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
        if (marginParams != null) {
            marginParams.width = viewBounds.width;
        }
        if (marginParams != null) {
            marginParams.height = viewBounds.height;
        }
        if (marginParams != null) {
            marginParams.topMargin = viewBounds.topMargin;
        }
        if (marginParams != null) {
            marginParams.leftMargin = viewBounds.leftMargin;
        }
        view.requestLayout();
        LogUtils.d("apply to view " + this, new Object[0]);
    }

    public final void recycle() {
        this.leftMargin = 0;
        this.topMargin = 0;
        this.width = 0;
        this.height = 0;
    }
}
