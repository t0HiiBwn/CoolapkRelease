package com.coolapk.market.viewholder.v8;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.model.Feed;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"com/coolapk/market/viewholder/v8/FeedArticleViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "bindData", "", "viewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleViewHolder.kt */
public final class FeedArticleViewHolder$relativeInfoHotPlug$1 extends BaseFeedRelativeHotPlug {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedArticleViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedArticleViewHolder$relativeInfoHotPlug$1(FeedArticleViewHolder feedArticleViewHolder, DataBindingComponent dataBindingComponent, View view, DataBindingComponent dataBindingComponent2) {
        super(view, dataBindingComponent2, null, false, 12, null);
        this.this$0 = feedArticleViewHolder;
        this.$component = dataBindingComponent;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug
    public void bindData(FeedRelativeInfoViewPart feedRelativeInfoViewPart, Feed feed) {
        Intrinsics.checkNotNullParameter(feedRelativeInfoViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(feed, "data");
        feedRelativeInfoViewPart.setIgnoreTargetRow(Intrinsics.areEqual(feed.getFeedType(), "rating"));
        super.bindData(feedRelativeInfoViewPart, feed);
    }
}
