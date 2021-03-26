package com.coolapk.market.viewholder;

import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedScrollItemBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedScrollCardViewHolder.kt */
final class FeedScrollItemViewHolder$headerViewPart$2 extends Lambda implements Function0<FeedIntegratedHeaderViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedScrollItemViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedScrollItemViewHolder$headerViewPart$2(FeedScrollItemViewHolder feedScrollItemViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedScrollItemViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedIntegratedHeaderViewPart invoke() {
        FeedIntegratedHeaderViewPart.Companion companion = FeedIntegratedHeaderViewPart.Companion;
        DataBindingComponent dataBindingComponent = this.$component;
        LinearLayout linearLayout = ((ItemFeedScrollItemBinding) this.this$0.getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
        FeedIntegratedHeaderViewPart newInstance = companion.newInstance(dataBindingComponent, linearLayout);
        ViewUtil.replaceView(((ItemFeedScrollItemBinding) this.this$0.getBinding()).headerContainer, newInstance.getView());
        return newInstance;
    }
}
