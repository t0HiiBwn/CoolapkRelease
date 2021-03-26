package com.coolapk.market.view.node.topic;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.databinding.TopicNodeHeaderBinding;
import com.coolapk.market.view.node.util.NodeExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "startColor", "", "endColor", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicNodeHeaderViewPart.kt */
final class TopicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ Function2 $callback;
    final /* synthetic */ boolean $hasCover;
    final /* synthetic */ TopicNodeHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1(TopicNodeHeaderViewPart topicNodeHeaderViewPart, boolean z, Function2 function2) {
        super(2);
        this.this$0 = topicNodeHeaderViewPart;
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
            Space space = ((TopicNodeHeaderBinding) this.this$0.getBinding()).backgroundPlaceholderView;
            Intrinsics.checkNotNullExpressionValue(space, "binding.backgroundPlaceholderView");
            space.setVisibility(0);
            ViewPager viewPager = ((TopicNodeHeaderBinding) this.this$0.getBinding()).imageViewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.imageViewPager");
            viewPager.setBackground(new ColorDrawable(i));
            View view = ((TopicNodeHeaderBinding) this.this$0.getBinding()).maskView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.maskView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{0, i});
            Unit unit = Unit.INSTANCE;
            view.setBackground(gradientDrawable);
            View view2 = ((TopicNodeHeaderBinding) this.this$0.getBinding()).maskView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.maskView");
            NodeExtendsKt.nodeCoverDarkForegroundIfNeed(view2);
        }
        LinearLayout linearLayout = ((TopicNodeHeaderBinding) this.this$0.getBinding()).backgroundContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.backgroundContainer");
        NodeExtendsKt.nodeDarkForegroundIfNeed(linearLayout);
        this.$callback.invoke(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
