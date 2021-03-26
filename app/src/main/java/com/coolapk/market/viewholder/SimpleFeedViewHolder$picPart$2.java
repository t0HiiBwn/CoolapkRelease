package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemSimpleFeedBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGroupListViewHolder.kt */
final class SimpleFeedViewHolder$picPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ SimpleFeedViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleFeedViewHolder$picPart$2(SimpleFeedViewHolder simpleFeedViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = simpleFeedViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$component);
        LinearLayout linearLayout = ((ItemSimpleFeedBinding) this.this$0.getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(binding.cardView.context)");
        ninePicViewPart.createView(from, ((ItemSimpleFeedBinding) this.this$0.getBinding()).cardView);
        ninePicViewPart.setMaxShowCount(3);
        ViewUtil.replaceView(((ItemSimpleFeedBinding) this.this$0.getBinding()).spaceView, ninePicViewPart.getView());
        return ninePicViewPart;
    }
}
