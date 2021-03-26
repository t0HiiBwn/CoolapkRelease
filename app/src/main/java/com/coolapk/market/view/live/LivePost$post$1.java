package com.coolapk.market.view.live;

import com.coolapk.market.view.live.LivePost;
import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LivePost.kt */
final class LivePost$post$1 implements Action0 {
    final /* synthetic */ LivePost this$0;

    LivePost$post$1(LivePost livePost) {
        this.this$0 = livePost;
    }

    @Override // rx.functions.Action0
    public final void call() {
        LivePost.access$setPosting$p(this.this$0, true);
        LivePost.Callback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onSubscribe();
        }
    }
}
