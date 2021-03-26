package com.coolapk.market.view.video;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.DropDownCallback;
import com.coolapk.market.view.video.VideoDetailReplyListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/video/VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1", "Lcom/coolapk/market/util/DropDownCallback;", "onDropDownEnd", "", "offset", "", "onDropDownOffset", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoDetailReplyListFragment.kt */
public final class VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1 implements DropDownCallback {
    final /* synthetic */ VideoDetailReplyListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1(VideoDetailReplyListFragment videoDetailReplyListFragment) {
        this.this$0 = videoDetailReplyListFragment;
    }

    @Override // com.coolapk.market.util.DropDownCallback
    public void onDropDownEnd(int i) {
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        if (i >= (recyclerView.getHeight() * 2) / 5) {
            VideoDetailReplyListFragment.Callback callback = this.this$0.getCallback();
            if (callback != null) {
                callback.requestExitCommentView();
                return;
            }
            return;
        }
        VideoDetailReplyListFragment.Callback callback2 = this.this$0.getCallback();
        if (callback2 != null) {
            callback2.requestRestoreCommentView();
        }
    }

    @Override // com.coolapk.market.util.DropDownCallback
    public void onDropDownOffset(int i) {
        VideoDetailReplyListFragment.Callback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.setDropOffset(i);
        }
    }
}
