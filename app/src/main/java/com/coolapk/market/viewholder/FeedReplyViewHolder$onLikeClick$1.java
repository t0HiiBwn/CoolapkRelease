package com.coolapk.market.viewholder;

import android.text.TextUtils;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/viewholder/FeedReplyViewHolder$onLikeClick$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "onError", "", "e", "", "onNext", "stringResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyViewHolder.kt */
public final class FeedReplyViewHolder$onLikeClick$1 extends EmptySubscriber<Result<String>> {
    final /* synthetic */ FeedReplyViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedReplyViewHolder$onLikeClick$1(FeedReplyViewHolder feedReplyViewHolder) {
        this.this$0 = feedReplyViewHolder;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(UiUtils.getActivity(this.this$0.getContext()), th);
        FeedReplyViewHolder feedReplyViewHolder = this.this$0;
        feedReplyViewHolder.setLikeState(feedReplyViewHolder.getFeedReply().hasLike(), this.this$0.getFeedReply().getLikeNum());
        this.this$0.isPosting = false;
    }

    public void onNext(Result<String> result) {
        this.this$0.isPosting = false;
        if (result != null) {
            if (!TextUtils.isEmpty(result.getData())) {
                EventBus eventBus = EventBus.getDefault();
                String id = this.this$0.getFeedReply().getId();
                Integer valueOf = Integer.valueOf(result.getData());
                Intrinsics.checkNotNullExpressionValue(valueOf, "Integer.valueOf(likeNum)");
                eventBus.post(new FeedReplyLikeEvent(id, valueOf.intValue(), false));
                return;
            }
            Toast.show$default(UiUtils.getActivity(this.this$0.getContext()), result.getMessage(), 0, false, 12, null);
            FeedReplyViewHolder feedReplyViewHolder = this.this$0;
            feedReplyViewHolder.setLikeState(feedReplyViewHolder.getFeedReply().hasLike(), this.this$0.getFeedReply().getLikeNum());
        }
    }
}
