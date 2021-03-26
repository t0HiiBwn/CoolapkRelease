package com.coolapk.market.view.node;

import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/node/NodeFeedDialogInterceptor$buildChildSheetItems$callback$1", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeFeedDialogInterceptor.kt */
public final class NodeFeedDialogInterceptor$buildChildSheetItems$callback$1 implements SheetCallback {
    final /* synthetic */ Object $data;
    final /* synthetic */ boolean $isFeedTop;
    final /* synthetic */ NodeFeedDialogInterceptor this$0;

    NodeFeedDialogInterceptor$buildChildSheetItems$callback$1(NodeFeedDialogInterceptor nodeFeedDialogInterceptor, boolean z, Object obj) {
        this.this$0 = nodeFeedDialogInterceptor;
        this.$isFeedTop = z;
        this.$data = obj;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        this.this$0.checkAndShowSetFeedTopHint(this.$isFeedTop, (Feed) this.$data);
        return SheetResult.Companion.getClose();
    }
}
