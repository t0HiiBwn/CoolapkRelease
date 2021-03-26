package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemFeedDiscoveryDetailBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DiscoveryDetailViewHolder.kt */
final class DiscoveryDetailViewHolder$imageViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ View $itemView;
    final /* synthetic */ DiscoveryDetailViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoveryDetailViewHolder$imageViewPart$2(DiscoveryDetailViewHolder discoveryDetailViewHolder, DataBindingComponent dataBindingComponent, View view) {
        super(0);
        this.this$0 = discoveryDetailViewHolder;
        this.$component = dataBindingComponent;
        this.$itemView = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$component);
        LinearLayout linearLayout = ((ItemFeedDiscoveryDetailBinding) this.this$0.getBinding()).contentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
        LayoutInflater from = LayoutInflater.from(this.$itemView.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(itemView.context)");
        ninePicViewPart.createView(from, linearLayout);
        ViewUtil.replaceView(((ItemFeedDiscoveryDetailBinding) this.this$0.getBinding()).nineImageSpaceView, ninePicViewPart.getView());
        ViewGroup.LayoutParams layoutParams = ninePicViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(4.0f);
            marginLayoutParams.bottomMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.leftMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.rightMargin = ConvertUtils.dp2px(8.0f);
        }
        ninePicViewPart.setHorizonExpandWhenTriple(true);
        ninePicViewPart.setV9LikeMode(true);
        ninePicViewPart.setCenterCropWhenOne(true);
        return ninePicViewPart;
    }
}
