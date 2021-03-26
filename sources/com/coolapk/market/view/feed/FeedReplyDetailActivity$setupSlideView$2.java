package com.coolapk.market.view.feed;

import android.graphics.drawable.GradientDrawable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.AnimationUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"com/coolapk/market/view/feed/FeedReplyDetailActivity$setupSlideView$2", "Lcom/coolapk/market/widget/view/SlideUpView$Callback;", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "noRadius", "", "radius", "", "getRadius", "()F", "topRadius", "usingArray", "onDismiss", "", "onShow", "onTranslateYChange", "y", "", "usingRadiusArray", "target", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailActivity.kt */
public final class FeedReplyDetailActivity$setupSlideView$2 implements SlideUpView.Callback {
    private final GradientDrawable gradientDrawable;
    private final float[] noRadius = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private final float radius;
    final /* synthetic */ FeedReplyDetailActivity this$0;
    private final float[] topRadius;
    private float[] usingArray;

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onShow() {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedReplyDetailActivity$setupSlideView$2(FeedReplyDetailActivity feedReplyDetailActivity) {
        this.this$0 = feedReplyDetailActivity;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        this.gradientDrawable = gradientDrawable2;
        float dp = (float) NumberExtendsKt.getDp((Number) 12);
        this.radius = dp;
        this.topRadius = new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f};
        SlideUpView slideUpView = FeedReplyDetailActivity.access$getBinding$p(feedReplyDetailActivity).slideUpView;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.slideUpView");
        slideUpView.setBackground(gradientDrawable2);
    }

    public final float getRadius() {
        return this.radius;
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onTranslateYChange(int i) {
        if (i != 0) {
            ThemeUtils.setTranslucentStatusBar(this.this$0.getActivity());
            SlideUpView slideUpView = FeedReplyDetailActivity.access$getBinding$p(this.this$0).slideUpView;
            Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.slideUpView");
            FeedReplyDetailActivity.access$getBinding$p(this.this$0).mainContent.setBackgroundColor(AnimationUtils.calculateColor(((float) i) / ((float) slideUpView.getHeight()), -1728053248, 0));
            this.this$0.setSlidrEnable(false);
            usingRadiusArray(this.topRadius);
            return;
        }
        ThemeUtils.setStatusBarColor(this.this$0.getActivity(), ThemeUtils.getStatusBarColor());
        this.this$0.setSlidrEnable(true);
        usingRadiusArray(this.noRadius);
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onDismiss() {
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
    }

    private final void usingRadiusArray(float[] fArr) {
        if (this.usingArray != fArr) {
            this.usingArray = fArr;
            this.gradientDrawable.setCornerRadii(fArr);
            this.gradientDrawable.invalidateSelf();
        }
    }
}
