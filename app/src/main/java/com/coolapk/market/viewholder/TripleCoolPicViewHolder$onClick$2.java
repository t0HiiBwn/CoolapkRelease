package com.coolapk.market.viewholder;

import com.coolapk.market.model.Feed;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: TripleCoolPicViewHolder.kt */
final class TripleCoolPicViewHolder$onClick$2 implements Runnable {
    final /* synthetic */ Feed $feed;
    final /* synthetic */ TripleCoolPicViewHolder this$0;

    TripleCoolPicViewHolder$onClick$2(TripleCoolPicViewHolder tripleCoolPicViewHolder, Feed feed) {
        this.this$0 = tripleCoolPicViewHolder;
        this.$feed = feed;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.onLikeAction(this.$feed);
    }
}
