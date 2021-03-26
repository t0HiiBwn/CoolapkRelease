package com.coolapk.market.view.feedv8;

import android.util.Pair;
import com.coolapk.market.model.FeedMultiPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012F\u0010\u0003\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "string", "Landroid/util/Pair;", "", "call", "(Landroid/util/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$2$uploadLogo$1<T, R> implements Func1<Pair<String, String>, Boolean> {
    final /* synthetic */ BaseFeedContentHolder$prepareMultiFeed$2 this$0;

    BaseFeedContentHolder$prepareMultiFeed$2$uploadLogo$1(BaseFeedContentHolder$prepareMultiFeed$2 baseFeedContentHolder$prepareMultiFeed$2) {
        this.this$0 = baseFeedContentHolder$prepareMultiFeed$2;
    }

    public final Boolean call(Pair<String, String> pair) {
        BaseFeedContentHolder baseFeedContentHolder = this.this$0.this$0;
        FeedMultiPart build = FeedMultiPart.builder(this.this$0.this$0.getMultiPart()).extraPic((String) pair.second).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedMultiPart\n          …                 .build()");
        baseFeedContentHolder.updateMultiPart$presentation_coolapkAppRelease(build);
        return true;
    }
}
