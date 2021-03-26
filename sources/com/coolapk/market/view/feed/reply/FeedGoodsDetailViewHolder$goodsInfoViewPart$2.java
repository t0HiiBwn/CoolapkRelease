package com.coolapk.market.view.feed.reply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedGoodsDetailBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsDetailViewHolder.kt */
final class FeedGoodsDetailViewHolder$goodsInfoViewPart$2 extends Lambda implements Function0<FeedGoodsInfoViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedGoodsDetailViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedGoodsDetailViewHolder$goodsInfoViewPart$2(FeedGoodsDetailViewHolder feedGoodsDetailViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedGoodsDetailViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedGoodsInfoViewPart invoke() {
        FeedGoodsInfoViewPart feedGoodsInfoViewPart = new FeedGoodsInfoViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(((ItemFeedGoodsDetailBinding) this.this$0.getBinding()).goodsSpaceView, feedGoodsInfoViewPart.createView(from, ((ItemFeedGoodsDetailBinding) this.this$0.getBinding()).cardView));
        View view = feedGoodsInfoViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 12);
        marginLayoutParams2.leftMargin = NumberExtendsKt.getDp((Number) 16);
        marginLayoutParams2.rightMargin = NumberExtendsKt.getDp((Number) 16);
        view.setLayoutParams(marginLayoutParams);
        return feedGoodsInfoViewPart;
    }
}
