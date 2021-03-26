package com.coolapk.market.view.feed.post;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.ToastKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/post/FeedTitleEditDialog$post$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedTitleEditDialog.kt */
public final class FeedTitleEditDialog$post$1 extends EmptySubscriber<Result<String>> {
    final /* synthetic */ String $submitText;
    final /* synthetic */ FeedTitleEditDialog this$0;

    FeedTitleEditDialog$post$1(FeedTitleEditDialog feedTitleEditDialog, String str) {
        this.this$0 = feedTitleEditDialog;
        this.$submitText = str;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        this.this$0.isPosting = false;
        this.this$0.setLoadingState(false);
        Throwable mayBeCause = ToastKt.getMayBeCause(th);
        if (mayBeCause instanceof ClientException) {
            FeedTitleEditDialog feedTitleEditDialog = this.this$0;
            String message = mayBeCause.getMessage();
            if (message == null) {
                message = "";
            }
            feedTitleEditDialog.setErrorText(message);
            return;
        }
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(Result<String> result) {
        Intrinsics.checkNotNullParameter(result, "t");
        super.onNext((FeedTitleEditDialog$post$1) result);
        this.this$0.setLoadingState(false);
        this.this$0.isPosting = false;
        Toast.show$default(this.this$0.getActivity(), result.getData(), 0, false, 12, null);
        Function1 function1 = this.this$0.callback;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(this.$submitText);
        }
        this.this$0.dismiss();
    }
}
