package com.coolapk.market.view.goods.detail;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.databinding.UserToolbarBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
final class GoodsDetailActivity$onCreate$5 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ GoodsDetailActivity this$0;

    GoodsDetailActivity$onCreate$5(GoodsDetailActivity goodsDetailActivity) {
        this.this$0 = goodsDetailActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        Toolbar toolbar = GoodsDetailActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        Toolbar toolbar2 = toolbar;
        ViewGroup.LayoutParams layoutParams = toolbar2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = rect.top;
        toolbar2.setLayoutParams(marginLayoutParams);
        UserToolbarBinding userToolbarBinding = GoodsDetailActivity.access$getBinding$p(this.this$0).userToolbar;
        Intrinsics.checkNotNullExpressionValue(userToolbarBinding, "binding.userToolbar");
        View root = userToolbarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.userToolbar.root");
        ViewGroup.LayoutParams layoutParams2 = root.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.topMargin = rect.top;
        root.setLayoutParams(marginLayoutParams2);
        Space space = GoodsDetailActivity.access$getBinding$p(this.this$0).spaceHolder;
        Intrinsics.checkNotNullExpressionValue(space, "binding.spaceHolder");
        space.getLayoutParams().height = rect.top + UiUtils.getActionBarSize(this.this$0.getActivity());
        GoodsDetailActivity.access$getBinding$p(this.this$0).spaceHolder.requestLayout();
        IgnoreInsetFrameLayout ignoreInsetFrameLayout = GoodsDetailActivity.access$getBinding$p(this.this$0).tabContainer;
        Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.tabContainer");
        ignoreInsetFrameLayout.setMinimumHeight(UiUtils.getActionBarSize(this.this$0.getActivity()) + NumberExtendsKt.getDp((Number) 48) + rect.top);
        GoodsDetailActivity.access$getBinding$p(this.this$0).tabContainer.requestLayout();
    }
}
