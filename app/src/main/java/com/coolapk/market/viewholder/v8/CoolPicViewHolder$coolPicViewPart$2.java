package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedCoolPicLayoutBinding;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.CoolPicViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicViewHolder.kt */
final class CoolPicViewHolder$coolPicViewPart$2 extends Lambda implements Function0<CoolPicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ CoolPicViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoolPicViewHolder$coolPicViewPart$2(CoolPicViewHolder coolPicViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = coolPicViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final CoolPicViewPart invoke() {
        DataBindingComponent dataBindingComponent = this.$component;
        Objects.requireNonNull(dataBindingComponent, "null cannot be cast to non-null type com.coolapk.market.binding.FragmentBindingComponent");
        CoolPicViewPart coolPicViewPart = new CoolPicViewPart((FragmentBindingComponent) dataBindingComponent);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        coolPicViewPart.createView(from, ((ItemFeedCoolPicLayoutBinding) this.this$0.getBinding()).cardView);
        ViewUtil.replaceView(((ItemFeedCoolPicLayoutBinding) this.this$0.getBinding()).coolPicSpaceView, coolPicViewPart.getView());
        View view = coolPicViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        marginLayoutParams2.leftMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
        marginLayoutParams2.rightMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
        view.setLayoutParams(marginLayoutParams);
        return coolPicViewPart;
    }
}
