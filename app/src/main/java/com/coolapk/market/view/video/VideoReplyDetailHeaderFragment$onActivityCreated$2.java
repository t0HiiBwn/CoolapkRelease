package com.coolapk.market.view.video;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.view.video.VideoReplyDetailHeaderFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoReplyDetailHeaderFragment.kt */
final class VideoReplyDetailHeaderFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ VideoReplyDetailHeaderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoReplyDetailHeaderFragment$onActivityCreated$2(VideoReplyDetailHeaderFragment videoReplyDetailHeaderFragment) {
        super(1);
        this.this$0 = videoReplyDetailHeaderFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        VideoReplyDetailHeaderFragment videoReplyDetailHeaderFragment = this.this$0;
        FragmentBindingComponent fragmentBindingComponent = videoReplyDetailHeaderFragment.getBindingComponent();
        String firstReplyId$presentation_coolapkAppRelease = this.this$0.getFirstReplyId$presentation_coolapkAppRelease();
        if (firstReplyId$presentation_coolapkAppRelease == null) {
            firstReplyId$presentation_coolapkAppRelease = "";
        }
        return new VideoReplyDetailHeaderFragment.VideoFeedReplyViewHolder(videoReplyDetailHeaderFragment, view, fragmentBindingComponent, firstReplyId$presentation_coolapkAppRelease);
    }
}
