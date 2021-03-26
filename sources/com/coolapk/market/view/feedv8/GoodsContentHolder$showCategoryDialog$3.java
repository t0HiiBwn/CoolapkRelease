package com.coolapk.market.view.feedv8;

import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$showCategoryDialog$3 implements Runnable {
    final /* synthetic */ RecyclerView $categoryView;

    GoodsContentHolder$showCategoryDialog$3(RecyclerView recyclerView) {
        this.$categoryView = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewParent parent = this.$categoryView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) parent).setBackground(null);
    }
}
