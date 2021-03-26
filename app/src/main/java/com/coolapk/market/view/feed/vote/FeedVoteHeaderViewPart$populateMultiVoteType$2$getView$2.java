package com.coolapk.market.view.feed.vote;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "p2", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
final /* synthetic */ class FeedVoteHeaderViewPart$populateMultiVoteType$2$getView$2 extends FunctionReferenceImpl implements Function2<String, Boolean, Boolean> {
    FeedVoteHeaderViewPart$populateMultiVoteType$2$getView$2(FeedVoteHeaderViewPart feedVoteHeaderViewPart) {
        super(2, feedVoteHeaderViewPart, FeedVoteHeaderViewPart.class, "onVoteOptionIDCheckEvent", "onVoteOptionIDCheckEvent(Ljava/lang/String;Z)Z", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(String str, Boolean bool) {
        return Boolean.valueOf(invoke(str, bool.booleanValue()));
    }

    public final boolean invoke(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "p1");
        return ((FeedVoteHeaderViewPart) this.receiver).onVoteOptionIDCheckEvent(str, z);
    }
}
