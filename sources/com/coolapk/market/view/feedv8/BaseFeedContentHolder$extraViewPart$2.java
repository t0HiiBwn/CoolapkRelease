package com.coolapk.market.view.feedv8;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/SubmitExtraViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$extraViewPart$2 extends Lambda implements Function0<SubmitExtraViewPart> {
    final /* synthetic */ BaseFeedContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFeedContentHolder$extraViewPart$2(BaseFeedContentHolder baseFeedContentHolder) {
        super(0);
        this.this$0 = baseFeedContentHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SubmitExtraViewPart invoke() {
        SubmitExtraViewPart submitExtraViewPart = new SubmitExtraViewPart();
        LayoutInflater from = LayoutInflater.from(this.this$0.getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        submitExtraViewPart.createView(from, null);
        submitExtraViewPart.initWith(this.this$0.submitActivity);
        return submitExtraViewPart;
    }
}
