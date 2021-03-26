package com.coolapk.market.view.goods.detail;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.databinding.UserToolbarBinding;
import com.coolapk.market.widget.ViewVisibilityController;
import com.coolapk.market.widget.view.AlphableAppBarLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/coolapk/market/view/goods/detail/GoodsDetailActivity$setupHeaderViews$1", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "controller", "Lcom/coolapk/market/widget/ViewVisibilityController;", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
public final class GoodsDetailActivity$setupHeaderViews$1 implements AppBarLayout.OnOffsetChangedListener {
    private final ViewVisibilityController controller;
    final /* synthetic */ GoodsDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    GoodsDetailActivity$setupHeaderViews$1(GoodsDetailActivity goodsDetailActivity) {
        this.this$0 = goodsDetailActivity;
        UserToolbarBinding userToolbarBinding = GoodsDetailActivity.access$getBinding$p(goodsDetailActivity).userToolbar;
        Intrinsics.checkNotNullExpressionValue(userToolbarBinding, "binding.userToolbar");
        View root = userToolbarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.userToolbar.root");
        this.controller = new ViewVisibilityController(root, null, null, 0, 14, null);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Toolbar toolbar = GoodsDetailActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        float f = -((float) i);
        toolbar.setTranslationY(f);
        UserToolbarBinding userToolbarBinding = GoodsDetailActivity.access$getBinding$p(this.this$0).userToolbar;
        Intrinsics.checkNotNullExpressionValue(userToolbarBinding, "binding.userToolbar");
        View root = userToolbarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.userToolbar.root");
        root.setTranslationY(f);
        AlphableAppBarLayout alphableAppBarLayout = GoodsDetailActivity.access$getBinding$p(this.this$0).appBar;
        Intrinsics.checkNotNullExpressionValue(alphableAppBarLayout, "binding.appBar");
        float abs = ((float) 1) - (((float) Math.abs(i)) / ((float) alphableAppBarLayout.getTotalScrollRange()));
        if (abs == 0.0f) {
            this.controller.requestVisible(true);
        } else {
            this.controller.requestVisible(false);
        }
        LinearLayout linearLayout = GoodsDetailActivity.access$getBinding$p(this.this$0).actionView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionView");
        linearLayout.setAlpha(abs);
        LinearLayout linearLayout2 = GoodsDetailActivity.access$getBinding$p(this.this$0).headerContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.headerContainer");
        linearLayout2.setAlpha(abs);
    }
}
