package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoDetailListActivity.kt */
final class VideoDetailListActivity$startCloseAnimation$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VideoDetailListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoDetailListActivity$startCloseAnimation$2(VideoDetailListActivity videoDetailListActivity) {
        super(0);
        this.this$0 = videoDetailListActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        VideoDetailListActivity.access$getDetailViewPart$p(this.this$0).onAnimationEvent(false, false);
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
        this.this$0.isAnimating = false;
    }
}
