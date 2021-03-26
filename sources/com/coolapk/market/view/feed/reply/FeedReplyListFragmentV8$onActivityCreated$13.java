package com.coolapk.market.view.feed.reply;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/feed/reply/FilterArgs;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$13<T> implements Observer<FilterArgs> {
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    FeedReplyListFragmentV8$onActivityCreated$13(FeedReplyListFragmentV8 feedReplyListFragmentV8) {
        this.this$0 = feedReplyListFragmentV8;
    }

    public final void onChanged(FilterArgs filterArgs) {
        this.this$0.setPage(1);
        this.this$0.getPresenter().dispatchIntoDataList(1, this.this$0.getDataList());
        this.this$0.reloadData();
        this.this$0.addRefreshView();
    }
}
