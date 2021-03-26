package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/FeedMultiPart;", "kotlin.jvm.PlatformType", "it", "", "call", "(Ljava/lang/Boolean;)Lrx/Observable;"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$4<T, R> implements Func1<Boolean, Observable<? extends FeedMultiPart>> {
    final /* synthetic */ BaseFeedContentHolder$prepareMultiFeed$5 this$0;

    BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$4(BaseFeedContentHolder$prepareMultiFeed$5 baseFeedContentHolder$prepareMultiFeed$5) {
        this.this$0 = baseFeedContentHolder$prepareMultiFeed$5;
    }

    public final Observable<? extends FeedMultiPart> call(Boolean bool) {
        BaseFeedContentHolder baseFeedContentHolder = this.this$0.this$0;
        List<ImageUrl> imageUriList = this.this$0.this$0.getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "multiPart.imageUriList()");
        FeedMultiPart build = FeedMultiPart.builder(this.this$0.this$0.getMultiPart()).pic(baseFeedContentHolder.buildImageString(imageUriList)).build();
        BaseFeedContentHolder baseFeedContentHolder2 = this.this$0.this$0;
        Intrinsics.checkNotNullExpressionValue(build, "part");
        baseFeedContentHolder2.updateMultiPart$presentation_coolapkAppRelease(build);
        return Observable.just(build);
    }
}
