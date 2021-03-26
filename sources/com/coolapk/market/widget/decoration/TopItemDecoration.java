package com.coolapk.market.widget.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/decoration/TopItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerHeight", "", "topOffset", "(II)V", "getDividerHeight", "()I", "drawable", "Landroid/graphics/drawable/ColorDrawable;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopItemDecoration.kt */
public class TopItemDecoration extends RecyclerView.ItemDecoration {
    private final int dividerHeight;
    private final ColorDrawable drawable;
    private final int topOffset;

    public TopItemDecoration(int i, int i2) {
        this.dividerHeight = i;
        this.topOffset = i2;
        this.drawable = new ColorDrawable(AppHolder.getAppTheme().getMainBackgroundColor());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopItemDecoration(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && recyclerView.getChildAdapterPosition(childAt) == 0) {
            this.drawable.setBounds(0, (childAt.getTop() - this.dividerHeight) - this.topOffset, recyclerView.getWidth(), childAt.getTop() - this.topOffset);
            this.drawable.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.set(0, this.dividerHeight, 0, 0);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManagerCopy) {
            i = ((StaggeredGridLayoutManagerCopy) layoutManager).getSpanCount();
        } else {
            i = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).getSpanCount() : 0;
        }
        if (childLayoutPosition < i) {
            rect.set(0, this.dividerHeight, 0, 0);
        }
    }
}
