package com.coolapk.market.view.ad;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
final class SponsorSelfDrawNewsViewHolder$selfDrawForGDT$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NativeUnifiedADData $ad;
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawNewsViewHolder$selfDrawForGDT$1(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder, NativeUnifiedADData nativeUnifiedADData) {
        super(0);
        this.this$0 = sponsorSelfDrawNewsViewHolder;
        this.$ad = nativeUnifiedADData;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        RelativeLayout relativeLayout = SponsorSelfDrawNewsViewHolder.access$getBinding$p(this.this$0).itemView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.itemView");
        this.$ad.bindAdToView(this.this$0.getContext(), SponsorSelfDrawNewsViewHolder.access$getBinding$p(this.this$0).nativeAdContainer, new FrameLayout.LayoutParams(0, 0), CollectionsKt.mutableListOf(relativeLayout));
        this.$ad.setNativeAdEventListener(EntityAdHelperKt.getSIMPLE_NATIVE_AD_LISTENER());
    }
}
