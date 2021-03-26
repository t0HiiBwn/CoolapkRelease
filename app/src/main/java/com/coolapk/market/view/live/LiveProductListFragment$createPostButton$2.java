package com.coolapk.market.view.live;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveProductListFragment.kt */
final class LiveProductListFragment$createPostButton$2 implements View.OnClickListener {
    final /* synthetic */ LiveProductListFragment this$0;

    LiveProductListFragment$createPostButton$2(LiveProductListFragment liveProductListFragment) {
        this.this$0 = liveProductListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedMultiPart.Builder multiPartForFeed = FeedArgsFactory.multiPartForFeed();
        String str = this.this$0.getProductId();
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str, "this.productId!!");
        FeedMultiPart build = FeedArgsFactoryKt.applyProduct(multiPartForFeed, str).build();
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActionManager.startSubmitFeedV8Activity(this.this$0.getActivity(), FeedArgsFactory.uiConfigForFeed(requireActivity).relativeLogo(this.this$0.getProductLogo()).relativeTitle(this.this$0.getProductName()).title("发讨论").build(), build);
    }
}
