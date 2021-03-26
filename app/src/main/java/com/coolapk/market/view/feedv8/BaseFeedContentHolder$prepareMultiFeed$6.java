package com.coolapk.market.view.feedv8;

import android.app.ProgressDialog;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FeedMultiPart;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$6<T> implements Action1<FeedMultiPart> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ BaseFeedContentHolder this$0;

    BaseFeedContentHolder$prepareMultiFeed$6(BaseFeedContentHolder baseFeedContentHolder, ProgressDialog progressDialog) {
        this.this$0 = baseFeedContentHolder;
        this.$dialog = progressDialog;
    }

    public final void call(FeedMultiPart feedMultiPart) {
        this.$dialog.setMessage("正在提交...");
        BaseFeedContentHolder.PostListener postListener = this.this$0.listener;
        if (postListener != null) {
            postListener.onNewMessage("正在提交...");
        }
    }
}
