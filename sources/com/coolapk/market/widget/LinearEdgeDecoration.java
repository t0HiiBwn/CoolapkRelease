package com.coolapk.market.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/LinearEdgeDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "startPadding", "", "endPadding", "orientation", "inverted", "", "(IIIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LinearEdgeDecoration.kt */
public final class LinearEdgeDecoration extends RecyclerView.ItemDecoration {
    private final int endPadding;
    private final boolean inverted;
    private final int orientation;
    private final int startPadding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinearEdgeDecoration(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? i : i2, (i4 & 4) != 0 ? 1 : i3, (i4 & 8) != 0 ? false : z);
    }

    public LinearEdgeDecoration(int i, int i2, int i3, boolean z) {
        this.startPadding = i;
        this.endPadding = i2;
        this.orientation = i3;
        this.inverted = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
        int itemCount = layoutManager.getItemCount();
        if (viewAdapterPosition != -1 && itemCount != 0) {
            if (viewAdapterPosition > 0 && viewAdapterPosition < itemCount - 1) {
                return;
            }
            if (this.orientation == 0) {
                if (viewAdapterPosition == 0) {
                    if (!this.inverted) {
                        rect.left = this.startPadding;
                    } else {
                        rect.right = this.startPadding;
                    }
                } else if (viewAdapterPosition != itemCount - 1) {
                } else {
                    if (!this.inverted) {
                        rect.right = this.endPadding;
                    } else {
                        rect.left = this.endPadding;
                    }
                }
            } else if (viewAdapterPosition == 0) {
                if (!this.inverted) {
                    rect.top = this.startPadding;
                } else {
                    rect.bottom = this.startPadding;
                }
            } else if (viewAdapterPosition != itemCount - 1) {
            } else {
                if (!this.inverted) {
                    rect.bottom = this.endPadding;
                } else {
                    rect.top = this.endPadding;
                }
            }
        }
    }
}
