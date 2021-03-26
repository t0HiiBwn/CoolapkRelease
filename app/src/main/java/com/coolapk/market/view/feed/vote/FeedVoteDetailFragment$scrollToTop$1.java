package com.coolapk.market.view.feed.vote;

import com.coolapk.market.view.main.DataListViewPagerConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
final /* synthetic */ class FeedVoteDetailFragment$scrollToTop$1 extends MutablePropertyReference0Impl {
    FeedVoteDetailFragment$scrollToTop$1(FeedVoteDetailFragment feedVoteDetailFragment) {
        super(feedVoteDetailFragment, FeedVoteDetailFragment.class, "viewPagerConverter", "getViewPagerConverter()Lcom/coolapk/market/view/main/DataListViewPagerConverter;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return FeedVoteDetailFragment.access$getViewPagerConverter$p((FeedVoteDetailFragment) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((FeedVoteDetailFragment) this.receiver).viewPagerConverter = (DataListViewPagerConverter) obj;
    }
}
