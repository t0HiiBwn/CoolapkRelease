package com.coolapk.market.view.feedv8;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/ArticleFeedBaseContentHolder$onCreateContentView$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getExtraLayoutSpace", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleFeedBaseContentHolder.kt */
public final class ArticleFeedBaseContentHolder$onCreateContentView$1 extends LinearLayoutManager {
    final /* synthetic */ ArticleFeedBaseContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFeedBaseContentHolder$onCreateContentView$1(ArticleFeedBaseContentHolder articleFeedBaseContentHolder, Context context) {
        super(context);
        this.this$0 = articleFeedBaseContentHolder;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return DisplayUtils.dp2px(this.this$0.getActivity(), 200.0f);
    }
}
