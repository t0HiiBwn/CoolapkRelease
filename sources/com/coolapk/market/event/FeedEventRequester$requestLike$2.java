package com.coolapk.market.event;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.LikeResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/event/FeedEventRequester$requestLike$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/LikeResult;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedEventRequester$requestLike$2 extends EmptySubscriber<LikeResult> {
    final /* synthetic */ Function1 $errorHandler;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $like;
    final /* synthetic */ Function1 $successHandler;

    FeedEventRequester$requestLike$2(Function1 function1, String str, boolean z, Function1 function12) {
        this.$errorHandler = function1;
        this.$id = str;
        this.$like = z;
        this.$successHandler = function12;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Function1 function1 = this.$errorHandler;
        if (function1 == null || !((Boolean) function1.invoke(th)).booleanValue()) {
            FeedEventDispatcher.INSTANCE.dispatchLikeResult(this.$id, th, !this.$like, null);
        }
    }

    public void onNext(LikeResult likeResult) {
        super.onNext((FeedEventRequester$requestLike$2) likeResult);
        Function1 function1 = this.$successHandler;
        if (function1 == null || !((Boolean) function1.invoke(likeResult)).booleanValue()) {
            FeedEventDispatcher.INSTANCE.dispatchLikeResult(this.$id, null, this.$like, likeResult);
        }
    }
}
