package com.coolapk.market.view.userv9;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $this_doOnNextPreDraw;
    final /* synthetic */ UserSpaceV9Activity this$0;

    public UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1(View view, UserSpaceV9Activity userSpaceV9Activity) {
        this.$this_doOnNextPreDraw = view;
        this.this$0 = userSpaceV9Activity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.updateContainerHeight();
        AppBarLayout appBarLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).appBar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
        ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
        UserSpaceAppBarBehavior userSpaceAppBarBehavior = null;
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            layoutParams = null;
        }
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        Intrinsics.checkNotNull(layoutParams2);
        UserSpaceV9Activity userSpaceV9Activity = this.this$0;
        CoordinatorLayout.Behavior behavior = layoutParams2.getBehavior();
        if (behavior instanceof UserSpaceAppBarBehavior) {
            userSpaceAppBarBehavior = behavior;
        }
        UserSpaceAppBarBehavior userSpaceAppBarBehavior2 = userSpaceAppBarBehavior;
        Intrinsics.checkNotNull(userSpaceAppBarBehavior2);
        userSpaceV9Activity.behavior = userSpaceAppBarBehavior2;
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        int measuredHeight = (int) (((double) drawSystemBarFrameLayout.getMeasuredHeight()) * 0.2d);
        DrawSystemBarFrameLayout drawSystemBarFrameLayout2 = UserSpaceV9Activity.access$getBinding$p(this.this$0).mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout2, "binding.mainContent");
        int measuredHeight2 = (int) (((double) drawSystemBarFrameLayout2.getMeasuredHeight()) * 0.03d);
        DrawSystemBarFrameLayout drawSystemBarFrameLayout3 = UserSpaceV9Activity.access$getBinding$p(this.this$0).mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout3, "binding.mainContent");
        int measuredHeight3 = (int) (((double) drawSystemBarFrameLayout3.getMeasuredHeight()) * 0.16d);
        UserSpaceAppBarBehavior userSpaceAppBarBehavior3 = this.this$0.behavior;
        if (userSpaceAppBarBehavior3 == null) {
            return false;
        }
        userSpaceAppBarBehavior3.setCallback(new UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1$lambda$1(measuredHeight, measuredHeight3, measuredHeight2, this));
        return false;
    }
}
