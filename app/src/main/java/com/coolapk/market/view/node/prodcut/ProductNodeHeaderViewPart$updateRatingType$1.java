package com.coolapk.market.view.node.prodcut;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getRatePercent", "", "rateNum", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductNodeHeaderViewPart.kt */
final class ProductNodeHeaderViewPart$updateRatingType$1 extends Lambda implements Function1<Integer, Float> {
    final /* synthetic */ int $voteNumMax;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductNodeHeaderViewPart$updateRatingType$1(int i) {
        super(1);
        this.$voteNumMax = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(Integer num) {
        return Float.valueOf(invoke(num.intValue()));
    }

    public final float invoke(int i) {
        return Math.max(0.01f, (((float) i) * 1.0f) / ((float) this.$voteNumMax));
    }
}
