package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.view.feedv8.VoteExtraView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$ItemViewHolder$initView$2 implements View.OnFocusChangeListener {
    final /* synthetic */ VoteExtraView.ItemViewHolder this$0;

    VoteExtraView$ItemViewHolder$initView$2(VoteExtraView.ItemViewHolder itemViewHolder) {
        this.this$0 = itemViewHolder;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z && VoteExtraView.access$getUiConfig$p(this.this$0.this$0).isMenuItemEnabled()) {
            VoteExtraView voteExtraView = this.this$0.this$0;
            FeedUIConfig build = FeedUIConfig.builder(VoteExtraView.access$getUiConfig$p(this.this$0.this$0)).isMenuItemEnabled(false).build();
            Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
            VoteExtraView.access$setUiConfig$p(voteExtraView, build);
        }
    }
}
