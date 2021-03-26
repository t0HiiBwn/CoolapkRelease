package com.coolapk.market.view.cardlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.DisplayUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/cardlist/SpecialDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "itemViewTypeArray", "", "ignoreItemViewTypeArrays", "(Landroid/content/Context;[I[I)V", "divider", "Landroid/graphics/drawable/GradientDrawable;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SpecialDividerItemDecoration.kt */
public final class SpecialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private final GradientDrawable divider;
    private final int[] ignoreItemViewTypeArrays;
    private final int[] itemViewTypeArray;

    public SpecialDividerItemDecoration(Context context, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemViewTypeArray = iArr;
        this.ignoreItemViewTypeArrays = iArr2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        gradientDrawable.setSize(0, DisplayUtils.dp2px(context, 7.0f));
        this.divider = gradientDrawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        Intrinsics.checkNotNullExpressionValue(adapter, "parent.adapter!!");
        if (childAdapterPosition < adapter.getItemCount() - 1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int itemViewType = layoutManager.getItemViewType(view);
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter2);
            int itemViewType2 = adapter2.getItemViewType(childAdapterPosition + 1);
            int[] iArr = this.ignoreItemViewTypeArrays;
            if (iArr != null) {
                for (int i : iArr) {
                    if (itemViewType2 == i) {
                        return;
                    }
                }
            }
            int[] iArr2 = this.itemViewTypeArray;
            if (iArr2 != null) {
                for (int i2 : iArr2) {
                    if (itemViewType == i2 && itemViewType2 != i2) {
                        rect.bottom = this.divider.getIntrinsicHeight();
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter);
            Intrinsics.checkNotNullExpressionValue(adapter, "parent.adapter!!");
            if (childAdapterPosition < adapter.getItemCount() - 1) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager);
                int itemViewType = layoutManager.getItemViewType(childAt);
                RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter2);
                int itemViewType2 = adapter2.getItemViewType(childAdapterPosition + 1);
                int[] iArr = this.ignoreItemViewTypeArrays;
                if (iArr != null) {
                    int length = iArr.length;
                    int i2 = 0;
                    while (i2 < length && itemViewType2 != iArr[i2]) {
                        i2++;
                    }
                }
                int[] iArr2 = this.itemViewTypeArray;
                if (iArr2 != null) {
                    for (int i3 : iArr2) {
                        if (itemViewType == i3 && itemViewType2 != i3) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                            this.divider.setBounds(paddingLeft, bottom, width, this.divider.getIntrinsicHeight() + bottom);
                            this.divider.draw(canvas);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }
}
