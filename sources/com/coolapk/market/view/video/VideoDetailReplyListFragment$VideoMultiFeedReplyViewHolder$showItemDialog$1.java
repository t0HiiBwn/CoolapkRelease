package com.coolapk.market.view.video;

import android.app.Activity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.view.feed.dialog.SheetFactoryOptions;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupListFactory;
import com.coolapk.market.view.video.VideoDetailReplyListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/view/video/VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$showItemDialog$1", "Lcom/coolapk/market/view/feed/dialog/SheetGroupListFactory;", "Lcom/coolapk/market/model/FeedReply;", "createSheetGroupListFor", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "data", "activity", "Landroid/app/Activity;", "options", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoDetailReplyListFragment.kt */
public final class VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$showItemDialog$1 implements SheetGroupListFactory<FeedReply> {
    final /* synthetic */ VideoDetailReplyListFragment.VideoMultiFeedReplyViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$showItemDialog$1(VideoDetailReplyListFragment.VideoMultiFeedReplyViewHolder videoMultiFeedReplyViewHolder) {
        this.this$0 = videoMultiFeedReplyViewHolder;
    }

    public List<SheetGroup> createSheetGroupListFor(FeedReply feedReply, Activity activity, SheetFactoryOptions sheetFactoryOptions) {
        Intrinsics.checkNotNullParameter(feedReply, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetFactoryOptions, "options");
        return this.this$0.createSheetGroupListOuter(feedReply, activity, sheetFactoryOptions);
    }
}
