package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.ItemCoolpicDetailBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailViewHolder$viewOut$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder$viewOut$1 extends AnimatorListenerAdapter {
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicDetailViewHolder$viewOut$1(CoolPicDetailViewHolder coolPicDetailViewHolder) {
        this.this$0 = coolPicDetailViewHolder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionContainer");
        linearLayout.setVisibility(4);
        LinearLayout linearLayout2 = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).textContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.textContainer");
        linearLayout2.setVisibility(4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).sizeViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sizeViewContainer");
        linearLayout.setVisibility(0);
        CoolPicDetailViewHolder coolPicDetailViewHolder = this.this$0;
        View view = ((ItemCoolpicDetailBinding) coolPicDetailViewHolder.getBinding()).topShadeCover;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topShadeCover");
        CoolPicDetailViewHolder.alphaView$default(coolPicDetailViewHolder, view, true, 0, 0, 12, null);
        CoolPicDetailViewHolder coolPicDetailViewHolder2 = this.this$0;
        View view2 = ((ItemCoolpicDetailBinding) coolPicDetailViewHolder2.getBinding()).bottomShadeCover;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.bottomShadeCover");
        CoolPicDetailViewHolder.alphaView$default(coolPicDetailViewHolder2, view2, true, 0, 0, 12, null);
    }
}
