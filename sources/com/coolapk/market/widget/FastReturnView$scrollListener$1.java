package com.coolapk.market.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/widget/FastReturnView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "clear", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView$scrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ FastReturnView this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FastReturnView$scrollListener$1(FastReturnView fastReturnView) {
        this.this$0 = fastReturnView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if ((this.this$0.isShowFastReturnView()) && i == 0) {
            this.this$0.hideView(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (this.this$0.isShowFastReturnView()) {
            if (!ViewExtendsKt.canScrollDown(recyclerView)) {
                this.this$0.hideView(true);
            } else if (!(this.this$0.isShow) && ((float) recyclerView.computeVerticalScrollOffset()) > this.this$0.touchSlop) {
                this.this$0.showView();
            }
        }
    }

    public final void clear() {
        RecyclerView recyclerView = this.this$0.lastRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
    }
}
