package com.coolapk.market.widget.recyclerviewdivider.extension;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u000f"}, d2 = {"orientation", "", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getOrientation", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)I", "spanCount", "getSpanCount", "getAccumulatedSpanInLine", "spanSize", "itemPosition", "groupIndex", "getGroupCount", "itemCount", "getGroupIndex", "getSpanSize", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LayoutManagerExtensions.kt */
public final class LayoutManagerExtensionsKt {
    public static final int getOrientation(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "$this$orientation");
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    public static final int getSpanCount(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "$this$spanCount");
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    public static final int getSpanSize(RecyclerView.LayoutManager layoutManager, int i) {
        GridLayoutManager.SpanSizeLookup spanSizeLookup;
        Intrinsics.checkNotNullParameter(layoutManager, "$this$getSpanSize");
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager == null || (spanSizeLookup = gridLayoutManager.getSpanSizeLookup()) == null) {
            return 1;
        }
        return spanSizeLookup.getSpanSize(i);
    }

    public static final int getGroupIndex(RecyclerView.LayoutManager layoutManager, int i) {
        GridLayoutManager.SpanSizeLookup spanSizeLookup;
        Intrinsics.checkNotNullParameter(layoutManager, "$this$getGroupIndex");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) (!(layoutManager instanceof GridLayoutManager) ? null : layoutManager);
        return (gridLayoutManager == null || (spanSizeLookup = gridLayoutManager.getSpanSizeLookup()) == null) ? i : spanSizeLookup.getSpanGroupIndex(i, ((GridLayoutManager) layoutManager).getSpanCount());
    }

    public static final int getGroupCount(RecyclerView.LayoutManager layoutManager, int i) {
        Intrinsics.checkNotNullParameter(layoutManager, "$this$getGroupCount");
        if (!(layoutManager instanceof GridLayoutManager)) {
            return i;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
        int spanCount = gridLayoutManager.getSpanCount();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (spanSizeLookup.getSpanIndex(i3, spanCount) == 0) {
                i2++;
            }
        }
        return i2;
    }

    public static final int getAccumulatedSpanInLine(RecyclerView.LayoutManager layoutManager, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(layoutManager, "$this$getAccumulatedSpanInLine");
        int i4 = i2 - 1;
        while (i4 >= 0 && getGroupIndex(layoutManager, i4) == i3) {
            i += getSpanSize(layoutManager, i4);
            i4--;
        }
        return i;
    }
}
