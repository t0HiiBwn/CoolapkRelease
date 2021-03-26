package com.coolapk.market.view.cardlist;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.video.VideoAutoPlayManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/cardlist/EntityVideoHelper$onActivityCreated$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollState", "", "getScrollState", "()I", "setScrollState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityVideoHelper.kt */
public final class EntityVideoHelper$onActivityCreated$1 extends RecyclerView.OnScrollListener {
    private int scrollState = -1;
    final /* synthetic */ EntityVideoHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    EntityVideoHelper$onActivityCreated$1(EntityVideoHelper entityVideoHelper) {
        this.this$0 = entityVideoHelper;
    }

    public final int getScrollState() {
        return this.scrollState;
    }

    public final void setScrollState(int i) {
        this.scrollState = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        this.scrollState = i;
        if (i == 0 && !this.this$0.getTempDetachAutoPlay()) {
            VideoAutoPlayManager.requestPauseInvisiblePlayer(this.this$0.getFragment());
            VideoAutoPlayManager.requestAutoResumeVisiblePlayer();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
    }
}
