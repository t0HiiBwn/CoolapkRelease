package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedCoverViewBinding;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedArticleViewHolder.kt */
final class FeedArticleViewHolder$ninePicViewPart$2 extends Lambda implements Function0<NinePicViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedArticleViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedArticleViewHolder$ninePicViewPart$2(FeedArticleViewHolder feedArticleViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedArticleViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final NinePicViewPart invoke() {
        NinePicViewPart ninePicViewPart = new NinePicViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        Space space = ((ItemFeedCoverViewBinding) this.this$0.getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.nineImageSpaceView");
        ViewParent parent = space.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ninePicViewPart.createView(from, (ViewGroup) parent);
        ViewUtil.replaceView(((ItemFeedCoverViewBinding) this.this$0.getBinding()).nineImageSpaceView, ninePicViewPart.getView());
        ViewGroup.LayoutParams layoutParams = ninePicViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = DisplayUtils.dp2px(this.this$0.getContext(), 6.0f);
            layoutParams2.bottomMargin = DisplayUtils.dp2px(this.this$0.getContext(), 6.0f);
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.addRule(3, 2131363582);
        }
        View view = ninePicViewPart.getView();
        Space space2 = ((ItemFeedCoverViewBinding) this.this$0.getBinding()).nineImageSpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.nineImageSpaceView");
        view.setId(space2.getId());
        ninePicViewPart.setMaxShowCount(3);
        ninePicViewPart.setImageViewClickable(false);
        return ninePicViewPart;
    }
}
