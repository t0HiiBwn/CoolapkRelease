package com.coolapk.market.view.live;

import com.coolapk.market.view.live.LivePost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LivePost.kt */
final class LivePost$post$4<T> implements Action1<Throwable> {
    final /* synthetic */ LivePost this$0;

    LivePost$post$4(LivePost livePost) {
        this.this$0 = livePost;
    }

    public final void call(Throwable th) {
        LivePost.access$setPosting$p(this.this$0, false);
        LivePost.Callback callback = this.this$0.getCallback();
        if (callback != null) {
            Intrinsics.checkNotNullExpressionValue(th, "error");
            callback.onError(th);
        }
    }
}
