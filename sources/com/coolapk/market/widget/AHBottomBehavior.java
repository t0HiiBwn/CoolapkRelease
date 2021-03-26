package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J8\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coolapk/market/widget/AHBottomBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigation;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Lrx/functions/Action1;", "", "getCallback", "()Lrx/functions/Action1;", "setCallback", "(Lrx/functions/Action1;)V", "onNestedPreScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dx", "dy", "consumed", "", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AHBottomBehavior.kt */
public final class AHBottomBehavior extends CoordinatorLayout.Behavior<AHBottomNavigation> {
    private Action1<Integer> callback;

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AHBottomNavigation aHBottomNavigation, View view, View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(aHBottomNavigation, "child");
        Intrinsics.checkNotNullParameter(view, "directTargetChild");
        Intrinsics.checkNotNullParameter(view2, "target");
        return (i & 2) != 0;
    }

    public final Action1<Integer> getCallback() {
        return this.callback;
    }

    public final void setCallback(Action1<Integer> action1) {
        this.callback = action1;
    }

    public AHBottomBehavior() {
    }

    public AHBottomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AHBottomNavigation aHBottomNavigation, View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(aHBottomNavigation, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) aHBottomNavigation, view, i, i2, iArr, i3);
        Action1<Integer> action1 = this.callback;
        if (action1 != null) {
            action1.call(Integer.valueOf(i2));
        }
    }
}
