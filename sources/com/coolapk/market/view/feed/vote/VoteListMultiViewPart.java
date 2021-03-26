package com.coolapk.market.view.feed.vote;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVoteMultiBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteListMultiViewPart;", "Lcom/coolapk/market/view/feed/vote/VoteMultiViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "bindToDisplay", "", "option", "Lcom/coolapk/market/model/VoteOption;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
public final class VoteListMultiViewPart extends VoteMultiViewPart {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteListMultiViewPart(DataBindingComponent dataBindingComponent) {
        super(dataBindingComponent);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public final void bindToDisplay(VoteOption voteOption) {
        Intrinsics.checkNotNullParameter(voteOption, "option");
        ((ItemFeedVoteMultiBinding) getBinding()).executePendingBindings();
        int dp = NumberExtendsKt.getDp((Number) 1);
        int adjustAlpha = ColorUtils.adjustAlpha(ResourceUtils.getColorInt(getContext(), 2131099898), 0.2f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(dp, adjustAlpha);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 3));
        gradientDrawable.setShape(0);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()), gradientDrawable});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 1), NumberExtendsKt.getDp((Number) 1), NumberExtendsKt.getDp((Number) 1), NumberExtendsKt.getDp((Number) 1));
        LinearLayout linearLayout = ((ItemFeedVoteMultiBinding) getBinding()).rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.rootView");
        linearLayout.setBackground(layerDrawable);
        TextView textView = ((ItemFeedVoteMultiBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(voteOption.getTitle());
        TextView textView2 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.totalVoteNumView");
        textView2.setVisibility(8);
        TextView textView3 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.percentView");
        textView3.setVisibility(8);
        ((ItemFeedVoteMultiBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        ImageView imageView = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.checkView");
        imageView.setVisibility(8);
        ImageView imageView2 = ((ItemFeedVoteMultiBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.checkBox");
        imageView2.setVisibility(8);
        checkLayoutStyle();
    }
}
