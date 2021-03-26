package com.coolapk.market.view.feed;

import android.app.Dialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$doPost$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "onError", "", "e", "", "onNext", "result", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$doPost$1 extends EmptySubscriber<Result<T>> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Function1 $send;
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$doPost$1(ReplyActivity replyActivity, Dialog dialog, Function1 function1) {
        this.this$0 = replyActivity;
        this.$dialog = dialog;
        this.$send = function1;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        this.$dialog.dismiss();
        this.this$0.isPosting = false;
    }

    public void onNext(Result<T> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.isPosting = false;
        this.$dialog.dismiss();
        this.this$0.shouldCacheTheDraftOnPause = false;
        DataManager.getInstance().removeDraft(ReplyActivity.access$getFeedDraft$p(this.this$0));
        this.$send.invoke(result);
        this.this$0.startCloseAnimation();
    }
}
