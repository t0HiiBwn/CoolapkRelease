package com.coolapk.market.view.feed.vote;

import android.animation.ValueAnimator;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVoteMultiBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentMultiViewPart;", "Lcom/coolapk/market/view/feed/vote/VoteMultiViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "bindToUserVoteDetail", "", "data", "Lcom/coolapk/market/model/Feed;", "option", "Lcom/coolapk/market/model/VoteOption;", "realTotalSelectNum", "", "showAnimation", "", "showPercent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
public final class VoteCommentMultiViewPart extends VoteMultiViewPart {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteCommentMultiViewPart(DataBindingComponent dataBindingComponent) {
        super(dataBindingComponent);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public static /* synthetic */ void bindToUserVoteDetail$default(VoteCommentMultiViewPart voteCommentMultiViewPart, Feed feed, VoteOption voteOption, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z2 = i > 0;
        }
        voteCommentMultiViewPart.bindToUserVoteDetail(feed, voteOption, i, z, z2);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00e6: INVOKE  (r9v1 int) = (r18v0 com.coolapk.market.model.VoteOption) type: VIRTUAL call: com.coolapk.market.model.VoteOption.getTotalSelectNum():int), (31080 char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v1 int), ('%' char)] */
    public final void bindToUserVoteDetail(Feed feed, VoteOption voteOption, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(voteOption, "option");
        ((ItemFeedVoteMultiBinding) getBinding()).executePendingBindings();
        int dp = NumberExtendsKt.getDp((Number) 1);
        int adjustAlpha = ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorAccent(), 0.2f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(dp, adjustAlpha);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 3));
        gradientDrawable.setShape(0);
        int i2 = 100;
        if (z2) {
            i2 = MathKt.roundToInt(((float) (voteOption.getTotalSelectNum() * 100)) / ((float) i));
        }
        if (!z2) {
            adjustAlpha = AppHolder.getAppTheme().getContentBackgroundColor();
        }
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(adjustAlpha), 8388611, 1);
        clipDrawable.setLevel(i2 * 100);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, gradientDrawable});
        layerDrawable.setLayerInset(0, dp, dp, dp, dp);
        LinearLayout linearLayout = ((ItemFeedVoteMultiBinding) getBinding()).rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.rootView");
        linearLayout.setBackground(layerDrawable);
        TextView textView = ((ItemFeedVoteMultiBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(voteOption.getTitle());
        ImageView imageView = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.checkView");
        imageView.setVisibility(0);
        if (z2) {
            TextView textView2 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.totalVoteNumView");
            StringBuilder sb = new StringBuilder();
            sb.append(voteOption.getTotalSelectNum());
            sb.append((char) 31080);
            textView2.setText(sb.toString());
            TextView textView3 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.percentView");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            sb2.append('%');
            textView3.setText(sb2.toString());
            TextView textView4 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.totalVoteNumView");
            textView4.setVisibility(0);
            TextView textView5 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.percentView");
            textView5.setVisibility(0);
        } else {
            TextView textView6 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.totalVoteNumView");
            textView6.setVisibility(8);
            TextView textView7 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.percentView");
            textView7.setVisibility(8);
        }
        if (z && z2) {
            VoteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1 voteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1 = new VoteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1(this, clipDrawable, ((float) voteOption.getTotalSelectNum()) / ((float) i), layerDrawable, voteOption);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new VoteCommentMultiViewPart$bindToUserVoteDetail$$inlined$apply$lambda$1(voteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1));
            valueAnimator.setDuration(1200L);
            valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimator.start();
            voteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1.invoke((VoteCommentMultiViewPart$bindToUserVoteDetail$setAnimateFraction$1) Float.valueOf(0.0f));
        }
        checkLayoutStyle();
    }
}
