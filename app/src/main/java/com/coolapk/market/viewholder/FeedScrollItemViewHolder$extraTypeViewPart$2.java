package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedScrollItemBinding;
import com.coolapk.market.util.ViewUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedScrollCardViewHolder.kt */
final class FeedScrollItemViewHolder$extraTypeViewPart$2 extends Lambda implements Function0<FeedExtraTypeViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedScrollItemViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedScrollItemViewHolder$extraTypeViewPart$2(FeedScrollItemViewHolder feedScrollItemViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedScrollItemViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedExtraTypeViewPart invoke() {
        FeedExtraTypeViewPart feedExtraTypeViewPart = new FeedExtraTypeViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        Space space = ((ItemFeedScrollItemBinding) this.this$0.getBinding()).extraTypeContainer;
        Intrinsics.checkNotNullExpressionValue(space, "binding.extraTypeContainer");
        ViewParent parent = space.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        feedExtraTypeViewPart.createView(from, (ViewGroup) parent);
        ViewUtil.replaceView(((ItemFeedScrollItemBinding) this.this$0.getBinding()).extraTypeContainer, feedExtraTypeViewPart.getView());
        return feedExtraTypeViewPart;
    }
}
