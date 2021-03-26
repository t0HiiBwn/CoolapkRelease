package com.coolapk.market.view.userv9;

import android.animation.FloatEvaluator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p0", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "verticalOffset", "", "onOffsetChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
final class UserSpaceV9Activity$setupHeaderView$5 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ FloatEvaluator $floatEvaluator;
    final /* synthetic */ UserSpaceV9Activity this$0;

    UserSpaceV9Activity$setupHeaderView$5(UserSpaceV9Activity userSpaceV9Activity, FloatEvaluator floatEvaluator) {
        this.this$0 = userSpaceV9Activity;
        this.$floatEvaluator = floatEvaluator;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        AppBarLayout appBarLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0).appBar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout2, "binding.appBar");
        float abs = ((float) Math.abs(i)) / ((float) appBarLayout2.getTotalScrollRange());
        LinearLayout linearLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).actionViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionViewContainer");
        FloatEvaluator floatEvaluator = this.$floatEvaluator;
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Float evaluate = floatEvaluator.evaluate(abs, (Number) valueOf, (Number) valueOf2);
        Intrinsics.checkNotNullExpressionValue(evaluate, "floatEvaluator.evaluate(ratio, 1f, 0f)");
        linearLayout.setAlpha(evaluate.floatValue());
        FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).logoViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.logoViewContainer");
        Float evaluate2 = this.$floatEvaluator.evaluate(abs, (Number) valueOf, (Number) valueOf2);
        Intrinsics.checkNotNullExpressionValue(evaluate2, "floatEvaluator.evaluate(ratio, 1f, 0f)");
        frameLayout.setAlpha(evaluate2.floatValue());
        FrameLayout frameLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0).infoViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.infoViewContainer");
        Float evaluate3 = this.$floatEvaluator.evaluate(abs, (Number) valueOf, (Number) valueOf2);
        Intrinsics.checkNotNullExpressionValue(evaluate3, "floatEvaluator.evaluate(ratio, 1f, 0f)");
        frameLayout2.setAlpha(evaluate3.floatValue());
        IgnoreInsetFrameLayout ignoreInsetFrameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).tabContainer;
        Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.tabContainer");
        ignoreInsetFrameLayout.setTranslationY((float) i);
    }
}
