package com.coolapk.market.extend;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/extend/WrapOnApplyWindowInsetsListener;", "Landroid/view/View$OnApplyWindowInsetsListener;", "old", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", "callbacks", "", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "", "getCallbacks", "()Ljava/util/List;", "getOld", "()Landroid/view/View$OnApplyWindowInsetsListener;", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "v", "Landroid/view/View;", "insets", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
final class WrapOnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
    private final List<Function1<Rect, Unit>> callbacks = new ArrayList();
    private final View.OnApplyWindowInsetsListener old;

    public WrapOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.old = onApplyWindowInsetsListener;
    }

    public final View.OnApplyWindowInsetsListener getOld() {
        return this.old;
    }

    public final List<Function1<Rect, Unit>> getCallbacks() {
        return this.callbacks;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets;
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        Iterator<T> it2 = this.callbacks.iterator();
        while (it2.hasNext()) {
            it2.next().invoke(new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()));
        }
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.old;
        return (onApplyWindowInsetsListener == null || (onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets)) == null) ? windowInsets : onApplyWindowInsets;
    }
}
