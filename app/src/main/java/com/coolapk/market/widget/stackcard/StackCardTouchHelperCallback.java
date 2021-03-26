package com.coolapk.market.widget.stackcard;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J@\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "callback", "Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback$Callback;", "(Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback$Callback;)V", "getCallback", "()Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback$Callback;", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMovementFlags", "", "getThreshold", "", "isItemViewSwipeEnabled", "", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSwiped", "direction", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StackCardTouchHelperCallback.kt */
public final class StackCardTouchHelperCallback extends ItemTouchHelper.Callback {
    private final Callback callback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/stackcard/StackCardTouchHelperCallback$Callback;", "", "onSlided", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "direction", "onSliding", "ratio", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: StackCardTouchHelperCallback.kt */
    public interface Callback {
        void onSlided(RecyclerView.ViewHolder viewHolder, int i, int i2);

        void onSliding(RecyclerView.ViewHolder viewHolder, float f, int i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        return false;
    }

    public StackCardTouchHelperCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(0, recyclerView.getLayoutManager() instanceof StackCardLayoutManager ? 12 : 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.itemView.setOnTouchListener(null);
        int layoutPosition = viewHolder.getLayoutPosition();
        Callback callback2 = this.callback;
        int i2 = 4;
        if (i == 4) {
            i2 = 1;
        }
        callback2.onSlided(viewHolder, layoutPosition, i2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        int i2 = 1;
        if (i == 1) {
            float threshold = f / getThreshold(recyclerView, viewHolder);
            float f3 = (float) 1;
            if (threshold > f3) {
                threshold = 1.0f;
            } else if (threshold < ((float) -1)) {
                threshold = -1.0f;
            }
            view.setRotation(threshold * 0.0f);
            int childCount = recyclerView.getChildCount();
            if (childCount > 3) {
                int i3 = childCount - 1;
                for (int i4 = 1; i4 < i3; i4++) {
                    View childAt = recyclerView.getChildAt(i4);
                    Intrinsics.checkNotNullExpressionValue(childAt, "recyclerView.getChildAt(position)");
                    float f4 = (float) ((childCount - i4) - 1);
                    float f5 = f3 - (f4 * 0.1f);
                    childAt.setScaleX(f5 + (Math.abs(threshold) * 0.1f));
                    childAt.setScaleY(f5 + (Math.abs(threshold) * 0.1f));
                    childAt.setTranslationY(((f4 - Math.abs(threshold)) * ((float) view.getMeasuredHeight())) / 10.0f);
                }
            } else {
                int i5 = childCount - 1;
                int i6 = 0;
                while (i6 < i5) {
                    View childAt2 = recyclerView.getChildAt(i6);
                    Intrinsics.checkNotNullExpressionValue(childAt2, "recyclerView.getChildAt(position)");
                    float f6 = (float) ((childCount - i6) - i2);
                    float f7 = f3 - (f6 * 0.1f);
                    childAt2.setScaleX(f7 + (Math.abs(threshold) * 0.1f));
                    childAt2.setScaleY(f7 + (Math.abs(threshold) * 0.1f));
                    childAt2.setTranslationY(((f6 - Math.abs(threshold)) * ((float) view.getMeasuredHeight())) / 10.0f);
                    i6++;
                    i2 = 1;
                }
            }
            if (threshold != 0.0f) {
                this.callback.onSliding(viewHolder, threshold, threshold < ((float) 0) ? 4 : 8);
            } else {
                this.callback.onSliding(viewHolder, threshold, 1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        view.setRotation(0.0f);
    }

    private final float getThreshold(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ((float) recyclerView.getWidth()) * getSwipeThreshold(viewHolder);
    }
}
