package com.coolapk.market.view.ad;

import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.coolapk.market.extend.EntityExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/ad/SponsorSelfDrawNewsViewHolder$updateContentView$7", "Lcom/bytedance/sdk/openadsdk/TTAdDislike$DislikeInteractionCallback;", "onCancel", "", "onRefuse", "onSelected", "position", "", "value", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
public final class SponsorSelfDrawNewsViewHolder$updateContentView$7 implements TTAdDislike.DislikeInteractionCallback {
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SponsorSelfDrawNewsViewHolder$updateContentView$7(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder) {
        this.this$0 = sponsorSelfDrawNewsViewHolder;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.this$0.entityAdHelper.requestCloseAd(EntityExtendsKt.entityUniqueId(SponsorSelfDrawNewsViewHolder.access$getData$p(this.this$0)), this.this$0.getAdapterPosition());
    }
}