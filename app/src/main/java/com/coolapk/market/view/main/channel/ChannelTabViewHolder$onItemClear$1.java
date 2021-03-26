package com.coolapk.market.view.main.channel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/main/channel/ChannelTabViewHolder$onItemClear$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelTabViewHolder.kt */
public final class ChannelTabViewHolder$onItemClear$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ChannelTabViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ChannelTabViewHolder$onItemClear$1(ChannelTabViewHolder channelTabViewHolder) {
        this.this$0 = channelTabViewHolder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        RelativeLayout relativeLayout = this.this$0.binding.backgroundView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.backgroundView");
        relativeLayout.setBackground(null);
    }
}
