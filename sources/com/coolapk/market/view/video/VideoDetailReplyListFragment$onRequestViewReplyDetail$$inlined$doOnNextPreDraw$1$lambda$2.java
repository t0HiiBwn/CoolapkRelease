package com.coolapk.market.view.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/view/video/VideoDetailReplyListFragment$onRequestViewReplyDetail$1$1$2", "com/coolapk/market/view/video/VideoDetailReplyListFragment$$special$$inlined$apply$lambda$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoDetailReplyListFragment.kt */
final class VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1$lambda$2(VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1 videoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1) {
        super(0);
        this.this$0 = videoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.$fragment$inlined.setUserVisibleHint(true);
        this.this$0.$fragment$inlined.initData();
    }
}
