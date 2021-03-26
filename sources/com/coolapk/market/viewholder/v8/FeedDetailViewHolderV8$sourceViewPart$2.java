package com.coolapk.market.viewholder.v8;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedDetailViewV8Binding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.FeedIntegratedSourceViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedSourceViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailViewHolderV8.kt */
final class FeedDetailViewHolderV8$sourceViewPart$2 extends Lambda implements Function0<FeedIntegratedSourceViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedDetailViewHolderV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailViewHolderV8$sourceViewPart$2(FeedDetailViewHolderV8 feedDetailViewHolderV8, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedDetailViewHolderV8;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedIntegratedSourceViewPart invoke() {
        FeedIntegratedSourceViewPart.Companion companion = FeedIntegratedSourceViewPart.Companion;
        DataBindingComponent dataBindingComponent = this.$component;
        FrameLayout frameLayout = ((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardView");
        FeedIntegratedSourceViewPart newInstance = companion.newInstance(dataBindingComponent, frameLayout);
        ViewUtil.replaceView(((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).sourceSpaceView, newInstance.getView());
        ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams.leftMargin = NumberExtendsKt.getDp((Number) 16);
            marginLayoutParams.rightMargin = NumberExtendsKt.getDp((Number) 16);
            marginLayoutParams.bottomMargin = 0;
        }
        return newInstance;
    }
}
