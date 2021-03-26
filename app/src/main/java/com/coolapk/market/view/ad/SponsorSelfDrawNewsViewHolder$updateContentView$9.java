package com.coolapk.market.view.ad;

import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
final class SponsorSelfDrawNewsViewHolder$updateContentView$9 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TTFeedAd $ad;
    final /* synthetic */ List $imageViews;
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawNewsViewHolder$updateContentView$9(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder, TTFeedAd tTFeedAd, List list) {
        super(0);
        this.this$0 = sponsorSelfDrawNewsViewHolder;
        this.$ad = tTFeedAd;
        this.$imageViews = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        RelativeLayout relativeLayout = this.this$0.binding.itemView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.itemView");
        this.$ad.registerViewForInteraction(this.this$0.binding.itemView, this.$imageViews, CollectionsKt.mutableListOf(relativeLayout), null, this.this$0.binding.closeView, EntityAdHelperKt.getSIMPLE_TT_NATIVE_AD_LISTENER());
    }
}
