package com.coolapk.market.view.userv9;

import android.animation.FloatEvaluator;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"com/coolapk/market/view/userv9/UserSpaceV9Activity$setupHeaderView$3", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "blackColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getBlackColorDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "endAlpha", "", "getEndAlpha", "()F", "startAlpha", "getStartAlpha", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity$setupHeaderView$3 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ FloatEvaluator $floatEvaluator;
    private final ColorDrawable blackColorDrawable;
    private final float endAlpha = 0.8f;
    private final float startAlpha = 0.4f;
    final /* synthetic */ UserSpaceV9Activity this$0;

    UserSpaceV9Activity$setupHeaderView$3(UserSpaceV9Activity userSpaceV9Activity, FloatEvaluator floatEvaluator) {
        this.this$0 = userSpaceV9Activity;
        this.$floatEvaluator = floatEvaluator;
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        this.blackColorDrawable = colorDrawable;
        colorDrawable.setAlpha((int) (0.4f * ((float) 255)));
        FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(userSpaceV9Activity).backgroundViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.backgroundViewContainer");
        frameLayout.setForeground(colorDrawable);
    }

    public final ColorDrawable getBlackColorDrawable() {
        return this.blackColorDrawable;
    }

    public final float getStartAlpha() {
        return this.startAlpha;
    }

    public final float getEndAlpha() {
        return this.endAlpha;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        Toolbar toolbar = UserSpaceV9Activity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        float f = -((float) i);
        toolbar.setTranslationY(f);
        ImageView imageView = UserSpaceV9Activity.access$getBinding$p(this.this$0).backgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backgroundView");
        imageView.setTranslationY(f / ((float) 2));
        AppBarLayout appBarLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0).appBar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout2, "binding.appBar");
        this.blackColorDrawable.setAlpha((int) (this.$floatEvaluator.evaluate(((float) Math.abs(i)) / ((float) appBarLayout2.getTotalScrollRange()), (Number) Float.valueOf(this.startAlpha), (Number) Float.valueOf(this.endAlpha)).floatValue() * ((float) 255)));
        FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).backgroundViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.backgroundViewContainer");
        frameLayout.setForeground(this.blackColorDrawable);
    }
}
