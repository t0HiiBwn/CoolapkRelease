package com.coolapk.market.view.feed;

import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailActivityV8.kt */
final class FeedDetailActivityV8$loadFeedInfo$1$onNext$2<T> implements Action1<Throwable> {
    final /* synthetic */ FeedDetailActivityV8$loadFeedInfo$1 this$0;

    FeedDetailActivityV8$loadFeedInfo$1$onNext$2(FeedDetailActivityV8$loadFeedInfo$1 feedDetailActivityV8$loadFeedInfo$1) {
        this.this$0 = feedDetailActivityV8$loadFeedInfo$1;
    }

    public final void call(Throwable th) {
        Toast.error(this.this$0.this$0.getActivity(), th);
    }
}