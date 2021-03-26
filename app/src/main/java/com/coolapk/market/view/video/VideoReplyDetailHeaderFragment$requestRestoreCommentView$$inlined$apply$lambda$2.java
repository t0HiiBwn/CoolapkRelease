package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/view/video/VideoReplyDetailHeaderFragment$requestRestoreCommentView$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoReplyDetailHeaderFragment.kt */
final class VideoReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $startTranslateY$inlined;
    final /* synthetic */ VideoReplyDetailHeaderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoReplyDetailHeaderFragment$requestRestoreCommentView$$inlined$apply$lambda$2(VideoReplyDetailHeaderFragment videoReplyDetailHeaderFragment, float f) {
        super(0);
        this.this$0 = videoReplyDetailHeaderFragment;
        this.$startTranslateY$inlined = f;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.isAnimating = false;
    }
}
