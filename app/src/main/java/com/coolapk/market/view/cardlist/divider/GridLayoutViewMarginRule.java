package com.coolapk.market.view.cardlist.divider;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.recyclerviewdivider.extension.LayoutManagerExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/GridLayoutViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getPositionMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "lm", "Landroidx/recyclerview/widget/GridLayoutManager;", "position", "", "default", "getViewMarginData", "current", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListViewMarginRule.kt */
public final class GridLayoutViewMarginRule implements ViewMarginRule {
    private final RecyclerView recyclerView;

    public GridLayoutViewMarginRule(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
    public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
        Intrinsics.checkNotNullParameter(obj, "current");
        Intrinsics.checkNotNullParameter(viewMarginData, "default");
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager == null || !(obj instanceof Entity)) {
            return null;
        }
        Entity entity = (Entity) obj;
        if (Intrinsics.areEqual(EntityExtendsKt.uniqueType(entity), "liveTopic") && EntityExtendsKt.getIntExtraData(entity, "cols", 1) > 1) {
            return getPositionMarginData(gridLayoutManager, i, viewMarginData);
        }
        return null;
    }

    private final ViewMarginData getPositionMarginData(GridLayoutManager gridLayoutManager, int i, ViewMarginData viewMarginData) {
        int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager gridLayoutManager2 = gridLayoutManager;
        int spanSize = LayoutManagerExtensionsKt.getSpanSize(gridLayoutManager2, i);
        int accumulatedSpanInLine = LayoutManagerExtensionsKt.getAccumulatedSpanInLine(gridLayoutManager2, spanSize, i, LayoutManagerExtensionsKt.getGroupIndex(gridLayoutManager2, i));
        if (spanCount == 1 || spanSize == spanCount) {
            return viewMarginData;
        }
        if (accumulatedSpanInLine == spanSize) {
            return ViewMarginData.Companion.obtain(viewMarginData.getLeftMargin(), NumberExtendsKt.getDp((Number) 4));
        }
        if (accumulatedSpanInLine == spanCount) {
            return ViewMarginData.Companion.obtain(NumberExtendsKt.getDp((Number) 4), viewMarginData.getRightMargin());
        }
        return ViewMarginData.Companion.obtain(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4));
    }
}
