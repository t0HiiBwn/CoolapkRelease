package com.coolapk.market.view.feed.post;

import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedTitleEditDialog.kt */
final class FeedTitleEditDialog$onActivityCreated$4 implements Runnable {
    final /* synthetic */ FeedTitleEditDialog this$0;

    FeedTitleEditDialog$onActivityCreated$4(FeedTitleEditDialog feedTitleEditDialog) {
        this.this$0 = feedTitleEditDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UiUtils.openKeyboard(FeedTitleEditDialog.access$getBinding$p(this.this$0).editText);
    }
}
