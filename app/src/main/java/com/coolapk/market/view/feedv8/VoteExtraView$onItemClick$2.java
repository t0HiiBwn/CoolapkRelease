package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.util.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/util/DialogUtil$DialogItemData;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$onItemClick$2 extends Lambda implements Function1<DialogUtil.DialogItemData, Unit> {
    final /* synthetic */ VoteExtraView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteExtraView$onItemClick$2(VoteExtraView voteExtraView) {
        super(1);
        this.this$0 = voteExtraView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DialogUtil.DialogItemData dialogItemData) {
        invoke(dialogItemData);
        return Unit.INSTANCE;
    }

    public final void invoke(DialogUtil.DialogItemData dialogItemData) {
        Intrinsics.checkNotNullParameter(dialogItemData, "it");
        VoteExtraView voteExtraView = this.this$0;
        FeedMultiPart build = voteExtraView.getMultiPart().newBuilder().voteMaxSelectNum(Integer.parseInt(dialogItemData.getType())).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …                 .build()");
        voteExtraView.setMultiPart(build);
        this.this$0.requestUpdateDataList();
    }
}
