package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.ItemCoolpicDetailBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailViewHolder$viewIn$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder$viewIn$1 extends AnimatorListenerAdapter {
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicDetailViewHolder$viewIn$1(CoolPicDetailViewHolder coolPicDetailViewHolder) {
        this.this$0 = coolPicDetailViewHolder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        LinearLayout linearLayout = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionContainer");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).textContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.textContainer");
        linearLayout2.setVisibility(0);
        CoolPicDetailViewHolder coolPicDetailViewHolder = this.this$0;
        View view = ((ItemCoolpicDetailBinding) coolPicDetailViewHolder.getBinding()).topShadeCover;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topShadeCover");
        CoolPicDetailViewHolder.alphaView$default(coolPicDetailViewHolder, view, false, 0, 0, 8, null);
        CoolPicDetailViewHolder coolPicDetailViewHolder2 = this.this$0;
        View view2 = ((ItemCoolpicDetailBinding) coolPicDetailViewHolder2.getBinding()).bottomShadeCover;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.bottomShadeCover");
        CoolPicDetailViewHolder.alphaView$default(coolPicDetailViewHolder2, view2, false, 0, 0, 8, null);
    }
}
