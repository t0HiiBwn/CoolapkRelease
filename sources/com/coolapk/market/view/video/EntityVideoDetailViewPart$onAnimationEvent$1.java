package com.coolapk.market.view.video;

import android.transition.TransitionManager;
import com.coolapk.market.databinding.ItemEntityVideoDetailViewPartBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityVideoDetailViewPart.kt */
final class EntityVideoDetailViewPart$onAnimationEvent$1 implements Runnable {
    final /* synthetic */ EntityVideoDetailViewPart this$0;

    EntityVideoDetailViewPart$onAnimationEvent$1(EntityVideoDetailViewPart entityVideoDetailViewPart) {
        this.this$0 = entityVideoDetailViewPart;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.isAvailable$presentation_coolapkAppRelease()) {
            BaseControlCover.setControllerState$default(EntityVideoDetailViewPart.access$getDetailControlCover$p(this.this$0), true, null, 2, null);
            TransitionManager.beginDelayedTransition(((ItemEntityVideoDetailViewPartBinding) this.this$0.getBinding()).coolapkCardView);
            CoolapkCardView coolapkCardView = ((ItemEntityVideoDetailViewPartBinding) this.this$0.getBinding()).coolapkCardView;
            Intrinsics.checkNotNullExpressionValue(coolapkCardView, "binding.coolapkCardView");
            coolapkCardView.setVisibility(0);
        }
    }
}
