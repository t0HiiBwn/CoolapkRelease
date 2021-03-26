package com.coolapk.market.viewholder.v8;

import android.widget.FrameLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.widget.LinearAdapterLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteListViewPart.kt */
final class FeedVoteListViewPart$voteMultiView$2 extends Lambda implements Function0<LinearAdapterLayout> {
    final /* synthetic */ FeedVoteListViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteListViewPart$voteMultiView$2(FeedVoteListViewPart feedVoteListViewPart) {
        super(0);
        this.this$0 = feedVoteListViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LinearAdapterLayout invoke() {
        LinearAdapterLayout linearAdapterLayout = new LinearAdapterLayout(this.this$0.getContext(), null);
        linearAdapterLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ConvertUtils.dp2px(16.0f);
        layoutParams.rightMargin = ConvertUtils.dp2px(16.0f);
        Unit unit = Unit.INSTANCE;
        linearAdapterLayout.setLayoutParams(layoutParams);
        return linearAdapterLayout;
    }
}
