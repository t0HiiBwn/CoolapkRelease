package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyViewHolder.kt */
final class FeedReplyViewHolder$ninePicViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedReplyViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyViewHolder$ninePicViewPart$2(FeedReplyViewHolder feedReplyViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedReplyViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ninePicViewPart.createView(from, ((ItemFeedReplyBinding) this.this$0.getBinding()).extraPartContainer);
        ((ItemFeedReplyBinding) this.this$0.getBinding()).extraPartContainer.addView(ninePicViewPart.getView());
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(ninePicViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(8.0f);
            marginParams.leftMargin = 0;
            marginParams.rightMargin = 0;
        }
        return ninePicViewPart;
    }
}
