package com.coolapk.market.view.center;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/center/CardTitleViewHolder$onItemClear$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardTitleViewHolder.kt */
public final class CardTitleViewHolder$onItemClear$1 extends AnimatorListenerAdapter {
    final /* synthetic */ CardTitleViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CardTitleViewHolder$onItemClear$1(CardTitleViewHolder cardTitleViewHolder) {
        this.this$0 = cardTitleViewHolder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        LinearLayout linearLayout = CardTitleViewHolder.access$getBinding$p(this.this$0).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        linearLayout.setBackground(null);
    }
}
