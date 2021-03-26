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
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.ItemFeedVoteMultiBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0014¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteDetailMultiViewPart;", "Lcom/coolapk/market/view/feed/vote/VoteMultiViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "bindToDetail", "", "option", "Lcom/coolapk/market/model/VoteOption;", "realTotalSelectNum", "", "isVoted", "", "voteId", "", "showAnimation", "bindToUnvoted", "isChecked", "onCheckListener", "Lkotlin/Function2;", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
public final class VoteDetailMultiViewPart extends VoteMultiViewPart {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteDetailMultiViewPart(DataBindingComponent dataBindingComponent) {
        super(dataBindingComponent);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0133: INVOKE  (r11v1 int) = (r17v0 com.coolapk.market.model.VoteOption) type: VIRTUAL call: com.coolapk.market.model.VoteOption.getTotalSelectNum():int), (31080 char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r14v0 int), ('%' char)] */
    public final void bindToDetail(VoteOption voteOption, int i, boolean z, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(voteOption, "option");
        Intrinsics.checkNotNullParameter(str, "voteId");
        ((ItemFeedVoteMultiBinding) getBinding()).executePendingBindings();
        int dp = NumberExtendsKt.getDp((Number) 1);
        int adjustAlpha = ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorAccent(), 0.2f);
        int adjustAlpha2 = ColorUtils.adjustAlpha(ResourceUtils.getColorInt(getContext(), 2131099893), 0.2f);
        if (!z) {
            adjustAlpha = adjustAlpha2;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(dp, adjustAlpha);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 3));
        gradientDrawable.setShape(0);
        boolean z3 = i >= 0;
        int roundToInt = z3 ? MathKt.roundToInt(((float) (voteOption.getTotalSelectNum() * 100)) / ((float) i)) : 100;
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(adjustAlpha), 8388611, 1);
        clipDrawable.setLevel(roundToInt * 100);
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
        AppTheme appTheme = AppHolder.getAppTheme();
        int colorAccent = z ? appTheme.getColorAccent() : appTheme.getTextColorPrimary();
        ((ItemFeedVoteMultiBinding) getBinding()).titleView.setTextColor(colorAccent);
        if (z) {
            ImageView imageView2 = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.checkView");
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.checkView");
            imageView3.setVisibility(8);
        }
        if (z3) {
            TextView textView2 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.totalVoteNumView");
            StringBuilder sb = new StringBuilder();
            sb.append(voteOption.getTotalSelectNum());
            sb.append((char) 31080);
            textView2.setText(sb.toString());
            TextView textView3 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.percentView");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(roundToInt);
            sb2.append('%');
            textView3.setText(sb2.toString());
            TextView textView4 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.totalVoteNumView");
            textView4.setVisibility(0);
            TextView textView5 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.percentView");
            textView5.setVisibility(0);
            if (!z) {
                colorAccent = AppHolder.getAppTheme().getTextColorSecondary();
            }
            ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView.setTextColor(colorAccent);
            ((ItemFeedVoteMultiBinding) getBinding()).percentView.setTextColor(colorAccent);
        } else {
            TextView textView6 = ((ItemFeedVoteMultiBinding) getBinding()).totalVoteNumView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.totalVoteNumView");
            textView6.setVisibility(8);
            TextView textView7 = ((ItemFeedVoteMultiBinding) getBinding()).percentView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.percentView");
            textView7.setVisibility(8);
            ((ItemFeedVoteMultiBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            ImageView imageView4 = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.checkView");
            imageView4.setVisibility(8);
        }
        ImageView imageView5 = ((ItemFeedVoteMultiBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.checkBox");
        imageView5.setVisibility(8);
        ((ItemFeedVoteMultiBinding) getBinding()).getRoot().setOnClickListener(new VoteDetailMultiViewPart$bindToDetail$1(this, str, voteOption));
        if (z2 && z3) {
            VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1 voteDetailMultiViewPart$bindToDetail$setAnimateFraction$1 = new VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1(this, clipDrawable, ((float) voteOption.getTotalSelectNum()) / ((float) i), layerDrawable, voteOption);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new VoteDetailMultiViewPart$bindToDetail$$inlined$apply$lambda$1(voteDetailMultiViewPart$bindToDetail$setAnimateFraction$1));
            valueAnimator.setDuration(1200L);
            valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimator.start();
            voteDetailMultiViewPart$bindToDetail$setAnimateFraction$1.invoke((VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1) Float.valueOf(0.0f));
        }
        checkLayoutStyle();
    }

    @Override // com.coolapk.market.view.feed.vote.VoteMultiViewPart, com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
    }

    public final void bindToUnvoted(VoteOption voteOption, boolean z, Function2<? super String, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(voteOption, "option");
        Intrinsics.checkNotNullParameter(function2, "onCheckListener");
        ((ItemFeedVoteMultiBinding) getBinding()).executePendingBindings();
        int dp = NumberExtendsKt.getDp((Number) 1);
        int adjustAlpha = ColorUtils.adjustAlpha(ResourceUtils.getColorInt(getContext(), 2131099893), 0.2f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(dp, adjustAlpha);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 3));
        gradientDrawable.setShape(0);
        if (z) {
            ImageView imageView = ((ItemFeedVoteMultiBinding) getBinding()).checkBox;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.checkBox");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(AppHolder.getAppTheme().getColorAccent());
            gradientDrawable2.setShape(1);
            Unit unit = Unit.INSTANCE;
            imageView.setBackground(gradientDrawable2);
            ((ItemFeedVoteMultiBinding) getBinding()).checkBox.setImageResource(2131231178);
        } else {
            ImageView imageView2 = ((ItemFeedVoteMultiBinding) getBinding()).checkBox;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.checkBox");
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setStroke(dp, adjustAlpha);
            gradientDrawable3.setShape(1);
            Unit unit2 = Unit.INSTANCE;
            imageView2.setBackground(gradientDrawable3);
            ((ItemFeedVoteMultiBinding) getBinding()).checkBox.setImageDrawable(null);
        }
        ((ItemFeedVoteMultiBinding) getBinding()).getRoot().setOnClickListener(new VoteDetailMultiViewPart$bindToUnvoted$3(this, function2, voteOption, z));
        LinearLayout linearLayout = ((ItemFeedVoteMultiBinding) getBinding()).rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.rootView");
        linearLayout.setBackground(gradientDrawable);
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
        ImageView imageView3 = ((ItemFeedVoteMultiBinding) getBinding()).checkView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.checkView");
        imageView3.setVisibility(8);
        ImageView imageView4 = ((ItemFeedVoteMultiBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.checkBox");
        imageView4.setVisibility(0);
        checkLayoutStyle();
    }
}
