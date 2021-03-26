package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.percentlayout.widget.PercentFrameLayout;
import com.coolapk.market.databinding.ItemRatingCardBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.product.ProductGlobalData;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/viewholder/BaseRatingCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "voteNumMax", "", "bindTo", "", "data", "", "getRateNumMax", "rateNums", "", "getRatePercent", "", "rateNum", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingCardViewHolder.kt */
public class BaseRatingCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558889;
    private static final float MIN_PERCENT = 0.01f;
    private int voteNumMax;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRatingCardViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/BaseRatingCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "MIN_PERCENT", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RatingCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        ItemRatingCardBinding itemRatingCardBinding = (ItemRatingCardBinding) getBinding();
        EntityCard entityCard = (EntityCard) obj;
        int intExtraData = EntityExtendsKt.getIntExtraData(entityCard, "rate_num1", 0);
        int intExtraData2 = EntityExtendsKt.getIntExtraData(entityCard, "rate_num2", 0);
        int intExtraData3 = EntityExtendsKt.getIntExtraData(entityCard, "rate_num3", 0);
        int intExtraData4 = EntityExtendsKt.getIntExtraData(entityCard, "rate_num4", 0);
        int intExtraData5 = EntityExtendsKt.getIntExtraData(entityCard, "rate_num5", 0);
        float parseFloat = Float.parseFloat(EntityExtendsKt.getStringExtraData(entityCard, "score", "0"));
        TextView textView = itemRatingCardBinding.scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setText(KotlinExtendKt.toDisplayScore(parseFloat));
        TextView textView2 = itemRatingCardBinding.scoreView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.scoreView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context));
        RatingBar ratingBar = itemRatingCardBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(parseFloat));
        TextView textView3 = itemRatingCardBinding.ratingCountView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.ratingCountView");
        textView3.setText(EntityExtendsKt.getStringExtraData(entityCard, "rating_count", "0") + "人点评");
        TextView textView4 = itemRatingCardBinding.rateNum1;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.rateNum1");
        textView4.setText(String.valueOf(intExtraData));
        TextView textView5 = itemRatingCardBinding.rateNum2;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.rateNum2");
        textView5.setText(String.valueOf(intExtraData2));
        TextView textView6 = itemRatingCardBinding.rateNum3;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.rateNum3");
        textView6.setText(String.valueOf(intExtraData3));
        TextView textView7 = itemRatingCardBinding.rateNum4;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.rateNum4");
        textView7.setText(String.valueOf(intExtraData4));
        TextView textView8 = itemRatingCardBinding.rateNum5;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.rateNum5");
        textView8.setText(String.valueOf(intExtraData5));
        this.voteNumMax = getRateNumMax(new int[]{intExtraData, intExtraData2, intExtraData3, intExtraData4, intExtraData5});
        ImageView imageView = itemRatingCardBinding.ratingImageView1;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ratingImageView1");
        ImageView imageView2 = imageView;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams2 = (PercentFrameLayout.LayoutParams) layoutParams;
        layoutParams2.getPercentLayoutInfo().widthPercent = getRatePercent(intExtraData);
        imageView2.setLayoutParams(layoutParams2);
        ImageView imageView3 = itemRatingCardBinding.ratingImageView2;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ratingImageView2");
        ImageView imageView4 = imageView3;
        ViewGroup.LayoutParams layoutParams3 = imageView4.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams4 = (PercentFrameLayout.LayoutParams) layoutParams3;
        layoutParams4.getPercentLayoutInfo().widthPercent = getRatePercent(intExtraData2);
        imageView4.setLayoutParams(layoutParams4);
        ImageView imageView5 = itemRatingCardBinding.ratingImageView3;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ratingImageView3");
        ImageView imageView6 = imageView5;
        ViewGroup.LayoutParams layoutParams5 = imageView6.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams6 = (PercentFrameLayout.LayoutParams) layoutParams5;
        layoutParams6.getPercentLayoutInfo().widthPercent = getRatePercent(intExtraData3);
        imageView6.setLayoutParams(layoutParams6);
        ImageView imageView7 = itemRatingCardBinding.ratingImageView4;
        Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ratingImageView4");
        ImageView imageView8 = imageView7;
        ViewGroup.LayoutParams layoutParams7 = imageView8.getLayoutParams();
        Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams8 = (PercentFrameLayout.LayoutParams) layoutParams7;
        layoutParams8.getPercentLayoutInfo().widthPercent = getRatePercent(intExtraData4);
        imageView8.setLayoutParams(layoutParams8);
        ImageView imageView9 = itemRatingCardBinding.ratingImageView5;
        Intrinsics.checkNotNullExpressionValue(imageView9, "binding.ratingImageView5");
        ImageView imageView10 = imageView9;
        ViewGroup.LayoutParams layoutParams9 = imageView10.getLayoutParams();
        Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams10 = (PercentFrameLayout.LayoutParams) layoutParams9;
        layoutParams10.getPercentLayoutInfo().widthPercent = getRatePercent(intExtraData5);
        imageView10.setLayoutParams(layoutParams10);
        itemRatingCardBinding.executePendingBindings();
    }

    private final int getRateNumMax(int[] iArr) {
        Arrays.sort(iArr);
        return Math.max(0, iArr[iArr.length - 1]);
    }

    private final float getRatePercent(int i) {
        return Math.max(0.01f, (((float) i) * 1.0f) / ((float) this.voteNumMax));
    }
}
