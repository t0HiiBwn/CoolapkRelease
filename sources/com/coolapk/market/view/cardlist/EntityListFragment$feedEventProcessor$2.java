package com.coolapk.market.view.cardlist;

import com.coolapk.market.view.feed.FeedEventProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/FeedEventProcessor;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$feedEventProcessor$2 extends Lambda implements Function0<FeedEventProcessor> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$feedEventProcessor$2(EntityListFragment entityListFragment) {
        super(0);
        this.this$0 = entityListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedEventProcessor invoke() {
        return new FeedEventProcessor(this.this$0.dataList, this.this$0);
    }
}
