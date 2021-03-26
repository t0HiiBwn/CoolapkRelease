package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/FeedSmallHeaderViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedIntegratedHeaderViewPart.kt */
final class FeedIntegratedHeaderViewPart$smallHeader$2 extends Lambda implements Function0<FeedSmallHeaderViewPart> {
    final /* synthetic */ FeedIntegratedHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedIntegratedHeaderViewPart$smallHeader$2(FeedIntegratedHeaderViewPart feedIntegratedHeaderViewPart) {
        super(0);
        this.this$0 = feedIntegratedHeaderViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedSmallHeaderViewPart invoke() {
        FeedSmallHeaderViewPart feedSmallHeaderViewPart = new FeedSmallHeaderViewPart(this.this$0.getComponent());
        LayoutInflater from = LayoutInflater.from(FeedIntegratedHeaderViewPart.access$getFrameLayout$p(this.this$0).getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(frameLayout.context)");
        feedSmallHeaderViewPart.createView(from, FeedIntegratedHeaderViewPart.access$getFrameLayout$p(this.this$0));
        return feedSmallHeaderViewPart;
    }
}
