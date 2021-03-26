package com.coolapk.market.view.app;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/view/app/AppViewBaseInfoViewHolder$photoObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
public final class AppViewBaseInfoViewHolder$photoObserver$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ AppViewBaseInfoViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewBaseInfoViewHolder$photoObserver$1(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder) {
        this.this$0 = appViewBaseInfoViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.this$0.scrollToFirst();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        this.this$0.scrollToFirst();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        this.this$0.scrollToFirst();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        this.this$0.scrollToFirst();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        this.this$0.scrollToFirst();
    }
}
