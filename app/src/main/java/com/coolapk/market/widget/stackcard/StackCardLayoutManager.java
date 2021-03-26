package com.coolapk.market.widget.stackcard;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/widget/stackcard/StackCardLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/ItemTouchHelper;)V", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "isAutoMeasureEnabled", "", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StackCardLayoutManager.kt */
public final class StackCardLayoutManager extends RecyclerView.LayoutManager {
    private final ItemTouchHelper itemTouchHelper;
    private final RecyclerView recyclerView;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public StackCardLayoutManager(RecyclerView recyclerView2, ItemTouchHelper itemTouchHelper2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(itemTouchHelper2, "itemTouchHelper");
        this.recyclerView = recyclerView2;
        this.itemTouchHelper = itemTouchHelper2;
    }

    public final ItemTouchHelper getItemTouchHelper() {
        return this.itemTouchHelper;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount > 3) {
            for (int i = 3; i >= 0; i--) {
                View viewForPosition = recycler.getViewForPosition(i);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(position)");
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int width = (getWidth() - getDecoratedMeasuredWidth(viewForPosition)) / 2;
                int height = (getHeight() - getDecoratedMeasuredHeight(viewForPosition)) / 5;
                layoutDecoratedWithMargins(viewForPosition, width, height, width + getDecoratedMeasuredWidth(viewForPosition), height + getDecoratedMeasuredHeight(viewForPosition));
                if (i == 3) {
                    int i2 = i - 1;
                    float f = ((float) 1) - (((float) i2) * 0.1f);
                    viewForPosition.setScaleX(f);
                    viewForPosition.setScaleY(f);
                    viewForPosition.setTranslationY(((float) (i2 * viewForPosition.getMeasuredHeight())) / 10.0f);
                } else if (i > 0) {
                    float f2 = ((float) 1) - (((float) i) * 0.1f);
                    viewForPosition.setScaleX(f2);
                    viewForPosition.setScaleY(f2);
                    viewForPosition.setTranslationY(((float) (viewForPosition.getMeasuredHeight() * i)) / 10.0f);
                }
            }
            return;
        }
        for (int i3 = itemCount - 1; i3 >= 0; i3--) {
            View viewForPosition2 = recycler.getViewForPosition(i3);
            Intrinsics.checkNotNullExpressionValue(viewForPosition2, "recycler.getViewForPosition(position)");
            addView(viewForPosition2);
            measureChildWithMargins(viewForPosition2, 0, 0);
            int width2 = (getWidth() - getDecoratedMeasuredWidth(viewForPosition2)) / 2;
            int height2 = (getHeight() - getDecoratedMeasuredHeight(viewForPosition2)) / 5;
            layoutDecoratedWithMargins(viewForPosition2, width2, height2, width2 + getDecoratedMeasuredWidth(viewForPosition2), height2 + getDecoratedMeasuredHeight(viewForPosition2));
            if (i3 > 0) {
                float f3 = ((float) 1) - (((float) i3) * 0.1f);
                viewForPosition2.setScaleX(f3);
                viewForPosition2.setScaleY(f3);
                viewForPosition2.setTranslationY(((float) (viewForPosition2.getMeasuredHeight() * i3)) / 10.0f);
            }
        }
    }
}
