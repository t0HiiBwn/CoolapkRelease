package com.coolapk.market.view.live;

import android.view.View;
import com.coolapk.market.view.live.LiveUnreadMessageHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveUnreadMessageHelper.kt */
final class LiveUnreadMessageHelper$onLiveMessageCardLoaded$2 implements View.OnClickListener {
    final /* synthetic */ int $num;
    final /* synthetic */ LiveUnreadMessageHelper this$0;

    LiveUnreadMessageHelper$onLiveMessageCardLoaded$2(LiveUnreadMessageHelper liveUnreadMessageHelper, int i) {
        this.this$0 = liveUnreadMessageHelper;
        this.$num = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LiveUnreadMessageHelper.access$getFloatView$p(this.this$0).setVisibility(8);
        LiveUnreadMessageHelper.Callback callback = this.this$0.getCallback();
        if (callback != null) {
            Intrinsics.checkNotNullExpressionValue(view, "v");
            callback.onFloatViewClick(view, this.$num);
        }
    }
}
