package com.coolapk.market.viewholder;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/viewholder/VideoViewHolder$setupFixTop$1", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper$SimpleCallback;", "onDetachFromTop", "", "view", "Landroid/view/View;", "shouldViewBeTop", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isTop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoViewHolder.kt */
public final class VideoViewHolder$setupFixTop$1 extends EntityListFixTopHelper.SimpleCallback {
    final /* synthetic */ VideoViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoViewHolder$setupFixTop$1(VideoViewHolder videoViewHolder, EntityListFixTopHelper entityListFixTopHelper, ViewGroup viewGroup, Parcelable parcelable) {
        super(entityListFixTopHelper, viewGroup, parcelable);
        this.this$0 = videoViewHolder;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFixTopHelper.SimpleCallback, com.coolapk.market.view.cardlist.EntityListFixTopHelper.Callback
    public boolean shouldViewBeTop(RecyclerView recyclerView, boolean z) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        boolean shouldViewBeTop = super.shouldViewBeTop(recyclerView, z);
        if (shouldViewBeTop && !z) {
            this.this$0.setIsRecyclable(false);
            FrameLayout frameLayout = this.this$0.binding.holderView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.holderView");
            FrameLayout frameLayout2 = this.this$0.binding.videoContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.videoContainer");
            frameLayout.setMinimumHeight(frameLayout2.getHeight());
            VideoViewPart videoViewPart = (VideoViewPart) this.this$0.videoViewHotPlug.optViewPart();
            if (videoViewPart != null) {
                videoViewPart.setWillFixTop(true);
            }
            this.this$0.getVideoHelper().setTempDetachAutoPlay(true);
        }
        return shouldViewBeTop;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFixTopHelper.SimpleCallback, com.coolapk.market.view.cardlist.EntityListFixTopHelper.Callback
    public void onDetachFromTop(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDetachFromTop(view);
        this.this$0.setIsRecyclable(true);
        FrameLayout frameLayout = this.this$0.binding.holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.holderView");
        frameLayout.setMinimumHeight(0);
        VideoViewPart videoViewPart = (VideoViewPart) this.this$0.videoViewHotPlug.optViewPart();
        if (videoViewPart != null) {
            videoViewPart.setWillFixTop(false);
        }
        this.this$0.getVideoHelper().setTempDetachAutoPlay(false);
    }
}
