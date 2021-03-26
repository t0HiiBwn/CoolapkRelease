package com.coolapk.market.view.live;

import android.graphics.Rect;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "insets", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$initUI$1 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ LiveActivity this$0;

    LiveActivity$initUI$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        this.this$0.applyWindowsInset(new Rect(rect));
        LiveActivity.access$getBinding$p(this.this$0).postView.setPadding(0, 0, 0, rect.bottom);
    }
}
