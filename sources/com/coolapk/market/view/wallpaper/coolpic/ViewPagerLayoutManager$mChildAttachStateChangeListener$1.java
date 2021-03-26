package com.coolapk.market.view.wallpaper.coolpic;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager$mChildAttachStateChangeListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPagerLayoutManager.kt */
public final class ViewPagerLayoutManager$mChildAttachStateChangeListener$1 implements RecyclerView.OnChildAttachStateChangeListener {
    final /* synthetic */ ViewPagerLayoutManager this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ViewPagerLayoutManager$mChildAttachStateChangeListener$1(ViewPagerLayoutManager viewPagerLayoutManager) {
        this.this$0 = viewPagerLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.this$0.mOnViewPagerListener != null && this.this$0.getChildCount() == 1) {
            OnViewPagerListener onViewPagerListener = this.this$0.mOnViewPagerListener;
            Intrinsics.checkNotNull(onViewPagerListener);
            onViewPagerListener.onInitComplete();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.this$0.mOnViewPagerListener == null) {
            return;
        }
        if (this.this$0.mDrift >= 0) {
            OnViewPagerListener onViewPagerListener = this.this$0.mOnViewPagerListener;
            Intrinsics.checkNotNull(onViewPagerListener);
            onViewPagerListener.onPageRelease(true, this.this$0.getPosition(view));
            return;
        }
        OnViewPagerListener onViewPagerListener2 = this.this$0.mOnViewPagerListener;
        Intrinsics.checkNotNull(onViewPagerListener2);
        onViewPagerListener2.onPageRelease(false, this.this$0.getPosition(view));
    }
}
