package com.coolapk.market.viewholder;

import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemDiscoveryViewBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DiscoveryViewHolder.kt */
final class DiscoveryViewHolder$headerViewPart$2 extends Lambda implements Function0<FeedIntegratedHeaderViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ DiscoveryViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoveryViewHolder$headerViewPart$2(DiscoveryViewHolder discoveryViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = discoveryViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedIntegratedHeaderViewPart invoke() {
        FeedIntegratedHeaderViewPart.Companion companion = FeedIntegratedHeaderViewPart.Companion;
        DataBindingComponent dataBindingComponent = this.$component;
        LinearLayout linearLayout = ((ItemDiscoveryViewBinding) this.this$0.getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
        FeedIntegratedHeaderViewPart newInstance = companion.newInstance(dataBindingComponent, linearLayout);
        ViewUtil.replaceView(((ItemDiscoveryViewBinding) this.this$0.getBinding()).headerSpaceView, newInstance.getView());
        return newInstance;
    }
}
