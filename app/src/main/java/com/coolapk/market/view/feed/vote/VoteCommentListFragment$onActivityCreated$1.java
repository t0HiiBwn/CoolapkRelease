package com.coolapk.market.view.feed.vote;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/coolapk/market/view/feed/vote/VoteCommentListFragment$onActivityCreated$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "src", "Landroid/graphics/Rect;", "getItemOffsets", "", "outRect", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentListFragment.kt */
public final class VoteCommentListFragment$onActivityCreated$1 extends RecyclerView.ItemDecoration {
    private final Rect src = new Rect(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4));

    VoteCommentListFragment$onActivityCreated$1() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        rect.set(this.src);
    }
}
