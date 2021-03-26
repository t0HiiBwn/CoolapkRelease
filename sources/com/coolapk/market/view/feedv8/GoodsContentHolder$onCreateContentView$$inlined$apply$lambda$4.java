package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/coolapk/market/view/feedv8/GoodsContentHolder$onCreateContentView$1$4"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$4 implements View.OnFocusChangeListener {
    final /* synthetic */ GoodsContentHolder this$0;

    GoodsContentHolder$onCreateContentView$$inlined$apply$lambda$4(GoodsContentHolder goodsContentHolder) {
        this.this$0 = goodsContentHolder;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        FeedUIConfig uiConfig = this.this$0.getUiConfig();
        if (!uiConfig.isMenuItemEnabled() && z) {
            GoodsContentHolder goodsContentHolder = this.this$0;
            FeedUIConfig build = FeedUIConfig.builder(uiConfig).isMenuItemEnabled(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
            goodsContentHolder.updateUiConfig$presentation_coolapkAppRelease(build);
        }
    }
}
