package com.coolapk.market.view.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
final class SponsorSelfDrawNewsViewHolder$updateContentView$runnable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TTFeedAd $ad;
    final /* synthetic */ View $video;
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawNewsViewHolder$updateContentView$runnable$1(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder, View view, TTFeedAd tTFeedAd) {
        super(0);
        this.this$0 = sponsorSelfDrawNewsViewHolder;
        this.$video = view;
        this.$ad = tTFeedAd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        View view = this.$video;
        if (view != null && view.getParent() == null && this.this$0.lastAd == this.$ad) {
            this.this$0.binding.ttMediaView.removeAllViews();
            this.this$0.binding.ttMediaView.addView(this.$video, -1, -1);
        }
    }
}
