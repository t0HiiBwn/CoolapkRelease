package com.coolapk.market.view.feedv8;

import android.graphics.Rect;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "rect", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$onCreate$2 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$onCreate$2(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        if (rect.bottom >= NumberExtendsKt.getDp((Number) 40)) {
            ThemeUtils.setNavigationBarColor(this.this$0.getActivity(), 1711276032);
        }
    }
}
