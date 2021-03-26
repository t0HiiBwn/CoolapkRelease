package com.coolapk.market.view.block;

import android.app.Activity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetResult;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/block/FeedBlockSpamInterceptor$modifySheet$2$1", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBlockSpamInterceptor.kt */
public final class FeedBlockSpamInterceptor$modifySheet$$inlined$also$lambda$1 implements SheetCallback {
    final /* synthetic */ int $bgColor$inlined;
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ int $userItemColor$inlined;
    final /* synthetic */ FeedBlockSpamInterceptor this$0;

    FeedBlockSpamInterceptor$modifySheet$$inlined$also$lambda$1(FeedBlockSpamInterceptor feedBlockSpamInterceptor, int i, int i2, Object obj) {
        this.this$0 = feedBlockSpamInterceptor;
        this.$userItemColor$inlined = i;
        this.$bgColor$inlined = i2;
        this.$data$inlined = obj;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        AddBlockDialog addBlockDialog = AddBlockDialog.INSTANCE;
        Activity activity = this.this$0.getActivity();
        Object obj = this.$data$inlined;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
        addBlockDialog.showBlockNodeDialog(activity, (Feed) obj);
        return SheetResult.Companion.getClose();
    }
}
