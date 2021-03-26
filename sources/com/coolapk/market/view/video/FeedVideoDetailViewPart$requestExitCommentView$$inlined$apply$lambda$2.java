package com.coolapk.market.view.video;

import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/view/video/FeedVideoDetailViewPart$requestExitCommentView$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVideoDetailViewPart.kt */
final class FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $fractionMinus$inlined;
    final /* synthetic */ FeedVideoDetailViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$2(FeedVideoDetailViewPart feedVideoDetailViewPart, float f) {
        super(0);
        this.this$0 = feedVideoDetailViewPart;
        this.$fractionMinus$inlined = f;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((ItemFeedVideoDetailViewPartBinding) this.this$0.getBinding()).commentContainer.post(new Runnable(this) {
            /* class com.coolapk.market.view.video.FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$2.AnonymousClass1 */
            final /* synthetic */ FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoDetailViewPart.access$setExitingCommentView$p(this.this$0.this$0, false);
                FeedVideoDetailViewPart.access$exitCommentView(this.this$0.this$0);
            }
        });
    }
}
