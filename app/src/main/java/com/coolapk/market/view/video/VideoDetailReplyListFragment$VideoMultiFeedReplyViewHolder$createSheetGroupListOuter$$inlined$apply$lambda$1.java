package com.coolapk.market.view.video;

import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.video.VideoDetailReplyListFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "sheetGroup", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "index", "", "invoke", "com/coolapk/market/view/video/VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoDetailReplyListFragment.kt */
final class VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$$inlined$apply$lambda$1 extends Lambda implements Function2<SheetGroup, Integer, Unit> {
    final /* synthetic */ VideoDetailReplyListFragment.VideoMultiFeedReplyViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$$inlined$apply$lambda$1(VideoDetailReplyListFragment.VideoMultiFeedReplyViewHolder videoMultiFeedReplyViewHolder) {
        super(2);
        this.this$0 = videoMultiFeedReplyViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SheetGroup sheetGroup, Integer num) {
        invoke(sheetGroup, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SheetGroup sheetGroup, int i) {
        Intrinsics.checkNotNullParameter(sheetGroup, "sheetGroup");
        sheetGroup.getItems().set(i, SheetDataItem.copy$default(sheetGroup.getItems().get(i), null, null, null, new SheetCallback(this) {
            /* class com.coolapk.market.view.video.VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.view.feed.dialog.SheetCallback
            public SheetResult onSheetClick(SheetAction sheetAction) {
                Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
                this.this$0.this$0.this$0.onRequestViewReplyDetail(this.this$0.this$0.getFeedReply());
                return SheetResult.Companion.getClose();
            }
        }, null, 0, false, false, 247, null));
    }
}
