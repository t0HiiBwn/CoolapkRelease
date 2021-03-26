package com.coolapk.market.extend;

import android.graphics.Rect;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
final class ViewExtents2Kt$tryListenWindowsInset$insetsListener$1 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ Function1 $callback;

    ViewExtents2Kt$tryListenWindowsInset$insetsListener$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        Function1 function1 = this.$callback;
        Intrinsics.checkNotNullExpressionValue(rect, "it");
        function1.invoke(rect);
    }
}
