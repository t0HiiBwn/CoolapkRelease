package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.util.ColorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "left", "", "right", "invoke", "com/coolapk/market/view/feedv8/VoteExtraView$onItemClick$5$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$onItemClick$$inlined$apply$lambda$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ int $leftColor$inlined;
    final /* synthetic */ int $rightColor$inlined;
    final /* synthetic */ VoteExtraView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteExtraView$onItemClick$$inlined$apply$lambda$1(VoteExtraView voteExtraView, int i, int i2) {
        super(2);
        this.this$0 = voteExtraView;
        this.$leftColor$inlined = i;
        this.$rightColor$inlined = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        VoteExtraView voteExtraView = this.this$0;
        FeedMultiPart build = voteExtraView.getMultiPart().newBuilder().voteOptionColors(CollectionsKt.mutableListOf(ColorUtils.toColorString(i), ColorUtils.toColorString(i2))).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …                 .build()");
        voteExtraView.setMultiPart(build);
        this.this$0.requestUpdateDataList();
    }
}
