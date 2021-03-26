package com.coolapk.market.view.userv9;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/userv9/AutoLayoutBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/coolapk/market/widget/view/IgnoreInsetFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onLayoutChild", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "layoutDirection", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AutoLayoutBehavior.kt */
public final class AutoLayoutBehavior extends CoordinatorLayout.Behavior<IgnoreInsetFrameLayout> {
    public AutoLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, IgnoreInsetFrameLayout ignoreInsetFrameLayout, int i) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(ignoreInsetFrameLayout, "child");
        ignoreInsetFrameLayout.layout(0, 0, ignoreInsetFrameLayout.getMeasuredWidth(), ignoreInsetFrameLayout.getMeasuredHeight());
        return true;
    }
}
