package com.coolapk.market.view.feedv8;

import android.transition.TransitionManager;
import android.widget.LinearLayout;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "call", "com/coolapk/market/view/feedv8/NormalFeedContentHolder$onCreateContentView$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
final class NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$1 implements Action0 {
    final /* synthetic */ NormalFeedContentHolder this$0;

    NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$1(NormalFeedContentHolder normalFeedContentHolder) {
        this.this$0 = normalFeedContentHolder;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.requestCheckSubmittable$presentation_coolapkAppRelease();
        if (this.this$0.getUiConfig().isPickPhotoItemVisible()) {
            if (!this.this$0.getUiConfig().isPickPhotoContainerVisible()) {
                List<ImageUrl> imageUrls = this.this$0.getAdapter$presentation_coolapkAppRelease().getImageUrls();
                Intrinsics.checkNotNullExpressionValue(imageUrls, "adapter.imageUrls");
                if (!imageUrls.isEmpty()) {
                    NormalFeedContentHolder normalFeedContentHolder = this.this$0;
                    FeedUIConfig build = normalFeedContentHolder.getUiConfig().newBuilder().isPickPhotoContainerVisible(true).build();
                    Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder().is…inerVisible(true).build()");
                    normalFeedContentHolder.updateUiConfig$presentation_coolapkAppRelease(build);
                    this.this$0.notifyUIChange$presentation_coolapkAppRelease();
                }
            }
            TransitionManager.beginDelayedTransition(this.this$0.getBinding$presentation_coolapkAppRelease().warningView);
            if (this.this$0.getAdapter$presentation_coolapkAppRelease().getImageUrls().isEmpty()) {
                LinearLayout linearLayout = this.this$0.getBinding$presentation_coolapkAppRelease().warningView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.warningView");
                linearLayout.setVisibility(0);
                return;
            }
            LinearLayout linearLayout2 = this.this$0.getBinding$presentation_coolapkAppRelease().warningView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.warningView");
            linearLayout2.setVisibility(8);
        }
    }
}
