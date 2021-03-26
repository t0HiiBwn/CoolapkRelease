package com.coolapk.market.view.live;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$onCreate$1 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ LiveActivity this$0;

    LiveActivity$onCreate$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        if (rect.bottom > UiUtils.getNavigationBarHeight(this.this$0) * 2) {
            LiveActivity.access$getLiveVideoViewPart$p(this.this$0).offsetBottomContainerWithSoftHeight(rect.bottom);
        } else {
            LiveActivity.access$getLiveVideoViewPart$p(this.this$0).offsetBottomContainerWithSoftHeight(0);
        }
        Toolbar toolbar = LiveActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        Toolbar toolbar2 = toolbar;
        ViewGroup.LayoutParams layoutParams = toolbar2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = rect.top;
        toolbar2.setLayoutParams(marginLayoutParams);
    }
}
