package com.coolapk.market.extend;

import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$setTintColor$2", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$setTintColor$2 implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ int $color;
    final /* synthetic */ PorterDuffColorFilter $filter;

    ViewExtendsKt$setTintColor$2(PorterDuffColorFilter porterDuffColorFilter, int i) {
        this.$filter = porterDuffColorFilter;
        this.$color = i;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "parent");
        Intrinsics.checkNotNullParameter(view2, "child");
        if (view2 instanceof ActionMenuView) {
            ((ActionMenuView) view2).setOnHierarchyChangeListener(null);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "parent");
        Intrinsics.checkNotNullParameter(view2, "child");
        ViewExtendsKt$setTintColor$1.INSTANCE.invoke(view2, this.$filter, this.$color);
    }
}
