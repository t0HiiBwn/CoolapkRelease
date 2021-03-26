package com.coolapk.market.view.collectionList;

import com.coolapk.market.model.Feed;
import com.coolapk.market.view.collectionList.CollectionDetailActivity;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, d2 = {"com/coolapk/market/view/collectionList/CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$2$1$callback$1", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "presentation_coolapkAppRelease", "com/coolapk/market/view/collectionList/CollectionDetailActivity$FeedCollectionSheetModifier$$special$$inlined$run$lambda$1"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailActivity.kt */
public final class CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1 implements SheetCallback {
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ boolean $isFeedTop;
    final /* synthetic */ List $itemsDataList$inlined;
    final /* synthetic */ CollectionDetailActivity.FeedCollectionSheetModifier $this_run;
    final /* synthetic */ CollectionDetailActivity.FeedCollectionSheetModifier this$0;

    CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1(CollectionDetailActivity.FeedCollectionSheetModifier feedCollectionSheetModifier, boolean z, List list, CollectionDetailActivity.FeedCollectionSheetModifier feedCollectionSheetModifier2, Object obj) {
        this.$this_run = feedCollectionSheetModifier;
        this.$isFeedTop = z;
        this.$itemsDataList$inlined = list;
        this.this$0 = feedCollectionSheetModifier2;
        this.$data$inlined = obj;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        this.$this_run.handleTop((Feed) this.$data$inlined, this.$isFeedTop);
        return SheetResult.Companion.getClose();
    }
}
