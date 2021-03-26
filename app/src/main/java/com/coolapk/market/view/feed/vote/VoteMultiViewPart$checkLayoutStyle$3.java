package com.coolapk.market.view.feed.vote;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemFeedVoteMultiBinding;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
final class VoteMultiViewPart$checkLayoutStyle$3 implements Runnable {
    final /* synthetic */ VoteMultiViewPart this$0;

    VoteMultiViewPart$checkLayoutStyle$3(VoteMultiViewPart voteMultiViewPart) {
        this.this$0 = voteMultiViewPart;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Space space = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).spaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.spaceView");
        if (space.getWidth() <= 0) {
            Space space2 = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).spaceView;
            Intrinsics.checkNotNullExpressionValue(space2, "binding.spaceView");
            Space space3 = space2;
            ViewGroup.LayoutParams layoutParams = space3.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.weight = 0.0f;
            space3.setLayoutParams(layoutParams2);
            TextView textView = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            TextView textView2 = textView;
            ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            LinearLayout.LayoutParams layoutParams5 = layoutParams4;
            layoutParams5.width = 0;
            layoutParams5.weight = 1.0f;
            textView2.setLayoutParams(layoutParams4);
        }
    }
}
