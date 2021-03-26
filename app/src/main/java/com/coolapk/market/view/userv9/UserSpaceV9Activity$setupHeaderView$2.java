package com.coolapk.market.view.userv9;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
final class UserSpaceV9Activity$setupHeaderView$2 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ int $actionBar;
    final /* synthetic */ UserSpaceV9Activity this$0;

    UserSpaceV9Activity$setupHeaderView$2(UserSpaceV9Activity userSpaceV9Activity, int i) {
        this.this$0 = userSpaceV9Activity;
        this.$actionBar = i;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        int i = rect.top;
        IgnoreInsetFrameLayout ignoreInsetFrameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).appBarHolder;
        Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.appBarHolder");
        ignoreInsetFrameLayout.setMinimumHeight(this.$actionBar + NumberExtendsKt.getDp((Number) 48) + i);
        UserSpaceV9Activity.access$getBinding$p(this.this$0).appBar.requestLayout();
        Toolbar toolbar = UserSpaceV9Activity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(toolbar);
        if (marginParams != null) {
            marginParams.topMargin = i;
        }
        UserSpaceV9Activity.access$getBinding$p(this.this$0).toolbar.requestLayout();
        LinearLayout linearLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userToolbar.toolbarActionContainer");
        ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(linearLayout);
        if (marginParams2 != null) {
            marginParams2.topMargin = i;
        }
        UserSpaceV9Activity.access$getBinding$p(this.this$0).userToolbar.toolbarActionContainer.requestLayout();
        Space space = UserSpaceV9Activity.access$getBinding$p(this.this$0).spaceHolder;
        Intrinsics.checkNotNullExpressionValue(space, "binding.spaceHolder");
        ViewGroup.MarginLayoutParams marginParams3 = ViewExtendsKt.getMarginParams(space);
        if (marginParams3 != null) {
            marginParams3.height = i;
        }
        UserSpaceV9Activity.access$getBinding$p(this.this$0).spaceHolder.requestLayout();
        FrameLayout frameLayout = UserSpaceV9Activity.access$getBinding$p(this.this$0).refreshView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.refreshView");
        ViewGroup.MarginLayoutParams marginParams4 = ViewExtendsKt.getMarginParams(frameLayout);
        if (marginParams4 != null) {
            marginParams4.topMargin = i;
        }
        UserSpaceV9Activity.access$getBinding$p(this.this$0).refreshView.requestLayout();
    }
}
