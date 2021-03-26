package com.coolapk.market.view.ad;

import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawViewHolder.kt */
final class SponsorSelfDrawViewHolder$updateContentView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NativeUnifiedADData $ad;
    final /* synthetic */ SponsorSelfDrawViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawViewHolder$updateContentView$2(SponsorSelfDrawViewHolder sponsorSelfDrawViewHolder, NativeUnifiedADData nativeUnifiedADData) {
        super(0);
        this.this$0 = sponsorSelfDrawViewHolder;
        this.$ad = nativeUnifiedADData;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        MediaView mediaView = SponsorSelfDrawViewHolder.access$getBinding$p(this.this$0).mediaView;
        Intrinsics.checkNotNullExpressionValue(mediaView, "binding.mediaView");
        EntityAdHelperKt.makeADVideoDelayAutoPlay(mediaView, this.$ad);
    }
}
