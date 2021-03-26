package com.coolapk.market.view.base;

import android.graphics.Rect;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "inset", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlphaToolbarActivity.kt */
final class AlphaToolbarActivity$onCreate$3 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ AlphaToolbarActivity this$0;

    AlphaToolbarActivity$onCreate$3(AlphaToolbarActivity alphaToolbarActivity) {
        this.this$0 = alphaToolbarActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        this.this$0.getBinding().appBar.setPadding(0, rect.top, 0, 0);
        this.this$0.bottom = rect.bottom;
        this.this$0.setRect(rect);
    }
}
