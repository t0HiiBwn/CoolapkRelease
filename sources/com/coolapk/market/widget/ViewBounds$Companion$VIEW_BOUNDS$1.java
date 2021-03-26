package com.coolapk.market.widget;

import android.util.Property;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, d2 = {"com/coolapk/market/widget/ViewBounds$Companion$VIEW_BOUNDS$1", "Landroid/util/Property;", "Landroid/view/View;", "Lcom/coolapk/market/widget/ViewBounds;", "get", "view", "set", "", "value", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewBounds.kt */
public final class ViewBounds$Companion$VIEW_BOUNDS$1 extends Property<View, ViewBounds> {
    ViewBounds$Companion$VIEW_BOUNDS$1(Class cls, String str) {
        super(cls, str);
    }

    public void set(View view, ViewBounds viewBounds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewBounds, "value");
        viewBounds.applyToView(view);
        ViewBounds.Companion.release(viewBounds);
    }

    public ViewBounds get(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewBounds.Companion.acquire(view);
    }
}
