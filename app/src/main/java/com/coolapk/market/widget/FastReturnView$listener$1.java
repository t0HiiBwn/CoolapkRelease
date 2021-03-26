package com.coolapk.market.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/FastReturnView$listener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView$listener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ FastReturnView this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FastReturnView$listener$1(FastReturnView fastReturnView) {
        this.this$0 = fastReturnView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.this$0.hideView(true);
        RecyclerView recyclerView = this.this$0.lastRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        Object obj = this.this$0.refreshView;
        if (obj instanceof NewAsyncListFragment) {
            Object obj2 = this.this$0.refreshView;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.NewAsyncListFragment<*>");
            NewAsyncListFragment newAsyncListFragment = (NewAsyncListFragment) obj2;
            SwipeRefreshLayout swipeRefreshLayout = newAsyncListFragment.getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            if (swipeRefreshLayout.isEnabled()) {
                SwipeRefreshLayout swipeRefreshLayout2 = newAsyncListFragment.getSwipeRefreshLayout();
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout2, "swipeRefreshLayout");
                swipeRefreshLayout2.setRefreshing(true);
                newAsyncListFragment.reloadData();
            }
        } else if (obj instanceof AsyncListFragment) {
            Object obj3 = this.this$0.refreshView;
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type com.coolapk.market.view.base.asynclist.AsyncListFragment<*, *>");
            AsyncListFragment asyncListFragment = (AsyncListFragment) obj3;
            SwipeRefreshLayout swipeRefreshLayout3 = asyncListFragment.getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout3, "swipeRefreshLayout");
            if (swipeRefreshLayout3.isEnabled()) {
                SwipeRefreshLayout swipeRefreshLayout4 = asyncListFragment.getSwipeRefreshLayout();
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout4, "swipeRefreshLayout");
                swipeRefreshLayout4.setRefreshing(true);
                asyncListFragment.reloadData();
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.this$0.hideView(true);
        RecyclerView recyclerView = this.this$0.lastRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        return true;
    }
}
