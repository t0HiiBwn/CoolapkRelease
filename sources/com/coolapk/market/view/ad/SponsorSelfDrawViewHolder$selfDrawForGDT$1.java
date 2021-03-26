package com.coolapk.market.view.ad;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.ItemRelativeChildBinding;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawViewHolder.kt */
final class SponsorSelfDrawViewHolder$selfDrawForGDT$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NativeUnifiedADData $ad;
    final /* synthetic */ SponsorSelfDrawViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawViewHolder$selfDrawForGDT$1(SponsorSelfDrawViewHolder sponsorSelfDrawViewHolder, NativeUnifiedADData nativeUnifiedADData) {
        super(0);
        this.this$0 = sponsorSelfDrawViewHolder;
        this.$ad = nativeUnifiedADData;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        LinearLayout linearLayout = SponsorSelfDrawViewHolder.access$getBinding$p(this.this$0).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        ItemRelativeChildBinding itemRelativeChildBinding = SponsorSelfDrawViewHolder.access$getBinding$p(this.this$0).relativeView;
        Intrinsics.checkNotNullExpressionValue(itemRelativeChildBinding, "binding.relativeView");
        View root = itemRelativeChildBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.relativeView.root");
        this.$ad.bindAdToView(this.this$0.getContext(), SponsorSelfDrawViewHolder.access$getBinding$p(this.this$0).nativeAdContainer, new FrameLayout.LayoutParams(0, 0), CollectionsKt.mutableListOf(linearLayout, root), null);
        this.$ad.setNativeAdEventListener(EntityAdHelperKt.getSIMPLE_NATIVE_AD_LISTENER());
    }
}
