package com.coolapk.market.view.feed;

import android.app.ProgressDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.OtherPostEvent;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/ForwardEntityActivity$submitForwardFeed$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "result", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
public final class ForwardEntityActivity$submitForwardFeed$1 extends EmptySubscriber<Result<Entity>> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ ForwardEntityActivity this$0;

    ForwardEntityActivity$submitForwardFeed$1(ForwardEntityActivity forwardEntityActivity, ProgressDialog progressDialog) {
        this.this$0 = forwardEntityActivity;
        this.$dialog = progressDialog;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        this.$dialog.dismiss();
        this.this$0.isPosting = false;
    }

    public void onNext(Result<Entity> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.isPosting = false;
        this.$dialog.dismiss();
        Entity data = result.getData();
        if (data instanceof Feed) {
            EventBus.getDefault().post(new FeedPostEvent((Feed) data, null, null, 6, null));
            this.this$0.onBackPressed();
            AppHolder.getMainThreadHandler().postDelayed(new ForwardEntityActivity$submitForwardFeed$1$onNext$1(this), 400);
        } else if (data != null) {
            EventBus.getDefault().post(new OtherPostEvent(data, null, null, 6, null));
            this.this$0.onBackPressed();
        } else {
            Toast.show$default(this.this$0.getActivity(), result.getMessage(), 0, false, 12, null);
        }
    }
}
