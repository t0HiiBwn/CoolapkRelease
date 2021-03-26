package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedDetailViewV8Binding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailViewHolderV8.kt */
final class FeedDetailViewHolderV8$nineImageViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedDetailViewHolderV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailViewHolderV8$nineImageViewPart$2(FeedDetailViewHolderV8 feedDetailViewHolderV8, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedDetailViewHolderV8;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ninePicViewPart.createView(from, ((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).cardView);
        ViewUtil.replaceView(((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).nineImageSpaceView, ninePicViewPart.getView());
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(ninePicViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = NumberExtendsKt.getDp((Number) 12);
            marginParams.leftMargin = NumberExtendsKt.getDp((Number) 16);
            marginParams.rightMargin = NumberExtendsKt.getDp((Number) 16);
            marginParams.bottomMargin = 0;
        }
        ninePicViewPart.setMaxShowCount(9);
        ninePicViewPart.setFullSizeWhenOne(true);
        ninePicViewPart.setV9LikeMode(true);
        return ninePicViewPart;
    }
}
