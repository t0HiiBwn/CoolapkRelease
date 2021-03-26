package com.coolapk.market.view.live;

import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.live.LivePost;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "data", "", "Lcom/coolapk/market/model/LiveMessage;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LivePost.kt */
final class LivePost$post$3<T> implements Action1<List<LiveMessage>> {
    final /* synthetic */ LivePost this$0;

    LivePost$post$3(LivePost livePost) {
        this.this$0 = livePost;
    }

    public final void call(List<LiveMessage> list) {
        LivePost.access$setPosting$p(this.this$0, false);
        LivePost.Callback callback = this.this$0.getCallback();
        if (callback != null) {
            Intrinsics.checkNotNullExpressionValue(list, "data");
            callback.onNext(list);
        }
    }
}
