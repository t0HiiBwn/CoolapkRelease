package com.coolapk.market.view.goodsList;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.coolapk.market.databinding.ItemGoodGoodsListHeaderBinding;
import com.coolapk.market.view.node.util.NodeExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "startColor", "", "endColor", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsListHeaderViewHolder.kt */
final class GoodGoodsListHeaderViewHolder$loadBG$wrapCallback$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ Function2 $callback;
    final /* synthetic */ boolean $hasCover;
    final /* synthetic */ GoodGoodsListHeaderViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodGoodsListHeaderViewHolder$loadBG$wrapCallback$1(GoodGoodsListHeaderViewHolder goodGoodsListHeaderViewHolder, boolean z, Function2 function2) {
        super(2);
        this.this$0 = goodGoodsListHeaderViewHolder;
        this.$hasCover = z;
        this.$callback = function2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        if (this.$hasCover) {
            View view = ((ItemGoodGoodsListHeaderBinding) this.this$0.getBinding()).backgroundPlaceholderView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundPlaceholderView");
            view.setVisibility(0);
            View view2 = ((ItemGoodGoodsListHeaderBinding) this.this$0.getBinding()).maskView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.maskView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{0, i});
            Unit unit = Unit.INSTANCE;
            view2.setBackground(gradientDrawable);
            View view3 = ((ItemGoodGoodsListHeaderBinding) this.this$0.getBinding()).maskView;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.maskView");
            NodeExtendsKt.nodeCoverDarkForegroundIfNeed(view3);
        }
        LinearLayout linearLayout = ((ItemGoodGoodsListHeaderBinding) this.this$0.getBinding()).backgroundContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.backgroundContainer");
        NodeExtendsKt.nodeDarkForegroundIfNeed(linearLayout);
        this.$callback.invoke(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
