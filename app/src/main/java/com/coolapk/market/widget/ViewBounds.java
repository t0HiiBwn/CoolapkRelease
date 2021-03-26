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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010 \u001a\u00020\u0013H\u0002J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006$"}, d2 = {"Lcom/coolapk/market/widget/ViewBounds;", "", "leftMargin", "", "topMargin", "width", "height", "(IIII)V", "getHeight", "()I", "setHeight", "(I)V", "getLeftMargin", "setLeftMargin", "getTopMargin", "setTopMargin", "getWidth", "setWidth", "applyToView", "", "view", "Landroid/view/View;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "loadFromView", "recycle", "toString", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/widget/ViewBounds$Companion;", "", "()V", "BOUNDS_EVALUATOR", "Landroid/animation/TypeEvaluator;", "Lcom/coolapk/market/widget/ViewBounds;", "getBOUNDS_EVALUATOR", "()Landroid/animation/TypeEvaluator;", "VIEW_BOUNDS", "Landroid/util/Property;", "Landroid/view/View;", "getVIEW_BOUNDS", "()Landroid/util/Property;", "linearInterpolator", "Landroid/view/animation/LinearInterpolator;", "viewBoundsPools", "Landroidx/core/util/Pools$SimplePool;", "acquire", "view", "createAnimator", "Landroid/animation/ObjectAnimator;", "startBounds", "endBounds", "release", "", "viewBounds", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    /* access modifiers changed from: private */
    public final void recycle() {
        this.leftMargin = 0;
        this.topMargin = 0;
        this.width = 0;
        this.height = 0;
    }
}
