package com.coolapk.market.viewholder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import com.coolapk.market.databinding.ItemVideoViewPartBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import com.coolapk.market.widget.view.DividerLineView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/coolapk/market/viewholder/ImageAppViewHolder$videoViewHotPlug$2$1", "invoke", "()Lcom/coolapk/market/viewholder/ImageAppViewHolder$videoViewHotPlug$2$1;"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageAppViewHolder.kt */
final class ImageAppViewHolder$videoViewHotPlug$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ ImageAppViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageAppViewHolder$videoViewHotPlug$2(ImageAppViewHolder imageAppViewHolder) {
        super(0);
        this.this$0 = imageAppViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        Space space = this.this$0.binding.videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.videoPlayerSpaceView");
        return new BaseVideoHotPlug(this, space, this.this$0.getComponent()) {
            /* class com.coolapk.market.viewholder.ImageAppViewHolder$videoViewHotPlug$2.AnonymousClass1 */
            final /* synthetic */ ImageAppViewHolder$videoViewHotPlug$2 this$0;

            {
                this.this$0 = r8;
            }

            /* access modifiers changed from: protected */
            @Override // com.coolapk.market.widget.hotplug.BaseVideoHotPlug
            public void onViewPartLoad(VideoViewPart videoViewPart) {
                Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
                super.onViewPartLoad(videoViewPart);
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(videoViewPart.getView());
                if (marginParams != null) {
                    marginParams.topMargin = 0;
                    marginParams.leftMargin = 0;
                    marginParams.rightMargin = 0;
                    marginParams.bottomMargin = 0;
                }
                ItemVideoViewPartBinding itemVideoViewPartBinding = (ItemVideoViewPartBinding) videoViewPart.getBinding();
                itemVideoViewPartBinding.executePendingBindings();
                DividerLineView dividerLineView = itemVideoViewPartBinding.dividerView;
                Intrinsics.checkNotNullExpressionValue(dividerLineView, "dividerView");
                dividerLineView.setVisibility(8);
                FrameLayout frameLayout = itemVideoViewPartBinding.videoPlayer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "videoPlayer");
                frameLayout.setClipToOutline(false);
                FrameLayout frameLayout2 = itemVideoViewPartBinding.videoCoverContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "videoCoverContainer");
                frameLayout2.setClipToOutline(false);
            }

            /* access modifiers changed from: protected */
            @Override // com.coolapk.market.widget.hotplug.BaseVideoHotPlug
            public void recycleViewPart(VideoViewPart videoViewPart) {
                Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
                super.recycleViewPart(videoViewPart);
                ItemVideoViewPartBinding itemVideoViewPartBinding = (ItemVideoViewPartBinding) videoViewPart.getBinding();
                DividerLineView dividerLineView = itemVideoViewPartBinding.dividerView;
                Intrinsics.checkNotNullExpressionValue(dividerLineView, "dividerView");
                dividerLineView.setVisibility(0);
                FrameLayout frameLayout = itemVideoViewPartBinding.videoPlayer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "videoPlayer");
                frameLayout.setClipToOutline(true);
                FrameLayout frameLayout2 = itemVideoViewPartBinding.videoCoverContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "videoCoverContainer");
                frameLayout2.setClipToOutline(true);
            }
        };
    }
}
