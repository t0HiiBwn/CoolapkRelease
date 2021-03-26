package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ServiceAppExpandedViewHolder.kt */
final class ServiceAppExpandedViewHolder$imageViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $bindingComponent;
    final /* synthetic */ View $itemView;
    final /* synthetic */ ServiceAppExpandedViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceAppExpandedViewHolder$imageViewPart$2(ServiceAppExpandedViewHolder serviceAppExpandedViewHolder, DataBindingComponent dataBindingComponent, View view) {
        super(0);
        this.this$0 = serviceAppExpandedViewHolder;
        this.$bindingComponent = dataBindingComponent;
        this.$itemView = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$bindingComponent);
        LinearLayout linearLayout = ((ServiceAppBinding) this.this$0.getBinding()).introductionLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.introductionLayout");
        LayoutInflater from = LayoutInflater.from(this.$itemView.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(itemView.context)");
        ninePicViewPart.createView(from, linearLayout);
        linearLayout.addView(ninePicViewPart.getView(), 0, new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = ninePicViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(8.0f);
            marginLayoutParams.bottomMargin = ConvertUtils.dp2px(4.0f);
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = 0;
        }
        ninePicViewPart.setHorizonExpandWhenTriple(true);
        ninePicViewPart.setFullSizeWhenOne(true);
        ninePicViewPart.setMaxShowCount(3);
        return ninePicViewPart;
    }
}
