package com.coolapk.market.view.app;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.viewholder.v8.FeedViewHolderV8;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewListFragment.kt */
final class AppViewListFragment$onActivityCreated$12 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ AppViewListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewListFragment$onActivityCreated$12(AppViewListFragment appViewListFragment) {
        super(1);
        this.this$0 = appViewListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new FeedViewHolderV8(this, view, view, this.this$0.getBindingComponent(), null) {
            /* class com.coolapk.market.view.app.AppViewListFragment$onActivityCreated$12.AnonymousClass1 */
            final /* synthetic */ View $itemView;
            final /* synthetic */ AppViewListFragment$onActivityCreated$12 this$0;

            {
                this.this$0 = r1;
                this.$itemView = r2;
            }

            @Override // com.coolapk.market.viewholder.v8.FeedViewHolderV8
            public void bindToContent(Feed feed) {
                Intrinsics.checkNotNullParameter(feed, "feed");
                super.bindToContent(feed);
                hideFromWhereView();
            }
        };
    }
}
