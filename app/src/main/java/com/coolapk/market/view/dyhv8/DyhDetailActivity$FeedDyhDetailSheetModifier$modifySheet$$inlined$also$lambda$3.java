package com.coolapk.market.view.dyhv8;

import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.dyhv8.DyhDetailActivity;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/dyhv8/DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$2$item$1", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhDetailActivity.kt */
public final class DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$3 implements SheetCallback {
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ DyhModel $dyhModel$inlined;
    final /* synthetic */ boolean $isAdmin$inlined;
    final /* synthetic */ boolean $isDyhAdmin$inlined;
    final /* synthetic */ boolean $isEditor$inlined;
    final /* synthetic */ int $page$inlined;
    final /* synthetic */ DyhDetailActivity.FeedDyhDetailSheetModifier this$0;

    DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$3(DyhDetailActivity.FeedDyhDetailSheetModifier feedDyhDetailSheetModifier, boolean z, int i, boolean z2, Object obj, boolean z3, DyhModel dyhModel) {
        this.this$0 = feedDyhDetailSheetModifier;
        this.$isEditor$inlined = z;
        this.$page$inlined = i;
        this.$isDyhAdmin$inlined = z2;
        this.$data$inlined = obj;
        this.$isAdmin$inlined = z3;
        this.$dyhModel$inlined = dyhModel;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        this.this$0.handleDyhRemove((Feed) this.$data$inlined, this.$dyhModel$inlined);
        return SheetResult.Companion.getClose();
    }
}
