package com.coolapk.market.view.feedv8.util;

import android.app.Dialog;
import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showAddGoodsDialog$2$subscription$2 implements Action0 {
    final /* synthetic */ Dialog $dialog;

    FeedGoodsHelper$showAddGoodsDialog$2$subscription$2(Dialog dialog) {
        this.$dialog = dialog;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$dialog.dismiss();
    }
}
