package com.coolapk.market.view.feedv8;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.feedv8.BaseFeedContentHolder;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/BaseFeedContentHolder$startSubmitFeed$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "result", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public final class BaseFeedContentHolder$startSubmitFeed$2 extends EmptySubscriber<Result<Entity>> {
    final /* synthetic */ BaseFeedContentHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFeedContentHolder$startSubmitFeed$2(BaseFeedContentHolder baseFeedContentHolder) {
        this.this$0 = baseFeedContentHolder;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        BaseFeedContentHolder.PostListener postListener = this.this$0.listener;
        if (postListener != null) {
            postListener.onPostResult(th);
        }
        Toast.error(this.this$0.getActivity(), th);
        this.this$0.isPosting = false;
    }

    public void onNext(Result<Entity> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean z = false;
        this.this$0.isPosting = false;
        this.this$0.isPostSucceed = true;
        Entity data = result.getData();
        if (data != null) {
            AppHolder.getMainThreadHandler().postDelayed(new BaseFeedContentHolder$startSubmitFeed$2$onNext$1(this), 400);
        }
        if (data instanceof Feed) {
            Feed feed = (Feed) data;
            if (Intrinsics.areEqual(feed.getFeedType(), "ershou")) {
                StatisticHelper.Companion.getInstance().recordSecondHandChannelEvent("发布二手");
            }
            StatisticHelper.Companion.getInstance().recordPostFeedEvent(feed);
            this.this$0.submitActivity.onFeedPosted(data);
        } else if (data != null) {
            this.this$0.submitActivity.onFeedPosted(data);
        } else {
            String messageStatus = result.getMessageStatus();
            if (messageStatus != null) {
                if (messageStatus.length() > 0) {
                    z = true;
                }
                if (z) {
                    MessageStatusHelper messageStatusHelper = new MessageStatusHelper(this.this$0.getActivity(), new BaseFeedContentHolder$startSubmitFeed$2$onNext$2(this.this$0));
                    String message = result.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "result.message");
                    messageStatusHelper.handleMessageStatus(messageStatus, message, result.getMessageExtra());
                }
            }
            Toast.show$default(this.this$0.getActivity(), result.getMessage(), 0, false, 12, null);
        }
        BaseFeedContentHolder.PostListener postListener = this.this$0.listener;
        if (postListener != null) {
            postListener.onPostResult(null);
        }
    }
}
